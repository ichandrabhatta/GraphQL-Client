GraphQL client

A client that consumes graphql APIs

First build the graphql-service container from https://github.com/ichandrabhatta/GraphQL-With-Spring-Boot. Readme has the instructions


Now come back to this repo and do the following:

```
docker-compose up --build -d 

```

This brings up all the needed containers
Postgres
Graphql-service
student-service


Now you can create a student using rest API which calls Graphql under the hood.

Example GET in postman:

```
localhost:9090/api/student/get/2
```

Example Post:

Url:

```
localhost:9090/api/student/create
```

```
{
      "firstName": "Jeff",
       "lastName": "Tiff",
       "city": "San Francisco",
       "email": "jTiff@test.com",
      "street": "Elmo",
       "subjectsLearning": [
        { "subjectName": "Java", "marksObtained": 90 },
        { "subjectName": "Python", "marksObtained": 90 }
      ]
}
```



