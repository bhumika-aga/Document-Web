FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/documentweb-0.0.1-SNAPSHOT.jar documentweb.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "documentweb.jar" ]

# FROM tomcat:9.0-jdk8-openjdk
# COPY target/myapp.war /usr/local/tomcat/webapps/
# EXPOSE 8080
# CMD ["catalina.sh", "run"]
