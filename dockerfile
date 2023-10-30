# Use a imagem OpenJDK 17 como base
FROM maven:3.8.4 AS build
COPY . /app
WORKDIR /app
RUN mvn clean install

FROM openjdk:17-jdk
COPY --from=build /app/target/*.jar /app/inteligmy.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app/inteligmy.jar"]