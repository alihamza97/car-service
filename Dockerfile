# Stage 1: Build Stage
# Use Maven image with Java 17 to compile and package the application
FROM maven:3.9-eclipse-temurin-17 AS build

# Set working directory inside the container
WORKDIR /app

# Copy pom.xml first for better Docker layer caching
# If dependencies don't change, this layer can be reused
COPY pom.xml .

# Copy the source code directory
COPY src ./src

# Build the application using Maven
# -B: Run in batch (non-interactive) mode
# clean: Remove previous build artifacts
# package: Compile code and create JAR file
# -DskipTests: Skip running unit tests for faster builds
RUN mvn -B clean package -DskipTests

# Stage 2: Runtime Stage
# Use lightweight JRE-only image (no Maven or JDK needed)
# This significantly reduces final image size
FROM eclipse-temurin:17-jre

# Set working directory for the runtime container
WORKDIR /app

# Copy the compiled JAR file from the build stage
# --from=build: Reference the previous build stage
# *.jar: Copy any JAR file from target directory
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080 (Spring Boot default port)
# This is documentation only; doesn't actually publish the port
EXPOSE 8080

# Define the command to run when container starts
# Runs the Spring Boot application using Java
ENTRYPOINT ["java","-jar","/app/app.jar"]
