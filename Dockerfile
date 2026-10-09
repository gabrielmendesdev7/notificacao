# Atualizado para 8.14 para atender aos requisitos do plugin do Spring Boot
FROM gradle:8.14-jdk21 AS build

WORKDIR /app

COPY . .

# Compila o JAR do Spring Boot ignorando os testes de integração
RUN ./gradlew bootJar -x test --no-daemon

FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copia o JAR final gerado no estágio de build
COPY --from=build /app/build/libs/*-SNAPSHOT.jar /app/notificacao.jar

EXPOSE 8084

CMD ["java", "-jar", "/app/notificacao.jar"]
