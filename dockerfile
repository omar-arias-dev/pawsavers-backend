FROM amazoncorretto:17.0.8-alpine
COPY target/pawsavers-0.0.1-SNAPSHOT.jar pawsavers-api.jar
ENTRYPOINT ["java", "-jar", "pawsavers-api.jar"]