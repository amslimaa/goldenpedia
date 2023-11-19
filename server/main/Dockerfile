FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y 

COPY . .

RUN apt-get install zip curl -y
RUN curl -s "https://get.sdkman.io" | bash
RUN sdk install gradle
RUN gradle build

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /build/libs/main-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]