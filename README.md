# Sprint Boot Test: Score

### Instructions on how to build and run your app.

TBD

### Instruction on how to run unit and integration tests.

TBD

### Quick documentation of your API.

`GET`  `/scores/{id}`

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
{"id":2,"player":"zimmerman","score":110,"time":"2020-11-01T00:00:00.000+00:00"}
```

`POST`  `/scores`

retrieve a score.

--- Parameter ---
| Name | Description |
|------|-------------|
|  player  | *required String  |
|  score  |  *require Integer  |
|  time  | *required DateTime Format(yyyy-MM-dd hh:mm:ss) |

--- Response ---
| Code | Description |
|------|-------------|
| 200  | success created score  |

--- Example ---
```
{"id":0,"player":"gumpanat","score":3333,"time":"2021-01-25T02:01:01.000+00:00"}
```
