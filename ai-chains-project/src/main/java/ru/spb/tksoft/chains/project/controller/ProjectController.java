package ru.spb.tksoft.chains.project.controller;

import ru.spb.tksoft.chains.project.dto.response.CreateProjectResponseDto;
import ru.spb.tksoft.chains.project.dto.request.CreateProjectRequestDto;
import ru.spb.tksoft.chains.project.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    public CreateProjectResponseDto createProject(
            @NotNull @Valid @RequestBody CreateProjectRequestDto createProjectRequest) {

        return projectService.createProject(createProjectRequest);
    }

}
