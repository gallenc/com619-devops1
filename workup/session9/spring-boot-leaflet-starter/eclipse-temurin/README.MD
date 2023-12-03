# test docker file

this is a simple docker file to test external jmx accesss

```
docker compose exec jmx-client bash
java -jar /nagios-jmx-plugin/check_jmx.jar -U service:jmx:rmi://restsimulator:11099/jndi/rmi://restsimulator:11099/jmxrmi --username myuser --password mypass -O java.lang:type=Memory -A HeapMemoryUsage -K used

```

command to generate cli jmx configurations for opennms
https://docs.opennms.com/horizon/32/operation/deep-dive/admin/jmx-config-generator/cli.html

```
java -jar /usr/share/java/opennms/opennms_jmx_config_generator.jar
```
