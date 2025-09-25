package ru.spb.tksoft.aichains.project.controller;

import lombok.RequiredArgsConstructor;
import ru.spb.tksoft.aichains.project.dto.ProjectDto;
import ru.spb.tksoft.aichains.project.dto.request.CreateProjectRequestDto;
import ru.spb.tksoft.aichains.project.dto.request.DeleteProjectRequestDto;
import ru.spb.tksoft.aichains.project.dto.request.GetProjectRequestDto;
import ru.spb.tksoft.aichains.project.dto.request.UpdateProjectRequestDto;
import ru.spb.tksoft.aichains.project.dto.response.CreateProjectResponseDto;
import ru.spb.tksoft.aichains.project.dto.response.DeleteProjectResponseDto;
import ru.spb.tksoft.aichains.project.dto.response.UpdateProjectResponseDto;
import ru.spb.tksoft.aichains.project.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@Tag(name = "Projects (aka templates)")
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    /**
     * Create new project.
     * 
     * @return response DTO + 201/CREATED || 401/Unauthorized.
     */
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new project")
    @PostMapping("/create")
    @NotNull
    public CreateProjectResponseDto createProject(
            @NotNull @Valid CreateProjectRequestDto createProjectRequest) {

        return projectService.createProject(createProjectRequest);
    }

    /**
     * Get existing project.
     * 
     * @return response DTO + 200/OK || (401/Unauthorized | 404/Not Found).
     */
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get existing project")
    @GetMapping("/get")
    @NotNull
    public ProjectDto getProject(
            @NotNull @Valid GetProjectRequestDto getProjectRequest) {

        return projectService.getProject(getProjectRequest);
    }

    /**
     * Update existing template.
     * 
     * @return response DTO + 200/OK || (401/Unauthorized | 404/Not Found).
     */
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update existing project")
    @PostMapping("/update")
    @NotNull
    public UpdateProjectResponseDto updateProject(
            @NotNull @Valid UpdateProjectRequestDto updateProjectRequest) {

        return projectService.updateProject(updateProjectRequest);
    }

    /**
     * Delete existing template.
     *
     * Returns 204/NO_CONTENT || (401/Unauthorized | 404/Not Found).
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete existing project")
    @PostMapping("/delete")
    @NotNull
    public DeleteProjectResponseDto deleteProject(
            @NotNull @Valid DeleteProjectRequestDto deleteProjectRequest) {

        return projectService.deleteProject(deleteProjectRequest);
    }
}
