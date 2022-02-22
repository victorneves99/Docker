FROM maven as build-stage

RUN mkdir -p /usr/src/app

WORKDIR /usr/src/app

ADD . /usr/src/app/

RUN mvn install


FROM openjdk:8 as production-stage

COPY --from=build-stage /usr/src/app/target/api*.jar api.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/api.jar" ]