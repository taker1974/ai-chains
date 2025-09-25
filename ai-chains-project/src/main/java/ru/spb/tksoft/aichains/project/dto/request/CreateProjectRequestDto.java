package ru.spb.tksoft.aichains.project.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create new project request DTO.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProjectRequestDto {

    /** User ID. */
    @Min(value = 1, message = "userId must be greater than 0")
    @NotNull(message = "userId is required")
    @JsonProperty("user_id")
    private long userId;
}
