package com.example.testjson.service;

import com.example.testjson.dto.UserDataDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Сервис для обработки и логирования данных пользователя
 */
@Slf4j
@Service
public class UserDataService {

    /**
     * Логирует данные пользователя в консоль
     * 
     * @param userData данные пользователя для логирования
     */
    public void logUserData(UserDataDto userData) {
        log.info("=== Получены данные пользователя ===");
        log.info("User ID: {}", userData.getUserId());
        log.info("User Name: {}", userData.getUserName());
        log.info("Полные данные: {}", userData);
        log.info("=====================================");

        // Дополнительный вывод в консоль для демонстрации
        System.out.println("=== ДАННЫЕ ПОЛЬЗОВАТЕЛЯ ===");
        System.out.println("ID: " + userData.getUserId());
        System.out.println("Имя: " + userData.getUserName());
        System.out.println("==========================");
    }
}
