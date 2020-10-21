FROM openjdk:latest
ADD target/spring-mongo.jar spring-mongo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","spring-mongo.jar"]