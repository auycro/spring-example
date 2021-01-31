#FROM openjdk:8-jdk-alpine
FROM adoptopenjdk/openjdk11:ubi
#ARG JAR_FILE=target/*.jar
ARG JAR_FILE=./*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
