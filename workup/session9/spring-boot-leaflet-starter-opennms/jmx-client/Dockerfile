FROM eclipse-temurin:11-jdk-focal
#FROM opennms/deploy-base:ubuntu-3.0.1.b237-jre-17
## install unzip as root user 
USER root
RUN apt-get update && apt-get install -y unzip iputils-ping 

# installing opennms jmx config generator - this installs too many depencencies
# 
RUN apt-get install -y gnupg software-properties-common
RUN apt-key adv --fetch-keys https://debian.opennms.org/OPENNMS-GPG-KEY
RUN add-apt-repository -s 'deb https://debian.opennms.org stable main'
#RUN apt-get install -y opennms-jmx-config-generator
RUN apt-get download -y opennms-jmx-config-generator

# Optional - Install nagios jmx plugin - used for testing jmx locally
ADD http://snippets.syabru.ch/nagios-jmx-plugin/download/nagios-jmx-plugin.zip /nagios-jmx-plugin.zip
RUN unzip /nagios-jmx-plugin.zip -d /nagios-jmx-plugin-tmp
RUN mv /nagios-jmx-plugin-tmp/nagios-jmx-plugin-1.2.3 /nagios-jmx-plugin
RUN rm -R /nagios-jmx-plugin-tmp && rm /nagios-jmx-plugin.zip

# keep running
ENTRYPOINT ["tail", "-f", "/dev/null"]
