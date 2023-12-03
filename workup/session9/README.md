

very useful 

https://stackoverflow.com/questions/31257968/how-to-access-jmx-interface-in-docker-from-outside

https://snippets.syabru.ch/nagios-jmx-plugin/

https://exchange.nagios.org/directory/Plugins/Java-Applications-and-Servers/Syabru-Nagios-JMX-Plugin/details

The Syabru Nagios JMX plugin is meant to be used from Nagios, but doesn't require Nagios and is very convenient for command-line use: 

nagios jmx plugin - command line
see https://stackoverflow.com/questions/1751130/calling-jmx-mbean-method-from-a-shell-script

this plugin is added in the docker build

Note that username and password are not actually used in the jetty config

```
java -jar /nagios-jmx-plugin/check_jmx.jar -U service:jmx:rmi://localhost:11099/jndi/rmi://localhost:11099/jmxrmi --username myuser --password mypass -O java.lang:type=Memory -A HeapMemoryUsage -K used

JMX OK - HeapMemoryUsage.used = 213935616 | 'HeapMemoryUsage used'=213935616;;;;


```