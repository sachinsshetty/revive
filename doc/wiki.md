* Java
  * Use jdeps and jlink to create custom jre customised to application requirements. Reduce the docker images as jre in 17 is officially not released .
    * use bellsoft jre to temporarily test builds for java 17 jre.
  * LTS released for version 17.
    * modular release target to reduce size of jar/war builds
    * Features added :: TODO
      * AAA  
        * Used in Class -
        * Used in Class -
      * BB
* Spring Framework
  * SpringBoot
    * Singleton Pattern used for loading top class, reduces build time with starter kits provide for many requirement at ...
      * Spring-boot-starter-data-jpa
      * Spring-boot-starter-thymeleaf
        * Thymeleaf template provides simple access to UI creation and data exchange supporting MVC pattern.
      * Secuirty - OAuth
    * TODO
* JUnit
  * ver5 has introduced breaking changes, package names have changed , Assert function names are modified, Annotations have changed for SpringBootTest.
* Docker
  * alpine-linux based images have low memory requirements, It reduces bandwidth use for network transfer to testing build on CI/CD. Reduce the cost of deployment on cloud providers.
  * openjdk-17 release builds are more in size, jre not released officially due to custom jre support features added
* PostgreSQL
  * open source DB used for cloud computing. Capex costs are reduced as expensive licenses need not be bought to testing builds in CI/CD
* AWS
  * TODO
* Apache Kakfa
  * TODO
* Gradle(inplace of  maven)
  * Simple to read, used for Android and Kotlin
* Kotlin
  * TODO
