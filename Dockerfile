FROM openjdk:8-jdk-alpine

LABEL title="product-service"

COPY target/boot-test1-product-service-0.0.1-SNAPSHOT.jar /usr/src/myapp/
WORKDIR /usr/src/myapp

EXPOSE 7777

CMD ["java", "-Duser.timezone=UTC", "-jar", "boot-test1-product-service-0.0.1-SNAPSHOT.jar"]
