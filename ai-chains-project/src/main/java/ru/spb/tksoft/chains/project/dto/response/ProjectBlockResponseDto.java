package ru.spb.tksoft.chains.project.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Block response DTO.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Block response DTO")
@JsonPropertyOrder({"internal_block_id", "block_type_id", "default_input_text"})
public class ProjectBlockResponseDto {

    /** Internal block id. */
    @JsonProperty("internal_block_id")
    @Schema(description = "Internal block id", example = "block_123")
    private String internalBlockId;

    /** Block type id. */
    @JsonProperty("block_type_id")
    @Schema(description = "Block type id", example = "ai-deepseek")
    private String blockTypeId;

    /** Default input text. */
    @JsonProperty("default_input_text")
    @Schema(description = "Default input text", example = "Hello, world!")
    private String defaultInputText;
}
