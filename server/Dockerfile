#FROM maven:alpine
#WORKDIR /app
#ADD pom.xml /app/
#RUN mvn verify clean --fail-never
#COPY . /app/
#RUN mvn clean package -DskipTests=true

### BUILD THE FINAL IMAGE ###

FROM openjdk:8-jdk-alpine
ENV TZ=Europe/Helsinki
RUN apk update && apk upgrade && apk add bash bash-completion tzdata curl nano nss
#COPY --from=0 /app/target/plug-0.0.1-SNAPSHOT.jar /
COPY target/plug-0.0.1-SNAPSHOT.jar /
ENTRYPOINT ["java", "-jar", "/plug-0.0.1-SNAPSHOT.jar"]