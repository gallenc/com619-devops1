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

## Docker Compose configurations

In our example, we will host  our application in one container, nginx in a second container, and certbot in a third container.
There are many tutorials and code examples available and some are listed below.

[Nginx and Let’s Encrypt with Docker in Less Than 5 Minutes](https://pentacent.medium.com/nginx-and-lets-encrypt-with-docker-in-less-than-5-minutes-b4b8a60d3a71)

[Setting up Nginx Webserver with letsencrypt on Docker](https://phoenixnap.com/kb/letsencrypt-docker)

[Nginx and Let’s Encrypt with Docker in Less Than 5 Minutes](https://pentacent.medium.com/nginx-and-lets-encrypt-with-docker-in-less-than-5-minutes-b4b8a60d3a71) [github project](https://github.com/wmnnd/nginx-certbot) Note: replace docker-compose with docker compose if needed.

However, I have personally adoped and adapted a more complex example which allows me to run a script to generate my certificates for multiple   different back ends. 
This is a fork of an example by [eugene-khyst](https://github.com/eugene-khyst/letsencrypt-docker-compose).
However my example includes running a jetty server instead of node.js.

[com619 letsencrypt-docker-compose](https://github.com/gallenc/letsencrypt-docker-compose/tree/com619-1)
Note that my example is in the com619-1 branch. 


# Setting up letsencrypt

see my example https://github.com/gallenc/letsencrypt-docker-compose/tree/com619-1

based upon https://github.com/eugene-khyst/letsencrypt-docker-compose 

need to allow large uploads
need to allow reverse proxy
added a simple web app to deploy 

in the spring applications - need to have swagger ui do https

https://stackoverflow.com/questions/70843940/springdoc-openapi-ui-how-do-i-set-the-request-to-https
server.forward-headers-strategy=framework

to do - start docker-compose as a service - system d script
see https://blog.entek.org.uk/notes/2021/09/30/docker-compose-with-systemd.html


web site monitoring
https://github.com/gallenc/opennms-integrations-play/tree/main/websitemonitoring

https://hackmd.io/@agalue/HyGyD0diN  opennms letsencrypt cloud init

https://medium.com/nirman-tech-blog/nginx-as-reverse-proxy-with-grpc-820d35642bff

https://github.com/opennms-forge/stack-play/tree/cada4b5b39edd3f745d514aeaf4cce3f12fdef18/minimal-minion-grpc
