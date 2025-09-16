package ru.spb.tksoft.aichains.controller;

import lombok.RequiredArgsConstructor;
import ru.spb.tksoft.aichains.dto.request.CreateTemplateRequestDto;
import ru.spb.tksoft.aichains.dto.request.DeleteTemplateRequestDto;
import ru.spb.tksoft.aichains.dto.request.TemplateRequestDto;
import ru.spb.tksoft.aichains.dto.request.UpdateTemplateRequestDto;
import ru.spb.tksoft.aichains.dto.response.CreateTemplateResponseDto;
import ru.spb.tksoft.aichains.dto.response.TemplateResponseDto;
import ru.spb.tksoft.aichains.dto.response.UpdateTemplateResponseDto;
import ru.spb.tksoft.aichains.service.TemplateService;
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
@Tag(name = "Projects aka templates")
@RequestMapping("/templates")
public class TemplateController {

    private final TemplateService templateService;

    /**
     * Create new template.
     * 
     * @return 201/CREATED, 401/Unauthorized.
     */
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new template aka project")
    @PostMapping("/create")
    @NotNull
    public CreateTemplateResponseDto createTemplate(
            @NotNull @Valid CreateTemplateRequestDto createTemplateRequest) {

        return templateService.createTemplate(createTemplateRequest);
    }

    /**
     * Get existing template.
     * 
     * @return 200/OK, 401/Unauthorized, 404/Not Found.
     */
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get existing template")
    @PostMapping("/get")
    @NotNull
    public TemplateResponseDto getTemplate(
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
