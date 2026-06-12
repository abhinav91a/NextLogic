FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Root parent pom
COPY pom.xml .

# Module files
COPY alert-service/pom.xml alert-service/pom.xml
COPY alert-service/src alert-service/src

WORKDIR /app/alert-service

RUN mvn -DskipTests package

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/alert-service/target/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","app.jar"]