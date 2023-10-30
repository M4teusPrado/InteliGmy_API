FROM openjdk:17-jdk
COPY ./target/*.jar inteligmy.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./inteligmy.jar"]