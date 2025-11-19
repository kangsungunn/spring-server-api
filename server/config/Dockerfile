FROM eclipse-temurin:21-jdk-ubi9-minimal
VOLUME /tmp
COPY ./server/config/build/libs/*.jar /config-service.jar
ENTRYPOINT ["java", "-jar", "/config-service.jar"]

