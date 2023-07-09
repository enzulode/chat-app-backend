FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]