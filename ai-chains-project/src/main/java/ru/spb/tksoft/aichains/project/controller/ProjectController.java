package ru.spb.tksoft.aichains.project.controller;

import lombok.RequiredArgsConstructor;
import ru.spb.tksoft.aichains.project.dto.request.CreateTemplateRequestDto;
import ru.spb.tksoft.aichains.project.dto.request.DeleteTemplateRequestDto;
import ru.spb.tksoft.aichains.project.dto.request.TemplateRequestDto;
import ru.spb.tksoft.aichains.project.dto.request.UpdateTemplateRequestDto;
import ru.spb.tksoft.aichains.project.dto.response.CreateTemplateResponseDto;
import ru.spb.tksoft.aichains.project.dto.response.TemplateResponseDto;
import ru.spb.tksoft.aichains.project.dto.response.UpdateTemplateResponseDto;
import ru.spb.tksoft.aichains.project.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
     * @return 201/CREATED, 401/Unauthorized.
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
     * @return 200/OK, 401/Unauthorized, 404/Not Found.
     */
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get existing project")
    @PostMapping("/get")
    @NotNull
    public ProjectResponseDto getProject(
            @NotNull @Valid TemplateRequestDto getTemplateRequest) {

        return templateService.getTemplate(getTemplateRequest);
    }

    /**
     * Update existing template.
     * 
     * @return 200/OK, 401/Unauthorized, 404/Not Found.
     */
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update existing template")
    @PostMapping("/update")
    @NotNull
    public UpdateTemplateResponseDto updateTemplate(
            @NotNull @Valid UpdateTemplateRequestDto updateTemplateRequest) {

        return templateService.updateTemplate(updateTemplateRequest);
    }

    /**
     * Delete existing template.
     * 
     * @return 204/NO_CONTENT, 401/Unauthorized, 404/Not Found.
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete existing template")
    @DeleteMapping("/delete")
    @NotNull
    public void deleteTemplate(
            @NotNull @Valid DeleteTemplateRequestDto deleteTemplateRequest) {

        templateService.deleteTemplate(deleteTemplateRequest);
    }
}
