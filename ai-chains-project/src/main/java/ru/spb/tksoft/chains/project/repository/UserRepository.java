package ru.spb.tksoft.chains.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spb.tksoft.chains.project.entity.user.UserEntity;
import java.util.Optional;

/**
 * User repository.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * Find user by ID.
     * 
     * @param userId - user ID
     * @return user if found
     */
    Optional<UserEntity> findByUserId(Long id);
}
