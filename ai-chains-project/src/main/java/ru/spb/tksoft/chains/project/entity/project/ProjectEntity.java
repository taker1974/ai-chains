package ru.spb.tksoft.chains.project.entity.project;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spb.tksoft.chains.project.entity.user.UserEntity;
import ru.spb.tksoft.chains.project.enumeration.ProjectStatus;
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
public class ProjectEntity {

    /** Project ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long projectId;

    /** Project created at. */
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    /** Project updated at. */
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    /** Owner. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private UserEntity owner;

    /** Project name. */
    @NotBlank(message = "name is required")
    @Size(min = 4, max = 64, message = "name must be between 4 and 64 characters")
    @Column(name = "name", nullable = false, length = 64)
    private String name;

    /** Project status. */
    @Enumerated(EnumType.STRING)
    @NotNull(message = "status is required")
    @Column(name = "status", nullable = false, length = 20)
    private ProjectStatus status;

    /** Project blocks. */
    @OneToMany(mappedBy = "project",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ProjectBlockEntity> blocks = new ArrayList<>();

    /** Project lines. */
    @OneToMany(mappedBy = "project",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ProjectLineEntity> lines = new ArrayList<>();

    /** Constructor for new project. */
    public ProjectEntity(UserEntity owner, String name) {

        setOwner(owner);
        setName(name);
        setStatus(ProjectStatus.EDITING);
    }

    /** Creates new project entity. */
    public static ProjectEntity newProject(UserEntity owner, String name) {

        var entity = new ProjectEntity(owner, name);
        entity.setStatus(ProjectStatus.EDITING);
        entity.setBlocks(new ArrayList<>());
        entity.setLines(new ArrayList<>());
        return entity;
    }

    /**
     * Add block to project.
     * 
     * @param block - block to add
     */
    public void addBlock(ProjectBlockEntity block) {
        blocks.add(block);
        block.setProject(this);
    }

    /**
     * Remove block from project.
     * 
     * @param block - block to remove
     */
    public void removeBlock(ProjectBlockEntity block) {
        blocks.remove(block);
        block.setProject(null);
    }

    /**
     * Add line to project.
     * 
     * @param line - line to add
     */
    public void addLine(ProjectLineEntity line) {
        lines.add(line);
        line.setProject(this);
    }

    /**
     * Remove line from project.
     * 
     * @param line - line to remove
     */
    public void removeLine(ProjectLineEntity line) {
        lines.remove(line);
        line.setProject(null);
    }
}
