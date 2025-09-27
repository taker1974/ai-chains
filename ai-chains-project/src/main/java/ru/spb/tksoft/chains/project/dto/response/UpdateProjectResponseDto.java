package ru.spb.tksoft.chains.project.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Update existing project response DTO.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Update existing project response")
public class UpdateProjectResponseDto {

    /** Project ID. */
    @JsonProperty("project_id")
    @Schema(description = "Project ID", example = "123", minimum = "1")
    private Long projectId;
}
