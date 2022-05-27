|No. | Step | Status | Date |
|---|---|---|---|
|1.| JRE Size Reduction/Custom JRE | Done  | 27-May-22 |

* VSCode Setup + codespace

* Install OpenJDK17 -  https://adoptium.net/temurin/releases/?version=17

* Make builds for
    * 0.1 - Core Java + PostgreSQL
    * 0.2 - SpringBoot + Hibernate JPA
    * 0.3 - UT with Thymeleaf + v0.2
    * 0.4 - ReactJS frontend integration


* Create custom jre17 docker - https://levelup.gitconnected.com/java-developing-smaller-docker-images-with-jdeps-and-jlink-d4278718c550

* https://dzone.com/articles/dockerizing-with-a-custom-jre
* https://blog.adoptium.net/2021/08/using-jlink-in-dockerfiles/
* https://github.com/fedeoliv/java-custom-jre
* https://blog.adoptium.net/2021/10/jlink-to-produce-own-runtime/
* https://shekhargulati.com/2019/01/13/running-tests-and-building-react-applications-with-gradle-build-tool/


* Jlink - fix objcopy : https://medium.com/@david.delabassee/jlink-stripping-out-native-and-java-debug-information-507e7b587dd7
