FROM eclipse-temurin:21-jdk-ubi9-minimal
VOLUME /tmp
COPY ./service/user/build/libs/*.jar /user-service.jar
ENTRYPOINT ["java", "-jar", "/user-service.jar"]