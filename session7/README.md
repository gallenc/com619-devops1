# Session 7 setting up https with nginx and letsencrypt

## Introduction
In this session we will look at using nginx as a reverse proxy to terminate the https traffic and forward requests to your application. 
You will probably want to do this if your back end is java or javascript as it is simpler to test and monitor your application internally using http while external https access is proxied through nginx. 

A key requirement is that your https is enabled using a signed certificate. 
If a self-signed certificate is used, your web site will probably work but your browser will complain that the site may not be secure. 
Some browsers will refuse to open sites with self signed certificates. 

Instead the certificate must be signed by a recognised certificate authority that has validated that you own the site.
This is explained in this [certificate authority tutorial](https://www.techtarget.com/searchsecurity/definition/certificate-authority)
Certificate signing authories such as [godaddy](https://www.godaddy.com/en-uk/web-security/ssl-certificate) charge a lot of money for certificates for which they do a number of background checks.

However we can obtain free certificates from [Letsencrypt](https://letsencrypt.org/) which is a free, automated, and open certificate authority brought to you by the nonprofit Internet Security Research Group.
Letsencrypt certificates are obtained automatically using an application called certbot and they must be renewed every 3 months. 
The certificates are downloaded and passed to our web server to validate our https connections.

## Example Docker Compose configurations and tutorials

In our example, we will host  our application in one container, nginx in a second container, and certbot in a third container.
There are many tutorials and code examples available and some are listed below.

[Nginx and Let’s Encrypt with Docker in Less Than 5 Minutes](https://pentacent.medium.com/nginx-and-lets-encrypt-with-docker-in-less-than-5-minutes-b4b8a60d3a71)

[Setting up Nginx Webserver with letsencrypt on Docker](https://phoenixnap.com/kb/letsencrypt-docker)

[Nginx and Let’s Encrypt with Docker in Less Than 5 Minutes](https://pentacent.medium.com/nginx-and-lets-encrypt-with-docker-in-less-than-5-minutes-b4b8a60d3a71) [github project](https://github.com/wmnnd/nginx-certbot) (Note: replace `docker-compose` with `docker compose` if needed).

## Class example
I have personally adopted and adapted a more complex example which allows me to run a script to generate my certificates for multiple  different back ends. 
This is a fork of an example by [eugene-khyst](https://github.com/eugene-khyst/letsencrypt-docker-compose).
My example includes running a jetty server instead of node.js.

[com619 letsencrypt-docker-compose](https://github.com/gallenc/letsencrypt-docker-compose/tree/com619-1)
(Note that my example is in the com619-1 branch). 

This example will set up nginx and letsencrypt in a docker compose project with a jetty cargo based deployer. 
The example includes a simple jsp app which can be deployed to the server.

Note that the cargo deployer requires that the nginx configuration allows large uploads. 
Otherwise, nginx will respond with the message

```
HTTP request failed, response code: 413, response message: Request Entity Too Large,
```
This is fixed by adding the following line to the nginx configuration
```
client_max_body_size 100M;
```
## starting docker-compose as a service

When your server re-starts, you presently have to manually re-start the docker compose applications. 
This is not desirable in production. 
Instead, we create a simple systemd script to start up docker-compose when the system starts. 
The example is based on the simple example here: [docker compose with systemd](https://blog.entek.org.uk/notes/2021/09/30/docker-compose-with-systemd.html)

This systemd file goes in /etc/systemd/system/docker-compose@.service:
```
[Unit]
Description=%i service with docker compose
Requires=docker.service
After=docker.service

[Service]
Type=oneshot
RemainAfterExit=true
WorkingDirectory=/opt/%i
ExecStart=/usr/bin/docker-compose up -d --remove-orphans
ExecStop=/usr/bin/docker-compose down

[Install]
WantedBy=multi-user.target
```

To configure the application (e.g. my-app), with a docker-compose.yml in the corresponding directory (e.g. /opt/my-app/docker-compose.yml), to start on boot, we simply enable a systemd unit for this template:
```
systemctl enable docker-compose@my-app
```
And to start it:
```
systemctl start docker-compose@my-app
```
This same mechanism can be used for multiple docker-compose apps in the /opt/ directory.

## Modifications to jetty and spring-boot examples
Both of the previous examples have been modified to allow them to run behind the nginx proxy

[spring-boot-leaflet-starter](../session7/spring-boot-leaflet-starter)

[userManagementExample-web](../session7/userManagementExample-web)

The important change is to the spring boot configuration so that the swagger UI examples use https and not just http when behind a proxy.
(see [springdoc openapi-ui how do I set the request to https](https://stackoverflow.com/questions/70843940/springdoc-openapi-ui-how-do-i-set-the-request-to-https)
```
# add to application.properties
# allows ngnx to forward https for swagger
server.forward-headers-strategy=framework
```

## New deploy mechanisms
In both the example projects, the pom has changed to allow cargo to pick up properties from a properties file.

You need to copy `deploy.properties.template` to `deploy.properties`  and change the values to match your site.

The `mvn initialize` goal reads the properties file so when deploying use the command

```
mvn initialize cargo:deploy
```

