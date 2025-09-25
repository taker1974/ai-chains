package ru.spb.tksoft.aichains.project.dto;

import java.time.Instant;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project DTO.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

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

    /** Project blocks. */
    @JsonProperty("blocks")
    private List<ProjectBlockDto> blocks;

    /** Project lines. */
    @JsonProperty("lines")
    private List<ProjectLineDto> lines;
}
