FROM openjdk:10-jdk
VOLUME /tmp
ARG JAR_FILE=target/userservice-1.jar
ADD ${JAR_FILE} userservice.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/userservice.jar"]