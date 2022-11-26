FROM maven:3.8.2-jdk-11
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests
EXPOSE 8080
RUN ["ls" ,"target/"]
CMD ["java", "-jar" ,"./target/property-management-portal-spring-0.0.1-SNAPSHOT.jar"]
