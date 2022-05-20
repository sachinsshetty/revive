# revive

* Simulation for Autonomous Vehicle Tech Infrastructure (AVTI)

* Build Steps
  * Execute in terminal 'gradle wrapper'
  * Execute './gradlew bootJar'
    * This step creates an executable jar in build/libs

* Execution Steps
  * Execute in base directory './gradlew bootRun'
    * This runs the latest code directly
  * Execute in build/libs directory 'java -jar reviveJar-1.0-SNAPSHOT.jar'
    * This runs the jar file created from the build step.


* Currently deployed at
  * localhost

* Prerequisites :
  * Install PostgreSQL
  * Install Postman desktop


*  Final Tech Stack (Proposed)

  |Tech | Ver | Use Case |
  |--|--|--|
  | Java | 17  | . |
  | Hibernate | . | . |
  | PostgreSQL | 14 |   . |
  | Gradle | 7.4.2 | . |
  | SpringBoot, MVC | 2.7.0 | . |
  | JUnit | 5 | . |
  | git , Github Action | . | . |
  | REST | . | . |
  | Maven | . | . |
  | Docker | . | . |
  | Kubernetes | . |. |
  | Jenkins | . |. |
  | Micro Services | . |. |
  | AWS | . |. |
  | Message Bus| . |. |
  | OAuth | . |. |
  | Apache Kafka | . |. |
  | Dashboard | . |. |

* Release Version
	* Current  
		* 1.0
      * Tech Stack

      |Tech | Status |
      |--|--|
      | Java | Done |
      | Hibernate | Done |
      | PostgreSQL | Done |
      | Gradle | Done |
      | SpringBoot+MVC | Done |
      | JUnit | Done |
      | git + Github Action | WIP |
      | REST | Done |

      * Entity
        * Vehicle , Driver , Stall, Payment
  * Released


* Sample Entry into PostgreSQL DB
  * PostManAPi : Post : http://localhost:8080/avti/api/drivers
      Headers -> Content-Type : application/json
	    Body : raw :  : { "name" : "driverName" }


* Implement the MVP in the design document (repo/doc/system_design.md). Mock with interfaces all the extra features.

* Release notes for versions available at (repo/doc/release.md)
