package org.phraseapp.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.ServletComponentScan;

// ServeletComponentScan finds @WebFilters 
// see https://www.yawintutor.com/spring-boot-webfilter-not-working/
// this is only needed for embedded server i.e mvn spring-boot:run see https://www.baeldung.com/spring-servletcomponentscan

@SpringBootApplication
@ServletComponentScan("org.phraseapp.i18n")
public class InternationalisationApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(InternationalisationApplication.class, args);
	}
}
