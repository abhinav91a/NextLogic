FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Root parent pom
COPY pom.xml .

# Module files
COPY pom.xml .
COPY eureka-server/pom.xml eureka-server/pom.xml
COPY eureka-server/src eureka-server/src

WORKDIR /app/eureka-server

RUN mvn -DskipTests package

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/eureka-server/target/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","app.jar"]