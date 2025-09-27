package ru.spb.tksoft.chains.project.dto.response;

import java.time.Instant;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spb.tksoft.chains.project.enumeration.ProjectStatus;

/**
 * Project list item DTO.
 * 
 * Represents a one-line item in the project list. For use in "Load/open project" UI.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Project list item DTO")
@JsonPropertyOrder({"project_id", "created_at", "updated_at", "owner_id", "name", "status"})
public class ProjectListItemResponseDto {

    /** Project ID. */
    @JsonProperty("project_id")
    @Schema(description = "Project ID", example = "123", minimum = "1")
    private Long projectId;

    /** Project created at. */
    @JsonProperty("created_at")
    @Schema(description = "Project created at", example = "2025-01-01T00:00:00Z")
    private Instant createdAt;

    /** Project updated at. */
    @JsonProperty("updated_at")
    @Schema(description = "Project updated at", example = "2025-01-01T00:00:00Z")
    private Instant updatedAt;

    /** Owner ID. */
    @JsonProperty("owner_id")
    @Schema(description = "Owner ID", example = "123", minimum = "1")
    private Long ownerId;

    /** Project name. */
    @JsonProperty("name")
    @Schema(description = "Project name", example = "Project 1", minLength = 4, maxLength = 64)
    private String name;

    /** Project status. */
    @JsonProperty("status")
    @Schema(description = "Project status", example = "EDITING")
    private ProjectStatus status;
}
