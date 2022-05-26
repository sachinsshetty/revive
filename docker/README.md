* Docker command to build an image
    * docker build -t username/imagename:version


* Dockerfile for Postgres DB
    * from db folder , execute 
      * docker build -t slabstech/avti-db:1.0 .

* Dockerfile for App
    * Copy created jar file to target java directory
    * Execute in app folder
      * docker build -t slabstech/avti-app:1.0

* Publish images to docker hub
    * docker push username/imagname:version
      * Ex.
        * docker push slabstech/avti-app:1.0
        * docker push slabstech/avti-db:1.0

* To run the images
    * Execute in folder containing docker-compose.yml
      * docker-compose up
    * Execute 'docker ps' to find container id of image running avti-app
    * Run 'docker inspect container-id' to find IP address of Apache tomcat App

* Verify in browser with containerImageIp:8080


* Extra
* To test postgres db container
    * Start a docker instance from docker_image
      * docker run --name docker_image -d postgres
      * Ex : docker run --name avti-db -d avti_run
    * Connect to postgres instance
      * docker exec -it docker_instance psql -U postgres_user
      * Ex. docker exec -it avti_run psql -U avti_db


* References
Official postgres with alpine
* https://github.com/docker-library/postgres/blob/4e56664f1797ba4cc0f5917b6d794792a5571b45/14/alpine/Dockerfile
* https://github.com/docker-library/docs/blob/master/postgres/README.md
* https://hub.docker.com/_/postgres
* https://snapshooter.com/learn/postgresql/deploy-postgres-with-docker
* https://hub.docker.com/r/cafapi/java-postgres
* https://www.baeldung.com/spring-boot-postgresql-docker
* https://hub.docker.com/_/openjdk
