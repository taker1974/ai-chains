package ru.spb.tksoft.aichains.project.dto.response;

import java.time.Instant;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@JsonPropertyOrder({"project_id", "created_at", "updated_at", "owner_id", "name", "status"})
public class ProjectListItemResponseDto {

    /** Project ID. */
    @JsonProperty("project_id")
    private long projectId;

    /** Project created at. */
    @JsonProperty("created_at")
    private Instant createdAt;

    /** Project updated at. */
    @JsonProperty("updated_at")
    private Instant updatedAt;

    /** Owner ID. */
    @JsonProperty("owner_id")
    private long ownerId;

    /** Project name. */
    @JsonProperty("name")
    private String name;

    /** Project status. */
    @JsonProperty("status")
    private String status;
}
