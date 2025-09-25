package ru.spb.tksoft.aichains.project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import ru.spb.tksoft.aichains.project.dto.request.CreateProjectRequestDto;
import ru.spb.tksoft.aichains.project.dto.request.DeleteProjectRequestDto;
import ru.spb.tksoft.aichains.project.dto.request.GetProjectRequestDto;
import ru.spb.tksoft.aichains.project.dto.request.UpdateProjectRequestDto;
import ru.spb.tksoft.aichains.project.dto.response.CreateProjectResponseDto;
import ru.spb.tksoft.aichains.project.dto.response.ProjectResponseDto;
import ru.spb.tksoft.aichains.project.dto.response.UpdateProjectResponseDto;
import ru.spb.tksoft.utils.log.LogEx;

/**
 * Projects service.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Service
@RequiredArgsConstructor
public class ProjectService {

    private final Logger log = LoggerFactory.getLogger(ProjectService.class);

    /**
     * Create new project.
     * 
     * @param createProjectRequest - request DTO.
     * @return 201/CREATED, 401/Unauthorized.
     */
    public @NotNull CreateProjectResponseDto createProject(
            final @NotNull CreateProjectRequestDto createProjectRequest) {

        LogEx.trace(log, LogEx.getThisMethodName(), LogEx.STARTING);

        final CreateProjectResponseDto dto = new CreateProjectResponseDto();
        dto.setProjectId(123L);

        LogEx.trace(log, LogEx.getThisMethodName(), LogEx.STOPPING);
        return dto;
    }

    /**
     * Get existing project.
     * 
     * @param getProjectRequest - request DTO.
     * @return 200/OK, 401/Unauthorized, 404/Not Found.
     */
    public @NotNull ProjectResponseDto getProject(
            final @NotNull GetProjectRequestDto getProjectRequest) {

        LogEx.trace(log, LogEx.getThisMethodName(), LogEx.STARTING);

        final ProjectResponseDto dto = new ProjectResponseDto();
        dto.setProjectId(123L);

        LogEx.trace(log, LogEx.getThisMethodName(), LogEx.STOPPING);
        return dto;
    }

    /**
     * Update existing project.
     * 
     * @param updateProjectRequest - request DTO.
     * @return 200/OK, 401/Unauthorized, 404/Not Found.
     */
    public @NotNull UpdateProjectResponseDto updateProject(
            final @NotNull UpdateProjectRequestDto updateProjectRequest) {

        LogEx.trace(log, LogEx.getThisMethodName(), LogEx.STARTING);

        final UpdateProjectResponseDto dto = new UpdateProjectResponseDto();
        dto.setTemplateId(123L);

        LogEx.trace(log, LogEx.getThisMethodName(), LogEx.STOPPING);
        return dto;
    }

    /**
     * Delete existing project.
     * 
     * @param deleteProjectRequest - request DTO.
     */
    public void deleteProject(final @NotNull DeleteProjectRequestDto deleteProjectRequest) {

        LogEx.trace(log, LogEx.getThisMethodName(), LogEx.STARTING);

        // ...

        LogEx.trace(log, LogEx.getThisMethodName(), LogEx.STOPPED);
    }

}
