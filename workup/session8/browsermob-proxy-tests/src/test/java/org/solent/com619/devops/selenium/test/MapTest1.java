package org.solent.com619.devops.selenium.test;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;

public class MapTest1 {
	private  Logger LOG = LoggerFactory.getLogger(MapTest1.class);
	
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {

		// get geko driver from https://github.com/mozilla/geckodriver/releases
		// if you didn't update the Path system variable to add the full directory path
		// to the executable as above mentioned then doing this directly through code
		System.setProperty("webdriver.gecko.driver", "C:\\devel\\geckodriver\\geckodriver.exe");
		
		
		FirefoxBinary firefoxBinary = new FirefoxBinary();
		LOG.debug("setUp() HEADLESS");
		//firefoxBinary.addCommandLineOptions("--headless");
		
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		// set up proxy
		firefoxOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		LOG.debug("setUp() FIREFOX BINARY LOG LEVEL TRACE");
		firefoxOptions.setBinary(firefoxBinary);
		firefoxOptions.setLogLevel(FirefoxDriverLogLevel.TRACE);
		LOG.debug("setUp() 4");

		driver = new FirefoxDriver(firefoxOptions);
		LOG.debug("setUp() 5");

		LOG.debug("setUp() 6");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	public String waitForWindow(int timeout) {
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
