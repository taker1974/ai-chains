package ru.spb.tksoft.aichains.project.dto.response;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Project list DTO.
 * 
 * For use in "Load/open project" UI.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Data
@AllArgsConstructor
public class ProjectListResponseDto {

    /** Project list items. */
    @JsonProperty("items")
    private List<ProjectListItemResponseDto> items;

    /** Default constructor. */
    public ProjectListResponseDto() {
        this.items = new ArrayList<>();
    }
}
