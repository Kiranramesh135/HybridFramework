package com.hybridframework.testscripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.hybridframework.utils.Utilities;
import com.hybridframework.vtiger.pom.ProductsListPage;
import com.hybridframework.vtiger.pom.VtigerHomePage;
import com.hybridframework.vtiger.pom.VtigerLoginPage;

public class SampleTestScriptVtiger extends BaseTestNG {
	
	public Logger logger = LogManager.getLogger(this.getClass());
	
	@Test
	public void testLogin() {
		logger.info("Initializing brower");
		VtigerLoginPage vtigerLoginPage = new VtigerLoginPage(driver);
		logger.error("Logging in to vtiger");
		vtigerLoginPage.login("admin", "1234");
		Utilities.takeScreenshot(driver, "LoginPage");
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
