package ru.spb.tksoft.aichains.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Block DTO. Used for both request and response, so validation is actively used.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectBlockDto {

    /** Internal block id. */
    @NotBlank(message = "internalBlockId is required")
    @Size(min = 1, max = 16, message = "internalBlockId must be between 1 and 16 characters")
    @Pattern(regexp = "^[A-Za-z0-9\\-:_]+$",
            message = "internalBlockId must contain only Latin letters, digits, '-', ':', and '_'")
    @JsonProperty("internal_block_id")
    private String internalBlockId;

    /** Block type id. */
    @NotBlank(message = "blockTypeId is required")
    @Size(min = 4, max = 64, message = "blockTypeId must be between 4 and 64 characters")
    @Pattern(regexp = "^[A-Za-z0-9\\-:_]+$",
            message = "blockTypeId must contain only Latin letters, digits, '-', ':', and '_'")
    @JsonProperty("block_type_id")
    private String blockTypeId;

    /** Default input text. */
    @NotBlank(message = "defaultInputText is required")
    @Size(min = 4, max = 4096, message = "defaultInputText must be between 4 and 4096 characters")
    @JsonProperty("default_input_text")
    private String defaultInputText;
}
