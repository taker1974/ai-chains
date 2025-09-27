package ru.spb.tksoft.chains.project.service;

import ru.spb.tksoft.chains.project.dto.request.CreateProjectRequestDto;
import ru.spb.tksoft.chains.project.dto.request.DeleteProjectRequestDto;
import ru.spb.tksoft.chains.project.dto.request.GetProjectListRequestDto;
import ru.spb.tksoft.chains.project.dto.request.GetProjectRequestDto;
import ru.spb.tksoft.chains.project.dto.request.UpdateProjectRequestDto;
import ru.spb.tksoft.chains.project.dto.response.CreateProjectResponseDto;
import ru.spb.tksoft.chains.project.dto.response.DeleteProjectResponseDto;
import ru.spb.tksoft.chains.project.dto.response.ProjectListResponseDto;
import ru.spb.tksoft.chains.project.dto.response.ProjectResponseDto;
import ru.spb.tksoft.chains.project.dto.response.UpdateProjectResponseDto;
import ru.spb.tksoft.chains.project.enumeration.ProjectStatus;
import ru.spb.tksoft.utils.log.LogEx;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Сервис для обработки и логирования данных пользователя
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Service
public class ProjectService {

    private final Logger log = LoggerFactory.getLogger(ProjectService.class);

    /**
     * Create new project
     * 
     * @param createProjectRequest - request DTO
     * @return - response DTO
     */
    public CreateProjectResponseDto createProject(
            final CreateProjectRequestDto createProjectRequest) {

        LogEx.trace(log, LogEx.me(), LogEx.STARTING);

        var dto = new CreateProjectResponseDto();
        dto.setProjectId(createProjectRequest.getUserId());

        LogEx.trace(log, LogEx.me(), LogEx.STOPPING);
        return dto;
    }

    /**
     * Update existing project.
     * 
     * @param updateProjectRequest - request DTO.
     * @return response DTO.
     */
    public @NotNull UpdateProjectResponseDto updateProject(
            final @NotNull UpdateProjectRequestDto updateProjectRequest) {

        LogEx.trace(log, LogEx.me(), LogEx.STARTING);

        final UpdateProjectResponseDto dto = new UpdateProjectResponseDto();
        dto.setProjectId(updateProjectRequest.getData().getProjectId());

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

        var dto = new ProjectListResponseDto();

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
        dto.setName("other project");
        dto.setCreatedAt(Instant.now());
        dto.setUpdatedAt(Instant.now());
        dto.setStatus(ProjectStatus.EDITING.getValue());

        LogEx.trace(log, LogEx.me(), LogEx.STOPPING);
        return dto;
    }

    /**
     * Delete existing project.
     * 
     * @param deleteProjectRequest - request DTO.
     * @return response DTO.
     */
    public @NotNull DeleteProjectResponseDto deleteProject(
            final DeleteProjectRequestDto deleteProjectRequest) {

        LogEx.trace(log, LogEx.me(), LogEx.STARTING);

        var dto = new DeleteProjectResponseDto();
        dto.setProjectId(deleteProjectRequest.getProjectId());

        LogEx.trace(log, LogEx.me(), LogEx.STOPPING);
        return dto;
    }
}
