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

