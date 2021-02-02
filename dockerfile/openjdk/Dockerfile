FROM adoptopenjdk/openjdk11:ubi as base

# Copy Everything
FROM base AS build
ARG ROOT_PROJECT=./build/libs/score-0.0.1-SNAPSHOT.jar
COPY ${ROOT_PROJECT} app.jar
ENTRYPOINT ["java","-jar","./app.jar"]