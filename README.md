# revive
 Relearning the forgotten

Target - Autonomous Vehicle Tech Infrastructure (AVTI)

Implement the MVP in the design document (repo/doc/system_design.md). Mock with interfaces all the extra features.

Tech Stack - Java, Hibernate, Postgres, MongoDB, SpringMVC
Protocol - OBD2, RestAPI, Payment

* Concepts
  * Java
    * Deployment on Linux with apache-tomcat
      * Classpath
      * config.xml
      * apache/bin
    * Hibernate
      * Tables.hbm.xml
      * config.xml
    * Core
      * Class and Interfaces
      * Record from DB, store into
        * HashMap<PrimaryKey, Class(TableRowData)>
      * Concurrency
      * Lambda
    * Design Pattern
      * Singleton for Database instance
  * Database
    * Query
      * SQL
        * DML - Insert, Update
        * DDL - Create table, Drop table, Tablespaces,Indexey
        * Key - Primary Key, Foriegn Key, Unique
        * ID - Generator/Counter
        * Views from tables for reports
      * PreparedStatement
      * Hibernate query
  * Apache Spark
    * Query from OracleDB to Hive
    * Query from Hive tp OracleDB
    * Distributed cache-Infinispan for fast startup of lookup table
  * Database Upgrade
    * Hibernate Framework for compatibility
    * Restructure table to follow format
    * Installer modes
      * PreInstaller
      * PreInstaller
      * PostInstaller
