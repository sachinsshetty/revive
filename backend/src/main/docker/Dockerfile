####
# This Dockerfile is used to package the yak-server application
#
# Build the image with:
#
# ./gradlew buildDocker
#
###

RUN jdeps --ignore-missing-deps --module-path modules --add-modules=ALL-MODULE-PATH --generate-module-info out build/app.jar
RUN jlink --add-modules ALL-MODULE-PATH --no-man-pages --no-header-files --compress=2 --output jre 

# take a smaller runtime image for the final output
FROM alpine:latest
WORKDIR /deployment

# copy the custom JRE produced from jlink
COPY --from=jre-build /app/jre jre

# copy the app dependencies
COPY --from=jre-build /app/build/lib/* lib/

# copy the app
COPY --from=jre-build /app/build/app.jar app.jar

# run the app on startup
ENTRYPOINT jre/bin/java -jar app.jar


# tempoarily test our JAR works when we run the image
#WORKDIR /app/build
#ENTRYPOINT java -jar app.jar
