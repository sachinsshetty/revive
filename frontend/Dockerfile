#### Stage 1: Build the react application
FROM node:16.15.0-alpine3.15 as build

# Configure the main working directory inside the docker image. 
# This is the base directory used in any further RUN, COPY, and ENTRYPOINT 
# commands.
WORKDIR /app

# Copy the package.json as well as the package-lock.json and install 
# the dependencies. This is a separate step so the dependencies 
# will be cached unless changes to one of those two files 
# are made.
COPY package.json package-lock.json ./
RUN npm ci --prod
# Copy the main application
COPY . ./app



# Build the application
RUN npm run build

#### Stage 2: Serve the React application from Nginx 
FROM nginx:stable

# Copy the react build from Stage 1
COPY --from=build /build /usr/share/nginx/html

# Copy our custom nginx config
COPY nginx.conf /etc/nginx/nginx.conf

# Expose port 80 to the Docker host, so we can access it 
# from the outside.
EXPOSE 80

ENTRYPOINT ["nginx","-g","daemon off;"]