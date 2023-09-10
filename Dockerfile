FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/bms.jar bms.jar
EXPOSE 8080
CMD ["java","-jar","bms.jar"]