FROM eclipse-temurin:17-jdk-focal
ADD target/escape-room-api.jar escape-room-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "escape-room-api.jar"]