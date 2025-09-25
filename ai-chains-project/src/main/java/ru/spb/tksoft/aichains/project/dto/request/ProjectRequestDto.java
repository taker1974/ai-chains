package ru.spb.tksoft.aichains.project.dto.request;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spb.tksoft.aichains.project.dto.ProjectBlockDto;
import ru.spb.tksoft.aichains.project.dto.ProjectLineDto;

/**
 * Project request DTO.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"project_id", "owner_id", "name", "status", "blocks", "lines"})
public class ProjectRequestDto {

    /** Project ID. */
    @Min(value = 1, message = "projectId must be greater than 0")
    @NotNull(message = "projectId is required")
    @JsonProperty("project_id")
    private long projectId;

    /** Owner ID. */
    @Min(value = 1, message = "ownerId must be greater than 0")
    @NotNull(message = "ownerId is required")
    @JsonProperty("owner_id")
    private long ownerId;

    /** Project name. */
    @NotBlank(message = "name is required")
    @Size(min = 1, max = 64, message = "name must be between 1 and 64 characters")
    @JsonProperty("name")
    private String name;

    /** Project status. */
    @NotBlank(message = "status is required")
    @Size(min = 1, max = 20, message = "status must be between 1 and 20 characters")
    @JsonProperty("status")
    private String status;

    /** Project blocks. */
    @NotNull(message = "blocks is required")
    @JsonProperty("blocks")
    @Valid
    private List<ProjectBlockDto> blocks;

    /** Project lines. */
    @NotNull(message = "lines is required")
    @JsonProperty("lines")
    @Valid
    private List<ProjectLineDto> lines;
}
