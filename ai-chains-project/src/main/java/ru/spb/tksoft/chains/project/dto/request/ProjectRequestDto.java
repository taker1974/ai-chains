package ru.spb.tksoft.chains.project.dto.request;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project request DTO.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Project request DTO")
public class ProjectRequestDto {

    /** Project ID. */
    @NotNull(message = "projectId is required")
    @Positive(message = "projectId must be a positive number")
    @JsonProperty("project_id")
    @Schema(description = "Project ID", example = "123", minimum = "1")
    private Long projectId;

    /** Owner ID. */
    @NotNull(message = "ownerId is required")
    @Positive(message = "ownerId must be a positive number")
    @JsonProperty("owner_id")
    @Schema(description = "Owner ID", example = "123", minimum = "1")
    private Long ownerId;

    /** Project name. */
    @NotBlank(message = "name is required")
    @Size(min = 4, max = 64, message = "name must be between 4 and 64 characters")
    @JsonProperty("name")
    @Schema(description = "Project name", example = "Project 1", minLength = 4, maxLength = 64)
    private String name;

    /** Project status. */
    @NotBlank(message = "status is required")
    @Size(min = 1, max = 20, message = "status must be between 1 and 20 characters")
    @JsonProperty("status")
    @Schema(description = "Project status", example = "EDITING", minLength = 1, maxLength = 20)
    private String status;

    /** Project blocks. */
    @NotNull(message = "blocks is required")
    @JsonProperty("blocks")
    @Valid
    private List<ProjectBlockRequestDto> blocks;

    /** Project lines. */
    @NotNull(message = "lines is required")
    @JsonProperty("lines")
    @Valid
    private List<ProjectLineRequestDto> lines;
}
