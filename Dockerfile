# Build Stage
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copy project files
COPY . .

# Build the application
RUN mvn clean install -DskipTests

# Package Stage
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar backend_task_1.jar

# Expose the application port
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "backend_task_1.jar"]

