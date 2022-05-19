# revive

* Target - Autonomous Vehicle Tech Infrastructure (AVTI) for Stealth Startup

* Implement the MVP in the design document (repo/doc/system_design.md). Mock with interfaces all the extra features.

* Release notes for versions available at (repo/doc/release.md)

* Execution Steps
  * Run in Terminal the command 'gradle wrapper'
  * Execute './gradlew bootRun'

* Version
	* Current  
		* ver2 : Java + SpringBoot + PostgreSQL + HibernateJPA + SpringMVC
	* Released
		* ver1 : Java + PostgreSQL + JDBC

Currently deployed at
  * localhost

### Prerequisites : 
* Install PostgreSQL
* Install Postman desktop
	* PostManAPi : Post : http://localhost:8090/avti/api/v1/drivers 
	Headers -> Content-Type : application/json
	Body : { "name" : "driverName" }
	
* Classes
  * Vehicle
  * Charging Stall
  * Route Map
  * Payment - income from Driver, expense to PowerProvider
  * ServiceCenter
  * Rent/Lease
  * Insurance
  * Recycle
