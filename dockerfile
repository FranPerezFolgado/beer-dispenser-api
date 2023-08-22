# Use the official OpenJDK image with Java 17 as the base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY target/beer-tap-dispenser.jar .

# Expose the port that the application will run on
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "beer-tap-dispenser.jar"]
