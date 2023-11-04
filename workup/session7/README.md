# Session 7 setting up https with nginx and letsencrypt

To be completed


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