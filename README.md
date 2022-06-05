# revive
 
![Build](https://github.com/sachinsshetty/revive/actions/workflows/all_branch.yml/badge.svg) 
![Junit](https://github.com/sachinsshetty/revive/actions/workflows/test_unit_integration.yml/badge.svg)   
![DockerBuild](https://github.com/sachinsshetty/revive/actions/workflows/build_docker.yml/badge.svg)
![DockerPush-DB](https://github.com/sachinsshetty/revive/actions/workflows/push_docker_db.yml/badge.svg)  
![DockerPush-server](https://github.com/sachinsshetty/revive/actions/workflows/push_docker_server.yml/badge.svg)
![DockerPush-client](https://github.com/sachinsshetty/revive/actions/workflows/push_docker_client.yml/badge.svg)
![CodeQL](https://github.com/sachinsshetty/revive/actions/workflows/codeql-analysis.yml/badge.svg)


### Template library for RESTful Web Application with Micro-Services 

##### Execution Steps :
  * To compile code and build docker images
    * ./gradlew createAppDockerImages

  * To run the with docker-compose 
    * ./gradlew runAppDocker
  * To Run Client and Server separately
    * Server
      * ./gradlew runServer
    * Client
      * /gradlew runClient
  * To Stop Application
    * ./gradlew stopAppDocker

  * Access the application at localhost:3000

      
#### Important Links
* Documents maintained at Wiki - [https://github.com/sachinsshetty/revive/wiki](https://github.com/sachinsshetty/revive/wiki)

| Description                                                                   | Document                                                             |
|-------------------------------------------------------------------------------|----------------------------------------------------------------------|
| For Build steps                                                               | [Build](https://github.com/sachinsshetty/revive/wiki/Build)          |
| For Release notes                                                             | [Releases](https://github.com/sachinsshetty/revive/wiki/Release)     |
| FAQs | [FAQ](https://github.com/sachinsshetty/revive/wiki/Project-Demo-Revive) |
| For Sprint Task                                                               | [Sprint](https://github.com/sachinsshetty/revive/wiki/Sprint)        |
| For Sprint Logs                                                               | [Sprint_logs](https://github.com/sachinsshetty/revive/wiki/Sprint-Logs) |


###### Docker Images

| Docker Image | Tagname | Size(Mb) | Version                                                               |
|---|---|---|-----------------------------------------------------------------------|
| Server | [slabstech/revive-server](https://hub.docker.com/r/slabstech/revive-server) | 157.3 | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |
| Client | [slabstech/revive-client](https://hub.docker.com/r/slabstech/revive-client) | 54.13 | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |
| DB | [slabstech/revive-db](https://hub.docker.com/r/slabstech/revive-db) | 80.07 | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |

#### Tech Stack

| Version | Client  | Server     | Database   | Cloud Deploy | 
|---------|---------|------------|------------|--------------|
| 0.0.1   | ReactJS | SpringBoot | PostgreSQL | AWS          |
| 0.0.2   | -       | DropWizard | -          | MS Azure     |



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
