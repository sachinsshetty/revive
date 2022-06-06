# revive


![Build](https://github.com/sachinsshetty/revive/actions/workflows/all_branch.yml/badge.svg)
![CodeQL](https://github.com/sachinsshetty/revive/actions/workflows/codeql-analysis.yml/badge.svg)

#### Status

| Docker Image        | Docker Hub Repo                                                                                     | Github Package Registry                                                                                       |     Size(Mb)                                       | Status                                                                        |
|---------------------|-----------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------|-------------------------------------------------------------------------------|
| Server - SpringBoot | [slabstech/revive-server-spring-boot](https://hub.docker.com/r/slabstech/revive-server-spring-boot) | [revive-server-spring-boot](https://github.com/sachinsshetty/revive/pkgs/container/revive-server-spring-boot) |157.3    | ![SpringBoot](https://github.com/sachinsshetty/revive/actions/workflows/push_docker_server_spring_boot.yml/badge.svg) |
| Server - Dropwizard | [slabstech/revive-server-dropwizard](https://hub.docker.com/r/slabstech/revive-server-dropwizard)   | [revive-server-dropwizard](https://github.com/sachinsshetty/revive/pkgs/container/revive-server-dropwizard)   |109.2    | ![Dropwizard](https://github.com/sachinsshetty/revive/actions/workflows/push_docker_server_dropwizard.yml/badge.svg)|
| Client - ReactJS    | [slabstech/revive-client-reactjs](https://hub.docker.com/r/slabstech/revive-client-reactjs)         | [revive-client-reactjs](https://github.com/sachinsshetty/revive/pkgs/container/revive-client-reactjs)         |54.13    | ![ReactJS](https://github.com/sachinsshetty/revive/actions/workflows/push_docker_client_reactjs.yml/badge.svg) |
| DB - PostgreSQL     | [slabstech/revive-db-postgresql](https://hub.docker.com/r/slabstech/revive-db-postgresql)           | [revive-db-postgresql](https://github.com/sachinsshetty/revive/pkgs/container/revive-db-postgresql)           |80.07    | ![PostgreSQL](https://github.com/sachinsshetty/revive/actions/workflows/push_docker_db_postgresql.yml/badge.svg) |




### Template library for RESTful Web Application with Micro-Services 

##### Execution Steps :
| Step                                           | Command                                    | Description                             |
|------------------------------------------------|--------------------------------------------|-----------------------------------------|
| Build Image: SpringBoot + PostgreSQL + ReactJS | ./gradlew createAppDockerImages_springboot | To compile code and build docker images |
| Build Image: Dropwizard + PostgreSQL + ReactJS | ./gradlew createAppDockerImages_dropwizard | To compile code and build docker images |
| Run: SpringBoot + PostgreSQL + ReactJS         | ./gradlew runAppDocker_springboot          | To run with docker-compose              |
| Run: Dropwizard + PostgreSQL + ReactJS         | ./gradlew runAppDocker_dropwizard          | To run with docker-compose              |
| Stop: SpringBoot + PostgreSQL + ReactJS        | ./gradlew stopAppDocker_springboot         | To Stop Docker Run                      |
| Stop: Dropwizard + PostgreSQL + ReactJS        | ./gradlew stopAppDocker_dropwizard         | To Stop Docker Run                      |
| Run : Spring Boot Server                       | ./gradlew runSpringBootServer              | Run Server Spring Boot                  |
| Run : ReactJS Client                           | ./gradlew runReactJSClient                 | Run Client ReactJS                      |
| Run : Dropwizard Server                        | ./gradlew runDropwizardServer      | Run Server Dropwizard                   |

* Access the application at localhost:3000


#### Important Links
* Documents maintained at Wiki - [https://github.com/sachinsshetty/revive/wiki](https://github.com/sachinsshetty/revive/wiki)

| Description       | Document                                                                |
|-------------------|-------------------------------------------------------------------------|
| For Build steps   | [Build](https://github.com/sachinsshetty/revive/wiki/Build)             |
| For Release notes | [Releases](https://github.com/sachinsshetty/revive/wiki/Release)        |
| FAQs              | [FAQ](https://github.com/sachinsshetty/revive/wiki/Project-Demo-Revive) |
| For Sprint Task   | [Sprint](https://github.com/sachinsshetty/revive/wiki/Sprint)           |
| For Sprint Logs   | [Sprint_logs](https://github.com/sachinsshetty/revive/wiki/Sprint-Logs) |
| Project roadmap   | [Roadmap](https://github.com/sachinsshetty/revive/projects/1)           |


#### Tech Stack

| Version | Client  | Server     | Database   | Cloud Deploy | 
|---------|---------|------------|------------|--------------|
| 0.0.1   | ReactJS | SpringBoot | PostgreSQL | MS Azure   |
| 0.0.2   | ---     | DropWizard | ---        | AWS     |


| Tech                 | Version | Status  | Use Case                  | App Version                                                           |
|----------------------|---------|---------|---------------------------|-----------------------------------------------------------------------|
| Java                 | 17      | Done    | Programming Language      | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |
| JUnit                | 4       | Done    | Unit/Integration Test     | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |
| git + Github Actions | 2.34.1  | Done    | Version Control, CI/CD    | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |
| Docker               | 20      | Done    | Micro services deployment | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |
| Custom JRE           | 17      | Done    | Reduce Server Size        | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |
| NodeJs               | 16      | Done    | Client Framework          | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |
| Nginx                | 1.22    | Done    | Client Server             | [v0.0.1](https://github.com/sachinsshetty/revive/releases/tag/v0.0.1) |
| Kubernetes           | --      | --      | Container Orchestration   | --                                                                    |
| OAuth / Okta         | --      | --      | Authentication            | --                                                                    |
| Apache Kafka         | --      | --      | Message Queue             | --                                                                    |
| Microsoft Azure      | --      | --      | Cloud Deployment          | --                                                                    |


* Outcome
  * [Blog- WIP - How to migrate project from Monolith to Microservice](https://slabstech.github.io/blog/monolith-microservice/)

#### Sponsors


Revive is awaiting Sponsors for creating more templates


#### Currently being develops with 

* IntelliJ Idea Trial Licences
* VMWare WorkstationPlayer 16
* Github
