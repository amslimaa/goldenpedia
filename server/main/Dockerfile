FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jds -y 

COPY . .

RUN apt-get install gradle -y
RUN gradle build

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /build/libs/main-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]