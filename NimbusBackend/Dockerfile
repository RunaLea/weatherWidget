FROM eclipse-temurin:23-jre-alpine
LABEL authors="emil"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# mvn package -DskipTests
# docker build --tag=emilvdijk/nimbusbackend .
# docker run -e "nimbus.api.secret=APIKEYHERE" -p 8080:8080 -t emilvdijk/nimbusbackend:latest