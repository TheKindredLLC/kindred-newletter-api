# ============================
# 1. Build stage
# ============================
FROM eclipse-temurin:24-jdk AS build

WORKDIR /app

# Copy Gradle wrapper + settings first for layer caching
COPY gradlew .
COPY gradle ./gradle
COPY settings.gradle.kts .
COPY build.gradle.kts .

# Make wrapper executable
RUN chmod +x gradlew

# Copy entire source tree (if empty, this still works)
COPY . .

# Build the application (will produce JAR in build/libs)
RUN ./gradlew clean build -x test --no-daemon

# ============================
# 2. Runtime stage
# ============================
FROM eclipse-temurin:24-jre AS runner

WORKDIR /app

# Copy final JAR from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Server listens on this port (can override with ENV)
EXPOSE 8080

# JVM flags for production
ENV JAVA_OPTS="-XX:+UseG1GC -XX:MaxRAMPercentage=75"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
