#Remover todos continer e images de uma vez
# docker rm $(docker ps -qa)
#Remover todas images
# docker rmi $(docker images -q)

#FROM openjdk:8-jdk-alpine AS build

#MAINTAINER Fabiano Santos <fabiodeveloperti@gmail.com>
#docker build -t myorg/myapp .
#docker run -p 8080:8080 myorg/myapp

#docker run -ti --entrypoint /bin/sh myorg/myapp
#VOLUME /tmp
# mvn clean package
# mvn clean install

#EXPOSE 8080

#COPY target/*-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
FROM maven:3.6.0-jdk-11-slim AS build

MAINTAINER Fabiano Santos <fabiodeveloperti@gmail.com>

COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/*.jar /usr/local/lib/demo.jar
EXPOSE 8080
#ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]
