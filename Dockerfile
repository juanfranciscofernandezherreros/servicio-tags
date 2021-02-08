FROM maven:3.6-jdk-8 as maven
WORKDIR /app
COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B
COPY ./src ./src
# TODO: jollof-* should be replaced with the proper prefix
RUN mvn package && cp target/tags-2.1.2.RELEASE tags-2.1.2.RELEASE
# Rely on Docker's multi-stage build to get a smaller image based on JRE
FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=maven /app/tags-2.1.2.RELEASE ./tags-2.1.2.RELEASE
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/tags-2.1.2.RELEASE"]