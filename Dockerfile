FROM openjdk:8-jdk-alpine

MAINTAINER Fabiano Santos <fabiodeveloperti@gmail.com>
#docker build -t myorg/myapp .
#docker run -p 8080:8080 myorg/myapp

#docker run -ti --entrypoint /bin/sh myorg/myapp
VOLUME /tmp
#RUN mvn clean package

EXPOSE 8080

COPY target/*-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
