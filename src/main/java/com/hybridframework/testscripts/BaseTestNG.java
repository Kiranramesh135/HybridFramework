package com.hybridframework.testscripts;

import java.io.File;
import java.net.URI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.hybridframework.utils.DriverFactory;
import com.hybridframework.utils.LogDemo;

public class BaseTestNG {

	protected DriverFactory driverFactory;
	protected WebDriver driver;
	public Logger logger;

	@BeforeSuite
	public void preCondition() {
		LoggerContext context = (LoggerContext) LogManager.getContext(false);
		File file = new File("src/main/resources/config/log4j2.xml");
		context.setConfigLocation(file.toURI());
		logger = LogManager.getLogger(this.getClass());
		driverFactory = new DriverFactory();
		driver = driverFactory.setup(driver);
	}

	@AfterSuite
	public void postCondition() {
		driverFactory.destroyDriver();
	}
}
