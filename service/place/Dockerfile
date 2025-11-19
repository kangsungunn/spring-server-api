FROM eclipse-temurin:21-jdk-ubi9-minimal
VOLUME /tmp
COPY ./build/libs/*.jar /place-service.jar
ENTRYPOINT ["java", "-jar", "/place-service.jar"]

