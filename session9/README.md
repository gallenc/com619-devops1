# Session 9  remote monitoring

A basic level of monitoring can be achieved if you expose the nginx statistics and provide hte URL of your application. 

Please add the following lines and provide me with the URL of your application.

Nginx can provide internal statistics. 

See Using the stub_status Module in [monitoring nginx](https://www.nginx.com/blog/monitoring-nginx/)

get https://localhost/nginx_status  should give the following lines

```
Active connections: 2
server accepts handled requests
  6 6 54
 Reading: 0 Writing: 1 Waiting: 1

```

To enable this add the following lines into the listen 80 and/or listen 443 sections of your nginx config to expose the server statistics

```
server {
     listen 80 ;
...
       
       location /nginx_status {
         stub_status;
            #allow 127.0.0.1;    #only allow requests from localhost
            #deny all;       #deny all other hosts   
      }

}

```


```

server {
     listen 443 ;

     ...
       
       location /nginx_status {
         stub_status;
            #allow 127.0.0.1;    #only allow requests from localhost
            #deny all;       #deny all other hosts   
      }

}

```

