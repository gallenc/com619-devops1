package org.solent.spring.map.integration.test;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.JavascriptExecutor;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.io.File;
import java.util.concurrent.TimeUnit;


public class MapApplictionIT {
	private  Logger LOG = LoggerFactory.getLogger(MapApplictionIT.class);
	
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {

		// get gecko driver from https://github.com/mozilla/geckodriver/releases
		// if you didn't update the Path system variable to add the full directory path
		// to the executable as above mentioned then doing this directly through code
		
		String driverLocation = System.getProperty("webdriver.gecko.driver");
		LOG.debug("initial system property webdriver.gecko.driver "+driverLocation);
		if(driverLocation==null) {
			// detect if windows or linux
			String OS = System.getProperty("os.name").toLowerCase();
			if(OS.contains("win")) {
				LOG.debug("using windows driver");
				driverLocation = "./geckodriver.exe";
			} else {
				LOG.debug("using linux driver");
				driverLocation = "./geckodriver";
			}
			
			File driver = new File(driverLocation);
			System.setProperty("webdriver.gecko.driver", driver.getAbsolutePath());
		}
		LOG.debug("webdriver.gecko.driver set to "+System.getProperty("webdriver.gecko.driver"));
		
		FirefoxBinary firefoxBinary = new FirefoxBinary();
		
		String headless = System.getProperty("selenium.firefox.headless");
		LOG.debug("initial system property selenium.firefox.headless "+headless);
		if ("true".equals(headless)) {
			LOG.debug("system property selenium.firefox.headless="+headless+", running firefox in headless mode");
			firefoxBinary.addCommandLineOptions("--headless");
		} else {
			LOG.debug("system property selenium.firefox.headless="+headless+", running firefox with display");
		}

		
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		// set up proxy
		firefoxOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		LOG.debug("setUp() FIREFOX BINARY LOG LEVEL TRACE");
		firefoxOptions.setBinary(firefoxBinary);
		firefoxOptions.setLogLevel(FirefoxDriverLogLevel.TRACE);
		LOG.debug("setUp() LOADING FIREFOX DRIVER");

		driver = new FirefoxDriver(firefoxOptions);
		
		LOG.debug("setUp() SETTING DRIVER TIMEOUTS");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		LOG.debug("quitting driver");
		driver.quit();
	}

	public String waitForWindow(int timeout) {
		LOG.debug("waiting for window ms: "+timeout);
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Set<String> whNow = driver.getWindowHandles();
		Set<String> whThen = (Set<String>) vars.get("window_handles");
		if (whNow.size() > whThen.size()) {
			whNow.removeAll(whThen);
		}
		return whNow.iterator().next();
	}

	@Test
	public void pointTest() {
		driver.get("http://localhost:8080/");
		driver.manage().window().setSize(new Dimension(1095, 797));
		driver.findElement(By.linkText("Map")).click();
		driver.findElement(By.linkText("Point List")).click();
		driver.findElement(By.cssSelector("tr:nth-child(1) form:nth-child(1) > .btn")).click();
		driver.findElement(By.linkText("Map")).click();
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.linkText("Swagger (OpenAPI) UI")).click();
		vars.put("win4919", waitForWindow(2000));
		driver.switchTo().window(vars.get("win4919").toString());
		driver.findElement(By.cssSelector("#operations-map-point-rest-controller-list .opblock-summary-method"))
				.click();
		driver.findElement(By.cssSelector(".btn")).click();
		driver.findElement(By.cssSelector(".execute")).click();
		driver.findElement(By.cssSelector(".execute")).click();
	}
}
