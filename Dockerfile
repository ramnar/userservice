FROM openjdk:10-jdk
VOLUME /tmp 
ARG JAR_FILE=target/userservice1-1.jar
ADD ${JAR_FILE} userservice1.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/userservice1.jar"]