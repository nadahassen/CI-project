FROM openjdk:11
EXPOSE 8088
COPY target/achat-1.2.1-SNAPSHOT.jar achat-1.2.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/achat-1.2.1-SNAPSHOT.jar" ]