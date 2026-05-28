#FROM maven:3.9.6-eclipse-temurin-21
#
#WORKDIR /spring
#
## 1. Copiar el pom.xml desde la subcarpeta web
#COPY pom.xml ./
#
## 2. Copiar la carpeta src desde la subcarpeta web
#COPY src ./src
#
## 3. Compilar el proyecto saltando los tests
#RUN mvn clean package -DskipTests
#
#EXPOSE 8080
#
## 4. Ejecutar el jar generado (ojo al nombre de tu .jar en target)
#CMD ["java", "-jar", "target/web-0.0.1-SNAPSHOT.jar"]

FROM maven:3.9.6-eclipse-temurin-21

WORKDIR /spring
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run