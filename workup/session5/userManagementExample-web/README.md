
# ReST Authentication and User Management example

This session builds upon the example in session 3 to show how a ReSt api can also be authenticated.

This session is accompanied by a video [COM619 Session 5](xxxx)

# Introduction

This is a simple user management application which shows how to create and update a set of user accounts with a password.
Users can self-register to use the application but only the system administrator can allow them privileges.

(Note that this application is quite simple and does not use spring security but it does show how user credentials can be applied to a session).

The basic user authentication was explained in the previous example in session 3 .

This example has been extended in userManagementExample-web to include a ReST api which is documented with swagger/openapi 

The ReST api is implemented in UserRestController. 

The /getUserList request gets a full list of users.

the /getUser?username=xxx request gets a user with a particular user name

The UserRestController uses the UserRepository to access the database.

Obviously, we only want users with ADMINISTRATOR privileges to access user information, so the ReST api must be secured. 
In this example we use simple basic authentication to secure the ReST api.
The UserAuthoriserService is used to extract the basic authorisation credentials and find the UserRole associated with the user.
If the username is not found or the password does not authenticate, then a not authorised message is returned to the ReST call. 

If the username is found and the user is an ADMINISTRATOR, then the ReST call is allowed to proceed. 

The Swagger UI is only visable to someone logged in as an administrator.
The AuthOpenApiCustomizer adds a basic authentication button to the Swagger UI to allow users to set hte username and password accessing the ReST api in a Swagger UI test. 



## running 

To run as spring boot application 

```
mvn clean install
mvn spring-boot:run
```

You can also use the docker-compose script.

```
docker-compose up
```

## rest api examples

You can include basic basic authentication in the url of Get requests 

http://username:password@localhost:8080/...

The application will treat this as a basic auth request.

http://globaladmin:globaladmin@localhost:8080/getUserList

http://globaladmin:globaladmin@localhost:8080/getUser?username=user1234

But this is  not secure - better to use basic authentication headers which are encrypted using https.


