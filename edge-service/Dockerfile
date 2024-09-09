# 1. OpenJDK 8 tabanlı bir imaj kullanıyoruz
FROM openjdk:8-jdk-alpine

# 2. Uygulama jar dosyasını container içine kopyalıyoruz
COPY target/edge-service-0.0.1-SNAPSHOT.jar app.jar

# 3. Uygulamanın container içinde çalıştırılması
ENTRYPOINT ["java", "-jar", "/app.jar"]
