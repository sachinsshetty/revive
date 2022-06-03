#### Stage 1: Build the react application
FROM node:16.15.0-alpine3.15 as build-revive-client

# Configure the main working directory inside the docker image. 
# This is the base directory used in any further RUN, COPY, and ENTRYPOINT 
# commands.
WORKDIR /app

# Copy the package.json as well as the package-lock.json and install 
# the dependencies. This is a separate step so the dependencies 
# will be cached unless changes to one of those two files 
# are made.
#TODO remove below line- docker build failing
COPY package.json package-lock.json ./
#COPY package.json ./
RUN npm ci
# Copy the main application
COPY . ./



# Build the application
RUN npm run build
