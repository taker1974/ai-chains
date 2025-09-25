package ru.spb.tksoft.aichains.project.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
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
@JsonPropertyOrder({"user_id", "project_data"})
public class UpdateProjectRequestDto {

    /** User ID. */
    @Min(value = 1, message = "userId must be greater than 0")
    @NotNull(message = "userId is required")
    @JsonProperty("user_id")
    private long userId;

    /** Project full data. */
    @NotNull(message = "projectData is required")
    @JsonProperty("project_data")
    @Valid
    private ProjectRequestDto data;
}
