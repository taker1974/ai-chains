package ru.spb.tksoft.aichains.project.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.spb.tksoft.aichains.project.dto.request.UserDataDto;

/**
 * Projects service.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectService {

    /**
     * Log user data (test).
     * 
     * @param userData user data.
     */
    public void logUserData(UserDataDto userData) {

        log.info("=== User data received ===");
        log.info("User ID: {}", userData.getUserId());
        log.info("User Name: {}", userData.getUserName());
        log.info("Full data: {}", userData);
        log.info("=====================================");
    }

}
