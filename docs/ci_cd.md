
Used workflow triggers to run the following tasks in order of execution

* BuildSetup (branch.yml) : run's on each commit and compile codes and generates jar for Server and Html+JS for Client
* JUnitTest (test_unit_integration.yml): run's on each commit and is used for Unit Testing and will be upgraded for Integration testing later
* BuildDocker (main.yml) : run's if JUnitTest workflow is successful and when pull request and tag releases are made. 
* ci_docker_hub (docker_hub.yml) : run's if BuildDocker workflow is successful and when pull request and tag releases are made. 

