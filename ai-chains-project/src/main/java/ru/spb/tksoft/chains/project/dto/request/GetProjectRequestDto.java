package ru.spb.tksoft.chains.project.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Get existing project request DTO.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request for getting existing project")
public class GetProjectRequestDto {

    /** User ID. */
    @NotNull(message = "userId is required")
    @Positive(message = "userId must be a positive number")
    @JsonProperty("user_id")
    @Schema(description = "User ID", example = "123", minimum = "1")
    private Long userId;

    /** Project ID. */
    @NotNull(message = "projectId is required")
    @Positive(message = "projectId must be a positive number")
    @JsonProperty("project_id")
    @Schema(description = "Project ID", example = "123", minimum = "1")
    private Long projectId;
}
