FROM maven:3.8.3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM eclipse-temurin:17-jdk-focal
COPY --from=build  /home/app/target/escape-room-api.jar escape-room-api.jar
EXPOSE 8080