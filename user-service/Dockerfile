FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Root parent pom
COPY pom.xml .

# Module files
COPY user-service/pom.xml user-service/pom.xml
COPY user-service/src user-service/src

WORKDIR /app/user-service

RUN mvn -DskipTests package

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/user-service/target/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","app.jar"]