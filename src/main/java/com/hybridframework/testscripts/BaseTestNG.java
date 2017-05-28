package com.hybridframework.testscripts;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.hybridframework.utils.DriverFactory;
import com.hybridframework.utils.ExtentReportFactory;
import com.hybridframework.utils.LogFactory;
import com.hybridframework.utils.Utilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTestNG {

	protected DriverFactory driverFactory;
	protected ExtentReportFactory extentReportFactory;
	protected static WebDriver driver;
	protected static ExtentReports extent;
	public static ExtentTest test;
	public Logger logger = new LogFactory().getLogger();

	@BeforeSuite
	public void preCondition() {

		Utilities.createResultFolder();
		logger = LogManager.getLogger(this.getClass());
		logger.info("----------Initializing Browser----------");
		driverFactory = new DriverFactory();
		driver = driverFactory.setup(driver);
		extentReportFactory = new ExtentReportFactory();
		extent = extentReportFactory.intialize(extent);

	}

	@BeforeMethod
	public void beforeMethod(Method method) {

		test = extent.startTest((this.getClass().getSimpleName() + " :: " + method.getName()), method.getName());
		test.assignAuthor("Kiran");

	}

	@AfterMethod
	public void afterMethod() {
		extent.endTest(test);
	}

	@AfterSuite
	public void postCondition() {
		extent.flush();
		extent.close();
		driverFactory.destroyDriver();
		logger.info("----------Closing Browser----------");
	}
}
