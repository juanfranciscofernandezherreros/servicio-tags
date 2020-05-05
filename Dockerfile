FROM openjdk:8
VOLUME /tmp
ADD ./target/categorias-0.0.1-SNAPSHOT.jar servicio-categorias.jar
ENTRYPOINT ["java","-jar","/servicio-categorias.jar"]