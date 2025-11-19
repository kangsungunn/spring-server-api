FROM eclipse-temurin:21-jdk-ubi9-minimal
VOLUME /tmp
COPY ./server/eureka/build/libs/*.jar /eureka-service.jar
ENTRYPOINT ["java", "-jar", "/eureka-service.jar"]

