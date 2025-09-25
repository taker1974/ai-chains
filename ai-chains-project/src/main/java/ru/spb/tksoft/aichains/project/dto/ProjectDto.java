package ru.spb.tksoft.aichains.project.dto;

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
    private LocalDateTime createdAt;
    
    /** Project updated at. */
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
    
    /** Owner ID. */
    @JsonProperty("owner_id")
    private long ownerId;

    /** Project name. */
    @JsonProperty("name")
    private String name;

    /** Project status. */
    @JsonProperty("status")
    private String status;

    /** Project ai agents. */
    @JsonProperty("ai_agents")
    private List<String> aiAgents;
}
