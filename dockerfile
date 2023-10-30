FROM openjdk:17-jdk
COPY ./target/*.jar /app/inteligmy.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app/inteligmy.jar"]