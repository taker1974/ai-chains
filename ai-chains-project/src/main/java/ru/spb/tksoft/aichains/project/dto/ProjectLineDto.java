package ru.spb.tksoft.aichains.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Line DTO.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectLineDto {

    /** Internal line id. */
    @JsonProperty("internal_line_id")
    private String internalLineId;

    /** Block from internal id. */
    @JsonProperty("block_from_internal_id")
    private String blockFromInternalId;

    /** Block to internal id. */
    @JsonProperty("block_to_internal_id")
    private String blockToInternalId;
}
