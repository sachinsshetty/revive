* PostgreSQL status check

  * sudo systemctl is-active postgresql

  * sudo systemctl is-enabled postgresql

  * sudo systemctl status postgresql

  * sudo pg_isready


* Creating database
  * sudo su - postgres
  * psql
    * CREATE USER db_user WITH PASSWORD 'db_pswd';
    * CREATE DATABASE user_db;
    * GRANT ALL PRIVILEGES ON DATABASE user_db to db_user;

* sudo /usr/pgadmin4/bin/setup-web.sh
