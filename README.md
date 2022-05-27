# revive

![Build](https://github.com/sachinsshetty/revive/actions/workflows/main.yml/badge.svg) ![CodeQL](https://github.com/sachinsshetty/revive/actions/workflows/codeql-analysis.yml/badge.svg)

* Technology Demonstrator based on Micro-services architecture built using ReactJS + SpringBoot for Autonomous Vehicle Tech Infrastructure (AVTI)

Current Task
* Solve jlink error related to embed tomcat to create small docker images- use alpline-linux + custom-jre instead of large sized alpine-linux + openjdk-17 

* [Blog- WIP - How to migrate project from Monolith to Microservice](https://slabstech.github.io/blog/monolith-microservice/)

###### Docker Images

| Docker Image | Tagname | Size(Mb) | Version |
|---|---|---|---|
| App | [slabstech/avti-app](https://hub.docker.com/r/slabstech/avti-app) | 229 | 1 |
| DB | [slabstech/avti-db](https://hub.docker.com/r/slabstech/avti-db) | 80.7 | 1 |

#### Tech Stack

  |Tech | Version | Status | Use Case | App Version |
  |---|---|---|---|---|
  | Java | 17 JPA | WIP |-- | 1.0 |
  | Hibernate | -- | Done |-- | 1.0 |
  | PostgreSQL | 14 | Done |-- | 1.0 |
  | Gradle | 7.4.2 | Done | Compile code build tool | 1.0 |
  | SpringBoot, MVC | 2.7.0 | Design Pattern |-- | 1.0 |
  | JUnit | 5 | Done | Unit/Integration Test | 1.0 |
  | git , Github Action | -- | Done | Version Control, CI/CD | 1.0|
  | Docker | 20 | Done | micro services deployment | 1.0 |
  | React JS | -- | Done | Front end Dashboards | 1.0 |
  | REST | -- | -- |-- | 1.0 |
  | Maven | -- | -- |-- |-- |
  | Kubernetes | -- | -- | -- |-- |
  | Jenkins | -- | -- |-- |-- |
  | Micro Services | -- | -- |-- |-- |
  | AWS | -- | -- |-- |-- |
  | Message Bus| -- |-- |-- |-- |
  | OAuth | -- | -- |-- |-- |
  | Apache Kafka | -- | -- |-- |-- |

#### Releases

  | Version | Function | Status |
  |---|---|---|
  | 1.0 | App / DB Microservice, ReactJS Dashboard | WIP |
  | 2.0 | DB, App-Microservice split into 4 entities, OAuth |  TBD |
  | 3.0 | Kafka processing| TBD |


#### Important Links

| Description | Document |
|---|---|
|Learnings from the project available at [wiki.md](https://github.com/sachinsshetty/revive/blob/main/doc/wiki.md)|[wiki.md](https://github.com/sachinsshetty/revive/blob/main/doc/wiki.md)|
|Implement the MVP in the design document [system_design.md](https://github.com/sachinsshetty/revive/blob/main/doc/system_design.md)|[system_design.md](https://github.com/sachinsshetty/revive/blob/main/doc/system_design.md)|
|Build steps maintained at the document [build.md](https://github.com/sachinsshetty/revive/blob/main/doc/build.md)|[build.md](https://github.com/sachinsshetty/revive/blob/main/doc/build.md)|
|Release notes for versions available at [release.md](https://github.com/sachinsshetty/revive/blob/main/doc/release.md)|[release.md](https://github.com/sachinsshetty/revive/blob/main/doc/release.md)|


#### Deployment

| Environment | Status | Release Version |
|---|---|---|
| Local Machine - Windows 10 | Done | 1.0 |
| Local Machine - Ubuntu | Done | 1.0 |
| Docker - alpine-linux | Done | 1.0 |

##### Build Status - Java version

| JDK | 11 | 17 | 18 |
|---|---|---|---|
| ubuntu-latest | Pass | Pass | Pass |
| windows-latest | Pass | Pass | Pass |
| macOS-latest | Pass | Pass | Pass |

* Source - [Github Actions](https://github.com/sachinsshetty/revive/actions/workflows/main.yml)

* Services
  * Vehicle , Driver , Stall, Payment
