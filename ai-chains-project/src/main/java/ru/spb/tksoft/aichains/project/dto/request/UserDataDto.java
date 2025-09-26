package ru.spb.tksoft.aichains.project.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for transferring user data (test).
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "User data (test)")
public class UserDataDto {

    @NotNull(message = "User ID cannot be null")
    @Positive(message = "User ID must be a positive number")
    @JsonProperty("user_id")
    @Schema(description = "User ID", example = "123", minimum = "1")
    private Long userId;

    @NotBlank(message = "User name cannot be empty")
    @JsonProperty("user_name")
    @Schema(description = "User name", example = "ivan", minLength = 1)
    private String userName;
}
