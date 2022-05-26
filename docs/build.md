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



  * TODO :  
* Reduce java docker by using jre instead of jdk, it will save spaces. Create script which generates required customer jre.
* Use the docker-compose.yml directly to run the Application, required base images are available at https://hub.docker.com

