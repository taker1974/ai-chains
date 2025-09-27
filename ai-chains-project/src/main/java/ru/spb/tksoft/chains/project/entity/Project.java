package ru.spb.tksoft.chains.project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Project entity.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Entity
@Table(name = "projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    /** Project ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long projectId;

    /** Owner ID. */
    @NotNull(message = "ownerId is required")
    @Positive(message = "ownerId must be a positive number")
    @Column(name = "owner_id", nullable = false)
    private Long ownerId;

    /** Project name. */
    @NotBlank(message = "name is required")
    @Size(min = 4, max = 64, message = "name must be between 4 and 64 characters")
    @Column(name = "name", nullable = false, length = 64)
    private String name;

    /** Project status. */
    @NotBlank(message = "status is required")
    @Size(min = 1, max = 20, message = "status must be between 1 and 20 characters")
    @Column(name = "status", nullable = false, length = 20)
    private String status;

    /** Project created at. */
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    /** Project updated at. */
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    /** Project blocks. */
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ProjectBlock> blocks = new ArrayList<>();

    /** Project lines. */
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ProjectLine> lines = new ArrayList<>();

    /**
     * Add block to project.
     * 
     * @param block - block to add
     */
    public void addBlock(ProjectBlock block) {
        blocks.add(block);
        block.setProject(this);
    }

    /**
     * Remove block from project.
     * 
     * @param block - block to remove
     */
    public void removeBlock(ProjectBlock block) {
        blocks.remove(block);
        block.setProject(null);
    }

    /**
     * Add line to project.
     * 
     * @param line - line to add
     */
    public void addLine(ProjectLine line) {
        lines.add(line);
        line.setProject(this);
    }

    /**
     * Remove line from project.
     * 
     * @param line - line to remove
     */
    public void removeLine(ProjectLine line) {
        lines.remove(line);
        line.setProject(null);
    }
}
