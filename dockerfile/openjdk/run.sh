#docker build --build-arg JAR_FILE=build/libs/\*.jar -t springio/gs-spring-boot-docker . -t openjdk_image && docker run --name api_app -p 8080:8080 -d openjdk_image
#docker build -t openjdk_image . && docker run --network spring_app --name api_app -p 8080:8080 -d openjdk_image
docker build -t openjdk_image . && docker run --name api_app -p 8080:8080 -d openjdk_image