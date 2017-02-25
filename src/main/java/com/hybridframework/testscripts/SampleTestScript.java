package com.hybridframework.testscripts;

import org.apache.logging.log4j.*;
import org.testng.annotations.Test;
import com.hybridframework.pom.ProductsListPage;
import com.hybridframework.pom.VtigerHomePage;
import com.hybridframework.pom.VtigerLoginPage;
import com.hybridframework.utils.Utilities;

public class SampleTestScript extends BaseTestNG {
	
	public Logger logger = LogManager.getLogger(this.getClass());
	
	@Test
	public void testLogin() {
		logger.info("Initializing brower");
		VtigerLoginPage vtigerLoginPage = new VtigerLoginPage(driver);
		logger.error("Logging in to vtiger");
		Utilities.takeScreenshot(driver, "LoginPage");
		vtigerLoginPage.login("admin", "1234");
		logger.error("Clicking on Products Menu");
		VtigerHomePage vtigerHomePage = new VtigerHomePage(driver);
		Utilities.takeScreenshot(driver, "HomePage");
		vtigerHomePage.clickProductsMenu();
		logger.info("Clicking on Add Products Menu");
		ProductsListPage productsListPage = new ProductsListPage(driver);
		Utilities.takeScreenshot(driver, "ProductsListPage");
		productsListPage.clickAddProductsButton();
	}
}
