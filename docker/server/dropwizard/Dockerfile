FROM gradle:7.4.2-jdk17-alpine AS jre-build
WORKDIR /app

COPY servers/dropwizard/ .
RUN gradle build -x test

COPY /app/build/libs/app-0.0.1.jar /app/build/app.jar

RUN jdeps --ignore-missing-deps --module-path modules --add-modules=ALL-MODULE-PATH --generate-module-info out build/app.jar
RUN jlink --add-modules ALL-MODULE-PATH --no-man-pages --no-header-files --compress=2 --output jre

# take a smaller runtime image for the final output
FROM alpine:latest as revive-server-spring-boot
WORKDIR /deployment

# copy the custom JRE produced from jlink
COPY --from=jre-build /app/jre jre

# copy the app dependencies
COPY --from=jre-build /app/build/lib/* lib/

# copy the app
COPY --from=jre-build /app/build/app.jar app.jar

EXPOSE 8080

ENTRYPOINT ["jre/bin/java", "-jar", "app.jar"]
