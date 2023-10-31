# Session 6  securing cargo deployer and photo uploads

## Introduction

The examples so far have provided a starting applications for creating a map and managing user accounts. 
One option for building you application would be to re-factor and merge these examples before adding extra functionality.

In this session, we will look at how to upload images to a web server which can be used in your application.
The [spring-boot-leaflet-starter](../session6/spring-boot-leaflet-starter) has been updated to allow you to add images to a point.

The [userManagementExample-web](../session6/userManagementExample-web)  has been updated to allow you to add images of a user

We have also looked at how war files can be deployed to a remote java web application server using cargo. 
In this session we will look at how to secure the remote server so that only users with the correct credentials can upload a war.

## Securing the cargo deployer

As we have seen, cargo works by deploying a small web application to the jetty server which allows remote maven builds to upload war files to the server. 
The following tutorials explain this in more detail.

[Deploying Web Applications in Jetty](https://www.baeldung.com/deploy-to-jetty)

[Cargo Jetty Remote Deployer](https://codehaus-cargo.github.io/cargo/Jetty+Remote+Deployer.html)

Our earlier examples allowed deployment but did not secure the server. 
This weeks examples add basic authentication to the server and the maven build so that deployment is more secure.
Please note that for this to be really secure, your communications would need to use https and not http.

Both examples have the same docker-compose configuration  docker-compose-deploy-password.yml

```
# this build injects security configurations into deployer
# see https://www.baeldung.com/deploy-to-jetty
version: "3.2"

volumes:
  data-jetty-files: {}
  data-jetty-logs: {}

services: 
    # rest simulator app runs on http://localhost:8080/
    # deployer runs on http://localhost:8080/cargo-jetty-deployer/

    restsimulator :
        build: .
        ports: 
          - "8080:8080"
        volumes:
          # setting up log data storage (target is used in log4j2.xml)
          - data-jetty-logs:/var/lib/jetty/target
          # setting up data files storage
          - data-jetty-files:/data-jetty-files
          # setting up poperties for restsimulator app
          - ./container-fs/jetty/start.d/restsimulator.ini:/var/lib/jetty/start.d/restsimulator.ini
          
          # setting up security for cargo-deployer
          - ./container-fs/jetty/webapps/cargo-deployer/WEB-INF/web.xml:/var/lib/jetty/webapps/cargo-deployer/WEB-INF/web.xml
          - ./container-fs/jetty/webapps/cargo-deployer/WEB-INF/jetty-web.xml:/var/lib/jetty/webapps/cargo-deployer/WEB-INF/jetty-web.xml
          - ./container-fs/jetty/etc/realm.properties:/usr/local/jetty/etc/realm.properties
      

```

We add security to the jetty docker container by injecting files from the folder container-fs

![alt text](../session6/images/container-fs-example1.png "Figure container-fs-example1.png")

realm.properties is where the username and password are set. 
You could use an MD5 hash instead of the password which would be more secure (see the cargo and jetty documentation).

```
someusername: somepassword,manager
```
The web.xml and jetty-web.xml files have been altered to allow cargo to use the security realm.
Again see the tutorials for more details.

The cargo deployer section of the pom.xml references the username and password.

You probably do not want these credentials to be in the checked in code so it is possible to use variable substitution to store the credentials in a vault or at least the maven settings and separately from your code. 
I will let you investigate this for yourselves.

```
         <plugin>
            <groupId>org.codehaus.cargo</groupId>
            <artifactId>cargo-maven3-plugin</artifactId>
            <version>${cargo.plugin.version}</version>
            <configuration>
               <container>
                  <containerId>jetty10x</containerId>
                  <type>remote</type>
               </container>

               <configuration>
                  <type>runtime</type>
                  <properties>
                     <cargo.hostname>127.0.0.1</cargo.hostname>
                     <cargo.servlet.port>8080</cargo.servlet.port>
                     <cargo.protocol>http</cargo.protocol>
                     <cargo.remote.username>someusername</cargo.remote.username>
                     <cargo.remote.password>somepassword</cargo.remote.password>
                  </properties>
               </configuration>

               <deployer>
                  <type>remote</type>
               </deployer>

               <deployables>
                  <deployable>
                     <groupId>${project.groupId}</groupId>
                     <artifactId>${project.artifactId}</artifactId>
                     <type>war</type>
                     <properties>
                        <context>/</context>
                     </properties>
                  </deployable>
               </deployables>
            </configuration>
         </plugin>

```

To test this in either project use

```
mvn clean install

# if you want to see the logs
docker-compose -f docker-compose-deploy-password.yml up

# if you want to run as a daemon
docker-compose -f docker-compose-deploy-password.yml up -d

```
browse to http://localhost:8080/cargo-jetty-deployer/

You should be asked for a username and password.
This shows that the cargo deployer is secure.
Use the same credentials you used in realm.properties (i.e. someusername  somepassword)

http://localhost:8080/cargo-jetty-deployer/

should now respond with
```
HTTP ERROR 400 Command / is unknown
URI:    /cargo-jetty-deployer/
```
Then deploy the application

```
mvn cargo:deploy
```
browse to http://localhost:8080/ should show you the app

## Uploading images

Your application will need to allow you to upload images. 
We could opt to save images directly in the database as binary blobs or as base 64 encoded ascii.
However in this example, we will save the images directly in the file system and save a reference in the database.

Substantially the same code is used to save user or point images in the two applications.

### setting up locations for saving the files

Firstly, we need to specify a place in to save the images.
This location will be different when running locally or in docker.

When running locally with spring-boot:run, we will want to save the images temporarily in the target directory.
(we use target/archive-files)

We tell the application to use this location using a spring-boot environment variable `image.file.uploadpath` which is set in the spring-boot-maven-plugin

```
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
               <environmentVariables>
                  <!-- this is only used for  spring-boot:run instead of application.properties image.file.uploadpath=./target/archive-files -->
                  <!-- resolves to file:/C:/devel/gitrepos/com619-devops1/workup/session6/userManagementExample-web/./target/user-photos/ -->
                  <image.file.uploadpath>./target/archive-files</image.file.uploadpath>
               </environmentVariables>
            </configuration>
         </plugin>
```

This environment variable can be accessed in our application using

```
   @Autowired
    private Environment env;
    ...
    String savePath = env.getProperty("image.file.uploadpath");
  
```


When running in a docker container, we will want to create a separate volume which can store the images after the container is turned off. 
A volume is like a disk which we inject or mount into the container.
(Note that you will also want to create volumes for your database data for the same reason -but I leave that to you to figure out)

In the docker compose file, we inject a volume called `data-jetty-files` as a folder at the root of the jetty container using

```
  volumes:
     data-jetty-files: {}
  
  services: 
 
    restsimulator :
        build: .
        ports: 
          - "8080:8080"
        volumes:
          - data-jetty-files:/data-jetty-files
          
```

Unfortunately, docker-compose injects volumes as root user which means that jetty which runs as user jetty cannot write to them.
To fix this, we need to first create the folder and change the owner and group to jetty:jetty before docker injects the volume. 
We do this in the Dockerfile which is called with the `build: . directive` in docker-compose.

the Dockerfile creates and sets the ownership of shared directories for both the images (in /data-jetty-files) and the application logs (in /var/lib/jetty/target).

docker-compose then injects read/write volumes to these locations. 

As described previously, the Dockerfile also installs the cargo-deployer which it downloads from the maven repository.

```
FROM jetty:10.0.17-jdk11

# Install Cargo
## installs cargo deployer on standard jetty 10

## install unzip as root user and then revert to jetty user
USER root
RUN apt-get update && apt-get install -y unzip

# make shared directories and change ownership to jetty
RUN mkdir /data-jetty-files
RUN chown -R jetty:jetty /data-jetty-files

RUN mkdir /var/lib/jetty/target
RUN chown -R jetty:jetty /var/lib/jetty/target

USER jetty

## downloads and unpacks cargo jetty deployer in web apps directory
## instead of dpeloying a zipped war file, we deploy a directory. 
## this allows us to modify files in the app on the fly when the container is started by docker

ADD --chown=jetty:jetty https://repo1.maven.org/maven2/org/codehaus/cargo/cargo-jetty-10-deployer/1.10.10/cargo-jetty-10-deployer-1.10.10.war /var/lib/jetty/cargo-deployer.war
RUN unzip /var/lib/jetty/cargo-deployer.war -d /var/lib/jetty/webapps/cargo-deployer  
RUN rm /var/lib/jetty/cargo-deployer.war

```

### using spring-boot to save files to these locations

Having set up these locations, how are they accessed by our application?

Firstly, because the image files can be quite large, we need to allow large file uploads using these settings in the spring `application.properties`

```
spring.servlet.multipart.max-file-size=5MB
spring.servlet.multipart.max-request-size=5MB
```

Secondly, we need to pass the location of the folder to spring. 
We cannot use spring environment settings as before but we can inject system properties in to jetty when it starts up

This is done using the start.d\restsimulator.ini file

```
-Dimage.file.uploadpath=/data-jetty-files/archive-files
```
This property can be accessed in our application using

```
System.getProperty("image.file.uploadpath")
```
Because we want to run in both docker and locally, we use the following construct to use the environment variable if set or fall back to the system variable.

```
   String savePath = env.getProperty("image.file.uploadpath",System.getProperty("image.file.uploadpath"));

```

### saving and loading images
The two classes which allow us to access images are FileUploadDAO.java and MVCConfig.java

MVCConfig uses a standard mechanism in spring to expose directories in the file system to be used by web pages.

You can see a tutorial on this at [spring mvc static resources](https://www.baeldung.com/spring-mvc-static-resources)

```
@Configuration
public class MVCConfig implements WebMvcConfigurer {
 
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/user-photos/**").addResourceLocations("file:///data-jetty-files");
    }
```
This  example maps `file:///data-jetty-files` to a web directory called `/user-photos/`

The actual MVCConfig class reads the directory  location from the image.file.uploadpath property and maps this to a web directory called `/user-photos/`

This image folder  is accessed from the jsp

```
           <label>Photo: </label>
           <img src="./user-photos/${mapPoint.id}/${mapPoint.photoUrl}" alt="${mapPoint.name} ${mapPoint.id} image" width="100" height="100" />
           
```


The second class FileUploadDAO.java allows us to save a file uploaded as a Http MultipartFile object to a known location given by the properties.

the JSP uploads the image using

```
           <form action="./viewModifyPoint" method="POST" enctype="multipart/form-data">
               <input class="btn" type="file" name="image" accept="image/png, image/jpeg" capture="camera">
               <input type="hidden" name="pointId" value="${mapPoint.id}" />
                <input type="hidden" name="action" value="updatePointPhoto">
               <button class="btn" type="submit" >Update Photo</button>
           </form>
```

The PageController.java accesses this file using

```
    @RequestMapping(value = "/viewModifyPoint", method = { RequestMethod.POST })
    @Transactional
    public String photoModify(
               @RequestParam(value = "image", required = false) MultipartFile multipartFile
               
               ...
               String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
               fileUploadDao.saveFile(relativeUploadDir, fileName, multipartFile);

```









