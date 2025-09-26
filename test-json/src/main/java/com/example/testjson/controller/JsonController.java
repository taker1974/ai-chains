package com.example.testjson.controller;

import com.example.testjson.dto.UserDataDto;
import com.example.testjson.service.UserDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

/**
 * REST контроллер для обработки JSON данных пользователя
 */
@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Tag(name = "User Data", description = "API для работы с данными пользователя")
public class JsonController {

    private final UserDataService userDataService;

    /**
     * POST метод для получения и логирования данных пользователя
     * 
     * @param userData данные пользователя в формате JSON
     * @return ResponseEntity с сообщением об успешной обработке
     */
    @Operation(
            summary = "Логирование данных пользователя",
            description = "Принимает данные пользователя и выводит их в консоль для логирования")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Данные успешно обработаны",
                    content = @Content(
                            mediaType = "text/plain",
                            examples = @ExampleObject(
                                    value = "Данные пользователя успешно обработаны и залогированы"))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка валидации данных",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\"timestamp\":\"2025-09-26T10:00:00.000+00:00\",\"status\":400,\"error\":\"Bad Request\",\"path\":\"/api/logData\"}")))
    })
    @PostMapping("/logData")
    public ResponseEntity<String> logData(
            @Valid @RequestBody @Schema(description = "Данные пользователя",
                    example = "{\"user_id\": 123, \"user_name\": \"ivan\"}") UserDataDto userData) {
        log.info("Получен запрос на логирование данных пользователя: {}", userData);
        userDataService.logUserData(userData);
        return ResponseEntity.ok("Данные пользователя успешно обработаны и залогированы");
    }

    /**
     * GET метод для проверки работоспособности API
     * 
     * @return ResponseEntity с информацией о статусе
     */
    @Operation(
            summary = "Проверка работоспособности API",
            description = "Возвращает статус работоспособности API")
    @ApiResponse(
            responseCode = "200",
            description = "API работает корректно",
            content = @Content(
                    mediaType = "text/plain",
                    examples = @ExampleObject(value = "API работает корректно")))
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("API работает корректно");
    }

    /**
     * Обработчик ошибок валидации
     * 
     * @param ex исключение валидации
     * @return ResponseEntity с описанием ошибки
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        log.warn("Ошибка валидации: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Ошибка валидации данных: " + ex.getMessage());
    }
}
