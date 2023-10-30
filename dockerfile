FROM openjdk:17-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} inteligmy.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./inteligmy.jar"]