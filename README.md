# revive

![Build](https://github.com/sachinsshetty/revive/actions/workflows/main.yml/badge.svg) ![CodeQL](https://github.com/sachinsshetty/revive/actions/workflows/codeql-analysis.yml/badge.svg) 

* Simulation for Autonomous Vehicle Tech Infrastructure (AVTI)

* Learnings from the project available at [Wiki](https://github.com/sachinsshetty/revive/blob/main/doc/wiki.md)

* Implement the MVP in the design document [System Design](https://github.com/sachinsshetty/revive/blob/main/doc/system_design.md). Mock with interfaces all the extra features.

* Release notes for versions available at [Releases](https://github.com/sachinsshetty/revive/blob/main/doc/release.md)

* Currently deployed and tested at
  * Local Machine
    * Windows 10
    * Ubuntu 22
  * Docker
    * Ubuntu

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

* Note : Use the docker-compose.yml directly to run the Application, required base images are available at https://hub.docker.com

* Docker Images
  * avti-app : openjdk:17-alpine :  229 Mb
  * avti-db : postgres:alpine3.15 : 80.7 Mb
    * Reduce java docker by using jre instead of jdk, it will save spaces. Create script which generates required customer jre.

* Prerequisites :
  * Install PostgreSQL
  * Install Postman desktop

*  Final Tech Stack (Proposed)

  |Tech | Ver | Use Case |
  |---|---|---|
  | Java | 17  | -- |
  | Hibernate | -- | -- |
  | PostgreSQL | 14 | -- |
  | Gradle | 7.4.2 | Compile Code |
  | SpringBoot, MVC | 2.7.0 | Design Pattern |
  | JUnit | 5 | Unit/Integration Test |
  | git , Github Action | Version Control, CI/CD | -- |
  | REST | -- | -- |
  | Maven | -- | -- |
  | Docker | 20 | micro service deployment |
  | Kubernetes | -- | container orchestration |
  | Jenkins | -- | -- |
  | Micro Services | -- | -- |
  | AWS | -- | -- |
  | Message Bus| -- |-- |
  | OAuth | -- | -- |
  | Apache Kafka | -- | -- |
  | Dashboard | -- | -- |

* Release Version
	* Current  
		* 1.0
      * Tech Stack

      |Tech | Status |
      |---|---|
      | Java | Done |
      | Hibernate | Done |
      | PostgreSQL | Done |
      | Gradle | Done |
      | SpringBoot+MVC | Done |
      | JUnit | Done |
      | git + Github Action | WIP |
      | REST | Done |
      | Docker | Done |

      * Entity
        * Vehicle , Driver , Stall, Payment
  * Released


* Sample Entry into PostgreSQL DB
  * Curl command :
  * PostManAPi : Post : http://localhost:8080/avti/api/drivers
      Headers -> Content-Type : application/json
	    Body : raw :  : { "name" : "driverName" }
