# Session 8 Unit Testing and integration testing


## Introduction

One of the things which Devops engineers need to do as part of a CI/CD system is have broad test coverage which assures the project that code which is checked in by a contributor both works as expected and doesn't break any other part of the code base.
To do this, we need to test individual modules as the build progresses (Unit Testing) and also test the completed application as it will be put into production (Integration testing). 
Often unit tests and integration tests are essentially testing the same thing, but they do so in a differn't context.
Integration testing may not be as complete as unit testing but it should perform at least a 'smoke test' which shows that all of the components in the completed app are probably working as expected.

Once the application is completed and in production, we also need to have a process which ensures it is running correctly. 
This is sometimes referred to generically as monitoring or as service assurance. 
To assure that an application continues to operate correctly, we need to monitor the application in a way which simulates the actions of an end user. 
This uses what we call 'synthetic transactions' where regular interactions are performed, possibly from multiple geographic locations to ensure that the application is available to all of it's users or if it becomes unavailable, the service provider finds out about it before the users do.
However as well as monitoring the external behaviour of the application (black box testing), Devops engineers also need to monitor the internal components in order to detect potential problems before they manifest.
So, for instance, we probably need to monitor disk utilisation, the performance of the database or the number of sessions present in the web server. 
These measurements can help predict when there is a need to increase the memory or cpus allocated to an application.

## Unit Testing examples

In the [spring-boot-leaflet-starter](../session8/spring-boot-leaflet-starter) example I have introduced some unit tests which run during the initial build.

[MapApplicationTests.java](/spring-boot-leaflet-starter/src/test/java/org/solent/spring/map/test/MapApplicationTests.java) contains a set of tests which are run by the maven-surefire-plugin  in the [pom.xml](/spring-boot-leaflet-starter/pom.xml).
The plugin runs test classes named ending in *Test.java. 
However it is set up to avoid running integration test classes ending in *IT.java.

```
         <!-- surefire plugin runs junit tests during test phase but excludes integration tests -->
         <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <configuration>
               <excludes>
                  <exclude>**/*IT.java</exclude>
               </excludes>
            </configuration>
         </plugin>
```
The test class spins up the full spring boot application before running a test to check that the home page is reachable and returns some expected text. 
This is a very simple tests but much more sophisticated tests are possible.
See the [Spring Testing Guide](see https://spring.io/guides/gs/testing-web/) for more examples. 

```
// see https://spring.io/guides/gs/testing-web/  for examples of testing 
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class MapApplicationTests {
    
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    
    // very simple test that swagger ui link is present
    @Test
    public void homePage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/",
                String.class)).contains("Swagger (OpenAPI) UI");
    }
```

the unit tests will be run as part of the normal build

```
mvn clean install
```

## Integration Testing examples

I have provided an integration test example which uses the Selenium test framework. 

[Selenium](https://www.selenium.dev/documentation/) is an umbrella project for a range of tools and libraries that enable and support the automation of web browsers.
The [Selenium IDE](https://www.selenium.dev/documentation/ide/) is a browser plugin which can record the exact operations of a user visiting a site.
The IDE can export this recording as a Java Junit test which can then be incorporated in our integration tests. 

Spring can run Selenium as part of unit tests, but in this case I wanted to show testing the complete application running in a stand alone jetty web server without dependencies on the spring test framework..

[MapApplictionIT.java](../session8/spring-boot-leaflet-starter/src/test/java/org/solent/spring/map/integration/test/MapApplictionIT.java) is the example test class. 

The [maven-failsafe-plugin](https://maven.apache.org/surefire/maven-failsafe-plugin/) in the [pom.xml](/spring-boot-leaflet-starter/pom.xml) only runs tests ending with `*IT.java` during the `integration-test` phase of the build. 

Before the Selenium test can run, the built war is injected into a jetty server and the project starts jetty in the `pre-integration-test` phase and shuts down jetty in the `post-integration-test` phase. 

Selenium needs a web browser and its associated driver to be pre-installed on the server where the test is running. 
In this example we are using Firefox which must be pre-installed on the server.
The build uses a small ant script to download the appropriate driver depending on whether we are running on linux or windows. 
Both the Linux and Windows drivers are downloaded to `./geckodriver` and `./geckodriver.exe` if they are not already present.
It is important that a setting in the `.gitignore` file prevents them from being checked into github.

The `setUp()` method runs before the tests and sets up the driver ready for the actual tests.

A key aspect of this is the test whether to run the browser 'headless'.
If we are running our tests on our laptop, the browser can open a window and we can see the tests running. 
However on a server without a GUI (i.e. the server used to run the build with github actions), the browser will not start up unless we tell it to run without a window using the headless option.
The `selenium.firefox.headless` System property tells the setUp() method to run the browser headless. 

After the `setUo() method run` the `pointTest()` method contains the actions which are part of the test.
These have been recorded using the Selenium IDE describe above and could be extended to do more detailed checks on the responses. 

For a tutorial on integration testing see [maven integration tests](https://www.baeldung.com/maven-integration-test)

## Running the Integration tests

The integration tests do not run as part of the normal build but are included in a profile at the bottom of  the pom called `integration`

The command to run the full build with unit tests and integration tests is

```
mvn -Pintegration clean verify
```

## Fixes to get the example to work

It has been a bit of a struggle to get the Selenum tests to run as part of the spring-boot-leaflet-starter project. 
As is often the case in development, there can be conflicting dependencies which mess up the class path and stop things from running as expected. 
The basic problem is that my example used Selenium 3 and Spring boot imported its own dependencies on Selenium 4.

To get my example Selenium 3 tests to work,  I needed to carefully exclude Selenium 4 dependencies from the pom.xml which took a bit of work to sort out. 

Spring boot also has dependencies on Junit 5, when my tests used Junit 4. 
The following addition is is necessary if you're using JUnit 4 with the latest Spring Boot version
```
      <dependency>
         <groupId>org.junit.vintage</groupId>
         <artifactId>junit-vintage-engine</artifactId>
         <scope>test</scope>
      </dependency>
```




