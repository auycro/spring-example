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

- date parameters rule

```
time_range
{'since':YYYY-MM-DD,'until':YYYY-MM-DD}
A single time range object. UNIX timestamp not supported. This param is ignored if time_ranges is provided.

time_ranges
list<{'since':YYYY-MM-DD,'until':YYYY-MM-DD}>
Array of time range objects. Time ranges can overlap, for example to return cumulative insights. Each time range will have one result set. You cannot have more granular results with time_increment setting in this case.If time_ranges is specified, date_preset, time_range and time_increment are ignored.

since
datetime
A date in the format of "YYYY-MM-DD", which means from the beginning midnight of that day.

until
datetime
A date in the format of "YYYY-MM-DD", which means to the beginning midnight of the following day.
```

- Test Create 

```
curl -X POST localhost:8080/score -d player=First -d score=6666 -d time=2021-01-25
```

- Login to Mysql

```
docker exec -it score_db mysql -ujava_app -pfoobar score_db
```