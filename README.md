# Geo API
Simple Rest API written in Java using Spring Boot and Apache Cassandra.

### Endpoints

1) The Country API
   - POST /api/v1/countries Add a new country.
   - GET /api/v1/countries Retrieve all countries.
   - GET /api/v1/countries/{id} Get a country by its id.
   - PUT /api/v1/countries/{id} Update a country by its id.
   - DELETE /api/v1/countries/{id} Delete a country by its id
   
1) The POI API
   - POST /api/v1/poi Add a new POI.
   - GET /api/v1/poi Retrieve all POIs.
   - GET /api/v1/poi/{id} Get a POI by its id.
   - PUT /api/v1/poi/{id} Update a POI by its id.
   - DELETE /api/v1/poi/{id} Delete a POI by its id.

### Documentation 
   - /swagger-ui
   - /api-docs 

### Development

##### Prerequisites
Download and install the [JDK](https://www.oracle.com/java/technologies/downloads/)  
Install [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git), the free and open source distributed version control system.  
Install [Docker](https://docs.docker.com/get-docker/), an open source containerization platform.

##### Clone the project
Run `git clone git@github.com:opofa/geo-api.git` to clone the repository from [GitHub](https://github.com/opofa/geo-api).

##### Create a Database
Register to [DataStax](https://www.datastax.com/) (You can use your GitHub or your Google account).  
Create a Database for your project.  
Generate an Application Token for your project.  

##### Create the necessary Environment Variables
```
SPRING_DATA_CASSANDRA_KEYSPACE-NAME=<keyspace>
SPRING_DATA_CASSANDRA_USERNAME=<username>
SPRING_DATA_CASSANDRA_PASSWORD=<password>

ASTRA_DB_ID=<db_id>
ASTRA_DB_REGION=<region>
ASTRA_DB_KEYSPACE=<keyspace>
ASTRA_DB_APPLICATION_TOKEN=<app_token>
```