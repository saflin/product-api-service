FROM adoptopenjdk/openjdk11:jre-11.0.11_9-alpine
ARG JAR_FILE=build/libs/product-api-service-*.jar
COPY ${JAR_FILE} product-api-service.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/product-api-service.jar"]