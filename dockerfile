# Use a imagem OpenJDK 17 como base
FROM maven:3.8.4 AS build
COPY . /app
WORKDIR /app
RUN mvn clean install

FROM openjdk:17-jdk
COPY --from=build /app/target/*.jar /app/inteligmy.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app/inteligmy.jar"]

## Use a imagem base do PostgreSQL
#FROM postgres:latest
## Copie o arquivo de inicialização para o diretório de inicialização do PostgreSQL
#COPY init.sql /docker-entrypoint-initdb.d/
## Defina permissões para o script de inicialização
#RUN chmod +x /docker-entrypoint-initdb.d/init.sql