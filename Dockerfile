FROM openjdk:latest
COPY target/*.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]