package ru.spb.tksoft.aichains.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Get existing template request DTO.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"user_id", "template_id"})
public class TemplateRequestDto {

    /** User ID. */
    @JsonProperty("user_id")
    private long userId;

    /** Template ID. */
    @JsonProperty("template_id")
    private long templateId;
}
