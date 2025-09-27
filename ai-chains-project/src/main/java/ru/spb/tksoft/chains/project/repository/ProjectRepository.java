package ru.spb.tksoft.chains.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.spb.tksoft.chains.project.entity.Project;

import java.util.List;
import java.util.Optional;

/**
 * Project repository.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    /**
     * Find project by ID and owner ID.
     * 
     * @param projectId - project ID
     * @param ownerId - owner ID
     * @return project if found
     */
    @Query("SELECT p FROM Project p WHERE p.projectId = :projectId AND p.ownerId = :ownerId")
    Optional<Project> findByProjectIdAndOwnerId(@Param("projectId") Long projectId, @Param("ownerId") Long ownerId);

    /**
     * Find all projects by owner ID.
     * 
     * @param ownerId - owner ID
     * @return list of projects
     */
    List<Project> findByOwnerIdOrderByUpdatedAtDesc(Long ownerId);

    /**
     * Check if project exists by ID and owner ID.
     * 
     * @param projectId - project ID
     * @param ownerId - owner ID
     * @return true if exists
     */
    @Query("SELECT COUNT(p) > 0 FROM Project p WHERE p.projectId = :projectId AND p.ownerId = :ownerId")
    boolean existsByProjectIdAndOwnerId(@Param("projectId") Long projectId, @Param("ownerId") Long ownerId);
}
