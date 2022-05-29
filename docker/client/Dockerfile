#### Stage 2: Serve the React application from Nginx 
FROM nginx:stable

# Copy the react build from Stage 1
COPY --from=build-revive-client /build /usr/share/nginx/html

# Copy our custom nginx config
COPY nginx.conf /etc/nginx/nginx.conf

# Expose port 80 to the Docker host, so we can access it 
# from the outside.
EXPOSE 80

ENTRYPOINT ["nginx","-g","daemon off;"]