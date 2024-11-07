# Etapa de build
FROM gradle:7.5.1-jdk21 AS build
WORKDIR /app
COPY . .
RUN gradle clean build -x test

# Etapa de execução
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

