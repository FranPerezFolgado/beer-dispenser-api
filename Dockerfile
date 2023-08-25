# Use the official OpenJDK image with Java 17 as the base image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
# Expose the port that the application will run on
COPY src ./src

# Command to run the Spring Boot application
CMD ["./mvnw", "spring-boot:run", "-Dspring-boot.run.profiles=docker"]
