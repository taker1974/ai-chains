package ru.spb.tksoft.chains.project.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Block request DTO.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Block request DTO")
public class ProjectBlockRequestDto {

    /** Internal block id. */
    @NotBlank(message = "internalBlockId is required")
    @Size(min = 1, max = 16, message = "internalBlockId must be between 1 and 16 characters")
    @Pattern(regexp = "^[A-Za-z0-9\\-:_]+$",
            message = "internalBlockId must contain only Latin letters, digits, '-', ':', and '_'")
    @JsonProperty("internal_block_id")
    @Schema(description = "Internal block id", example = "block_123")
    private String internalBlockId;

    /** Block type id. */
    @NotBlank(message = "blockTypeId is required")
    @Size(min = 4, max = 64, message = "blockTypeId must be between 4 and 64 characters")
    @Pattern(regexp = "^[A-Za-z0-9\\-:_]+$",
            message = "blockTypeId must contain only Latin letters, digits, '-', ':', and '_'")
    @JsonProperty("block_type_id")
    @Schema(description = "Block type id", example = "ai-deepseek")
    private String blockTypeId;

    /** Default input text. */
    @NotBlank(message = "defaultInputText is required")
    @Size(min = 4, max = 4096,
            message = "defaultInputText must be between 4 and 4096 characters")
    @JsonProperty("default_input_text")
    @Schema(description = "Default input text", example = "Hello, world!")
    private String defaultInputText;
}
