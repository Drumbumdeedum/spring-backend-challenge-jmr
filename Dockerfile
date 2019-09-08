FROM openjdk:8-jdk
VOLUME /temp
ADD build/libs/spring-boot-docker-0.1.0.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.data.mongodb.uri=mongodb://spring-demo-mongo/contacts", "-jar","/app.jar"]