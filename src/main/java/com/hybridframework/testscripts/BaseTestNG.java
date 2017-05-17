package com.hybridframework.testscripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.hybridframework.utils.DriverFactory;
import com.hybridframework.utils.LogFactory;
import com.hybridframework.utils.Utilities;

public class BaseTestNG {

	protected DriverFactory driverFactory;
	protected static WebDriver driver;
	public Logger logger=new LogFactory().getLogger();

	@BeforeSuite
	public void preCondition() {
		
		Utilities.createResultFolder();
		logger=LogManager.getLogger(this.getClass());
		logger.info("----------Initializing Driver----------");
		driverFactory=new DriverFactory();
		driver=driverFactory.setup(driver);
	}

	@AfterSuite
	public void postCondition() {
//		driverFactory.destroyDriver();
	}
}
