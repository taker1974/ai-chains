package ru.spb.tksoft.chains.project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project block entity.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Entity
@Table(name = "project_blocks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectBlock {

    /** Block ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "block_id")
    private Long blockId;

    /** Project reference. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    /** Internal block id. */
    @NotBlank(message = "internalBlockId is required")
    @Size(min = 1, max = 16, message = "internalBlockId must be between 1 and 16 characters")
    @Pattern(regexp = "^[A-Za-z0-9\\-:_]+$",
            message = "internalBlockId must contain only Latin letters, digits, '-', ':', and '_'")
    @Column(name = "internal_block_id", nullable = false, length = 16)
    private String internalBlockId;

    /** Block type id. */
    @NotBlank(message = "blockTypeId is required")
    @Size(min = 4, max = 64, message = "blockTypeId must be between 4 and 64 characters")
    @Pattern(regexp = "^[A-Za-z0-9\\-:_]+$",
            message = "blockTypeId must contain only Latin letters, digits, '-', ':', and '_'")
    @Column(name = "block_type_id", nullable = false, length = 64)
    private String blockTypeId;

    /** Default input text. */
    @NotBlank(message = "defaultInputText is required")
    @Size(min = 4, max = 4096,
            message = "defaultInputText must be between 4 and 4096 characters")
    @Column(name = "default_input_text", nullable = false, length = 4096)
    private String defaultInputText;
}
