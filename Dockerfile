## BUILD EXECUTABLE stage 1 ##
FROM openjdk:11-jdk AS builder
WORKDIR /usr/build
COPY src src
COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
RUN ./mvnw package -DskipTests

## EXECUTE APPLICATION stage 2 ##
FROM openjdk:11-jre
WORKDIR /usr/app
COPY --from=builder /usr/build/target/tx-services-be-challenge.jar tx-services-be-challenge.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","tx-services-be-challenge.jar"]