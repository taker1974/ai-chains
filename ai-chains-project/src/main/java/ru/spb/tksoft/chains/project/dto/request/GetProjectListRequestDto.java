package ru.spb.tksoft.chains.project.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Get list of existing projects owned by the user request DTO.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetProjectListRequestDto {

    /** User ID. */
    @NotNull(message = "userId is required")
    @Positive(message = "userId must be a positive number")
    @JsonProperty("user_id")
    @Schema(description = "User ID", example = "123", minimum = "1")
    private Long userId;
}
