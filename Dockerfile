FROM eclipse-temurin:19.0.1_10-jre-focal

WORKDIR /app
COPY target/sushi-app.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
