package ru.spb.tksoft.chains.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.spb.tksoft.chains.project.entity.ProjectBlock;

import java.util.List;
import java.util.Optional;

/**
 * Project block repository.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Repository
public interface ProjectBlockRepository extends JpaRepository<ProjectBlock, Long> {

    /**
     * Find all blocks by project ID.
     * 
     * @param projectId - project ID
     * @return list of blocks
     */
    List<ProjectBlock> findByProjectProjectIdOrderByBlockId(Long projectId);

    /**
     * Find block by project ID and internal block ID.
     * 
     * @param projectId - project ID
     * @param internalBlockId - internal block ID
     * @return block if found
     */
    @Query("SELECT b FROM ProjectBlock b WHERE b.project.projectId = :projectId AND b.internalBlockId = :internalBlockId")
    Optional<ProjectBlock> findByProjectIdAndInternalBlockId(@Param("projectId") Long projectId, @Param("internalBlockId") String internalBlockId);

    /**
     * Delete all blocks by project ID.
     * 
     * @param projectId - project ID
     */
    void deleteByProjectProjectId(Long projectId);
}
