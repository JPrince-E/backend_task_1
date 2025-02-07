# Build Stage
FROM maven:3.8.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy project files
COPY . .

# Build the application
RUN mvn clean install -DskipTests

# Package Stage
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar backend_task_1.jar

# Expose the application port
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "backend_task_1.jar"]
