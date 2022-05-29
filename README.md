# revive

![Build](https://github.com/sachinsshetty/revive/actions/workflows/main.yml/badge.svg) ![CodeQL](https://github.com/sachinsshetty/revive/actions/workflows/codeql-analysis.yml/badge.svg)

* Device Management Starter Library based on Multi-service architecture using Docker + ReactJS + SpringBoot + Postgres


###### Sprint

1. Create CI/CD Pipeline + ver1 - SpringBoot + Thymeleaf
2. ver2- SpringBoot + ReactJS
3. Cloud Deploy
4. Automation Testing
5. Algorithm Implementation

  See [sprint.md](https://github.com/sachinsshetty/revive/blob/main/docs/sprint.md) for detailed tasks

  * Current Sprint Task
     * 2.2 Create Docker Image for ReactApp - Build failure due to connection issue

###### Docker Images

| Docker Image | Tagname | Size(Mb) | Version |
|---|---|---|---|
| Server | [slabstech/revive-server](https://hub.docker.com/r/slabstech/revive-server) | 160 | [v2.0.0](https://github.com/sachinsshetty/revive/releases/tag/v2.0.0) |
| Client | [slabstech/revive-client](https://hub.docker.com/r/slabstech/revive-client) | 160 | [v2.0.0](https://github.com/sachinsshetty/revive/releases/tag/v2.0.0) |
| DB | [slabstech/revive-db](https://hub.docker.com/r/slabstech/revive-db) | 80.7 | [v2.0.0](https://github.com/sachinsshetty/revive/releases/tag/v2.0.0) |


Execution Steps :
* In base folder ,
  * ./gradlew runDocker
* Execute scripts/findIPAddress.sh to locate IP webserver

* In browser :
  * for homepage : http://IpAddress:8080
  * for droiver info : http://IpAddress:8080/api/drivers


#### Tech Stack

  |Tech | Version | Status | Use Case | App Version |
  |---|---|---|---|---|
  | Java | 17  | WIP |-- | [v1.0.0](https://github.com/sachinsshetty/revive/releases/tag/v1.0.0) |
  | Hibernate | -- | Done |-- | [v1.0.0](https://github.com/sachinsshetty/revive/releases/tag/v1.0.0) |
  | PostgreSQL | 14 | Done |-- | [v1.0.0](https://github.com/sachinsshetty/revive/releases/tag/v1.0.0) |
  | Gradle | 7.4.2 | Done | Compile code build tool | [v1.0.0](https://github.com/sachinsshetty/revive/releases/tag/v1.0.0) |
  | SpringBoot + Thymeleaf | 2.7.0 | Design Pattern |-- | [v1.0.0](https://github.com/sachinsshetty/revive/releases/tag/v1.0.0) |
  | JUnit | 5 | Done | Unit/Integration Test | 2.0 |
  | git , Github Action | -- | Done | Version Control, CI/CD | [v1.0.0](https://github.com/sachinsshetty/revive/releases/tag/v1.0.0)|
  | Docker | 20 | Done | micro services deployment | [v1.0.0](https://github.com/sachinsshetty/revive/releases/tag/v1.0.0) |
  | Custom JRE 17 | 20 | Done | micro services deployment | [v1.0.0](https://github.com/sachinsshetty/revive/releases/tag/v1.0.0) |
  | NodeJs | 16 | Done |-- | 2.0 |
  | React JS | -- | Done | Front end Dashboards | 2.0 |
  | Nginx | -- | Done | Client Server | 2.0 |
  | REST | -- | -- |-- | 1.0 |
  | Maven | -- | -- |-- |-- |
  | Kubernetes | -- | -- | -- |-- |
  | Jenkins | -- | -- |-- |-- |
  | Micro Services | -- | -- |-- |-- |
  | AWS | -- | -- |-- |-- |
  | Message Bus| -- |-- |-- |-- |
  | OAuth | -- | -- |-- |-- |
  | Apache Kafka | -- | -- |-- |-- |

#### Important Links

| Description | Document |
|---|---|
|Learnings from the project available at [wiki.md](https://github.com/sachinsshetty/revive/blob/main/docs/wiki.md)|[wiki.md](https://github.com/sachinsshetty/revive/blob/main/doc/wiki.md)|
|Implement the MVP in the design document [system_design.md](https://github.com/sachinsshetty/revive/blob/main/docs/system_design.md)|[system_design.md](https://github.com/sachinsshetty/revive/blob/main/doc/system_design.md)|
|Build steps maintained at the document [build.md](https://github.com/sachinsshetty/revive/blob/main/docs/build.md)|[build.md](https://github.com/sachinsshetty/revive/blob/main/doc/build.md)|
|Release notes for versions available at [release.md](https://github.com/sachinsshetty/revive/blob/main/docs/release.md)|[release.md](https://github.com/sachinsshetty/revive/blob/main/doc/release.md)|
|FAQ at [answers.md](https://github.com/sachinsshetty/revive/blob/main/docs/answers.md)|[answer.md](https://github.com/sachinsshetty/revive/blob/main/docs/answers.md)|

#### Deployment

| Environment | Status | Release Version |
|---|---|---|
| Local Machine - Ubuntu | Done | 1.0 |
| Docker - alpine-linux | Done | 1.0 |

##### Build Status - Java version - GithubRunner

| JDK | 11 | 17 | 18 |
|---|---|---|---|
| ubuntu-latest | Pass | Pass | Pass |
| windows-latest | Pass | Pass | Pass |
| macOS-latest | Pass | Pass | Pass |

* Source - [Github Actions](https://github.com/sachinsshetty/revive/actions/workflows/main.yml)

* Services
  * User, Device

* Outcome
  * [Blog- WIP - How to migrate project from Monolith to Microservice](https://slabstech.github.io/blog/monolith-microservice/)
