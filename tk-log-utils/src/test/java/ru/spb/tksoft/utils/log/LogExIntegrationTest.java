package ru.spb.tksoft.utils.log;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration tests for LogEx class with real logger.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@SuppressWarnings("java:S1192")
@DisplayName("LogEx Integration Tests")
class LogExIntegrationTest {

    private Logger logger;
    private ListAppender<ILoggingEvent> listAppender;

    @BeforeEach
    void setUp() {
        logger = (Logger) LoggerFactory.getLogger(LogExIntegrationTest.class);
        logger.setLevel(Level.TRACE);

        listAppender = new ListAppender<>();
        listAppender.start();
        logger.addAppender(listAppender);
    }

    @Test
    @DisplayName("Should log with real logger - trace level")
    void shouldLogWithRealLoggerTraceLevel() {
        // When
        LogEx.trace(logger, "integration", "test", "trace");

        // Then
        List<ILoggingEvent> events = listAppender.list;
        assertThat(events).hasSize(1);
        assertThat(events.get(0).getLevel()).isEqualTo(Level.TRACE);
        assertThat(events.get(0).getFormattedMessage()).isEqualTo("integration: test: trace");
    }

    @Test
    @DisplayName("Should log with real logger - debug level")
    void shouldLogWithRealLoggerDebugLevel() {
        // When
        LogEx.debug(logger, "integration", "test", "debug");

        // Then
        List<ILoggingEvent> events = listAppender.list;
        assertThat(events).hasSize(1);
        assertThat(events.get(0).getLevel()).isEqualTo(Level.DEBUG);
        assertThat(events.get(0).getFormattedMessage()).isEqualTo("integration: test: debug");
    }

    @Test
    @DisplayName("Should log with real logger - info level")
    void shouldLogWithRealLoggerInfoLevel() {
        // When
        LogEx.info(logger, "integration", "test", "info");

        // Then
        List<ILoggingEvent> events = listAppender.list;
        assertThat(events).hasSize(1);
        assertThat(events.get(0).getLevel()).isEqualTo(Level.INFO);
        assertThat(events.get(0).getFormattedMessage()).isEqualTo("integration: test: info");
    }

    @Test
    @DisplayName("Should log with real logger - warn level")
    void shouldLogWithRealLoggerWarnLevel() {
        // When
        LogEx.warn(logger, "integration", "test", "warn");

        // Then
        List<ILoggingEvent> events = listAppender.list;
        assertThat(events).hasSize(1);
        assertThat(events.get(0).getLevel()).isEqualTo(Level.WARN);
        assertThat(events.get(0).getFormattedMessage()).isEqualTo("integration: test: warn");
    }

    @Test
    @DisplayName("Should log with real logger - error level")
    void shouldLogWithRealLoggerErrorLevel() {
        // When
        LogEx.error(logger, "integration", "test", "error");

        // Then
        List<ILoggingEvent> events = listAppender.list;
        assertThat(events).hasSize(1);
        assertThat(events.get(0).getLevel()).isEqualTo(Level.ERROR);
        assertThat(events.get(0).getFormattedMessage()).isEqualTo("integration: test: error");
    }

    @Test
    @DisplayName("Should respect logger level configuration")
    void shouldRespectLoggerLevelConfiguration() {
        // Given
        logger.setLevel(Level.WARN);

        // When
        LogEx.trace(logger, "trace", "message");
        LogEx.debug(logger, "debug", "message");
        LogEx.info(logger, "info", "message");
        LogEx.warn(logger, "warn", "message");
        LogEx.error(logger, "error", "message");

        // Then
        List<ILoggingEvent> events = listAppender.list;
        assertThat(events).hasSize(2); // Only warn and error should be logged
        assertThat(events.get(0).getLevel()).isEqualTo(Level.WARN);
        assertThat(events.get(0).getFormattedMessage()).isEqualTo("warn: message");
        assertThat(events.get(1).getLevel()).isEqualTo(Level.ERROR);
        assertThat(events.get(1).getFormattedMessage()).isEqualTo("error: message");
    }

    @Test
    @DisplayName("Should handle method name detection in real scenario")
    void shouldHandleMethodNameDetectionInRealScenario() {
        // When
        String methodName = LogEx.me();

        // Then
        assertThat(methodName).isEqualTo("shouldHandleMethodNameDetectionInRealScenario");
    }

    @Test
    @DisplayName("Should work with constants in real logger")
    void shouldWorkWithConstantsInRealLogger() {
        // When
        LogEx.info(logger, LogEx.STARTING, "application");
        LogEx.info(logger, LogEx.STOPPING, "application");
        LogEx.error(logger, LogEx.EXCEPTION_THROWN, "RuntimeException");

        // Then
        List<ILoggingEvent> events = listAppender.list;
        assertThat(events).hasSize(3);
        assertThat(events.get(0).getFormattedMessage()).isEqualTo("starting: application");
        assertThat(events.get(1).getFormattedMessage()).isEqualTo("finishing: application");
        assertThat(events.get(2).getFormattedMessage())
                .isEqualTo("exception thrown: RuntimeException");
    }

    @Test
    @DisplayName("Should handle complex logging scenario")
    void shouldHandleComplexLoggingScenario() {
        // When
        LogEx.info(logger, "User", "John", "performed", "action", "login");
        LogEx.warn(logger, "System", "memory", "usage", "high", 85, "%");
        LogEx.error(logger, "Database", "connection", "failed", "retry", 3);

        // Then
        List<ILoggingEvent> events = listAppender.list;
        assertThat(events).hasSize(3);
        assertThat(events.get(0).getFormattedMessage())
                .isEqualTo("User: John: performed: action: login");
        assertThat(events.get(1).getFormattedMessage())
                .isEqualTo("System: memory: usage: high: 85: %");
        assertThat(events.get(2).getFormattedMessage())
                .isEqualTo("Database: connection: failed: retry: 3");
    }
}
