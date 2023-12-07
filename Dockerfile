FROM openjdk:11
COPY target/your-project.jar /app.jar
CMD ["java", "-jar", "/app.jar"]