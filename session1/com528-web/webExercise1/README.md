# running with maven on windows

If maven is not installed on windows, you can use the maven wrapper to run maven from a command line.

jar files cannot be checked into github so the maven-wrapper.jar is named maven-wrapper.jar-saved 

rename .mvn/wrapper/maven-wrapper.jar-saved to maven-wrapper.jar then run command

```
mvnw.cmd clean install
mvnw.cmd cargo:run
```

