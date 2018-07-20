# starwars-api

### Made with JAVA + MongoDB

### Run with 
`$ mvn spring-boot:run`

### Retrieve All
`curl -X GET http://localhost:8080/planet/`

### Create
`curl -i -X POST -H "Content-Type:application/json" -d "{  \"name\" : \"Tatooine\",  \"terrain\" : \"desert\" , \"climate\" : \"arid\" }" http://localhost:8080/planet`

### Update
`curl -i -X PUT -H "Content-Type:application/json" -d "{ \"id\" : \"{id}\", \"name\" : \"Alderaan\",  \"terrain\" : \"grasslands, mountains\" , \"climate\" : \"temperate\" }" http://
localhost:8080/planet`

### Delete
`curl -X DELETE http://localhost:8080/planet/{id}`

### Find By Id
`curl -i http://localhost:8080/planet/{id}`

### Find By Name
`curl -i http://localhost:8080/planet/name/{name}`
