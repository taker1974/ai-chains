package ru.spb.tksoft.chains.project.service;

import ru.spb.tksoft.chains.project.dto.request.CreateProjectRequestDto;
import ru.spb.tksoft.chains.project.dto.response.CreateProjectResponseDto;
import ru.spb.tksoft.utils.log.LogEx;
import org.springframework.stereotype.Service;
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
}
