package ru.spb.tksoft.aichains.project.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Delete existing project request DTO.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteProjectRequestDto {

    /** User ID. */
    @JsonProperty("user_id")
    private long userId;

    /** Project ID. */
    @JsonProperty("project_id")
    private long projectId;
}
