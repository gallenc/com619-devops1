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

# OpenNMS config generator

```
java -jar /usr/share/java/opennms/opennms_jmx_config_generator.jar 
```

```
java -jar /usr/share/java/opennms/opennms_jmx_config_generator.jar  query  --host restsimulator --port 11099

java.util.logging
jdk.management.jfr
java.util
org.eclipse.jetty.util.component
org.eclipse.jetty.websocket.core.server
org.eclipse.jetty.jmx
org.eclipse.jetty.util
org.eclipse.jetty.websocket.core
java.nio
JMImplementation
org.eclipse.jetty.util.thread
org.eclipse.jetty.security
org.eclipse.jetty.servlet.listener
com.zaxxer.hikari
org.eclipse.jetty.annotations
org.eclipse.jetty.io
org.eclipse.jetty.websocket.common
org.eclipse.jetty.websocket.javax.server.internal
org.eclipse.jetty.plus.jndi
org.eclipse.jetty.servlet
org.springframework.boot.web.servlet.support
org.eclipse.jetty.websocket.javax.client
org.eclipse.jetty.logging
org.eclipse.jetty.server.session
org.eclipse.jetty.websocket.server.internal
java.util.concurrent
org.eclipse.jetty.deploy.providers
org.eclipse.jetty.websocket.servlet
org.eclipse.jetty.server.handler
org.eclipse.jetty.util.thread.strategy
org.eclipse.jetty.websocket.server
java.lang
com.sun.management
org.eclipse.jetty.webapp
org.eclipse.jetty.server
sun.nio.ch
org.eclipse.jetty.util.compression
org.apache.logging.log4j2
org.eclipse.jetty.websocket.javax.common
org.eclipse.jetty.deploy
```


```
java -jar /usr/share/java/opennms/opennms_jmx_config_generator.jar generate-graph --host restsimulator --port 11099 --output JMX-DatacollectionDummy.xml --service restsim  "java.lang:*"

<jmx-datacollection-config xmlns="http://xmlns.opennms.org/xsd/config/jmx-datacollection">
   <jmx-collection name="JSR160-restsim">
      <rrd step="300">
         <rra>RRA:AVERAGE:0.5:1:2016</rra>
         <rra>RRA:AVERAGE:0.5:12:1488</rra>
         <rra>RRA:AVERAGE:0.5:288:366</rra>
         <rra>RRA:MAX:0.5:288:366</rra>
         <rra>RRA:MIN:0.5:288:366</rra>
      </rrd>
      <mbeans>
         <mbean name="java.lang.ClassLoading" objectname="java.lang:type=ClassLoading">
            <attrib name="Verbose" alias="0Verbose" type="gauge"/>
            <attrib name="LoadedClassCount" alias="0LoadedClassCnt" type="gauge"/>
            <attrib name="UnloadedClassCount" alias="0UnloadedClassCnt" type="gauge"/>
            <attrib name="TotalLoadedClassCount" alias="0TotalLoadeClassCnt" type="gauge"/>
            <attrib name="ObjectName" alias="0ObjectName" type="gauge"/>
         </mbean>
         <mbean name="java.lang.Compilation" objectname="java.lang:type=Compilation">
            <attrib name="Name" alias="0Name" type="gauge"/>
            <attrib name="CompilationTimeMonitoringSupported" alias="0CompTimeMonitSuppo" type="gauge"/>
            <attrib name="TotalCompilationTime" alias="0TotalCompilatiTime" type="gauge"/>
            <attrib name="ObjectName" alias="1ObjectName" type="gauge"/>
         </mbean>
         <mbean name="java.lang.GarbageCollector" objectname="java.lang:name=G1 Old Generation,type=GarbageCollector">
            <attrib name="LastGcInfo" alias="0LastGcInfo" type="gauge"/>
            <attrib name="CollectionCount" alias="0CollectionCnt" type="gauge"/>
            <attrib name="CollectionTime" alias="0CollectionTime" type="gauge"/>
            <attrib name="Valid" alias="0Valid" type="gauge"/>
            <attrib name="Name" alias="1Name" type="gauge"/>
            <attrib name="MemoryPoolNames" alias="0MemPoolNames" type="gauge"/>
            <attrib name="ObjectName" alias="2ObjectName" type="gauge"/>
         </mbean>
         <mbean name="java.lang.GarbageCollector" objectname="java.lang:name=G1 Young Generation,type=GarbageCollector">
            <attrib name="LastGcInfo" alias="1LastGcInfo" type="gauge"/>
            <attrib name="CollectionCount" alias="1CollectionCnt" type="gauge"/>
            <attrib name="CollectionTime" alias="1CollectionTime" type="gauge"/>
            <attrib name="Valid" alias="1Valid" type="gauge"/>
            <attrib name="Name" alias="2Name" type="gauge"/>
            <attrib name="MemoryPoolNames" alias="1MemPoolNames" type="gauge"/>
            <attrib name="ObjectName" alias="3ObjectName" type="gauge"/>
            <comp-attrib name="LastGcInfo" alias="LastGcInfo" type="Composite">
               <comp-member name="GcThreadCount" alias="0LasGcInfoGcThreCnt" type="gauge"/>
               <comp-member name="duration" alias="0LastGcInfoDuration" type="gauge"/>
               <comp-member name="endTime" alias="0LastGcInfoEndTime" type="gauge"/>
               <comp-member name="id" alias="0LastGcInfoId" type="gauge"/>
               <comp-member name="memoryUsageAfterGc" alias="0LaGcInfMemUsaAftGc" type="gauge"/>
               <comp-member name="memoryUsageBeforeGc" alias="0LaGcInfMemUsaBefGc" type="gauge"/>
               <comp-member name="startTime" alias="0LastGcInfoStarTime" type="gauge"/>
            </comp-attrib>
         </mbean>
         <mbean name="java.lang.Memory" objectname="java.lang:type=Memory">
            <attrib name="Verbose" alias="1Verbose" type="gauge"/>
            <attrib name="ObjectPendingFinalizationCount" alias="0ObjecPendiFinalCnt" type="gauge"/>
            <attrib name="HeapMemoryUsage" alias="0HeapMemUsage" type="gauge"/>
            <attrib name="NonHeapMemoryUsage" alias="0NonHeapMemUsage" type="gauge"/>
            <attrib name="ObjectName" alias="4ObjectName" type="gauge"/>
            <comp-attrib name="HeapMemoryUsage" alias="HeapMemoryUsage" type="Composite">
               <comp-member name="committed" alias="0HeapMemUsageCommit" type="gauge"/>
               <comp-member name="init" alias="0HeapMemUsageInit" type="gauge"/>
               <comp-member name="max" alias="0HeapMemUsageMax" type="gauge"/>
               <comp-member name="used" alias="0HeapMemUsageUsed" type="gauge"/>
            </comp-attrib>
            <comp-attrib name="NonHeapMemoryUsage" alias="NonHeapMemoryUsage" type="Composite">
               <comp-member name="committed" alias="0NonHeapMemUsagComm" type="gauge"/>
               <comp-member name="init" alias="0NonHeapMemUsagInit" type="gauge"/>
               <comp-member name="max" alias="0NonHeapMemUsageMax" type="gauge"/>
               <comp-member name="used" alias="0NonHeapMemUsagUsed" type="gauge"/>
            </comp-attrib>
         </mbean>
         <mbean name="java.lang.MemoryManager" objectname="java.lang:name=CodeCacheManager,type=MemoryManager">
            <attrib name="Valid" alias="2Valid" type="gauge"/>
            <attrib name="Name" alias="3Name" type="gauge"/>
            <attrib name="MemoryPoolNames" alias="2MemPoolNames" type="gauge"/>
            <attrib name="ObjectName" alias="5ObjectName" type="gauge"/>
         </mbean>
         <mbean name="java.lang.MemoryManager" objectname="java.lang:name=Metaspace Manager,type=MemoryManager">
            <attrib name="Valid" alias="3Valid" type="gauge"/>
            <attrib name="Name" alias="4Name" type="gauge"/>
            <attrib name="MemoryPoolNames" alias="3MemPoolNames" type="gauge"/>
            <attrib name="ObjectName" alias="6ObjectName" type="gauge"/>
         </mbean>
         <mbean name="java.lang.MemoryPool" objectname="java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool">
            <attrib name="Valid" alias="4Valid" type="gauge"/>
            <attrib name="Name" alias="5Name" type="gauge"/>
            <attrib name="Type" alias="0Type" type="gauge"/>
            <attrib name="Usage" alias="0Usage" type="gauge"/>
            <attrib name="PeakUsage" alias="0PeakUsage" type="gauge"/>
            <attrib name="MemoryManagerNames" alias="0MemManagerNames" type="gauge"/>
            <attrib name="UsageThreshold" alias="0UsageThreshold" type="gauge"/>
            <attrib name="UsageThresholdExceeded" alias="0UsageThreshExceede" type="gauge"/>
            <attrib name="UsageThresholdCount" alias="0UsageThresholdCnt" type="gauge"/>
            <attrib name="UsageThresholdSupported" alias="0UsageThreshSupport" type="gauge"/>
            <attrib name="CollectionUsageThreshold" alias="0CollecUsageThresho" type="gauge"/>
            <attrib name="CollectionUsageThresholdExceeded" alias="0CollUsagThresExcee" type="gauge"/>
            <attrib name="CollectionUsageThresholdCount" alias="0ColleUsageThresCnt" type="gauge"/>
            <attrib name="CollectionUsage" alias="0CollectionUsage" type="gauge"/>
            <attrib name="CollectionUsageThresholdSupported" alias="0CollUsagThresSuppo" type="gauge"/>
            <attrib name="ObjectName" alias="7ObjectName" type="gauge"/>
            <comp-attrib name="Usage" alias="Usage" type="Composite">
               <comp-member name="committed" alias="0UsageCommit" type="gauge"/>
               <comp-member name="init" alias="0UsageInit" type="gauge"/>
               <comp-member name="max" alias="0UsageMax" type="gauge"/>
               <comp-member name="used" alias="0UsageUsed" type="gauge"/>
            </comp-attrib>
            <comp-attrib name="PeakUsage" alias="PeakUsage" type="Composite">
               <comp-member name="committed" alias="0PeakUsageCommit" type="gauge"/>
               <comp-member name="init" alias="0PeakUsageInit" type="gauge"/>
               <comp-member name="max" alias="0PeakUsageMax" type="gauge"/>
               <comp-member name="used" alias="0PeakUsageUsed" type="gauge"/>
            </comp-attrib>
         </mbean>
         <mbean name="java.lang.MemoryPool" objectname="java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool">
            <attrib name="Valid" alias="5Valid" type="gauge"/>
            <attrib name="Name" alias="6Name" type="gauge"/>
            <attrib name="Type" alias="1Type" type="gauge"/>
            <attrib name="Usage" alias="1Usage" type="gauge"/>
            <attrib name="PeakUsage" alias="1PeakUsage" type="gauge"/>
            <attrib name="MemoryManagerNames" alias="1MemManagerNames" type="gauge"/>
            <attrib name="UsageThreshold" alias="1UsageThreshold" type="gauge"/>
            <attrib name="UsageThresholdExceeded" alias="1UsageThreshExceede" type="gauge"/>
            <attrib name="UsageThresholdCount" alias="1UsageThresholdCnt" type="gauge"/>
            <attrib name="UsageThresholdSupported" alias="1UsageThreshSupport" type="gauge"/>
            <attrib name="CollectionUsageThreshold" alias="1CollecUsageThresho" type="gauge"/>
            <attrib name="CollectionUsageThresholdExceeded" alias="1CollUsagThresExcee" type="gauge"/>
            <attrib name="CollectionUsageThresholdCount" alias="1ColleUsageThresCnt" type="gauge"/>
            <attrib name="CollectionUsage" alias="1CollectionUsage" type="gauge"/>
            <attrib name="CollectionUsageThresholdSupported" alias="1CollUsagThresSuppo" type="gauge"/>
            <attrib name="ObjectName" alias="8ObjectName" type="gauge"/>
            <comp-attrib name="Usage" alias="Usage" type="Composite">
               <comp-member name="committed" alias="1UsageCommit" type="gauge"/>
               <comp-member name="init" alias="1UsageInit" type="gauge"/>
               <comp-member name="max" alias="1UsageMax" type="gauge"/>
               <comp-member name="used" alias="1UsageUsed" type="gauge"/>
            </comp-attrib>
            <comp-attrib name="PeakUsage" alias="PeakUsage" type="Composite">
               <comp-member name="committed" alias="1PeakUsageCommit" type="gauge"/>
               <comp-member name="init" alias="1PeakUsageInit" type="gauge"/>
               <comp-member name="max" alias="1PeakUsageMax" type="gauge"/>
               <comp-member name="used" alias="1PeakUsageUsed" type="gauge"/>
            </comp-attrib>
         </mbean>
         <mbean name="java.lang.MemoryPool" objectname="java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool">
            <attrib name="Valid" alias="6Valid" type="gauge"/>
            <attrib name="Name" alias="7Name" type="gauge"/>
            <attrib name="Type" alias="2Type" type="gauge"/>
            <attrib name="Usage" alias="2Usage" type="gauge"/>
            <attrib name="PeakUsage" alias="2PeakUsage" type="gauge"/>
            <attrib name="MemoryManagerNames" alias="2MemManagerNames" type="gauge"/>
            <attrib name="UsageThreshold" alias="2UsageThreshold" type="gauge"/>
            <attrib name="UsageThresholdExceeded" alias="2UsageThreshExceede" type="gauge"/>
            <attrib name="UsageThresholdCount" alias="2UsageThresholdCnt" type="gauge"/>
            <attrib name="UsageThresholdSupported" alias="2UsageThreshSupport" type="gauge"/>
            <attrib name="CollectionUsageThreshold" alias="2CollecUsageThresho" type="gauge"/>
            <attrib name="CollectionUsageThresholdExceeded" alias="2CollUsagThresExcee" type="gauge"/>
            <attrib name="CollectionUsageThresholdCount" alias="2ColleUsageThresCnt" type="gauge"/>
            <attrib name="CollectionUsage" alias="2CollectionUsage" type="gauge"/>
            <attrib name="CollectionUsageThresholdSupported" alias="2CollUsagThresSuppo" type="gauge"/>
            <attrib name="ObjectName" alias="9ObjectName" type="gauge"/>
            <comp-attrib name="Usage" alias="Usage" type="Composite">
               <comp-member name="committed" alias="2UsageCommit" type="gauge"/>
               <comp-member name="init" alias="2UsageInit" type="gauge"/>
               <comp-member name="max" alias="2UsageMax" type="gauge"/>
               <comp-member name="used" alias="2UsageUsed" type="gauge"/>
            </comp-attrib>
            <comp-attrib name="PeakUsage" alias="PeakUsage" type="Composite">
               <comp-member name="committed" alias="2PeakUsageCommit" type="gauge"/>
               <comp-member name="init" alias="2PeakUsageInit" type="gauge"/>
               <comp-member name="max" alias="2PeakUsageMax" type="gauge"/>
               <comp-member name="used" alias="2PeakUsageUsed" type="gauge"/>
            </comp-attrib>
         </mbean>
         <mbean name="java.lang.MemoryPool" objectname="java.lang:name=Compressed Class Space,type=MemoryPool">
            <attrib name="Valid" alias="7Valid" type="gauge"/>
            <attrib name="Name" alias="8Name" type="gauge"/>
            <attrib name="Type" alias="3Type" type="gauge"/>
            <attrib name="Usage" alias="3Usage" type="gauge"/>
            <attrib name="PeakUsage" alias="3PeakUsage" type="gauge"/>
            <attrib name="MemoryManagerNames" alias="3MemManagerNames" type="gauge"/>
            <attrib name="UsageThreshold" alias="3UsageThreshold" type="gauge"/>
            <attrib name="UsageThresholdExceeded" alias="3UsageThreshExceede" type="gauge"/>
            <attrib name="UsageThresholdCount" alias="3UsageThresholdCnt" type="gauge"/>
            <attrib name="UsageThresholdSupported" alias="3UsageThreshSupport" type="gauge"/>
            <attrib name="CollectionUsageThreshold" alias="3CollecUsageThresho" type="gauge"/>
            <attrib name="CollectionUsageThresholdExceeded" alias="3CollUsagThresExcee" type="gauge"/>
            <attrib name="CollectionUsageThresholdCount" alias="3ColleUsageThresCnt" type="gauge"/>
            <attrib name="CollectionUsage" alias="3CollectionUsage" type="gauge"/>
            <attrib name="CollectionUsageThresholdSupported" alias="3CollUsagThresSuppo" type="gauge"/>
            <attrib name="ObjectName" alias="10ObjectName" type="gauge"/>
            <comp-attrib name="Usage" alias="Usage" type="Composite">
               <comp-member name="committed" alias="3UsageCommit" type="gauge"/>
               <comp-member name="init" alias="3UsageInit" type="gauge"/>
               <comp-member name="max" alias="3UsageMax" type="gauge"/>
               <comp-member name="used" alias="3UsageUsed" type="gauge"/>
            </comp-attrib>
            <comp-attrib name="PeakUsage" alias="PeakUsage" type="Composite">
               <comp-member name="committed" alias="3PeakUsageCommit" type="gauge"/>
               <comp-member name="init" alias="3PeakUsageInit" type="gauge"/>
               <comp-member name="max" alias="3PeakUsageMax" type="gauge"/>
               <comp-member name="used" alias="3PeakUsageUsed" type="gauge"/>
            </comp-attrib>
         </mbean>
         <mbean name="java.lang.MemoryPool" objectname="java.lang:name=G1 Eden Space,type=MemoryPool">
            <attrib name="Valid" alias="8Valid" type="gauge"/>
            <attrib name="Name" alias="9Name" type="gauge"/>
            <attrib name="Type" alias="4Type" type="gauge"/>
            <attrib name="Usage" alias="4Usage" type="gauge"/>
            <attrib name="PeakUsage" alias="4PeakUsage" type="gauge"/>
            <attrib name="MemoryManagerNames" alias="4MemManagerNames" type="gauge"/>
            <attrib name="UsageThreshold" alias="4UsageThreshold" type="gauge"/>
            <attrib name="UsageThresholdExceeded" alias="4UsageThreshExceede" type="gauge"/>
            <attrib name="UsageThresholdCount" alias="4UsageThresholdCnt" type="gauge"/>
            <attrib name="UsageThresholdSupported" alias="4UsageThreshSupport" type="gauge"/>
            <attrib name="CollectionUsageThreshold" alias="4CollecUsageThresho" type="gauge"/>
            <attrib name="CollectionUsageThresholdExceeded" alias="4CollUsagThresExcee" type="gauge"/>
            <attrib name="CollectionUsageThresholdCount" alias="4ColleUsageThresCnt" type="gauge"/>
            <attrib name="CollectionUsage" alias="4CollectionUsage" type="gauge"/>
            <attrib name="CollectionUsageThresholdSupported" alias="4CollUsagThresSuppo" type="gauge"/>
            <attrib name="ObjectName" alias="11ObjectName" type="gauge"/>
            <comp-attrib name="Usage" alias="Usage" type="Composite">
               <comp-member name="committed" alias="4UsageCommit" type="gauge"/>
               <comp-member name="init" alias="4UsageInit" type="gauge"/>
               <comp-member name="max" alias="4UsageMax" type="gauge"/>
               <comp-member name="used" alias="4UsageUsed" type="gauge"/>
            </comp-attrib>
            <comp-attrib name="PeakUsage" alias="PeakUsage" type="Composite">
               <comp-member name="committed" alias="4PeakUsageCommit" type="gauge"/>
               <comp-member name="init" alias="4PeakUsageInit" type="gauge"/>
               <comp-member name="max" alias="4PeakUsageMax" type="gauge"/>
               <comp-member name="used" alias="4PeakUsageUsed" type="gauge"/>
            </comp-attrib>
            <comp-attrib name="CollectionUsage" alias="CollectionUsage" type="Composite">
               <comp-member name="committed" alias="0CollectUsageCommit" type="gauge"/>
               <comp-member name="init" alias="0CollectioUsageInit" type="gauge"/>
               <comp-member name="max" alias="0CollectionUsageMax" type="gauge"/>
               <comp-member name="used" alias="0CollectioUsageUsed" type="gauge"/>
            </comp-attrib>
         </mbean>
         <mbean name="java.lang.MemoryPool" objectname="java.lang:name=G1 Old Gen,type=MemoryPool">
            <attrib name="Valid" alias="9Valid" type="gauge"/>
            <attrib name="Name" alias="10Name" type="gauge"/>
            <attrib name="Type" alias="5Type" type="gauge"/>
            <attrib name="Usage" alias="5Usage" type="gauge"/>
            <attrib name="PeakUsage" alias="5PeakUsage" type="gauge"/>
            <attrib name="MemoryManagerNames" alias="5MemManagerNames" type="gauge"/>
            <attrib name="UsageThreshold" alias="5UsageThreshold" type="gauge"/>
            <attrib name="UsageThresholdExceeded" alias="5UsageThreshExceede" type="gauge"/>
            <attrib name="UsageThresholdCount" alias="5UsageThresholdCnt" type="gauge"/>
            <attrib name="UsageThresholdSupported" alias="5UsageThreshSupport" type="gauge"/>
            <attrib name="CollectionUsageThreshold" alias="5CollecUsageThresho" type="gauge"/>
            <attrib name="CollectionUsageThresholdExceeded" alias="5CollUsagThresExcee" type="gauge"/>
            <attrib name="CollectionUsageThresholdCount" alias="5ColleUsageThresCnt" type="gauge"/>
            <attrib name="CollectionUsage" alias="5CollectionUsage" type="gauge"/>
            <attrib name="CollectionUsageThresholdSupported" alias="5CollUsagThresSuppo" type="gauge"/>
            <attrib name="ObjectName" alias="12ObjectName" type="gauge"/>
            <comp-attrib name="Usage" alias="Usage" type="Composite">
               <comp-member name="committed" alias="5UsageCommit" type="gauge"/>
               <comp-member name="init" alias="5UsageInit" type="gauge"/>
               <comp-member name="max" alias="5UsageMax" type="gauge"/>
               <comp-member name="used" alias="5UsageUsed" type="gauge"/>
            </comp-attrib>
            <comp-attrib name="PeakUsage" alias="PeakUsage" type="Composite">
               <comp-member name="committed" alias="5PeakUsageCommit" type="gauge"/>
               <comp-member name="init" alias="5PeakUsageInit" type="gauge"/>
               <comp-member name="max" alias="5PeakUsageMax" type="gauge"/>
               <comp-member name="used" alias="5PeakUsageUsed" type="gauge"/>
            </comp-attrib>
            <comp-attrib name="CollectionUsage" alias="CollectionUsage" type="Composite">
               <comp-member name="committed" alias="1CollectUsageCommit" type="gauge"/>
               <comp-member name="init" alias="1CollectioUsageInit" type="gauge"/>
               <comp-member name="max" alias="1CollectionUsageMax" type="gauge"/>
               <comp-member name="used" alias="1CollectioUsageUsed" type="gauge"/>
            </comp-attrib>
         </mbean>
         <mbean name="java.lang.MemoryPool" objectname="java.lang:name=G1 Survivor Space,type=MemoryPool">
            <attrib name="Valid" alias="10Valid" type="gauge"/>
            <attrib name="Name" alias="11Name" type="gauge"/>
            <attrib name="Type" alias="6Type" type="gauge"/>
            <attrib name="Usage" alias="6Usage" type="gauge"/>
            <attrib name="PeakUsage" alias="6PeakUsage" type="gauge"/>
            <attrib name="MemoryManagerNames" alias="6MemManagerNames" type="gauge"/>
            <attrib name="UsageThreshold" alias="6UsageThreshold" type="gauge"/>
            <attrib name="UsageThresholdExceeded" alias="6UsageThreshExceede" type="gauge"/>
            <attrib name="UsageThresholdCount" alias="6UsageThresholdCnt" type="gauge"/>
            <attrib name="UsageThresholdSupported" alias="6UsageThreshSupport" type="gauge"/>
            <attrib name="CollectionUsageThreshold" alias="6CollecUsageThresho" type="gauge"/>
            <attrib name="CollectionUsageThresholdExceeded" alias="6CollUsagThresExcee" type="gauge"/>
            <attrib name="CollectionUsageThresholdCount" alias="6ColleUsageThresCnt" type="gauge"/>
            <attrib name="CollectionUsage" alias="6CollectionUsage" type="gauge"/>
            <attrib name="CollectionUsageThresholdSupported" alias="6CollUsagThresSuppo" type="gauge"/>
            <attrib name="ObjectName" alias="13ObjectName" type="gauge"/>
            <comp-attrib name="Usage" alias="Usage" type="Composite">
               <comp-member name="committed" alias="6UsageCommit" type="gauge"/>
               <comp-member name="init" alias="6UsageInit" type="gauge"/>
               <comp-member name="max" alias="6UsageMax" type="gauge"/>
               <comp-member name="used" alias="6UsageUsed" type="gauge"/>
            </comp-attrib>
            <comp-attrib name="PeakUsage" alias="PeakUsage" type="Composite">
               <comp-member name="committed" alias="6PeakUsageCommit" type="gauge"/>
               <comp-member name="init" alias="6PeakUsageInit" type="gauge"/>
               <comp-member name="max" alias="6PeakUsageMax" type="gauge"/>
               <comp-member name="used" alias="6PeakUsageUsed" type="gauge"/>
            </comp-attrib>
            <comp-attrib name="CollectionUsage" alias="CollectionUsage" type="Composite">
               <comp-member name="committed" alias="2CollectUsageCommit" type="gauge"/>
               <comp-member name="init" alias="2CollectioUsageInit" type="gauge"/>
               <comp-member name="max" alias="2CollectionUsageMax" type="gauge"/>
               <comp-member name="used" alias="2CollectioUsageUsed" type="gauge"/>
            </comp-attrib>
         </mbean>
         <mbean name="java.lang.MemoryPool" objectname="java.lang:name=Metaspace,type=MemoryPool">
            <attrib name="Valid" alias="11Valid" type="gauge"/>
            <attrib name="Name" alias="12Name" type="gauge"/>
            <attrib name="Type" alias="7Type" type="gauge"/>
            <attrib name="Usage" alias="7Usage" type="gauge"/>
            <attrib name="PeakUsage" alias="7PeakUsage" type="gauge"/>
            <attrib name="MemoryManagerNames" alias="7MemManagerNames" type="gauge"/>
            <attrib name="UsageThreshold" alias="7UsageThreshold" type="gauge"/>
            <attrib name="UsageThresholdExceeded" alias="7UsageThreshExceede" type="gauge"/>
            <attrib name="UsageThresholdCount" alias="7UsageThresholdCnt" type="gauge"/>
            <attrib name="UsageThresholdSupported" alias="7UsageThreshSupport" type="gauge"/>
            <attrib name="CollectionUsageThreshold" alias="7CollecUsageThresho" type="gauge"/>
            <attrib name="CollectionUsageThresholdExceeded" alias="7CollUsagThresExcee" type="gauge"/>
            <attrib name="CollectionUsageThresholdCount" alias="7ColleUsageThresCnt" type="gauge"/>
            <attrib name="CollectionUsage" alias="7CollectionUsage" type="gauge"/>
            <attrib name="CollectionUsageThresholdSupported" alias="7CollUsagThresSuppo" type="gauge"/>
            <attrib name="ObjectName" alias="14ObjectName" type="gauge"/>
            <comp-attrib name="Usage" alias="Usage" type="Composite">
               <comp-member name="committed" alias="7UsageCommit" type="gauge"/>
               <comp-member name="init" alias="7UsageInit" type="gauge"/>
               <comp-member name="max" alias="7UsageMax" type="gauge"/>
               <comp-member name="used" alias="7UsageUsed" type="gauge"/>
            </comp-attrib>
            <comp-attrib name="PeakUsage" alias="PeakUsage" type="Composite">
               <comp-member name="committed" alias="7PeakUsageCommit" type="gauge"/>
               <comp-member name="init" alias="7PeakUsageInit" type="gauge"/>
               <comp-member name="max" alias="7PeakUsageMax" type="gauge"/>
               <comp-member name="used" alias="7PeakUsageUsed" type="gauge"/>
            </comp-attrib>
         </mbean>
         <mbean name="java.lang.OperatingSystem" objectname="java.lang:type=OperatingSystem">
            <attrib name="OpenFileDescriptorCount" alias="0OpenFileDescripCnt" type="gauge"/>
            <attrib name="MaxFileDescriptorCount" alias="0MaxFileDescriptCnt" type="gauge"/>
            <attrib name="CommittedVirtualMemorySize" alias="0CommitVirtMemSize" type="gauge"/>
            <attrib name="TotalSwapSpaceSize" alias="0TotalSwapSpaceSize" type="gauge"/>
            <attrib name="FreeSwapSpaceSize" alias="0FreeSwapSpaceSize" type="gauge"/>
            <attrib name="ProcessCpuTime" alias="0ProcessCpuTime" type="gauge"/>
            <attrib name="FreePhysicalMemorySize" alias="0FreePhysicaMemSize" type="gauge"/>
            <attrib name="TotalPhysicalMemorySize" alias="0TotalPhysicMemSize" type="gauge"/>
            <attrib name="SystemCpuLoad" alias="0SysCpuLoad" type="gauge"/>
            <attrib name="ProcessCpuLoad" alias="0ProcessCpuLoad" type="gauge"/>
            <attrib name="Version" alias="0Version" type="gauge"/>
            <attrib name="Name" alias="13Name" type="gauge"/>
            <attrib name="AvailableProcessors" alias="0AvailProcessors" type="gauge"/>
            <attrib name="Arch" alias="0Arch" type="gauge"/>
            <attrib name="SystemLoadAverage" alias="0SysLoadAvg" type="gauge"/>
            <attrib name="ObjectName" alias="15ObjectName" type="gauge"/>
         </mbean>
         <mbean name="java.lang.Runtime" objectname="java.lang:type=Runtime">
            <attrib name="ClassPath" alias="0ClassPath" type="gauge"/>
            <attrib name="Name" alias="14Name" type="gauge"/>
            <attrib name="BootClassPathSupported" alias="0BootClassPathSuppo" type="gauge"/>
            <attrib name="VmName" alias="0VmName" type="gauge"/>
            <attrib name="VmVendor" alias="0VmVendor" type="gauge"/>
            <attrib name="VmVersion" alias="0VmVersion" type="gauge"/>
            <attrib name="LibraryPath" alias="0LibraryPath" type="gauge"/>
            <attrib name="BootClassPath" alias="0BootClassPath" type="gauge"/>
            <attrib name="Uptime" alias="0Uptime" type="gauge"/>
            <attrib name="ManagementSpecVersion" alias="0ManagemSpecVersion" type="gauge"/>
            <attrib name="SpecName" alias="0SpecName" type="gauge"/>
            <attrib name="SpecVendor" alias="0SpecVendor" type="gauge"/>
            <attrib name="SpecVersion" alias="0SpecVersion" type="gauge"/>
            <attrib name="InputArguments" alias="0InputArguments" type="gauge"/>
            <attrib name="StartTime" alias="0StartTime" type="gauge"/>
            <attrib name="SystemProperties" alias="0SysProperties" type="gauge"/>
            <attrib name="Pid" alias="0Pid" type="gauge"/>
            <attrib name="ObjectName" alias="16ObjectName" type="gauge"/>
         </mbean>
         <mbean name="java.lang.Threading" objectname="java.lang:type=Threading">
            <attrib name="ThreadAllocatedMemorySupported" alias="0ThreaAllocMemSuppo" type="gauge"/>
            <attrib name="ThreadAllocatedMemoryEnabled" alias="0ThreaAllocMemEnabl" type="gauge"/>
            <attrib name="CurrentThreadAllocatedBytes" alias="0CurrThreAllocBytes" type="gauge"/>
            <attrib name="ThreadContentionMonitoringEnabled" alias="0ThreContMonitEnabl" type="gauge"/>
            <attrib name="ThreadContentionMonitoringSupported" alias="0ThreContMonitSuppo" type="gauge"/>
            <attrib name="CurrentThreadCpuTimeSupported" alias="0CurThreCpuTimeSupp" type="gauge"/>
            <attrib name="ObjectMonitorUsageSupported" alias="0ObjeMoniUsageSuppo" type="gauge"/>
            <attrib name="SynchronizerUsageSupported" alias="0SynchrUsageSupport" type="gauge"/>
            <attrib name="ThreadCpuTimeEnabled" alias="0ThreaCpuTimeEnable" type="gauge"/>
            <attrib name="PeakThreadCount" alias="0PeakThreadCnt" type="gauge"/>
            <attrib name="DaemonThreadCount" alias="0DaemonThreadCnt" type="gauge"/>
            <attrib name="ThreadCount" alias="0ThreadCnt" type="gauge"/>
            <attrib name="TotalStartedThreadCount" alias="0TotalStartThreaCnt" type="gauge"/>
            <attrib name="AllThreadIds" alias="0AllThreadIds" type="gauge"/>
            <attrib name="CurrentThreadCpuTime" alias="0CurreThreadCpuTime" type="gauge"/>
            <attrib name="CurrentThreadUserTime" alias="0CurreThreadUsrTime" type="gauge"/>
            <attrib name="ThreadCpuTimeSupported" alias="0ThreaCpuTimeSuppor" type="gauge"/>
            <attrib name="ObjectName" alias="17ObjectName" type="gauge"/>
         </mbean>
      </mbeans>
   </jmx-collection>
</jmx-datacollection-config>
```

```
java -jar /usr/share/java/opennms/opennms_jmx_config_generator.jar generate-graph --input JMX-DatacollectionDummy.xml --output mygraph.properties

reports=java.lang.ClassLoading.MBeanReport, \

java.lang.ClassLoading.0Verbose.AttributeReport, \

java.lang.ClassLoading.0LoadedClassCnt.AttributeReport, \

java.lang.ClassLoading.0UnloadedClassCnt.AttributeReport, \

java.lang.ClassLoading.0TotalLoadeClassCnt.AttributeReport, \

java.lang.ClassLoading.0ObjectName.AttributeReport, \

java.lang.Compilation.MBeanReport, \

java.lang.Compilation.0Name.AttributeReport, \

java.lang.Compilation.0CompTimeMonitSuppo.AttributeReport, \

java.lang.Compilation.0TotalCompilatiTime.AttributeReport, \

java.lang.Compilation.1ObjectName.AttributeReport, \

java.lang.GarbageCollector.MBeanReport, \

java.lang.GarbageCollector.0LastGcInfo.AttributeReport, \

java.lang.GarbageCollector.0CollectionCnt.AttributeReport, \

java.lang.GarbageCollector.0CollectionTime.AttributeReport, \

java.lang.GarbageCollector.0Valid.AttributeReport, \

java.lang.GarbageCollector.1Name.AttributeReport, \

java.lang.GarbageCollector.0MemPoolNames.AttributeReport, \

java.lang.GarbageCollector.2ObjectName.AttributeReport, \

java.lang.GarbageCollector.MBeanReport, \

java.lang.GarbageCollector.1LastGcInfo.AttributeReport, \

java.lang.GarbageCollector.1CollectionCnt.AttributeReport, \

java.lang.GarbageCollector.1CollectionTime.AttributeReport, \

java.lang.GarbageCollector.1Valid.AttributeReport, \

java.lang.GarbageCollector.2Name.AttributeReport, \

java.lang.GarbageCollector.1MemPoolNames.AttributeReport, \

java.lang.GarbageCollector.3ObjectName.AttributeReport, \

java.lang.GarbageCollector.LastGcInfo.CompositeReport, \

java.lang.GarbageCollector.LastGcInfo.GcThreadCount.CompositeAttributeReport, \

java.lang.GarbageCollector.LastGcInfo.duration.CompositeAttributeReport, \

java.lang.GarbageCollector.LastGcInfo.endTime.CompositeAttributeReport, \

java.lang.GarbageCollector.LastGcInfo.id.CompositeAttributeReport, \

java.lang.GarbageCollector.LastGcInfo.memoryUsageAfterGc.CompositeAttributeReport, \

java.lang.GarbageCollector.LastGcInfo.memoryUsageBeforeGc.CompositeAttributeReport, \

java.lang.GarbageCollector.LastGcInfo.startTime.CompositeAttributeReport, \

java.lang.Memory.MBeanReport, \

java.lang.Memory.1Verbose.AttributeReport, \

java.lang.Memory.0ObjecPendiFinalCnt.AttributeReport, \

java.lang.Memory.0HeapMemUsage.AttributeReport, \

java.lang.Memory.0NonHeapMemUsage.AttributeReport, \

java.lang.Memory.4ObjectName.AttributeReport, \

java.lang.Memory.HeapMemoryUsage.CompositeReport, \

java.lang.Memory.NonHeapMemoryUsage.CompositeReport, \

java.lang.Memory.HeapMemoryUsage.committed.CompositeAttributeReport, \

java.lang.Memory.HeapMemoryUsage.init.CompositeAttributeReport, \

java.lang.Memory.HeapMemoryUsage.max.CompositeAttributeReport, \

java.lang.Memory.HeapMemoryUsage.used.CompositeAttributeReport, \

java.lang.Memory.NonHeapMemoryUsage.committed.CompositeAttributeReport, \

java.lang.Memory.NonHeapMemoryUsage.init.CompositeAttributeReport, \

java.lang.Memory.NonHeapMemoryUsage.max.CompositeAttributeReport, \

java.lang.Memory.NonHeapMemoryUsage.used.CompositeAttributeReport, \

java.lang.MemoryManager.MBeanReport, \

java.lang.MemoryManager.2Valid.AttributeReport, \

java.lang.MemoryManager.3Name.AttributeReport, \

java.lang.MemoryManager.2MemPoolNames.AttributeReport, \

java.lang.MemoryManager.5ObjectName.AttributeReport, \

java.lang.MemoryManager.MBeanReport, \

java.lang.MemoryManager.3Valid.AttributeReport, \

java.lang.MemoryManager.4Name.AttributeReport, \

java.lang.MemoryManager.3MemPoolNames.AttributeReport, \

java.lang.MemoryManager.6ObjectName.AttributeReport, \

java.lang.MemoryPool.MBeanReport, \

java.lang.MemoryPool.4Valid.AttributeReport, \

java.lang.MemoryPool.5Name.AttributeReport, \

java.lang.MemoryPool.0Type.AttributeReport, \

java.lang.MemoryPool.0Usage.AttributeReport, \

java.lang.MemoryPool.0PeakUsage.AttributeReport, \

java.lang.MemoryPool.0MemManagerNames.AttributeReport, \

java.lang.MemoryPool.0UsageThreshold.AttributeReport, \

java.lang.MemoryPool.0UsageThreshExceede.AttributeReport, \

java.lang.MemoryPool.0UsageThresholdCnt.AttributeReport, \

java.lang.MemoryPool.0UsageThreshSupport.AttributeReport, \

java.lang.MemoryPool.0CollecUsageThresho.AttributeReport, \

java.lang.MemoryPool.0CollUsagThresExcee.AttributeReport, \

java.lang.MemoryPool.0ColleUsageThresCnt.AttributeReport, \

java.lang.MemoryPool.0CollectionUsage.AttributeReport, \

java.lang.MemoryPool.0CollUsagThresSuppo.AttributeReport, \

java.lang.MemoryPool.7ObjectName.AttributeReport, \

java.lang.MemoryPool.Usage.CompositeReport, \

java.lang.MemoryPool.PeakUsage.CompositeReport, \

java.lang.MemoryPool.Usage.committed.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.init.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.max.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.used.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport, \

java.lang.MemoryPool.MBeanReport, \

java.lang.MemoryPool.5Valid.AttributeReport, \

java.lang.MemoryPool.6Name.AttributeReport, \

java.lang.MemoryPool.1Type.AttributeReport, \

java.lang.MemoryPool.1Usage.AttributeReport, \

java.lang.MemoryPool.1PeakUsage.AttributeReport, \

java.lang.MemoryPool.1MemManagerNames.AttributeReport, \

java.lang.MemoryPool.1UsageThreshold.AttributeReport, \

java.lang.MemoryPool.1UsageThreshExceede.AttributeReport, \

java.lang.MemoryPool.1UsageThresholdCnt.AttributeReport, \

java.lang.MemoryPool.1UsageThreshSupport.AttributeReport, \

java.lang.MemoryPool.1CollecUsageThresho.AttributeReport, \

java.lang.MemoryPool.1CollUsagThresExcee.AttributeReport, \

java.lang.MemoryPool.1ColleUsageThresCnt.AttributeReport, \

java.lang.MemoryPool.1CollectionUsage.AttributeReport, \

java.lang.MemoryPool.1CollUsagThresSuppo.AttributeReport, \

java.lang.MemoryPool.8ObjectName.AttributeReport, \

java.lang.MemoryPool.Usage.CompositeReport, \

java.lang.MemoryPool.PeakUsage.CompositeReport, \

java.lang.MemoryPool.Usage.committed.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.init.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.max.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.used.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport, \

java.lang.MemoryPool.MBeanReport, \

java.lang.MemoryPool.6Valid.AttributeReport, \

java.lang.MemoryPool.7Name.AttributeReport, \

java.lang.MemoryPool.2Type.AttributeReport, \

java.lang.MemoryPool.2Usage.AttributeReport, \

java.lang.MemoryPool.2PeakUsage.AttributeReport, \

java.lang.MemoryPool.2MemManagerNames.AttributeReport, \

java.lang.MemoryPool.2UsageThreshold.AttributeReport, \

java.lang.MemoryPool.2UsageThreshExceede.AttributeReport, \

java.lang.MemoryPool.2UsageThresholdCnt.AttributeReport, \

java.lang.MemoryPool.2UsageThreshSupport.AttributeReport, \

java.lang.MemoryPool.2CollecUsageThresho.AttributeReport, \

java.lang.MemoryPool.2CollUsagThresExcee.AttributeReport, \

java.lang.MemoryPool.2ColleUsageThresCnt.AttributeReport, \

java.lang.MemoryPool.2CollectionUsage.AttributeReport, \

java.lang.MemoryPool.2CollUsagThresSuppo.AttributeReport, \

java.lang.MemoryPool.9ObjectName.AttributeReport, \

java.lang.MemoryPool.Usage.CompositeReport, \

java.lang.MemoryPool.PeakUsage.CompositeReport, \

java.lang.MemoryPool.Usage.committed.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.init.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.max.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.used.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport, \

java.lang.MemoryPool.MBeanReport, \

java.lang.MemoryPool.7Valid.AttributeReport, \

java.lang.MemoryPool.8Name.AttributeReport, \

java.lang.MemoryPool.3Type.AttributeReport, \

java.lang.MemoryPool.3Usage.AttributeReport, \

java.lang.MemoryPool.3PeakUsage.AttributeReport, \

java.lang.MemoryPool.3MemManagerNames.AttributeReport, \

java.lang.MemoryPool.3UsageThreshold.AttributeReport, \

java.lang.MemoryPool.3UsageThreshExceede.AttributeReport, \

java.lang.MemoryPool.3UsageThresholdCnt.AttributeReport, \

java.lang.MemoryPool.3UsageThreshSupport.AttributeReport, \

java.lang.MemoryPool.3CollecUsageThresho.AttributeReport, \

java.lang.MemoryPool.3CollUsagThresExcee.AttributeReport, \

java.lang.MemoryPool.3ColleUsageThresCnt.AttributeReport, \

java.lang.MemoryPool.3CollectionUsage.AttributeReport, \

java.lang.MemoryPool.3CollUsagThresSuppo.AttributeReport, \

java.lang.MemoryPool.10ObjectName.AttributeReport, \

java.lang.MemoryPool.Usage.CompositeReport, \

java.lang.MemoryPool.PeakUsage.CompositeReport, \

java.lang.MemoryPool.Usage.committed.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.init.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.max.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.used.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport, \

java.lang.MemoryPool.MBeanReport, \

java.lang.MemoryPool.8Valid.AttributeReport, \

java.lang.MemoryPool.9Name.AttributeReport, \

java.lang.MemoryPool.4Type.AttributeReport, \

java.lang.MemoryPool.4Usage.AttributeReport, \

java.lang.MemoryPool.4PeakUsage.AttributeReport, \

java.lang.MemoryPool.4MemManagerNames.AttributeReport, \

java.lang.MemoryPool.4UsageThreshold.AttributeReport, \

java.lang.MemoryPool.4UsageThreshExceede.AttributeReport, \

java.lang.MemoryPool.4UsageThresholdCnt.AttributeReport, \

java.lang.MemoryPool.4UsageThreshSupport.AttributeReport, \

java.lang.MemoryPool.4CollecUsageThresho.AttributeReport, \

java.lang.MemoryPool.4CollUsagThresExcee.AttributeReport, \

java.lang.MemoryPool.4ColleUsageThresCnt.AttributeReport, \

java.lang.MemoryPool.4CollectionUsage.AttributeReport, \

java.lang.MemoryPool.4CollUsagThresSuppo.AttributeReport, \

java.lang.MemoryPool.11ObjectName.AttributeReport, \

java.lang.MemoryPool.Usage.CompositeReport, \

java.lang.MemoryPool.PeakUsage.CompositeReport, \

java.lang.MemoryPool.CollectionUsage.CompositeReport, \

java.lang.MemoryPool.Usage.committed.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.init.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.max.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.used.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport, \

java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport, \

java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport, \

java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport, \

java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport, \

java.lang.MemoryPool.MBeanReport, \

java.lang.MemoryPool.9Valid.AttributeReport, \

java.lang.MemoryPool.10Name.AttributeReport, \

java.lang.MemoryPool.5Type.AttributeReport, \

java.lang.MemoryPool.5Usage.AttributeReport, \

java.lang.MemoryPool.5PeakUsage.AttributeReport, \

java.lang.MemoryPool.5MemManagerNames.AttributeReport, \

java.lang.MemoryPool.5UsageThreshold.AttributeReport, \

java.lang.MemoryPool.5UsageThreshExceede.AttributeReport, \

java.lang.MemoryPool.5UsageThresholdCnt.AttributeReport, \

java.lang.MemoryPool.5UsageThreshSupport.AttributeReport, \

java.lang.MemoryPool.5CollecUsageThresho.AttributeReport, \

java.lang.MemoryPool.5CollUsagThresExcee.AttributeReport, \

java.lang.MemoryPool.5ColleUsageThresCnt.AttributeReport, \

java.lang.MemoryPool.5CollectionUsage.AttributeReport, \

java.lang.MemoryPool.5CollUsagThresSuppo.AttributeReport, \

java.lang.MemoryPool.12ObjectName.AttributeReport, \

java.lang.MemoryPool.Usage.CompositeReport, \

java.lang.MemoryPool.PeakUsage.CompositeReport, \

java.lang.MemoryPool.CollectionUsage.CompositeReport, \

java.lang.MemoryPool.Usage.committed.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.init.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.max.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.used.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport, \

java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport, \

java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport, \

java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport, \

java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport, \

java.lang.MemoryPool.MBeanReport, \

java.lang.MemoryPool.10Valid.AttributeReport, \

java.lang.MemoryPool.11Name.AttributeReport, \

java.lang.MemoryPool.6Type.AttributeReport, \

java.lang.MemoryPool.6Usage.AttributeReport, \

java.lang.MemoryPool.6PeakUsage.AttributeReport, \

java.lang.MemoryPool.6MemManagerNames.AttributeReport, \

java.lang.MemoryPool.6UsageThreshold.AttributeReport, \

java.lang.MemoryPool.6UsageThreshExceede.AttributeReport, \

java.lang.MemoryPool.6UsageThresholdCnt.AttributeReport, \

java.lang.MemoryPool.6UsageThreshSupport.AttributeReport, \

java.lang.MemoryPool.6CollecUsageThresho.AttributeReport, \

java.lang.MemoryPool.6CollUsagThresExcee.AttributeReport, \

java.lang.MemoryPool.6ColleUsageThresCnt.AttributeReport, \

java.lang.MemoryPool.6CollectionUsage.AttributeReport, \

java.lang.MemoryPool.6CollUsagThresSuppo.AttributeReport, \

java.lang.MemoryPool.13ObjectName.AttributeReport, \

java.lang.MemoryPool.Usage.CompositeReport, \

java.lang.MemoryPool.PeakUsage.CompositeReport, \

java.lang.MemoryPool.CollectionUsage.CompositeReport, \

java.lang.MemoryPool.Usage.committed.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.init.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.max.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.used.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport, \

java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport, \

java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport, \

java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport, \

java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport, \

java.lang.MemoryPool.MBeanReport, \

java.lang.MemoryPool.11Valid.AttributeReport, \

java.lang.MemoryPool.12Name.AttributeReport, \

java.lang.MemoryPool.7Type.AttributeReport, \

java.lang.MemoryPool.7Usage.AttributeReport, \

java.lang.MemoryPool.7PeakUsage.AttributeReport, \

java.lang.MemoryPool.7MemManagerNames.AttributeReport, \

java.lang.MemoryPool.7UsageThreshold.AttributeReport, \

java.lang.MemoryPool.7UsageThreshExceede.AttributeReport, \

java.lang.MemoryPool.7UsageThresholdCnt.AttributeReport, \

java.lang.MemoryPool.7UsageThreshSupport.AttributeReport, \

java.lang.MemoryPool.7CollecUsageThresho.AttributeReport, \

java.lang.MemoryPool.7CollUsagThresExcee.AttributeReport, \

java.lang.MemoryPool.7ColleUsageThresCnt.AttributeReport, \

java.lang.MemoryPool.7CollectionUsage.AttributeReport, \

java.lang.MemoryPool.7CollUsagThresSuppo.AttributeReport, \

java.lang.MemoryPool.14ObjectName.AttributeReport, \

java.lang.MemoryPool.Usage.CompositeReport, \

java.lang.MemoryPool.PeakUsage.CompositeReport, \

java.lang.MemoryPool.Usage.committed.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.init.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.max.CompositeAttributeReport, \

java.lang.MemoryPool.Usage.used.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport, \

java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport, \

java.lang.OperatingSystem.MBeanReport, \

java.lang.OperatingSystem.0OpenFileDescripCnt.AttributeReport, \

java.lang.OperatingSystem.0MaxFileDescriptCnt.AttributeReport, \

java.lang.OperatingSystem.0CommitVirtMemSize.AttributeReport, \

java.lang.OperatingSystem.0TotalSwapSpaceSize.AttributeReport, \

java.lang.OperatingSystem.0FreeSwapSpaceSize.AttributeReport, \

java.lang.OperatingSystem.0ProcessCpuTime.AttributeReport, \

java.lang.OperatingSystem.0FreePhysicaMemSize.AttributeReport, \

java.lang.OperatingSystem.0TotalPhysicMemSize.AttributeReport, \

java.lang.OperatingSystem.0SysCpuLoad.AttributeReport, \

java.lang.OperatingSystem.0ProcessCpuLoad.AttributeReport, \

java.lang.OperatingSystem.0Version.AttributeReport, \

java.lang.OperatingSystem.13Name.AttributeReport, \

java.lang.OperatingSystem.0AvailProcessors.AttributeReport, \

java.lang.OperatingSystem.0Arch.AttributeReport, \

java.lang.OperatingSystem.0SysLoadAvg.AttributeReport, \

java.lang.OperatingSystem.15ObjectName.AttributeReport, \

java.lang.Runtime.MBeanReport, \

java.lang.Runtime.0ClassPath.AttributeReport, \

java.lang.Runtime.14Name.AttributeReport, \

java.lang.Runtime.0BootClassPathSuppo.AttributeReport, \

java.lang.Runtime.0VmName.AttributeReport, \

java.lang.Runtime.0VmVendor.AttributeReport, \

java.lang.Runtime.0VmVersion.AttributeReport, \

java.lang.Runtime.0LibraryPath.AttributeReport, \

java.lang.Runtime.0BootClassPath.AttributeReport, \

java.lang.Runtime.0Uptime.AttributeReport, \

java.lang.Runtime.0ManagemSpecVersion.AttributeReport, \

java.lang.Runtime.0SpecName.AttributeReport, \

java.lang.Runtime.0SpecVendor.AttributeReport, \

java.lang.Runtime.0SpecVersion.AttributeReport, \

java.lang.Runtime.0InputArguments.AttributeReport, \

java.lang.Runtime.0StartTime.AttributeReport, \

java.lang.Runtime.0SysProperties.AttributeReport, \

java.lang.Runtime.0Pid.AttributeReport, \

java.lang.Runtime.16ObjectName.AttributeReport, \

java.lang.Threading.MBeanReport, \

java.lang.Threading.0ThreaAllocMemSuppo.AttributeReport, \

java.lang.Threading.0ThreaAllocMemEnabl.AttributeReport, \

java.lang.Threading.0CurrThreAllocBytes.AttributeReport, \

java.lang.Threading.0ThreContMonitEnabl.AttributeReport, \

java.lang.Threading.0ThreContMonitSuppo.AttributeReport, \

java.lang.Threading.0CurThreCpuTimeSupp.AttributeReport, \

java.lang.Threading.0ObjeMoniUsageSuppo.AttributeReport, \

java.lang.Threading.0SynchrUsageSupport.AttributeReport, \

java.lang.Threading.0ThreaCpuTimeEnable.AttributeReport, \

java.lang.Threading.0PeakThreadCnt.AttributeReport, \

java.lang.Threading.0DaemonThreadCnt.AttributeReport, \

java.lang.Threading.0ThreadCnt.AttributeReport, \

java.lang.Threading.0TotalStartThreaCnt.AttributeReport, \

java.lang.Threading.0AllThreadIds.AttributeReport, \

java.lang.Threading.0CurreThreadCpuTime.AttributeReport, \

java.lang.Threading.0CurreThreadUsrTime.AttributeReport, \

java.lang.Threading.0ThreaCpuTimeSuppor.AttributeReport, \

java.lang.Threading.17ObjectName.AttributeReport




###########################################
## java.lang.ClassLoading.MBeanReport
###########################################
report.java.lang.ClassLoading.MBeanReport.name=java.lang.ClassLoading
report.java.lang.ClassLoading.MBeanReport.columns=0Verbose, 0LoadedClassCnt, 0UnloadedClassCnt, 0TotalLoadeClassCnt, 0ObjectName
report.java.lang.ClassLoading.MBeanReport.type=interfaceSnmp
report.java.lang.ClassLoading.MBeanReport.command=--title="java.lang.ClassLoading" \
 --vertical-label="verticalLabel" \
 DEF:0Verbose={rrd1}:0Verbose:AVERAGE \
 AREA:0Verbose#edd400 \
 LINE2:0Verbose#c4a000:"Verbose" \
 GPRINT:0Verbose:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0Verbose:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0Verbose:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0LoadedClassCnt={rrd2}:0LoadedClassCnt:AVERAGE \
 AREA:0LoadedClassCnt#f57900 \
 LINE2:0LoadedClassCnt#ce5c00:"LoadedClassCount" \
 GPRINT:0LoadedClassCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0LoadedClassCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0LoadedClassCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0UnloadedClassCnt={rrd3}:0UnloadedClassCnt:AVERAGE \
 AREA:0UnloadedClassCnt#c17d11 \
 LINE2:0UnloadedClassCnt#8f5902:"UnloadedClassCount" \
 GPRINT:0UnloadedClassCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0UnloadedClassCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0UnloadedClassCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0TotalLoadeClassCnt={rrd4}:0TotalLoadeClassCnt:AVERAGE \
 AREA:0TotalLoadeClassCnt#73d216 \
 LINE2:0TotalLoadeClassCnt#4e9a06:"TotalLoadedClassCount" \
 GPRINT:0TotalLoadeClassCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0TotalLoadeClassCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0TotalLoadeClassCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0ObjectName={rrd5}:0ObjectName:AVERAGE \
 AREA:0ObjectName#3465a4 \
 LINE2:0ObjectName#204a87:"ObjectName" \
 GPRINT:0ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.ClassLoading.0Verbose.AttributeReport
###########################################
report.java.lang.ClassLoading.0Verbose.AttributeReport.name=java.lang:type=ClassLoading[Verbose]
report.java.lang.ClassLoading.0Verbose.AttributeReport.columns=0Verbose
report.java.lang.ClassLoading.0Verbose.AttributeReport.type=interfaceSnmp
report.java.lang.ClassLoading.0Verbose.AttributeReport.command=--title="java.lang:type=ClassLoading[Verbose]" \
 --vertical-label="verticalLabel" \
 DEF:0Verbose={rrd1}:0Verbose:AVERAGE \
 AREA:0Verbose#edd400 \
 LINE2:0Verbose#c4a000:"Verbose" \
 GPRINT:0Verbose:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0Verbose:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0Verbose:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.ClassLoading.0LoadedClassCnt.AttributeReport
###########################################
report.java.lang.ClassLoading.0LoadedClassCnt.AttributeReport.name=java.lang:type=ClassLoading[LoadedClassCount]
report.java.lang.ClassLoading.0LoadedClassCnt.AttributeReport.columns=0LoadedClassCnt
report.java.lang.ClassLoading.0LoadedClassCnt.AttributeReport.type=interfaceSnmp
report.java.lang.ClassLoading.0LoadedClassCnt.AttributeReport.command=--title="java.lang:type=ClassLoading[LoadedClassCount]" \
 --vertical-label="verticalLabel" \
 DEF:0LoadedClassCnt={rrd1}:0LoadedClassCnt:AVERAGE \
 AREA:0LoadedClassCnt#edd400 \
 LINE2:0LoadedClassCnt#c4a000:"LoadedClassCount" \
 GPRINT:0LoadedClassCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0LoadedClassCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0LoadedClassCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.ClassLoading.0UnloadedClassCnt.AttributeReport
###########################################
report.java.lang.ClassLoading.0UnloadedClassCnt.AttributeReport.name=java.lang:type=ClassLoading[UnloadedClassCount]
report.java.lang.ClassLoading.0UnloadedClassCnt.AttributeReport.columns=0UnloadedClassCnt
report.java.lang.ClassLoading.0UnloadedClassCnt.AttributeReport.type=interfaceSnmp
report.java.lang.ClassLoading.0UnloadedClassCnt.AttributeReport.command=--title="java.lang:type=ClassLoading[UnloadedClassCount]" \
 --vertical-label="verticalLabel" \
 DEF:0UnloadedClassCnt={rrd1}:0UnloadedClassCnt:AVERAGE \
 AREA:0UnloadedClassCnt#edd400 \
 LINE2:0UnloadedClassCnt#c4a000:"UnloadedClassCount" \
 GPRINT:0UnloadedClassCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0UnloadedClassCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0UnloadedClassCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.ClassLoading.0TotalLoadeClassCnt.AttributeReport
###########################################
report.java.lang.ClassLoading.0TotalLoadeClassCnt.AttributeReport.name=java.lang:type=ClassLoading[TotalLoadedClassCount]
report.java.lang.ClassLoading.0TotalLoadeClassCnt.AttributeReport.columns=0TotalLoadeClassCnt
report.java.lang.ClassLoading.0TotalLoadeClassCnt.AttributeReport.type=interfaceSnmp
report.java.lang.ClassLoading.0TotalLoadeClassCnt.AttributeReport.command=--title="java.lang:type=ClassLoading[TotalLoadedClassCount]" \
 --vertical-label="verticalLabel" \
 DEF:0TotalLoadeClassCnt={rrd1}:0TotalLoadeClassCnt:AVERAGE \
 AREA:0TotalLoadeClassCnt#edd400 \
 LINE2:0TotalLoadeClassCnt#c4a000:"TotalLoadedClassCount" \
 GPRINT:0TotalLoadeClassCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0TotalLoadeClassCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0TotalLoadeClassCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.ClassLoading.0ObjectName.AttributeReport
###########################################
report.java.lang.ClassLoading.0ObjectName.AttributeReport.name=java.lang:type=ClassLoading[ObjectName]
report.java.lang.ClassLoading.0ObjectName.AttributeReport.columns=0ObjectName
report.java.lang.ClassLoading.0ObjectName.AttributeReport.type=interfaceSnmp
report.java.lang.ClassLoading.0ObjectName.AttributeReport.command=--title="java.lang:type=ClassLoading[ObjectName]" \
 --vertical-label="verticalLabel" \
 DEF:0ObjectName={rrd1}:0ObjectName:AVERAGE \
 AREA:0ObjectName#edd400 \
 LINE2:0ObjectName#c4a000:"ObjectName" \
 GPRINT:0ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Compilation.MBeanReport
###########################################
report.java.lang.Compilation.MBeanReport.name=java.lang.Compilation
report.java.lang.Compilation.MBeanReport.columns=0Name, 0CompTimeMonitSuppo, 0TotalCompilatiTime, 1ObjectName
report.java.lang.Compilation.MBeanReport.type=interfaceSnmp
report.java.lang.Compilation.MBeanReport.command=--title="java.lang.Compilation" \
 --vertical-label="verticalLabel" \
 DEF:0Name={rrd1}:0Name:AVERAGE \
 AREA:0Name#edd400 \
 LINE2:0Name#c4a000:"Name" \
 GPRINT:0Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0Name:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0CompTimeMonitSuppo={rrd2}:0CompTimeMonitSuppo:AVERAGE \
 AREA:0CompTimeMonitSuppo#f57900 \
 LINE2:0CompTimeMonitSuppo#ce5c00:"CompilationTimeMonitoringSupported" \
 GPRINT:0CompTimeMonitSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CompTimeMonitSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CompTimeMonitSuppo:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0TotalCompilatiTime={rrd3}:0TotalCompilatiTime:AVERAGE \
 AREA:0TotalCompilatiTime#c17d11 \
 LINE2:0TotalCompilatiTime#8f5902:"TotalCompilationTime" \
 GPRINT:0TotalCompilatiTime:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0TotalCompilatiTime:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0TotalCompilatiTime:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1ObjectName={rrd4}:1ObjectName:AVERAGE \
 AREA:1ObjectName#73d216 \
 LINE2:1ObjectName#4e9a06:"ObjectName" \
 GPRINT:1ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Compilation.0Name.AttributeReport
###########################################
report.java.lang.Compilation.0Name.AttributeReport.name=java.lang:type=Compilation[Name]
report.java.lang.Compilation.0Name.AttributeReport.columns=0Name
report.java.lang.Compilation.0Name.AttributeReport.type=interfaceSnmp
report.java.lang.Compilation.0Name.AttributeReport.command=--title="java.lang:type=Compilation[Name]" \
 --vertical-label="verticalLabel" \
 DEF:0Name={rrd1}:0Name:AVERAGE \
 AREA:0Name#edd400 \
 LINE2:0Name#c4a000:"Name" \
 GPRINT:0Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0Name:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Compilation.0CompTimeMonitSuppo.AttributeReport
###########################################
report.java.lang.Compilation.0CompTimeMonitSuppo.AttributeReport.name=java.lang:type=Compilation[CompilationTimeMonitoringSupported]
report.java.lang.Compilation.0CompTimeMonitSuppo.AttributeReport.columns=0CompTimeMonitSuppo
report.java.lang.Compilation.0CompTimeMonitSuppo.AttributeReport.type=interfaceSnmp
report.java.lang.Compilation.0CompTimeMonitSuppo.AttributeReport.command=--title="java.lang:type=Compilation[CompilationTimeMonitoringSupported]" \
 --vertical-label="verticalLabel" \
 DEF:0CompTimeMonitSuppo={rrd1}:0CompTimeMonitSuppo:AVERAGE \
 AREA:0CompTimeMonitSuppo#edd400 \
 LINE2:0CompTimeMonitSuppo#c4a000:"CompilationTimeMonitoringSupported" \
 GPRINT:0CompTimeMonitSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CompTimeMonitSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CompTimeMonitSuppo:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Compilation.0TotalCompilatiTime.AttributeReport
###########################################
report.java.lang.Compilation.0TotalCompilatiTime.AttributeReport.name=java.lang:type=Compilation[TotalCompilationTime]
report.java.lang.Compilation.0TotalCompilatiTime.AttributeReport.columns=0TotalCompilatiTime
report.java.lang.Compilation.0TotalCompilatiTime.AttributeReport.type=interfaceSnmp
report.java.lang.Compilation.0TotalCompilatiTime.AttributeReport.command=--title="java.lang:type=Compilation[TotalCompilationTime]" \
 --vertical-label="verticalLabel" \
 DEF:0TotalCompilatiTime={rrd1}:0TotalCompilatiTime:AVERAGE \
 AREA:0TotalCompilatiTime#edd400 \
 LINE2:0TotalCompilatiTime#c4a000:"TotalCompilationTime" \
 GPRINT:0TotalCompilatiTime:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0TotalCompilatiTime:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0TotalCompilatiTime:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Compilation.1ObjectName.AttributeReport
###########################################
report.java.lang.Compilation.1ObjectName.AttributeReport.name=java.lang:type=Compilation[ObjectName]
report.java.lang.Compilation.1ObjectName.AttributeReport.columns=1ObjectName
report.java.lang.Compilation.1ObjectName.AttributeReport.type=interfaceSnmp
report.java.lang.Compilation.1ObjectName.AttributeReport.command=--title="java.lang:type=Compilation[ObjectName]" \
 --vertical-label="verticalLabel" \
 DEF:1ObjectName={rrd1}:1ObjectName:AVERAGE \
 AREA:1ObjectName#edd400 \
 LINE2:1ObjectName#c4a000:"ObjectName" \
 GPRINT:1ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.MBeanReport
###########################################
report.java.lang.GarbageCollector.MBeanReport.name=java.lang.GarbageCollector
report.java.lang.GarbageCollector.MBeanReport.columns=0LastGcInfo, 0CollectionCnt, 0CollectionTime, 0Valid, 1Name, 0MemPoolNames, 2ObjectName
report.java.lang.GarbageCollector.MBeanReport.type=interfaceSnmp
report.java.lang.GarbageCollector.MBeanReport.command=--title="java.lang.GarbageCollector" \
 --vertical-label="verticalLabel" \
 DEF:0LastGcInfo={rrd1}:0LastGcInfo:AVERAGE \
 AREA:0LastGcInfo#edd400 \
 LINE2:0LastGcInfo#c4a000:"LastGcInfo" \
 GPRINT:0LastGcInfo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0LastGcInfo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0LastGcInfo:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0CollectionCnt={rrd2}:0CollectionCnt:AVERAGE \
 AREA:0CollectionCnt#f57900 \
 LINE2:0CollectionCnt#ce5c00:"CollectionCount" \
 GPRINT:0CollectionCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CollectionCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CollectionCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0CollectionTime={rrd3}:0CollectionTime:AVERAGE \
 AREA:0CollectionTime#c17d11 \
 LINE2:0CollectionTime#8f5902:"CollectionTime" \
 GPRINT:0CollectionTime:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CollectionTime:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CollectionTime:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0Valid={rrd4}:0Valid:AVERAGE \
 AREA:0Valid#73d216 \
 LINE2:0Valid#4e9a06:"Valid" \
 GPRINT:0Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0Valid:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1Name={rrd5}:1Name:AVERAGE \
 AREA:1Name#3465a4 \
 LINE2:1Name#204a87:"Name" \
 GPRINT:1Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1Name:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0MemPoolNames={rrd6}:0MemPoolNames:AVERAGE \
 AREA:0MemPoolNames#75507b \
 LINE2:0MemPoolNames#5c3566:"MemoryPoolNames" \
 GPRINT:0MemPoolNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0MemPoolNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0MemPoolNames:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2ObjectName={rrd7}:2ObjectName:AVERAGE \
 AREA:2ObjectName#cc0000 \
 LINE2:2ObjectName#a40000:"ObjectName" \
 GPRINT:2ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.0LastGcInfo.AttributeReport
###########################################
report.java.lang.GarbageCollector.0LastGcInfo.AttributeReport.name=java.lang:name=G1 Old Generation,type=GarbageCollector[LastGcInfo]
report.java.lang.GarbageCollector.0LastGcInfo.AttributeReport.columns=0LastGcInfo
report.java.lang.GarbageCollector.0LastGcInfo.AttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.0LastGcInfo.AttributeReport.command=--title="java.lang:name=G1 Old Generation,type=GarbageCollector[LastGcInfo]" \
 --vertical-label="verticalLabel" \
 DEF:0LastGcInfo={rrd1}:0LastGcInfo:AVERAGE \
 AREA:0LastGcInfo#edd400 \
 LINE2:0LastGcInfo#c4a000:"LastGcInfo" \
 GPRINT:0LastGcInfo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0LastGcInfo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0LastGcInfo:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.0CollectionCnt.AttributeReport
###########################################
report.java.lang.GarbageCollector.0CollectionCnt.AttributeReport.name=java.lang:name=G1 Old Generation,type=GarbageCollector[CollectionCount]
report.java.lang.GarbageCollector.0CollectionCnt.AttributeReport.columns=0CollectionCnt
report.java.lang.GarbageCollector.0CollectionCnt.AttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.0CollectionCnt.AttributeReport.command=--title="java.lang:name=G1 Old Generation,type=GarbageCollector[CollectionCount]" \
 --vertical-label="verticalLabel" \
 DEF:0CollectionCnt={rrd1}:0CollectionCnt:AVERAGE \
 AREA:0CollectionCnt#edd400 \
 LINE2:0CollectionCnt#c4a000:"CollectionCount" \
 GPRINT:0CollectionCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CollectionCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CollectionCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.0CollectionTime.AttributeReport
###########################################
report.java.lang.GarbageCollector.0CollectionTime.AttributeReport.name=java.lang:name=G1 Old Generation,type=GarbageCollector[CollectionTime]
report.java.lang.GarbageCollector.0CollectionTime.AttributeReport.columns=0CollectionTime
report.java.lang.GarbageCollector.0CollectionTime.AttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.0CollectionTime.AttributeReport.command=--title="java.lang:name=G1 Old Generation,type=GarbageCollector[CollectionTime]" \
 --vertical-label="verticalLabel" \
 DEF:0CollectionTime={rrd1}:0CollectionTime:AVERAGE \
 AREA:0CollectionTime#edd400 \
 LINE2:0CollectionTime#c4a000:"CollectionTime" \
 GPRINT:0CollectionTime:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CollectionTime:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CollectionTime:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.0Valid.AttributeReport
###########################################
report.java.lang.GarbageCollector.0Valid.AttributeReport.name=java.lang:name=G1 Old Generation,type=GarbageCollector[Valid]
report.java.lang.GarbageCollector.0Valid.AttributeReport.columns=0Valid
report.java.lang.GarbageCollector.0Valid.AttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.0Valid.AttributeReport.command=--title="java.lang:name=G1 Old Generation,type=GarbageCollector[Valid]" \
 --vertical-label="verticalLabel" \
 DEF:0Valid={rrd1}:0Valid:AVERAGE \
 AREA:0Valid#edd400 \
 LINE2:0Valid#c4a000:"Valid" \
 GPRINT:0Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0Valid:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.1Name.AttributeReport
###########################################
report.java.lang.GarbageCollector.1Name.AttributeReport.name=java.lang:name=G1 Old Generation,type=GarbageCollector[Name]
report.java.lang.GarbageCollector.1Name.AttributeReport.columns=1Name
report.java.lang.GarbageCollector.1Name.AttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.1Name.AttributeReport.command=--title="java.lang:name=G1 Old Generation,type=GarbageCollector[Name]" \
 --vertical-label="verticalLabel" \
 DEF:1Name={rrd1}:1Name:AVERAGE \
 AREA:1Name#edd400 \
 LINE2:1Name#c4a000:"Name" \
 GPRINT:1Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1Name:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.0MemPoolNames.AttributeReport
###########################################
report.java.lang.GarbageCollector.0MemPoolNames.AttributeReport.name=java.lang:name=G1 Old Generation,type=GarbageCollector[MemoryPoolNames]
report.java.lang.GarbageCollector.0MemPoolNames.AttributeReport.columns=0MemPoolNames
report.java.lang.GarbageCollector.0MemPoolNames.AttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.0MemPoolNames.AttributeReport.command=--title="java.lang:name=G1 Old Generation,type=GarbageCollector[MemoryPoolNames]" \
 --vertical-label="verticalLabel" \
 DEF:0MemPoolNames={rrd1}:0MemPoolNames:AVERAGE \
 AREA:0MemPoolNames#edd400 \
 LINE2:0MemPoolNames#c4a000:"MemoryPoolNames" \
 GPRINT:0MemPoolNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0MemPoolNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0MemPoolNames:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.2ObjectName.AttributeReport
###########################################
report.java.lang.GarbageCollector.2ObjectName.AttributeReport.name=java.lang:name=G1 Old Generation,type=GarbageCollector[ObjectName]
report.java.lang.GarbageCollector.2ObjectName.AttributeReport.columns=2ObjectName
report.java.lang.GarbageCollector.2ObjectName.AttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.2ObjectName.AttributeReport.command=--title="java.lang:name=G1 Old Generation,type=GarbageCollector[ObjectName]" \
 --vertical-label="verticalLabel" \
 DEF:2ObjectName={rrd1}:2ObjectName:AVERAGE \
 AREA:2ObjectName#edd400 \
 LINE2:2ObjectName#c4a000:"ObjectName" \
 GPRINT:2ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.MBeanReport
###########################################
report.java.lang.GarbageCollector.MBeanReport.name=java.lang.GarbageCollector
report.java.lang.GarbageCollector.MBeanReport.columns=1LastGcInfo, 1CollectionCnt, 1CollectionTime, 1Valid, 2Name, 1MemPoolNames, 3ObjectName
report.java.lang.GarbageCollector.MBeanReport.type=interfaceSnmp
report.java.lang.GarbageCollector.MBeanReport.command=--title="java.lang.GarbageCollector" \
 --vertical-label="verticalLabel" \
 DEF:1LastGcInfo={rrd1}:1LastGcInfo:AVERAGE \
 AREA:1LastGcInfo#edd400 \
 LINE2:1LastGcInfo#c4a000:"LastGcInfo" \
 GPRINT:1LastGcInfo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1LastGcInfo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1LastGcInfo:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1CollectionCnt={rrd2}:1CollectionCnt:AVERAGE \
 AREA:1CollectionCnt#f57900 \
 LINE2:1CollectionCnt#ce5c00:"CollectionCount" \
 GPRINT:1CollectionCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1CollectionCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1CollectionCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1CollectionTime={rrd3}:1CollectionTime:AVERAGE \
 AREA:1CollectionTime#c17d11 \
 LINE2:1CollectionTime#8f5902:"CollectionTime" \
 GPRINT:1CollectionTime:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1CollectionTime:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1CollectionTime:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1Valid={rrd4}:1Valid:AVERAGE \
 AREA:1Valid#73d216 \
 LINE2:1Valid#4e9a06:"Valid" \
 GPRINT:1Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1Valid:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2Name={rrd5}:2Name:AVERAGE \
 AREA:2Name#3465a4 \
 LINE2:2Name#204a87:"Name" \
 GPRINT:2Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2Name:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1MemPoolNames={rrd6}:1MemPoolNames:AVERAGE \
 AREA:1MemPoolNames#75507b \
 LINE2:1MemPoolNames#5c3566:"MemoryPoolNames" \
 GPRINT:1MemPoolNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1MemPoolNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1MemPoolNames:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3ObjectName={rrd7}:3ObjectName:AVERAGE \
 AREA:3ObjectName#cc0000 \
 LINE2:3ObjectName#a40000:"ObjectName" \
 GPRINT:3ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.1LastGcInfo.AttributeReport
###########################################
report.java.lang.GarbageCollector.1LastGcInfo.AttributeReport.name=java.lang:name=G1 Young Generation,type=GarbageCollector[LastGcInfo]
report.java.lang.GarbageCollector.1LastGcInfo.AttributeReport.columns=1LastGcInfo
report.java.lang.GarbageCollector.1LastGcInfo.AttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.1LastGcInfo.AttributeReport.command=--title="java.lang:name=G1 Young Generation,type=GarbageCollector[LastGcInfo]" \
 --vertical-label="verticalLabel" \
 DEF:1LastGcInfo={rrd1}:1LastGcInfo:AVERAGE \
 AREA:1LastGcInfo#edd400 \
 LINE2:1LastGcInfo#c4a000:"LastGcInfo" \
 GPRINT:1LastGcInfo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1LastGcInfo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1LastGcInfo:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.1CollectionCnt.AttributeReport
###########################################
report.java.lang.GarbageCollector.1CollectionCnt.AttributeReport.name=java.lang:name=G1 Young Generation,type=GarbageCollector[CollectionCount]
report.java.lang.GarbageCollector.1CollectionCnt.AttributeReport.columns=1CollectionCnt
report.java.lang.GarbageCollector.1CollectionCnt.AttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.1CollectionCnt.AttributeReport.command=--title="java.lang:name=G1 Young Generation,type=GarbageCollector[CollectionCount]" \
 --vertical-label="verticalLabel" \
 DEF:1CollectionCnt={rrd1}:1CollectionCnt:AVERAGE \
 AREA:1CollectionCnt#edd400 \
 LINE2:1CollectionCnt#c4a000:"CollectionCount" \
 GPRINT:1CollectionCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1CollectionCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1CollectionCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.1CollectionTime.AttributeReport
###########################################
report.java.lang.GarbageCollector.1CollectionTime.AttributeReport.name=java.lang:name=G1 Young Generation,type=GarbageCollector[CollectionTime]
report.java.lang.GarbageCollector.1CollectionTime.AttributeReport.columns=1CollectionTime
report.java.lang.GarbageCollector.1CollectionTime.AttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.1CollectionTime.AttributeReport.command=--title="java.lang:name=G1 Young Generation,type=GarbageCollector[CollectionTime]" \
 --vertical-label="verticalLabel" \
 DEF:1CollectionTime={rrd1}:1CollectionTime:AVERAGE \
 AREA:1CollectionTime#edd400 \
 LINE2:1CollectionTime#c4a000:"CollectionTime" \
 GPRINT:1CollectionTime:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1CollectionTime:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1CollectionTime:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.1Valid.AttributeReport
###########################################
report.java.lang.GarbageCollector.1Valid.AttributeReport.name=java.lang:name=G1 Young Generation,type=GarbageCollector[Valid]
report.java.lang.GarbageCollector.1Valid.AttributeReport.columns=1Valid
report.java.lang.GarbageCollector.1Valid.AttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.1Valid.AttributeReport.command=--title="java.lang:name=G1 Young Generation,type=GarbageCollector[Valid]" \
 --vertical-label="verticalLabel" \
 DEF:1Valid={rrd1}:1Valid:AVERAGE \
 AREA:1Valid#edd400 \
 LINE2:1Valid#c4a000:"Valid" \
 GPRINT:1Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1Valid:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.2Name.AttributeReport
###########################################
report.java.lang.GarbageCollector.2Name.AttributeReport.name=java.lang:name=G1 Young Generation,type=GarbageCollector[Name]
report.java.lang.GarbageCollector.2Name.AttributeReport.columns=2Name
report.java.lang.GarbageCollector.2Name.AttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.2Name.AttributeReport.command=--title="java.lang:name=G1 Young Generation,type=GarbageCollector[Name]" \
 --vertical-label="verticalLabel" \
 DEF:2Name={rrd1}:2Name:AVERAGE \
 AREA:2Name#edd400 \
 LINE2:2Name#c4a000:"Name" \
 GPRINT:2Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2Name:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.1MemPoolNames.AttributeReport
###########################################
report.java.lang.GarbageCollector.1MemPoolNames.AttributeReport.name=java.lang:name=G1 Young Generation,type=GarbageCollector[MemoryPoolNames]
report.java.lang.GarbageCollector.1MemPoolNames.AttributeReport.columns=1MemPoolNames
report.java.lang.GarbageCollector.1MemPoolNames.AttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.1MemPoolNames.AttributeReport.command=--title="java.lang:name=G1 Young Generation,type=GarbageCollector[MemoryPoolNames]" \
 --vertical-label="verticalLabel" \
 DEF:1MemPoolNames={rrd1}:1MemPoolNames:AVERAGE \
 AREA:1MemPoolNames#edd400 \
 LINE2:1MemPoolNames#c4a000:"MemoryPoolNames" \
 GPRINT:1MemPoolNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1MemPoolNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1MemPoolNames:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.3ObjectName.AttributeReport
###########################################
report.java.lang.GarbageCollector.3ObjectName.AttributeReport.name=java.lang:name=G1 Young Generation,type=GarbageCollector[ObjectName]
report.java.lang.GarbageCollector.3ObjectName.AttributeReport.columns=3ObjectName
report.java.lang.GarbageCollector.3ObjectName.AttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.3ObjectName.AttributeReport.command=--title="java.lang:name=G1 Young Generation,type=GarbageCollector[ObjectName]" \
 --vertical-label="verticalLabel" \
 DEF:3ObjectName={rrd1}:3ObjectName:AVERAGE \
 AREA:3ObjectName#edd400 \
 LINE2:3ObjectName#c4a000:"ObjectName" \
 GPRINT:3ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.LastGcInfo.CompositeReport
###########################################
report.java.lang.GarbageCollector.LastGcInfo.CompositeReport.name=java.lang.GarbageCollector.LastGcInfo.CompositeReport
report.java.lang.GarbageCollector.LastGcInfo.CompositeReport.columns=0LasGcInfoGcThreCnt, 0LastGcInfoDuration, 0LastGcInfoEndTime, 0LastGcInfoId, 0LaGcInfMemUsaAftGc, 0LaGcInfMemUsaBefGc, 0LastGcInfoStarTime
report.java.lang.GarbageCollector.LastGcInfo.CompositeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.LastGcInfo.CompositeReport.command=--title="java.lang.GarbageCollector.LastGcInfo.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:0LasGcInfoGcThreCnt={rrd1}:0LasGcInfoGcThreCnt:AVERAGE \
 AREA:0LasGcInfoGcThreCnt#edd400 \
 LINE2:0LasGcInfoGcThreCnt#c4a000:"GcThreadCount" \
 GPRINT:0LasGcInfoGcThreCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0LasGcInfoGcThreCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0LasGcInfoGcThreCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0LastGcInfoDuration={rrd2}:0LastGcInfoDuration:AVERAGE \
 AREA:0LastGcInfoDuration#f57900 \
 LINE2:0LastGcInfoDuration#ce5c00:"duration" \
 GPRINT:0LastGcInfoDuration:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0LastGcInfoDuration:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0LastGcInfoDuration:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0LastGcInfoEndTime={rrd3}:0LastGcInfoEndTime:AVERAGE \
 AREA:0LastGcInfoEndTime#c17d11 \
 LINE2:0LastGcInfoEndTime#8f5902:"endTime" \
 GPRINT:0LastGcInfoEndTime:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0LastGcInfoEndTime:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0LastGcInfoEndTime:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0LastGcInfoId={rrd4}:0LastGcInfoId:AVERAGE \
 AREA:0LastGcInfoId#73d216 \
 LINE2:0LastGcInfoId#4e9a06:"id" \
 GPRINT:0LastGcInfoId:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0LastGcInfoId:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0LastGcInfoId:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0LaGcInfMemUsaAftGc={rrd5}:0LaGcInfMemUsaAftGc:AVERAGE \
 AREA:0LaGcInfMemUsaAftGc#3465a4 \
 LINE2:0LaGcInfMemUsaAftGc#204a87:"memoryUsageAfterGc" \
 GPRINT:0LaGcInfMemUsaAftGc:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0LaGcInfMemUsaAftGc:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0LaGcInfMemUsaAftGc:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0LaGcInfMemUsaBefGc={rrd6}:0LaGcInfMemUsaBefGc:AVERAGE \
 AREA:0LaGcInfMemUsaBefGc#75507b \
 LINE2:0LaGcInfMemUsaBefGc#5c3566:"memoryUsageBeforeGc" \
 GPRINT:0LaGcInfMemUsaBefGc:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0LaGcInfMemUsaBefGc:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0LaGcInfMemUsaBefGc:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0LastGcInfoStarTime={rrd7}:0LastGcInfoStarTime:AVERAGE \
 AREA:0LastGcInfoStarTime#cc0000 \
 LINE2:0LastGcInfoStarTime#a40000:"startTime" \
 GPRINT:0LastGcInfoStarTime:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0LastGcInfoStarTime:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0LastGcInfoStarTime:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.LastGcInfo.GcThreadCount.CompositeAttributeReport
###########################################
report.java.lang.GarbageCollector.LastGcInfo.GcThreadCount.CompositeAttributeReport.name=java.lang.GarbageCollector.LastGcInfo.GcThreadCount.CompositeAttributeReport
report.java.lang.GarbageCollector.LastGcInfo.GcThreadCount.CompositeAttributeReport.columns=0LasGcInfoGcThreCnt
report.java.lang.GarbageCollector.LastGcInfo.GcThreadCount.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.LastGcInfo.GcThreadCount.CompositeAttributeReport.command=--title="java.lang.GarbageCollector.LastGcInfo.GcThreadCount.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0LasGcInfoGcThreCnt={rrd1}:0LasGcInfoGcThreCnt:AVERAGE \
 AREA:0LasGcInfoGcThreCnt#edd400 \
 LINE2:0LasGcInfoGcThreCnt#c4a000:"GcThreadCount" \
 GPRINT:0LasGcInfoGcThreCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0LasGcInfoGcThreCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0LasGcInfoGcThreCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.LastGcInfo.duration.CompositeAttributeReport
###########################################
report.java.lang.GarbageCollector.LastGcInfo.duration.CompositeAttributeReport.name=java.lang.GarbageCollector.LastGcInfo.duration.CompositeAttributeReport
report.java.lang.GarbageCollector.LastGcInfo.duration.CompositeAttributeReport.columns=0LastGcInfoDuration
report.java.lang.GarbageCollector.LastGcInfo.duration.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.LastGcInfo.duration.CompositeAttributeReport.command=--title="java.lang.GarbageCollector.LastGcInfo.duration.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0LastGcInfoDuration={rrd1}:0LastGcInfoDuration:AVERAGE \
 AREA:0LastGcInfoDuration#edd400 \
 LINE2:0LastGcInfoDuration#c4a000:"duration" \
 GPRINT:0LastGcInfoDuration:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0LastGcInfoDuration:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0LastGcInfoDuration:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.LastGcInfo.endTime.CompositeAttributeReport
###########################################
report.java.lang.GarbageCollector.LastGcInfo.endTime.CompositeAttributeReport.name=java.lang.GarbageCollector.LastGcInfo.endTime.CompositeAttributeReport
report.java.lang.GarbageCollector.LastGcInfo.endTime.CompositeAttributeReport.columns=0LastGcInfoEndTime
report.java.lang.GarbageCollector.LastGcInfo.endTime.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.LastGcInfo.endTime.CompositeAttributeReport.command=--title="java.lang.GarbageCollector.LastGcInfo.endTime.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0LastGcInfoEndTime={rrd1}:0LastGcInfoEndTime:AVERAGE \
 AREA:0LastGcInfoEndTime#edd400 \
 LINE2:0LastGcInfoEndTime#c4a000:"endTime" \
 GPRINT:0LastGcInfoEndTime:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0LastGcInfoEndTime:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0LastGcInfoEndTime:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.LastGcInfo.id.CompositeAttributeReport
###########################################
report.java.lang.GarbageCollector.LastGcInfo.id.CompositeAttributeReport.name=java.lang.GarbageCollector.LastGcInfo.id.CompositeAttributeReport
report.java.lang.GarbageCollector.LastGcInfo.id.CompositeAttributeReport.columns=0LastGcInfoId
report.java.lang.GarbageCollector.LastGcInfo.id.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.LastGcInfo.id.CompositeAttributeReport.command=--title="java.lang.GarbageCollector.LastGcInfo.id.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0LastGcInfoId={rrd1}:0LastGcInfoId:AVERAGE \
 AREA:0LastGcInfoId#edd400 \
 LINE2:0LastGcInfoId#c4a000:"id" \
 GPRINT:0LastGcInfoId:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0LastGcInfoId:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0LastGcInfoId:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.LastGcInfo.memoryUsageAfterGc.CompositeAttributeReport
###########################################
report.java.lang.GarbageCollector.LastGcInfo.memoryUsageAfterGc.CompositeAttributeReport.name=java.lang.GarbageCollector.LastGcInfo.memoryUsageAfterGc.CompositeAttributeReport
report.java.lang.GarbageCollector.LastGcInfo.memoryUsageAfterGc.CompositeAttributeReport.columns=0LaGcInfMemUsaAftGc
report.java.lang.GarbageCollector.LastGcInfo.memoryUsageAfterGc.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.LastGcInfo.memoryUsageAfterGc.CompositeAttributeReport.command=--title="java.lang.GarbageCollector.LastGcInfo.memoryUsageAfterGc.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0LaGcInfMemUsaAftGc={rrd1}:0LaGcInfMemUsaAftGc:AVERAGE \
 AREA:0LaGcInfMemUsaAftGc#edd400 \
 LINE2:0LaGcInfMemUsaAftGc#c4a000:"memoryUsageAfterGc" \
 GPRINT:0LaGcInfMemUsaAftGc:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0LaGcInfMemUsaAftGc:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0LaGcInfMemUsaAftGc:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.LastGcInfo.memoryUsageBeforeGc.CompositeAttributeReport
###########################################
report.java.lang.GarbageCollector.LastGcInfo.memoryUsageBeforeGc.CompositeAttributeReport.name=java.lang.GarbageCollector.LastGcInfo.memoryUsageBeforeGc.CompositeAttributeReport
report.java.lang.GarbageCollector.LastGcInfo.memoryUsageBeforeGc.CompositeAttributeReport.columns=0LaGcInfMemUsaBefGc
report.java.lang.GarbageCollector.LastGcInfo.memoryUsageBeforeGc.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.LastGcInfo.memoryUsageBeforeGc.CompositeAttributeReport.command=--title="java.lang.GarbageCollector.LastGcInfo.memoryUsageBeforeGc.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0LaGcInfMemUsaBefGc={rrd1}:0LaGcInfMemUsaBefGc:AVERAGE \
 AREA:0LaGcInfMemUsaBefGc#edd400 \
 LINE2:0LaGcInfMemUsaBefGc#c4a000:"memoryUsageBeforeGc" \
 GPRINT:0LaGcInfMemUsaBefGc:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0LaGcInfMemUsaBefGc:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0LaGcInfMemUsaBefGc:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.GarbageCollector.LastGcInfo.startTime.CompositeAttributeReport
###########################################
report.java.lang.GarbageCollector.LastGcInfo.startTime.CompositeAttributeReport.name=java.lang.GarbageCollector.LastGcInfo.startTime.CompositeAttributeReport
report.java.lang.GarbageCollector.LastGcInfo.startTime.CompositeAttributeReport.columns=0LastGcInfoStarTime
report.java.lang.GarbageCollector.LastGcInfo.startTime.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.GarbageCollector.LastGcInfo.startTime.CompositeAttributeReport.command=--title="java.lang.GarbageCollector.LastGcInfo.startTime.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0LastGcInfoStarTime={rrd1}:0LastGcInfoStarTime:AVERAGE \
 AREA:0LastGcInfoStarTime#edd400 \
 LINE2:0LastGcInfoStarTime#c4a000:"startTime" \
 GPRINT:0LastGcInfoStarTime:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0LastGcInfoStarTime:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0LastGcInfoStarTime:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Memory.MBeanReport
###########################################
report.java.lang.Memory.MBeanReport.name=java.lang.Memory
report.java.lang.Memory.MBeanReport.columns=1Verbose, 0ObjecPendiFinalCnt, 0HeapMemUsage, 0NonHeapMemUsage, 4ObjectName
report.java.lang.Memory.MBeanReport.type=interfaceSnmp
report.java.lang.Memory.MBeanReport.command=--title="java.lang.Memory" \
 --vertical-label="verticalLabel" \
 DEF:1Verbose={rrd1}:1Verbose:AVERAGE \
 AREA:1Verbose#edd400 \
 LINE2:1Verbose#c4a000:"Verbose" \
 GPRINT:1Verbose:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1Verbose:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1Verbose:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0ObjecPendiFinalCnt={rrd2}:0ObjecPendiFinalCnt:AVERAGE \
 AREA:0ObjecPendiFinalCnt#f57900 \
 LINE2:0ObjecPendiFinalCnt#ce5c00:"ObjectPendingFinalizationCount" \
 GPRINT:0ObjecPendiFinalCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ObjecPendiFinalCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ObjecPendiFinalCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0HeapMemUsage={rrd3}:0HeapMemUsage:AVERAGE \
 AREA:0HeapMemUsage#c17d11 \
 LINE2:0HeapMemUsage#8f5902:"HeapMemoryUsage" \
 GPRINT:0HeapMemUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0HeapMemUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0HeapMemUsage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0NonHeapMemUsage={rrd4}:0NonHeapMemUsage:AVERAGE \
 AREA:0NonHeapMemUsage#73d216 \
 LINE2:0NonHeapMemUsage#4e9a06:"NonHeapMemoryUsage" \
 GPRINT:0NonHeapMemUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0NonHeapMemUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0NonHeapMemUsage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4ObjectName={rrd5}:4ObjectName:AVERAGE \
 AREA:4ObjectName#3465a4 \
 LINE2:4ObjectName#204a87:"ObjectName" \
 GPRINT:4ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Memory.1Verbose.AttributeReport
###########################################
report.java.lang.Memory.1Verbose.AttributeReport.name=java.lang:type=Memory[Verbose]
report.java.lang.Memory.1Verbose.AttributeReport.columns=1Verbose
report.java.lang.Memory.1Verbose.AttributeReport.type=interfaceSnmp
report.java.lang.Memory.1Verbose.AttributeReport.command=--title="java.lang:type=Memory[Verbose]" \
 --vertical-label="verticalLabel" \
 DEF:1Verbose={rrd1}:1Verbose:AVERAGE \
 AREA:1Verbose#edd400 \
 LINE2:1Verbose#c4a000:"Verbose" \
 GPRINT:1Verbose:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1Verbose:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1Verbose:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Memory.0ObjecPendiFinalCnt.AttributeReport
###########################################
report.java.lang.Memory.0ObjecPendiFinalCnt.AttributeReport.name=java.lang:type=Memory[ObjectPendingFinalizationCount]
report.java.lang.Memory.0ObjecPendiFinalCnt.AttributeReport.columns=0ObjecPendiFinalCnt
report.java.lang.Memory.0ObjecPendiFinalCnt.AttributeReport.type=interfaceSnmp
report.java.lang.Memory.0ObjecPendiFinalCnt.AttributeReport.command=--title="java.lang:type=Memory[ObjectPendingFinalizationCount]" \
 --vertical-label="verticalLabel" \
 DEF:0ObjecPendiFinalCnt={rrd1}:0ObjecPendiFinalCnt:AVERAGE \
 AREA:0ObjecPendiFinalCnt#edd400 \
 LINE2:0ObjecPendiFinalCnt#c4a000:"ObjectPendingFinalizationCount" \
 GPRINT:0ObjecPendiFinalCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ObjecPendiFinalCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ObjecPendiFinalCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Memory.0HeapMemUsage.AttributeReport
###########################################
report.java.lang.Memory.0HeapMemUsage.AttributeReport.name=java.lang:type=Memory[HeapMemoryUsage]
report.java.lang.Memory.0HeapMemUsage.AttributeReport.columns=0HeapMemUsage
report.java.lang.Memory.0HeapMemUsage.AttributeReport.type=interfaceSnmp
report.java.lang.Memory.0HeapMemUsage.AttributeReport.command=--title="java.lang:type=Memory[HeapMemoryUsage]" \
 --vertical-label="verticalLabel" \
 DEF:0HeapMemUsage={rrd1}:0HeapMemUsage:AVERAGE \
 AREA:0HeapMemUsage#edd400 \
 LINE2:0HeapMemUsage#c4a000:"HeapMemoryUsage" \
 GPRINT:0HeapMemUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0HeapMemUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0HeapMemUsage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Memory.0NonHeapMemUsage.AttributeReport
###########################################
report.java.lang.Memory.0NonHeapMemUsage.AttributeReport.name=java.lang:type=Memory[NonHeapMemoryUsage]
report.java.lang.Memory.0NonHeapMemUsage.AttributeReport.columns=0NonHeapMemUsage
report.java.lang.Memory.0NonHeapMemUsage.AttributeReport.type=interfaceSnmp
report.java.lang.Memory.0NonHeapMemUsage.AttributeReport.command=--title="java.lang:type=Memory[NonHeapMemoryUsage]" \
 --vertical-label="verticalLabel" \
 DEF:0NonHeapMemUsage={rrd1}:0NonHeapMemUsage:AVERAGE \
 AREA:0NonHeapMemUsage#edd400 \
 LINE2:0NonHeapMemUsage#c4a000:"NonHeapMemoryUsage" \
 GPRINT:0NonHeapMemUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0NonHeapMemUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0NonHeapMemUsage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Memory.4ObjectName.AttributeReport
###########################################
report.java.lang.Memory.4ObjectName.AttributeReport.name=java.lang:type=Memory[ObjectName]
report.java.lang.Memory.4ObjectName.AttributeReport.columns=4ObjectName
report.java.lang.Memory.4ObjectName.AttributeReport.type=interfaceSnmp
report.java.lang.Memory.4ObjectName.AttributeReport.command=--title="java.lang:type=Memory[ObjectName]" \
 --vertical-label="verticalLabel" \
 DEF:4ObjectName={rrd1}:4ObjectName:AVERAGE \
 AREA:4ObjectName#edd400 \
 LINE2:4ObjectName#c4a000:"ObjectName" \
 GPRINT:4ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Memory.HeapMemoryUsage.CompositeReport
###########################################
report.java.lang.Memory.HeapMemoryUsage.CompositeReport.name=java.lang.Memory.HeapMemoryUsage.CompositeReport
report.java.lang.Memory.HeapMemoryUsage.CompositeReport.columns=0HeapMemUsageCommit, 0HeapMemUsageInit, 0HeapMemUsageMax, 0HeapMemUsageUsed
report.java.lang.Memory.HeapMemoryUsage.CompositeReport.type=interfaceSnmp
report.java.lang.Memory.HeapMemoryUsage.CompositeReport.command=--title="java.lang.Memory.HeapMemoryUsage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:0HeapMemUsageCommit={rrd1}:0HeapMemUsageCommit:AVERAGE \
 AREA:0HeapMemUsageCommit#edd400 \
 LINE2:0HeapMemUsageCommit#c4a000:"committed" \
 GPRINT:0HeapMemUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0HeapMemUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0HeapMemUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0HeapMemUsageInit={rrd2}:0HeapMemUsageInit:AVERAGE \
 AREA:0HeapMemUsageInit#f57900 \
 LINE2:0HeapMemUsageInit#ce5c00:"init" \
 GPRINT:0HeapMemUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0HeapMemUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0HeapMemUsageInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0HeapMemUsageMax={rrd3}:0HeapMemUsageMax:AVERAGE \
 AREA:0HeapMemUsageMax#c17d11 \
 LINE2:0HeapMemUsageMax#8f5902:"max" \
 GPRINT:0HeapMemUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0HeapMemUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0HeapMemUsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0HeapMemUsageUsed={rrd4}:0HeapMemUsageUsed:AVERAGE \
 AREA:0HeapMemUsageUsed#73d216 \
 LINE2:0HeapMemUsageUsed#4e9a06:"used" \
 GPRINT:0HeapMemUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0HeapMemUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0HeapMemUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Memory.NonHeapMemoryUsage.CompositeReport
###########################################
report.java.lang.Memory.NonHeapMemoryUsage.CompositeReport.name=java.lang.Memory.NonHeapMemoryUsage.CompositeReport
report.java.lang.Memory.NonHeapMemoryUsage.CompositeReport.columns=0NonHeapMemUsagComm, 0NonHeapMemUsagInit, 0NonHeapMemUsageMax, 0NonHeapMemUsagUsed
report.java.lang.Memory.NonHeapMemoryUsage.CompositeReport.type=interfaceSnmp
report.java.lang.Memory.NonHeapMemoryUsage.CompositeReport.command=--title="java.lang.Memory.NonHeapMemoryUsage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:0NonHeapMemUsagComm={rrd1}:0NonHeapMemUsagComm:AVERAGE \
 AREA:0NonHeapMemUsagComm#edd400 \
 LINE2:0NonHeapMemUsagComm#c4a000:"committed" \
 GPRINT:0NonHeapMemUsagComm:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0NonHeapMemUsagComm:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0NonHeapMemUsagComm:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0NonHeapMemUsagInit={rrd2}:0NonHeapMemUsagInit:AVERAGE \
 AREA:0NonHeapMemUsagInit#f57900 \
 LINE2:0NonHeapMemUsagInit#ce5c00:"init" \
 GPRINT:0NonHeapMemUsagInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0NonHeapMemUsagInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0NonHeapMemUsagInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0NonHeapMemUsageMax={rrd3}:0NonHeapMemUsageMax:AVERAGE \
 AREA:0NonHeapMemUsageMax#c17d11 \
 LINE2:0NonHeapMemUsageMax#8f5902:"max" \
 GPRINT:0NonHeapMemUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0NonHeapMemUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0NonHeapMemUsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0NonHeapMemUsagUsed={rrd4}:0NonHeapMemUsagUsed:AVERAGE \
 AREA:0NonHeapMemUsagUsed#73d216 \
 LINE2:0NonHeapMemUsagUsed#4e9a06:"used" \
 GPRINT:0NonHeapMemUsagUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0NonHeapMemUsagUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0NonHeapMemUsagUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Memory.HeapMemoryUsage.committed.CompositeAttributeReport
###########################################
report.java.lang.Memory.HeapMemoryUsage.committed.CompositeAttributeReport.name=java.lang.Memory.HeapMemoryUsage.committed.CompositeAttributeReport
report.java.lang.Memory.HeapMemoryUsage.committed.CompositeAttributeReport.columns=0HeapMemUsageCommit
report.java.lang.Memory.HeapMemoryUsage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.Memory.HeapMemoryUsage.committed.CompositeAttributeReport.command=--title="java.lang.Memory.HeapMemoryUsage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0HeapMemUsageCommit={rrd1}:0HeapMemUsageCommit:AVERAGE \
 AREA:0HeapMemUsageCommit#edd400 \
 LINE2:0HeapMemUsageCommit#c4a000:"committed" \
 GPRINT:0HeapMemUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0HeapMemUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0HeapMemUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Memory.HeapMemoryUsage.init.CompositeAttributeReport
###########################################
report.java.lang.Memory.HeapMemoryUsage.init.CompositeAttributeReport.name=java.lang.Memory.HeapMemoryUsage.init.CompositeAttributeReport
report.java.lang.Memory.HeapMemoryUsage.init.CompositeAttributeReport.columns=0HeapMemUsageInit
report.java.lang.Memory.HeapMemoryUsage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.Memory.HeapMemoryUsage.init.CompositeAttributeReport.command=--title="java.lang.Memory.HeapMemoryUsage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0HeapMemUsageInit={rrd1}:0HeapMemUsageInit:AVERAGE \
 AREA:0HeapMemUsageInit#edd400 \
 LINE2:0HeapMemUsageInit#c4a000:"init" \
 GPRINT:0HeapMemUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0HeapMemUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0HeapMemUsageInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Memory.HeapMemoryUsage.max.CompositeAttributeReport
###########################################
report.java.lang.Memory.HeapMemoryUsage.max.CompositeAttributeReport.name=java.lang.Memory.HeapMemoryUsage.max.CompositeAttributeReport
report.java.lang.Memory.HeapMemoryUsage.max.CompositeAttributeReport.columns=0HeapMemUsageMax
report.java.lang.Memory.HeapMemoryUsage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.Memory.HeapMemoryUsage.max.CompositeAttributeReport.command=--title="java.lang.Memory.HeapMemoryUsage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0HeapMemUsageMax={rrd1}:0HeapMemUsageMax:AVERAGE \
 AREA:0HeapMemUsageMax#edd400 \
 LINE2:0HeapMemUsageMax#c4a000:"max" \
 GPRINT:0HeapMemUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0HeapMemUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0HeapMemUsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Memory.HeapMemoryUsage.used.CompositeAttributeReport
###########################################
report.java.lang.Memory.HeapMemoryUsage.used.CompositeAttributeReport.name=java.lang.Memory.HeapMemoryUsage.used.CompositeAttributeReport
report.java.lang.Memory.HeapMemoryUsage.used.CompositeAttributeReport.columns=0HeapMemUsageUsed
report.java.lang.Memory.HeapMemoryUsage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.Memory.HeapMemoryUsage.used.CompositeAttributeReport.command=--title="java.lang.Memory.HeapMemoryUsage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0HeapMemUsageUsed={rrd1}:0HeapMemUsageUsed:AVERAGE \
 AREA:0HeapMemUsageUsed#edd400 \
 LINE2:0HeapMemUsageUsed#c4a000:"used" \
 GPRINT:0HeapMemUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0HeapMemUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0HeapMemUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Memory.NonHeapMemoryUsage.committed.CompositeAttributeReport
###########################################
report.java.lang.Memory.NonHeapMemoryUsage.committed.CompositeAttributeReport.name=java.lang.Memory.NonHeapMemoryUsage.committed.CompositeAttributeReport
report.java.lang.Memory.NonHeapMemoryUsage.committed.CompositeAttributeReport.columns=0NonHeapMemUsagComm
report.java.lang.Memory.NonHeapMemoryUsage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.Memory.NonHeapMemoryUsage.committed.CompositeAttributeReport.command=--title="java.lang.Memory.NonHeapMemoryUsage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0NonHeapMemUsagComm={rrd1}:0NonHeapMemUsagComm:AVERAGE \
 AREA:0NonHeapMemUsagComm#edd400 \
 LINE2:0NonHeapMemUsagComm#c4a000:"committed" \
 GPRINT:0NonHeapMemUsagComm:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0NonHeapMemUsagComm:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0NonHeapMemUsagComm:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Memory.NonHeapMemoryUsage.init.CompositeAttributeReport
###########################################
report.java.lang.Memory.NonHeapMemoryUsage.init.CompositeAttributeReport.name=java.lang.Memory.NonHeapMemoryUsage.init.CompositeAttributeReport
report.java.lang.Memory.NonHeapMemoryUsage.init.CompositeAttributeReport.columns=0NonHeapMemUsagInit
report.java.lang.Memory.NonHeapMemoryUsage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.Memory.NonHeapMemoryUsage.init.CompositeAttributeReport.command=--title="java.lang.Memory.NonHeapMemoryUsage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0NonHeapMemUsagInit={rrd1}:0NonHeapMemUsagInit:AVERAGE \
 AREA:0NonHeapMemUsagInit#edd400 \
 LINE2:0NonHeapMemUsagInit#c4a000:"init" \
 GPRINT:0NonHeapMemUsagInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0NonHeapMemUsagInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0NonHeapMemUsagInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Memory.NonHeapMemoryUsage.max.CompositeAttributeReport
###########################################
report.java.lang.Memory.NonHeapMemoryUsage.max.CompositeAttributeReport.name=java.lang.Memory.NonHeapMemoryUsage.max.CompositeAttributeReport
report.java.lang.Memory.NonHeapMemoryUsage.max.CompositeAttributeReport.columns=0NonHeapMemUsageMax
report.java.lang.Memory.NonHeapMemoryUsage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.Memory.NonHeapMemoryUsage.max.CompositeAttributeReport.command=--title="java.lang.Memory.NonHeapMemoryUsage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0NonHeapMemUsageMax={rrd1}:0NonHeapMemUsageMax:AVERAGE \
 AREA:0NonHeapMemUsageMax#edd400 \
 LINE2:0NonHeapMemUsageMax#c4a000:"max" \
 GPRINT:0NonHeapMemUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0NonHeapMemUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0NonHeapMemUsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Memory.NonHeapMemoryUsage.used.CompositeAttributeReport
###########################################
report.java.lang.Memory.NonHeapMemoryUsage.used.CompositeAttributeReport.name=java.lang.Memory.NonHeapMemoryUsage.used.CompositeAttributeReport
report.java.lang.Memory.NonHeapMemoryUsage.used.CompositeAttributeReport.columns=0NonHeapMemUsagUsed
report.java.lang.Memory.NonHeapMemoryUsage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.Memory.NonHeapMemoryUsage.used.CompositeAttributeReport.command=--title="java.lang.Memory.NonHeapMemoryUsage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0NonHeapMemUsagUsed={rrd1}:0NonHeapMemUsagUsed:AVERAGE \
 AREA:0NonHeapMemUsagUsed#edd400 \
 LINE2:0NonHeapMemUsagUsed#c4a000:"used" \
 GPRINT:0NonHeapMemUsagUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0NonHeapMemUsagUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0NonHeapMemUsagUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryManager.MBeanReport
###########################################
report.java.lang.MemoryManager.MBeanReport.name=java.lang.MemoryManager
report.java.lang.MemoryManager.MBeanReport.columns=2Valid, 3Name, 2MemPoolNames, 5ObjectName
report.java.lang.MemoryManager.MBeanReport.type=interfaceSnmp
report.java.lang.MemoryManager.MBeanReport.command=--title="java.lang.MemoryManager" \
 --vertical-label="verticalLabel" \
 DEF:2Valid={rrd1}:2Valid:AVERAGE \
 AREA:2Valid#edd400 \
 LINE2:2Valid#c4a000:"Valid" \
 GPRINT:2Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2Valid:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3Name={rrd2}:3Name:AVERAGE \
 AREA:3Name#f57900 \
 LINE2:3Name#ce5c00:"Name" \
 GPRINT:3Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3Name:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2MemPoolNames={rrd3}:2MemPoolNames:AVERAGE \
 AREA:2MemPoolNames#c17d11 \
 LINE2:2MemPoolNames#8f5902:"MemoryPoolNames" \
 GPRINT:2MemPoolNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2MemPoolNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2MemPoolNames:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5ObjectName={rrd4}:5ObjectName:AVERAGE \
 AREA:5ObjectName#73d216 \
 LINE2:5ObjectName#4e9a06:"ObjectName" \
 GPRINT:5ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryManager.2Valid.AttributeReport
###########################################
report.java.lang.MemoryManager.2Valid.AttributeReport.name=java.lang:name=CodeCacheManager,type=MemoryManager[Valid]
report.java.lang.MemoryManager.2Valid.AttributeReport.columns=2Valid
report.java.lang.MemoryManager.2Valid.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryManager.2Valid.AttributeReport.command=--title="java.lang:name=CodeCacheManager,type=MemoryManager[Valid]" \
 --vertical-label="verticalLabel" \
 DEF:2Valid={rrd1}:2Valid:AVERAGE \
 AREA:2Valid#edd400 \
 LINE2:2Valid#c4a000:"Valid" \
 GPRINT:2Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2Valid:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryManager.3Name.AttributeReport
###########################################
report.java.lang.MemoryManager.3Name.AttributeReport.name=java.lang:name=CodeCacheManager,type=MemoryManager[Name]
report.java.lang.MemoryManager.3Name.AttributeReport.columns=3Name
report.java.lang.MemoryManager.3Name.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryManager.3Name.AttributeReport.command=--title="java.lang:name=CodeCacheManager,type=MemoryManager[Name]" \
 --vertical-label="verticalLabel" \
 DEF:3Name={rrd1}:3Name:AVERAGE \
 AREA:3Name#edd400 \
 LINE2:3Name#c4a000:"Name" \
 GPRINT:3Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3Name:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryManager.2MemPoolNames.AttributeReport
###########################################
report.java.lang.MemoryManager.2MemPoolNames.AttributeReport.name=java.lang:name=CodeCacheManager,type=MemoryManager[MemoryPoolNames]
report.java.lang.MemoryManager.2MemPoolNames.AttributeReport.columns=2MemPoolNames
report.java.lang.MemoryManager.2MemPoolNames.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryManager.2MemPoolNames.AttributeReport.command=--title="java.lang:name=CodeCacheManager,type=MemoryManager[MemoryPoolNames]" \
 --vertical-label="verticalLabel" \
 DEF:2MemPoolNames={rrd1}:2MemPoolNames:AVERAGE \
 AREA:2MemPoolNames#edd400 \
 LINE2:2MemPoolNames#c4a000:"MemoryPoolNames" \
 GPRINT:2MemPoolNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2MemPoolNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2MemPoolNames:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryManager.5ObjectName.AttributeReport
###########################################
report.java.lang.MemoryManager.5ObjectName.AttributeReport.name=java.lang:name=CodeCacheManager,type=MemoryManager[ObjectName]
report.java.lang.MemoryManager.5ObjectName.AttributeReport.columns=5ObjectName
report.java.lang.MemoryManager.5ObjectName.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryManager.5ObjectName.AttributeReport.command=--title="java.lang:name=CodeCacheManager,type=MemoryManager[ObjectName]" \
 --vertical-label="verticalLabel" \
 DEF:5ObjectName={rrd1}:5ObjectName:AVERAGE \
 AREA:5ObjectName#edd400 \
 LINE2:5ObjectName#c4a000:"ObjectName" \
 GPRINT:5ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryManager.MBeanReport
###########################################
report.java.lang.MemoryManager.MBeanReport.name=java.lang.MemoryManager
report.java.lang.MemoryManager.MBeanReport.columns=3Valid, 4Name, 3MemPoolNames, 6ObjectName
report.java.lang.MemoryManager.MBeanReport.type=interfaceSnmp
report.java.lang.MemoryManager.MBeanReport.command=--title="java.lang.MemoryManager" \
 --vertical-label="verticalLabel" \
 DEF:3Valid={rrd1}:3Valid:AVERAGE \
 AREA:3Valid#edd400 \
 LINE2:3Valid#c4a000:"Valid" \
 GPRINT:3Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3Valid:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4Name={rrd2}:4Name:AVERAGE \
 AREA:4Name#f57900 \
 LINE2:4Name#ce5c00:"Name" \
 GPRINT:4Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4Name:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3MemPoolNames={rrd3}:3MemPoolNames:AVERAGE \
 AREA:3MemPoolNames#c17d11 \
 LINE2:3MemPoolNames#8f5902:"MemoryPoolNames" \
 GPRINT:3MemPoolNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3MemPoolNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3MemPoolNames:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6ObjectName={rrd4}:6ObjectName:AVERAGE \
 AREA:6ObjectName#73d216 \
 LINE2:6ObjectName#4e9a06:"ObjectName" \
 GPRINT:6ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryManager.3Valid.AttributeReport
###########################################
report.java.lang.MemoryManager.3Valid.AttributeReport.name=java.lang:name=Metaspace Manager,type=MemoryManager[Valid]
report.java.lang.MemoryManager.3Valid.AttributeReport.columns=3Valid
report.java.lang.MemoryManager.3Valid.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryManager.3Valid.AttributeReport.command=--title="java.lang:name=Metaspace Manager,type=MemoryManager[Valid]" \
 --vertical-label="verticalLabel" \
 DEF:3Valid={rrd1}:3Valid:AVERAGE \
 AREA:3Valid#edd400 \
 LINE2:3Valid#c4a000:"Valid" \
 GPRINT:3Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3Valid:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryManager.4Name.AttributeReport
###########################################
report.java.lang.MemoryManager.4Name.AttributeReport.name=java.lang:name=Metaspace Manager,type=MemoryManager[Name]
report.java.lang.MemoryManager.4Name.AttributeReport.columns=4Name
report.java.lang.MemoryManager.4Name.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryManager.4Name.AttributeReport.command=--title="java.lang:name=Metaspace Manager,type=MemoryManager[Name]" \
 --vertical-label="verticalLabel" \
 DEF:4Name={rrd1}:4Name:AVERAGE \
 AREA:4Name#edd400 \
 LINE2:4Name#c4a000:"Name" \
 GPRINT:4Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4Name:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryManager.3MemPoolNames.AttributeReport
###########################################
report.java.lang.MemoryManager.3MemPoolNames.AttributeReport.name=java.lang:name=Metaspace Manager,type=MemoryManager[MemoryPoolNames]
report.java.lang.MemoryManager.3MemPoolNames.AttributeReport.columns=3MemPoolNames
report.java.lang.MemoryManager.3MemPoolNames.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryManager.3MemPoolNames.AttributeReport.command=--title="java.lang:name=Metaspace Manager,type=MemoryManager[MemoryPoolNames]" \
 --vertical-label="verticalLabel" \
 DEF:3MemPoolNames={rrd1}:3MemPoolNames:AVERAGE \
 AREA:3MemPoolNames#edd400 \
 LINE2:3MemPoolNames#c4a000:"MemoryPoolNames" \
 GPRINT:3MemPoolNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3MemPoolNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3MemPoolNames:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryManager.6ObjectName.AttributeReport
###########################################
report.java.lang.MemoryManager.6ObjectName.AttributeReport.name=java.lang:name=Metaspace Manager,type=MemoryManager[ObjectName]
report.java.lang.MemoryManager.6ObjectName.AttributeReport.columns=6ObjectName
report.java.lang.MemoryManager.6ObjectName.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryManager.6ObjectName.AttributeReport.command=--title="java.lang:name=Metaspace Manager,type=MemoryManager[ObjectName]" \
 --vertical-label="verticalLabel" \
 DEF:6ObjectName={rrd1}:6ObjectName:AVERAGE \
 AREA:6ObjectName#edd400 \
 LINE2:6ObjectName#c4a000:"ObjectName" \
 GPRINT:6ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.MBeanReport
###########################################
report.java.lang.MemoryPool.MBeanReport.name=java.lang.MemoryPool
report.java.lang.MemoryPool.MBeanReport.columns=4Valid, 5Name, 0Type, 0Usage, 0PeakUsage, 0MemManagerNames, 0UsageThreshold, 0UsageThreshExceede, 0UsageThresholdCnt, 0UsageThreshSupport, 0CollecUsageThresho, 0CollUsagThresExcee, 0ColleUsageThresCnt, 0CollectionUsage, 0CollUsagThresSuppo, 7ObjectName
report.java.lang.MemoryPool.MBeanReport.type=interfaceSnmp
report.java.lang.MemoryPool.MBeanReport.command=--title="java.lang.MemoryPool" \
 --vertical-label="verticalLabel" \
 DEF:4Valid={rrd1}:4Valid:AVERAGE \
 AREA:4Valid#edd400 \
 LINE2:4Valid#c4a000:"Valid" \
 GPRINT:4Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4Valid:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5Name={rrd2}:5Name:AVERAGE \
 AREA:5Name#f57900 \
 LINE2:5Name#ce5c00:"Name" \
 GPRINT:5Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5Name:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0Type={rrd3}:0Type:AVERAGE \
 AREA:0Type#c17d11 \
 LINE2:0Type#8f5902:"Type" \
 GPRINT:0Type:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0Type:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0Type:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0Usage={rrd4}:0Usage:AVERAGE \
 AREA:0Usage#73d216 \
 LINE2:0Usage#4e9a06:"Usage" \
 GPRINT:0Usage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0Usage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0Usage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0PeakUsage={rrd5}:0PeakUsage:AVERAGE \
 AREA:0PeakUsage#3465a4 \
 LINE2:0PeakUsage#204a87:"PeakUsage" \
 GPRINT:0PeakUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0PeakUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0PeakUsage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0MemManagerNames={rrd6}:0MemManagerNames:AVERAGE \
 AREA:0MemManagerNames#75507b \
 LINE2:0MemManagerNames#5c3566:"MemoryManagerNames" \
 GPRINT:0MemManagerNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0MemManagerNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0MemManagerNames:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0UsageThreshold={rrd7}:0UsageThreshold:AVERAGE \
 AREA:0UsageThreshold#cc0000 \
 LINE2:0UsageThreshold#a40000:"UsageThreshold" \
 GPRINT:0UsageThreshold:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0UsageThreshold:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0UsageThreshold:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0UsageThreshExceede={rrd8}:0UsageThreshExceede:AVERAGE \
 AREA:0UsageThreshExceede#d3d7cf \
 LINE2:0UsageThreshExceede#babdb6:"UsageThresholdExceeded" \
 GPRINT:0UsageThreshExceede:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0UsageThreshExceede:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0UsageThreshExceede:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0UsageThresholdCnt={rrd9}:0UsageThresholdCnt:AVERAGE \
 AREA:0UsageThresholdCnt#555753 \
 LINE2:0UsageThresholdCnt#2e3436:"UsageThresholdCount" \
 GPRINT:0UsageThresholdCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0UsageThresholdCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0UsageThresholdCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0UsageThreshSupport={rrd10}:0UsageThreshSupport:AVERAGE \
 AREA:0UsageThreshSupport#edd400 \
 LINE2:0UsageThreshSupport#c4a000:"UsageThresholdSupported" \
 GPRINT:0UsageThreshSupport:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0UsageThreshSupport:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0UsageThreshSupport:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0CollecUsageThresho={rrd11}:0CollecUsageThresho:AVERAGE \
 AREA:0CollecUsageThresho#f57900 \
 LINE2:0CollecUsageThresho#ce5c00:"CollectionUsageThreshold" \
 GPRINT:0CollecUsageThresho:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CollecUsageThresho:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CollecUsageThresho:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0CollUsagThresExcee={rrd12}:0CollUsagThresExcee:AVERAGE \
 AREA:0CollUsagThresExcee#c17d11 \
 LINE2:0CollUsagThresExcee#8f5902:"CollectionUsageThresholdExceeded" \
 GPRINT:0CollUsagThresExcee:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CollUsagThresExcee:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CollUsagThresExcee:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0ColleUsageThresCnt={rrd13}:0ColleUsageThresCnt:AVERAGE \
 AREA:0ColleUsageThresCnt#73d216 \
 LINE2:0ColleUsageThresCnt#4e9a06:"CollectionUsageThresholdCount" \
 GPRINT:0ColleUsageThresCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ColleUsageThresCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ColleUsageThresCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0CollectionUsage={rrd14}:0CollectionUsage:AVERAGE \
 AREA:0CollectionUsage#3465a4 \
 LINE2:0CollectionUsage#204a87:"CollectionUsage" \
 GPRINT:0CollectionUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CollectionUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CollectionUsage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0CollUsagThresSuppo={rrd15}:0CollUsagThresSuppo:AVERAGE \
 AREA:0CollUsagThresSuppo#75507b \
 LINE2:0CollUsagThresSuppo#5c3566:"CollectionUsageThresholdSupported" \
 GPRINT:0CollUsagThresSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CollUsagThresSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CollUsagThresSuppo:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7ObjectName={rrd16}:7ObjectName:AVERAGE \
 AREA:7ObjectName#cc0000 \
 LINE2:7ObjectName#a40000:"ObjectName" \
 GPRINT:7ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.4Valid.AttributeReport
###########################################
report.java.lang.MemoryPool.4Valid.AttributeReport.name=java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[Valid]
report.java.lang.MemoryPool.4Valid.AttributeReport.columns=4Valid
report.java.lang.MemoryPool.4Valid.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.4Valid.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[Valid]" \
 --vertical-label="verticalLabel" \
 DEF:4Valid={rrd1}:4Valid:AVERAGE \
 AREA:4Valid#edd400 \
 LINE2:4Valid#c4a000:"Valid" \
 GPRINT:4Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4Valid:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.5Name.AttributeReport
###########################################
report.java.lang.MemoryPool.5Name.AttributeReport.name=java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[Name]
report.java.lang.MemoryPool.5Name.AttributeReport.columns=5Name
report.java.lang.MemoryPool.5Name.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.5Name.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[Name]" \
 --vertical-label="verticalLabel" \
 DEF:5Name={rrd1}:5Name:AVERAGE \
 AREA:5Name#edd400 \
 LINE2:5Name#c4a000:"Name" \
 GPRINT:5Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5Name:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.0Type.AttributeReport
###########################################
report.java.lang.MemoryPool.0Type.AttributeReport.name=java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[Type]
report.java.lang.MemoryPool.0Type.AttributeReport.columns=0Type
report.java.lang.MemoryPool.0Type.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.0Type.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[Type]" \
 --vertical-label="verticalLabel" \
 DEF:0Type={rrd1}:0Type:AVERAGE \
 AREA:0Type#edd400 \
 LINE2:0Type#c4a000:"Type" \
 GPRINT:0Type:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0Type:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0Type:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.0Usage.AttributeReport
###########################################
report.java.lang.MemoryPool.0Usage.AttributeReport.name=java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[Usage]
report.java.lang.MemoryPool.0Usage.AttributeReport.columns=0Usage
report.java.lang.MemoryPool.0Usage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.0Usage.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[Usage]" \
 --vertical-label="verticalLabel" \
 DEF:0Usage={rrd1}:0Usage:AVERAGE \
 AREA:0Usage#edd400 \
 LINE2:0Usage#c4a000:"Usage" \
 GPRINT:0Usage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0Usage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0Usage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.0PeakUsage.AttributeReport
###########################################
report.java.lang.MemoryPool.0PeakUsage.AttributeReport.name=java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[PeakUsage]
report.java.lang.MemoryPool.0PeakUsage.AttributeReport.columns=0PeakUsage
report.java.lang.MemoryPool.0PeakUsage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.0PeakUsage.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[PeakUsage]" \
 --vertical-label="verticalLabel" \
 DEF:0PeakUsage={rrd1}:0PeakUsage:AVERAGE \
 AREA:0PeakUsage#edd400 \
 LINE2:0PeakUsage#c4a000:"PeakUsage" \
 GPRINT:0PeakUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0PeakUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0PeakUsage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.0MemManagerNames.AttributeReport
###########################################
report.java.lang.MemoryPool.0MemManagerNames.AttributeReport.name=java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[MemoryManagerNames]
report.java.lang.MemoryPool.0MemManagerNames.AttributeReport.columns=0MemManagerNames
report.java.lang.MemoryPool.0MemManagerNames.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.0MemManagerNames.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[MemoryManagerNames]" \
 --vertical-label="verticalLabel" \
 DEF:0MemManagerNames={rrd1}:0MemManagerNames:AVERAGE \
 AREA:0MemManagerNames#edd400 \
 LINE2:0MemManagerNames#c4a000:"MemoryManagerNames" \
 GPRINT:0MemManagerNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0MemManagerNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0MemManagerNames:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.0UsageThreshold.AttributeReport
###########################################
report.java.lang.MemoryPool.0UsageThreshold.AttributeReport.name=java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[UsageThreshold]
report.java.lang.MemoryPool.0UsageThreshold.AttributeReport.columns=0UsageThreshold
report.java.lang.MemoryPool.0UsageThreshold.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.0UsageThreshold.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[UsageThreshold]" \
 --vertical-label="verticalLabel" \
 DEF:0UsageThreshold={rrd1}:0UsageThreshold:AVERAGE \
 AREA:0UsageThreshold#edd400 \
 LINE2:0UsageThreshold#c4a000:"UsageThreshold" \
 GPRINT:0UsageThreshold:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0UsageThreshold:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0UsageThreshold:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.0UsageThreshExceede.AttributeReport
###########################################
report.java.lang.MemoryPool.0UsageThreshExceede.AttributeReport.name=java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[UsageThresholdExceeded]
report.java.lang.MemoryPool.0UsageThreshExceede.AttributeReport.columns=0UsageThreshExceede
report.java.lang.MemoryPool.0UsageThreshExceede.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.0UsageThreshExceede.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[UsageThresholdExceeded]" \
 --vertical-label="verticalLabel" \
 DEF:0UsageThreshExceede={rrd1}:0UsageThreshExceede:AVERAGE \
 AREA:0UsageThreshExceede#edd400 \
 LINE2:0UsageThreshExceede#c4a000:"UsageThresholdExceeded" \
 GPRINT:0UsageThreshExceede:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0UsageThreshExceede:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0UsageThreshExceede:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.0UsageThresholdCnt.AttributeReport
###########################################
report.java.lang.MemoryPool.0UsageThresholdCnt.AttributeReport.name=java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[UsageThresholdCount]
report.java.lang.MemoryPool.0UsageThresholdCnt.AttributeReport.columns=0UsageThresholdCnt
report.java.lang.MemoryPool.0UsageThresholdCnt.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.0UsageThresholdCnt.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[UsageThresholdCount]" \
 --vertical-label="verticalLabel" \
 DEF:0UsageThresholdCnt={rrd1}:0UsageThresholdCnt:AVERAGE \
 AREA:0UsageThresholdCnt#edd400 \
 LINE2:0UsageThresholdCnt#c4a000:"UsageThresholdCount" \
 GPRINT:0UsageThresholdCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0UsageThresholdCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0UsageThresholdCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.0UsageThreshSupport.AttributeReport
###########################################
report.java.lang.MemoryPool.0UsageThreshSupport.AttributeReport.name=java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[UsageThresholdSupported]
report.java.lang.MemoryPool.0UsageThreshSupport.AttributeReport.columns=0UsageThreshSupport
report.java.lang.MemoryPool.0UsageThreshSupport.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.0UsageThreshSupport.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[UsageThresholdSupported]" \
 --vertical-label="verticalLabel" \
 DEF:0UsageThreshSupport={rrd1}:0UsageThreshSupport:AVERAGE \
 AREA:0UsageThreshSupport#edd400 \
 LINE2:0UsageThreshSupport#c4a000:"UsageThresholdSupported" \
 GPRINT:0UsageThreshSupport:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0UsageThreshSupport:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0UsageThreshSupport:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.0CollecUsageThresho.AttributeReport
###########################################
report.java.lang.MemoryPool.0CollecUsageThresho.AttributeReport.name=java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[CollectionUsageThreshold]
report.java.lang.MemoryPool.0CollecUsageThresho.AttributeReport.columns=0CollecUsageThresho
report.java.lang.MemoryPool.0CollecUsageThresho.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.0CollecUsageThresho.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[CollectionUsageThreshold]" \
 --vertical-label="verticalLabel" \
 DEF:0CollecUsageThresho={rrd1}:0CollecUsageThresho:AVERAGE \
 AREA:0CollecUsageThresho#edd400 \
 LINE2:0CollecUsageThresho#c4a000:"CollectionUsageThreshold" \
 GPRINT:0CollecUsageThresho:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CollecUsageThresho:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CollecUsageThresho:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.0CollUsagThresExcee.AttributeReport
###########################################
report.java.lang.MemoryPool.0CollUsagThresExcee.AttributeReport.name=java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[CollectionUsageThresholdExceeded]
report.java.lang.MemoryPool.0CollUsagThresExcee.AttributeReport.columns=0CollUsagThresExcee
report.java.lang.MemoryPool.0CollUsagThresExcee.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.0CollUsagThresExcee.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[CollectionUsageThresholdExceeded]" \
 --vertical-label="verticalLabel" \
 DEF:0CollUsagThresExcee={rrd1}:0CollUsagThresExcee:AVERAGE \
 AREA:0CollUsagThresExcee#edd400 \
 LINE2:0CollUsagThresExcee#c4a000:"CollectionUsageThresholdExceeded" \
 GPRINT:0CollUsagThresExcee:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CollUsagThresExcee:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CollUsagThresExcee:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.0ColleUsageThresCnt.AttributeReport
###########################################
report.java.lang.MemoryPool.0ColleUsageThresCnt.AttributeReport.name=java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[CollectionUsageThresholdCount]
report.java.lang.MemoryPool.0ColleUsageThresCnt.AttributeReport.columns=0ColleUsageThresCnt
report.java.lang.MemoryPool.0ColleUsageThresCnt.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.0ColleUsageThresCnt.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[CollectionUsageThresholdCount]" \
 --vertical-label="verticalLabel" \
 DEF:0ColleUsageThresCnt={rrd1}:0ColleUsageThresCnt:AVERAGE \
 AREA:0ColleUsageThresCnt#edd400 \
 LINE2:0ColleUsageThresCnt#c4a000:"CollectionUsageThresholdCount" \
 GPRINT:0ColleUsageThresCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ColleUsageThresCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ColleUsageThresCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.0CollectionUsage.AttributeReport
###########################################
report.java.lang.MemoryPool.0CollectionUsage.AttributeReport.name=java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[CollectionUsage]
report.java.lang.MemoryPool.0CollectionUsage.AttributeReport.columns=0CollectionUsage
report.java.lang.MemoryPool.0CollectionUsage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.0CollectionUsage.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[CollectionUsage]" \
 --vertical-label="verticalLabel" \
 DEF:0CollectionUsage={rrd1}:0CollectionUsage:AVERAGE \
 AREA:0CollectionUsage#edd400 \
 LINE2:0CollectionUsage#c4a000:"CollectionUsage" \
 GPRINT:0CollectionUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CollectionUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CollectionUsage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.0CollUsagThresSuppo.AttributeReport
###########################################
report.java.lang.MemoryPool.0CollUsagThresSuppo.AttributeReport.name=java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[CollectionUsageThresholdSupported]
report.java.lang.MemoryPool.0CollUsagThresSuppo.AttributeReport.columns=0CollUsagThresSuppo
report.java.lang.MemoryPool.0CollUsagThresSuppo.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.0CollUsagThresSuppo.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[CollectionUsageThresholdSupported]" \
 --vertical-label="verticalLabel" \
 DEF:0CollUsagThresSuppo={rrd1}:0CollUsagThresSuppo:AVERAGE \
 AREA:0CollUsagThresSuppo#edd400 \
 LINE2:0CollUsagThresSuppo#c4a000:"CollectionUsageThresholdSupported" \
 GPRINT:0CollUsagThresSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CollUsagThresSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CollUsagThresSuppo:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.7ObjectName.AttributeReport
###########################################
report.java.lang.MemoryPool.7ObjectName.AttributeReport.name=java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[ObjectName]
report.java.lang.MemoryPool.7ObjectName.AttributeReport.columns=7ObjectName
report.java.lang.MemoryPool.7ObjectName.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.7ObjectName.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-nmethods',type=MemoryPool[ObjectName]" \
 --vertical-label="verticalLabel" \
 DEF:7ObjectName={rrd1}:7ObjectName:AVERAGE \
 AREA:7ObjectName#edd400 \
 LINE2:7ObjectName#c4a000:"ObjectName" \
 GPRINT:7ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.CompositeReport
###########################################
report.java.lang.MemoryPool.Usage.CompositeReport.name=java.lang.MemoryPool.Usage.CompositeReport
report.java.lang.MemoryPool.Usage.CompositeReport.columns=0UsageCommit, 0UsageInit, 0UsageMax, 0UsageUsed
report.java.lang.MemoryPool.Usage.CompositeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.CompositeReport.command=--title="java.lang.MemoryPool.Usage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:0UsageCommit={rrd1}:0UsageCommit:AVERAGE \
 AREA:0UsageCommit#edd400 \
 LINE2:0UsageCommit#c4a000:"committed" \
 GPRINT:0UsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0UsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0UsageCommit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0UsageInit={rrd2}:0UsageInit:AVERAGE \
 AREA:0UsageInit#f57900 \
 LINE2:0UsageInit#ce5c00:"init" \
 GPRINT:0UsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0UsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0UsageInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0UsageMax={rrd3}:0UsageMax:AVERAGE \
 AREA:0UsageMax#c17d11 \
 LINE2:0UsageMax#8f5902:"max" \
 GPRINT:0UsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0UsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0UsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0UsageUsed={rrd4}:0UsageUsed:AVERAGE \
 AREA:0UsageUsed#73d216 \
 LINE2:0UsageUsed#4e9a06:"used" \
 GPRINT:0UsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0UsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0UsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.CompositeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.CompositeReport.name=java.lang.MemoryPool.PeakUsage.CompositeReport
report.java.lang.MemoryPool.PeakUsage.CompositeReport.columns=0PeakUsageCommit, 0PeakUsageInit, 0PeakUsageMax, 0PeakUsageUsed
report.java.lang.MemoryPool.PeakUsage.CompositeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.CompositeReport.command=--title="java.lang.MemoryPool.PeakUsage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:0PeakUsageCommit={rrd1}:0PeakUsageCommit:AVERAGE \
 AREA:0PeakUsageCommit#edd400 \
 LINE2:0PeakUsageCommit#c4a000:"committed" \
 GPRINT:0PeakUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0PeakUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0PeakUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0PeakUsageInit={rrd2}:0PeakUsageInit:AVERAGE \
 AREA:0PeakUsageInit#f57900 \
 LINE2:0PeakUsageInit#ce5c00:"init" \
 GPRINT:0PeakUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0PeakUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0PeakUsageInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0PeakUsageMax={rrd3}:0PeakUsageMax:AVERAGE \
 AREA:0PeakUsageMax#c17d11 \
 LINE2:0PeakUsageMax#8f5902:"max" \
 GPRINT:0PeakUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0PeakUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0PeakUsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0PeakUsageUsed={rrd4}:0PeakUsageUsed:AVERAGE \
 AREA:0PeakUsageUsed#73d216 \
 LINE2:0PeakUsageUsed#4e9a06:"used" \
 GPRINT:0PeakUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0PeakUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0PeakUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.committed.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.committed.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.columns=0UsageCommit
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0UsageCommit={rrd1}:0UsageCommit:AVERAGE \
 AREA:0UsageCommit#edd400 \
 LINE2:0UsageCommit#c4a000:"committed" \
 GPRINT:0UsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0UsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0UsageCommit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.init.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.init.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.columns=0UsageInit
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0UsageInit={rrd1}:0UsageInit:AVERAGE \
 AREA:0UsageInit#edd400 \
 LINE2:0UsageInit#c4a000:"init" \
 GPRINT:0UsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0UsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0UsageInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.max.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.max.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.columns=0UsageMax
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0UsageMax={rrd1}:0UsageMax:AVERAGE \
 AREA:0UsageMax#edd400 \
 LINE2:0UsageMax#c4a000:"max" \
 GPRINT:0UsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0UsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0UsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.used.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.used.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.columns=0UsageUsed
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0UsageUsed={rrd1}:0UsageUsed:AVERAGE \
 AREA:0UsageUsed#edd400 \
 LINE2:0UsageUsed#c4a000:"used" \
 GPRINT:0UsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0UsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0UsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.columns=0PeakUsageCommit
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0PeakUsageCommit={rrd1}:0PeakUsageCommit:AVERAGE \
 AREA:0PeakUsageCommit#edd400 \
 LINE2:0PeakUsageCommit#c4a000:"committed" \
 GPRINT:0PeakUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0PeakUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0PeakUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.columns=0PeakUsageInit
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0PeakUsageInit={rrd1}:0PeakUsageInit:AVERAGE \
 AREA:0PeakUsageInit#edd400 \
 LINE2:0PeakUsageInit#c4a000:"init" \
 GPRINT:0PeakUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0PeakUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0PeakUsageInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.columns=0PeakUsageMax
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0PeakUsageMax={rrd1}:0PeakUsageMax:AVERAGE \
 AREA:0PeakUsageMax#edd400 \
 LINE2:0PeakUsageMax#c4a000:"max" \
 GPRINT:0PeakUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0PeakUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0PeakUsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.columns=0PeakUsageUsed
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0PeakUsageUsed={rrd1}:0PeakUsageUsed:AVERAGE \
 AREA:0PeakUsageUsed#edd400 \
 LINE2:0PeakUsageUsed#c4a000:"used" \
 GPRINT:0PeakUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0PeakUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0PeakUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.MBeanReport
###########################################
report.java.lang.MemoryPool.MBeanReport.name=java.lang.MemoryPool
report.java.lang.MemoryPool.MBeanReport.columns=5Valid, 6Name, 1Type, 1Usage, 1PeakUsage, 1MemManagerNames, 1UsageThreshold, 1UsageThreshExceede, 1UsageThresholdCnt, 1UsageThreshSupport, 1CollecUsageThresho, 1CollUsagThresExcee, 1ColleUsageThresCnt, 1CollectionUsage, 1CollUsagThresSuppo, 8ObjectName
report.java.lang.MemoryPool.MBeanReport.type=interfaceSnmp
report.java.lang.MemoryPool.MBeanReport.command=--title="java.lang.MemoryPool" \
 --vertical-label="verticalLabel" \
 DEF:5Valid={rrd1}:5Valid:AVERAGE \
 AREA:5Valid#edd400 \
 LINE2:5Valid#c4a000:"Valid" \
 GPRINT:5Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5Valid:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6Name={rrd2}:6Name:AVERAGE \
 AREA:6Name#f57900 \
 LINE2:6Name#ce5c00:"Name" \
 GPRINT:6Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6Name:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1Type={rrd3}:1Type:AVERAGE \
 AREA:1Type#c17d11 \
 LINE2:1Type#8f5902:"Type" \
 GPRINT:1Type:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1Type:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1Type:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1Usage={rrd4}:1Usage:AVERAGE \
 AREA:1Usage#73d216 \
 LINE2:1Usage#4e9a06:"Usage" \
 GPRINT:1Usage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1Usage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1Usage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1PeakUsage={rrd5}:1PeakUsage:AVERAGE \
 AREA:1PeakUsage#3465a4 \
 LINE2:1PeakUsage#204a87:"PeakUsage" \
 GPRINT:1PeakUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1PeakUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1PeakUsage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1MemManagerNames={rrd6}:1MemManagerNames:AVERAGE \
 AREA:1MemManagerNames#75507b \
 LINE2:1MemManagerNames#5c3566:"MemoryManagerNames" \
 GPRINT:1MemManagerNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1MemManagerNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1MemManagerNames:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1UsageThreshold={rrd7}:1UsageThreshold:AVERAGE \
 AREA:1UsageThreshold#cc0000 \
 LINE2:1UsageThreshold#a40000:"UsageThreshold" \
 GPRINT:1UsageThreshold:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1UsageThreshold:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1UsageThreshold:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1UsageThreshExceede={rrd8}:1UsageThreshExceede:AVERAGE \
 AREA:1UsageThreshExceede#d3d7cf \
 LINE2:1UsageThreshExceede#babdb6:"UsageThresholdExceeded" \
 GPRINT:1UsageThreshExceede:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1UsageThreshExceede:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1UsageThreshExceede:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1UsageThresholdCnt={rrd9}:1UsageThresholdCnt:AVERAGE \
 AREA:1UsageThresholdCnt#555753 \
 LINE2:1UsageThresholdCnt#2e3436:"UsageThresholdCount" \
 GPRINT:1UsageThresholdCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1UsageThresholdCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1UsageThresholdCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1UsageThreshSupport={rrd10}:1UsageThreshSupport:AVERAGE \
 AREA:1UsageThreshSupport#edd400 \
 LINE2:1UsageThreshSupport#c4a000:"UsageThresholdSupported" \
 GPRINT:1UsageThreshSupport:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1UsageThreshSupport:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1UsageThreshSupport:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1CollecUsageThresho={rrd11}:1CollecUsageThresho:AVERAGE \
 AREA:1CollecUsageThresho#f57900 \
 LINE2:1CollecUsageThresho#ce5c00:"CollectionUsageThreshold" \
 GPRINT:1CollecUsageThresho:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1CollecUsageThresho:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1CollecUsageThresho:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1CollUsagThresExcee={rrd12}:1CollUsagThresExcee:AVERAGE \
 AREA:1CollUsagThresExcee#c17d11 \
 LINE2:1CollUsagThresExcee#8f5902:"CollectionUsageThresholdExceeded" \
 GPRINT:1CollUsagThresExcee:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1CollUsagThresExcee:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1CollUsagThresExcee:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1ColleUsageThresCnt={rrd13}:1ColleUsageThresCnt:AVERAGE \
 AREA:1ColleUsageThresCnt#73d216 \
 LINE2:1ColleUsageThresCnt#4e9a06:"CollectionUsageThresholdCount" \
 GPRINT:1ColleUsageThresCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1ColleUsageThresCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1ColleUsageThresCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1CollectionUsage={rrd14}:1CollectionUsage:AVERAGE \
 AREA:1CollectionUsage#3465a4 \
 LINE2:1CollectionUsage#204a87:"CollectionUsage" \
 GPRINT:1CollectionUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1CollectionUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1CollectionUsage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1CollUsagThresSuppo={rrd15}:1CollUsagThresSuppo:AVERAGE \
 AREA:1CollUsagThresSuppo#75507b \
 LINE2:1CollUsagThresSuppo#5c3566:"CollectionUsageThresholdSupported" \
 GPRINT:1CollUsagThresSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1CollUsagThresSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1CollUsagThresSuppo:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:8ObjectName={rrd16}:8ObjectName:AVERAGE \
 AREA:8ObjectName#cc0000 \
 LINE2:8ObjectName#a40000:"ObjectName" \
 GPRINT:8ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:8ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:8ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.5Valid.AttributeReport
###########################################
report.java.lang.MemoryPool.5Valid.AttributeReport.name=java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[Valid]
report.java.lang.MemoryPool.5Valid.AttributeReport.columns=5Valid
report.java.lang.MemoryPool.5Valid.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.5Valid.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[Valid]" \
 --vertical-label="verticalLabel" \
 DEF:5Valid={rrd1}:5Valid:AVERAGE \
 AREA:5Valid#edd400 \
 LINE2:5Valid#c4a000:"Valid" \
 GPRINT:5Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5Valid:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.6Name.AttributeReport
###########################################
report.java.lang.MemoryPool.6Name.AttributeReport.name=java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[Name]
report.java.lang.MemoryPool.6Name.AttributeReport.columns=6Name
report.java.lang.MemoryPool.6Name.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.6Name.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[Name]" \
 --vertical-label="verticalLabel" \
 DEF:6Name={rrd1}:6Name:AVERAGE \
 AREA:6Name#edd400 \
 LINE2:6Name#c4a000:"Name" \
 GPRINT:6Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6Name:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.1Type.AttributeReport
###########################################
report.java.lang.MemoryPool.1Type.AttributeReport.name=java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[Type]
report.java.lang.MemoryPool.1Type.AttributeReport.columns=1Type
report.java.lang.MemoryPool.1Type.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.1Type.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[Type]" \
 --vertical-label="verticalLabel" \
 DEF:1Type={rrd1}:1Type:AVERAGE \
 AREA:1Type#edd400 \
 LINE2:1Type#c4a000:"Type" \
 GPRINT:1Type:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1Type:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1Type:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.1Usage.AttributeReport
###########################################
report.java.lang.MemoryPool.1Usage.AttributeReport.name=java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[Usage]
report.java.lang.MemoryPool.1Usage.AttributeReport.columns=1Usage
report.java.lang.MemoryPool.1Usage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.1Usage.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[Usage]" \
 --vertical-label="verticalLabel" \
 DEF:1Usage={rrd1}:1Usage:AVERAGE \
 AREA:1Usage#edd400 \
 LINE2:1Usage#c4a000:"Usage" \
 GPRINT:1Usage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1Usage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1Usage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.1PeakUsage.AttributeReport
###########################################
report.java.lang.MemoryPool.1PeakUsage.AttributeReport.name=java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[PeakUsage]
report.java.lang.MemoryPool.1PeakUsage.AttributeReport.columns=1PeakUsage
report.java.lang.MemoryPool.1PeakUsage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.1PeakUsage.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[PeakUsage]" \
 --vertical-label="verticalLabel" \
 DEF:1PeakUsage={rrd1}:1PeakUsage:AVERAGE \
 AREA:1PeakUsage#edd400 \
 LINE2:1PeakUsage#c4a000:"PeakUsage" \
 GPRINT:1PeakUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1PeakUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1PeakUsage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.1MemManagerNames.AttributeReport
###########################################
report.java.lang.MemoryPool.1MemManagerNames.AttributeReport.name=java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[MemoryManagerNames]
report.java.lang.MemoryPool.1MemManagerNames.AttributeReport.columns=1MemManagerNames
report.java.lang.MemoryPool.1MemManagerNames.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.1MemManagerNames.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[MemoryManagerNames]" \
 --vertical-label="verticalLabel" \
 DEF:1MemManagerNames={rrd1}:1MemManagerNames:AVERAGE \
 AREA:1MemManagerNames#edd400 \
 LINE2:1MemManagerNames#c4a000:"MemoryManagerNames" \
 GPRINT:1MemManagerNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1MemManagerNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1MemManagerNames:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.1UsageThreshold.AttributeReport
###########################################
report.java.lang.MemoryPool.1UsageThreshold.AttributeReport.name=java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[UsageThreshold]
report.java.lang.MemoryPool.1UsageThreshold.AttributeReport.columns=1UsageThreshold
report.java.lang.MemoryPool.1UsageThreshold.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.1UsageThreshold.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[UsageThreshold]" \
 --vertical-label="verticalLabel" \
 DEF:1UsageThreshold={rrd1}:1UsageThreshold:AVERAGE \
 AREA:1UsageThreshold#edd400 \
 LINE2:1UsageThreshold#c4a000:"UsageThreshold" \
 GPRINT:1UsageThreshold:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1UsageThreshold:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1UsageThreshold:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.1UsageThreshExceede.AttributeReport
###########################################
report.java.lang.MemoryPool.1UsageThreshExceede.AttributeReport.name=java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[UsageThresholdExceeded]
report.java.lang.MemoryPool.1UsageThreshExceede.AttributeReport.columns=1UsageThreshExceede
report.java.lang.MemoryPool.1UsageThreshExceede.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.1UsageThreshExceede.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[UsageThresholdExceeded]" \
 --vertical-label="verticalLabel" \
 DEF:1UsageThreshExceede={rrd1}:1UsageThreshExceede:AVERAGE \
 AREA:1UsageThreshExceede#edd400 \
 LINE2:1UsageThreshExceede#c4a000:"UsageThresholdExceeded" \
 GPRINT:1UsageThreshExceede:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1UsageThreshExceede:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1UsageThreshExceede:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.1UsageThresholdCnt.AttributeReport
###########################################
report.java.lang.MemoryPool.1UsageThresholdCnt.AttributeReport.name=java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[UsageThresholdCount]
report.java.lang.MemoryPool.1UsageThresholdCnt.AttributeReport.columns=1UsageThresholdCnt
report.java.lang.MemoryPool.1UsageThresholdCnt.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.1UsageThresholdCnt.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[UsageThresholdCount]" \
 --vertical-label="verticalLabel" \
 DEF:1UsageThresholdCnt={rrd1}:1UsageThresholdCnt:AVERAGE \
 AREA:1UsageThresholdCnt#edd400 \
 LINE2:1UsageThresholdCnt#c4a000:"UsageThresholdCount" \
 GPRINT:1UsageThresholdCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1UsageThresholdCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1UsageThresholdCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.1UsageThreshSupport.AttributeReport
###########################################
report.java.lang.MemoryPool.1UsageThreshSupport.AttributeReport.name=java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[UsageThresholdSupported]
report.java.lang.MemoryPool.1UsageThreshSupport.AttributeReport.columns=1UsageThreshSupport
report.java.lang.MemoryPool.1UsageThreshSupport.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.1UsageThreshSupport.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[UsageThresholdSupported]" \
 --vertical-label="verticalLabel" \
 DEF:1UsageThreshSupport={rrd1}:1UsageThreshSupport:AVERAGE \
 AREA:1UsageThreshSupport#edd400 \
 LINE2:1UsageThreshSupport#c4a000:"UsageThresholdSupported" \
 GPRINT:1UsageThreshSupport:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1UsageThreshSupport:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1UsageThreshSupport:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.1CollecUsageThresho.AttributeReport
###########################################
report.java.lang.MemoryPool.1CollecUsageThresho.AttributeReport.name=java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[CollectionUsageThreshold]
report.java.lang.MemoryPool.1CollecUsageThresho.AttributeReport.columns=1CollecUsageThresho
report.java.lang.MemoryPool.1CollecUsageThresho.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.1CollecUsageThresho.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[CollectionUsageThreshold]" \
 --vertical-label="verticalLabel" \
 DEF:1CollecUsageThresho={rrd1}:1CollecUsageThresho:AVERAGE \
 AREA:1CollecUsageThresho#edd400 \
 LINE2:1CollecUsageThresho#c4a000:"CollectionUsageThreshold" \
 GPRINT:1CollecUsageThresho:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1CollecUsageThresho:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1CollecUsageThresho:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.1CollUsagThresExcee.AttributeReport
###########################################
report.java.lang.MemoryPool.1CollUsagThresExcee.AttributeReport.name=java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[CollectionUsageThresholdExceeded]
report.java.lang.MemoryPool.1CollUsagThresExcee.AttributeReport.columns=1CollUsagThresExcee
report.java.lang.MemoryPool.1CollUsagThresExcee.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.1CollUsagThresExcee.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[CollectionUsageThresholdExceeded]" \
 --vertical-label="verticalLabel" \
 DEF:1CollUsagThresExcee={rrd1}:1CollUsagThresExcee:AVERAGE \
 AREA:1CollUsagThresExcee#edd400 \
 LINE2:1CollUsagThresExcee#c4a000:"CollectionUsageThresholdExceeded" \
 GPRINT:1CollUsagThresExcee:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1CollUsagThresExcee:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1CollUsagThresExcee:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.1ColleUsageThresCnt.AttributeReport
###########################################
report.java.lang.MemoryPool.1ColleUsageThresCnt.AttributeReport.name=java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[CollectionUsageThresholdCount]
report.java.lang.MemoryPool.1ColleUsageThresCnt.AttributeReport.columns=1ColleUsageThresCnt
report.java.lang.MemoryPool.1ColleUsageThresCnt.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.1ColleUsageThresCnt.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[CollectionUsageThresholdCount]" \
 --vertical-label="verticalLabel" \
 DEF:1ColleUsageThresCnt={rrd1}:1ColleUsageThresCnt:AVERAGE \
 AREA:1ColleUsageThresCnt#edd400 \
 LINE2:1ColleUsageThresCnt#c4a000:"CollectionUsageThresholdCount" \
 GPRINT:1ColleUsageThresCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1ColleUsageThresCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1ColleUsageThresCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.1CollectionUsage.AttributeReport
###########################################
report.java.lang.MemoryPool.1CollectionUsage.AttributeReport.name=java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[CollectionUsage]
report.java.lang.MemoryPool.1CollectionUsage.AttributeReport.columns=1CollectionUsage
report.java.lang.MemoryPool.1CollectionUsage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.1CollectionUsage.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[CollectionUsage]" \
 --vertical-label="verticalLabel" \
 DEF:1CollectionUsage={rrd1}:1CollectionUsage:AVERAGE \
 AREA:1CollectionUsage#edd400 \
 LINE2:1CollectionUsage#c4a000:"CollectionUsage" \
 GPRINT:1CollectionUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1CollectionUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1CollectionUsage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.1CollUsagThresSuppo.AttributeReport
###########################################
report.java.lang.MemoryPool.1CollUsagThresSuppo.AttributeReport.name=java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[CollectionUsageThresholdSupported]
report.java.lang.MemoryPool.1CollUsagThresSuppo.AttributeReport.columns=1CollUsagThresSuppo
report.java.lang.MemoryPool.1CollUsagThresSuppo.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.1CollUsagThresSuppo.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[CollectionUsageThresholdSupported]" \
 --vertical-label="verticalLabel" \
 DEF:1CollUsagThresSuppo={rrd1}:1CollUsagThresSuppo:AVERAGE \
 AREA:1CollUsagThresSuppo#edd400 \
 LINE2:1CollUsagThresSuppo#c4a000:"CollectionUsageThresholdSupported" \
 GPRINT:1CollUsagThresSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1CollUsagThresSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1CollUsagThresSuppo:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.8ObjectName.AttributeReport
###########################################
report.java.lang.MemoryPool.8ObjectName.AttributeReport.name=java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[ObjectName]
report.java.lang.MemoryPool.8ObjectName.AttributeReport.columns=8ObjectName
report.java.lang.MemoryPool.8ObjectName.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.8ObjectName.AttributeReport.command=--title="java.lang:name=CodeHeap 'non-profiled nmethods',type=MemoryPool[ObjectName]" \
 --vertical-label="verticalLabel" \
 DEF:8ObjectName={rrd1}:8ObjectName:AVERAGE \
 AREA:8ObjectName#edd400 \
 LINE2:8ObjectName#c4a000:"ObjectName" \
 GPRINT:8ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:8ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:8ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.CompositeReport
###########################################
report.java.lang.MemoryPool.Usage.CompositeReport.name=java.lang.MemoryPool.Usage.CompositeReport
report.java.lang.MemoryPool.Usage.CompositeReport.columns=1UsageCommit, 1UsageInit, 1UsageMax, 1UsageUsed
report.java.lang.MemoryPool.Usage.CompositeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.CompositeReport.command=--title="java.lang.MemoryPool.Usage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:1UsageCommit={rrd1}:1UsageCommit:AVERAGE \
 AREA:1UsageCommit#edd400 \
 LINE2:1UsageCommit#c4a000:"committed" \
 GPRINT:1UsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1UsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1UsageCommit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1UsageInit={rrd2}:1UsageInit:AVERAGE \
 AREA:1UsageInit#f57900 \
 LINE2:1UsageInit#ce5c00:"init" \
 GPRINT:1UsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1UsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1UsageInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1UsageMax={rrd3}:1UsageMax:AVERAGE \
 AREA:1UsageMax#c17d11 \
 LINE2:1UsageMax#8f5902:"max" \
 GPRINT:1UsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1UsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1UsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1UsageUsed={rrd4}:1UsageUsed:AVERAGE \
 AREA:1UsageUsed#73d216 \
 LINE2:1UsageUsed#4e9a06:"used" \
 GPRINT:1UsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1UsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1UsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.CompositeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.CompositeReport.name=java.lang.MemoryPool.PeakUsage.CompositeReport
report.java.lang.MemoryPool.PeakUsage.CompositeReport.columns=1PeakUsageCommit, 1PeakUsageInit, 1PeakUsageMax, 1PeakUsageUsed
report.java.lang.MemoryPool.PeakUsage.CompositeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.CompositeReport.command=--title="java.lang.MemoryPool.PeakUsage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:1PeakUsageCommit={rrd1}:1PeakUsageCommit:AVERAGE \
 AREA:1PeakUsageCommit#edd400 \
 LINE2:1PeakUsageCommit#c4a000:"committed" \
 GPRINT:1PeakUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1PeakUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1PeakUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1PeakUsageInit={rrd2}:1PeakUsageInit:AVERAGE \
 AREA:1PeakUsageInit#f57900 \
 LINE2:1PeakUsageInit#ce5c00:"init" \
 GPRINT:1PeakUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1PeakUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1PeakUsageInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1PeakUsageMax={rrd3}:1PeakUsageMax:AVERAGE \
 AREA:1PeakUsageMax#c17d11 \
 LINE2:1PeakUsageMax#8f5902:"max" \
 GPRINT:1PeakUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1PeakUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1PeakUsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1PeakUsageUsed={rrd4}:1PeakUsageUsed:AVERAGE \
 AREA:1PeakUsageUsed#73d216 \
 LINE2:1PeakUsageUsed#4e9a06:"used" \
 GPRINT:1PeakUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1PeakUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1PeakUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.committed.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.committed.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.columns=1UsageCommit
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:1UsageCommit={rrd1}:1UsageCommit:AVERAGE \
 AREA:1UsageCommit#edd400 \
 LINE2:1UsageCommit#c4a000:"committed" \
 GPRINT:1UsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1UsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1UsageCommit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.init.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.init.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.columns=1UsageInit
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:1UsageInit={rrd1}:1UsageInit:AVERAGE \
 AREA:1UsageInit#edd400 \
 LINE2:1UsageInit#c4a000:"init" \
 GPRINT:1UsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1UsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1UsageInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.max.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.max.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.columns=1UsageMax
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:1UsageMax={rrd1}:1UsageMax:AVERAGE \
 AREA:1UsageMax#edd400 \
 LINE2:1UsageMax#c4a000:"max" \
 GPRINT:1UsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1UsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1UsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.used.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.used.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.columns=1UsageUsed
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:1UsageUsed={rrd1}:1UsageUsed:AVERAGE \
 AREA:1UsageUsed#edd400 \
 LINE2:1UsageUsed#c4a000:"used" \
 GPRINT:1UsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1UsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1UsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.columns=1PeakUsageCommit
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:1PeakUsageCommit={rrd1}:1PeakUsageCommit:AVERAGE \
 AREA:1PeakUsageCommit#edd400 \
 LINE2:1PeakUsageCommit#c4a000:"committed" \
 GPRINT:1PeakUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1PeakUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1PeakUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.columns=1PeakUsageInit
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:1PeakUsageInit={rrd1}:1PeakUsageInit:AVERAGE \
 AREA:1PeakUsageInit#edd400 \
 LINE2:1PeakUsageInit#c4a000:"init" \
 GPRINT:1PeakUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1PeakUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1PeakUsageInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.columns=1PeakUsageMax
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:1PeakUsageMax={rrd1}:1PeakUsageMax:AVERAGE \
 AREA:1PeakUsageMax#edd400 \
 LINE2:1PeakUsageMax#c4a000:"max" \
 GPRINT:1PeakUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1PeakUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1PeakUsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.columns=1PeakUsageUsed
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:1PeakUsageUsed={rrd1}:1PeakUsageUsed:AVERAGE \
 AREA:1PeakUsageUsed#edd400 \
 LINE2:1PeakUsageUsed#c4a000:"used" \
 GPRINT:1PeakUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1PeakUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1PeakUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.MBeanReport
###########################################
report.java.lang.MemoryPool.MBeanReport.name=java.lang.MemoryPool
report.java.lang.MemoryPool.MBeanReport.columns=6Valid, 7Name, 2Type, 2Usage, 2PeakUsage, 2MemManagerNames, 2UsageThreshold, 2UsageThreshExceede, 2UsageThresholdCnt, 2UsageThreshSupport, 2CollecUsageThresho, 2CollUsagThresExcee, 2ColleUsageThresCnt, 2CollectionUsage, 2CollUsagThresSuppo, 9ObjectName
report.java.lang.MemoryPool.MBeanReport.type=interfaceSnmp
report.java.lang.MemoryPool.MBeanReport.command=--title="java.lang.MemoryPool" \
 --vertical-label="verticalLabel" \
 DEF:6Valid={rrd1}:6Valid:AVERAGE \
 AREA:6Valid#edd400 \
 LINE2:6Valid#c4a000:"Valid" \
 GPRINT:6Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6Valid:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7Name={rrd2}:7Name:AVERAGE \
 AREA:7Name#f57900 \
 LINE2:7Name#ce5c00:"Name" \
 GPRINT:7Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7Name:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2Type={rrd3}:2Type:AVERAGE \
 AREA:2Type#c17d11 \
 LINE2:2Type#8f5902:"Type" \
 GPRINT:2Type:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2Type:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2Type:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2Usage={rrd4}:2Usage:AVERAGE \
 AREA:2Usage#73d216 \
 LINE2:2Usage#4e9a06:"Usage" \
 GPRINT:2Usage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2Usage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2Usage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2PeakUsage={rrd5}:2PeakUsage:AVERAGE \
 AREA:2PeakUsage#3465a4 \
 LINE2:2PeakUsage#204a87:"PeakUsage" \
 GPRINT:2PeakUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2PeakUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2PeakUsage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2MemManagerNames={rrd6}:2MemManagerNames:AVERAGE \
 AREA:2MemManagerNames#75507b \
 LINE2:2MemManagerNames#5c3566:"MemoryManagerNames" \
 GPRINT:2MemManagerNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2MemManagerNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2MemManagerNames:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2UsageThreshold={rrd7}:2UsageThreshold:AVERAGE \
 AREA:2UsageThreshold#cc0000 \
 LINE2:2UsageThreshold#a40000:"UsageThreshold" \
 GPRINT:2UsageThreshold:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2UsageThreshold:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2UsageThreshold:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2UsageThreshExceede={rrd8}:2UsageThreshExceede:AVERAGE \
 AREA:2UsageThreshExceede#d3d7cf \
 LINE2:2UsageThreshExceede#babdb6:"UsageThresholdExceeded" \
 GPRINT:2UsageThreshExceede:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2UsageThreshExceede:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2UsageThreshExceede:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2UsageThresholdCnt={rrd9}:2UsageThresholdCnt:AVERAGE \
 AREA:2UsageThresholdCnt#555753 \
 LINE2:2UsageThresholdCnt#2e3436:"UsageThresholdCount" \
 GPRINT:2UsageThresholdCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2UsageThresholdCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2UsageThresholdCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2UsageThreshSupport={rrd10}:2UsageThreshSupport:AVERAGE \
 AREA:2UsageThreshSupport#edd400 \
 LINE2:2UsageThreshSupport#c4a000:"UsageThresholdSupported" \
 GPRINT:2UsageThreshSupport:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2UsageThreshSupport:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2UsageThreshSupport:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2CollecUsageThresho={rrd11}:2CollecUsageThresho:AVERAGE \
 AREA:2CollecUsageThresho#f57900 \
 LINE2:2CollecUsageThresho#ce5c00:"CollectionUsageThreshold" \
 GPRINT:2CollecUsageThresho:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2CollecUsageThresho:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2CollecUsageThresho:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2CollUsagThresExcee={rrd12}:2CollUsagThresExcee:AVERAGE \
 AREA:2CollUsagThresExcee#c17d11 \
 LINE2:2CollUsagThresExcee#8f5902:"CollectionUsageThresholdExceeded" \
 GPRINT:2CollUsagThresExcee:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2CollUsagThresExcee:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2CollUsagThresExcee:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2ColleUsageThresCnt={rrd13}:2ColleUsageThresCnt:AVERAGE \
 AREA:2ColleUsageThresCnt#73d216 \
 LINE2:2ColleUsageThresCnt#4e9a06:"CollectionUsageThresholdCount" \
 GPRINT:2ColleUsageThresCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2ColleUsageThresCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2ColleUsageThresCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2CollectionUsage={rrd14}:2CollectionUsage:AVERAGE \
 AREA:2CollectionUsage#3465a4 \
 LINE2:2CollectionUsage#204a87:"CollectionUsage" \
 GPRINT:2CollectionUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2CollectionUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2CollectionUsage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2CollUsagThresSuppo={rrd15}:2CollUsagThresSuppo:AVERAGE \
 AREA:2CollUsagThresSuppo#75507b \
 LINE2:2CollUsagThresSuppo#5c3566:"CollectionUsageThresholdSupported" \
 GPRINT:2CollUsagThresSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2CollUsagThresSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2CollUsagThresSuppo:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:9ObjectName={rrd16}:9ObjectName:AVERAGE \
 AREA:9ObjectName#cc0000 \
 LINE2:9ObjectName#a40000:"ObjectName" \
 GPRINT:9ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:9ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:9ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.6Valid.AttributeReport
###########################################
report.java.lang.MemoryPool.6Valid.AttributeReport.name=java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[Valid]
report.java.lang.MemoryPool.6Valid.AttributeReport.columns=6Valid
report.java.lang.MemoryPool.6Valid.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.6Valid.AttributeReport.command=--title="java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[Valid]" \
 --vertical-label="verticalLabel" \
 DEF:6Valid={rrd1}:6Valid:AVERAGE \
 AREA:6Valid#edd400 \
 LINE2:6Valid#c4a000:"Valid" \
 GPRINT:6Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6Valid:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.7Name.AttributeReport
###########################################
report.java.lang.MemoryPool.7Name.AttributeReport.name=java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[Name]
report.java.lang.MemoryPool.7Name.AttributeReport.columns=7Name
report.java.lang.MemoryPool.7Name.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.7Name.AttributeReport.command=--title="java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[Name]" \
 --vertical-label="verticalLabel" \
 DEF:7Name={rrd1}:7Name:AVERAGE \
 AREA:7Name#edd400 \
 LINE2:7Name#c4a000:"Name" \
 GPRINT:7Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7Name:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.2Type.AttributeReport
###########################################
report.java.lang.MemoryPool.2Type.AttributeReport.name=java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[Type]
report.java.lang.MemoryPool.2Type.AttributeReport.columns=2Type
report.java.lang.MemoryPool.2Type.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.2Type.AttributeReport.command=--title="java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[Type]" \
 --vertical-label="verticalLabel" \
 DEF:2Type={rrd1}:2Type:AVERAGE \
 AREA:2Type#edd400 \
 LINE2:2Type#c4a000:"Type" \
 GPRINT:2Type:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2Type:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2Type:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.2Usage.AttributeReport
###########################################
report.java.lang.MemoryPool.2Usage.AttributeReport.name=java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[Usage]
report.java.lang.MemoryPool.2Usage.AttributeReport.columns=2Usage
report.java.lang.MemoryPool.2Usage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.2Usage.AttributeReport.command=--title="java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[Usage]" \
 --vertical-label="verticalLabel" \
 DEF:2Usage={rrd1}:2Usage:AVERAGE \
 AREA:2Usage#edd400 \
 LINE2:2Usage#c4a000:"Usage" \
 GPRINT:2Usage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2Usage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2Usage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.2PeakUsage.AttributeReport
###########################################
report.java.lang.MemoryPool.2PeakUsage.AttributeReport.name=java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[PeakUsage]
report.java.lang.MemoryPool.2PeakUsage.AttributeReport.columns=2PeakUsage
report.java.lang.MemoryPool.2PeakUsage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.2PeakUsage.AttributeReport.command=--title="java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[PeakUsage]" \
 --vertical-label="verticalLabel" \
 DEF:2PeakUsage={rrd1}:2PeakUsage:AVERAGE \
 AREA:2PeakUsage#edd400 \
 LINE2:2PeakUsage#c4a000:"PeakUsage" \
 GPRINT:2PeakUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2PeakUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2PeakUsage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.2MemManagerNames.AttributeReport
###########################################
report.java.lang.MemoryPool.2MemManagerNames.AttributeReport.name=java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[MemoryManagerNames]
report.java.lang.MemoryPool.2MemManagerNames.AttributeReport.columns=2MemManagerNames
report.java.lang.MemoryPool.2MemManagerNames.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.2MemManagerNames.AttributeReport.command=--title="java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[MemoryManagerNames]" \
 --vertical-label="verticalLabel" \
 DEF:2MemManagerNames={rrd1}:2MemManagerNames:AVERAGE \
 AREA:2MemManagerNames#edd400 \
 LINE2:2MemManagerNames#c4a000:"MemoryManagerNames" \
 GPRINT:2MemManagerNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2MemManagerNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2MemManagerNames:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.2UsageThreshold.AttributeReport
###########################################
report.java.lang.MemoryPool.2UsageThreshold.AttributeReport.name=java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[UsageThreshold]
report.java.lang.MemoryPool.2UsageThreshold.AttributeReport.columns=2UsageThreshold
report.java.lang.MemoryPool.2UsageThreshold.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.2UsageThreshold.AttributeReport.command=--title="java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[UsageThreshold]" \
 --vertical-label="verticalLabel" \
 DEF:2UsageThreshold={rrd1}:2UsageThreshold:AVERAGE \
 AREA:2UsageThreshold#edd400 \
 LINE2:2UsageThreshold#c4a000:"UsageThreshold" \
 GPRINT:2UsageThreshold:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2UsageThreshold:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2UsageThreshold:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.2UsageThreshExceede.AttributeReport
###########################################
report.java.lang.MemoryPool.2UsageThreshExceede.AttributeReport.name=java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[UsageThresholdExceeded]
report.java.lang.MemoryPool.2UsageThreshExceede.AttributeReport.columns=2UsageThreshExceede
report.java.lang.MemoryPool.2UsageThreshExceede.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.2UsageThreshExceede.AttributeReport.command=--title="java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[UsageThresholdExceeded]" \
 --vertical-label="verticalLabel" \
 DEF:2UsageThreshExceede={rrd1}:2UsageThreshExceede:AVERAGE \
 AREA:2UsageThreshExceede#edd400 \
 LINE2:2UsageThreshExceede#c4a000:"UsageThresholdExceeded" \
 GPRINT:2UsageThreshExceede:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2UsageThreshExceede:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2UsageThreshExceede:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.2UsageThresholdCnt.AttributeReport
###########################################
report.java.lang.MemoryPool.2UsageThresholdCnt.AttributeReport.name=java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[UsageThresholdCount]
report.java.lang.MemoryPool.2UsageThresholdCnt.AttributeReport.columns=2UsageThresholdCnt
report.java.lang.MemoryPool.2UsageThresholdCnt.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.2UsageThresholdCnt.AttributeReport.command=--title="java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[UsageThresholdCount]" \
 --vertical-label="verticalLabel" \
 DEF:2UsageThresholdCnt={rrd1}:2UsageThresholdCnt:AVERAGE \
 AREA:2UsageThresholdCnt#edd400 \
 LINE2:2UsageThresholdCnt#c4a000:"UsageThresholdCount" \
 GPRINT:2UsageThresholdCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2UsageThresholdCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2UsageThresholdCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.2UsageThreshSupport.AttributeReport
###########################################
report.java.lang.MemoryPool.2UsageThreshSupport.AttributeReport.name=java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[UsageThresholdSupported]
report.java.lang.MemoryPool.2UsageThreshSupport.AttributeReport.columns=2UsageThreshSupport
report.java.lang.MemoryPool.2UsageThreshSupport.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.2UsageThreshSupport.AttributeReport.command=--title="java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[UsageThresholdSupported]" \
 --vertical-label="verticalLabel" \
 DEF:2UsageThreshSupport={rrd1}:2UsageThreshSupport:AVERAGE \
 AREA:2UsageThreshSupport#edd400 \
 LINE2:2UsageThreshSupport#c4a000:"UsageThresholdSupported" \
 GPRINT:2UsageThreshSupport:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2UsageThreshSupport:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2UsageThreshSupport:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.2CollecUsageThresho.AttributeReport
###########################################
report.java.lang.MemoryPool.2CollecUsageThresho.AttributeReport.name=java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[CollectionUsageThreshold]
report.java.lang.MemoryPool.2CollecUsageThresho.AttributeReport.columns=2CollecUsageThresho
report.java.lang.MemoryPool.2CollecUsageThresho.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.2CollecUsageThresho.AttributeReport.command=--title="java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[CollectionUsageThreshold]" \
 --vertical-label="verticalLabel" \
 DEF:2CollecUsageThresho={rrd1}:2CollecUsageThresho:AVERAGE \
 AREA:2CollecUsageThresho#edd400 \
 LINE2:2CollecUsageThresho#c4a000:"CollectionUsageThreshold" \
 GPRINT:2CollecUsageThresho:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2CollecUsageThresho:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2CollecUsageThresho:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.2CollUsagThresExcee.AttributeReport
###########################################
report.java.lang.MemoryPool.2CollUsagThresExcee.AttributeReport.name=java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[CollectionUsageThresholdExceeded]
report.java.lang.MemoryPool.2CollUsagThresExcee.AttributeReport.columns=2CollUsagThresExcee
report.java.lang.MemoryPool.2CollUsagThresExcee.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.2CollUsagThresExcee.AttributeReport.command=--title="java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[CollectionUsageThresholdExceeded]" \
 --vertical-label="verticalLabel" \
 DEF:2CollUsagThresExcee={rrd1}:2CollUsagThresExcee:AVERAGE \
 AREA:2CollUsagThresExcee#edd400 \
 LINE2:2CollUsagThresExcee#c4a000:"CollectionUsageThresholdExceeded" \
 GPRINT:2CollUsagThresExcee:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2CollUsagThresExcee:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2CollUsagThresExcee:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.2ColleUsageThresCnt.AttributeReport
###########################################
report.java.lang.MemoryPool.2ColleUsageThresCnt.AttributeReport.name=java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[CollectionUsageThresholdCount]
report.java.lang.MemoryPool.2ColleUsageThresCnt.AttributeReport.columns=2ColleUsageThresCnt
report.java.lang.MemoryPool.2ColleUsageThresCnt.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.2ColleUsageThresCnt.AttributeReport.command=--title="java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[CollectionUsageThresholdCount]" \
 --vertical-label="verticalLabel" \
 DEF:2ColleUsageThresCnt={rrd1}:2ColleUsageThresCnt:AVERAGE \
 AREA:2ColleUsageThresCnt#edd400 \
 LINE2:2ColleUsageThresCnt#c4a000:"CollectionUsageThresholdCount" \
 GPRINT:2ColleUsageThresCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2ColleUsageThresCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2ColleUsageThresCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.2CollectionUsage.AttributeReport
###########################################
report.java.lang.MemoryPool.2CollectionUsage.AttributeReport.name=java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[CollectionUsage]
report.java.lang.MemoryPool.2CollectionUsage.AttributeReport.columns=2CollectionUsage
report.java.lang.MemoryPool.2CollectionUsage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.2CollectionUsage.AttributeReport.command=--title="java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[CollectionUsage]" \
 --vertical-label="verticalLabel" \
 DEF:2CollectionUsage={rrd1}:2CollectionUsage:AVERAGE \
 AREA:2CollectionUsage#edd400 \
 LINE2:2CollectionUsage#c4a000:"CollectionUsage" \
 GPRINT:2CollectionUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2CollectionUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2CollectionUsage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.2CollUsagThresSuppo.AttributeReport
###########################################
report.java.lang.MemoryPool.2CollUsagThresSuppo.AttributeReport.name=java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[CollectionUsageThresholdSupported]
report.java.lang.MemoryPool.2CollUsagThresSuppo.AttributeReport.columns=2CollUsagThresSuppo
report.java.lang.MemoryPool.2CollUsagThresSuppo.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.2CollUsagThresSuppo.AttributeReport.command=--title="java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[CollectionUsageThresholdSupported]" \
 --vertical-label="verticalLabel" \
 DEF:2CollUsagThresSuppo={rrd1}:2CollUsagThresSuppo:AVERAGE \
 AREA:2CollUsagThresSuppo#edd400 \
 LINE2:2CollUsagThresSuppo#c4a000:"CollectionUsageThresholdSupported" \
 GPRINT:2CollUsagThresSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2CollUsagThresSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2CollUsagThresSuppo:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.9ObjectName.AttributeReport
###########################################
report.java.lang.MemoryPool.9ObjectName.AttributeReport.name=java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[ObjectName]
report.java.lang.MemoryPool.9ObjectName.AttributeReport.columns=9ObjectName
report.java.lang.MemoryPool.9ObjectName.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.9ObjectName.AttributeReport.command=--title="java.lang:name=CodeHeap 'profiled nmethods',type=MemoryPool[ObjectName]" \
 --vertical-label="verticalLabel" \
 DEF:9ObjectName={rrd1}:9ObjectName:AVERAGE \
 AREA:9ObjectName#edd400 \
 LINE2:9ObjectName#c4a000:"ObjectName" \
 GPRINT:9ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:9ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:9ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.CompositeReport
###########################################
report.java.lang.MemoryPool.Usage.CompositeReport.name=java.lang.MemoryPool.Usage.CompositeReport
report.java.lang.MemoryPool.Usage.CompositeReport.columns=2UsageCommit, 2UsageInit, 2UsageMax, 2UsageUsed
report.java.lang.MemoryPool.Usage.CompositeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.CompositeReport.command=--title="java.lang.MemoryPool.Usage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:2UsageCommit={rrd1}:2UsageCommit:AVERAGE \
 AREA:2UsageCommit#edd400 \
 LINE2:2UsageCommit#c4a000:"committed" \
 GPRINT:2UsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2UsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2UsageCommit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2UsageInit={rrd2}:2UsageInit:AVERAGE \
 AREA:2UsageInit#f57900 \
 LINE2:2UsageInit#ce5c00:"init" \
 GPRINT:2UsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2UsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2UsageInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2UsageMax={rrd3}:2UsageMax:AVERAGE \
 AREA:2UsageMax#c17d11 \
 LINE2:2UsageMax#8f5902:"max" \
 GPRINT:2UsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2UsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2UsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2UsageUsed={rrd4}:2UsageUsed:AVERAGE \
 AREA:2UsageUsed#73d216 \
 LINE2:2UsageUsed#4e9a06:"used" \
 GPRINT:2UsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2UsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2UsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.CompositeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.CompositeReport.name=java.lang.MemoryPool.PeakUsage.CompositeReport
report.java.lang.MemoryPool.PeakUsage.CompositeReport.columns=2PeakUsageCommit, 2PeakUsageInit, 2PeakUsageMax, 2PeakUsageUsed
report.java.lang.MemoryPool.PeakUsage.CompositeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.CompositeReport.command=--title="java.lang.MemoryPool.PeakUsage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:2PeakUsageCommit={rrd1}:2PeakUsageCommit:AVERAGE \
 AREA:2PeakUsageCommit#edd400 \
 LINE2:2PeakUsageCommit#c4a000:"committed" \
 GPRINT:2PeakUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2PeakUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2PeakUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2PeakUsageInit={rrd2}:2PeakUsageInit:AVERAGE \
 AREA:2PeakUsageInit#f57900 \
 LINE2:2PeakUsageInit#ce5c00:"init" \
 GPRINT:2PeakUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2PeakUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2PeakUsageInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2PeakUsageMax={rrd3}:2PeakUsageMax:AVERAGE \
 AREA:2PeakUsageMax#c17d11 \
 LINE2:2PeakUsageMax#8f5902:"max" \
 GPRINT:2PeakUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2PeakUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2PeakUsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2PeakUsageUsed={rrd4}:2PeakUsageUsed:AVERAGE \
 AREA:2PeakUsageUsed#73d216 \
 LINE2:2PeakUsageUsed#4e9a06:"used" \
 GPRINT:2PeakUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2PeakUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2PeakUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.committed.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.committed.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.columns=2UsageCommit
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:2UsageCommit={rrd1}:2UsageCommit:AVERAGE \
 AREA:2UsageCommit#edd400 \
 LINE2:2UsageCommit#c4a000:"committed" \
 GPRINT:2UsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2UsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2UsageCommit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.init.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.init.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.columns=2UsageInit
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:2UsageInit={rrd1}:2UsageInit:AVERAGE \
 AREA:2UsageInit#edd400 \
 LINE2:2UsageInit#c4a000:"init" \
 GPRINT:2UsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2UsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2UsageInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.max.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.max.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.columns=2UsageMax
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:2UsageMax={rrd1}:2UsageMax:AVERAGE \
 AREA:2UsageMax#edd400 \
 LINE2:2UsageMax#c4a000:"max" \
 GPRINT:2UsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2UsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2UsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.used.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.used.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.columns=2UsageUsed
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:2UsageUsed={rrd1}:2UsageUsed:AVERAGE \
 AREA:2UsageUsed#edd400 \
 LINE2:2UsageUsed#c4a000:"used" \
 GPRINT:2UsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2UsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2UsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.columns=2PeakUsageCommit
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:2PeakUsageCommit={rrd1}:2PeakUsageCommit:AVERAGE \
 AREA:2PeakUsageCommit#edd400 \
 LINE2:2PeakUsageCommit#c4a000:"committed" \
 GPRINT:2PeakUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2PeakUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2PeakUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.columns=2PeakUsageInit
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:2PeakUsageInit={rrd1}:2PeakUsageInit:AVERAGE \
 AREA:2PeakUsageInit#edd400 \
 LINE2:2PeakUsageInit#c4a000:"init" \
 GPRINT:2PeakUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2PeakUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2PeakUsageInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.columns=2PeakUsageMax
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:2PeakUsageMax={rrd1}:2PeakUsageMax:AVERAGE \
 AREA:2PeakUsageMax#edd400 \
 LINE2:2PeakUsageMax#c4a000:"max" \
 GPRINT:2PeakUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2PeakUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2PeakUsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.columns=2PeakUsageUsed
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:2PeakUsageUsed={rrd1}:2PeakUsageUsed:AVERAGE \
 AREA:2PeakUsageUsed#edd400 \
 LINE2:2PeakUsageUsed#c4a000:"used" \
 GPRINT:2PeakUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2PeakUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2PeakUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.MBeanReport
###########################################
report.java.lang.MemoryPool.MBeanReport.name=java.lang.MemoryPool
report.java.lang.MemoryPool.MBeanReport.columns=7Valid, 8Name, 3Type, 3Usage, 3PeakUsage, 3MemManagerNames, 3UsageThreshold, 3UsageThreshExceede, 3UsageThresholdCnt, 3UsageThreshSupport, 3CollecUsageThresho, 3CollUsagThresExcee, 3ColleUsageThresCnt, 3CollectionUsage, 3CollUsagThresSuppo, 10ObjectName
report.java.lang.MemoryPool.MBeanReport.type=interfaceSnmp
report.java.lang.MemoryPool.MBeanReport.command=--title="java.lang.MemoryPool" \
 --vertical-label="verticalLabel" \
 DEF:7Valid={rrd1}:7Valid:AVERAGE \
 AREA:7Valid#edd400 \
 LINE2:7Valid#c4a000:"Valid" \
 GPRINT:7Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7Valid:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:8Name={rrd2}:8Name:AVERAGE \
 AREA:8Name#f57900 \
 LINE2:8Name#ce5c00:"Name" \
 GPRINT:8Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:8Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:8Name:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3Type={rrd3}:3Type:AVERAGE \
 AREA:3Type#c17d11 \
 LINE2:3Type#8f5902:"Type" \
 GPRINT:3Type:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3Type:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3Type:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3Usage={rrd4}:3Usage:AVERAGE \
 AREA:3Usage#73d216 \
 LINE2:3Usage#4e9a06:"Usage" \
 GPRINT:3Usage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3Usage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3Usage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3PeakUsage={rrd5}:3PeakUsage:AVERAGE \
 AREA:3PeakUsage#3465a4 \
 LINE2:3PeakUsage#204a87:"PeakUsage" \
 GPRINT:3PeakUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3PeakUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3PeakUsage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3MemManagerNames={rrd6}:3MemManagerNames:AVERAGE \
 AREA:3MemManagerNames#75507b \
 LINE2:3MemManagerNames#5c3566:"MemoryManagerNames" \
 GPRINT:3MemManagerNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3MemManagerNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3MemManagerNames:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3UsageThreshold={rrd7}:3UsageThreshold:AVERAGE \
 AREA:3UsageThreshold#cc0000 \
 LINE2:3UsageThreshold#a40000:"UsageThreshold" \
 GPRINT:3UsageThreshold:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3UsageThreshold:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3UsageThreshold:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3UsageThreshExceede={rrd8}:3UsageThreshExceede:AVERAGE \
 AREA:3UsageThreshExceede#d3d7cf \
 LINE2:3UsageThreshExceede#babdb6:"UsageThresholdExceeded" \
 GPRINT:3UsageThreshExceede:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3UsageThreshExceede:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3UsageThreshExceede:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3UsageThresholdCnt={rrd9}:3UsageThresholdCnt:AVERAGE \
 AREA:3UsageThresholdCnt#555753 \
 LINE2:3UsageThresholdCnt#2e3436:"UsageThresholdCount" \
 GPRINT:3UsageThresholdCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3UsageThresholdCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3UsageThresholdCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3UsageThreshSupport={rrd10}:3UsageThreshSupport:AVERAGE \
 AREA:3UsageThreshSupport#edd400 \
 LINE2:3UsageThreshSupport#c4a000:"UsageThresholdSupported" \
 GPRINT:3UsageThreshSupport:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3UsageThreshSupport:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3UsageThreshSupport:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3CollecUsageThresho={rrd11}:3CollecUsageThresho:AVERAGE \
 AREA:3CollecUsageThresho#f57900 \
 LINE2:3CollecUsageThresho#ce5c00:"CollectionUsageThreshold" \
 GPRINT:3CollecUsageThresho:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3CollecUsageThresho:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3CollecUsageThresho:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3CollUsagThresExcee={rrd12}:3CollUsagThresExcee:AVERAGE \
 AREA:3CollUsagThresExcee#c17d11 \
 LINE2:3CollUsagThresExcee#8f5902:"CollectionUsageThresholdExceeded" \
 GPRINT:3CollUsagThresExcee:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3CollUsagThresExcee:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3CollUsagThresExcee:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3ColleUsageThresCnt={rrd13}:3ColleUsageThresCnt:AVERAGE \
 AREA:3ColleUsageThresCnt#73d216 \
 LINE2:3ColleUsageThresCnt#4e9a06:"CollectionUsageThresholdCount" \
 GPRINT:3ColleUsageThresCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3ColleUsageThresCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3ColleUsageThresCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3CollectionUsage={rrd14}:3CollectionUsage:AVERAGE \
 AREA:3CollectionUsage#3465a4 \
 LINE2:3CollectionUsage#204a87:"CollectionUsage" \
 GPRINT:3CollectionUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3CollectionUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3CollectionUsage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3CollUsagThresSuppo={rrd15}:3CollUsagThresSuppo:AVERAGE \
 AREA:3CollUsagThresSuppo#75507b \
 LINE2:3CollUsagThresSuppo#5c3566:"CollectionUsageThresholdSupported" \
 GPRINT:3CollUsagThresSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3CollUsagThresSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3CollUsagThresSuppo:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:10ObjectName={rrd16}:10ObjectName:AVERAGE \
 AREA:10ObjectName#cc0000 \
 LINE2:10ObjectName#a40000:"ObjectName" \
 GPRINT:10ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:10ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:10ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.7Valid.AttributeReport
###########################################
report.java.lang.MemoryPool.7Valid.AttributeReport.name=java.lang:name=Compressed Class Space,type=MemoryPool[Valid]
report.java.lang.MemoryPool.7Valid.AttributeReport.columns=7Valid
report.java.lang.MemoryPool.7Valid.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.7Valid.AttributeReport.command=--title="java.lang:name=Compressed Class Space,type=MemoryPool[Valid]" \
 --vertical-label="verticalLabel" \
 DEF:7Valid={rrd1}:7Valid:AVERAGE \
 AREA:7Valid#edd400 \
 LINE2:7Valid#c4a000:"Valid" \
 GPRINT:7Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7Valid:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.8Name.AttributeReport
###########################################
report.java.lang.MemoryPool.8Name.AttributeReport.name=java.lang:name=Compressed Class Space,type=MemoryPool[Name]
report.java.lang.MemoryPool.8Name.AttributeReport.columns=8Name
report.java.lang.MemoryPool.8Name.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.8Name.AttributeReport.command=--title="java.lang:name=Compressed Class Space,type=MemoryPool[Name]" \
 --vertical-label="verticalLabel" \
 DEF:8Name={rrd1}:8Name:AVERAGE \
 AREA:8Name#edd400 \
 LINE2:8Name#c4a000:"Name" \
 GPRINT:8Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:8Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:8Name:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.3Type.AttributeReport
###########################################
report.java.lang.MemoryPool.3Type.AttributeReport.name=java.lang:name=Compressed Class Space,type=MemoryPool[Type]
report.java.lang.MemoryPool.3Type.AttributeReport.columns=3Type
report.java.lang.MemoryPool.3Type.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.3Type.AttributeReport.command=--title="java.lang:name=Compressed Class Space,type=MemoryPool[Type]" \
 --vertical-label="verticalLabel" \
 DEF:3Type={rrd1}:3Type:AVERAGE \
 AREA:3Type#edd400 \
 LINE2:3Type#c4a000:"Type" \
 GPRINT:3Type:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3Type:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3Type:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.3Usage.AttributeReport
###########################################
report.java.lang.MemoryPool.3Usage.AttributeReport.name=java.lang:name=Compressed Class Space,type=MemoryPool[Usage]
report.java.lang.MemoryPool.3Usage.AttributeReport.columns=3Usage
report.java.lang.MemoryPool.3Usage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.3Usage.AttributeReport.command=--title="java.lang:name=Compressed Class Space,type=MemoryPool[Usage]" \
 --vertical-label="verticalLabel" \
 DEF:3Usage={rrd1}:3Usage:AVERAGE \
 AREA:3Usage#edd400 \
 LINE2:3Usage#c4a000:"Usage" \
 GPRINT:3Usage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3Usage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3Usage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.3PeakUsage.AttributeReport
###########################################
report.java.lang.MemoryPool.3PeakUsage.AttributeReport.name=java.lang:name=Compressed Class Space,type=MemoryPool[PeakUsage]
report.java.lang.MemoryPool.3PeakUsage.AttributeReport.columns=3PeakUsage
report.java.lang.MemoryPool.3PeakUsage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.3PeakUsage.AttributeReport.command=--title="java.lang:name=Compressed Class Space,type=MemoryPool[PeakUsage]" \
 --vertical-label="verticalLabel" \
 DEF:3PeakUsage={rrd1}:3PeakUsage:AVERAGE \
 AREA:3PeakUsage#edd400 \
 LINE2:3PeakUsage#c4a000:"PeakUsage" \
 GPRINT:3PeakUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3PeakUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3PeakUsage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.3MemManagerNames.AttributeReport
###########################################
report.java.lang.MemoryPool.3MemManagerNames.AttributeReport.name=java.lang:name=Compressed Class Space,type=MemoryPool[MemoryManagerNames]
report.java.lang.MemoryPool.3MemManagerNames.AttributeReport.columns=3MemManagerNames
report.java.lang.MemoryPool.3MemManagerNames.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.3MemManagerNames.AttributeReport.command=--title="java.lang:name=Compressed Class Space,type=MemoryPool[MemoryManagerNames]" \
 --vertical-label="verticalLabel" \
 DEF:3MemManagerNames={rrd1}:3MemManagerNames:AVERAGE \
 AREA:3MemManagerNames#edd400 \
 LINE2:3MemManagerNames#c4a000:"MemoryManagerNames" \
 GPRINT:3MemManagerNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3MemManagerNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3MemManagerNames:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.3UsageThreshold.AttributeReport
###########################################
report.java.lang.MemoryPool.3UsageThreshold.AttributeReport.name=java.lang:name=Compressed Class Space,type=MemoryPool[UsageThreshold]
report.java.lang.MemoryPool.3UsageThreshold.AttributeReport.columns=3UsageThreshold
report.java.lang.MemoryPool.3UsageThreshold.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.3UsageThreshold.AttributeReport.command=--title="java.lang:name=Compressed Class Space,type=MemoryPool[UsageThreshold]" \
 --vertical-label="verticalLabel" \
 DEF:3UsageThreshold={rrd1}:3UsageThreshold:AVERAGE \
 AREA:3UsageThreshold#edd400 \
 LINE2:3UsageThreshold#c4a000:"UsageThreshold" \
 GPRINT:3UsageThreshold:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3UsageThreshold:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3UsageThreshold:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.3UsageThreshExceede.AttributeReport
###########################################
report.java.lang.MemoryPool.3UsageThreshExceede.AttributeReport.name=java.lang:name=Compressed Class Space,type=MemoryPool[UsageThresholdExceeded]
report.java.lang.MemoryPool.3UsageThreshExceede.AttributeReport.columns=3UsageThreshExceede
report.java.lang.MemoryPool.3UsageThreshExceede.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.3UsageThreshExceede.AttributeReport.command=--title="java.lang:name=Compressed Class Space,type=MemoryPool[UsageThresholdExceeded]" \
 --vertical-label="verticalLabel" \
 DEF:3UsageThreshExceede={rrd1}:3UsageThreshExceede:AVERAGE \
 AREA:3UsageThreshExceede#edd400 \
 LINE2:3UsageThreshExceede#c4a000:"UsageThresholdExceeded" \
 GPRINT:3UsageThreshExceede:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3UsageThreshExceede:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3UsageThreshExceede:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.3UsageThresholdCnt.AttributeReport
###########################################
report.java.lang.MemoryPool.3UsageThresholdCnt.AttributeReport.name=java.lang:name=Compressed Class Space,type=MemoryPool[UsageThresholdCount]
report.java.lang.MemoryPool.3UsageThresholdCnt.AttributeReport.columns=3UsageThresholdCnt
report.java.lang.MemoryPool.3UsageThresholdCnt.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.3UsageThresholdCnt.AttributeReport.command=--title="java.lang:name=Compressed Class Space,type=MemoryPool[UsageThresholdCount]" \
 --vertical-label="verticalLabel" \
 DEF:3UsageThresholdCnt={rrd1}:3UsageThresholdCnt:AVERAGE \
 AREA:3UsageThresholdCnt#edd400 \
 LINE2:3UsageThresholdCnt#c4a000:"UsageThresholdCount" \
 GPRINT:3UsageThresholdCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3UsageThresholdCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3UsageThresholdCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.3UsageThreshSupport.AttributeReport
###########################################
report.java.lang.MemoryPool.3UsageThreshSupport.AttributeReport.name=java.lang:name=Compressed Class Space,type=MemoryPool[UsageThresholdSupported]
report.java.lang.MemoryPool.3UsageThreshSupport.AttributeReport.columns=3UsageThreshSupport
report.java.lang.MemoryPool.3UsageThreshSupport.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.3UsageThreshSupport.AttributeReport.command=--title="java.lang:name=Compressed Class Space,type=MemoryPool[UsageThresholdSupported]" \
 --vertical-label="verticalLabel" \
 DEF:3UsageThreshSupport={rrd1}:3UsageThreshSupport:AVERAGE \
 AREA:3UsageThreshSupport#edd400 \
 LINE2:3UsageThreshSupport#c4a000:"UsageThresholdSupported" \
 GPRINT:3UsageThreshSupport:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3UsageThreshSupport:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3UsageThreshSupport:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.3CollecUsageThresho.AttributeReport
###########################################
report.java.lang.MemoryPool.3CollecUsageThresho.AttributeReport.name=java.lang:name=Compressed Class Space,type=MemoryPool[CollectionUsageThreshold]
report.java.lang.MemoryPool.3CollecUsageThresho.AttributeReport.columns=3CollecUsageThresho
report.java.lang.MemoryPool.3CollecUsageThresho.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.3CollecUsageThresho.AttributeReport.command=--title="java.lang:name=Compressed Class Space,type=MemoryPool[CollectionUsageThreshold]" \
 --vertical-label="verticalLabel" \
 DEF:3CollecUsageThresho={rrd1}:3CollecUsageThresho:AVERAGE \
 AREA:3CollecUsageThresho#edd400 \
 LINE2:3CollecUsageThresho#c4a000:"CollectionUsageThreshold" \
 GPRINT:3CollecUsageThresho:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3CollecUsageThresho:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3CollecUsageThresho:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.3CollUsagThresExcee.AttributeReport
###########################################
report.java.lang.MemoryPool.3CollUsagThresExcee.AttributeReport.name=java.lang:name=Compressed Class Space,type=MemoryPool[CollectionUsageThresholdExceeded]
report.java.lang.MemoryPool.3CollUsagThresExcee.AttributeReport.columns=3CollUsagThresExcee
report.java.lang.MemoryPool.3CollUsagThresExcee.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.3CollUsagThresExcee.AttributeReport.command=--title="java.lang:name=Compressed Class Space,type=MemoryPool[CollectionUsageThresholdExceeded]" \
 --vertical-label="verticalLabel" \
 DEF:3CollUsagThresExcee={rrd1}:3CollUsagThresExcee:AVERAGE \
 AREA:3CollUsagThresExcee#edd400 \
 LINE2:3CollUsagThresExcee#c4a000:"CollectionUsageThresholdExceeded" \
 GPRINT:3CollUsagThresExcee:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3CollUsagThresExcee:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3CollUsagThresExcee:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.3ColleUsageThresCnt.AttributeReport
###########################################
report.java.lang.MemoryPool.3ColleUsageThresCnt.AttributeReport.name=java.lang:name=Compressed Class Space,type=MemoryPool[CollectionUsageThresholdCount]
report.java.lang.MemoryPool.3ColleUsageThresCnt.AttributeReport.columns=3ColleUsageThresCnt
report.java.lang.MemoryPool.3ColleUsageThresCnt.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.3ColleUsageThresCnt.AttributeReport.command=--title="java.lang:name=Compressed Class Space,type=MemoryPool[CollectionUsageThresholdCount]" \
 --vertical-label="verticalLabel" \
 DEF:3ColleUsageThresCnt={rrd1}:3ColleUsageThresCnt:AVERAGE \
 AREA:3ColleUsageThresCnt#edd400 \
 LINE2:3ColleUsageThresCnt#c4a000:"CollectionUsageThresholdCount" \
 GPRINT:3ColleUsageThresCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3ColleUsageThresCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3ColleUsageThresCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.3CollectionUsage.AttributeReport
###########################################
report.java.lang.MemoryPool.3CollectionUsage.AttributeReport.name=java.lang:name=Compressed Class Space,type=MemoryPool[CollectionUsage]
report.java.lang.MemoryPool.3CollectionUsage.AttributeReport.columns=3CollectionUsage
report.java.lang.MemoryPool.3CollectionUsage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.3CollectionUsage.AttributeReport.command=--title="java.lang:name=Compressed Class Space,type=MemoryPool[CollectionUsage]" \
 --vertical-label="verticalLabel" \
 DEF:3CollectionUsage={rrd1}:3CollectionUsage:AVERAGE \
 AREA:3CollectionUsage#edd400 \
 LINE2:3CollectionUsage#c4a000:"CollectionUsage" \
 GPRINT:3CollectionUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3CollectionUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3CollectionUsage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.3CollUsagThresSuppo.AttributeReport
###########################################
report.java.lang.MemoryPool.3CollUsagThresSuppo.AttributeReport.name=java.lang:name=Compressed Class Space,type=MemoryPool[CollectionUsageThresholdSupported]
report.java.lang.MemoryPool.3CollUsagThresSuppo.AttributeReport.columns=3CollUsagThresSuppo
report.java.lang.MemoryPool.3CollUsagThresSuppo.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.3CollUsagThresSuppo.AttributeReport.command=--title="java.lang:name=Compressed Class Space,type=MemoryPool[CollectionUsageThresholdSupported]" \
 --vertical-label="verticalLabel" \
 DEF:3CollUsagThresSuppo={rrd1}:3CollUsagThresSuppo:AVERAGE \
 AREA:3CollUsagThresSuppo#edd400 \
 LINE2:3CollUsagThresSuppo#c4a000:"CollectionUsageThresholdSupported" \
 GPRINT:3CollUsagThresSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3CollUsagThresSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3CollUsagThresSuppo:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.10ObjectName.AttributeReport
###########################################
report.java.lang.MemoryPool.10ObjectName.AttributeReport.name=java.lang:name=Compressed Class Space,type=MemoryPool[ObjectName]
report.java.lang.MemoryPool.10ObjectName.AttributeReport.columns=10ObjectName
report.java.lang.MemoryPool.10ObjectName.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.10ObjectName.AttributeReport.command=--title="java.lang:name=Compressed Class Space,type=MemoryPool[ObjectName]" \
 --vertical-label="verticalLabel" \
 DEF:10ObjectName={rrd1}:10ObjectName:AVERAGE \
 AREA:10ObjectName#edd400 \
 LINE2:10ObjectName#c4a000:"ObjectName" \
 GPRINT:10ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:10ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:10ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.CompositeReport
###########################################
report.java.lang.MemoryPool.Usage.CompositeReport.name=java.lang.MemoryPool.Usage.CompositeReport
report.java.lang.MemoryPool.Usage.CompositeReport.columns=3UsageCommit, 3UsageInit, 3UsageMax, 3UsageUsed
report.java.lang.MemoryPool.Usage.CompositeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.CompositeReport.command=--title="java.lang.MemoryPool.Usage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:3UsageCommit={rrd1}:3UsageCommit:AVERAGE \
 AREA:3UsageCommit#edd400 \
 LINE2:3UsageCommit#c4a000:"committed" \
 GPRINT:3UsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3UsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3UsageCommit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3UsageInit={rrd2}:3UsageInit:AVERAGE \
 AREA:3UsageInit#f57900 \
 LINE2:3UsageInit#ce5c00:"init" \
 GPRINT:3UsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3UsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3UsageInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3UsageMax={rrd3}:3UsageMax:AVERAGE \
 AREA:3UsageMax#c17d11 \
 LINE2:3UsageMax#8f5902:"max" \
 GPRINT:3UsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3UsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3UsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3UsageUsed={rrd4}:3UsageUsed:AVERAGE \
 AREA:3UsageUsed#73d216 \
 LINE2:3UsageUsed#4e9a06:"used" \
 GPRINT:3UsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3UsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3UsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.CompositeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.CompositeReport.name=java.lang.MemoryPool.PeakUsage.CompositeReport
report.java.lang.MemoryPool.PeakUsage.CompositeReport.columns=3PeakUsageCommit, 3PeakUsageInit, 3PeakUsageMax, 3PeakUsageUsed
report.java.lang.MemoryPool.PeakUsage.CompositeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.CompositeReport.command=--title="java.lang.MemoryPool.PeakUsage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:3PeakUsageCommit={rrd1}:3PeakUsageCommit:AVERAGE \
 AREA:3PeakUsageCommit#edd400 \
 LINE2:3PeakUsageCommit#c4a000:"committed" \
 GPRINT:3PeakUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3PeakUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3PeakUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3PeakUsageInit={rrd2}:3PeakUsageInit:AVERAGE \
 AREA:3PeakUsageInit#f57900 \
 LINE2:3PeakUsageInit#ce5c00:"init" \
 GPRINT:3PeakUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3PeakUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3PeakUsageInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3PeakUsageMax={rrd3}:3PeakUsageMax:AVERAGE \
 AREA:3PeakUsageMax#c17d11 \
 LINE2:3PeakUsageMax#8f5902:"max" \
 GPRINT:3PeakUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3PeakUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3PeakUsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:3PeakUsageUsed={rrd4}:3PeakUsageUsed:AVERAGE \
 AREA:3PeakUsageUsed#73d216 \
 LINE2:3PeakUsageUsed#4e9a06:"used" \
 GPRINT:3PeakUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3PeakUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3PeakUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.committed.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.committed.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.columns=3UsageCommit
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:3UsageCommit={rrd1}:3UsageCommit:AVERAGE \
 AREA:3UsageCommit#edd400 \
 LINE2:3UsageCommit#c4a000:"committed" \
 GPRINT:3UsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3UsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3UsageCommit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.init.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.init.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.columns=3UsageInit
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:3UsageInit={rrd1}:3UsageInit:AVERAGE \
 AREA:3UsageInit#edd400 \
 LINE2:3UsageInit#c4a000:"init" \
 GPRINT:3UsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3UsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3UsageInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.max.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.max.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.columns=3UsageMax
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:3UsageMax={rrd1}:3UsageMax:AVERAGE \
 AREA:3UsageMax#edd400 \
 LINE2:3UsageMax#c4a000:"max" \
 GPRINT:3UsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3UsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3UsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.used.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.used.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.columns=3UsageUsed
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:3UsageUsed={rrd1}:3UsageUsed:AVERAGE \
 AREA:3UsageUsed#edd400 \
 LINE2:3UsageUsed#c4a000:"used" \
 GPRINT:3UsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3UsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3UsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.columns=3PeakUsageCommit
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:3PeakUsageCommit={rrd1}:3PeakUsageCommit:AVERAGE \
 AREA:3PeakUsageCommit#edd400 \
 LINE2:3PeakUsageCommit#c4a000:"committed" \
 GPRINT:3PeakUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3PeakUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3PeakUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.columns=3PeakUsageInit
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:3PeakUsageInit={rrd1}:3PeakUsageInit:AVERAGE \
 AREA:3PeakUsageInit#edd400 \
 LINE2:3PeakUsageInit#c4a000:"init" \
 GPRINT:3PeakUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3PeakUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3PeakUsageInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.columns=3PeakUsageMax
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:3PeakUsageMax={rrd1}:3PeakUsageMax:AVERAGE \
 AREA:3PeakUsageMax#edd400 \
 LINE2:3PeakUsageMax#c4a000:"max" \
 GPRINT:3PeakUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3PeakUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3PeakUsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.columns=3PeakUsageUsed
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:3PeakUsageUsed={rrd1}:3PeakUsageUsed:AVERAGE \
 AREA:3PeakUsageUsed#edd400 \
 LINE2:3PeakUsageUsed#c4a000:"used" \
 GPRINT:3PeakUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:3PeakUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:3PeakUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.MBeanReport
###########################################
report.java.lang.MemoryPool.MBeanReport.name=java.lang.MemoryPool
report.java.lang.MemoryPool.MBeanReport.columns=8Valid, 9Name, 4Type, 4Usage, 4PeakUsage, 4MemManagerNames, 4UsageThreshold, 4UsageThreshExceede, 4UsageThresholdCnt, 4UsageThreshSupport, 4CollecUsageThresho, 4CollUsagThresExcee, 4ColleUsageThresCnt, 4CollectionUsage, 4CollUsagThresSuppo, 11ObjectName
report.java.lang.MemoryPool.MBeanReport.type=interfaceSnmp
report.java.lang.MemoryPool.MBeanReport.command=--title="java.lang.MemoryPool" \
 --vertical-label="verticalLabel" \
 DEF:8Valid={rrd1}:8Valid:AVERAGE \
 AREA:8Valid#edd400 \
 LINE2:8Valid#c4a000:"Valid" \
 GPRINT:8Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:8Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:8Valid:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:9Name={rrd2}:9Name:AVERAGE \
 AREA:9Name#f57900 \
 LINE2:9Name#ce5c00:"Name" \
 GPRINT:9Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:9Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:9Name:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4Type={rrd3}:4Type:AVERAGE \
 AREA:4Type#c17d11 \
 LINE2:4Type#8f5902:"Type" \
 GPRINT:4Type:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4Type:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4Type:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4Usage={rrd4}:4Usage:AVERAGE \
 AREA:4Usage#73d216 \
 LINE2:4Usage#4e9a06:"Usage" \
 GPRINT:4Usage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4Usage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4Usage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4PeakUsage={rrd5}:4PeakUsage:AVERAGE \
 AREA:4PeakUsage#3465a4 \
 LINE2:4PeakUsage#204a87:"PeakUsage" \
 GPRINT:4PeakUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4PeakUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4PeakUsage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4MemManagerNames={rrd6}:4MemManagerNames:AVERAGE \
 AREA:4MemManagerNames#75507b \
 LINE2:4MemManagerNames#5c3566:"MemoryManagerNames" \
 GPRINT:4MemManagerNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4MemManagerNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4MemManagerNames:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4UsageThreshold={rrd7}:4UsageThreshold:AVERAGE \
 AREA:4UsageThreshold#cc0000 \
 LINE2:4UsageThreshold#a40000:"UsageThreshold" \
 GPRINT:4UsageThreshold:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4UsageThreshold:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4UsageThreshold:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4UsageThreshExceede={rrd8}:4UsageThreshExceede:AVERAGE \
 AREA:4UsageThreshExceede#d3d7cf \
 LINE2:4UsageThreshExceede#babdb6:"UsageThresholdExceeded" \
 GPRINT:4UsageThreshExceede:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4UsageThreshExceede:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4UsageThreshExceede:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4UsageThresholdCnt={rrd9}:4UsageThresholdCnt:AVERAGE \
 AREA:4UsageThresholdCnt#555753 \
 LINE2:4UsageThresholdCnt#2e3436:"UsageThresholdCount" \
 GPRINT:4UsageThresholdCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4UsageThresholdCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4UsageThresholdCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4UsageThreshSupport={rrd10}:4UsageThreshSupport:AVERAGE \
 AREA:4UsageThreshSupport#edd400 \
 LINE2:4UsageThreshSupport#c4a000:"UsageThresholdSupported" \
 GPRINT:4UsageThreshSupport:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4UsageThreshSupport:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4UsageThreshSupport:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4CollecUsageThresho={rrd11}:4CollecUsageThresho:AVERAGE \
 AREA:4CollecUsageThresho#f57900 \
 LINE2:4CollecUsageThresho#ce5c00:"CollectionUsageThreshold" \
 GPRINT:4CollecUsageThresho:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4CollecUsageThresho:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4CollecUsageThresho:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4CollUsagThresExcee={rrd12}:4CollUsagThresExcee:AVERAGE \
 AREA:4CollUsagThresExcee#c17d11 \
 LINE2:4CollUsagThresExcee#8f5902:"CollectionUsageThresholdExceeded" \
 GPRINT:4CollUsagThresExcee:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4CollUsagThresExcee:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4CollUsagThresExcee:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4ColleUsageThresCnt={rrd13}:4ColleUsageThresCnt:AVERAGE \
 AREA:4ColleUsageThresCnt#73d216 \
 LINE2:4ColleUsageThresCnt#4e9a06:"CollectionUsageThresholdCount" \
 GPRINT:4ColleUsageThresCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4ColleUsageThresCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4ColleUsageThresCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4CollectionUsage={rrd14}:4CollectionUsage:AVERAGE \
 AREA:4CollectionUsage#3465a4 \
 LINE2:4CollectionUsage#204a87:"CollectionUsage" \
 GPRINT:4CollectionUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4CollectionUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4CollectionUsage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4CollUsagThresSuppo={rrd15}:4CollUsagThresSuppo:AVERAGE \
 AREA:4CollUsagThresSuppo#75507b \
 LINE2:4CollUsagThresSuppo#5c3566:"CollectionUsageThresholdSupported" \
 GPRINT:4CollUsagThresSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4CollUsagThresSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4CollUsagThresSuppo:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:11ObjectName={rrd16}:11ObjectName:AVERAGE \
 AREA:11ObjectName#cc0000 \
 LINE2:11ObjectName#a40000:"ObjectName" \
 GPRINT:11ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:11ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:11ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.8Valid.AttributeReport
###########################################
report.java.lang.MemoryPool.8Valid.AttributeReport.name=java.lang:name=G1 Eden Space,type=MemoryPool[Valid]
report.java.lang.MemoryPool.8Valid.AttributeReport.columns=8Valid
report.java.lang.MemoryPool.8Valid.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.8Valid.AttributeReport.command=--title="java.lang:name=G1 Eden Space,type=MemoryPool[Valid]" \
 --vertical-label="verticalLabel" \
 DEF:8Valid={rrd1}:8Valid:AVERAGE \
 AREA:8Valid#edd400 \
 LINE2:8Valid#c4a000:"Valid" \
 GPRINT:8Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:8Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:8Valid:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.9Name.AttributeReport
###########################################
report.java.lang.MemoryPool.9Name.AttributeReport.name=java.lang:name=G1 Eden Space,type=MemoryPool[Name]
report.java.lang.MemoryPool.9Name.AttributeReport.columns=9Name
report.java.lang.MemoryPool.9Name.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.9Name.AttributeReport.command=--title="java.lang:name=G1 Eden Space,type=MemoryPool[Name]" \
 --vertical-label="verticalLabel" \
 DEF:9Name={rrd1}:9Name:AVERAGE \
 AREA:9Name#edd400 \
 LINE2:9Name#c4a000:"Name" \
 GPRINT:9Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:9Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:9Name:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.4Type.AttributeReport
###########################################
report.java.lang.MemoryPool.4Type.AttributeReport.name=java.lang:name=G1 Eden Space,type=MemoryPool[Type]
report.java.lang.MemoryPool.4Type.AttributeReport.columns=4Type
report.java.lang.MemoryPool.4Type.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.4Type.AttributeReport.command=--title="java.lang:name=G1 Eden Space,type=MemoryPool[Type]" \
 --vertical-label="verticalLabel" \
 DEF:4Type={rrd1}:4Type:AVERAGE \
 AREA:4Type#edd400 \
 LINE2:4Type#c4a000:"Type" \
 GPRINT:4Type:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4Type:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4Type:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.4Usage.AttributeReport
###########################################
report.java.lang.MemoryPool.4Usage.AttributeReport.name=java.lang:name=G1 Eden Space,type=MemoryPool[Usage]
report.java.lang.MemoryPool.4Usage.AttributeReport.columns=4Usage
report.java.lang.MemoryPool.4Usage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.4Usage.AttributeReport.command=--title="java.lang:name=G1 Eden Space,type=MemoryPool[Usage]" \
 --vertical-label="verticalLabel" \
 DEF:4Usage={rrd1}:4Usage:AVERAGE \
 AREA:4Usage#edd400 \
 LINE2:4Usage#c4a000:"Usage" \
 GPRINT:4Usage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4Usage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4Usage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.4PeakUsage.AttributeReport
###########################################
report.java.lang.MemoryPool.4PeakUsage.AttributeReport.name=java.lang:name=G1 Eden Space,type=MemoryPool[PeakUsage]
report.java.lang.MemoryPool.4PeakUsage.AttributeReport.columns=4PeakUsage
report.java.lang.MemoryPool.4PeakUsage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.4PeakUsage.AttributeReport.command=--title="java.lang:name=G1 Eden Space,type=MemoryPool[PeakUsage]" \
 --vertical-label="verticalLabel" \
 DEF:4PeakUsage={rrd1}:4PeakUsage:AVERAGE \
 AREA:4PeakUsage#edd400 \
 LINE2:4PeakUsage#c4a000:"PeakUsage" \
 GPRINT:4PeakUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4PeakUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4PeakUsage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.4MemManagerNames.AttributeReport
###########################################
report.java.lang.MemoryPool.4MemManagerNames.AttributeReport.name=java.lang:name=G1 Eden Space,type=MemoryPool[MemoryManagerNames]
report.java.lang.MemoryPool.4MemManagerNames.AttributeReport.columns=4MemManagerNames
report.java.lang.MemoryPool.4MemManagerNames.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.4MemManagerNames.AttributeReport.command=--title="java.lang:name=G1 Eden Space,type=MemoryPool[MemoryManagerNames]" \
 --vertical-label="verticalLabel" \
 DEF:4MemManagerNames={rrd1}:4MemManagerNames:AVERAGE \
 AREA:4MemManagerNames#edd400 \
 LINE2:4MemManagerNames#c4a000:"MemoryManagerNames" \
 GPRINT:4MemManagerNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4MemManagerNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4MemManagerNames:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.4UsageThreshold.AttributeReport
###########################################
report.java.lang.MemoryPool.4UsageThreshold.AttributeReport.name=java.lang:name=G1 Eden Space,type=MemoryPool[UsageThreshold]
report.java.lang.MemoryPool.4UsageThreshold.AttributeReport.columns=4UsageThreshold
report.java.lang.MemoryPool.4UsageThreshold.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.4UsageThreshold.AttributeReport.command=--title="java.lang:name=G1 Eden Space,type=MemoryPool[UsageThreshold]" \
 --vertical-label="verticalLabel" \
 DEF:4UsageThreshold={rrd1}:4UsageThreshold:AVERAGE \
 AREA:4UsageThreshold#edd400 \
 LINE2:4UsageThreshold#c4a000:"UsageThreshold" \
 GPRINT:4UsageThreshold:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4UsageThreshold:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4UsageThreshold:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.4UsageThreshExceede.AttributeReport
###########################################
report.java.lang.MemoryPool.4UsageThreshExceede.AttributeReport.name=java.lang:name=G1 Eden Space,type=MemoryPool[UsageThresholdExceeded]
report.java.lang.MemoryPool.4UsageThreshExceede.AttributeReport.columns=4UsageThreshExceede
report.java.lang.MemoryPool.4UsageThreshExceede.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.4UsageThreshExceede.AttributeReport.command=--title="java.lang:name=G1 Eden Space,type=MemoryPool[UsageThresholdExceeded]" \
 --vertical-label="verticalLabel" \
 DEF:4UsageThreshExceede={rrd1}:4UsageThreshExceede:AVERAGE \
 AREA:4UsageThreshExceede#edd400 \
 LINE2:4UsageThreshExceede#c4a000:"UsageThresholdExceeded" \
 GPRINT:4UsageThreshExceede:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4UsageThreshExceede:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4UsageThreshExceede:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.4UsageThresholdCnt.AttributeReport
###########################################
report.java.lang.MemoryPool.4UsageThresholdCnt.AttributeReport.name=java.lang:name=G1 Eden Space,type=MemoryPool[UsageThresholdCount]
report.java.lang.MemoryPool.4UsageThresholdCnt.AttributeReport.columns=4UsageThresholdCnt
report.java.lang.MemoryPool.4UsageThresholdCnt.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.4UsageThresholdCnt.AttributeReport.command=--title="java.lang:name=G1 Eden Space,type=MemoryPool[UsageThresholdCount]" \
 --vertical-label="verticalLabel" \
 DEF:4UsageThresholdCnt={rrd1}:4UsageThresholdCnt:AVERAGE \
 AREA:4UsageThresholdCnt#edd400 \
 LINE2:4UsageThresholdCnt#c4a000:"UsageThresholdCount" \
 GPRINT:4UsageThresholdCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4UsageThresholdCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4UsageThresholdCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.4UsageThreshSupport.AttributeReport
###########################################
report.java.lang.MemoryPool.4UsageThreshSupport.AttributeReport.name=java.lang:name=G1 Eden Space,type=MemoryPool[UsageThresholdSupported]
report.java.lang.MemoryPool.4UsageThreshSupport.AttributeReport.columns=4UsageThreshSupport
report.java.lang.MemoryPool.4UsageThreshSupport.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.4UsageThreshSupport.AttributeReport.command=--title="java.lang:name=G1 Eden Space,type=MemoryPool[UsageThresholdSupported]" \
 --vertical-label="verticalLabel" \
 DEF:4UsageThreshSupport={rrd1}:4UsageThreshSupport:AVERAGE \
 AREA:4UsageThreshSupport#edd400 \
 LINE2:4UsageThreshSupport#c4a000:"UsageThresholdSupported" \
 GPRINT:4UsageThreshSupport:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4UsageThreshSupport:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4UsageThreshSupport:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.4CollecUsageThresho.AttributeReport
###########################################
report.java.lang.MemoryPool.4CollecUsageThresho.AttributeReport.name=java.lang:name=G1 Eden Space,type=MemoryPool[CollectionUsageThreshold]
report.java.lang.MemoryPool.4CollecUsageThresho.AttributeReport.columns=4CollecUsageThresho
report.java.lang.MemoryPool.4CollecUsageThresho.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.4CollecUsageThresho.AttributeReport.command=--title="java.lang:name=G1 Eden Space,type=MemoryPool[CollectionUsageThreshold]" \
 --vertical-label="verticalLabel" \
 DEF:4CollecUsageThresho={rrd1}:4CollecUsageThresho:AVERAGE \
 AREA:4CollecUsageThresho#edd400 \
 LINE2:4CollecUsageThresho#c4a000:"CollectionUsageThreshold" \
 GPRINT:4CollecUsageThresho:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4CollecUsageThresho:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4CollecUsageThresho:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.4CollUsagThresExcee.AttributeReport
###########################################
report.java.lang.MemoryPool.4CollUsagThresExcee.AttributeReport.name=java.lang:name=G1 Eden Space,type=MemoryPool[CollectionUsageThresholdExceeded]
report.java.lang.MemoryPool.4CollUsagThresExcee.AttributeReport.columns=4CollUsagThresExcee
report.java.lang.MemoryPool.4CollUsagThresExcee.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.4CollUsagThresExcee.AttributeReport.command=--title="java.lang:name=G1 Eden Space,type=MemoryPool[CollectionUsageThresholdExceeded]" \
 --vertical-label="verticalLabel" \
 DEF:4CollUsagThresExcee={rrd1}:4CollUsagThresExcee:AVERAGE \
 AREA:4CollUsagThresExcee#edd400 \
 LINE2:4CollUsagThresExcee#c4a000:"CollectionUsageThresholdExceeded" \
 GPRINT:4CollUsagThresExcee:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4CollUsagThresExcee:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4CollUsagThresExcee:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.4ColleUsageThresCnt.AttributeReport
###########################################
report.java.lang.MemoryPool.4ColleUsageThresCnt.AttributeReport.name=java.lang:name=G1 Eden Space,type=MemoryPool[CollectionUsageThresholdCount]
report.java.lang.MemoryPool.4ColleUsageThresCnt.AttributeReport.columns=4ColleUsageThresCnt
report.java.lang.MemoryPool.4ColleUsageThresCnt.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.4ColleUsageThresCnt.AttributeReport.command=--title="java.lang:name=G1 Eden Space,type=MemoryPool[CollectionUsageThresholdCount]" \
 --vertical-label="verticalLabel" \
 DEF:4ColleUsageThresCnt={rrd1}:4ColleUsageThresCnt:AVERAGE \
 AREA:4ColleUsageThresCnt#edd400 \
 LINE2:4ColleUsageThresCnt#c4a000:"CollectionUsageThresholdCount" \
 GPRINT:4ColleUsageThresCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4ColleUsageThresCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4ColleUsageThresCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.4CollectionUsage.AttributeReport
###########################################
report.java.lang.MemoryPool.4CollectionUsage.AttributeReport.name=java.lang:name=G1 Eden Space,type=MemoryPool[CollectionUsage]
report.java.lang.MemoryPool.4CollectionUsage.AttributeReport.columns=4CollectionUsage
report.java.lang.MemoryPool.4CollectionUsage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.4CollectionUsage.AttributeReport.command=--title="java.lang:name=G1 Eden Space,type=MemoryPool[CollectionUsage]" \
 --vertical-label="verticalLabel" \
 DEF:4CollectionUsage={rrd1}:4CollectionUsage:AVERAGE \
 AREA:4CollectionUsage#edd400 \
 LINE2:4CollectionUsage#c4a000:"CollectionUsage" \
 GPRINT:4CollectionUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4CollectionUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4CollectionUsage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.4CollUsagThresSuppo.AttributeReport
###########################################
report.java.lang.MemoryPool.4CollUsagThresSuppo.AttributeReport.name=java.lang:name=G1 Eden Space,type=MemoryPool[CollectionUsageThresholdSupported]
report.java.lang.MemoryPool.4CollUsagThresSuppo.AttributeReport.columns=4CollUsagThresSuppo
report.java.lang.MemoryPool.4CollUsagThresSuppo.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.4CollUsagThresSuppo.AttributeReport.command=--title="java.lang:name=G1 Eden Space,type=MemoryPool[CollectionUsageThresholdSupported]" \
 --vertical-label="verticalLabel" \
 DEF:4CollUsagThresSuppo={rrd1}:4CollUsagThresSuppo:AVERAGE \
 AREA:4CollUsagThresSuppo#edd400 \
 LINE2:4CollUsagThresSuppo#c4a000:"CollectionUsageThresholdSupported" \
 GPRINT:4CollUsagThresSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4CollUsagThresSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4CollUsagThresSuppo:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.11ObjectName.AttributeReport
###########################################
report.java.lang.MemoryPool.11ObjectName.AttributeReport.name=java.lang:name=G1 Eden Space,type=MemoryPool[ObjectName]
report.java.lang.MemoryPool.11ObjectName.AttributeReport.columns=11ObjectName
report.java.lang.MemoryPool.11ObjectName.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.11ObjectName.AttributeReport.command=--title="java.lang:name=G1 Eden Space,type=MemoryPool[ObjectName]" \
 --vertical-label="verticalLabel" \
 DEF:11ObjectName={rrd1}:11ObjectName:AVERAGE \
 AREA:11ObjectName#edd400 \
 LINE2:11ObjectName#c4a000:"ObjectName" \
 GPRINT:11ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:11ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:11ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.CompositeReport
###########################################
report.java.lang.MemoryPool.Usage.CompositeReport.name=java.lang.MemoryPool.Usage.CompositeReport
report.java.lang.MemoryPool.Usage.CompositeReport.columns=4UsageCommit, 4UsageInit, 4UsageMax, 4UsageUsed
report.java.lang.MemoryPool.Usage.CompositeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.CompositeReport.command=--title="java.lang.MemoryPool.Usage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:4UsageCommit={rrd1}:4UsageCommit:AVERAGE \
 AREA:4UsageCommit#edd400 \
 LINE2:4UsageCommit#c4a000:"committed" \
 GPRINT:4UsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4UsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4UsageCommit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4UsageInit={rrd2}:4UsageInit:AVERAGE \
 AREA:4UsageInit#f57900 \
 LINE2:4UsageInit#ce5c00:"init" \
 GPRINT:4UsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4UsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4UsageInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4UsageMax={rrd3}:4UsageMax:AVERAGE \
 AREA:4UsageMax#c17d11 \
 LINE2:4UsageMax#8f5902:"max" \
 GPRINT:4UsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4UsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4UsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4UsageUsed={rrd4}:4UsageUsed:AVERAGE \
 AREA:4UsageUsed#73d216 \
 LINE2:4UsageUsed#4e9a06:"used" \
 GPRINT:4UsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4UsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4UsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.CompositeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.CompositeReport.name=java.lang.MemoryPool.PeakUsage.CompositeReport
report.java.lang.MemoryPool.PeakUsage.CompositeReport.columns=4PeakUsageCommit, 4PeakUsageInit, 4PeakUsageMax, 4PeakUsageUsed
report.java.lang.MemoryPool.PeakUsage.CompositeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.CompositeReport.command=--title="java.lang.MemoryPool.PeakUsage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:4PeakUsageCommit={rrd1}:4PeakUsageCommit:AVERAGE \
 AREA:4PeakUsageCommit#edd400 \
 LINE2:4PeakUsageCommit#c4a000:"committed" \
 GPRINT:4PeakUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4PeakUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4PeakUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4PeakUsageInit={rrd2}:4PeakUsageInit:AVERAGE \
 AREA:4PeakUsageInit#f57900 \
 LINE2:4PeakUsageInit#ce5c00:"init" \
 GPRINT:4PeakUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4PeakUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4PeakUsageInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4PeakUsageMax={rrd3}:4PeakUsageMax:AVERAGE \
 AREA:4PeakUsageMax#c17d11 \
 LINE2:4PeakUsageMax#8f5902:"max" \
 GPRINT:4PeakUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4PeakUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4PeakUsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:4PeakUsageUsed={rrd4}:4PeakUsageUsed:AVERAGE \
 AREA:4PeakUsageUsed#73d216 \
 LINE2:4PeakUsageUsed#4e9a06:"used" \
 GPRINT:4PeakUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4PeakUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4PeakUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.CollectionUsage.CompositeReport
###########################################
report.java.lang.MemoryPool.CollectionUsage.CompositeReport.name=java.lang.MemoryPool.CollectionUsage.CompositeReport
report.java.lang.MemoryPool.CollectionUsage.CompositeReport.columns=0CollectUsageCommit, 0CollectioUsageInit, 0CollectionUsageMax, 0CollectioUsageUsed
report.java.lang.MemoryPool.CollectionUsage.CompositeReport.type=interfaceSnmp
report.java.lang.MemoryPool.CollectionUsage.CompositeReport.command=--title="java.lang.MemoryPool.CollectionUsage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:0CollectUsageCommit={rrd1}:0CollectUsageCommit:AVERAGE \
 AREA:0CollectUsageCommit#edd400 \
 LINE2:0CollectUsageCommit#c4a000:"committed" \
 GPRINT:0CollectUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CollectUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CollectUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0CollectioUsageInit={rrd2}:0CollectioUsageInit:AVERAGE \
 AREA:0CollectioUsageInit#f57900 \
 LINE2:0CollectioUsageInit#ce5c00:"init" \
 GPRINT:0CollectioUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CollectioUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CollectioUsageInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0CollectionUsageMax={rrd3}:0CollectionUsageMax:AVERAGE \
 AREA:0CollectionUsageMax#c17d11 \
 LINE2:0CollectionUsageMax#8f5902:"max" \
 GPRINT:0CollectionUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CollectionUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CollectionUsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0CollectioUsageUsed={rrd4}:0CollectioUsageUsed:AVERAGE \
 AREA:0CollectioUsageUsed#73d216 \
 LINE2:0CollectioUsageUsed#4e9a06:"used" \
 GPRINT:0CollectioUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CollectioUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CollectioUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.committed.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.committed.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.columns=4UsageCommit
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:4UsageCommit={rrd1}:4UsageCommit:AVERAGE \
 AREA:4UsageCommit#edd400 \
 LINE2:4UsageCommit#c4a000:"committed" \
 GPRINT:4UsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4UsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4UsageCommit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.init.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.init.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.columns=4UsageInit
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:4UsageInit={rrd1}:4UsageInit:AVERAGE \
 AREA:4UsageInit#edd400 \
 LINE2:4UsageInit#c4a000:"init" \
 GPRINT:4UsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4UsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4UsageInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.max.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.max.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.columns=4UsageMax
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:4UsageMax={rrd1}:4UsageMax:AVERAGE \
 AREA:4UsageMax#edd400 \
 LINE2:4UsageMax#c4a000:"max" \
 GPRINT:4UsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4UsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4UsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.used.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.used.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.columns=4UsageUsed
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:4UsageUsed={rrd1}:4UsageUsed:AVERAGE \
 AREA:4UsageUsed#edd400 \
 LINE2:4UsageUsed#c4a000:"used" \
 GPRINT:4UsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4UsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4UsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.columns=4PeakUsageCommit
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:4PeakUsageCommit={rrd1}:4PeakUsageCommit:AVERAGE \
 AREA:4PeakUsageCommit#edd400 \
 LINE2:4PeakUsageCommit#c4a000:"committed" \
 GPRINT:4PeakUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4PeakUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4PeakUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.columns=4PeakUsageInit
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:4PeakUsageInit={rrd1}:4PeakUsageInit:AVERAGE \
 AREA:4PeakUsageInit#edd400 \
 LINE2:4PeakUsageInit#c4a000:"init" \
 GPRINT:4PeakUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4PeakUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4PeakUsageInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.columns=4PeakUsageMax
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:4PeakUsageMax={rrd1}:4PeakUsageMax:AVERAGE \
 AREA:4PeakUsageMax#edd400 \
 LINE2:4PeakUsageMax#c4a000:"max" \
 GPRINT:4PeakUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4PeakUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4PeakUsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.columns=4PeakUsageUsed
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:4PeakUsageUsed={rrd1}:4PeakUsageUsed:AVERAGE \
 AREA:4PeakUsageUsed#edd400 \
 LINE2:4PeakUsageUsed#c4a000:"used" \
 GPRINT:4PeakUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:4PeakUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:4PeakUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport.name=java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport
report.java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport.columns=0CollectUsageCommit
report.java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport.command=--title="java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0CollectUsageCommit={rrd1}:0CollectUsageCommit:AVERAGE \
 AREA:0CollectUsageCommit#edd400 \
 LINE2:0CollectUsageCommit#c4a000:"committed" \
 GPRINT:0CollectUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CollectUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CollectUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport.name=java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport
report.java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport.columns=0CollectioUsageInit
report.java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport.command=--title="java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0CollectioUsageInit={rrd1}:0CollectioUsageInit:AVERAGE \
 AREA:0CollectioUsageInit#edd400 \
 LINE2:0CollectioUsageInit#c4a000:"init" \
 GPRINT:0CollectioUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CollectioUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CollectioUsageInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport.name=java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport
report.java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport.columns=0CollectionUsageMax
report.java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport.command=--title="java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0CollectionUsageMax={rrd1}:0CollectionUsageMax:AVERAGE \
 AREA:0CollectionUsageMax#edd400 \
 LINE2:0CollectionUsageMax#c4a000:"max" \
 GPRINT:0CollectionUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CollectionUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CollectionUsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport.name=java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport
report.java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport.columns=0CollectioUsageUsed
report.java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport.command=--title="java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:0CollectioUsageUsed={rrd1}:0CollectioUsageUsed:AVERAGE \
 AREA:0CollectioUsageUsed#edd400 \
 LINE2:0CollectioUsageUsed#c4a000:"used" \
 GPRINT:0CollectioUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CollectioUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CollectioUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.MBeanReport
###########################################
report.java.lang.MemoryPool.MBeanReport.name=java.lang.MemoryPool
report.java.lang.MemoryPool.MBeanReport.columns=9Valid, 10Name, 5Type, 5Usage, 5PeakUsage, 5MemManagerNames, 5UsageThreshold, 5UsageThreshExceede, 5UsageThresholdCnt, 5UsageThreshSupport, 5CollecUsageThresho, 5CollUsagThresExcee, 5ColleUsageThresCnt, 5CollectionUsage, 5CollUsagThresSuppo, 12ObjectName
report.java.lang.MemoryPool.MBeanReport.type=interfaceSnmp
report.java.lang.MemoryPool.MBeanReport.command=--title="java.lang.MemoryPool" \
 --vertical-label="verticalLabel" \
 DEF:9Valid={rrd1}:9Valid:AVERAGE \
 AREA:9Valid#edd400 \
 LINE2:9Valid#c4a000:"Valid" \
 GPRINT:9Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:9Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:9Valid:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:10Name={rrd2}:10Name:AVERAGE \
 AREA:10Name#f57900 \
 LINE2:10Name#ce5c00:"Name" \
 GPRINT:10Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:10Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:10Name:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5Type={rrd3}:5Type:AVERAGE \
 AREA:5Type#c17d11 \
 LINE2:5Type#8f5902:"Type" \
 GPRINT:5Type:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5Type:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5Type:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5Usage={rrd4}:5Usage:AVERAGE \
 AREA:5Usage#73d216 \
 LINE2:5Usage#4e9a06:"Usage" \
 GPRINT:5Usage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5Usage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5Usage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5PeakUsage={rrd5}:5PeakUsage:AVERAGE \
 AREA:5PeakUsage#3465a4 \
 LINE2:5PeakUsage#204a87:"PeakUsage" \
 GPRINT:5PeakUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5PeakUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5PeakUsage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5MemManagerNames={rrd6}:5MemManagerNames:AVERAGE \
 AREA:5MemManagerNames#75507b \
 LINE2:5MemManagerNames#5c3566:"MemoryManagerNames" \
 GPRINT:5MemManagerNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5MemManagerNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5MemManagerNames:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5UsageThreshold={rrd7}:5UsageThreshold:AVERAGE \
 AREA:5UsageThreshold#cc0000 \
 LINE2:5UsageThreshold#a40000:"UsageThreshold" \
 GPRINT:5UsageThreshold:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5UsageThreshold:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5UsageThreshold:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5UsageThreshExceede={rrd8}:5UsageThreshExceede:AVERAGE \
 AREA:5UsageThreshExceede#d3d7cf \
 LINE2:5UsageThreshExceede#babdb6:"UsageThresholdExceeded" \
 GPRINT:5UsageThreshExceede:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5UsageThreshExceede:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5UsageThreshExceede:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5UsageThresholdCnt={rrd9}:5UsageThresholdCnt:AVERAGE \
 AREA:5UsageThresholdCnt#555753 \
 LINE2:5UsageThresholdCnt#2e3436:"UsageThresholdCount" \
 GPRINT:5UsageThresholdCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5UsageThresholdCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5UsageThresholdCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5UsageThreshSupport={rrd10}:5UsageThreshSupport:AVERAGE \
 AREA:5UsageThreshSupport#edd400 \
 LINE2:5UsageThreshSupport#c4a000:"UsageThresholdSupported" \
 GPRINT:5UsageThreshSupport:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5UsageThreshSupport:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5UsageThreshSupport:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5CollecUsageThresho={rrd11}:5CollecUsageThresho:AVERAGE \
 AREA:5CollecUsageThresho#f57900 \
 LINE2:5CollecUsageThresho#ce5c00:"CollectionUsageThreshold" \
 GPRINT:5CollecUsageThresho:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5CollecUsageThresho:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5CollecUsageThresho:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5CollUsagThresExcee={rrd12}:5CollUsagThresExcee:AVERAGE \
 AREA:5CollUsagThresExcee#c17d11 \
 LINE2:5CollUsagThresExcee#8f5902:"CollectionUsageThresholdExceeded" \
 GPRINT:5CollUsagThresExcee:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5CollUsagThresExcee:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5CollUsagThresExcee:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5ColleUsageThresCnt={rrd13}:5ColleUsageThresCnt:AVERAGE \
 AREA:5ColleUsageThresCnt#73d216 \
 LINE2:5ColleUsageThresCnt#4e9a06:"CollectionUsageThresholdCount" \
 GPRINT:5ColleUsageThresCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5ColleUsageThresCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5ColleUsageThresCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5CollectionUsage={rrd14}:5CollectionUsage:AVERAGE \
 AREA:5CollectionUsage#3465a4 \
 LINE2:5CollectionUsage#204a87:"CollectionUsage" \
 GPRINT:5CollectionUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5CollectionUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5CollectionUsage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5CollUsagThresSuppo={rrd15}:5CollUsagThresSuppo:AVERAGE \
 AREA:5CollUsagThresSuppo#75507b \
 LINE2:5CollUsagThresSuppo#5c3566:"CollectionUsageThresholdSupported" \
 GPRINT:5CollUsagThresSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5CollUsagThresSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5CollUsagThresSuppo:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:12ObjectName={rrd16}:12ObjectName:AVERAGE \
 AREA:12ObjectName#cc0000 \
 LINE2:12ObjectName#a40000:"ObjectName" \
 GPRINT:12ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:12ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:12ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.9Valid.AttributeReport
###########################################
report.java.lang.MemoryPool.9Valid.AttributeReport.name=java.lang:name=G1 Old Gen,type=MemoryPool[Valid]
report.java.lang.MemoryPool.9Valid.AttributeReport.columns=9Valid
report.java.lang.MemoryPool.9Valid.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.9Valid.AttributeReport.command=--title="java.lang:name=G1 Old Gen,type=MemoryPool[Valid]" \
 --vertical-label="verticalLabel" \
 DEF:9Valid={rrd1}:9Valid:AVERAGE \
 AREA:9Valid#edd400 \
 LINE2:9Valid#c4a000:"Valid" \
 GPRINT:9Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:9Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:9Valid:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.10Name.AttributeReport
###########################################
report.java.lang.MemoryPool.10Name.AttributeReport.name=java.lang:name=G1 Old Gen,type=MemoryPool[Name]
report.java.lang.MemoryPool.10Name.AttributeReport.columns=10Name
report.java.lang.MemoryPool.10Name.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.10Name.AttributeReport.command=--title="java.lang:name=G1 Old Gen,type=MemoryPool[Name]" \
 --vertical-label="verticalLabel" \
 DEF:10Name={rrd1}:10Name:AVERAGE \
 AREA:10Name#edd400 \
 LINE2:10Name#c4a000:"Name" \
 GPRINT:10Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:10Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:10Name:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.5Type.AttributeReport
###########################################
report.java.lang.MemoryPool.5Type.AttributeReport.name=java.lang:name=G1 Old Gen,type=MemoryPool[Type]
report.java.lang.MemoryPool.5Type.AttributeReport.columns=5Type
report.java.lang.MemoryPool.5Type.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.5Type.AttributeReport.command=--title="java.lang:name=G1 Old Gen,type=MemoryPool[Type]" \
 --vertical-label="verticalLabel" \
 DEF:5Type={rrd1}:5Type:AVERAGE \
 AREA:5Type#edd400 \
 LINE2:5Type#c4a000:"Type" \
 GPRINT:5Type:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5Type:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5Type:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.5Usage.AttributeReport
###########################################
report.java.lang.MemoryPool.5Usage.AttributeReport.name=java.lang:name=G1 Old Gen,type=MemoryPool[Usage]
report.java.lang.MemoryPool.5Usage.AttributeReport.columns=5Usage
report.java.lang.MemoryPool.5Usage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.5Usage.AttributeReport.command=--title="java.lang:name=G1 Old Gen,type=MemoryPool[Usage]" \
 --vertical-label="verticalLabel" \
 DEF:5Usage={rrd1}:5Usage:AVERAGE \
 AREA:5Usage#edd400 \
 LINE2:5Usage#c4a000:"Usage" \
 GPRINT:5Usage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5Usage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5Usage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.5PeakUsage.AttributeReport
###########################################
report.java.lang.MemoryPool.5PeakUsage.AttributeReport.name=java.lang:name=G1 Old Gen,type=MemoryPool[PeakUsage]
report.java.lang.MemoryPool.5PeakUsage.AttributeReport.columns=5PeakUsage
report.java.lang.MemoryPool.5PeakUsage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.5PeakUsage.AttributeReport.command=--title="java.lang:name=G1 Old Gen,type=MemoryPool[PeakUsage]" \
 --vertical-label="verticalLabel" \
 DEF:5PeakUsage={rrd1}:5PeakUsage:AVERAGE \
 AREA:5PeakUsage#edd400 \
 LINE2:5PeakUsage#c4a000:"PeakUsage" \
 GPRINT:5PeakUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5PeakUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5PeakUsage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.5MemManagerNames.AttributeReport
###########################################
report.java.lang.MemoryPool.5MemManagerNames.AttributeReport.name=java.lang:name=G1 Old Gen,type=MemoryPool[MemoryManagerNames]
report.java.lang.MemoryPool.5MemManagerNames.AttributeReport.columns=5MemManagerNames
report.java.lang.MemoryPool.5MemManagerNames.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.5MemManagerNames.AttributeReport.command=--title="java.lang:name=G1 Old Gen,type=MemoryPool[MemoryManagerNames]" \
 --vertical-label="verticalLabel" \
 DEF:5MemManagerNames={rrd1}:5MemManagerNames:AVERAGE \
 AREA:5MemManagerNames#edd400 \
 LINE2:5MemManagerNames#c4a000:"MemoryManagerNames" \
 GPRINT:5MemManagerNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5MemManagerNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5MemManagerNames:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.5UsageThreshold.AttributeReport
###########################################
report.java.lang.MemoryPool.5UsageThreshold.AttributeReport.name=java.lang:name=G1 Old Gen,type=MemoryPool[UsageThreshold]
report.java.lang.MemoryPool.5UsageThreshold.AttributeReport.columns=5UsageThreshold
report.java.lang.MemoryPool.5UsageThreshold.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.5UsageThreshold.AttributeReport.command=--title="java.lang:name=G1 Old Gen,type=MemoryPool[UsageThreshold]" \
 --vertical-label="verticalLabel" \
 DEF:5UsageThreshold={rrd1}:5UsageThreshold:AVERAGE \
 AREA:5UsageThreshold#edd400 \
 LINE2:5UsageThreshold#c4a000:"UsageThreshold" \
 GPRINT:5UsageThreshold:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5UsageThreshold:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5UsageThreshold:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.5UsageThreshExceede.AttributeReport
###########################################
report.java.lang.MemoryPool.5UsageThreshExceede.AttributeReport.name=java.lang:name=G1 Old Gen,type=MemoryPool[UsageThresholdExceeded]
report.java.lang.MemoryPool.5UsageThreshExceede.AttributeReport.columns=5UsageThreshExceede
report.java.lang.MemoryPool.5UsageThreshExceede.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.5UsageThreshExceede.AttributeReport.command=--title="java.lang:name=G1 Old Gen,type=MemoryPool[UsageThresholdExceeded]" \
 --vertical-label="verticalLabel" \
 DEF:5UsageThreshExceede={rrd1}:5UsageThreshExceede:AVERAGE \
 AREA:5UsageThreshExceede#edd400 \
 LINE2:5UsageThreshExceede#c4a000:"UsageThresholdExceeded" \
 GPRINT:5UsageThreshExceede:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5UsageThreshExceede:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5UsageThreshExceede:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.5UsageThresholdCnt.AttributeReport
###########################################
report.java.lang.MemoryPool.5UsageThresholdCnt.AttributeReport.name=java.lang:name=G1 Old Gen,type=MemoryPool[UsageThresholdCount]
report.java.lang.MemoryPool.5UsageThresholdCnt.AttributeReport.columns=5UsageThresholdCnt
report.java.lang.MemoryPool.5UsageThresholdCnt.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.5UsageThresholdCnt.AttributeReport.command=--title="java.lang:name=G1 Old Gen,type=MemoryPool[UsageThresholdCount]" \
 --vertical-label="verticalLabel" \
 DEF:5UsageThresholdCnt={rrd1}:5UsageThresholdCnt:AVERAGE \
 AREA:5UsageThresholdCnt#edd400 \
 LINE2:5UsageThresholdCnt#c4a000:"UsageThresholdCount" \
 GPRINT:5UsageThresholdCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5UsageThresholdCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5UsageThresholdCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.5UsageThreshSupport.AttributeReport
###########################################
report.java.lang.MemoryPool.5UsageThreshSupport.AttributeReport.name=java.lang:name=G1 Old Gen,type=MemoryPool[UsageThresholdSupported]
report.java.lang.MemoryPool.5UsageThreshSupport.AttributeReport.columns=5UsageThreshSupport
report.java.lang.MemoryPool.5UsageThreshSupport.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.5UsageThreshSupport.AttributeReport.command=--title="java.lang:name=G1 Old Gen,type=MemoryPool[UsageThresholdSupported]" \
 --vertical-label="verticalLabel" \
 DEF:5UsageThreshSupport={rrd1}:5UsageThreshSupport:AVERAGE \
 AREA:5UsageThreshSupport#edd400 \
 LINE2:5UsageThreshSupport#c4a000:"UsageThresholdSupported" \
 GPRINT:5UsageThreshSupport:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5UsageThreshSupport:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5UsageThreshSupport:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.5CollecUsageThresho.AttributeReport
###########################################
report.java.lang.MemoryPool.5CollecUsageThresho.AttributeReport.name=java.lang:name=G1 Old Gen,type=MemoryPool[CollectionUsageThreshold]
report.java.lang.MemoryPool.5CollecUsageThresho.AttributeReport.columns=5CollecUsageThresho
report.java.lang.MemoryPool.5CollecUsageThresho.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.5CollecUsageThresho.AttributeReport.command=--title="java.lang:name=G1 Old Gen,type=MemoryPool[CollectionUsageThreshold]" \
 --vertical-label="verticalLabel" \
 DEF:5CollecUsageThresho={rrd1}:5CollecUsageThresho:AVERAGE \
 AREA:5CollecUsageThresho#edd400 \
 LINE2:5CollecUsageThresho#c4a000:"CollectionUsageThreshold" \
 GPRINT:5CollecUsageThresho:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5CollecUsageThresho:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5CollecUsageThresho:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.5CollUsagThresExcee.AttributeReport
###########################################
report.java.lang.MemoryPool.5CollUsagThresExcee.AttributeReport.name=java.lang:name=G1 Old Gen,type=MemoryPool[CollectionUsageThresholdExceeded]
report.java.lang.MemoryPool.5CollUsagThresExcee.AttributeReport.columns=5CollUsagThresExcee
report.java.lang.MemoryPool.5CollUsagThresExcee.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.5CollUsagThresExcee.AttributeReport.command=--title="java.lang:name=G1 Old Gen,type=MemoryPool[CollectionUsageThresholdExceeded]" \
 --vertical-label="verticalLabel" \
 DEF:5CollUsagThresExcee={rrd1}:5CollUsagThresExcee:AVERAGE \
 AREA:5CollUsagThresExcee#edd400 \
 LINE2:5CollUsagThresExcee#c4a000:"CollectionUsageThresholdExceeded" \
 GPRINT:5CollUsagThresExcee:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5CollUsagThresExcee:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5CollUsagThresExcee:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.5ColleUsageThresCnt.AttributeReport
###########################################
report.java.lang.MemoryPool.5ColleUsageThresCnt.AttributeReport.name=java.lang:name=G1 Old Gen,type=MemoryPool[CollectionUsageThresholdCount]
report.java.lang.MemoryPool.5ColleUsageThresCnt.AttributeReport.columns=5ColleUsageThresCnt
report.java.lang.MemoryPool.5ColleUsageThresCnt.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.5ColleUsageThresCnt.AttributeReport.command=--title="java.lang:name=G1 Old Gen,type=MemoryPool[CollectionUsageThresholdCount]" \
 --vertical-label="verticalLabel" \
 DEF:5ColleUsageThresCnt={rrd1}:5ColleUsageThresCnt:AVERAGE \
 AREA:5ColleUsageThresCnt#edd400 \
 LINE2:5ColleUsageThresCnt#c4a000:"CollectionUsageThresholdCount" \
 GPRINT:5ColleUsageThresCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5ColleUsageThresCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5ColleUsageThresCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.5CollectionUsage.AttributeReport
###########################################
report.java.lang.MemoryPool.5CollectionUsage.AttributeReport.name=java.lang:name=G1 Old Gen,type=MemoryPool[CollectionUsage]
report.java.lang.MemoryPool.5CollectionUsage.AttributeReport.columns=5CollectionUsage
report.java.lang.MemoryPool.5CollectionUsage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.5CollectionUsage.AttributeReport.command=--title="java.lang:name=G1 Old Gen,type=MemoryPool[CollectionUsage]" \
 --vertical-label="verticalLabel" \
 DEF:5CollectionUsage={rrd1}:5CollectionUsage:AVERAGE \
 AREA:5CollectionUsage#edd400 \
 LINE2:5CollectionUsage#c4a000:"CollectionUsage" \
 GPRINT:5CollectionUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5CollectionUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5CollectionUsage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.5CollUsagThresSuppo.AttributeReport
###########################################
report.java.lang.MemoryPool.5CollUsagThresSuppo.AttributeReport.name=java.lang:name=G1 Old Gen,type=MemoryPool[CollectionUsageThresholdSupported]
report.java.lang.MemoryPool.5CollUsagThresSuppo.AttributeReport.columns=5CollUsagThresSuppo
report.java.lang.MemoryPool.5CollUsagThresSuppo.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.5CollUsagThresSuppo.AttributeReport.command=--title="java.lang:name=G1 Old Gen,type=MemoryPool[CollectionUsageThresholdSupported]" \
 --vertical-label="verticalLabel" \
 DEF:5CollUsagThresSuppo={rrd1}:5CollUsagThresSuppo:AVERAGE \
 AREA:5CollUsagThresSuppo#edd400 \
 LINE2:5CollUsagThresSuppo#c4a000:"CollectionUsageThresholdSupported" \
 GPRINT:5CollUsagThresSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5CollUsagThresSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5CollUsagThresSuppo:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.12ObjectName.AttributeReport
###########################################
report.java.lang.MemoryPool.12ObjectName.AttributeReport.name=java.lang:name=G1 Old Gen,type=MemoryPool[ObjectName]
report.java.lang.MemoryPool.12ObjectName.AttributeReport.columns=12ObjectName
report.java.lang.MemoryPool.12ObjectName.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.12ObjectName.AttributeReport.command=--title="java.lang:name=G1 Old Gen,type=MemoryPool[ObjectName]" \
 --vertical-label="verticalLabel" \
 DEF:12ObjectName={rrd1}:12ObjectName:AVERAGE \
 AREA:12ObjectName#edd400 \
 LINE2:12ObjectName#c4a000:"ObjectName" \
 GPRINT:12ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:12ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:12ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.CompositeReport
###########################################
report.java.lang.MemoryPool.Usage.CompositeReport.name=java.lang.MemoryPool.Usage.CompositeReport
report.java.lang.MemoryPool.Usage.CompositeReport.columns=5UsageCommit, 5UsageInit, 5UsageMax, 5UsageUsed
report.java.lang.MemoryPool.Usage.CompositeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.CompositeReport.command=--title="java.lang.MemoryPool.Usage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:5UsageCommit={rrd1}:5UsageCommit:AVERAGE \
 AREA:5UsageCommit#edd400 \
 LINE2:5UsageCommit#c4a000:"committed" \
 GPRINT:5UsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5UsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5UsageCommit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5UsageInit={rrd2}:5UsageInit:AVERAGE \
 AREA:5UsageInit#f57900 \
 LINE2:5UsageInit#ce5c00:"init" \
 GPRINT:5UsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5UsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5UsageInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5UsageMax={rrd3}:5UsageMax:AVERAGE \
 AREA:5UsageMax#c17d11 \
 LINE2:5UsageMax#8f5902:"max" \
 GPRINT:5UsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5UsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5UsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5UsageUsed={rrd4}:5UsageUsed:AVERAGE \
 AREA:5UsageUsed#73d216 \
 LINE2:5UsageUsed#4e9a06:"used" \
 GPRINT:5UsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5UsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5UsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.CompositeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.CompositeReport.name=java.lang.MemoryPool.PeakUsage.CompositeReport
report.java.lang.MemoryPool.PeakUsage.CompositeReport.columns=5PeakUsageCommit, 5PeakUsageInit, 5PeakUsageMax, 5PeakUsageUsed
report.java.lang.MemoryPool.PeakUsage.CompositeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.CompositeReport.command=--title="java.lang.MemoryPool.PeakUsage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:5PeakUsageCommit={rrd1}:5PeakUsageCommit:AVERAGE \
 AREA:5PeakUsageCommit#edd400 \
 LINE2:5PeakUsageCommit#c4a000:"committed" \
 GPRINT:5PeakUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5PeakUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5PeakUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5PeakUsageInit={rrd2}:5PeakUsageInit:AVERAGE \
 AREA:5PeakUsageInit#f57900 \
 LINE2:5PeakUsageInit#ce5c00:"init" \
 GPRINT:5PeakUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5PeakUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5PeakUsageInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5PeakUsageMax={rrd3}:5PeakUsageMax:AVERAGE \
 AREA:5PeakUsageMax#c17d11 \
 LINE2:5PeakUsageMax#8f5902:"max" \
 GPRINT:5PeakUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5PeakUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5PeakUsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:5PeakUsageUsed={rrd4}:5PeakUsageUsed:AVERAGE \
 AREA:5PeakUsageUsed#73d216 \
 LINE2:5PeakUsageUsed#4e9a06:"used" \
 GPRINT:5PeakUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5PeakUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5PeakUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.CollectionUsage.CompositeReport
###########################################
report.java.lang.MemoryPool.CollectionUsage.CompositeReport.name=java.lang.MemoryPool.CollectionUsage.CompositeReport
report.java.lang.MemoryPool.CollectionUsage.CompositeReport.columns=1CollectUsageCommit, 1CollectioUsageInit, 1CollectionUsageMax, 1CollectioUsageUsed
report.java.lang.MemoryPool.CollectionUsage.CompositeReport.type=interfaceSnmp
report.java.lang.MemoryPool.CollectionUsage.CompositeReport.command=--title="java.lang.MemoryPool.CollectionUsage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:1CollectUsageCommit={rrd1}:1CollectUsageCommit:AVERAGE \
 AREA:1CollectUsageCommit#edd400 \
 LINE2:1CollectUsageCommit#c4a000:"committed" \
 GPRINT:1CollectUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1CollectUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1CollectUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1CollectioUsageInit={rrd2}:1CollectioUsageInit:AVERAGE \
 AREA:1CollectioUsageInit#f57900 \
 LINE2:1CollectioUsageInit#ce5c00:"init" \
 GPRINT:1CollectioUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1CollectioUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1CollectioUsageInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1CollectionUsageMax={rrd3}:1CollectionUsageMax:AVERAGE \
 AREA:1CollectionUsageMax#c17d11 \
 LINE2:1CollectionUsageMax#8f5902:"max" \
 GPRINT:1CollectionUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1CollectionUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1CollectionUsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:1CollectioUsageUsed={rrd4}:1CollectioUsageUsed:AVERAGE \
 AREA:1CollectioUsageUsed#73d216 \
 LINE2:1CollectioUsageUsed#4e9a06:"used" \
 GPRINT:1CollectioUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1CollectioUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1CollectioUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.committed.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.committed.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.columns=5UsageCommit
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:5UsageCommit={rrd1}:5UsageCommit:AVERAGE \
 AREA:5UsageCommit#edd400 \
 LINE2:5UsageCommit#c4a000:"committed" \
 GPRINT:5UsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5UsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5UsageCommit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.init.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.init.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.columns=5UsageInit
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:5UsageInit={rrd1}:5UsageInit:AVERAGE \
 AREA:5UsageInit#edd400 \
 LINE2:5UsageInit#c4a000:"init" \
 GPRINT:5UsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5UsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5UsageInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.max.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.max.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.columns=5UsageMax
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:5UsageMax={rrd1}:5UsageMax:AVERAGE \
 AREA:5UsageMax#edd400 \
 LINE2:5UsageMax#c4a000:"max" \
 GPRINT:5UsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5UsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5UsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.used.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.used.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.columns=5UsageUsed
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:5UsageUsed={rrd1}:5UsageUsed:AVERAGE \
 AREA:5UsageUsed#edd400 \
 LINE2:5UsageUsed#c4a000:"used" \
 GPRINT:5UsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5UsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5UsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.columns=5PeakUsageCommit
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:5PeakUsageCommit={rrd1}:5PeakUsageCommit:AVERAGE \
 AREA:5PeakUsageCommit#edd400 \
 LINE2:5PeakUsageCommit#c4a000:"committed" \
 GPRINT:5PeakUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5PeakUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5PeakUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.columns=5PeakUsageInit
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:5PeakUsageInit={rrd1}:5PeakUsageInit:AVERAGE \
 AREA:5PeakUsageInit#edd400 \
 LINE2:5PeakUsageInit#c4a000:"init" \
 GPRINT:5PeakUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5PeakUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5PeakUsageInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.columns=5PeakUsageMax
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:5PeakUsageMax={rrd1}:5PeakUsageMax:AVERAGE \
 AREA:5PeakUsageMax#edd400 \
 LINE2:5PeakUsageMax#c4a000:"max" \
 GPRINT:5PeakUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5PeakUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5PeakUsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.columns=5PeakUsageUsed
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:5PeakUsageUsed={rrd1}:5PeakUsageUsed:AVERAGE \
 AREA:5PeakUsageUsed#edd400 \
 LINE2:5PeakUsageUsed#c4a000:"used" \
 GPRINT:5PeakUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:5PeakUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:5PeakUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport.name=java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport
report.java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport.columns=1CollectUsageCommit
report.java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport.command=--title="java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:1CollectUsageCommit={rrd1}:1CollectUsageCommit:AVERAGE \
 AREA:1CollectUsageCommit#edd400 \
 LINE2:1CollectUsageCommit#c4a000:"committed" \
 GPRINT:1CollectUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1CollectUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1CollectUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport.name=java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport
report.java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport.columns=1CollectioUsageInit
report.java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport.command=--title="java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:1CollectioUsageInit={rrd1}:1CollectioUsageInit:AVERAGE \
 AREA:1CollectioUsageInit#edd400 \
 LINE2:1CollectioUsageInit#c4a000:"init" \
 GPRINT:1CollectioUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1CollectioUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1CollectioUsageInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport.name=java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport
report.java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport.columns=1CollectionUsageMax
report.java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport.command=--title="java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:1CollectionUsageMax={rrd1}:1CollectionUsageMax:AVERAGE \
 AREA:1CollectionUsageMax#edd400 \
 LINE2:1CollectionUsageMax#c4a000:"max" \
 GPRINT:1CollectionUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1CollectionUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1CollectionUsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport.name=java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport
report.java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport.columns=1CollectioUsageUsed
report.java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport.command=--title="java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:1CollectioUsageUsed={rrd1}:1CollectioUsageUsed:AVERAGE \
 AREA:1CollectioUsageUsed#edd400 \
 LINE2:1CollectioUsageUsed#c4a000:"used" \
 GPRINT:1CollectioUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:1CollectioUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:1CollectioUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.MBeanReport
###########################################
report.java.lang.MemoryPool.MBeanReport.name=java.lang.MemoryPool
report.java.lang.MemoryPool.MBeanReport.columns=10Valid, 11Name, 6Type, 6Usage, 6PeakUsage, 6MemManagerNames, 6UsageThreshold, 6UsageThreshExceede, 6UsageThresholdCnt, 6UsageThreshSupport, 6CollecUsageThresho, 6CollUsagThresExcee, 6ColleUsageThresCnt, 6CollectionUsage, 6CollUsagThresSuppo, 13ObjectName
report.java.lang.MemoryPool.MBeanReport.type=interfaceSnmp
report.java.lang.MemoryPool.MBeanReport.command=--title="java.lang.MemoryPool" \
 --vertical-label="verticalLabel" \
 DEF:10Valid={rrd1}:10Valid:AVERAGE \
 AREA:10Valid#edd400 \
 LINE2:10Valid#c4a000:"Valid" \
 GPRINT:10Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:10Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:10Valid:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:11Name={rrd2}:11Name:AVERAGE \
 AREA:11Name#f57900 \
 LINE2:11Name#ce5c00:"Name" \
 GPRINT:11Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:11Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:11Name:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6Type={rrd3}:6Type:AVERAGE \
 AREA:6Type#c17d11 \
 LINE2:6Type#8f5902:"Type" \
 GPRINT:6Type:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6Type:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6Type:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6Usage={rrd4}:6Usage:AVERAGE \
 AREA:6Usage#73d216 \
 LINE2:6Usage#4e9a06:"Usage" \
 GPRINT:6Usage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6Usage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6Usage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6PeakUsage={rrd5}:6PeakUsage:AVERAGE \
 AREA:6PeakUsage#3465a4 \
 LINE2:6PeakUsage#204a87:"PeakUsage" \
 GPRINT:6PeakUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6PeakUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6PeakUsage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6MemManagerNames={rrd6}:6MemManagerNames:AVERAGE \
 AREA:6MemManagerNames#75507b \
 LINE2:6MemManagerNames#5c3566:"MemoryManagerNames" \
 GPRINT:6MemManagerNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6MemManagerNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6MemManagerNames:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6UsageThreshold={rrd7}:6UsageThreshold:AVERAGE \
 AREA:6UsageThreshold#cc0000 \
 LINE2:6UsageThreshold#a40000:"UsageThreshold" \
 GPRINT:6UsageThreshold:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6UsageThreshold:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6UsageThreshold:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6UsageThreshExceede={rrd8}:6UsageThreshExceede:AVERAGE \
 AREA:6UsageThreshExceede#d3d7cf \
 LINE2:6UsageThreshExceede#babdb6:"UsageThresholdExceeded" \
 GPRINT:6UsageThreshExceede:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6UsageThreshExceede:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6UsageThreshExceede:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6UsageThresholdCnt={rrd9}:6UsageThresholdCnt:AVERAGE \
 AREA:6UsageThresholdCnt#555753 \
 LINE2:6UsageThresholdCnt#2e3436:"UsageThresholdCount" \
 GPRINT:6UsageThresholdCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6UsageThresholdCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6UsageThresholdCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6UsageThreshSupport={rrd10}:6UsageThreshSupport:AVERAGE \
 AREA:6UsageThreshSupport#edd400 \
 LINE2:6UsageThreshSupport#c4a000:"UsageThresholdSupported" \
 GPRINT:6UsageThreshSupport:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6UsageThreshSupport:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6UsageThreshSupport:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6CollecUsageThresho={rrd11}:6CollecUsageThresho:AVERAGE \
 AREA:6CollecUsageThresho#f57900 \
 LINE2:6CollecUsageThresho#ce5c00:"CollectionUsageThreshold" \
 GPRINT:6CollecUsageThresho:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6CollecUsageThresho:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6CollecUsageThresho:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6CollUsagThresExcee={rrd12}:6CollUsagThresExcee:AVERAGE \
 AREA:6CollUsagThresExcee#c17d11 \
 LINE2:6CollUsagThresExcee#8f5902:"CollectionUsageThresholdExceeded" \
 GPRINT:6CollUsagThresExcee:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6CollUsagThresExcee:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6CollUsagThresExcee:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6ColleUsageThresCnt={rrd13}:6ColleUsageThresCnt:AVERAGE \
 AREA:6ColleUsageThresCnt#73d216 \
 LINE2:6ColleUsageThresCnt#4e9a06:"CollectionUsageThresholdCount" \
 GPRINT:6ColleUsageThresCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6ColleUsageThresCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6ColleUsageThresCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6CollectionUsage={rrd14}:6CollectionUsage:AVERAGE \
 AREA:6CollectionUsage#3465a4 \
 LINE2:6CollectionUsage#204a87:"CollectionUsage" \
 GPRINT:6CollectionUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6CollectionUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6CollectionUsage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6CollUsagThresSuppo={rrd15}:6CollUsagThresSuppo:AVERAGE \
 AREA:6CollUsagThresSuppo#75507b \
 LINE2:6CollUsagThresSuppo#5c3566:"CollectionUsageThresholdSupported" \
 GPRINT:6CollUsagThresSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6CollUsagThresSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6CollUsagThresSuppo:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:13ObjectName={rrd16}:13ObjectName:AVERAGE \
 AREA:13ObjectName#cc0000 \
 LINE2:13ObjectName#a40000:"ObjectName" \
 GPRINT:13ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:13ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:13ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.10Valid.AttributeReport
###########################################
report.java.lang.MemoryPool.10Valid.AttributeReport.name=java.lang:name=G1 Survivor Space,type=MemoryPool[Valid]
report.java.lang.MemoryPool.10Valid.AttributeReport.columns=10Valid
report.java.lang.MemoryPool.10Valid.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.10Valid.AttributeReport.command=--title="java.lang:name=G1 Survivor Space,type=MemoryPool[Valid]" \
 --vertical-label="verticalLabel" \
 DEF:10Valid={rrd1}:10Valid:AVERAGE \
 AREA:10Valid#edd400 \
 LINE2:10Valid#c4a000:"Valid" \
 GPRINT:10Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:10Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:10Valid:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.11Name.AttributeReport
###########################################
report.java.lang.MemoryPool.11Name.AttributeReport.name=java.lang:name=G1 Survivor Space,type=MemoryPool[Name]
report.java.lang.MemoryPool.11Name.AttributeReport.columns=11Name
report.java.lang.MemoryPool.11Name.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.11Name.AttributeReport.command=--title="java.lang:name=G1 Survivor Space,type=MemoryPool[Name]" \
 --vertical-label="verticalLabel" \
 DEF:11Name={rrd1}:11Name:AVERAGE \
 AREA:11Name#edd400 \
 LINE2:11Name#c4a000:"Name" \
 GPRINT:11Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:11Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:11Name:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.6Type.AttributeReport
###########################################
report.java.lang.MemoryPool.6Type.AttributeReport.name=java.lang:name=G1 Survivor Space,type=MemoryPool[Type]
report.java.lang.MemoryPool.6Type.AttributeReport.columns=6Type
report.java.lang.MemoryPool.6Type.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.6Type.AttributeReport.command=--title="java.lang:name=G1 Survivor Space,type=MemoryPool[Type]" \
 --vertical-label="verticalLabel" \
 DEF:6Type={rrd1}:6Type:AVERAGE \
 AREA:6Type#edd400 \
 LINE2:6Type#c4a000:"Type" \
 GPRINT:6Type:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6Type:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6Type:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.6Usage.AttributeReport
###########################################
report.java.lang.MemoryPool.6Usage.AttributeReport.name=java.lang:name=G1 Survivor Space,type=MemoryPool[Usage]
report.java.lang.MemoryPool.6Usage.AttributeReport.columns=6Usage
report.java.lang.MemoryPool.6Usage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.6Usage.AttributeReport.command=--title="java.lang:name=G1 Survivor Space,type=MemoryPool[Usage]" \
 --vertical-label="verticalLabel" \
 DEF:6Usage={rrd1}:6Usage:AVERAGE \
 AREA:6Usage#edd400 \
 LINE2:6Usage#c4a000:"Usage" \
 GPRINT:6Usage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6Usage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6Usage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.6PeakUsage.AttributeReport
###########################################
report.java.lang.MemoryPool.6PeakUsage.AttributeReport.name=java.lang:name=G1 Survivor Space,type=MemoryPool[PeakUsage]
report.java.lang.MemoryPool.6PeakUsage.AttributeReport.columns=6PeakUsage
report.java.lang.MemoryPool.6PeakUsage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.6PeakUsage.AttributeReport.command=--title="java.lang:name=G1 Survivor Space,type=MemoryPool[PeakUsage]" \
 --vertical-label="verticalLabel" \
 DEF:6PeakUsage={rrd1}:6PeakUsage:AVERAGE \
 AREA:6PeakUsage#edd400 \
 LINE2:6PeakUsage#c4a000:"PeakUsage" \
 GPRINT:6PeakUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6PeakUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6PeakUsage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.6MemManagerNames.AttributeReport
###########################################
report.java.lang.MemoryPool.6MemManagerNames.AttributeReport.name=java.lang:name=G1 Survivor Space,type=MemoryPool[MemoryManagerNames]
report.java.lang.MemoryPool.6MemManagerNames.AttributeReport.columns=6MemManagerNames
report.java.lang.MemoryPool.6MemManagerNames.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.6MemManagerNames.AttributeReport.command=--title="java.lang:name=G1 Survivor Space,type=MemoryPool[MemoryManagerNames]" \
 --vertical-label="verticalLabel" \
 DEF:6MemManagerNames={rrd1}:6MemManagerNames:AVERAGE \
 AREA:6MemManagerNames#edd400 \
 LINE2:6MemManagerNames#c4a000:"MemoryManagerNames" \
 GPRINT:6MemManagerNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6MemManagerNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6MemManagerNames:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.6UsageThreshold.AttributeReport
###########################################
report.java.lang.MemoryPool.6UsageThreshold.AttributeReport.name=java.lang:name=G1 Survivor Space,type=MemoryPool[UsageThreshold]
report.java.lang.MemoryPool.6UsageThreshold.AttributeReport.columns=6UsageThreshold
report.java.lang.MemoryPool.6UsageThreshold.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.6UsageThreshold.AttributeReport.command=--title="java.lang:name=G1 Survivor Space,type=MemoryPool[UsageThreshold]" \
 --vertical-label="verticalLabel" \
 DEF:6UsageThreshold={rrd1}:6UsageThreshold:AVERAGE \
 AREA:6UsageThreshold#edd400 \
 LINE2:6UsageThreshold#c4a000:"UsageThreshold" \
 GPRINT:6UsageThreshold:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6UsageThreshold:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6UsageThreshold:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.6UsageThreshExceede.AttributeReport
###########################################
report.java.lang.MemoryPool.6UsageThreshExceede.AttributeReport.name=java.lang:name=G1 Survivor Space,type=MemoryPool[UsageThresholdExceeded]
report.java.lang.MemoryPool.6UsageThreshExceede.AttributeReport.columns=6UsageThreshExceede
report.java.lang.MemoryPool.6UsageThreshExceede.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.6UsageThreshExceede.AttributeReport.command=--title="java.lang:name=G1 Survivor Space,type=MemoryPool[UsageThresholdExceeded]" \
 --vertical-label="verticalLabel" \
 DEF:6UsageThreshExceede={rrd1}:6UsageThreshExceede:AVERAGE \
 AREA:6UsageThreshExceede#edd400 \
 LINE2:6UsageThreshExceede#c4a000:"UsageThresholdExceeded" \
 GPRINT:6UsageThreshExceede:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6UsageThreshExceede:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6UsageThreshExceede:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.6UsageThresholdCnt.AttributeReport
###########################################
report.java.lang.MemoryPool.6UsageThresholdCnt.AttributeReport.name=java.lang:name=G1 Survivor Space,type=MemoryPool[UsageThresholdCount]
report.java.lang.MemoryPool.6UsageThresholdCnt.AttributeReport.columns=6UsageThresholdCnt
report.java.lang.MemoryPool.6UsageThresholdCnt.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.6UsageThresholdCnt.AttributeReport.command=--title="java.lang:name=G1 Survivor Space,type=MemoryPool[UsageThresholdCount]" \
 --vertical-label="verticalLabel" \
 DEF:6UsageThresholdCnt={rrd1}:6UsageThresholdCnt:AVERAGE \
 AREA:6UsageThresholdCnt#edd400 \
 LINE2:6UsageThresholdCnt#c4a000:"UsageThresholdCount" \
 GPRINT:6UsageThresholdCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6UsageThresholdCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6UsageThresholdCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.6UsageThreshSupport.AttributeReport
###########################################
report.java.lang.MemoryPool.6UsageThreshSupport.AttributeReport.name=java.lang:name=G1 Survivor Space,type=MemoryPool[UsageThresholdSupported]
report.java.lang.MemoryPool.6UsageThreshSupport.AttributeReport.columns=6UsageThreshSupport
report.java.lang.MemoryPool.6UsageThreshSupport.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.6UsageThreshSupport.AttributeReport.command=--title="java.lang:name=G1 Survivor Space,type=MemoryPool[UsageThresholdSupported]" \
 --vertical-label="verticalLabel" \
 DEF:6UsageThreshSupport={rrd1}:6UsageThreshSupport:AVERAGE \
 AREA:6UsageThreshSupport#edd400 \
 LINE2:6UsageThreshSupport#c4a000:"UsageThresholdSupported" \
 GPRINT:6UsageThreshSupport:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6UsageThreshSupport:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6UsageThreshSupport:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.6CollecUsageThresho.AttributeReport
###########################################
report.java.lang.MemoryPool.6CollecUsageThresho.AttributeReport.name=java.lang:name=G1 Survivor Space,type=MemoryPool[CollectionUsageThreshold]
report.java.lang.MemoryPool.6CollecUsageThresho.AttributeReport.columns=6CollecUsageThresho
report.java.lang.MemoryPool.6CollecUsageThresho.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.6CollecUsageThresho.AttributeReport.command=--title="java.lang:name=G1 Survivor Space,type=MemoryPool[CollectionUsageThreshold]" \
 --vertical-label="verticalLabel" \
 DEF:6CollecUsageThresho={rrd1}:6CollecUsageThresho:AVERAGE \
 AREA:6CollecUsageThresho#edd400 \
 LINE2:6CollecUsageThresho#c4a000:"CollectionUsageThreshold" \
 GPRINT:6CollecUsageThresho:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6CollecUsageThresho:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6CollecUsageThresho:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.6CollUsagThresExcee.AttributeReport
###########################################
report.java.lang.MemoryPool.6CollUsagThresExcee.AttributeReport.name=java.lang:name=G1 Survivor Space,type=MemoryPool[CollectionUsageThresholdExceeded]
report.java.lang.MemoryPool.6CollUsagThresExcee.AttributeReport.columns=6CollUsagThresExcee
report.java.lang.MemoryPool.6CollUsagThresExcee.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.6CollUsagThresExcee.AttributeReport.command=--title="java.lang:name=G1 Survivor Space,type=MemoryPool[CollectionUsageThresholdExceeded]" \
 --vertical-label="verticalLabel" \
 DEF:6CollUsagThresExcee={rrd1}:6CollUsagThresExcee:AVERAGE \
 AREA:6CollUsagThresExcee#edd400 \
 LINE2:6CollUsagThresExcee#c4a000:"CollectionUsageThresholdExceeded" \
 GPRINT:6CollUsagThresExcee:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6CollUsagThresExcee:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6CollUsagThresExcee:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.6ColleUsageThresCnt.AttributeReport
###########################################
report.java.lang.MemoryPool.6ColleUsageThresCnt.AttributeReport.name=java.lang:name=G1 Survivor Space,type=MemoryPool[CollectionUsageThresholdCount]
report.java.lang.MemoryPool.6ColleUsageThresCnt.AttributeReport.columns=6ColleUsageThresCnt
report.java.lang.MemoryPool.6ColleUsageThresCnt.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.6ColleUsageThresCnt.AttributeReport.command=--title="java.lang:name=G1 Survivor Space,type=MemoryPool[CollectionUsageThresholdCount]" \
 --vertical-label="verticalLabel" \
 DEF:6ColleUsageThresCnt={rrd1}:6ColleUsageThresCnt:AVERAGE \
 AREA:6ColleUsageThresCnt#edd400 \
 LINE2:6ColleUsageThresCnt#c4a000:"CollectionUsageThresholdCount" \
 GPRINT:6ColleUsageThresCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6ColleUsageThresCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6ColleUsageThresCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.6CollectionUsage.AttributeReport
###########################################
report.java.lang.MemoryPool.6CollectionUsage.AttributeReport.name=java.lang:name=G1 Survivor Space,type=MemoryPool[CollectionUsage]
report.java.lang.MemoryPool.6CollectionUsage.AttributeReport.columns=6CollectionUsage
report.java.lang.MemoryPool.6CollectionUsage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.6CollectionUsage.AttributeReport.command=--title="java.lang:name=G1 Survivor Space,type=MemoryPool[CollectionUsage]" \
 --vertical-label="verticalLabel" \
 DEF:6CollectionUsage={rrd1}:6CollectionUsage:AVERAGE \
 AREA:6CollectionUsage#edd400 \
 LINE2:6CollectionUsage#c4a000:"CollectionUsage" \
 GPRINT:6CollectionUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6CollectionUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6CollectionUsage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.6CollUsagThresSuppo.AttributeReport
###########################################
report.java.lang.MemoryPool.6CollUsagThresSuppo.AttributeReport.name=java.lang:name=G1 Survivor Space,type=MemoryPool[CollectionUsageThresholdSupported]
report.java.lang.MemoryPool.6CollUsagThresSuppo.AttributeReport.columns=6CollUsagThresSuppo
report.java.lang.MemoryPool.6CollUsagThresSuppo.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.6CollUsagThresSuppo.AttributeReport.command=--title="java.lang:name=G1 Survivor Space,type=MemoryPool[CollectionUsageThresholdSupported]" \
 --vertical-label="verticalLabel" \
 DEF:6CollUsagThresSuppo={rrd1}:6CollUsagThresSuppo:AVERAGE \
 AREA:6CollUsagThresSuppo#edd400 \
 LINE2:6CollUsagThresSuppo#c4a000:"CollectionUsageThresholdSupported" \
 GPRINT:6CollUsagThresSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6CollUsagThresSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6CollUsagThresSuppo:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.13ObjectName.AttributeReport
###########################################
report.java.lang.MemoryPool.13ObjectName.AttributeReport.name=java.lang:name=G1 Survivor Space,type=MemoryPool[ObjectName]
report.java.lang.MemoryPool.13ObjectName.AttributeReport.columns=13ObjectName
report.java.lang.MemoryPool.13ObjectName.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.13ObjectName.AttributeReport.command=--title="java.lang:name=G1 Survivor Space,type=MemoryPool[ObjectName]" \
 --vertical-label="verticalLabel" \
 DEF:13ObjectName={rrd1}:13ObjectName:AVERAGE \
 AREA:13ObjectName#edd400 \
 LINE2:13ObjectName#c4a000:"ObjectName" \
 GPRINT:13ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:13ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:13ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.CompositeReport
###########################################
report.java.lang.MemoryPool.Usage.CompositeReport.name=java.lang.MemoryPool.Usage.CompositeReport
report.java.lang.MemoryPool.Usage.CompositeReport.columns=6UsageCommit, 6UsageInit, 6UsageMax, 6UsageUsed
report.java.lang.MemoryPool.Usage.CompositeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.CompositeReport.command=--title="java.lang.MemoryPool.Usage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:6UsageCommit={rrd1}:6UsageCommit:AVERAGE \
 AREA:6UsageCommit#edd400 \
 LINE2:6UsageCommit#c4a000:"committed" \
 GPRINT:6UsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6UsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6UsageCommit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6UsageInit={rrd2}:6UsageInit:AVERAGE \
 AREA:6UsageInit#f57900 \
 LINE2:6UsageInit#ce5c00:"init" \
 GPRINT:6UsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6UsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6UsageInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6UsageMax={rrd3}:6UsageMax:AVERAGE \
 AREA:6UsageMax#c17d11 \
 LINE2:6UsageMax#8f5902:"max" \
 GPRINT:6UsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6UsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6UsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6UsageUsed={rrd4}:6UsageUsed:AVERAGE \
 AREA:6UsageUsed#73d216 \
 LINE2:6UsageUsed#4e9a06:"used" \
 GPRINT:6UsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6UsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6UsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.CompositeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.CompositeReport.name=java.lang.MemoryPool.PeakUsage.CompositeReport
report.java.lang.MemoryPool.PeakUsage.CompositeReport.columns=6PeakUsageCommit, 6PeakUsageInit, 6PeakUsageMax, 6PeakUsageUsed
report.java.lang.MemoryPool.PeakUsage.CompositeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.CompositeReport.command=--title="java.lang.MemoryPool.PeakUsage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:6PeakUsageCommit={rrd1}:6PeakUsageCommit:AVERAGE \
 AREA:6PeakUsageCommit#edd400 \
 LINE2:6PeakUsageCommit#c4a000:"committed" \
 GPRINT:6PeakUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6PeakUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6PeakUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6PeakUsageInit={rrd2}:6PeakUsageInit:AVERAGE \
 AREA:6PeakUsageInit#f57900 \
 LINE2:6PeakUsageInit#ce5c00:"init" \
 GPRINT:6PeakUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6PeakUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6PeakUsageInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6PeakUsageMax={rrd3}:6PeakUsageMax:AVERAGE \
 AREA:6PeakUsageMax#c17d11 \
 LINE2:6PeakUsageMax#8f5902:"max" \
 GPRINT:6PeakUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6PeakUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6PeakUsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:6PeakUsageUsed={rrd4}:6PeakUsageUsed:AVERAGE \
 AREA:6PeakUsageUsed#73d216 \
 LINE2:6PeakUsageUsed#4e9a06:"used" \
 GPRINT:6PeakUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6PeakUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6PeakUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.CollectionUsage.CompositeReport
###########################################
report.java.lang.MemoryPool.CollectionUsage.CompositeReport.name=java.lang.MemoryPool.CollectionUsage.CompositeReport
report.java.lang.MemoryPool.CollectionUsage.CompositeReport.columns=2CollectUsageCommit, 2CollectioUsageInit, 2CollectionUsageMax, 2CollectioUsageUsed
report.java.lang.MemoryPool.CollectionUsage.CompositeReport.type=interfaceSnmp
report.java.lang.MemoryPool.CollectionUsage.CompositeReport.command=--title="java.lang.MemoryPool.CollectionUsage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:2CollectUsageCommit={rrd1}:2CollectUsageCommit:AVERAGE \
 AREA:2CollectUsageCommit#edd400 \
 LINE2:2CollectUsageCommit#c4a000:"committed" \
 GPRINT:2CollectUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2CollectUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2CollectUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2CollectioUsageInit={rrd2}:2CollectioUsageInit:AVERAGE \
 AREA:2CollectioUsageInit#f57900 \
 LINE2:2CollectioUsageInit#ce5c00:"init" \
 GPRINT:2CollectioUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2CollectioUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2CollectioUsageInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2CollectionUsageMax={rrd3}:2CollectionUsageMax:AVERAGE \
 AREA:2CollectionUsageMax#c17d11 \
 LINE2:2CollectionUsageMax#8f5902:"max" \
 GPRINT:2CollectionUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2CollectionUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2CollectionUsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:2CollectioUsageUsed={rrd4}:2CollectioUsageUsed:AVERAGE \
 AREA:2CollectioUsageUsed#73d216 \
 LINE2:2CollectioUsageUsed#4e9a06:"used" \
 GPRINT:2CollectioUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2CollectioUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2CollectioUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.committed.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.committed.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.columns=6UsageCommit
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:6UsageCommit={rrd1}:6UsageCommit:AVERAGE \
 AREA:6UsageCommit#edd400 \
 LINE2:6UsageCommit#c4a000:"committed" \
 GPRINT:6UsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6UsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6UsageCommit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.init.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.init.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.columns=6UsageInit
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:6UsageInit={rrd1}:6UsageInit:AVERAGE \
 AREA:6UsageInit#edd400 \
 LINE2:6UsageInit#c4a000:"init" \
 GPRINT:6UsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6UsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6UsageInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.max.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.max.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.columns=6UsageMax
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:6UsageMax={rrd1}:6UsageMax:AVERAGE \
 AREA:6UsageMax#edd400 \
 LINE2:6UsageMax#c4a000:"max" \
 GPRINT:6UsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6UsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6UsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.used.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.used.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.columns=6UsageUsed
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:6UsageUsed={rrd1}:6UsageUsed:AVERAGE \
 AREA:6UsageUsed#edd400 \
 LINE2:6UsageUsed#c4a000:"used" \
 GPRINT:6UsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6UsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6UsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.columns=6PeakUsageCommit
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:6PeakUsageCommit={rrd1}:6PeakUsageCommit:AVERAGE \
 AREA:6PeakUsageCommit#edd400 \
 LINE2:6PeakUsageCommit#c4a000:"committed" \
 GPRINT:6PeakUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6PeakUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6PeakUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.columns=6PeakUsageInit
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:6PeakUsageInit={rrd1}:6PeakUsageInit:AVERAGE \
 AREA:6PeakUsageInit#edd400 \
 LINE2:6PeakUsageInit#c4a000:"init" \
 GPRINT:6PeakUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6PeakUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6PeakUsageInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.columns=6PeakUsageMax
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:6PeakUsageMax={rrd1}:6PeakUsageMax:AVERAGE \
 AREA:6PeakUsageMax#edd400 \
 LINE2:6PeakUsageMax#c4a000:"max" \
 GPRINT:6PeakUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6PeakUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6PeakUsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.columns=6PeakUsageUsed
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:6PeakUsageUsed={rrd1}:6PeakUsageUsed:AVERAGE \
 AREA:6PeakUsageUsed#edd400 \
 LINE2:6PeakUsageUsed#c4a000:"used" \
 GPRINT:6PeakUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:6PeakUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:6PeakUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport.name=java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport
report.java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport.columns=2CollectUsageCommit
report.java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport.command=--title="java.lang.MemoryPool.CollectionUsage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:2CollectUsageCommit={rrd1}:2CollectUsageCommit:AVERAGE \
 AREA:2CollectUsageCommit#edd400 \
 LINE2:2CollectUsageCommit#c4a000:"committed" \
 GPRINT:2CollectUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2CollectUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2CollectUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport.name=java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport
report.java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport.columns=2CollectioUsageInit
report.java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport.command=--title="java.lang.MemoryPool.CollectionUsage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:2CollectioUsageInit={rrd1}:2CollectioUsageInit:AVERAGE \
 AREA:2CollectioUsageInit#edd400 \
 LINE2:2CollectioUsageInit#c4a000:"init" \
 GPRINT:2CollectioUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2CollectioUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2CollectioUsageInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport.name=java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport
report.java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport.columns=2CollectionUsageMax
report.java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport.command=--title="java.lang.MemoryPool.CollectionUsage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:2CollectionUsageMax={rrd1}:2CollectionUsageMax:AVERAGE \
 AREA:2CollectionUsageMax#edd400 \
 LINE2:2CollectionUsageMax#c4a000:"max" \
 GPRINT:2CollectionUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2CollectionUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2CollectionUsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport.name=java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport
report.java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport.columns=2CollectioUsageUsed
report.java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport.command=--title="java.lang.MemoryPool.CollectionUsage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:2CollectioUsageUsed={rrd1}:2CollectioUsageUsed:AVERAGE \
 AREA:2CollectioUsageUsed#edd400 \
 LINE2:2CollectioUsageUsed#c4a000:"used" \
 GPRINT:2CollectioUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:2CollectioUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:2CollectioUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.MBeanReport
###########################################
report.java.lang.MemoryPool.MBeanReport.name=java.lang.MemoryPool
report.java.lang.MemoryPool.MBeanReport.columns=11Valid, 12Name, 7Type, 7Usage, 7PeakUsage, 7MemManagerNames, 7UsageThreshold, 7UsageThreshExceede, 7UsageThresholdCnt, 7UsageThreshSupport, 7CollecUsageThresho, 7CollUsagThresExcee, 7ColleUsageThresCnt, 7CollectionUsage, 7CollUsagThresSuppo, 14ObjectName
report.java.lang.MemoryPool.MBeanReport.type=interfaceSnmp
report.java.lang.MemoryPool.MBeanReport.command=--title="java.lang.MemoryPool" \
 --vertical-label="verticalLabel" \
 DEF:11Valid={rrd1}:11Valid:AVERAGE \
 AREA:11Valid#edd400 \
 LINE2:11Valid#c4a000:"Valid" \
 GPRINT:11Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:11Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:11Valid:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:12Name={rrd2}:12Name:AVERAGE \
 AREA:12Name#f57900 \
 LINE2:12Name#ce5c00:"Name" \
 GPRINT:12Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:12Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:12Name:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7Type={rrd3}:7Type:AVERAGE \
 AREA:7Type#c17d11 \
 LINE2:7Type#8f5902:"Type" \
 GPRINT:7Type:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7Type:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7Type:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7Usage={rrd4}:7Usage:AVERAGE \
 AREA:7Usage#73d216 \
 LINE2:7Usage#4e9a06:"Usage" \
 GPRINT:7Usage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7Usage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7Usage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7PeakUsage={rrd5}:7PeakUsage:AVERAGE \
 AREA:7PeakUsage#3465a4 \
 LINE2:7PeakUsage#204a87:"PeakUsage" \
 GPRINT:7PeakUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7PeakUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7PeakUsage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7MemManagerNames={rrd6}:7MemManagerNames:AVERAGE \
 AREA:7MemManagerNames#75507b \
 LINE2:7MemManagerNames#5c3566:"MemoryManagerNames" \
 GPRINT:7MemManagerNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7MemManagerNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7MemManagerNames:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7UsageThreshold={rrd7}:7UsageThreshold:AVERAGE \
 AREA:7UsageThreshold#cc0000 \
 LINE2:7UsageThreshold#a40000:"UsageThreshold" \
 GPRINT:7UsageThreshold:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7UsageThreshold:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7UsageThreshold:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7UsageThreshExceede={rrd8}:7UsageThreshExceede:AVERAGE \
 AREA:7UsageThreshExceede#d3d7cf \
 LINE2:7UsageThreshExceede#babdb6:"UsageThresholdExceeded" \
 GPRINT:7UsageThreshExceede:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7UsageThreshExceede:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7UsageThreshExceede:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7UsageThresholdCnt={rrd9}:7UsageThresholdCnt:AVERAGE \
 AREA:7UsageThresholdCnt#555753 \
 LINE2:7UsageThresholdCnt#2e3436:"UsageThresholdCount" \
 GPRINT:7UsageThresholdCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7UsageThresholdCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7UsageThresholdCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7UsageThreshSupport={rrd10}:7UsageThreshSupport:AVERAGE \
 AREA:7UsageThreshSupport#edd400 \
 LINE2:7UsageThreshSupport#c4a000:"UsageThresholdSupported" \
 GPRINT:7UsageThreshSupport:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7UsageThreshSupport:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7UsageThreshSupport:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7CollecUsageThresho={rrd11}:7CollecUsageThresho:AVERAGE \
 AREA:7CollecUsageThresho#f57900 \
 LINE2:7CollecUsageThresho#ce5c00:"CollectionUsageThreshold" \
 GPRINT:7CollecUsageThresho:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7CollecUsageThresho:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7CollecUsageThresho:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7CollUsagThresExcee={rrd12}:7CollUsagThresExcee:AVERAGE \
 AREA:7CollUsagThresExcee#c17d11 \
 LINE2:7CollUsagThresExcee#8f5902:"CollectionUsageThresholdExceeded" \
 GPRINT:7CollUsagThresExcee:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7CollUsagThresExcee:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7CollUsagThresExcee:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7ColleUsageThresCnt={rrd13}:7ColleUsageThresCnt:AVERAGE \
 AREA:7ColleUsageThresCnt#73d216 \
 LINE2:7ColleUsageThresCnt#4e9a06:"CollectionUsageThresholdCount" \
 GPRINT:7ColleUsageThresCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7ColleUsageThresCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7ColleUsageThresCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7CollectionUsage={rrd14}:7CollectionUsage:AVERAGE \
 AREA:7CollectionUsage#3465a4 \
 LINE2:7CollectionUsage#204a87:"CollectionUsage" \
 GPRINT:7CollectionUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7CollectionUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7CollectionUsage:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7CollUsagThresSuppo={rrd15}:7CollUsagThresSuppo:AVERAGE \
 AREA:7CollUsagThresSuppo#75507b \
 LINE2:7CollUsagThresSuppo#5c3566:"CollectionUsageThresholdSupported" \
 GPRINT:7CollUsagThresSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7CollUsagThresSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7CollUsagThresSuppo:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:14ObjectName={rrd16}:14ObjectName:AVERAGE \
 AREA:14ObjectName#cc0000 \
 LINE2:14ObjectName#a40000:"ObjectName" \
 GPRINT:14ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:14ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:14ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.11Valid.AttributeReport
###########################################
report.java.lang.MemoryPool.11Valid.AttributeReport.name=java.lang:name=Metaspace,type=MemoryPool[Valid]
report.java.lang.MemoryPool.11Valid.AttributeReport.columns=11Valid
report.java.lang.MemoryPool.11Valid.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.11Valid.AttributeReport.command=--title="java.lang:name=Metaspace,type=MemoryPool[Valid]" \
 --vertical-label="verticalLabel" \
 DEF:11Valid={rrd1}:11Valid:AVERAGE \
 AREA:11Valid#edd400 \
 LINE2:11Valid#c4a000:"Valid" \
 GPRINT:11Valid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:11Valid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:11Valid:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.12Name.AttributeReport
###########################################
report.java.lang.MemoryPool.12Name.AttributeReport.name=java.lang:name=Metaspace,type=MemoryPool[Name]
report.java.lang.MemoryPool.12Name.AttributeReport.columns=12Name
report.java.lang.MemoryPool.12Name.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.12Name.AttributeReport.command=--title="java.lang:name=Metaspace,type=MemoryPool[Name]" \
 --vertical-label="verticalLabel" \
 DEF:12Name={rrd1}:12Name:AVERAGE \
 AREA:12Name#edd400 \
 LINE2:12Name#c4a000:"Name" \
 GPRINT:12Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:12Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:12Name:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.7Type.AttributeReport
###########################################
report.java.lang.MemoryPool.7Type.AttributeReport.name=java.lang:name=Metaspace,type=MemoryPool[Type]
report.java.lang.MemoryPool.7Type.AttributeReport.columns=7Type
report.java.lang.MemoryPool.7Type.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.7Type.AttributeReport.command=--title="java.lang:name=Metaspace,type=MemoryPool[Type]" \
 --vertical-label="verticalLabel" \
 DEF:7Type={rrd1}:7Type:AVERAGE \
 AREA:7Type#edd400 \
 LINE2:7Type#c4a000:"Type" \
 GPRINT:7Type:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7Type:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7Type:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.7Usage.AttributeReport
###########################################
report.java.lang.MemoryPool.7Usage.AttributeReport.name=java.lang:name=Metaspace,type=MemoryPool[Usage]
report.java.lang.MemoryPool.7Usage.AttributeReport.columns=7Usage
report.java.lang.MemoryPool.7Usage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.7Usage.AttributeReport.command=--title="java.lang:name=Metaspace,type=MemoryPool[Usage]" \
 --vertical-label="verticalLabel" \
 DEF:7Usage={rrd1}:7Usage:AVERAGE \
 AREA:7Usage#edd400 \
 LINE2:7Usage#c4a000:"Usage" \
 GPRINT:7Usage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7Usage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7Usage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.7PeakUsage.AttributeReport
###########################################
report.java.lang.MemoryPool.7PeakUsage.AttributeReport.name=java.lang:name=Metaspace,type=MemoryPool[PeakUsage]
report.java.lang.MemoryPool.7PeakUsage.AttributeReport.columns=7PeakUsage
report.java.lang.MemoryPool.7PeakUsage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.7PeakUsage.AttributeReport.command=--title="java.lang:name=Metaspace,type=MemoryPool[PeakUsage]" \
 --vertical-label="verticalLabel" \
 DEF:7PeakUsage={rrd1}:7PeakUsage:AVERAGE \
 AREA:7PeakUsage#edd400 \
 LINE2:7PeakUsage#c4a000:"PeakUsage" \
 GPRINT:7PeakUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7PeakUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7PeakUsage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.7MemManagerNames.AttributeReport
###########################################
report.java.lang.MemoryPool.7MemManagerNames.AttributeReport.name=java.lang:name=Metaspace,type=MemoryPool[MemoryManagerNames]
report.java.lang.MemoryPool.7MemManagerNames.AttributeReport.columns=7MemManagerNames
report.java.lang.MemoryPool.7MemManagerNames.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.7MemManagerNames.AttributeReport.command=--title="java.lang:name=Metaspace,type=MemoryPool[MemoryManagerNames]" \
 --vertical-label="verticalLabel" \
 DEF:7MemManagerNames={rrd1}:7MemManagerNames:AVERAGE \
 AREA:7MemManagerNames#edd400 \
 LINE2:7MemManagerNames#c4a000:"MemoryManagerNames" \
 GPRINT:7MemManagerNames:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7MemManagerNames:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7MemManagerNames:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.7UsageThreshold.AttributeReport
###########################################
report.java.lang.MemoryPool.7UsageThreshold.AttributeReport.name=java.lang:name=Metaspace,type=MemoryPool[UsageThreshold]
report.java.lang.MemoryPool.7UsageThreshold.AttributeReport.columns=7UsageThreshold
report.java.lang.MemoryPool.7UsageThreshold.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.7UsageThreshold.AttributeReport.command=--title="java.lang:name=Metaspace,type=MemoryPool[UsageThreshold]" \
 --vertical-label="verticalLabel" \
 DEF:7UsageThreshold={rrd1}:7UsageThreshold:AVERAGE \
 AREA:7UsageThreshold#edd400 \
 LINE2:7UsageThreshold#c4a000:"UsageThreshold" \
 GPRINT:7UsageThreshold:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7UsageThreshold:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7UsageThreshold:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.7UsageThreshExceede.AttributeReport
###########################################
report.java.lang.MemoryPool.7UsageThreshExceede.AttributeReport.name=java.lang:name=Metaspace,type=MemoryPool[UsageThresholdExceeded]
report.java.lang.MemoryPool.7UsageThreshExceede.AttributeReport.columns=7UsageThreshExceede
report.java.lang.MemoryPool.7UsageThreshExceede.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.7UsageThreshExceede.AttributeReport.command=--title="java.lang:name=Metaspace,type=MemoryPool[UsageThresholdExceeded]" \
 --vertical-label="verticalLabel" \
 DEF:7UsageThreshExceede={rrd1}:7UsageThreshExceede:AVERAGE \
 AREA:7UsageThreshExceede#edd400 \
 LINE2:7UsageThreshExceede#c4a000:"UsageThresholdExceeded" \
 GPRINT:7UsageThreshExceede:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7UsageThreshExceede:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7UsageThreshExceede:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.7UsageThresholdCnt.AttributeReport
###########################################
report.java.lang.MemoryPool.7UsageThresholdCnt.AttributeReport.name=java.lang:name=Metaspace,type=MemoryPool[UsageThresholdCount]
report.java.lang.MemoryPool.7UsageThresholdCnt.AttributeReport.columns=7UsageThresholdCnt
report.java.lang.MemoryPool.7UsageThresholdCnt.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.7UsageThresholdCnt.AttributeReport.command=--title="java.lang:name=Metaspace,type=MemoryPool[UsageThresholdCount]" \
 --vertical-label="verticalLabel" \
 DEF:7UsageThresholdCnt={rrd1}:7UsageThresholdCnt:AVERAGE \
 AREA:7UsageThresholdCnt#edd400 \
 LINE2:7UsageThresholdCnt#c4a000:"UsageThresholdCount" \
 GPRINT:7UsageThresholdCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7UsageThresholdCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7UsageThresholdCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.7UsageThreshSupport.AttributeReport
###########################################
report.java.lang.MemoryPool.7UsageThreshSupport.AttributeReport.name=java.lang:name=Metaspace,type=MemoryPool[UsageThresholdSupported]
report.java.lang.MemoryPool.7UsageThreshSupport.AttributeReport.columns=7UsageThreshSupport
report.java.lang.MemoryPool.7UsageThreshSupport.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.7UsageThreshSupport.AttributeReport.command=--title="java.lang:name=Metaspace,type=MemoryPool[UsageThresholdSupported]" \
 --vertical-label="verticalLabel" \
 DEF:7UsageThreshSupport={rrd1}:7UsageThreshSupport:AVERAGE \
 AREA:7UsageThreshSupport#edd400 \
 LINE2:7UsageThreshSupport#c4a000:"UsageThresholdSupported" \
 GPRINT:7UsageThreshSupport:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7UsageThreshSupport:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7UsageThreshSupport:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.7CollecUsageThresho.AttributeReport
###########################################
report.java.lang.MemoryPool.7CollecUsageThresho.AttributeReport.name=java.lang:name=Metaspace,type=MemoryPool[CollectionUsageThreshold]
report.java.lang.MemoryPool.7CollecUsageThresho.AttributeReport.columns=7CollecUsageThresho
report.java.lang.MemoryPool.7CollecUsageThresho.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.7CollecUsageThresho.AttributeReport.command=--title="java.lang:name=Metaspace,type=MemoryPool[CollectionUsageThreshold]" \
 --vertical-label="verticalLabel" \
 DEF:7CollecUsageThresho={rrd1}:7CollecUsageThresho:AVERAGE \
 AREA:7CollecUsageThresho#edd400 \
 LINE2:7CollecUsageThresho#c4a000:"CollectionUsageThreshold" \
 GPRINT:7CollecUsageThresho:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7CollecUsageThresho:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7CollecUsageThresho:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.7CollUsagThresExcee.AttributeReport
###########################################
report.java.lang.MemoryPool.7CollUsagThresExcee.AttributeReport.name=java.lang:name=Metaspace,type=MemoryPool[CollectionUsageThresholdExceeded]
report.java.lang.MemoryPool.7CollUsagThresExcee.AttributeReport.columns=7CollUsagThresExcee
report.java.lang.MemoryPool.7CollUsagThresExcee.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.7CollUsagThresExcee.AttributeReport.command=--title="java.lang:name=Metaspace,type=MemoryPool[CollectionUsageThresholdExceeded]" \
 --vertical-label="verticalLabel" \
 DEF:7CollUsagThresExcee={rrd1}:7CollUsagThresExcee:AVERAGE \
 AREA:7CollUsagThresExcee#edd400 \
 LINE2:7CollUsagThresExcee#c4a000:"CollectionUsageThresholdExceeded" \
 GPRINT:7CollUsagThresExcee:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7CollUsagThresExcee:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7CollUsagThresExcee:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.7ColleUsageThresCnt.AttributeReport
###########################################
report.java.lang.MemoryPool.7ColleUsageThresCnt.AttributeReport.name=java.lang:name=Metaspace,type=MemoryPool[CollectionUsageThresholdCount]
report.java.lang.MemoryPool.7ColleUsageThresCnt.AttributeReport.columns=7ColleUsageThresCnt
report.java.lang.MemoryPool.7ColleUsageThresCnt.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.7ColleUsageThresCnt.AttributeReport.command=--title="java.lang:name=Metaspace,type=MemoryPool[CollectionUsageThresholdCount]" \
 --vertical-label="verticalLabel" \
 DEF:7ColleUsageThresCnt={rrd1}:7ColleUsageThresCnt:AVERAGE \
 AREA:7ColleUsageThresCnt#edd400 \
 LINE2:7ColleUsageThresCnt#c4a000:"CollectionUsageThresholdCount" \
 GPRINT:7ColleUsageThresCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7ColleUsageThresCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7ColleUsageThresCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.7CollectionUsage.AttributeReport
###########################################
report.java.lang.MemoryPool.7CollectionUsage.AttributeReport.name=java.lang:name=Metaspace,type=MemoryPool[CollectionUsage]
report.java.lang.MemoryPool.7CollectionUsage.AttributeReport.columns=7CollectionUsage
report.java.lang.MemoryPool.7CollectionUsage.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.7CollectionUsage.AttributeReport.command=--title="java.lang:name=Metaspace,type=MemoryPool[CollectionUsage]" \
 --vertical-label="verticalLabel" \
 DEF:7CollectionUsage={rrd1}:7CollectionUsage:AVERAGE \
 AREA:7CollectionUsage#edd400 \
 LINE2:7CollectionUsage#c4a000:"CollectionUsage" \
 GPRINT:7CollectionUsage:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7CollectionUsage:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7CollectionUsage:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.7CollUsagThresSuppo.AttributeReport
###########################################
report.java.lang.MemoryPool.7CollUsagThresSuppo.AttributeReport.name=java.lang:name=Metaspace,type=MemoryPool[CollectionUsageThresholdSupported]
report.java.lang.MemoryPool.7CollUsagThresSuppo.AttributeReport.columns=7CollUsagThresSuppo
report.java.lang.MemoryPool.7CollUsagThresSuppo.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.7CollUsagThresSuppo.AttributeReport.command=--title="java.lang:name=Metaspace,type=MemoryPool[CollectionUsageThresholdSupported]" \
 --vertical-label="verticalLabel" \
 DEF:7CollUsagThresSuppo={rrd1}:7CollUsagThresSuppo:AVERAGE \
 AREA:7CollUsagThresSuppo#edd400 \
 LINE2:7CollUsagThresSuppo#c4a000:"CollectionUsageThresholdSupported" \
 GPRINT:7CollUsagThresSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7CollUsagThresSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7CollUsagThresSuppo:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.14ObjectName.AttributeReport
###########################################
report.java.lang.MemoryPool.14ObjectName.AttributeReport.name=java.lang:name=Metaspace,type=MemoryPool[ObjectName]
report.java.lang.MemoryPool.14ObjectName.AttributeReport.columns=14ObjectName
report.java.lang.MemoryPool.14ObjectName.AttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.14ObjectName.AttributeReport.command=--title="java.lang:name=Metaspace,type=MemoryPool[ObjectName]" \
 --vertical-label="verticalLabel" \
 DEF:14ObjectName={rrd1}:14ObjectName:AVERAGE \
 AREA:14ObjectName#edd400 \
 LINE2:14ObjectName#c4a000:"ObjectName" \
 GPRINT:14ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:14ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:14ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.CompositeReport
###########################################
report.java.lang.MemoryPool.Usage.CompositeReport.name=java.lang.MemoryPool.Usage.CompositeReport
report.java.lang.MemoryPool.Usage.CompositeReport.columns=7UsageCommit, 7UsageInit, 7UsageMax, 7UsageUsed
report.java.lang.MemoryPool.Usage.CompositeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.CompositeReport.command=--title="java.lang.MemoryPool.Usage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:7UsageCommit={rrd1}:7UsageCommit:AVERAGE \
 AREA:7UsageCommit#edd400 \
 LINE2:7UsageCommit#c4a000:"committed" \
 GPRINT:7UsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7UsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7UsageCommit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7UsageInit={rrd2}:7UsageInit:AVERAGE \
 AREA:7UsageInit#f57900 \
 LINE2:7UsageInit#ce5c00:"init" \
 GPRINT:7UsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7UsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7UsageInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7UsageMax={rrd3}:7UsageMax:AVERAGE \
 AREA:7UsageMax#c17d11 \
 LINE2:7UsageMax#8f5902:"max" \
 GPRINT:7UsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7UsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7UsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7UsageUsed={rrd4}:7UsageUsed:AVERAGE \
 AREA:7UsageUsed#73d216 \
 LINE2:7UsageUsed#4e9a06:"used" \
 GPRINT:7UsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7UsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7UsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.CompositeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.CompositeReport.name=java.lang.MemoryPool.PeakUsage.CompositeReport
report.java.lang.MemoryPool.PeakUsage.CompositeReport.columns=7PeakUsageCommit, 7PeakUsageInit, 7PeakUsageMax, 7PeakUsageUsed
report.java.lang.MemoryPool.PeakUsage.CompositeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.CompositeReport.command=--title="java.lang.MemoryPool.PeakUsage.CompositeReport" \
 --vertical-label="verticalLabel" \
 DEF:7PeakUsageCommit={rrd1}:7PeakUsageCommit:AVERAGE \
 AREA:7PeakUsageCommit#edd400 \
 LINE2:7PeakUsageCommit#c4a000:"committed" \
 GPRINT:7PeakUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7PeakUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7PeakUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7PeakUsageInit={rrd2}:7PeakUsageInit:AVERAGE \
 AREA:7PeakUsageInit#f57900 \
 LINE2:7PeakUsageInit#ce5c00:"init" \
 GPRINT:7PeakUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7PeakUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7PeakUsageInit:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7PeakUsageMax={rrd3}:7PeakUsageMax:AVERAGE \
 AREA:7PeakUsageMax#c17d11 \
 LINE2:7PeakUsageMax#8f5902:"max" \
 GPRINT:7PeakUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7PeakUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7PeakUsageMax:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:7PeakUsageUsed={rrd4}:7PeakUsageUsed:AVERAGE \
 AREA:7PeakUsageUsed#73d216 \
 LINE2:7PeakUsageUsed#4e9a06:"used" \
 GPRINT:7PeakUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7PeakUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7PeakUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.committed.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.committed.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.columns=7UsageCommit
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.committed.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:7UsageCommit={rrd1}:7UsageCommit:AVERAGE \
 AREA:7UsageCommit#edd400 \
 LINE2:7UsageCommit#c4a000:"committed" \
 GPRINT:7UsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7UsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7UsageCommit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.init.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.init.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.columns=7UsageInit
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.init.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:7UsageInit={rrd1}:7UsageInit:AVERAGE \
 AREA:7UsageInit#edd400 \
 LINE2:7UsageInit#c4a000:"init" \
 GPRINT:7UsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7UsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7UsageInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.max.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.max.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.columns=7UsageMax
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.max.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:7UsageMax={rrd1}:7UsageMax:AVERAGE \
 AREA:7UsageMax#edd400 \
 LINE2:7UsageMax#c4a000:"max" \
 GPRINT:7UsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7UsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7UsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.Usage.used.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.name=java.lang.MemoryPool.Usage.used.CompositeAttributeReport
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.columns=7UsageUsed
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.Usage.used.CompositeAttributeReport.command=--title="java.lang.MemoryPool.Usage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:7UsageUsed={rrd1}:7UsageUsed:AVERAGE \
 AREA:7UsageUsed#edd400 \
 LINE2:7UsageUsed#c4a000:"used" \
 GPRINT:7UsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7UsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7UsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.columns=7PeakUsageCommit
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.committed.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:7PeakUsageCommit={rrd1}:7PeakUsageCommit:AVERAGE \
 AREA:7PeakUsageCommit#edd400 \
 LINE2:7PeakUsageCommit#c4a000:"committed" \
 GPRINT:7PeakUsageCommit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7PeakUsageCommit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7PeakUsageCommit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.columns=7PeakUsageInit
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.init.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:7PeakUsageInit={rrd1}:7PeakUsageInit:AVERAGE \
 AREA:7PeakUsageInit#edd400 \
 LINE2:7PeakUsageInit#c4a000:"init" \
 GPRINT:7PeakUsageInit:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7PeakUsageInit:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7PeakUsageInit:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.columns=7PeakUsageMax
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.max.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:7PeakUsageMax={rrd1}:7PeakUsageMax:AVERAGE \
 AREA:7PeakUsageMax#edd400 \
 LINE2:7PeakUsageMax#c4a000:"max" \
 GPRINT:7PeakUsageMax:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7PeakUsageMax:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7PeakUsageMax:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport
###########################################
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.name=java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.columns=7PeakUsageUsed
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.type=interfaceSnmp
report.java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport.command=--title="java.lang.MemoryPool.PeakUsage.used.CompositeAttributeReport" \
 --vertical-label="verticalLabel" \
 DEF:7PeakUsageUsed={rrd1}:7PeakUsageUsed:AVERAGE \
 AREA:7PeakUsageUsed#edd400 \
 LINE2:7PeakUsageUsed#c4a000:"used" \
 GPRINT:7PeakUsageUsed:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:7PeakUsageUsed:MIN:" Min \\: %8.2lf %s" \
 GPRINT:7PeakUsageUsed:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.OperatingSystem.MBeanReport
###########################################
report.java.lang.OperatingSystem.MBeanReport.name=java.lang.OperatingSystem
report.java.lang.OperatingSystem.MBeanReport.columns=0OpenFileDescripCnt, 0MaxFileDescriptCnt, 0CommitVirtMemSize, 0TotalSwapSpaceSize, 0FreeSwapSpaceSize, 0ProcessCpuTime, 0FreePhysicaMemSize, 0TotalPhysicMemSize, 0SysCpuLoad, 0ProcessCpuLoad, 0Version, 13Name, 0AvailProcessors, 0Arch, 0SysLoadAvg, 15ObjectName
report.java.lang.OperatingSystem.MBeanReport.type=interfaceSnmp
report.java.lang.OperatingSystem.MBeanReport.command=--title="java.lang.OperatingSystem" \
 --vertical-label="verticalLabel" \
 DEF:0OpenFileDescripCnt={rrd1}:0OpenFileDescripCnt:AVERAGE \
 AREA:0OpenFileDescripCnt#edd400 \
 LINE2:0OpenFileDescripCnt#c4a000:"OpenFileDescriptorCount" \
 GPRINT:0OpenFileDescripCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0OpenFileDescripCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0OpenFileDescripCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0MaxFileDescriptCnt={rrd2}:0MaxFileDescriptCnt:AVERAGE \
 AREA:0MaxFileDescriptCnt#f57900 \
 LINE2:0MaxFileDescriptCnt#ce5c00:"MaxFileDescriptorCount" \
 GPRINT:0MaxFileDescriptCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0MaxFileDescriptCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0MaxFileDescriptCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0CommitVirtMemSize={rrd3}:0CommitVirtMemSize:AVERAGE \
 AREA:0CommitVirtMemSize#c17d11 \
 LINE2:0CommitVirtMemSize#8f5902:"CommittedVirtualMemorySize" \
 GPRINT:0CommitVirtMemSize:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CommitVirtMemSize:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CommitVirtMemSize:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0TotalSwapSpaceSize={rrd4}:0TotalSwapSpaceSize:AVERAGE \
 AREA:0TotalSwapSpaceSize#73d216 \
 LINE2:0TotalSwapSpaceSize#4e9a06:"TotalSwapSpaceSize" \
 GPRINT:0TotalSwapSpaceSize:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0TotalSwapSpaceSize:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0TotalSwapSpaceSize:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0FreeSwapSpaceSize={rrd5}:0FreeSwapSpaceSize:AVERAGE \
 AREA:0FreeSwapSpaceSize#3465a4 \
 LINE2:0FreeSwapSpaceSize#204a87:"FreeSwapSpaceSize" \
 GPRINT:0FreeSwapSpaceSize:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0FreeSwapSpaceSize:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0FreeSwapSpaceSize:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0ProcessCpuTime={rrd6}:0ProcessCpuTime:AVERAGE \
 AREA:0ProcessCpuTime#75507b \
 LINE2:0ProcessCpuTime#5c3566:"ProcessCpuTime" \
 GPRINT:0ProcessCpuTime:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ProcessCpuTime:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ProcessCpuTime:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0FreePhysicaMemSize={rrd7}:0FreePhysicaMemSize:AVERAGE \
 AREA:0FreePhysicaMemSize#cc0000 \
 LINE2:0FreePhysicaMemSize#a40000:"FreePhysicalMemorySize" \
 GPRINT:0FreePhysicaMemSize:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0FreePhysicaMemSize:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0FreePhysicaMemSize:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0TotalPhysicMemSize={rrd8}:0TotalPhysicMemSize:AVERAGE \
 AREA:0TotalPhysicMemSize#d3d7cf \
 LINE2:0TotalPhysicMemSize#babdb6:"TotalPhysicalMemorySize" \
 GPRINT:0TotalPhysicMemSize:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0TotalPhysicMemSize:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0TotalPhysicMemSize:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0SysCpuLoad={rrd9}:0SysCpuLoad:AVERAGE \
 AREA:0SysCpuLoad#555753 \
 LINE2:0SysCpuLoad#2e3436:"SystemCpuLoad" \
 GPRINT:0SysCpuLoad:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0SysCpuLoad:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0SysCpuLoad:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0ProcessCpuLoad={rrd10}:0ProcessCpuLoad:AVERAGE \
 AREA:0ProcessCpuLoad#edd400 \
 LINE2:0ProcessCpuLoad#c4a000:"ProcessCpuLoad" \
 GPRINT:0ProcessCpuLoad:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ProcessCpuLoad:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ProcessCpuLoad:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0Version={rrd11}:0Version:AVERAGE \
 AREA:0Version#f57900 \
 LINE2:0Version#ce5c00:"Version" \
 GPRINT:0Version:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0Version:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0Version:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:13Name={rrd12}:13Name:AVERAGE \
 AREA:13Name#c17d11 \
 LINE2:13Name#8f5902:"Name" \
 GPRINT:13Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:13Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:13Name:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0AvailProcessors={rrd13}:0AvailProcessors:AVERAGE \
 AREA:0AvailProcessors#73d216 \
 LINE2:0AvailProcessors#4e9a06:"AvailableProcessors" \
 GPRINT:0AvailProcessors:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0AvailProcessors:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0AvailProcessors:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0Arch={rrd14}:0Arch:AVERAGE \
 AREA:0Arch#3465a4 \
 LINE2:0Arch#204a87:"Arch" \
 GPRINT:0Arch:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0Arch:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0Arch:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0SysLoadAvg={rrd15}:0SysLoadAvg:AVERAGE \
 AREA:0SysLoadAvg#75507b \
 LINE2:0SysLoadAvg#5c3566:"SystemLoadAverage" \
 GPRINT:0SysLoadAvg:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0SysLoadAvg:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0SysLoadAvg:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:15ObjectName={rrd16}:15ObjectName:AVERAGE \
 AREA:15ObjectName#cc0000 \
 LINE2:15ObjectName#a40000:"ObjectName" \
 GPRINT:15ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:15ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:15ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.OperatingSystem.0OpenFileDescripCnt.AttributeReport
###########################################
report.java.lang.OperatingSystem.0OpenFileDescripCnt.AttributeReport.name=java.lang:type=OperatingSystem[OpenFileDescriptorCount]
report.java.lang.OperatingSystem.0OpenFileDescripCnt.AttributeReport.columns=0OpenFileDescripCnt
report.java.lang.OperatingSystem.0OpenFileDescripCnt.AttributeReport.type=interfaceSnmp
report.java.lang.OperatingSystem.0OpenFileDescripCnt.AttributeReport.command=--title="java.lang:type=OperatingSystem[OpenFileDescriptorCount]" \
 --vertical-label="verticalLabel" \
 DEF:0OpenFileDescripCnt={rrd1}:0OpenFileDescripCnt:AVERAGE \
 AREA:0OpenFileDescripCnt#edd400 \
 LINE2:0OpenFileDescripCnt#c4a000:"OpenFileDescriptorCount" \
 GPRINT:0OpenFileDescripCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0OpenFileDescripCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0OpenFileDescripCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.OperatingSystem.0MaxFileDescriptCnt.AttributeReport
###########################################
report.java.lang.OperatingSystem.0MaxFileDescriptCnt.AttributeReport.name=java.lang:type=OperatingSystem[MaxFileDescriptorCount]
report.java.lang.OperatingSystem.0MaxFileDescriptCnt.AttributeReport.columns=0MaxFileDescriptCnt
report.java.lang.OperatingSystem.0MaxFileDescriptCnt.AttributeReport.type=interfaceSnmp
report.java.lang.OperatingSystem.0MaxFileDescriptCnt.AttributeReport.command=--title="java.lang:type=OperatingSystem[MaxFileDescriptorCount]" \
 --vertical-label="verticalLabel" \
 DEF:0MaxFileDescriptCnt={rrd1}:0MaxFileDescriptCnt:AVERAGE \
 AREA:0MaxFileDescriptCnt#edd400 \
 LINE2:0MaxFileDescriptCnt#c4a000:"MaxFileDescriptorCount" \
 GPRINT:0MaxFileDescriptCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0MaxFileDescriptCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0MaxFileDescriptCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.OperatingSystem.0CommitVirtMemSize.AttributeReport
###########################################
report.java.lang.OperatingSystem.0CommitVirtMemSize.AttributeReport.name=java.lang:type=OperatingSystem[CommittedVirtualMemorySize]
report.java.lang.OperatingSystem.0CommitVirtMemSize.AttributeReport.columns=0CommitVirtMemSize
report.java.lang.OperatingSystem.0CommitVirtMemSize.AttributeReport.type=interfaceSnmp
report.java.lang.OperatingSystem.0CommitVirtMemSize.AttributeReport.command=--title="java.lang:type=OperatingSystem[CommittedVirtualMemorySize]" \
 --vertical-label="verticalLabel" \
 DEF:0CommitVirtMemSize={rrd1}:0CommitVirtMemSize:AVERAGE \
 AREA:0CommitVirtMemSize#edd400 \
 LINE2:0CommitVirtMemSize#c4a000:"CommittedVirtualMemorySize" \
 GPRINT:0CommitVirtMemSize:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CommitVirtMemSize:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CommitVirtMemSize:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.OperatingSystem.0TotalSwapSpaceSize.AttributeReport
###########################################
report.java.lang.OperatingSystem.0TotalSwapSpaceSize.AttributeReport.name=java.lang:type=OperatingSystem[TotalSwapSpaceSize]
report.java.lang.OperatingSystem.0TotalSwapSpaceSize.AttributeReport.columns=0TotalSwapSpaceSize
report.java.lang.OperatingSystem.0TotalSwapSpaceSize.AttributeReport.type=interfaceSnmp
report.java.lang.OperatingSystem.0TotalSwapSpaceSize.AttributeReport.command=--title="java.lang:type=OperatingSystem[TotalSwapSpaceSize]" \
 --vertical-label="verticalLabel" \
 DEF:0TotalSwapSpaceSize={rrd1}:0TotalSwapSpaceSize:AVERAGE \
 AREA:0TotalSwapSpaceSize#edd400 \
 LINE2:0TotalSwapSpaceSize#c4a000:"TotalSwapSpaceSize" \
 GPRINT:0TotalSwapSpaceSize:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0TotalSwapSpaceSize:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0TotalSwapSpaceSize:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.OperatingSystem.0FreeSwapSpaceSize.AttributeReport
###########################################
report.java.lang.OperatingSystem.0FreeSwapSpaceSize.AttributeReport.name=java.lang:type=OperatingSystem[FreeSwapSpaceSize]
report.java.lang.OperatingSystem.0FreeSwapSpaceSize.AttributeReport.columns=0FreeSwapSpaceSize
report.java.lang.OperatingSystem.0FreeSwapSpaceSize.AttributeReport.type=interfaceSnmp
report.java.lang.OperatingSystem.0FreeSwapSpaceSize.AttributeReport.command=--title="java.lang:type=OperatingSystem[FreeSwapSpaceSize]" \
 --vertical-label="verticalLabel" \
 DEF:0FreeSwapSpaceSize={rrd1}:0FreeSwapSpaceSize:AVERAGE \
 AREA:0FreeSwapSpaceSize#edd400 \
 LINE2:0FreeSwapSpaceSize#c4a000:"FreeSwapSpaceSize" \
 GPRINT:0FreeSwapSpaceSize:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0FreeSwapSpaceSize:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0FreeSwapSpaceSize:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.OperatingSystem.0ProcessCpuTime.AttributeReport
###########################################
report.java.lang.OperatingSystem.0ProcessCpuTime.AttributeReport.name=java.lang:type=OperatingSystem[ProcessCpuTime]
report.java.lang.OperatingSystem.0ProcessCpuTime.AttributeReport.columns=0ProcessCpuTime
report.java.lang.OperatingSystem.0ProcessCpuTime.AttributeReport.type=interfaceSnmp
report.java.lang.OperatingSystem.0ProcessCpuTime.AttributeReport.command=--title="java.lang:type=OperatingSystem[ProcessCpuTime]" \
 --vertical-label="verticalLabel" \
 DEF:0ProcessCpuTime={rrd1}:0ProcessCpuTime:AVERAGE \
 AREA:0ProcessCpuTime#edd400 \
 LINE2:0ProcessCpuTime#c4a000:"ProcessCpuTime" \
 GPRINT:0ProcessCpuTime:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ProcessCpuTime:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ProcessCpuTime:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.OperatingSystem.0FreePhysicaMemSize.AttributeReport
###########################################
report.java.lang.OperatingSystem.0FreePhysicaMemSize.AttributeReport.name=java.lang:type=OperatingSystem[FreePhysicalMemorySize]
report.java.lang.OperatingSystem.0FreePhysicaMemSize.AttributeReport.columns=0FreePhysicaMemSize
report.java.lang.OperatingSystem.0FreePhysicaMemSize.AttributeReport.type=interfaceSnmp
report.java.lang.OperatingSystem.0FreePhysicaMemSize.AttributeReport.command=--title="java.lang:type=OperatingSystem[FreePhysicalMemorySize]" \
 --vertical-label="verticalLabel" \
 DEF:0FreePhysicaMemSize={rrd1}:0FreePhysicaMemSize:AVERAGE \
 AREA:0FreePhysicaMemSize#edd400 \
 LINE2:0FreePhysicaMemSize#c4a000:"FreePhysicalMemorySize" \
 GPRINT:0FreePhysicaMemSize:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0FreePhysicaMemSize:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0FreePhysicaMemSize:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.OperatingSystem.0TotalPhysicMemSize.AttributeReport
###########################################
report.java.lang.OperatingSystem.0TotalPhysicMemSize.AttributeReport.name=java.lang:type=OperatingSystem[TotalPhysicalMemorySize]
report.java.lang.OperatingSystem.0TotalPhysicMemSize.AttributeReport.columns=0TotalPhysicMemSize
report.java.lang.OperatingSystem.0TotalPhysicMemSize.AttributeReport.type=interfaceSnmp
report.java.lang.OperatingSystem.0TotalPhysicMemSize.AttributeReport.command=--title="java.lang:type=OperatingSystem[TotalPhysicalMemorySize]" \
 --vertical-label="verticalLabel" \
 DEF:0TotalPhysicMemSize={rrd1}:0TotalPhysicMemSize:AVERAGE \
 AREA:0TotalPhysicMemSize#edd400 \
 LINE2:0TotalPhysicMemSize#c4a000:"TotalPhysicalMemorySize" \
 GPRINT:0TotalPhysicMemSize:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0TotalPhysicMemSize:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0TotalPhysicMemSize:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.OperatingSystem.0SysCpuLoad.AttributeReport
###########################################
report.java.lang.OperatingSystem.0SysCpuLoad.AttributeReport.name=java.lang:type=OperatingSystem[SystemCpuLoad]
report.java.lang.OperatingSystem.0SysCpuLoad.AttributeReport.columns=0SysCpuLoad
report.java.lang.OperatingSystem.0SysCpuLoad.AttributeReport.type=interfaceSnmp
report.java.lang.OperatingSystem.0SysCpuLoad.AttributeReport.command=--title="java.lang:type=OperatingSystem[SystemCpuLoad]" \
 --vertical-label="verticalLabel" \
 DEF:0SysCpuLoad={rrd1}:0SysCpuLoad:AVERAGE \
 AREA:0SysCpuLoad#edd400 \
 LINE2:0SysCpuLoad#c4a000:"SystemCpuLoad" \
 GPRINT:0SysCpuLoad:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0SysCpuLoad:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0SysCpuLoad:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.OperatingSystem.0ProcessCpuLoad.AttributeReport
###########################################
report.java.lang.OperatingSystem.0ProcessCpuLoad.AttributeReport.name=java.lang:type=OperatingSystem[ProcessCpuLoad]
report.java.lang.OperatingSystem.0ProcessCpuLoad.AttributeReport.columns=0ProcessCpuLoad
report.java.lang.OperatingSystem.0ProcessCpuLoad.AttributeReport.type=interfaceSnmp
report.java.lang.OperatingSystem.0ProcessCpuLoad.AttributeReport.command=--title="java.lang:type=OperatingSystem[ProcessCpuLoad]" \
 --vertical-label="verticalLabel" \
 DEF:0ProcessCpuLoad={rrd1}:0ProcessCpuLoad:AVERAGE \
 AREA:0ProcessCpuLoad#edd400 \
 LINE2:0ProcessCpuLoad#c4a000:"ProcessCpuLoad" \
 GPRINT:0ProcessCpuLoad:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ProcessCpuLoad:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ProcessCpuLoad:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.OperatingSystem.0Version.AttributeReport
###########################################
report.java.lang.OperatingSystem.0Version.AttributeReport.name=java.lang:type=OperatingSystem[Version]
report.java.lang.OperatingSystem.0Version.AttributeReport.columns=0Version
report.java.lang.OperatingSystem.0Version.AttributeReport.type=interfaceSnmp
report.java.lang.OperatingSystem.0Version.AttributeReport.command=--title="java.lang:type=OperatingSystem[Version]" \
 --vertical-label="verticalLabel" \
 DEF:0Version={rrd1}:0Version:AVERAGE \
 AREA:0Version#edd400 \
 LINE2:0Version#c4a000:"Version" \
 GPRINT:0Version:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0Version:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0Version:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.OperatingSystem.13Name.AttributeReport
###########################################
report.java.lang.OperatingSystem.13Name.AttributeReport.name=java.lang:type=OperatingSystem[Name]
report.java.lang.OperatingSystem.13Name.AttributeReport.columns=13Name
report.java.lang.OperatingSystem.13Name.AttributeReport.type=interfaceSnmp
report.java.lang.OperatingSystem.13Name.AttributeReport.command=--title="java.lang:type=OperatingSystem[Name]" \
 --vertical-label="verticalLabel" \
 DEF:13Name={rrd1}:13Name:AVERAGE \
 AREA:13Name#edd400 \
 LINE2:13Name#c4a000:"Name" \
 GPRINT:13Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:13Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:13Name:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.OperatingSystem.0AvailProcessors.AttributeReport
###########################################
report.java.lang.OperatingSystem.0AvailProcessors.AttributeReport.name=java.lang:type=OperatingSystem[AvailableProcessors]
report.java.lang.OperatingSystem.0AvailProcessors.AttributeReport.columns=0AvailProcessors
report.java.lang.OperatingSystem.0AvailProcessors.AttributeReport.type=interfaceSnmp
report.java.lang.OperatingSystem.0AvailProcessors.AttributeReport.command=--title="java.lang:type=OperatingSystem[AvailableProcessors]" \
 --vertical-label="verticalLabel" \
 DEF:0AvailProcessors={rrd1}:0AvailProcessors:AVERAGE \
 AREA:0AvailProcessors#edd400 \
 LINE2:0AvailProcessors#c4a000:"AvailableProcessors" \
 GPRINT:0AvailProcessors:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0AvailProcessors:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0AvailProcessors:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.OperatingSystem.0Arch.AttributeReport
###########################################
report.java.lang.OperatingSystem.0Arch.AttributeReport.name=java.lang:type=OperatingSystem[Arch]
report.java.lang.OperatingSystem.0Arch.AttributeReport.columns=0Arch
report.java.lang.OperatingSystem.0Arch.AttributeReport.type=interfaceSnmp
report.java.lang.OperatingSystem.0Arch.AttributeReport.command=--title="java.lang:type=OperatingSystem[Arch]" \
 --vertical-label="verticalLabel" \
 DEF:0Arch={rrd1}:0Arch:AVERAGE \
 AREA:0Arch#edd400 \
 LINE2:0Arch#c4a000:"Arch" \
 GPRINT:0Arch:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0Arch:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0Arch:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.OperatingSystem.0SysLoadAvg.AttributeReport
###########################################
report.java.lang.OperatingSystem.0SysLoadAvg.AttributeReport.name=java.lang:type=OperatingSystem[SystemLoadAverage]
report.java.lang.OperatingSystem.0SysLoadAvg.AttributeReport.columns=0SysLoadAvg
report.java.lang.OperatingSystem.0SysLoadAvg.AttributeReport.type=interfaceSnmp
report.java.lang.OperatingSystem.0SysLoadAvg.AttributeReport.command=--title="java.lang:type=OperatingSystem[SystemLoadAverage]" \
 --vertical-label="verticalLabel" \
 DEF:0SysLoadAvg={rrd1}:0SysLoadAvg:AVERAGE \
 AREA:0SysLoadAvg#edd400 \
 LINE2:0SysLoadAvg#c4a000:"SystemLoadAverage" \
 GPRINT:0SysLoadAvg:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0SysLoadAvg:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0SysLoadAvg:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.OperatingSystem.15ObjectName.AttributeReport
###########################################
report.java.lang.OperatingSystem.15ObjectName.AttributeReport.name=java.lang:type=OperatingSystem[ObjectName]
report.java.lang.OperatingSystem.15ObjectName.AttributeReport.columns=15ObjectName
report.java.lang.OperatingSystem.15ObjectName.AttributeReport.type=interfaceSnmp
report.java.lang.OperatingSystem.15ObjectName.AttributeReport.command=--title="java.lang:type=OperatingSystem[ObjectName]" \
 --vertical-label="verticalLabel" \
 DEF:15ObjectName={rrd1}:15ObjectName:AVERAGE \
 AREA:15ObjectName#edd400 \
 LINE2:15ObjectName#c4a000:"ObjectName" \
 GPRINT:15ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:15ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:15ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Runtime.MBeanReport
###########################################
report.java.lang.Runtime.MBeanReport.name=java.lang.Runtime
report.java.lang.Runtime.MBeanReport.columns=0ClassPath, 14Name, 0BootClassPathSuppo, 0VmName, 0VmVendor, 0VmVersion, 0LibraryPath, 0BootClassPath, 0Uptime, 0ManagemSpecVersion, 0SpecName, 0SpecVendor, 0SpecVersion, 0InputArguments, 0StartTime, 0SysProperties, 0Pid, 16ObjectName
report.java.lang.Runtime.MBeanReport.type=interfaceSnmp
report.java.lang.Runtime.MBeanReport.command=--title="java.lang.Runtime" \
 --vertical-label="verticalLabel" \
 DEF:0ClassPath={rrd1}:0ClassPath:AVERAGE \
 AREA:0ClassPath#edd400 \
 LINE2:0ClassPath#c4a000:"ClassPath" \
 GPRINT:0ClassPath:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ClassPath:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ClassPath:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:14Name={rrd2}:14Name:AVERAGE \
 AREA:14Name#f57900 \
 LINE2:14Name#ce5c00:"Name" \
 GPRINT:14Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:14Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:14Name:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0BootClassPathSuppo={rrd3}:0BootClassPathSuppo:AVERAGE \
 AREA:0BootClassPathSuppo#c17d11 \
 LINE2:0BootClassPathSuppo#8f5902:"BootClassPathSupported" \
 GPRINT:0BootClassPathSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0BootClassPathSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0BootClassPathSuppo:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0VmName={rrd4}:0VmName:AVERAGE \
 AREA:0VmName#73d216 \
 LINE2:0VmName#4e9a06:"VmName" \
 GPRINT:0VmName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0VmName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0VmName:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0VmVendor={rrd5}:0VmVendor:AVERAGE \
 AREA:0VmVendor#3465a4 \
 LINE2:0VmVendor#204a87:"VmVendor" \
 GPRINT:0VmVendor:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0VmVendor:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0VmVendor:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0VmVersion={rrd6}:0VmVersion:AVERAGE \
 AREA:0VmVersion#75507b \
 LINE2:0VmVersion#5c3566:"VmVersion" \
 GPRINT:0VmVersion:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0VmVersion:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0VmVersion:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0LibraryPath={rrd7}:0LibraryPath:AVERAGE \
 AREA:0LibraryPath#cc0000 \
 LINE2:0LibraryPath#a40000:"LibraryPath" \
 GPRINT:0LibraryPath:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0LibraryPath:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0LibraryPath:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0BootClassPath={rrd8}:0BootClassPath:AVERAGE \
 AREA:0BootClassPath#d3d7cf \
 LINE2:0BootClassPath#babdb6:"BootClassPath" \
 GPRINT:0BootClassPath:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0BootClassPath:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0BootClassPath:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0Uptime={rrd9}:0Uptime:AVERAGE \
 AREA:0Uptime#555753 \
 LINE2:0Uptime#2e3436:"Uptime" \
 GPRINT:0Uptime:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0Uptime:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0Uptime:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0ManagemSpecVersion={rrd10}:0ManagemSpecVersion:AVERAGE \
 AREA:0ManagemSpecVersion#edd400 \
 LINE2:0ManagemSpecVersion#c4a000:"ManagementSpecVersion" \
 GPRINT:0ManagemSpecVersion:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ManagemSpecVersion:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ManagemSpecVersion:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0SpecName={rrd11}:0SpecName:AVERAGE \
 AREA:0SpecName#f57900 \
 LINE2:0SpecName#ce5c00:"SpecName" \
 GPRINT:0SpecName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0SpecName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0SpecName:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0SpecVendor={rrd12}:0SpecVendor:AVERAGE \
 AREA:0SpecVendor#c17d11 \
 LINE2:0SpecVendor#8f5902:"SpecVendor" \
 GPRINT:0SpecVendor:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0SpecVendor:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0SpecVendor:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0SpecVersion={rrd13}:0SpecVersion:AVERAGE \
 AREA:0SpecVersion#73d216 \
 LINE2:0SpecVersion#4e9a06:"SpecVersion" \
 GPRINT:0SpecVersion:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0SpecVersion:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0SpecVersion:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0InputArguments={rrd14}:0InputArguments:AVERAGE \
 AREA:0InputArguments#3465a4 \
 LINE2:0InputArguments#204a87:"InputArguments" \
 GPRINT:0InputArguments:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0InputArguments:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0InputArguments:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0StartTime={rrd15}:0StartTime:AVERAGE \
 AREA:0StartTime#75507b \
 LINE2:0StartTime#5c3566:"StartTime" \
 GPRINT:0StartTime:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0StartTime:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0StartTime:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0SysProperties={rrd16}:0SysProperties:AVERAGE \
 AREA:0SysProperties#cc0000 \
 LINE2:0SysProperties#a40000:"SystemProperties" \
 GPRINT:0SysProperties:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0SysProperties:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0SysProperties:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0Pid={rrd17}:0Pid:AVERAGE \
 AREA:0Pid#d3d7cf \
 LINE2:0Pid#babdb6:"Pid" \
 GPRINT:0Pid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0Pid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0Pid:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:16ObjectName={rrd18}:16ObjectName:AVERAGE \
 AREA:16ObjectName#555753 \
 LINE2:16ObjectName#2e3436:"ObjectName" \
 GPRINT:16ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:16ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:16ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Runtime.0ClassPath.AttributeReport
###########################################
report.java.lang.Runtime.0ClassPath.AttributeReport.name=java.lang:type=Runtime[ClassPath]
report.java.lang.Runtime.0ClassPath.AttributeReport.columns=0ClassPath
report.java.lang.Runtime.0ClassPath.AttributeReport.type=interfaceSnmp
report.java.lang.Runtime.0ClassPath.AttributeReport.command=--title="java.lang:type=Runtime[ClassPath]" \
 --vertical-label="verticalLabel" \
 DEF:0ClassPath={rrd1}:0ClassPath:AVERAGE \
 AREA:0ClassPath#edd400 \
 LINE2:0ClassPath#c4a000:"ClassPath" \
 GPRINT:0ClassPath:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ClassPath:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ClassPath:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Runtime.14Name.AttributeReport
###########################################
report.java.lang.Runtime.14Name.AttributeReport.name=java.lang:type=Runtime[Name]
report.java.lang.Runtime.14Name.AttributeReport.columns=14Name
report.java.lang.Runtime.14Name.AttributeReport.type=interfaceSnmp
report.java.lang.Runtime.14Name.AttributeReport.command=--title="java.lang:type=Runtime[Name]" \
 --vertical-label="verticalLabel" \
 DEF:14Name={rrd1}:14Name:AVERAGE \
 AREA:14Name#edd400 \
 LINE2:14Name#c4a000:"Name" \
 GPRINT:14Name:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:14Name:MIN:" Min \\: %8.2lf %s" \
 GPRINT:14Name:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Runtime.0BootClassPathSuppo.AttributeReport
###########################################
report.java.lang.Runtime.0BootClassPathSuppo.AttributeReport.name=java.lang:type=Runtime[BootClassPathSupported]
report.java.lang.Runtime.0BootClassPathSuppo.AttributeReport.columns=0BootClassPathSuppo
report.java.lang.Runtime.0BootClassPathSuppo.AttributeReport.type=interfaceSnmp
report.java.lang.Runtime.0BootClassPathSuppo.AttributeReport.command=--title="java.lang:type=Runtime[BootClassPathSupported]" \
 --vertical-label="verticalLabel" \
 DEF:0BootClassPathSuppo={rrd1}:0BootClassPathSuppo:AVERAGE \
 AREA:0BootClassPathSuppo#edd400 \
 LINE2:0BootClassPathSuppo#c4a000:"BootClassPathSupported" \
 GPRINT:0BootClassPathSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0BootClassPathSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0BootClassPathSuppo:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Runtime.0VmName.AttributeReport
###########################################
report.java.lang.Runtime.0VmName.AttributeReport.name=java.lang:type=Runtime[VmName]
report.java.lang.Runtime.0VmName.AttributeReport.columns=0VmName
report.java.lang.Runtime.0VmName.AttributeReport.type=interfaceSnmp
report.java.lang.Runtime.0VmName.AttributeReport.command=--title="java.lang:type=Runtime[VmName]" \
 --vertical-label="verticalLabel" \
 DEF:0VmName={rrd1}:0VmName:AVERAGE \
 AREA:0VmName#edd400 \
 LINE2:0VmName#c4a000:"VmName" \
 GPRINT:0VmName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0VmName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0VmName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Runtime.0VmVendor.AttributeReport
###########################################
report.java.lang.Runtime.0VmVendor.AttributeReport.name=java.lang:type=Runtime[VmVendor]
report.java.lang.Runtime.0VmVendor.AttributeReport.columns=0VmVendor
report.java.lang.Runtime.0VmVendor.AttributeReport.type=interfaceSnmp
report.java.lang.Runtime.0VmVendor.AttributeReport.command=--title="java.lang:type=Runtime[VmVendor]" \
 --vertical-label="verticalLabel" \
 DEF:0VmVendor={rrd1}:0VmVendor:AVERAGE \
 AREA:0VmVendor#edd400 \
 LINE2:0VmVendor#c4a000:"VmVendor" \
 GPRINT:0VmVendor:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0VmVendor:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0VmVendor:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Runtime.0VmVersion.AttributeReport
###########################################
report.java.lang.Runtime.0VmVersion.AttributeReport.name=java.lang:type=Runtime[VmVersion]
report.java.lang.Runtime.0VmVersion.AttributeReport.columns=0VmVersion
report.java.lang.Runtime.0VmVersion.AttributeReport.type=interfaceSnmp
report.java.lang.Runtime.0VmVersion.AttributeReport.command=--title="java.lang:type=Runtime[VmVersion]" \
 --vertical-label="verticalLabel" \
 DEF:0VmVersion={rrd1}:0VmVersion:AVERAGE \
 AREA:0VmVersion#edd400 \
 LINE2:0VmVersion#c4a000:"VmVersion" \
 GPRINT:0VmVersion:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0VmVersion:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0VmVersion:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Runtime.0LibraryPath.AttributeReport
###########################################
report.java.lang.Runtime.0LibraryPath.AttributeReport.name=java.lang:type=Runtime[LibraryPath]
report.java.lang.Runtime.0LibraryPath.AttributeReport.columns=0LibraryPath
report.java.lang.Runtime.0LibraryPath.AttributeReport.type=interfaceSnmp
report.java.lang.Runtime.0LibraryPath.AttributeReport.command=--title="java.lang:type=Runtime[LibraryPath]" \
 --vertical-label="verticalLabel" \
 DEF:0LibraryPath={rrd1}:0LibraryPath:AVERAGE \
 AREA:0LibraryPath#edd400 \
 LINE2:0LibraryPath#c4a000:"LibraryPath" \
 GPRINT:0LibraryPath:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0LibraryPath:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0LibraryPath:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Runtime.0BootClassPath.AttributeReport
###########################################
report.java.lang.Runtime.0BootClassPath.AttributeReport.name=java.lang:type=Runtime[BootClassPath]
report.java.lang.Runtime.0BootClassPath.AttributeReport.columns=0BootClassPath
report.java.lang.Runtime.0BootClassPath.AttributeReport.type=interfaceSnmp
report.java.lang.Runtime.0BootClassPath.AttributeReport.command=--title="java.lang:type=Runtime[BootClassPath]" \
 --vertical-label="verticalLabel" \
 DEF:0BootClassPath={rrd1}:0BootClassPath:AVERAGE \
 AREA:0BootClassPath#edd400 \
 LINE2:0BootClassPath#c4a000:"BootClassPath" \
 GPRINT:0BootClassPath:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0BootClassPath:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0BootClassPath:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Runtime.0Uptime.AttributeReport
###########################################
report.java.lang.Runtime.0Uptime.AttributeReport.name=java.lang:type=Runtime[Uptime]
report.java.lang.Runtime.0Uptime.AttributeReport.columns=0Uptime
report.java.lang.Runtime.0Uptime.AttributeReport.type=interfaceSnmp
report.java.lang.Runtime.0Uptime.AttributeReport.command=--title="java.lang:type=Runtime[Uptime]" \
 --vertical-label="verticalLabel" \
 DEF:0Uptime={rrd1}:0Uptime:AVERAGE \
 AREA:0Uptime#edd400 \
 LINE2:0Uptime#c4a000:"Uptime" \
 GPRINT:0Uptime:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0Uptime:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0Uptime:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Runtime.0ManagemSpecVersion.AttributeReport
###########################################
report.java.lang.Runtime.0ManagemSpecVersion.AttributeReport.name=java.lang:type=Runtime[ManagementSpecVersion]
report.java.lang.Runtime.0ManagemSpecVersion.AttributeReport.columns=0ManagemSpecVersion
report.java.lang.Runtime.0ManagemSpecVersion.AttributeReport.type=interfaceSnmp
report.java.lang.Runtime.0ManagemSpecVersion.AttributeReport.command=--title="java.lang:type=Runtime[ManagementSpecVersion]" \
 --vertical-label="verticalLabel" \
 DEF:0ManagemSpecVersion={rrd1}:0ManagemSpecVersion:AVERAGE \
 AREA:0ManagemSpecVersion#edd400 \
 LINE2:0ManagemSpecVersion#c4a000:"ManagementSpecVersion" \
 GPRINT:0ManagemSpecVersion:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ManagemSpecVersion:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ManagemSpecVersion:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Runtime.0SpecName.AttributeReport
###########################################
report.java.lang.Runtime.0SpecName.AttributeReport.name=java.lang:type=Runtime[SpecName]
report.java.lang.Runtime.0SpecName.AttributeReport.columns=0SpecName
report.java.lang.Runtime.0SpecName.AttributeReport.type=interfaceSnmp
report.java.lang.Runtime.0SpecName.AttributeReport.command=--title="java.lang:type=Runtime[SpecName]" \
 --vertical-label="verticalLabel" \
 DEF:0SpecName={rrd1}:0SpecName:AVERAGE \
 AREA:0SpecName#edd400 \
 LINE2:0SpecName#c4a000:"SpecName" \
 GPRINT:0SpecName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0SpecName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0SpecName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Runtime.0SpecVendor.AttributeReport
###########################################
report.java.lang.Runtime.0SpecVendor.AttributeReport.name=java.lang:type=Runtime[SpecVendor]
report.java.lang.Runtime.0SpecVendor.AttributeReport.columns=0SpecVendor
report.java.lang.Runtime.0SpecVendor.AttributeReport.type=interfaceSnmp
report.java.lang.Runtime.0SpecVendor.AttributeReport.command=--title="java.lang:type=Runtime[SpecVendor]" \
 --vertical-label="verticalLabel" \
 DEF:0SpecVendor={rrd1}:0SpecVendor:AVERAGE \
 AREA:0SpecVendor#edd400 \
 LINE2:0SpecVendor#c4a000:"SpecVendor" \
 GPRINT:0SpecVendor:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0SpecVendor:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0SpecVendor:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Runtime.0SpecVersion.AttributeReport
###########################################
report.java.lang.Runtime.0SpecVersion.AttributeReport.name=java.lang:type=Runtime[SpecVersion]
report.java.lang.Runtime.0SpecVersion.AttributeReport.columns=0SpecVersion
report.java.lang.Runtime.0SpecVersion.AttributeReport.type=interfaceSnmp
report.java.lang.Runtime.0SpecVersion.AttributeReport.command=--title="java.lang:type=Runtime[SpecVersion]" \
 --vertical-label="verticalLabel" \
 DEF:0SpecVersion={rrd1}:0SpecVersion:AVERAGE \
 AREA:0SpecVersion#edd400 \
 LINE2:0SpecVersion#c4a000:"SpecVersion" \
 GPRINT:0SpecVersion:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0SpecVersion:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0SpecVersion:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Runtime.0InputArguments.AttributeReport
###########################################
report.java.lang.Runtime.0InputArguments.AttributeReport.name=java.lang:type=Runtime[InputArguments]
report.java.lang.Runtime.0InputArguments.AttributeReport.columns=0InputArguments
report.java.lang.Runtime.0InputArguments.AttributeReport.type=interfaceSnmp
report.java.lang.Runtime.0InputArguments.AttributeReport.command=--title="java.lang:type=Runtime[InputArguments]" \
 --vertical-label="verticalLabel" \
 DEF:0InputArguments={rrd1}:0InputArguments:AVERAGE \
 AREA:0InputArguments#edd400 \
 LINE2:0InputArguments#c4a000:"InputArguments" \
 GPRINT:0InputArguments:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0InputArguments:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0InputArguments:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Runtime.0StartTime.AttributeReport
###########################################
report.java.lang.Runtime.0StartTime.AttributeReport.name=java.lang:type=Runtime[StartTime]
report.java.lang.Runtime.0StartTime.AttributeReport.columns=0StartTime
report.java.lang.Runtime.0StartTime.AttributeReport.type=interfaceSnmp
report.java.lang.Runtime.0StartTime.AttributeReport.command=--title="java.lang:type=Runtime[StartTime]" \
 --vertical-label="verticalLabel" \
 DEF:0StartTime={rrd1}:0StartTime:AVERAGE \
 AREA:0StartTime#edd400 \
 LINE2:0StartTime#c4a000:"StartTime" \
 GPRINT:0StartTime:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0StartTime:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0StartTime:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Runtime.0SysProperties.AttributeReport
###########################################
report.java.lang.Runtime.0SysProperties.AttributeReport.name=java.lang:type=Runtime[SystemProperties]
report.java.lang.Runtime.0SysProperties.AttributeReport.columns=0SysProperties
report.java.lang.Runtime.0SysProperties.AttributeReport.type=interfaceSnmp
report.java.lang.Runtime.0SysProperties.AttributeReport.command=--title="java.lang:type=Runtime[SystemProperties]" \
 --vertical-label="verticalLabel" \
 DEF:0SysProperties={rrd1}:0SysProperties:AVERAGE \
 AREA:0SysProperties#edd400 \
 LINE2:0SysProperties#c4a000:"SystemProperties" \
 GPRINT:0SysProperties:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0SysProperties:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0SysProperties:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Runtime.0Pid.AttributeReport
###########################################
report.java.lang.Runtime.0Pid.AttributeReport.name=java.lang:type=Runtime[Pid]
report.java.lang.Runtime.0Pid.AttributeReport.columns=0Pid
report.java.lang.Runtime.0Pid.AttributeReport.type=interfaceSnmp
report.java.lang.Runtime.0Pid.AttributeReport.command=--title="java.lang:type=Runtime[Pid]" \
 --vertical-label="verticalLabel" \
 DEF:0Pid={rrd1}:0Pid:AVERAGE \
 AREA:0Pid#edd400 \
 LINE2:0Pid#c4a000:"Pid" \
 GPRINT:0Pid:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0Pid:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0Pid:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Runtime.16ObjectName.AttributeReport
###########################################
report.java.lang.Runtime.16ObjectName.AttributeReport.name=java.lang:type=Runtime[ObjectName]
report.java.lang.Runtime.16ObjectName.AttributeReport.columns=16ObjectName
report.java.lang.Runtime.16ObjectName.AttributeReport.type=interfaceSnmp
report.java.lang.Runtime.16ObjectName.AttributeReport.command=--title="java.lang:type=Runtime[ObjectName]" \
 --vertical-label="verticalLabel" \
 DEF:16ObjectName={rrd1}:16ObjectName:AVERAGE \
 AREA:16ObjectName#edd400 \
 LINE2:16ObjectName#c4a000:"ObjectName" \
 GPRINT:16ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:16ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:16ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Threading.MBeanReport
###########################################
report.java.lang.Threading.MBeanReport.name=java.lang.Threading
report.java.lang.Threading.MBeanReport.columns=0ThreaAllocMemSuppo, 0ThreaAllocMemEnabl, 0CurrThreAllocBytes, 0ThreContMonitEnabl, 0ThreContMonitSuppo, 0CurThreCpuTimeSupp, 0ObjeMoniUsageSuppo, 0SynchrUsageSupport, 0ThreaCpuTimeEnable, 0PeakThreadCnt, 0DaemonThreadCnt, 0ThreadCnt, 0TotalStartThreaCnt, 0AllThreadIds, 0CurreThreadCpuTime, 0CurreThreadUsrTime, 0ThreaCpuTimeSuppor, 17ObjectName
report.java.lang.Threading.MBeanReport.type=interfaceSnmp
report.java.lang.Threading.MBeanReport.command=--title="java.lang.Threading" \
 --vertical-label="verticalLabel" \
 DEF:0ThreaAllocMemSuppo={rrd1}:0ThreaAllocMemSuppo:AVERAGE \
 AREA:0ThreaAllocMemSuppo#edd400 \
 LINE2:0ThreaAllocMemSuppo#c4a000:"ThreadAllocatedMemorySupported" \
 GPRINT:0ThreaAllocMemSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ThreaAllocMemSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ThreaAllocMemSuppo:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0ThreaAllocMemEnabl={rrd2}:0ThreaAllocMemEnabl:AVERAGE \
 AREA:0ThreaAllocMemEnabl#f57900 \
 LINE2:0ThreaAllocMemEnabl#ce5c00:"ThreadAllocatedMemoryEnabled" \
 GPRINT:0ThreaAllocMemEnabl:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ThreaAllocMemEnabl:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ThreaAllocMemEnabl:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0CurrThreAllocBytes={rrd3}:0CurrThreAllocBytes:AVERAGE \
 AREA:0CurrThreAllocBytes#c17d11 \
 LINE2:0CurrThreAllocBytes#8f5902:"CurrentThreadAllocatedBytes" \
 GPRINT:0CurrThreAllocBytes:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CurrThreAllocBytes:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CurrThreAllocBytes:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0ThreContMonitEnabl={rrd4}:0ThreContMonitEnabl:AVERAGE \
 AREA:0ThreContMonitEnabl#73d216 \
 LINE2:0ThreContMonitEnabl#4e9a06:"ThreadContentionMonitoringEnabled" \
 GPRINT:0ThreContMonitEnabl:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ThreContMonitEnabl:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ThreContMonitEnabl:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0ThreContMonitSuppo={rrd5}:0ThreContMonitSuppo:AVERAGE \
 AREA:0ThreContMonitSuppo#3465a4 \
 LINE2:0ThreContMonitSuppo#204a87:"ThreadContentionMonitoringSupported" \
 GPRINT:0ThreContMonitSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ThreContMonitSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ThreContMonitSuppo:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0CurThreCpuTimeSupp={rrd6}:0CurThreCpuTimeSupp:AVERAGE \
 AREA:0CurThreCpuTimeSupp#75507b \
 LINE2:0CurThreCpuTimeSupp#5c3566:"CurrentThreadCpuTimeSupported" \
 GPRINT:0CurThreCpuTimeSupp:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CurThreCpuTimeSupp:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CurThreCpuTimeSupp:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0ObjeMoniUsageSuppo={rrd7}:0ObjeMoniUsageSuppo:AVERAGE \
 AREA:0ObjeMoniUsageSuppo#cc0000 \
 LINE2:0ObjeMoniUsageSuppo#a40000:"ObjectMonitorUsageSupported" \
 GPRINT:0ObjeMoniUsageSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ObjeMoniUsageSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ObjeMoniUsageSuppo:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0SynchrUsageSupport={rrd8}:0SynchrUsageSupport:AVERAGE \
 AREA:0SynchrUsageSupport#d3d7cf \
 LINE2:0SynchrUsageSupport#babdb6:"SynchronizerUsageSupported" \
 GPRINT:0SynchrUsageSupport:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0SynchrUsageSupport:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0SynchrUsageSupport:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0ThreaCpuTimeEnable={rrd9}:0ThreaCpuTimeEnable:AVERAGE \
 AREA:0ThreaCpuTimeEnable#555753 \
 LINE2:0ThreaCpuTimeEnable#2e3436:"ThreadCpuTimeEnabled" \
 GPRINT:0ThreaCpuTimeEnable:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ThreaCpuTimeEnable:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ThreaCpuTimeEnable:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0PeakThreadCnt={rrd10}:0PeakThreadCnt:AVERAGE \
 AREA:0PeakThreadCnt#edd400 \
 LINE2:0PeakThreadCnt#c4a000:"PeakThreadCount" \
 GPRINT:0PeakThreadCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0PeakThreadCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0PeakThreadCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0DaemonThreadCnt={rrd11}:0DaemonThreadCnt:AVERAGE \
 AREA:0DaemonThreadCnt#f57900 \
 LINE2:0DaemonThreadCnt#ce5c00:"DaemonThreadCount" \
 GPRINT:0DaemonThreadCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0DaemonThreadCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0DaemonThreadCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0ThreadCnt={rrd12}:0ThreadCnt:AVERAGE \
 AREA:0ThreadCnt#c17d11 \
 LINE2:0ThreadCnt#8f5902:"ThreadCount" \
 GPRINT:0ThreadCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ThreadCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ThreadCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0TotalStartThreaCnt={rrd13}:0TotalStartThreaCnt:AVERAGE \
 AREA:0TotalStartThreaCnt#73d216 \
 LINE2:0TotalStartThreaCnt#4e9a06:"TotalStartedThreadCount" \
 GPRINT:0TotalStartThreaCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0TotalStartThreaCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0TotalStartThreaCnt:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0AllThreadIds={rrd14}:0AllThreadIds:AVERAGE \
 AREA:0AllThreadIds#3465a4 \
 LINE2:0AllThreadIds#204a87:"AllThreadIds" \
 GPRINT:0AllThreadIds:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0AllThreadIds:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0AllThreadIds:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0CurreThreadCpuTime={rrd15}:0CurreThreadCpuTime:AVERAGE \
 AREA:0CurreThreadCpuTime#75507b \
 LINE2:0CurreThreadCpuTime#5c3566:"CurrentThreadCpuTime" \
 GPRINT:0CurreThreadCpuTime:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CurreThreadCpuTime:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CurreThreadCpuTime:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0CurreThreadUsrTime={rrd16}:0CurreThreadUsrTime:AVERAGE \
 AREA:0CurreThreadUsrTime#cc0000 \
 LINE2:0CurreThreadUsrTime#a40000:"CurrentThreadUserTime" \
 GPRINT:0CurreThreadUsrTime:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CurreThreadUsrTime:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CurreThreadUsrTime:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:0ThreaCpuTimeSuppor={rrd17}:0ThreaCpuTimeSuppor:AVERAGE \
 AREA:0ThreaCpuTimeSuppor#d3d7cf \
 LINE2:0ThreaCpuTimeSuppor#babdb6:"ThreadCpuTimeSupported" \
 GPRINT:0ThreaCpuTimeSuppor:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ThreaCpuTimeSuppor:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ThreaCpuTimeSuppor:MAX:" Max \\: %8.2lf %s\\n" \
 DEF:17ObjectName={rrd18}:17ObjectName:AVERAGE \
 AREA:17ObjectName#555753 \
 LINE2:17ObjectName#2e3436:"ObjectName" \
 GPRINT:17ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:17ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:17ObjectName:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Threading.0ThreaAllocMemSuppo.AttributeReport
###########################################
report.java.lang.Threading.0ThreaAllocMemSuppo.AttributeReport.name=java.lang:type=Threading[ThreadAllocatedMemorySupported]
report.java.lang.Threading.0ThreaAllocMemSuppo.AttributeReport.columns=0ThreaAllocMemSuppo
report.java.lang.Threading.0ThreaAllocMemSuppo.AttributeReport.type=interfaceSnmp
report.java.lang.Threading.0ThreaAllocMemSuppo.AttributeReport.command=--title="java.lang:type=Threading[ThreadAllocatedMemorySupported]" \
 --vertical-label="verticalLabel" \
 DEF:0ThreaAllocMemSuppo={rrd1}:0ThreaAllocMemSuppo:AVERAGE \
 AREA:0ThreaAllocMemSuppo#edd400 \
 LINE2:0ThreaAllocMemSuppo#c4a000:"ThreadAllocatedMemorySupported" \
 GPRINT:0ThreaAllocMemSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ThreaAllocMemSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ThreaAllocMemSuppo:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Threading.0ThreaAllocMemEnabl.AttributeReport
###########################################
report.java.lang.Threading.0ThreaAllocMemEnabl.AttributeReport.name=java.lang:type=Threading[ThreadAllocatedMemoryEnabled]
report.java.lang.Threading.0ThreaAllocMemEnabl.AttributeReport.columns=0ThreaAllocMemEnabl
report.java.lang.Threading.0ThreaAllocMemEnabl.AttributeReport.type=interfaceSnmp
report.java.lang.Threading.0ThreaAllocMemEnabl.AttributeReport.command=--title="java.lang:type=Threading[ThreadAllocatedMemoryEnabled]" \
 --vertical-label="verticalLabel" \
 DEF:0ThreaAllocMemEnabl={rrd1}:0ThreaAllocMemEnabl:AVERAGE \
 AREA:0ThreaAllocMemEnabl#edd400 \
 LINE2:0ThreaAllocMemEnabl#c4a000:"ThreadAllocatedMemoryEnabled" \
 GPRINT:0ThreaAllocMemEnabl:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ThreaAllocMemEnabl:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ThreaAllocMemEnabl:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Threading.0CurrThreAllocBytes.AttributeReport
###########################################
report.java.lang.Threading.0CurrThreAllocBytes.AttributeReport.name=java.lang:type=Threading[CurrentThreadAllocatedBytes]
report.java.lang.Threading.0CurrThreAllocBytes.AttributeReport.columns=0CurrThreAllocBytes
report.java.lang.Threading.0CurrThreAllocBytes.AttributeReport.type=interfaceSnmp
report.java.lang.Threading.0CurrThreAllocBytes.AttributeReport.command=--title="java.lang:type=Threading[CurrentThreadAllocatedBytes]" \
 --vertical-label="verticalLabel" \
 DEF:0CurrThreAllocBytes={rrd1}:0CurrThreAllocBytes:AVERAGE \
 AREA:0CurrThreAllocBytes#edd400 \
 LINE2:0CurrThreAllocBytes#c4a000:"CurrentThreadAllocatedBytes" \
 GPRINT:0CurrThreAllocBytes:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CurrThreAllocBytes:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CurrThreAllocBytes:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Threading.0ThreContMonitEnabl.AttributeReport
###########################################
report.java.lang.Threading.0ThreContMonitEnabl.AttributeReport.name=java.lang:type=Threading[ThreadContentionMonitoringEnabled]
report.java.lang.Threading.0ThreContMonitEnabl.AttributeReport.columns=0ThreContMonitEnabl
report.java.lang.Threading.0ThreContMonitEnabl.AttributeReport.type=interfaceSnmp
report.java.lang.Threading.0ThreContMonitEnabl.AttributeReport.command=--title="java.lang:type=Threading[ThreadContentionMonitoringEnabled]" \
 --vertical-label="verticalLabel" \
 DEF:0ThreContMonitEnabl={rrd1}:0ThreContMonitEnabl:AVERAGE \
 AREA:0ThreContMonitEnabl#edd400 \
 LINE2:0ThreContMonitEnabl#c4a000:"ThreadContentionMonitoringEnabled" \
 GPRINT:0ThreContMonitEnabl:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ThreContMonitEnabl:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ThreContMonitEnabl:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Threading.0ThreContMonitSuppo.AttributeReport
###########################################
report.java.lang.Threading.0ThreContMonitSuppo.AttributeReport.name=java.lang:type=Threading[ThreadContentionMonitoringSupported]
report.java.lang.Threading.0ThreContMonitSuppo.AttributeReport.columns=0ThreContMonitSuppo
report.java.lang.Threading.0ThreContMonitSuppo.AttributeReport.type=interfaceSnmp
report.java.lang.Threading.0ThreContMonitSuppo.AttributeReport.command=--title="java.lang:type=Threading[ThreadContentionMonitoringSupported]" \
 --vertical-label="verticalLabel" \
 DEF:0ThreContMonitSuppo={rrd1}:0ThreContMonitSuppo:AVERAGE \
 AREA:0ThreContMonitSuppo#edd400 \
 LINE2:0ThreContMonitSuppo#c4a000:"ThreadContentionMonitoringSupported" \
 GPRINT:0ThreContMonitSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ThreContMonitSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ThreContMonitSuppo:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Threading.0CurThreCpuTimeSupp.AttributeReport
###########################################
report.java.lang.Threading.0CurThreCpuTimeSupp.AttributeReport.name=java.lang:type=Threading[CurrentThreadCpuTimeSupported]
report.java.lang.Threading.0CurThreCpuTimeSupp.AttributeReport.columns=0CurThreCpuTimeSupp
report.java.lang.Threading.0CurThreCpuTimeSupp.AttributeReport.type=interfaceSnmp
report.java.lang.Threading.0CurThreCpuTimeSupp.AttributeReport.command=--title="java.lang:type=Threading[CurrentThreadCpuTimeSupported]" \
 --vertical-label="verticalLabel" \
 DEF:0CurThreCpuTimeSupp={rrd1}:0CurThreCpuTimeSupp:AVERAGE \
 AREA:0CurThreCpuTimeSupp#edd400 \
 LINE2:0CurThreCpuTimeSupp#c4a000:"CurrentThreadCpuTimeSupported" \
 GPRINT:0CurThreCpuTimeSupp:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CurThreCpuTimeSupp:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CurThreCpuTimeSupp:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Threading.0ObjeMoniUsageSuppo.AttributeReport
###########################################
report.java.lang.Threading.0ObjeMoniUsageSuppo.AttributeReport.name=java.lang:type=Threading[ObjectMonitorUsageSupported]
report.java.lang.Threading.0ObjeMoniUsageSuppo.AttributeReport.columns=0ObjeMoniUsageSuppo
report.java.lang.Threading.0ObjeMoniUsageSuppo.AttributeReport.type=interfaceSnmp
report.java.lang.Threading.0ObjeMoniUsageSuppo.AttributeReport.command=--title="java.lang:type=Threading[ObjectMonitorUsageSupported]" \
 --vertical-label="verticalLabel" \
 DEF:0ObjeMoniUsageSuppo={rrd1}:0ObjeMoniUsageSuppo:AVERAGE \
 AREA:0ObjeMoniUsageSuppo#edd400 \
 LINE2:0ObjeMoniUsageSuppo#c4a000:"ObjectMonitorUsageSupported" \
 GPRINT:0ObjeMoniUsageSuppo:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ObjeMoniUsageSuppo:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ObjeMoniUsageSuppo:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Threading.0SynchrUsageSupport.AttributeReport
###########################################
report.java.lang.Threading.0SynchrUsageSupport.AttributeReport.name=java.lang:type=Threading[SynchronizerUsageSupported]
report.java.lang.Threading.0SynchrUsageSupport.AttributeReport.columns=0SynchrUsageSupport
report.java.lang.Threading.0SynchrUsageSupport.AttributeReport.type=interfaceSnmp
report.java.lang.Threading.0SynchrUsageSupport.AttributeReport.command=--title="java.lang:type=Threading[SynchronizerUsageSupported]" \
 --vertical-label="verticalLabel" \
 DEF:0SynchrUsageSupport={rrd1}:0SynchrUsageSupport:AVERAGE \
 AREA:0SynchrUsageSupport#edd400 \
 LINE2:0SynchrUsageSupport#c4a000:"SynchronizerUsageSupported" \
 GPRINT:0SynchrUsageSupport:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0SynchrUsageSupport:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0SynchrUsageSupport:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Threading.0ThreaCpuTimeEnable.AttributeReport
###########################################
report.java.lang.Threading.0ThreaCpuTimeEnable.AttributeReport.name=java.lang:type=Threading[ThreadCpuTimeEnabled]
report.java.lang.Threading.0ThreaCpuTimeEnable.AttributeReport.columns=0ThreaCpuTimeEnable
report.java.lang.Threading.0ThreaCpuTimeEnable.AttributeReport.type=interfaceSnmp
report.java.lang.Threading.0ThreaCpuTimeEnable.AttributeReport.command=--title="java.lang:type=Threading[ThreadCpuTimeEnabled]" \
 --vertical-label="verticalLabel" \
 DEF:0ThreaCpuTimeEnable={rrd1}:0ThreaCpuTimeEnable:AVERAGE \
 AREA:0ThreaCpuTimeEnable#edd400 \
 LINE2:0ThreaCpuTimeEnable#c4a000:"ThreadCpuTimeEnabled" \
 GPRINT:0ThreaCpuTimeEnable:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ThreaCpuTimeEnable:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ThreaCpuTimeEnable:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Threading.0PeakThreadCnt.AttributeReport
###########################################
report.java.lang.Threading.0PeakThreadCnt.AttributeReport.name=java.lang:type=Threading[PeakThreadCount]
report.java.lang.Threading.0PeakThreadCnt.AttributeReport.columns=0PeakThreadCnt
report.java.lang.Threading.0PeakThreadCnt.AttributeReport.type=interfaceSnmp
report.java.lang.Threading.0PeakThreadCnt.AttributeReport.command=--title="java.lang:type=Threading[PeakThreadCount]" \
 --vertical-label="verticalLabel" \
 DEF:0PeakThreadCnt={rrd1}:0PeakThreadCnt:AVERAGE \
 AREA:0PeakThreadCnt#edd400 \
 LINE2:0PeakThreadCnt#c4a000:"PeakThreadCount" \
 GPRINT:0PeakThreadCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0PeakThreadCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0PeakThreadCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Threading.0DaemonThreadCnt.AttributeReport
###########################################
report.java.lang.Threading.0DaemonThreadCnt.AttributeReport.name=java.lang:type=Threading[DaemonThreadCount]
report.java.lang.Threading.0DaemonThreadCnt.AttributeReport.columns=0DaemonThreadCnt
report.java.lang.Threading.0DaemonThreadCnt.AttributeReport.type=interfaceSnmp
report.java.lang.Threading.0DaemonThreadCnt.AttributeReport.command=--title="java.lang:type=Threading[DaemonThreadCount]" \
 --vertical-label="verticalLabel" \
 DEF:0DaemonThreadCnt={rrd1}:0DaemonThreadCnt:AVERAGE \
 AREA:0DaemonThreadCnt#edd400 \
 LINE2:0DaemonThreadCnt#c4a000:"DaemonThreadCount" \
 GPRINT:0DaemonThreadCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0DaemonThreadCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0DaemonThreadCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Threading.0ThreadCnt.AttributeReport
###########################################
report.java.lang.Threading.0ThreadCnt.AttributeReport.name=java.lang:type=Threading[ThreadCount]
report.java.lang.Threading.0ThreadCnt.AttributeReport.columns=0ThreadCnt
report.java.lang.Threading.0ThreadCnt.AttributeReport.type=interfaceSnmp
report.java.lang.Threading.0ThreadCnt.AttributeReport.command=--title="java.lang:type=Threading[ThreadCount]" \
 --vertical-label="verticalLabel" \
 DEF:0ThreadCnt={rrd1}:0ThreadCnt:AVERAGE \
 AREA:0ThreadCnt#edd400 \
 LINE2:0ThreadCnt#c4a000:"ThreadCount" \
 GPRINT:0ThreadCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ThreadCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ThreadCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Threading.0TotalStartThreaCnt.AttributeReport
###########################################
report.java.lang.Threading.0TotalStartThreaCnt.AttributeReport.name=java.lang:type=Threading[TotalStartedThreadCount]
report.java.lang.Threading.0TotalStartThreaCnt.AttributeReport.columns=0TotalStartThreaCnt
report.java.lang.Threading.0TotalStartThreaCnt.AttributeReport.type=interfaceSnmp
report.java.lang.Threading.0TotalStartThreaCnt.AttributeReport.command=--title="java.lang:type=Threading[TotalStartedThreadCount]" \
 --vertical-label="verticalLabel" \
 DEF:0TotalStartThreaCnt={rrd1}:0TotalStartThreaCnt:AVERAGE \
 AREA:0TotalStartThreaCnt#edd400 \
 LINE2:0TotalStartThreaCnt#c4a000:"TotalStartedThreadCount" \
 GPRINT:0TotalStartThreaCnt:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0TotalStartThreaCnt:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0TotalStartThreaCnt:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Threading.0AllThreadIds.AttributeReport
###########################################
report.java.lang.Threading.0AllThreadIds.AttributeReport.name=java.lang:type=Threading[AllThreadIds]
report.java.lang.Threading.0AllThreadIds.AttributeReport.columns=0AllThreadIds
report.java.lang.Threading.0AllThreadIds.AttributeReport.type=interfaceSnmp
report.java.lang.Threading.0AllThreadIds.AttributeReport.command=--title="java.lang:type=Threading[AllThreadIds]" \
 --vertical-label="verticalLabel" \
 DEF:0AllThreadIds={rrd1}:0AllThreadIds:AVERAGE \
 AREA:0AllThreadIds#edd400 \
 LINE2:0AllThreadIds#c4a000:"AllThreadIds" \
 GPRINT:0AllThreadIds:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0AllThreadIds:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0AllThreadIds:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Threading.0CurreThreadCpuTime.AttributeReport
###########################################
report.java.lang.Threading.0CurreThreadCpuTime.AttributeReport.name=java.lang:type=Threading[CurrentThreadCpuTime]
report.java.lang.Threading.0CurreThreadCpuTime.AttributeReport.columns=0CurreThreadCpuTime
report.java.lang.Threading.0CurreThreadCpuTime.AttributeReport.type=interfaceSnmp
report.java.lang.Threading.0CurreThreadCpuTime.AttributeReport.command=--title="java.lang:type=Threading[CurrentThreadCpuTime]" \
 --vertical-label="verticalLabel" \
 DEF:0CurreThreadCpuTime={rrd1}:0CurreThreadCpuTime:AVERAGE \
 AREA:0CurreThreadCpuTime#edd400 \
 LINE2:0CurreThreadCpuTime#c4a000:"CurrentThreadCpuTime" \
 GPRINT:0CurreThreadCpuTime:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CurreThreadCpuTime:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CurreThreadCpuTime:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Threading.0CurreThreadUsrTime.AttributeReport
###########################################
report.java.lang.Threading.0CurreThreadUsrTime.AttributeReport.name=java.lang:type=Threading[CurrentThreadUserTime]
report.java.lang.Threading.0CurreThreadUsrTime.AttributeReport.columns=0CurreThreadUsrTime
report.java.lang.Threading.0CurreThreadUsrTime.AttributeReport.type=interfaceSnmp
report.java.lang.Threading.0CurreThreadUsrTime.AttributeReport.command=--title="java.lang:type=Threading[CurrentThreadUserTime]" \
 --vertical-label="verticalLabel" \
 DEF:0CurreThreadUsrTime={rrd1}:0CurreThreadUsrTime:AVERAGE \
 AREA:0CurreThreadUsrTime#edd400 \
 LINE2:0CurreThreadUsrTime#c4a000:"CurrentThreadUserTime" \
 GPRINT:0CurreThreadUsrTime:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0CurreThreadUsrTime:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0CurreThreadUsrTime:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Threading.0ThreaCpuTimeSuppor.AttributeReport
###########################################
report.java.lang.Threading.0ThreaCpuTimeSuppor.AttributeReport.name=java.lang:type=Threading[ThreadCpuTimeSupported]
report.java.lang.Threading.0ThreaCpuTimeSuppor.AttributeReport.columns=0ThreaCpuTimeSuppor
report.java.lang.Threading.0ThreaCpuTimeSuppor.AttributeReport.type=interfaceSnmp
report.java.lang.Threading.0ThreaCpuTimeSuppor.AttributeReport.command=--title="java.lang:type=Threading[ThreadCpuTimeSupported]" \
 --vertical-label="verticalLabel" \
 DEF:0ThreaCpuTimeSuppor={rrd1}:0ThreaCpuTimeSuppor:AVERAGE \
 AREA:0ThreaCpuTimeSuppor#edd400 \
 LINE2:0ThreaCpuTimeSuppor#c4a000:"ThreadCpuTimeSupported" \
 GPRINT:0ThreaCpuTimeSuppor:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:0ThreaCpuTimeSuppor:MIN:" Min \\: %8.2lf %s" \
 GPRINT:0ThreaCpuTimeSuppor:MAX:" Max \\: %8.2lf %s\\n" \


###########################################
## java.lang.Threading.17ObjectName.AttributeReport
###########################################
report.java.lang.Threading.17ObjectName.AttributeReport.name=java.lang:type=Threading[ObjectName]
report.java.lang.Threading.17ObjectName.AttributeReport.columns=17ObjectName
report.java.lang.Threading.17ObjectName.AttributeReport.type=interfaceSnmp
report.java.lang.Threading.17ObjectName.AttributeReport.command=--title="java.lang:type=Threading[ObjectName]" \
 --vertical-label="verticalLabel" \
 DEF:17ObjectName={rrd1}:17ObjectName:AVERAGE \
 AREA:17ObjectName#edd400 \
 LINE2:17ObjectName#c4a000:"ObjectName" \
 GPRINT:17ObjectName:AVERAGE:" Avg \\: %8.2lf %s" \
 GPRINT:17ObjectName:MIN:" Min \\: %8.2lf %s" \
 GPRINT:17ObjectName:MAX:" Max \\: %8.2lf %s\\n" \

```


