# starwars-api

### Made with JAVA + MongoDB

### Run with 
`$ mvn spring-boot:run`

### Retrieve All
`curl -X GET http://localhost:8080/planet/`

### Create
`curl -i -X POST -H "Content-Type:application/json" -d "{  \"name\" : \"Foo 2\",  \"terrain\" : \"grasslands, mountains\" , \"climate\" : \"temperate, tropical\" }" http://localhost:8080/planet`

### Update
`curl -i -X PUT -H "Content-Type:application/json" -d "{ \"id\" : \"5b4f68ae491f9c6a25189b12\", \"name\" : \"Foo 2 Incremented 2\",  \"terrain\" : \"desert\" , \"climate\" : \"arid\" }" http://
localhost:8080/planet`

### Delete
`curl -X DELETE http://localhost:8080/planet/{id}`

### Find By Id
`curl -i http://localhost:8080/planet/{id}`

### Find By Name
`curl -i http://localhost:8080/planet/name/{name}`
