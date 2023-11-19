# Session 8 Unit Testing and integration testing


## Introduction
In this example i have introducted some unit tests which run during the initial build.

And some Selenium tests which run against the final assembled project. 
To get the Selenium tests to run, the project starts jetty in the pre-integrtion-test phase and shuts down jetty in the post-integration-test phase. 

to run the full build with unit tests and integration tests use

```
mvn clean -Pintegration verify
```

more information at 
testing https://www.baeldung.com/maven-integration-test

## fixes to get it to work

Spring boot has its own dependencies on Selenium 4 so to get my example Selenium 3 tests to work,  I needed to carefully exclude Selenium 4 dependencies from the pom.xml.

Spring boot also has depencenis on Junit 5, when my tests used Junit 4. 
This is necessary if you're using JUnit 4 with the latest Spring Boot version
```
      <dependency>
         <groupId>org.junit.vintage</groupId>
         <artifactId>junit-vintage-engine</artifactId>
         <scope>test</scope>
      </dependency>
```




