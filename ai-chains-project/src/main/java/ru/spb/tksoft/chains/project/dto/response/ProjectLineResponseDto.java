package ru.spb.tksoft.chains.project.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Line response DTO.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Line response DTO")
public class ProjectLineResponseDto {

    /** Internal line id. */
    @NotBlank(message = "internalLineId is required")
    @Size(min = 1, max = 16, message = "internalLineId must be between 1 and 16 characters")
    @Pattern(regexp = "^[A-Za-z0-9\\-:_]+$",
            message = "internalLineId must contain only Latin letters, digits, '-', ':', and '_'")
    @JsonProperty("internal_line_id")
    @Schema(description = "Internal line id", example = "line_123")
    private String internalLineId;

    /** Block from internal id. */
    @NotBlank(message = "blockFromInternalId is required")
    @Size(min = 1, max = 16,
            message = "blockFromInternalId must be between 1 and 16 characters")
    @Pattern(regexp = "^[A-Za-z0-9\\-:_]+$",
            message = "blockFromInternalId must contain only Latin letters, digits, '-', ':', and '_'")
    @JsonProperty("block_from_internal_id")
    @Schema(description = "Block from internal id", example = "block_123")
    private String blockFromInternalId;

    /** Block to internal id. */
    @NotBlank(message = "blockToInternalId is required")
    @Size(min = 1, max = 16, message = "blockToInternalId must be between 1 and 16 characters")
    @Pattern(regexp = "^[A-Za-z0-9\\-:_]+$",
            message = "blockToInternalId must contain only Latin letters, digits, '-', ':', and '_'")
    @JsonProperty("block_to_internal_id")
    @Schema(description = "Block to internal id", example = "block_456")
    private String blockToInternalId;
}
