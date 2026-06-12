FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Root parent pom
COPY pom.xml .

# Module files
COPY api-gateway/pom.xml api-gateway/pom.xml
COPY api-gateway/src api-gateway/src

WORKDIR /app/api-gateway

RUN mvn -DskipTests package

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/api-gateway/target/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","app.jar"]