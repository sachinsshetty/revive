# revive
 
![Build](https://github.com/sachinsshetty/revive/actions/workflows/all_branch.yml/badge.svg) 
![DockerPush-DB-PostgreSQL](https://github.com/sachinsshetty/revive/actions/workflows/push_docker_db_postgresql.yml/badge.svg)  
![DockerPush-server-Dropwizard](https://github.com/sachinsshetty/revive/actions/workflows/push_docker_server_dropwizard.yml/badge.svg)
![DockerPush-server-SpringBoot](https://github.com/sachinsshetty/revive/actions/workflows/push_docker_server_spring_boot.yml/badge.svg)
![DockerPush-Client-ReactJS](https://github.com/sachinsshetty/revive/actions/workflows/push_docker_client_reactjs.yml/badge.svg)
![CodeQL](https://github.com/sachinsshetty/revive/actions/workflows/codeql-analysis.yml/badge.svg)


### Template library for RESTful Web Application with Micro-Services 

##### Execution Steps :
  * To compile code and build docker images
    * SpringBoot + PostgreSQL + ReactJS
      * ./gradlew createAppDockerImages_springboot
    * Dropwizard + PostgreSQL + ReactJS
        * ./gradlew createAppDockerImages_dropwizard

  * To run the with docker-compose 
     * SpringBoot + PostgreSQL + ReactJS
       * ./gradlew runAppDocker_springboot
     * Dropwizard + PostgreSQL + ReactJS
       * ./gradlew runAppDocker_dropwizard

  * To Stop Application
    * ./gradlew stopAppDocker_springboot or
    * ./gradlew stopAppDocker_dropwizard

  * To Build All Task
    * ./gradlew buildAllTasks

  * To Run Client and Server separately
    * Server
      * SpringBoot
        * ./gradlew servers:spring_boot:runServer
      * Dropwizard
        * ./gradlew servers:dropwizard:build
        * java -jar target/app-0.0.1.jar
    * Client
      * /gradlew clients:reactjs:runClient

  * Access the application at localhost:3000


#### Important Links
* Documents maintained at Wiki - [https://github.com/sachinsshetty/revive/wiki](https://github.com/sachinsshetty/revive/wiki)

| Description | Document                                                                |
|---|-------------------------------------------------------------------------|
| For Build steps                                                               | [Build](https://github.com/sachinsshetty/revive/wiki/Build)             |
| For Release notes                                                             | [Releases](https://github.com/sachinsshetty/revive/wiki/Release)        |
| FAQs | [FAQ](https://github.com/sachinsshetty/revive/wiki/Project-Demo-Revive) |
| For Sprint Task                                                               | [Sprint](https://github.com/sachinsshetty/revive/wiki/Sprint)           |
| For Sprint Logs                                                               | [Sprint_logs](https://github.com/sachinsshetty/revive/wiki/Sprint-Logs) |
| Project roadmap                                                               | [Roadmap](https://github.com/sachinsshetty/revive/projects/1)           |

 


###### Docker Images

| Docker Image        | Tagname                                                    | Size(Mb) | Version                                                               |
|---|------------------------------------------------------------|----------|-----------------------------------------------------------------------|
| Server - SpringBoot  | [slabstech/revive-server-spring-boot](https://hub.docker.com/r/slabstech/revive-server-spring-boot) | 157.3    | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |
| Server - Dropwizard | [slabstech/revive-server-dropwizard](https://hub.docker.com/r/slabstech/revive-server-dropwizard) | 109.2    | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |
| Client - ReactJS    | [slabstech/revive-client-reactjs](https://hub.docker.com/r/slabstech/revive-client-reactjs) | 54.13    | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |
| DB                  | [slabstech/revive-db-postgresql](https://hub.docker.com/r/slabstech/revive-db-postgresql) | 80.07    | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |


#### Tech Stack

| Version | Client  | Server     | Database   | Cloud Deploy | 
|---------|---------|------------|------------|--------------|
| 0.0.1   | ReactJS | SpringBoot | PostgreSQL | AWS          |
| 0.0.1   | -       | DropWizard | -          | MS Azure     |



|Tech | Version | Status | Use Case | App Version |
  |---------|--------|---|---|---|
  | Java | 17      | Done   |-- | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |
  | JUnit | 4       | Done | Unit/Integration Test | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |
  | git | 2.34.1  | Done | Version Control, CI/CD | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1)|
  | Docker | 20      | Done | micro services deployment | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |
  | Custom JRE 17 | 17      | Done | micro services deployment | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |
  | NodeJs | 16      | Done |-- | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |
  | Nginx | --      | Done | Client Server | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |
  | Github Actions Workflow | --      | Done | CI/CD | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |
  | Kubernetes | --      | -- | -- |-- |
  | Message Bus| --      |-- |-- |-- |
  | OAuth | --      | -- |-- |-- |
  | Apache Kafka | --      | -- |-- |-- |

* Outcome
  * [Blog- WIP - How to migrate project from Monolith to Microservice](https://slabstech.github.io/blog/monolith-microservice/)

#### Sponsors
--------

Revive is awaiting Sponsors for creating more templates


#### Currently being develops with 

* IntelliJ Idea Trial Licences
* VMWare WorkstationPlayer 16
* Github
