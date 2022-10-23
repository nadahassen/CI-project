FROM openjdk:11
EXPOSE 8088
ADD target/achat-1.0-S7.jar achat-1.0-S7.jar
ENTRYPOINT ["java", "-jar", "/achat-1.0-S7.jar" ]
