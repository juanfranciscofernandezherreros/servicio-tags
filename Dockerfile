FROM openjdk:8
VOLUME /tmp
ADD ./target/tags-2.1.2.RELEASE.jar servicio-tags.jar
ENTRYPOINT ["java","-jar","/servicio-categorias.jar"]