package ru.spb.tksoft.aichains.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Line DTO. Used for both request and response, so validation is actively used.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectLineDto {

    /** Internal line id. */
    @NotBlank(message = "internalLineId is required")
    @Size(min = 1, max = 16, message = "internalLineId must be between 1 and 16 characters")
    @Pattern(regexp = "^[A-Za-z0-9\\-:_]+$",
            message = "internalLineId must contain only Latin letters, digits, '-', ':', and '_'")
    @JsonProperty("internal_line_id")
    private String internalLineId;

    /** Block from internal id. */
    @NotBlank(message = "blockFromInternalId is required")
    @Size(min = 1, max = 16, message = "blockFromInternalId must be between 1 and 16 characters")
    @Pattern(regexp = "^[A-Za-z0-9\\-:_]+$",
            message = "blockFromInternalId must contain only Latin letters, digits, '-', ':', and '_'")
    @JsonProperty("block_from_internal_id")
    private String blockFromInternalId;

    /** Block to internal id. */
    @NotBlank(message = "blockToInternalId is required")
    @Size(min = 1, max = 16, message = "blockToInternalId must be between 1 and 16 characters")
    @Pattern(regexp = "^[A-Za-z0-9\\-:_]+$",
            message = "blockToInternalId must contain only Latin letters, digits, '-', ':', and '_'")
    @JsonProperty("block_to_internal_id")
    private String blockToInternalId;
}
