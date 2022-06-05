#### Stage 1: Build the react application
FROM node:16.15.0-alpine3.15 as build-revive-client-reactjs

# Configure the main working directory inside the docker image.
# This is the base directory used in any further RUN, COPY, and ENTRYPOINT
# commands.
WORKDIR /app

# Copy the package.json as well as the package-lock.json and install
# the dependencies. This is a separate step so the dependencies
# will be cached unless changes to one of those two files
# are made.
#TODO remove below line- docker build failing
COPY clients/reactjs/package.json clients/reactjs/package-lock.json ./
#COPY package.json ./
RUN npm ci
# Copy the main application
COPY clients/reactjs/. ./

COPY clients/reactjs/package.json clients/reactjs/package-lock.json ./

# Build the application
RUN npm run build

#### Stage 2: Serve the React application from Nginx
FROM nginx:stable

WORKDIR /usr/share/nginx/html


RUN rm -rf ./*

# Copy our custom nginx config
COPY docker/client/reactjs/reactjs_nginx.conf ./nginx.conf
COPY --from=build-revive-client-reactjs /app/build .
# Expose port 80 to the Docker host, so we can access it 
# from the outside.
EXPOSE 80

ENTRYPOINT ["nginx","-g","daemon off;"]
