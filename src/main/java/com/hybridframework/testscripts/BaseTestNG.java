package com.hybridframework.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.hybridframework.utils.DriverFactory;

public abstract class BaseTestNG {

	protected DriverFactory driverFactory;
	protected WebDriver driver;

	@BeforeSuite
	public void preCondition() {
		driverFactory = new DriverFactory();
		driver = driverFactory.setup(driver);
	}

	@AfterSuite
	public void postCondition() {
		driverFactory.destroyDriver();
		
	}
}
