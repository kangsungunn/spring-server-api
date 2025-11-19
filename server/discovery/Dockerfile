FROM eclipse-temurin:21-jdk-ubi9-minimal
VOLUME /tmp
COPY ./server/discovery/build/libs/*.jar /discovery-service.jar
ENTRYPOINT ["java", "-jar", "/discovery-service.jar"]

