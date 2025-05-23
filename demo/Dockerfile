FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

COPY target/demo-adcash.webapp-0.0.1.jar app.jar

COPY src/main/resources/static ./static

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]