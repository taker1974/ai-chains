package ru.spb.tksoft.aichains.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Block DTO.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectBlockDto {

    /** Internal block id. */
    @JsonProperty("internal_block_id")
    private String internalBlockId;

    /** Block type id. */
    @JsonProperty("block_type_id")
    private String blockTypeId;

    /** Default input text. */
    @JsonProperty("default_input_text")
    private String defaultInputText;
}
