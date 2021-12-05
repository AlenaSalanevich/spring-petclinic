#FROM openjdk:8-jdk-alpine

FROM ubuntu:18.04

COPY ../target/spring-petclinic-2.4.5.jar  app.jar

RUN apt update&&apt install openjdk-8-jre-headless&&apt-get install ssh

ENV JVM_OPTS="-Xmx1024m -Xms512m"

CMD  java $JVM_OPTS  -jar app.jar

EXPOSE 8088

