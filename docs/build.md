### Build

* Steps
  * Docker
    * Build Steps
      * In the base directory , Execute in terminal 'gradle wrapper'
      * Execute './gradlew bootJar -x test'
        * This step creates an executable jar in build/libs

      * In the src/main/docker/java directory
        * Copy the generated jar to the current directory.
        * Execute the command "docker build -t docker-avti-java ."
      * In the src/main/docker/db directory
        * Execute the command "docker build -t docker-avti-db ."

    * Execution Step
      * In the base directory, Execute in terminal "docker-compose up"
      * Use the command 'docker inspect JavaAppcontainerID' to find ip of the docker instance.
      * Access the Application with link "DockerIp:8080"

  * Standalone
    * Build Steps
      * Execute in terminal 'gradle wrapper'
      * Execute './gradlew bootJar'
        * This step creates an executable jar in build/libs

    * Execution Steps
      * Execute in base directory './gradlew bootRun'
        * This runs the latest code directly
      * Execute in build/libs directory 'java -jar reviveJar-1.0-SNAPSHOT.jar'
        * This runs the jar file created from the build step.
      * Access the Application with link "localhost:8080"


* Sample Entry into PostgreSQL DB
  * Curl command :
  * PostManAPi : Post : http://localhost:8080/avti/api/drivers
      Headers -> Content-Type : application/json
	    Body : raw :  : { "name" : "driverName" }


* Prerequisites :
* Install PostgreSQL



Custom JRE 
* jdeps to find dependency of app.jar 
  * RUN jdeps --ignore-missing-deps --module-path modules --add-modules=ALL-MODULE-PATH --generate-module-info out build/app.jar
* jlink to generate jre with all module dependencies
  * RUN jlink --add-modules ALL-MODULE-PATH --no-man-pages --no-header-files --compress=2 --output jre 

* Use the docker-compose.yml directly to run the Application, required base images are available at https://hub.docker.com





* React Build
  * npx create-react-app frontend    
  * cd frontend     
  * npm install --save bootstrap@5.1 react-cookie@4.1.1 react-router-dom@5.3.0 reactstrap@8.10.0
  * npm start
  * npm run build
  * Use the github gradle runner to execute the build task only currently
    * TODO - Use the trigger to create docker images and push to docker hub + AWS deploy on commit


    * Build tool - Gradle for SpringBoot
        * ReactJS build is triggered by calleding npm install and npm run build.
    TODO - Using Github actions Gradle Runner to build jars currently by targering build task in main.yml +
        * Target it trigger buildDocker task in current form as it compliments Continous Integration, runDocker task can be tested for verification in target Cloud deployment,

    Current build does the following step
        * Build springboot application uber jar
        * In a docker container, it creates module-info.java for mapping dependencies on appication.jar & using jlink it creates a customer JRE as the ouput of the first interstitial docker container. 
        * On bare metal alpine-linux image, customer jre with module dependencies and the application jar are copied to the image.
        * The build is tagged frm gradle based on dockerHubRepoName:tagversiom