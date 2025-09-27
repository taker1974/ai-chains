package ru.spb.tksoft.chains.project.controller;

import ru.spb.tksoft.chains.project.dto.response.CreateProjectResponseDto;
import ru.spb.tksoft.chains.project.dto.response.DeleteProjectResponseDto;
import ru.spb.tksoft.chains.project.dto.response.ProjectListResponseDto;
import ru.spb.tksoft.chains.project.dto.response.ProjectResponseDto;
import ru.spb.tksoft.chains.project.dto.response.UpdateProjectResponseDto;
import ru.spb.tksoft.chains.project.dto.request.CreateProjectRequestDto;
import ru.spb.tksoft.chains.project.dto.request.DeleteProjectRequestDto;
import ru.spb.tksoft.chains.project.dto.request.GetProjectListRequestDto;
import ru.spb.tksoft.chains.project.dto.request.GetProjectRequestDto;
import ru.spb.tksoft.chains.project.dto.request.UpdateProjectRequestDto;
import ru.spb.tksoft.chains.project.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Projects controller.
 * 
 * Each method can return 400/Bad Request, 401/Unauthorized, 404/Not Found in case of invalid
 * request or even 500/Internal Server Error in case of error.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Projects", description = "CRUD for projects")
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    /**
     * Create new project.
     * 
     * @param createProjectRequest request DTO.
     * @return response DTO + 201/CREATED.
     */
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new project")
    @Tag(name = "create")
    @PostMapping("/create")
    @NotNull
    public CreateProjectResponseDto createProject(
            @NotNull @Valid @RequestBody CreateProjectRequestDto createProjectRequest) {

        return projectService.createProject(createProjectRequest);
    }

    /**
     * Update existing project.
     * 
     * @return response DTO + 200/OK.
     */
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update existing project")
    @Tag(name = "update")
    @PostMapping("/update")
    @NotNull
    public UpdateProjectResponseDto updateProject(
            @NotNull @Valid @RequestBody UpdateProjectRequestDto updateProjectRequest) {

        return projectService.updateProject(updateProjectRequest);
    }

    /**
     * Get list of existing projects owned by the user.
     * 
     * @param getProjectListRequest request DTO.
     * @return response DTO + 200/OK.
     */
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get list of existing projects owned by the user")
    @Tag(name = "list")
    @GetMapping("/list")
    @NotNull
    public ProjectListResponseDto getProjectList(
            @RequestBody @NotNull @Valid GetProjectListRequestDto getProjectListRequest) {

        return projectService.getProjectList(getProjectListRequest);
    }

    /**
     * Get existing project.
     * 
     * @return response DTO + 200/OK.
     */
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get existing project")
    @Tag(name = "get")
    @GetMapping("/get")
    @NotNull
    public ProjectResponseDto getProject(
            @RequestBody @NotNull @Valid GetProjectRequestDto getProjectRequest) {

        return projectService.getProject(getProjectRequest);
    }

    /**
     * Delete existing project.
     * 
     * @return response DTO + 204/NO_CONTENT.
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete existing project")
    @Tag(name = "delete")
    @PostMapping("/delete")
    @NotNull
    public DeleteProjectResponseDto deleteProject(
            @RequestBody @NotNull @Valid DeleteProjectRequestDto deleteProjectRequest) {

        return projectService.deleteProject(deleteProjectRequest);
    }
}
