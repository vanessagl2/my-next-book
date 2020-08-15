# Learning series: Backend API in JAVA
Sample backend API. The goal is to exercise key concepts using JAVA 14, Spring Boot, Junit 5.

# My Next Book

## Context
Sample RESTful API to manage a book catalog. 


## Technical Details
### Languages and Frameworks 
* Java 14
* [Spring Boot](https://spring.io/guides): Many guides on building restful services are provided there 
* [Spring Start](https://start.spring.io/): Spring Initializer tool
* RESTful communication with JSON resources

* Database
    * **Local:** h2 in memory database. Console is enabled for further details at: http://localhost:8080/h2-console 
    * Upper environments: Postgres
* Infrastructure: _to be defined_

### Testing Stack
* JUnit, Mockito, RestAssured for testing
* ArchUnit to test your code design
* Gradle to manage your dependencies
* Docker


## Local Environment
### Running the Application Locally
Locally the application is running with an H2 database and a volatile memory defined at:

#### Using gradle wrapper
* Navigate to your root application directory and then run:
```shell script
$ ./gradlew bootRun
```
* Run with specific profile
```shell script
$ ./gradlew bootRun --args='--spring.profiles.active=PROFILE  '
```

#### Building local docker image
* Build the application (please notice that the application name and version may vary): 
```shell script
$ ./gradlew build && java -jar build/libs/catalog-0.0.1-SNAPSHOT.jar
```

* Generate the application docker image:
```shell script
$ mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*.jar)
$ docker build --build-arg DEPENDENCY=build/dependency -t catalog/my-next-book-docker .
```

* Run the application:
```shell script
$ docker run --name=books -d -p 8080:8080 catalog/my-next-book-docker
```
* Alternatively you can override the Spring active profile by running the container with:  
```shell script
$ docker run -e "spring.profiles.active=PROFILE" --name=books -p 8080:8080 catalog/my-next-book-docker
```
The application is then available on http://localhost:8080

* When it is running you can see in the list of containers, e.g:
```shell script
$ docker ps
```

* Stop the container:
```shell script
$ docker stop books
```

#### Setup Local Postgres
Let's see how to 
* Create volume to store data
``` shell script
$ docker create -v /var/lib/postgresql/data --name PostgresData alpine
```

* Create database
``` shell script
$ docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=<define a password> -d --volumes-from PostgresData postgres
```

### Further reference
* [HATEOS](https://spring.io/guides/gs/rest-hateoas/#scratch)