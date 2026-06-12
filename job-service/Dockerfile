FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Root parent pom
COPY pom.xml .

# Module files
COPY job-service/pom.xml job-service/pom.xml
COPY job-service/src job-service/src

WORKDIR /app/job-service

RUN mvn -DskipTests package

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/job-service/target/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","app.jar"]