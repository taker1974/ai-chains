package ru.spb.tksoft.chains.project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project line entity.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Entity
@Table(name = "project_lines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectLine {

    /** Line ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "line_id")
    private Long lineId;

    /** Project reference. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    /** Internal line id. */
    @NotBlank(message = "internalLineId is required")
    @Size(min = 1, max = 16, message = "internalLineId must be between 1 and 16 characters")
    @Pattern(regexp = "^[A-Za-z0-9\\-:_]+$",
            message = "internalLineId must contain only Latin letters, digits, '-', ':', and '_'")
    @Column(name = "internal_line_id", nullable = false, length = 16)
    private String internalLineId;

    /** Block from internal id. */
    @NotBlank(message = "blockFromInternalId is required")
    @Size(min = 1, max = 16,
            message = "blockFromInternalId must be between 1 and 16 characters")
    @Pattern(regexp = "^[A-Za-z0-9\\-:_]+$",
            message = "blockFromInternalId must contain only Latin letters, digits, '-', ':', and '_'")
    @Column(name = "block_from_internal_id", nullable = false, length = 16)
    private String blockFromInternalId;

    /** Block to internal id. */
    @NotBlank(message = "blockToInternalId is required")
    @Size(min = 1, max = 16, message = "blockToInternalId must be between 1 and 16 characters")
    @Pattern(regexp = "^[A-Za-z0-9\\-:_]+$",
            message = "blockToInternalId must contain only Latin letters, digits, '-', ':', and '_'")
    @Column(name = "block_to_internal_id", nullable = false, length = 16)
    private String blockToInternalId;
}
