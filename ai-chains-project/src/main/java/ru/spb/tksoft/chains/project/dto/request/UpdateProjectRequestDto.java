package ru.spb.tksoft.chains.project.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Update existing project request DTO.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Update existing project request")
public class UpdateProjectRequestDto {

    /** User ID. */
    @NotNull(message = "userId is required")
    @Positive(message = "userId must be a positive number")
    @JsonProperty("user_id")
    @Schema(description = "User ID", example = "123", minimum = "1")
    private Long userId;

    /** Project full data. */
    @NotNull(message = "projectData is required")
    @Schema(description = "Project full data")
    @JsonProperty("data")
    @Valid
    private ProjectRequestDto data;
}
