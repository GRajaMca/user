FROM openjdk:8-jre-alpine
ADD target/app.jar /home/app.jar
WORKDIR "/home"
EXPOSE 9112
CMD ["java", "-Dspring.application.name=userapp", "-Xmx512m", "-jar", "./app.jar"]
