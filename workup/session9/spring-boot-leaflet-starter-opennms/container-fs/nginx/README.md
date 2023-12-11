## NGINX reverse proxy

If you want to run a simple reverse proxy on nginx port 80, place the `opennms-no-ssl.conf` file in `container-fs/nginx/conf.d` and remove `jetty-https.properties` from `opennms.properties.d`

If you want to use https/TLS, replace `opennms-no-ssl.conf` with `opennms-witn-ssl.conf` in `container-fs/nginx/conf.d`

you must also tell OpenNMS to serve https by placing `jetty-https.properties` in `opennms.properties.d`

`jetty-https.properties` should contain

```
opennms.web.base-url = https://%x%c/
```
(see https://opennms.discourse.group/t/how-to-use-nginx-as-ssl-proxy-with-opennms-horizon/208)

## public and private keys

A self signed certificate is provided here with a life of 5 years. 

You can regenerate these certifictes using the following instructions

### regenerating self signed certificate

see tutorial at https://www.humankode.com/ssl/create-a-selfsigned-certificate-for-nginx-in-5-minutes/

on a linux machine with openssl installed, edit a file localhost.conf 

```
sudo nano localhost.conf
```
and fill with the following - modify values as desired

```
[req]
default_bits       = 2048
default_keyfile    = localhost.key
distinguished_name = req_distinguished_name
req_extensions     = req_ext
x509_extensions    = v3_ca

[req_distinguished_name]
countryName                 = Country Name (2 letter code)
countryName_default         = US
stateOrProvinceName         = State or Province Name (full name)
stateOrProvinceName_default = New York
localityName                = Locality Name (eg, city)
localityName_default        = Rochester
organizationName            = Organization Name (eg, company)
organizationName_default    = localhost
organizationalUnitName      = organizationalunit
organizationalUnitName_default = Development
commonName                  = Common Name (e.g. server FQDN or YOUR name)
commonName_default          = localhost
commonName_max              = 64

[req_ext]
subjectAltName = @alt_names

[v3_ca]
subjectAltName = @alt_names

[alt_names]
DNS.1   = localhost
DNS.2   = 127.0.0.1
```

Then create public and private keys, in this case for 5 years validity

```
sudo openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout localhost.key -out localhost.crt -config localhost.conf
```

copy 
 `localhost.key` to `container-fs/private`
 `localhost.crt` to `container-fs/certs`


# OpenNMS GRPC

code 

generated [OpenNMSIpcGrpc.java](https://github.com/OpenNMS/opennms/blob/develop/core/ipc/grpc/common/src/main/java/org/opennms/core/ipc/grpc/common/OpenNMSIpcGrpc.java)

protouf definition [ipc.proto}(https://github.com/OpenNMS/opennms/blob/develop/core/ipc/grpc/common/src/main/proto/ipc.proto)


https://docs.opennms.com/meridian/2023/deployment/minion/install.html

## monitoring nginx

https://www.tecmint.com/enable-nginx-status-page/

https://sourceforge.net/p/opennms/mailman/opennms-discuss/thread/1491528003843-7595317.post%40n2.nabble.com/#msg35775352
nginx monitor opennms
