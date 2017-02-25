package com.hybridframework.stepdefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;

public class Initialize {

	WebDriver driver = new FirefoxDriver();

	@Given("^i open browser$")
	public void i_open_browser() throws Throwable {
		// driver.get(ConfigReader.getValue("url"));
		driver.manage().window().maximize();
	}

	@Given("^maximize the browser$")
	public void maximize_the_browser() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
