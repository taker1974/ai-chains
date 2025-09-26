package com.example.testjson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Главный класс Spring Boot приложения для обработки JSON данных
 */
@SpringBootApplication
public class TestJsonApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestJsonApplication.class, args);
        System.out.println("==========================================");
        System.out.println("Spring Boot приложение запущено!");
        System.out.println("API доступно по адресу: http://localhost:8080/api");
        System.out.println("POST /api/logData - для отправки данных пользователя");
        System.out.println("GET /api/health - для проверки работоспособности");
        System.out.println("==========================================");
    }
}
