# Session 1

## Recap - JSP

You should all have completed the basic introduction to Java from year 2. 

If you need to refresh yourself please review [COM528 Object oriented design - java - Nick Whitlegg](https://nwcourses.github.io/COM528/)

## webExercise1

The [webExercise1](../session1/com528-web/webExercise1) project contains the core of the answer to the exercises in last year's [COM528 WEEK6](https://nwcourses.github.io/COM528/week6.html)

You can import this project into netbeans and run with tomcat locally or you can run in a tomcat server downloaded by the [maven cargo plugin](https://codehaus-cargo.github.io/cargo/Maven+3+Plugin.html)


To run tomcat in maven outside of an IDE use

```
mvn clean install
mvn cargo:run
```

After a short time you should be able to browse to the application at 
[http://localhost:8080/webExercise1/](http://localhost:8080/webExercise1/)

# Running example in docker using docker-compose

A [docker-compose](../session1/com528-web/webExercise1/docker-compose) file has also been provided to allow you to run this example in Docker.

Docker-compose comes with docker-desktop but can be installed separately in a linux distribution.

Note: before you run this docker app make sure that tomcat is turned off in netbeans as the 8080 ports will clash.

To run in docker compose seeing the logs use

```
docker-compose up
```

or to run as a daemon use

```
docker-compose up -d
```
The application will be browseable at

[http://localhost:8080/](http://localhost:8080/)

# Set up an azure server 

Instructions for setting up a Microsoft Azure server and installing needed software are at [Server Setup](../session1/serverSetup.md)

# install software on the server and run the same example there

## log into your running vm
You can log into the server from a web terminal on your azure account but generally it will be better to use putty to SSH to your running machine. 
I suggest using Putty with SuperPutty which gives you a multi-terminal view

putty https://www.putty.org/

superputty https://www.puttygen.com/superputty

## install software

```
# (note that yum and dnf are effectively interchangable commands)

# ensure software is up to date
sudo yum update

# install nano editor and git and net-tools (ifconfig)
sudo yum install nano
sudo yum install git
sudo yum install net-tools

# install java 11
sudo yum install java-11-openjdk java-11-openjdk-devel

# check java 11 installed using 
java -version
javac -version

# you may need to select which version is being used using alternatives to select java 11
sudo update-alternatives --config java
sudo update-alternatives --config javac

# install maven
sudo yum install maven

# maven will install and prefer java 8 - we need to change this to java 11
# create and edit a new file /etc/java/maven.conf

sudo nano /etc/java/maven.conf

# and add the lines
JAVA_HOME=/usr/lib/jvm/jre

# check that maven is now picking up the correct java. You may need to re-set the alternatives as above.

mvn -version

 Apache Maven 3.5.4 (Red Hat 3.5.4-5)
 Maven home: /usr/share/maven
 Java version: 11.0.20, vendor: Red Hat, Inc., runtime: /usr/lib/jvm/java-11-openjdk-11.0.20.0.8-3.el8_8.x86_64

```
# docker and docker-compose

```
# add docker and docker-compose
# see https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-rocky-linux-9
# see https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-compose-on-rocky-linux-9 

# install docker depo and docker and docker-compose
sudo dnf config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
sudo dnf install docker-ce docker-ce-cli containerd.io
sudo dnf install docker-compose-plugin

# allow user to run docker outside of root 
sudo usermod -aG docker $(whoami)

# start docker and check working
sudo systemctl start docker
sudo systemctl enable docker
sudo systemctl status docker

docker ps
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES

# restart your whole server and see if you can log in
sudo shutdown -r now

You should now be able to clone the repo and run the docker compose command to run the example discussed above
```

# optional - install fail2ban
fail2ban prevents multiple attempts to log in with SSH. 
 see https://www.digitalocean.com/community/tutorials/how-to-protect-ssh-with-fail2ban-on-rocky-linux-9

```
# installing fail2ban starts firewalld which doesnt work with docker by default. You need to add the following changes

# install rules to allow 8080 port through firewall
# see firewalld documentation https://docs.rockylinux.org/books/lxd_server/04-firewall/
sudo firewall-cmd --zone=public --add-port=8080/tcp  --permanent
sudo firewall-cmd --reload

# stop docker and set up to use firewall which support fail2ban
sudo systemctl stop docker

# install firewall rules to allow docker to work with firewalld
# see https://www.reddit.com/r/RockyLinux/comments/zw4pcu/docker_firewalld/?rdt=60462

sudo systemctl enable firewalld
sudo systemctl start firewalld


sudo firewall-cmd --permanent --new-zone=docker
sudo firewall-cmd --permanent --zone=public --add-rich-rule='rule family="ipv4" source address=172.17.0.0/16 masquerade' # Change zone to whatever hosts the real WAN interface
sudo firewall-cmd --permanent --zone=docker --change-interface=docker0 # Or whatever bridge exists

sudo firewall-cmd --reload

## edit docker.service and add --iptables=false to the ExecStart line

sudo nano /etc/systemd/system/multi-user.target.wants/docker.service

ExecStart=/usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock --iptables=false

sudo systemctl start docker

# restart your whole server and see if you can log in
sudo shutdown -r now
```


