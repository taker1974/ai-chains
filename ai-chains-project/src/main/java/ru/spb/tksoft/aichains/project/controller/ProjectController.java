package ru.spb.tksoft.aichains.project.controller;

import lombok.RequiredArgsConstructor;
import ru.spb.tksoft.aichains.project.dto.request.UserDataDto;
import ru.spb.tksoft.aichains.project.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import jakarta.validation.Valid;
import org.springframework.web.bind.MethodArgumentNotValidException;
import lombok.extern.slf4j.Slf4j;

/**
 * Projects controller.
 * 
 * Each method can return 400/Bad Request, 401/Unauthorized, 404/Not Found in case of invalid
 * request or even 500/Internal Server Error in case of error.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Tag(name = "User Data", description = "API for working with user data")
public class ProjectController {

    private final ProjectService projectService;

    /**
     * POST method for receiving and logging user data
     * 
     * @param userData user data in JSON format
     * @return ResponseEntity with success message
     */
    @Operation(
            summary = "Logging user data",
            description = "Accepts user data and logs it to the console")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Data successfully processed",
                    content = @Content(
                            mediaType = "text/plain",
                            examples = @ExampleObject(
                                    value = "User data successfully processed and logged"))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Data validation error",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\"timestamp\":\"2025-09-26T10:00:00.000+00:00\",\"status\":400,\"error\":\"Bad Request\",\"path\":\"/api/logData\"}")))
    })
    @PostMapping("/logData")
    public ResponseEntity<String> logData(
            @Valid @RequestBody @Schema(description = "User data",
                    example = "{\"user_id\": 123, \"user_name\": \"ivan\"}") UserDataDto userData) {
        log.info("Received request to log user data: {}", userData);
        projectService.logUserData(userData);
        return ResponseEntity.ok("User data successfully processed and logged");
    }

    /**
     * GET method for checking API health
     * 
     * @return ResponseEntity with status information
     */
    @Operation(
            summary = "Checking API health",
            description = "Returns the status of the API")
    @ApiResponse(
            responseCode = "200",
            description = "API is working correctly",
            content = @Content(
                    mediaType = "text/plain",
                    examples = @ExampleObject(value = "API is working correctly")))
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("API is working correctly");
    }

    /**
     * Validation error handler
     * 
     * @param ex validation exception
     * @return ResponseEntity with error description
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        
        log.warn("Validation error: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Validation error: " + ex.getMessage());
    }

}
