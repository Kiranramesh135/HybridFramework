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

public class BaseTestNG {

	protected DriverFactory driverFactory;
	protected WebDriver driver;
	public Logger logger = (Logger) LogManager.getLogger(BaseTestNG.class);

	@BeforeSuite
	public void preCondition() {
		
		File f = new File("src/main/resources/config/log4j2.xml");
		URI fc = f.toURI();         
		LoggerContext.getContext().setConfigLocation(fc);
		logger.debug("this is a debug log message");
		logger.info("this is a information log message");
		logger.warn("this is a warning log message");
		logger.error("this is a precondition");
		driverFactory = new DriverFactory();
		driver = driverFactory.setup(driver);
		
		
	}

	@AfterSuite
	public void postCondition() {
		driverFactory.destroyDriver();
	}
}
