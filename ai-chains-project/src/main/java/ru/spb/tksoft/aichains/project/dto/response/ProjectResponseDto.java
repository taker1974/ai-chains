package ru.spb.tksoft.aichains.project.dto.response;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spb.tksoft.aichains.project.dto.ProjectBlockDto;
import ru.spb.tksoft.aichains.project.dto.ProjectLineDto;

/**
 * Project response DTO.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@AllArgsConstructor
public class ProjectResponseDto {

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

    /** Default constructor. */
    public ProjectResponseDto() {
        this.blocks = new ArrayList<>();
        this.lines = new ArrayList<>();
    }
}
