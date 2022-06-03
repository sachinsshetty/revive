# revive
 
![Build](https://github.com/sachinsshetty/revive/actions/workflows/all_branch.yml/badge.svg) 
![Junit](https://github.com/sachinsshetty/revive/actions/workflows/test_unit_integration.yml/badge.svg)   
![DockerBuild](https://github.com/sachinsshetty/revive/actions/workflows/build_docker.yml/badge.svg)
![DockerHub](https://github.com/sachinsshetty/revive/actions/workflows/push_docker.yml/badge.svg)  
![CodeQL](https://github.com/sachinsshetty/revive/actions/workflows/codeql-analysis.yml/badge.svg)


### Initializor libray for Web Application with Micro-Services 

##### Execution Steps :
  * To compile code and build docker images
    * ./gradlew createAppDockerImages

  * To run the with docker-compose 
    * ./gradlew runAppDocker
  * To Run Client and Server separately
    * First build project
      * ./gradlew buildAll
    * Server
      * ./gradlew bootRun
    * Client
      * npm start

  * To Stop Application
    * ./gradlew stopAppDocker

  * Access the application at localhost:3000

      
#### Important Links

| Description | Document |
|---|---|
|Build steps maintained at the document [Build](https://github.com/sachinsshetty/revive/wiki/Build)|[Build.md](https://github.com/sachinsshetty/revive/wiki/Build)|
|Release notes for versions available at [Releases](https://github.com/sachinsshetty/revive/wiki/Release)|[Releases](https://github.com/sachinsshetty/revive/wiki/Release)|
|FAQ at [Demo](https://github.com/sachinsshetty/revive/wiki/Project-Demo-Revive)|[Demo](https://github.com/sachinsshetty/revive/wiki/Project-Demo-Revive)|
|Sprint Task available at [Sprint](https://github.com/sachinsshetty/revive/wiki/Sprint)|[Sprint](https://github.com/sachinsshetty/revive/wiki/Sprint)|
|Sprint Logs available at [Sprint_logs](https://github.com/sachinsshetty/revive/wiki/Sprint-Logs)|[Sprint_logs](https://github.com/sachinsshetty/revive/wiki/Sprint-Logs)|


###### Docker Images

| Docker Image | Tagname | Size(Mb) | Version |
|---|---|---|---|
| Server | [slabstech/revive-server](https://hub.docker.com/r/slabstech/revive-server) | 157.3 | [v2.0.0](https://github.com/sachinsshetty/revive/releases/tag/v2.0.0) |
| Client | [slabstech/revive-client](https://hub.docker.com/r/slabstech/revive-client) | 54.13 | [v2.0.0](https://github.com/sachinsshetty/revive/releases/tag/v2.0.0) |
| DB | [slabstech/revive-db](https://hub.docker.com/r/slabstech/revive-db) | 80.07 | [v2.0.0](https://github.com/sachinsshetty/revive/releases/tag/v2.0.0) |

#### Tech Stack

  |Tech | Version | Status | Use Case | App Version |
  |---|---|---|---|---|
  | Java | 17  | WIP |-- | [v2.0.0](https://github.com/sachinsshetty/revive/releases/tag/v2.0.0) |
  | Hibernate | -- | Done |-- | [v2.0.0](https://github.com/sachinsshetty/revive/releases/tag/v2.0.0) |
  | PostgreSQL | 14 | Done |-- | [v2.0.0](https://github.com/sachinsshetty/revive/releases/tag/v2.0.0) |
  | Gradle | 7.4.2 | Done | Compile code build tool | [v2.0.0](https://github.com/sachinsshetty/revive/releases/tag/v2.0.0) |
  | SpringBoot  | 2.7.0 | Done | Design Pattern | [v2.0.0](https://github.com/sachinsshetty/revive/releases/tag/v2.0.0) |
  | Thymeleaf | 2.7.0 | Deprecated | Design Pattern | [v1.0.0](https://github.com/sachinsshetty/revive/releases/tag/v1.0.0) |
  | JUnit | 5 | Done | Unit/Integration Test | [v2.0.0](https://github.com/sachinsshetty/revive/releases/tag/v2.0.0) |
  | git | 2.34.1 | Done | Version Control, CI/CD | [v2.0.0](https://github.com/sachinsshetty/revive/releases/tag/v2.0.0)|
  | Docker | 20 | Done | micro services deployment | [v2.0.0](https://github.com/sachinsshetty/revive/releases/tag/v2.0.0) |
  | Custom JRE 17 | 20 | Done | micro services deployment | [v2.0.0](https://github.com/sachinsshetty/revive/releases/tag/v2.0.0) |
  | NodeJs | 16 | Done |-- | [v2.0.0](https://github.com/sachinsshetty/revive/releases/tag/v2.0.0) |
  | React JS | -- | Done | Front end Dashboards | [v2.0.0](https://github.com/sachinsshetty/revive/releases/tag/v2.0.0)|
  | Nginx | -- | Done | Client Server | [v2.0.0](https://github.com/sachinsshetty/revive/releases/tag/v2.0.0) |
  | Github Actions Workflow | -- | Done | CI/CD | [v2.0.0](https://github.com/sachinsshetty/revive/releases/tag/v2.0.0) |
  | Kubernetes | -- | -- | -- |-- |
  | AWS | -- | -- |-- |-- |
  | Message Bus| -- |-- |-- |-- |
  | OAuth | -- | -- |-- |-- |
  | Apache Kafka | -- | -- |-- |-- |

* Outcome
  * [Blog- WIP - How to migrate project from Monolith to Microservice](https://slabstech.github.io/blog/monolith-microservice/)
