FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
ENV PORT 8080
EXPOSE 8080
COPY target/todo-service-1.0-SNAPSHOT.jar todo-service-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "todo-service-1.0-SNAPSHOT.jar"]
