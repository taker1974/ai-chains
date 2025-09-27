package ru.spb.tksoft.chains.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.spb.tksoft.chains.project.entity.ProjectLine;

import java.util.List;
import java.util.Optional;

/**
 * Project line repository.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Repository
public interface ProjectLineRepository extends JpaRepository<ProjectLine, Long> {

    /**
     * Find all lines by project ID.
     * 
     * @param projectId - project ID
     * @return list of lines
     */
    List<ProjectLine> findByProjectProjectIdOrderByLineId(Long projectId);

    /**
     * Find line by project ID and internal line ID.
     * 
     * @param projectId - project ID
     * @param internalLineId - internal line ID
     * @return line if found
     */
    @Query("SELECT l FROM ProjectLine l WHERE l.project.projectId = :projectId AND l.internalLineId = :internalLineId")
    Optional<ProjectLine> findByProjectIdAndInternalLineId(@Param("projectId") Long projectId, @Param("internalLineId") String internalLineId);

    /**
     * Delete all lines by project ID.
     * 
     * @param projectId - project ID
     */
    void deleteByProjectProjectId(Long projectId);
}
