package com.hybridframework.testscripts;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.hybridframework.utils.DriverFactory;
import com.hybridframework.utils.LogFactory;

public class BaseTestNG {

	protected DriverFactory driverFactory;
	protected WebDriver driver;
	public Logger logger = new LogFactory().getLogger();

	@BeforeSuite
	public void preCondition() {
		logger = LogManager.getLogger(this.getClass());
		logger.info("----------Initializing Driver----------");
		driverFactory = new DriverFactory();
		driver = driverFactory.setup(driver);
	}

	@AfterSuite
	public void postCondition() {
		driverFactory.destroyDriver();
	}
}
