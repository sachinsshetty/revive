* Install steps 

* Create Setup
    * create database revive_db;
    * create user revive_db with password 'revive_db';
    * grant all privileges on database revive_db to revive_db;
* To login
    * psql -h localhost -p 5432 -d revive_db -U revive_db
* To display all tables
    * \dt