# AVTI - Autonomous Vehicle Transport Infrastructure

* Entities
  * Vehicle
    * Battery Management
    * Sensor Telematics
    * Driver Profile
    * Self-driving
  * Charging Stall
    * Occupancy
    * Maintenance
    * Price Management
    * Route Optimisation
  * Route Map
  * Payment - income from Driver, expense to PowerProvider
  * ServiceCenter
  * Rent/Lease
  * Insurance
  * Recycle


* Backend Infra
  * Data
    * Flow
      * Kafka topics for logging
    * Storage
      * Postgres / SQLite for Driver Info
      * MongoDB for unstructured data
        * Camera Sensor information
  * Deployment
    * AWS
    * Github for code
    * GSM / Cellular  - Mock with Interfaces
