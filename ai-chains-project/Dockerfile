FROM eclipse-temurin:21-jre-alpine3.19

RUN apk add --no-cache tzdata
ENV TZ=Europe/Moscow

WORKDIR /app

COPY target/ai-chains-project-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
