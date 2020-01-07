FROM openjdk:8
ADD target/docker-example.jar docker-example.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "docker-example.jar"]
