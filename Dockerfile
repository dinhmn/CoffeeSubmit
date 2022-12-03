FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/Coffee-0.0.1-SNAPSHOT.jar maven-wrapper.jar
ENTRYPOINT ["java", "-jar", "maven-wrapper.jar"]