package ru.spb.tksoft.chains.project.mapper;

import ru.spb.tksoft.chains.project.dto.request.CreateProjectRequestDto;
import ru.spb.tksoft.chains.project.dto.response.CreateProjectResponseDto;
import ru.spb.tksoft.chains.project.entity.project.ProjectEntity;

/**
 * Mapper for Project*.
 *
 * Converting {@code DTO from/to entity}.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
public final class ProjectMapper {

    /** Default constructor. */
    private ProjectMapper() {}

    /**
     * Convert ProjectEntity to CreateProjectResponseDto.
     * 
     * @param entity - saved entity.
     * @return response DTO.
     */
    public static CreateProjectResponseDto toDto(ProjectEntity entity) {

        return new CreateProjectResponseDto(entity.getProjectId());
    }
}
