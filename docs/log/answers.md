* How API was setup with SpringBoot

* How is persistence done with Postgres
    * Using Hibernate JPA and Sping MVC - JPA Repository and model files automatically map to postgres database.
    * Table , Sequence, Primary and Unique key constraints are handled in the POJO file
    * Dummy values are passed as SQL on startup, kept in resources folder as data.sql , can also be mapped to Docker volume 
    * Current issue, it executes everytime, need to convert into PL/SQL to handle multilpe runs . Error is suppresed with config : spring.sql.init.continue-on-error=true

* How do you use unit & integration test
    * TODO - Backend Logic tested with JUnit
    * TODO - ReactJS with Jasmine test
    * TODO - SQL with verification SQL's 

* How CI/CD accomplished with Github Actions
    * Use the github gradle runner to execute the build task only currently
    * TODO - Use the trigger to create docker images and push to docker hub + AWS deploy on commit

    * Build tool - Gradle for SpringBoot
        * ReactJS build is triggered by calleding npm install and npm run build.
    TODO - Using Github actions Gradle Runner to build jars currently by targering build task in main.yml +
        * Target it trigger buildDocker task in current form as it compliments Continous Integration, runDocker task can be tested for verification in target Cloud deployment,

    Current build does the following step
        * Build springboot application uber jar
        * In a docker container, it creates module-info.java for mapping dependencies on appication.jar & using jlink it creates a customer JRE as the ouput of the first interstitial docker container. 
        * On bare metal alpine-linux image, customer jre with module dependencies and the application jar are copied to the image.
        * The build is tagged frm gradle based on dockerHubRepoName:tagversiom

* Minimalistic frontend
    * TODO : Display simple tables
    * TODO : Some graphs display ? if time permits , last task

* Automated deployment into any cloud provider
    * TODO : Build using Docker compose to load into AWS

* How to Present the Problem 
    * Why i started the project - inside joke : why the name : revive  : Easter Egg.

* What were the problems , challenges and tricks

    * Challenges
        * Build Custom JRE
            * Building the module-info.java using jdeps command, was throwing a missing module error for tomcat-embed.jar, There was no solution found only on how to add the missing dependency.
            * Tried by chekcing if any IDE has an automatic module info generator - Eclipse JEE, VSCode and IntelliJ Idea i could not find the configuration. 
            * One link had used a different set of parameters, it looked like it was using all the modules. The command worked and the docker image is running, Size still can be reduced by tweaking few parameters
            * Container image size reduced by 78 MB from 228 MB to 160 MB
        * Combined FrontEnd in ReactJS and Backend in SpringBoot Image for deployment was a mistake, As we need two servers to deploy them if have to scale  independently. The final targer was a split of FrontEnd and Backend, But i was trying actual migration strategy that companies follow.
        * Dev Coding Environment -
            On wednesday got access to VSCode codespaces beta, it reduces the time between writing java code in Windows and testing the docker implementation on the Ubuntu. Verifying if the entire current cycle can be done completely on the browser.


