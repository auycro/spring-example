# Sprint Boot Test: Score

### Instructions on how to build and run your app.

1. Clone project

    ```
    > git clone git@github.com:auycro/spring-example.git
    ```

2. Settting up database

    ```
    > cd spring-example/dockerfile/mysql/
    > sh run.sh
    ```

    This command will build and run MySQL docker container called 'score_db'.

    You can access to mysql server via this command.

    ```
    > docker exec -it score_db mysql -ujava_app -pfoobar score_db
    # select * from scores;
    ```

3. Running Application

    ```
    > cd spring-example
    > ./gradlew bootRun
    ```

### Instruction on how to run unit and integration tests.

```
> ./gradlew test
```

### Quick documentation of your API.

1. `GET`  `/scores/{id}`

    retrieve a score.

    --- Parameter ---
    | Name | Description |
    |------|-------------|
    |  id  | *required integer   |

    --- Response ---
    | Code | Description |
    |------|-------------|
    | 200  | success retrived score   |

    --- Example ---
    ```
    curl localhost:8080/scores/2
    ```

    ```
    {"id":2,"player":"zimmerman","score":110,"time":"2020-11-01T00:00:00.000+00:00"}
    ```
<br/>
<br/>

2. `POST`  `/scores`

    retrieve a score.

    --- Parameter ---
    | Name | Description |
    |------|-------------|
    |  player  | *required String  |
    |  score  |  *require Integer  |
    |  time  | *required DateTime : Format(yyyy-MM-dd hh:mm:ss) or Format(yyyy-MM-dd)|
    
    --- Response ---
    | Code | Description |
    |------|-------------|
    | 200  | success created score  |
    
    --- Example ---
    ```
    curl -X POST localhost:8080/scores -d player=foo -d score=6666 -d time="2021-01-25 00:00:00"
    ```

    ```
    {"id":0,"player":"foo","score":6666,"time":"2021-01-24T15:00:00.000+00:00"}
    ```

<br/>
<br/>

3. `DELETE` `/score/{id}`

    delete a score.

    --- Parameter ---
    | Name | Description |
    |------|-------------|
    |  id  | *required Integer  |
    
    --- Response ---
    | Code | Description |
    |------|-------------|
    | 200  | success deleted score  |
    
    --- Example ---
    ```
    curl -X DELETE localhost:8080/scores/12
    ```

    ```
    {"id":12,"player":"o'reilly","score":24,"time":"2020-12-21T00:00:00.000+00:00"}
    ```

<br/>
<br/>

4. `GET` `/score/search`

    delete a score.

    --- Parameter ---
    | Name | Description |
    |------|-------------|
    |  player  | String |
    |  before  | DateTime : Format(yyyy-MM-dd hh:mm:ss) or Format(yyyy-MM-dd) |
    |  after  | DateTime : Format(yyyy-MM-dd hh:mm:ss) or Format(yyyy-MM-dd) |
    |  page  | Integer  |
    |  limit  | Integer  |
    
    --- Response ---
    | Code | Description |
    |------|-------------|
    | 200  | success search score  |
    
    --- Example 1 ---
    ```
    curl -X GET http://localhost:8080/scores/search?player=dunkley&page=0
    ```

    ```
    [{"id":20,"player":"dunkley","score":10,"time":"2021-01-01T00:00:00.000+00:00"},{"id":21,"player":"dunkley","score":20,"time":"2021-01-02T00:00:00.000+00:00"},{"id":22,"player":"dunkley","score":30,"time":"2021-01-03T00:00:00.000+00:00"},{"id":23,"player":"dunkley","score":40,"time":"2021-01-04T00:00:00.000+00:00"},{"id":24,"player":"dunkley","score":50,"time":"2021-01-05T00:00:00.000+00:00"}]
    ```
    
    --- Example 2 ---
    ```
    curl "http://localhost:8080/scores/search?before=2021-01-10&page=0&limit=4&after=2020-12-31&player=dunkley&player=davey"
    ```

    ```
    [{"id":1,"player":"davey","score":100,"time":"2021-01-01T00:00:00.000+00:00"},{"id":20,"player":"dunkley","score":10,"time":"2021-01-01T00:00:00.000+00:00"},{"id":21,"player":"dunkley","score":20,"time":"2021-01-02T00:00:00.000+00:00"},{"id":22,"player":"dunkley","score":30,"time":"2021-01-03T00:00:00.000+00:00"}]
    ```

<br/>
<br/>

5. `GET` `/history`

    delete a score.

    --- Parameter ---
    | Name | Description |
    |------|-------------|
    |  player  | *required String |
    
    --- Response ---
    | Code | Description |
    |------|-------------|
    | 200  | success get player history  |
    
    --- Example ---
    ```
    curl "http://localhost:8080/history?player=dunkley"
    ```

    ```
    {"player":"dunkley","topScore":{"id":29,"player":"dunkley","score":100,"time":"2021-01-10T00:00:00.000+00:00"},"lowScore":{"id":20,"player":"dunkley","score":10,"time":"2021-01-01T00:00:00.000+00:00"},"average":55.0,"score":[{"id":20,"player":"dunkley","score":10,"time":"2021-01-01T00:00:00.000+00:00"},{"id":21,"player":"dunkley","score":20,"time":"2021-01-02T00:00:00.000+00:00"},{"id":22,"player":"dunkley","score":30,"time":"2021-01-03T00:00:00.000+00:00"},{"id":23,"player":"dunkley","score":40,"time":"2021-01-04T00:00:00.000+00:00"},{"id":24,"player":"dunkley","score":50,"time":"2021-01-05T00:00:00.000+00:00"},{"id":25,"player":"dunkley","score":60,"time":"2021-01-06T00:00:00.000+00:00"},{"id":26,"player":"dunkley","score":70,"time":"2021-01-07T00:00:00.000+00:00"},{"id":27,"player":"dunkley","score":80,"time":"2021-01-08T00:00:00.000+00:00"},{"id":28,"player":"dunkley","score":90,"time":"2021-01-09T00:00:00.000+00:00"},{"id":29,"player":"dunkley","score":100,"time":"2021-01-10T00:00:00.000+00:00"}]}
    ```
