# Persistance
* Using Hibernate JPA and Sping MVC - JPA Repository and model files automatically map to postgres database.
    * Table , Sequence, Primary and Unique key constraints are handled in the POJO file
    * Dummy values are passed as SQL on startup, kept in resources folder as data.sql , can also be mapped to Docker volume 
    * Current issue, it executes everytime, need to convert into PL/SQL to handle multilpe runs . Error is suppresed with config : spring.sql.init.continue-on-error=true