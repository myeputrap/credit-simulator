# Use a base image with Java 11 runtime
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY credit-simulator.jar /app/credit-simulator.jar

# Set the entry point for the container to run the Java application
ENTRYPOINT ["java", "-jar", "/app/credit-simulator.jar"]
