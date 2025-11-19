FROM eclipse-temurin:21-jdk-ubi9-minimal
VOLUME /tmp
COPY ./build/libs/*.jar /restaurant-service.jar
ENTRYPOINT ["java", "-jar", "/restaurant-service.jar"]

