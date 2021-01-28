Prerequisite:

1. Install jdk (https://adoptopenjdk.net/)

2. Add Java and Spring Extension to VS Code

Tool Requirements:

----------
Java 11 (Java 8 or above)
Gradle 6 or above
Spring 2.2 or above
Spring Boot
MySQL
JUnit 5
----------

1. Create project from [Spring Initializr](https://start.spring.io/)
    
  1.1 Add dependency : Spring Web, MySQL driver

  1.2 Test run in VS Code.

2. Create simple [Score] api (https://spring.io/guides/gs/rest-service/#scratch)

  2.1 Add Score.java

  2.2 Add ScoreController.java

3. Prepare database

  3.1 Prepate Dockerfile

  3.2 Run 'run.sh'

4. Try access to db (https://spring.io/guides/gs/accessing-data-mysql/)

  4.1 Add dependencies(JPA,MysqlDriver) in build.gradle, Reload

  4.2 Add Entity and Repository

----------

Some useful command

- Reload gradle

```
rm -rf $HOME/.gradle/caches/
./gradlew build --refresh-dependencies
```

- Refresh dependencies

```
./gradlew assemble  --refresh-dependencies
```