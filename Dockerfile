# Multi-stage build for smaller image size
FROM eclipse-temurin:21-jre-alpine AS runtime

# Add opentelemetry java agent
ADD ./opentelemetry-javaagent.jar /opt/opentelemetry-javaagent.jar -Dotel.metrics.exporter=none

# Create a non-root user for security
RUN addgroup -S spring && adduser -S spring -G spring

# Set working directory
WORKDIR /app

# Copy the JAR file
COPY target/spring-app-0.0.1-SNAPSHOT.jar app.jar

# Change ownership to non-root user
RUN chown spring:spring app.jar

# Switch to non-root user
USER spring:spring

# Expose port (change if your app uses a different port)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-javaagent:/opt/opentelemetry-javaagent.jar", "-jar", "app.jar"]

