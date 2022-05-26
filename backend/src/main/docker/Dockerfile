####
# This Dockerfile is used to package the yak-server application
#
# Build the image with:
#
# ./gradlew buildDocker
#
###

FROM openjdk:17-alpine AS jre-build
WORKDIR /app

# copy the dependencies into the docker image
COPY build/lib/* build/lib/

# copy the executable jar into the docker image
COPY build/libs/app-*.jar build/app.jar

# tempoarily test our JAR works when we run the image
WORKDIR /app/build
ENTRYPOINT java -jar app.jar
