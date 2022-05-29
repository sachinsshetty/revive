### Build
* Steps
  * Docker
    * Build Steps
      * In the base directory , Execute in terminal 'gradle wrapper'
      * Execute './gradlew bootJar -x test'
        * This step creates an executable jar in build/libs

      * In the docker/client directory
        * Execute the command "docker build -t slabstech/revive-client:2.0 ."
      * In the docker/db directory
        * Execute the command "docker build -t slabstech/revive-db:2.0 ."
      * In the docker/server directory
        * Execute the command "docker build -t slabstech/revive-server:2.0 ."


    * Execution Step
      * In the base directory, Execute in terminal "docker-compose up"
      * Use the command 'docker inspect JavaAppcontainerID' to find ip of the docker instance.
      * Access the Application with link "DockerIp:8080"


    * Standalone 
      * Execution Steps
        * Execute in base directory './gradlew bootRun'
          * This runs the latest code directly
        * In another terminal , Execute in client directory
          * npm start
        


  * Detailed Infomation :
      * Current server build does the following step
        * Build springboot application uber jar
        * In a docker container, it creates module-info.java for mapping dependencies on appication.jar & using jlink it creates a customer JRE as the ouput of the first interstitial docker container. 
        * On bare metal alpine-linux image, customer jre with module dependencies and the application jar are copied to the image.
        * The build is tagged frm gradle based on dockerHubRepoName:tagversiom
        
      * Steps to create Custom JRE 
        * jdeps to find dependency of app.jar 
          * RUN jdeps --ignore-missing-deps --module-path modules --add-modules=ALL-MODULE-PATH --generate-module-info out build/app.jar
        * jlink to generate jre with all module dependencies
          * RUN jlink --add-modules ALL-MODULE-PATH --no-man-pages --no-header-files --compress=2 --output jre 


      * React Build
        * npx create-react-app frontend    
        * cd frontend     
        * npm install --save bootstrap@5.1 react-cookie@4.1.1 react-router-dom@5.3.0 reactstrap@8.10.0
        * npm start
        * npm run build


        * Build tool - Gradle for React JS
            * ReactJS build is triggered by calleding npm ci and npm run build.

            * Target it to trigger buildDocker task in current form as it compliments Continous Integration, runDocker task can be tested for verification in target Cloud deployment.
            

* Pre-Requisites - 

* Required Software to Install
  * Node
    * curl -fsSL https://deb.nodesource.com/setup_16.x | sudo -E bash -

    * sudo apt-get install -y nodejs


  * PostgreSQL
    * PostgreSQL status check

    * sudo systemctl is-active postgresql

    * sudo systemctl is-enabled postgresql

    * sudo systemctl status postgresql

    * sudo pg_isready
    * Creating database
        * sudo su - postgres
        * psql
          * CREATE USER db_user WITH PASSWORD 'db_pswd';
          * CREATE DATABASE user_db;
          * GRANT ALL PRIVILEGES ON DATABASE user_db to db_user;

      * sudo /usr/pgadmin4/bin/setup-web.sh

    * Docker 

    * Java 
