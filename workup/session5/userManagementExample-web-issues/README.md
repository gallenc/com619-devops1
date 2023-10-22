
# User Management example

This session is accompanied by a video [COM619 Session 3](https://youtu.be/v3XppCqvH5c)

# Introduction

This is a simple user management application which shows how to create and update a set of user accounts with a password.
Users can self-register to use the application but only the system administrator can allow them privileges.

(Note that this application is quite simple and does not use spring security but it does show how user credentials can be applied to a session).

You can see the user information in the model package, Users have an Address, a Username and Password. 
A UserRepository is used to persist users to the database

The UserAndloginController does hte work of managing the user data and controlling the user update JSP's.
Note the use of @Transaction on the user update methods. 
This means that the user will be atomically updated within a database transaction.

The PasswordUtils class is used to hash the password using a library called BCrypt.
Only the hash of the password is stored in the database.

Users have different roles and only ADMINISTRATOR users can change another user's data or change their role.

The application uses Spring MVC and Spring Data (JPA) to store data but note that in this example the configuration is done slightly differently using a PersistanceJPAConfig. 

This is just a choice to expose more of the internals of spring which are normally hidden in spring boot. 

The application also has more sophisticated use of JSP's where each JSP has a header and footer which allows the same content to be rendered for the header and footer for all JSP's

The CSS in this example uses bootstrap and the bootstrap-starter.html which is included here as an example was used to create the styling used by all of the JSP's.

You can choose to use any of this application which you find useful as a framework.

## to run locally

To run as spring boot application 

```
mvn clean install

mvn spring-boot:run
```

UI is at http://localhost:8080/


## to see open api annotations

Swagger / OpenAPI Test UI:

http://localhost:8080/swagger-ui/index.html

Swagger / OpenAPI yaml:

http://localhost:8080/api-docs



