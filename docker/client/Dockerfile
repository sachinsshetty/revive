#### Stage 2: Serve the React application from Nginx 
FROM nginx:stable

WORKDIR /usr/share/nginx/html


RUN rm -rf ./*

# Copy our custom nginx config
COPY reactjs_nginx.conf ./nginx.conf
COPY --from=build-revive-client /app/build .
# Expose port 80 to the Docker host, so we can access it 
# from the outside.
EXPOSE 80

ENTRYPOINT ["nginx","-g","daemon off;"]
