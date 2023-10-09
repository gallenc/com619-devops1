# Session 3

In this session we are going to look at how Spring MVC can be used to create a simple user management application. 

[userManagementExample-web](../session3/userManagementExample-web)

This session is accompanied by a video [COM619 Session 3](https://youtu.be/v3XppCqvH5c)

You will need to be able to create and manage users for your map application so this will give you a starting point. 

Note that this example is quite simple but it does show you how to do simple CRUD (Create, Retrieve, Update, Delete ) operations on a user. 

The application is pre-populated with two users, one an Administrator. 
This is done using the PopulateDatabaseOnStart class.

It does not use a sophisticated authentication mechanism like Spring Security but simply stores the user permissions in the session object in order to control which parts of a JSP can be displayed.

You will still need to think about how you will authenticate user clients accessing the ReST application.

