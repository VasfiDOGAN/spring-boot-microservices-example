# Start with an OpenJDK base image
FROM openjdk:8-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar file into the container
COPY target/eureka-service-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose port 8761 (default Eureka server port)
EXPOSE 8761

# Set the entry point to run the jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
