package org.solent.spring.map.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

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
	
	// very simple test that swagger page has loaded. Note we cannot test the javascript elements here.
	@Test
	public void swaggerUiPage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/swagger-ui/index.html",
				String.class)).contains("<div id=\"swagger-ui\"></div>");
	}
	

//	@Test
//	public void contextLoads() {
//	}
	

}
