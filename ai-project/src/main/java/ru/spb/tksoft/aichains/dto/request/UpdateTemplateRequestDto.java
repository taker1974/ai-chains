package ru.spb.tksoft.aichains.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spb.tksoft.aichains.dto.TemplateDto;

/**
 * Update existing template request DTO.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTemplateRequestDto {

    /** Template full data. */
    @JsonProperty("template_data")
    private TemplateDto data;
}
