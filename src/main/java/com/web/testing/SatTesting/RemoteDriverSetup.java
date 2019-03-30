package com.web.testing.SatTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriverSetup {
	
	public WebDriver driver = null;
	
	public WebDriver getRemoteWebDriver() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		Map<String, Object> baseState = new HashMap<String, Object>();
		baseState.put("type", "NATIVE");
		baseState.put("executable", "APP");
		baseState.put("locator", "//Window");

		capabilities.setCapability("appdriver-basestate", baseState);

		Map<String, Object> options = new HashMap<String, Object>();
		options.put("closeOnQuit", true);

		capabilities.setCapability("appdriver-options", options);
		capabilities.setCapability("networkConnectionEnabled", true);
        capabilities.setCapability("browserConnectionEnabled", true);

		driver = new RemoteWebDriver(new URL("http://localhost:8080"), capabilities);
		return driver;
	}
	
	
	public WebDriver getLocalDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Mohwk_college\\Selenium\\selenium-driver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    return driver;
	}

}
