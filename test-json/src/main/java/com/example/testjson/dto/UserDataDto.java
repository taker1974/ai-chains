package com.example.testjson.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO для передачи данных пользователя
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные пользователя")
public class UserDataDto {

    @NotNull(message = "User ID не может быть null")
    @Positive(message = "User ID должен быть положительным числом")
    @JsonProperty("user_id")
    @Schema(description = "Идентификатор пользователя", example = "123", minimum = "1")
    private Long userId;

    @NotBlank(message = "User name не может быть пустым")
    @JsonProperty("user_name")
    @Schema(description = "Имя пользователя", example = "ivan", minLength = 1)
    private String userName;
}
