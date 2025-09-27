package ru.spb.tksoft.chains.project.service;

import ru.spb.tksoft.chains.project.dto.request.CreateProjectRequestDto;
import ru.spb.tksoft.chains.project.dto.request.DeleteProjectRequestDto;
import ru.spb.tksoft.chains.project.dto.request.GetProjectListRequestDto;
import ru.spb.tksoft.chains.project.dto.request.GetProjectRequestDto;
import ru.spb.tksoft.chains.project.dto.request.UpdateProjectRequestDto;
import ru.spb.tksoft.chains.project.dto.request.ProjectBlockRequestDto;
import ru.spb.tksoft.chains.project.dto.request.ProjectLineRequestDto;
import ru.spb.tksoft.chains.project.dto.response.CreateProjectResponseDto;
import ru.spb.tksoft.chains.project.dto.response.DeleteProjectResponseDto;
import ru.spb.tksoft.chains.project.dto.response.ProjectListResponseDto;
import ru.spb.tksoft.chains.project.dto.response.ProjectResponseDto;
import ru.spb.tksoft.chains.project.dto.response.UpdateProjectResponseDto;
import ru.spb.tksoft.chains.project.dto.response.ProjectBlockResponseDto;
import ru.spb.tksoft.chains.project.dto.response.ProjectLineResponseDto;
import ru.spb.tksoft.chains.project.dto.response.ProjectListItemResponseDto;
import ru.spb.tksoft.chains.project.entity.Project;
import ru.spb.tksoft.chains.project.entity.ProjectBlock;
import ru.spb.tksoft.chains.project.entity.ProjectLine;
import ru.spb.tksoft.chains.project.enumeration.ProjectStatus;
import ru.spb.tksoft.chains.project.repository.ProjectRepository;
import ru.spb.tksoft.chains.project.repository.ProjectBlockRepository;
import ru.spb.tksoft.chains.project.repository.ProjectLineRepository;
import ru.spb.tksoft.utils.log.LogEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Projects service.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Service
@RequiredArgsConstructor
public class ProjectService {

    private final Logger log = LoggerFactory.getLogger(ProjectService.class);

    private final ProjectRepository projectRepository;

    private final ProjectBlockRepository projectBlockRepository;

    private final ProjectLineRepository projectLineRepository;

    /**
     * Create new project
     * 
     * @param createProjectRequest - request DTO
     * @return - response DTO
     */
    @Transactional
    public CreateProjectResponseDto createProject(
            final CreateProjectRequestDto createProjectRequest) {

        LogEx.trace(log, LogEx.me(), LogEx.STARTING);

        // Create project entity
        Project project = new Project();
        project.setOwnerId(createProjectRequest.getUserId());
        project.setName(createProjectRequest.getName());
        project.setStatus(ProjectStatus.EDITING.getValue()); // Default status
        
        // Initialize empty lists for blocks and lines
        project.setBlocks(new ArrayList<>());
        project.setLines(new ArrayList<>());

        // Save project
        Project savedProject = projectRepository.save(project);

        // Save project with blocks and lines
        projectRepository.save(savedProject);

        var dto = new CreateProjectResponseDto();
        dto.setProjectId(savedProject.getProjectId());

        LogEx.trace(log, LogEx.me(), LogEx.STOPPING);
        return dto;
    }

    /**
     * Update existing project.
     * 
     * @param updateProjectRequest - request DTO.
     * @return response DTO.
     */
    @Transactional
    public @NotNull UpdateProjectResponseDto updateProject(
            final @NotNull UpdateProjectRequestDto updateProjectRequest) {

        LogEx.trace(log, LogEx.me(), LogEx.STARTING);

        final UpdateProjectResponseDto dto = new UpdateProjectResponseDto();
        dto.setProjectId(updateProjectRequest.getData().getProjectId());

        // Find existing project
        Optional<Project> projectOpt = projectRepository.findByProjectIdAndOwnerId(
                updateProjectRequest.getData().getProjectId(),
                updateProjectRequest.getUserId());

        if (projectOpt.isPresent()) {
            Project project = projectOpt.get();
            
            // Update project fields
            project.setName(updateProjectRequest.getData().getName());
            project.setStatus(updateProjectRequest.getData().getStatus());

            // Clear existing blocks and lines
            project.getBlocks().clear();
            project.getLines().clear();

            // Add new blocks if provided
            if (updateProjectRequest.getData().getBlocks() != null) {
                for (ProjectBlockRequestDto blockDto : updateProjectRequest.getData().getBlocks()) {
                    ProjectBlock block = new ProjectBlock();
                    block.setProject(project);
                    block.setInternalBlockId(blockDto.getInternalBlockId());
                    block.setBlockTypeId(blockDto.getBlockTypeId());
                    block.setDefaultInputText(blockDto.getDefaultInputText());
                    project.addBlock(block);
                }
            }

            // Add new lines if provided
            if (updateProjectRequest.getData().getLines() != null) {
                for (ProjectLineRequestDto lineDto : updateProjectRequest.getData().getLines()) {
                    ProjectLine line = new ProjectLine();
                    line.setProject(project);
                    line.setInternalLineId(lineDto.getInternalLineId());
                    line.setBlockFromInternalId(lineDto.getBlockFromInternalId());
                    line.setBlockToInternalId(lineDto.getBlockToInternalId());
                    project.addLine(line);
                }
            }

            // Save updated project
            projectRepository.save(project);
        }

        LogEx.trace(log, LogEx.me(), LogEx.STOPPING);
        return dto;
    }

    /**
     * Get list of existing projects owned by the user.
     * 
     * @param getProjectListRequest - request DTO.
     * @return response DTO.
     */
    public @NotNull ProjectListResponseDto getProjectList(
            final @NotNull GetProjectListRequestDto getProjectListRequest) {

        LogEx.trace(log, LogEx.me(), LogEx.STARTING);

        // Get projects by owner ID
        List<Project> projects = projectRepository.findByOwnerIdOrderByUpdatedAtDesc(getProjectListRequest.getUserId());

        // Convert to DTOs
        List<ProjectListItemResponseDto> projectItems = new ArrayList<>();
        for (Project project : projects) {
            ProjectListItemResponseDto item = new ProjectListItemResponseDto();
            item.setProjectId(project.getProjectId());
            item.setCreatedAt(project.getCreatedAt());
            item.setUpdatedAt(project.getUpdatedAt());
            item.setOwnerId(project.getOwnerId());
            item.setName(project.getName());
            item.setStatus(project.getStatus());
            projectItems.add(item);
        }

        var dto = new ProjectListResponseDto();
        dto.setItems(projectItems);

        LogEx.trace(log, LogEx.me(), LogEx.STOPPING);
        return dto;
    }

    /**
     * Get existing project.
     * 
     * @param getProjectRequest - request DTO.
     * @return response DTO.
     */
    public @NotNull ProjectResponseDto getProject(
            final @NotNull GetProjectRequestDto getProjectRequest) {

        LogEx.trace(log, LogEx.me(), LogEx.STARTING);

        final ProjectResponseDto dto = new ProjectResponseDto();
        dto.setOwnerId(getProjectRequest.getUserId());
        dto.setProjectId(getProjectRequest.getProjectId());

        // Find project in database
        Optional<Project> projectOpt = projectRepository.findByProjectIdAndOwnerId(
                getProjectRequest.getProjectId(),
                getProjectRequest.getUserId());

        if (projectOpt.isPresent()) {
            Project project = projectOpt.get();
            
            dto.setName(project.getName());
            dto.setCreatedAt(project.getCreatedAt());
            dto.setUpdatedAt(project.getUpdatedAt());
            dto.setStatus(project.getStatus());

            // Convert blocks to DTOs
            List<ProjectBlockResponseDto> blockDtos = new ArrayList<>();
            for (ProjectBlock block : project.getBlocks()) {
                ProjectBlockResponseDto blockDto = new ProjectBlockResponseDto();
                blockDto.setInternalBlockId(block.getInternalBlockId());
                blockDto.setBlockTypeId(block.getBlockTypeId());
                blockDto.setDefaultInputText(block.getDefaultInputText());
                blockDtos.add(blockDto);
            }
            dto.setBlocks(blockDtos);

            // Convert lines to DTOs
            List<ProjectLineResponseDto> lineDtos = new ArrayList<>();
            for (ProjectLine line : project.getLines()) {
                ProjectLineResponseDto lineDto = new ProjectLineResponseDto();
                lineDto.setInternalLineId(line.getInternalLineId());
                lineDto.setBlockFromInternalId(line.getBlockFromInternalId());
                lineDto.setBlockToInternalId(line.getBlockToInternalId());
                lineDtos.add(lineDto);
            }
            dto.setLines(lineDtos);
        } else {
            // Set default values if project not found
            dto.setName("Project not found");
            dto.setCreatedAt(Instant.now());
            dto.setUpdatedAt(Instant.now());
            dto.setStatus(ProjectStatus.UNKNOWN.getValue());
            dto.setBlocks(new ArrayList<>());
            dto.setLines(new ArrayList<>());
        }

        LogEx.trace(log, LogEx.me(), LogEx.STOPPING);
        return dto;
    }

    /**
     * Delete existing project.
     * 
     * @param deleteProjectRequest - request DTO.
     * @return response DTO.
     */
    @Transactional
    public @NotNull DeleteProjectResponseDto deleteProject(
            final DeleteProjectRequestDto deleteProjectRequest) {

        LogEx.trace(log, LogEx.me(), LogEx.STARTING);

        var dto = new DeleteProjectResponseDto();
        dto.setProjectId(deleteProjectRequest.getProjectId());

        // Find and delete project
        Optional<Project> projectOpt = projectRepository.findByProjectIdAndOwnerId(
                deleteProjectRequest.getProjectId(),
                deleteProjectRequest.getUserId());

        if (projectOpt.isPresent()) {
            Project project = projectOpt.get();
            
            // Delete blocks and lines first (cascade should handle this, but being explicit)
            projectBlockRepository.deleteByProjectProjectId(project.getProjectId());
            projectLineRepository.deleteByProjectProjectId(project.getProjectId());
            
            // Delete project
            projectRepository.delete(project);
        }
        
        LogEx.trace(log, LogEx.me(), LogEx.STOPPING);
        return dto;
    }
}
