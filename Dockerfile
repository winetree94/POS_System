FROM ubuntu:18.04
LABEL maintainer=winetree94@outlook.com

USER root

# install dependencies
RUN apt-get update -y && \
    apt-get upgrade -y && \
    apt-get install openjdk-8-jdk curl -y


RUN mkdir /source
COPY . /source
WORKDIR /source
RUN ./mvnw package

# deploy
EXPOSE 8088
ENTRYPOINT ["java","-jar","./target/app.jar"]