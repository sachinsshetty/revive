# Version 1

|No. | Step | Status | Date |
|--|--|--|--|
|1.| Run main class from Server.java eclipse control panel| Done | 18-May-22 |
|2.| Generate artifacts for deployment | Done| 18-May-22|
|3.| Create Test Suite|||
|4.| Run from apache-tomcat | ||
|5.| Create github action to build | Done | 18-May-22|

Source for steps
*  https://www.jetbrains.com/help/space/publish-artifacts-from-a-gradle-project.html
* https://www.vogella.com/tutorials/EclipseGradle/article.html
* createing fat jar or uber-jar :  https://www.baeldung.com/gradle-fat-jar
* shadowJar - https://imperceptiblethoughts.com/shadow/publishing/#publishing-with-maven-publish-plugin
* Conversion Steps
	* Add build.gradle file in root project directory
	* Add configurations
	* Close the project in Eclipse and Re.import as Gradle Project
	* In Gradle Tasks menu bar, run "gradle init"
* Installing gradle in linux - Ubuntu : https://linuxize.com/post/how-to-install-gradle-on-ubuntu-18-04/ :: install version 6.8 
* In terminal run "gradle build"
* java -jar build/libs/reviveJar-1.0-SNAPSHOT.jar
* Setup Gradle with github action :  https://tomgregory.com/build-gradle-projects-with-github-actions/