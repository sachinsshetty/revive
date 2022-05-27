* Docker command to build an image
    * docker build -t username/imagename:version


* Dockerfile for Postgres DB
    * from db folder , execute 
      * docker build -t slabstech/avti-db:2.0 .

* Dockerfile for App
     * Execute in app folder
      * docker build -t slabstech/avti-app:2.0

* Publish images to docker hub
    * docker push username/imagname:version
      * Ex.
        * docker push slabstech/avti-app:2.0
        * docker push slabstech/avti-db:2.0

* To run the images
    * Execute in folder containing docker-compose.yml
      * docker-compose up
    * Execute findAddress.sh to find IP appdress

* Verify in browser with containerImageIp:8080


* Extra
* To test postgres db container
    * Start a docker instance from docker_image
      * docker run --name docker_image -d postgres
      * Ex : docker run --name avti-db -d avti_run
    * Connect to postgres instance
      * docker exec -it docker_instance psql -U postgres_user
      * Ex. docker exec -it avti_run psql -U avti_db