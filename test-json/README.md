# Test JSON Spring Boot Application

Spring Boot приложение для обработки JSON данных пользователя с автоматически
генерируемой документацией API через Swagger UI.

## 🚀 Быстрый старт

1. **Запуск приложения:**

   ```bash
   mvn spring-boot:run
   ```

2. **Доступ к API:**

   - API: <http://localhost:8080/api>
   - Swagger UI: <http://localhost:8080/swagger-ui/index.html>

3. **Тестирование:**

   ```bash
   curl -X POST http://localhost:8080/api/logData \
     -H "Content-Type: application/json" \
     -d '{"user_id": 123, "user_name": "ivan"}'
   ```

## 📋 Описание

Приложение предоставляет REST API для получения и логирования данных пользователя
в консоль с полной документацией через Swagger UI.

## Структура проекта

```text
src/
├── main/
│   ├── java/com/example/testjson/
│   │   ├── TestJsonApplication.java    # Главный класс приложения
│   │   ├── controller/
│   │   │   └── JsonController.java     # REST контроллер
│   │   ├── service/
│   │   │   └── UserDataService.java    # Сервис для логирования
│   │   ├── dto/
│   │   │   └── UserDataDto.java        # DTO для данных пользователя
│   │   └── config/
│   │       └── OpenApiConfig.java      # Конфигурация OpenAPI/Swagger
│   └── resources/
│       └── application.yml              # Конфигурация приложения
├── pom.xml                            # Maven конфигурация
└── test-api.http                      # Файл для тестирования API
```

## ⚙️ Запуск приложения

1. **Требования:**

   - Java 21
   - Maven 3.6+

2. **Компиляция и запуск:**

   ```bash
   mvn spring-boot:run
   ```

3. **Результат:**

   - Приложение запустится на порту 8080
   - API будет доступно по адресу: <http://localhost:8080/api>
   - Swagger UI: <http://localhost:8080/swagger-ui/index.html>

## API Endpoints

### 🔄 POST /api/logData

Отправляет данные пользователя для логирования.

**Request Body:**

```json
{
  "user_id": 123,
  "user_name": "ivan"
}
```

**Response:**

```text
Данные пользователя успешно обработаны и залогированы
```

### ❤️ GET /api/health

Проверка работоспособности API.

**Response:**

```text
API работает корректно
```

## 📚 Swagger UI

Приложение включает в себя автоматически генерируемую документацию API через Swagger UI.

### 🔗 Доступ к документации

- **Swagger UI**: <http://localhost:8080/swagger-ui/index.html>
- **OpenAPI JSON**: <http://localhost:8080/api-docs>

### ✨ Возможности Swagger UI

- 📖 Интерактивная документация API
- 🧪 Тестирование endpoints прямо в браузере
- 📋 Автоматически генерируемые примеры запросов
- ✅ Валидация данных в реальном времени
- 🔍 Описание всех параметров и ответов

## 🚀 Пример использования

### Командная строка (curl)

```bash
# Отправка данных пользователя
curl -X POST http://localhost:8080/api/logData \
  -H "Content-Type: application/json" \
  -d '{"user_id": 123, "user_name": "ivan"}'

# Проверка работоспособности
curl http://localhost:8080/api/health
```

### REST Client (VS Code)

Используйте файл `test-api.http` для тестирования API прямо в VS Code
с расширением REST Client.

### Swagger UI

Откройте <http://localhost:8080/swagger-ui/index.html> в браузере
для интерактивного тестирования.

## 🛠️ Технологии

- **Spring Boot** 3.5.0
- **Java** 21
- **Maven** - управление зависимостями
- **Spring Web** - REST API
- **Spring Validation** - валидация данных
- **Lombok** - упрощение кода
- **SpringDoc OpenAPI 3** - Swagger UI
- **SLF4J** - логирование

## ✨ Особенности

- ✅ **Валидация данных** - user_id должен быть положительным,
  user_name не может быть пустым
- 🏷️ **Правильные соглашения** - camelCase в Java коде, snake_case в JSON
- 🚀 **Lombok** - автоматическая генерация геттеров, сеттеров,
  конструкторов и toString()
- 📄 **YAML конфигурация** - современный формат application.yml
- 📚 **Swagger UI** - автоматически генерируемая документация API
- 🧪 **Интерактивное тестирование** - API через веб-интерфейс
- 📝 **Логирование** - данные в консоль через SLF4J
- ⚠️ **Обработка ошибок** - валидация с помощью @ExceptionHandler
- 🌐 **CORS поддержка** - для веб-приложений
- 🏗️ **Современные практики** - Spring Boot best practices
- 🔍 **SonarQube** - соответствие стандартам качества кода
