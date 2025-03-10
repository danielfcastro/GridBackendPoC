# Use image base with java and gradle
FROM gradle:8.5.0-jdk17 AS build

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build --no-daemon

#Execute migrations
RUN gradle flywayMigrate --no-daemon

# Use image base
FROM openjdk:17-jdk

#COPY build artifact to app image
COPY --from=build /home/gradle/src/build/libs/GridBackEndPoC-0.0.1-SNAPSHOT.jar /app/demo.jar

#Define command to run app
ENTRYPOINT ["java", "-jar", "/app/demo.jar"]