* Docker command to build an image
    * docker build -t username/imagename:version


* Dockerfile for Postgres DB
    * from db folder , execute 
      * docker build -t slabstech/revive-db:2.0 .

* Dockerfile for server
     * Execute in server folder
      * docker build -t slabstech/revive-server:2.0 .

* Dockerfile for client
    * Execute in client folder
      * docker build -t slabstech/revive-client:2.0 .

* Publish images to docker hub
    * docker push username/imagname:version
      * Ex.x
        * docker push slabstech/revive-server:2.0
        * docker push slabstech/revive-client:2.0
        * docker push slabstech/revive-db:2.0

* To run the images
    * Execute in folder containing docker-compose.yml
      * docker-compose up
    * Execute findAddress.sh to find IP appdress

* Verify in browser with containerImageIp:8080


* Extra
* To test postgres db container
    * Start a docker instance from docker_image
      * docker run --name docker_image -d postgres
      * Ex : docker run --name revive-db -d revive_run
    * Connect to postgres instance
      * docker exec -it docker_instance psql -U postgres_user
      * Ex. docker exec -it revive_run psql -U revive_db
