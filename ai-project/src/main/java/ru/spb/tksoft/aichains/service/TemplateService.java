package ru.spb.tksoft.aichains.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import ru.spb.tksoft.aichains.dto.request.CreateTemplateRequestDto;
import ru.spb.tksoft.aichains.dto.request.DeleteTemplateRequestDto;
import ru.spb.tksoft.aichains.dto.request.TemplateRequestDto;
import ru.spb.tksoft.aichains.dto.request.UpdateTemplateRequestDto;
import ru.spb.tksoft.aichains.dto.response.CreateTemplateResponseDto;
import ru.spb.tksoft.aichains.dto.response.TemplateResponseDto;
import ru.spb.tksoft.aichains.dto.response.UpdateTemplateResponseDto;
import ru.spb.tksoft.utils.log.LogEx;

/**
 * Templates service.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Service
@RequiredArgsConstructor
public class TemplateService {

    private final Logger log = LoggerFactory.getLogger(TemplateService.class);

    /**
     * Create new template.
     * 
     * @param createTemplateRequest - request DTO.
     * @return 201/CREATED, 401/Unauthorized.
     */
    public @NotNull CreateTemplateResponseDto createTemplate(
            final @NotNull CreateTemplateRequestDto createTemplateRequest) {

        LogEx.trace(log, LogEx.getThisMethodName(), LogEx.STARTING);

        final CreateTemplateResponseDto dto = new CreateTemplateResponseDto();
        dto.setTemplateId(123L);

        LogEx.trace(log, LogEx.getThisMethodName(), LogEx.STOPPING);
        return dto;
    }

    /**
     * Get existing template.
     * 
     * @param getTemplateRequest - request DTO.
     * @return 200/OK, 401/Unauthorized, 404/Not Found.
     */
    public @NotNull TemplateResponseDto getTemplate(
            final @NotNull TemplateRequestDto getTemplateRequest) {

        LogEx.trace(log, LogEx.getThisMethodName(), LogEx.STARTING);

        final TemplateResponseDto dto = new TemplateResponseDto();
        dto.setTemplateId(123L);

        LogEx.trace(log, LogEx.getThisMethodName(), LogEx.STOPPING);
        return dto;
    }

    /**
     * Update existing template.
     * 
     * @param updateTemplateRequest - request DTO.
     * @return 200/OK, 401/Unauthorized, 404/Not Found.
     */
    public @NotNull UpdateTemplateResponseDto updateTemplate(
            final @NotNull UpdateTemplateRequestDto updateTemplateRequest) {

        LogEx.trace(log, LogEx.getThisMethodName(), LogEx.STARTING);

        final UpdateTemplateResponseDto dto = new UpdateTemplateResponseDto();
        dto.setTemplateId(123L);

        LogEx.trace(log, LogEx.getThisMethodName(), LogEx.STOPPING);
        return dto;
    }

    /**
     * Delete existing template.
     * 
     * @param deleteTemplateRequest - request DTO.
     */
    public void deleteTemplate(final @NotNull DeleteTemplateRequestDto deleteTemplateRequest) {

        LogEx.trace(log, LogEx.getThisMethodName(), LogEx.STARTING);

        // ...

        LogEx.trace(log, LogEx.getThisMethodName(), LogEx.STOPPED);
    }

}
