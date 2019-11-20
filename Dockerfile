FROM openjdk:8-jdk-alpine as builder





#remover image força bruta $
#sudo docker rmi $(sudo docker images -aq) --force


# RUN cp /usr/src/java-code/target/*.jar ./app.jar
#
# EXPOSE 8080
#
# ENTRYPOINT ['java', ''-jar', 'app.jar']
