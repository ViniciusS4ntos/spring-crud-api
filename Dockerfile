# Pegar a imagem do  java
FROM eclipse-temurin:21-jdk-alpine

# Criar  uma  pasta dentro do container
WORKDIR /app

# Bota o .jar na pasta correta
COPY target/spring-crud-api-0.0.1-SNAPSHOT.jar /app/spring-crud-api-0.0.1-SNAPSHOT.jar

#Porta exposta
EXPOSE 8080

# Comandos cmd
CMD ["java", "-jar", "spring-crud-api-0.0.1-SNAPSHOT.jar"]
