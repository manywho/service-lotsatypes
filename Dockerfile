FROM maven:alpine AS build

WORKDIR /usr/src/app

COPY pom.xml pom.xml

RUN mvn dependency:resolve

COPY src src

RUN mvn clean package

FROM openjdk:jre-alpine

EXPOSE 8080

COPY --from=build /usr/src/app/target/service-lotsatypes.jar /usr/src/app/target/service-lotsatypes.jar

CMD ["java", "-Xmx300m", "-jar", "/usr/src/app/target/service-lotsatypes.jar"]
