package ru.spb.tksoft.chains.project.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create new project request DTO.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Create new project request")
public class CreateProjectRequestDto {

    /** User ID. */
    @NotNull(message = "userId is required")
    @Positive(message = "userId must be a positive number")
    @JsonProperty("user_id")
    @Schema(description = "User ID", example = "123", minimum = "1")
    private Long userId;

    /** Project name. */
    @NotBlank(message = "name is required")
    @Size(min = 4, max = 64, message = "name must be between 4 and 64 characters")
    @Schema(description = "Project name", example = "Project 1", minLength = 4, maxLength = 64)
    @JsonProperty("name")
    private String name;
}
