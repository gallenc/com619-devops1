# Session 5

In this session we will be looking at securing a ReST application using basic authentication (without using spring security).

See [Session 5 Basic Authentication of ReST api video](https://youtu.be/O0w8UAEmCds)

## Basic Authentication

The simplest form of authentication used by many web site is called Basic Authentication. 
When using Basic Authentication, a browser adds an Authorization header to every request which passes a simple username and password to the server.

The username and password are simply combined into a single string separated by a colon ':' character.
The bytes making up this complete string is then encoded as base64 an represented as text characters. 
This process simply reduces the size of the sent string and also avoids any problems with differn't character set encoding.

```
username:password -> Base64 encoding -> Basic {base64 encoded string)
```
A get request with username:password = globaladmin:globaladmin sent using curl would look like this

```
curl -X 'GET' \
  'http://localhost:8080/getUserList' \
  -H 'accept: */*' \
  -H 'Authorization: Basic Z2xvYmFsYWRtaW46Z2xvYmFsYWRtaW4='
```
We can also use a tool called RESTer to create a request.

It is important to note that even though the authentication credentials are hidden in the HTTP header, they are far from secure. 
Thus Basic Authentication should only be used over a TLS encoded link (i.e. using HTTPS)

## RESTer test app

You can test the app using the RESTer plugin for Firefox or chrome.

[RESTer Chrome plugin](https://chrome.google.com/webstore/detail/rester/eejfoncpjfgmeleakejdcanedmefagga)

[RESTer Firefox plugin](https://addons.mozilla.org/en-GB/firefox/addon/rester/)

![alt text](../session5/images/RESTerCom619-5.png "Figure RESTerCom619-5.png")


Using authentication in this test app

![alt text](../session5/images/ReSTER-Example1.png "Figure ReSTER-Example1.png")
