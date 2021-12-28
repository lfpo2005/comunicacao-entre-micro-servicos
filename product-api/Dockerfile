FROM maven:3.8.4-jdk-11
VOLUME /tmp
ADD ./target/product-api-0.0.1-SNAPSHOT.jar product-api.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/product-api.jar"]
