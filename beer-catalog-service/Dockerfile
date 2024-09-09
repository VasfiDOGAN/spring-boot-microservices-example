# Base image olarak JDK 8 kullanıyoruz
FROM openjdk:8-jdk-alpine

# Proje jar dosyasını container içine kopyalıyoruz
ARG JAR_FILE=target/beer-catalog-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Uygulamayı çalıştırmak için komut
ENTRYPOINT ["java", "-jar", "/app.jar"]
