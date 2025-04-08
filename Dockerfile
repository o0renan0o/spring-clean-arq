FROM maven:3.8.4-openjdk-17 AS build
COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package


FROM openjdk:17.0.2-jdk-oracle
ENV TZ=America/Sao_Paulo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && \
    echo $TZ > /etc/timezone
ARG JAR_FILE=target/bff-chave.jar
COPY --from=build /home/app/target/bff-chave.jar bff-chave.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/bff-chave.jar"]