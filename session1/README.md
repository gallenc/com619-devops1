# Session 1

## Recap - JSP

You should all have completed the basic introduction to Java from year 2. 

If you need to refresh yourself please review [COM528 Object oriented design - java - Nick Whitlegg](https://nwcourses.github.io/COM528/)

## webExercise1

The [webExercise1](../session1/com528-web/webExercise1) project contains the core of the answer to the exercises in last year's [COM528 WEEK6](https://nwcourses.github.io/COM528/week6.html)

You can import this project into netbeans and run with tomcat locally or you can run in a tomcat server downloaded by the [maven cargo plugin](https://codehaus-cargo.github.io/cargo/Maven+3+Plugin.html)


To run tomcat in maven outside of an IDE use

```
mvn clean install
mvn cargo:run
```

After a short time you should be able to browse to the application at 
[http://localhost:8080/webExercise1/](http://localhost:8080/webExercise1/)

# running example in docker using docker-compose

A [docker-compose](../session1/com528-web/webExercise1/docker-compose) file has also been provided to allow you to run this example in Docker.

Docker-compose comes with docker-desktop but can be installed separately in a linux distribution.

Note: before you run this docker app make sure that tomcat is turned off in netbeans as the 8080 ports will clash.

To run in docker compose seeing the logs use

```
docker-compose up
```

or to run as a daemon use

```
docker-compose up -d
```
The application will be browseable at

[http://localhost:8080/](http://localhost:8080/)


