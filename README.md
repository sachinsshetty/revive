# revive

* Autonomous Vehicle Tech Infrastructure (AVTI) for Stealth Startup

* Implement the MVP in the design document (repo/doc/system_design.md). Mock with interfaces all the extra features.

* Release notes for versions available at (repo/doc/release.md)

* Build Steps
  * Execute in terminal 'gradle wrapper'
  * Execute './gradlew bootJar'
    * This step creates an executable jar in build/libs

* Execution Steps
  * Execute in base directory './gradlew bootRun'
    * This runs the latest code directly
  * Execute in build/libs directory 'java -jar reviveJar-1.0-SNAPSHOT.jar'
    * This runs the jar file created from the build step.

* Version
	* Current  
		* ver2 : Java + SpringBoot + PostgreSQL + HibernateJPA + SpringMVC
	* Released
		* ver1 : Java + PostgreSQL + JDBC

* Currently deployed at
  * localhost

* Prerequisites :
  * Install PostgreSQL
  * Install Postman desktop

* Sample Entry into PostgreSQL DB
  * PostManAPi : Post : http://localhost:8090/avti/api/v1/drivers
      Headers -> Content-Type : application/json
	    Body : { "name" : "driverName" }
