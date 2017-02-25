package com.hybridframework.testscripts;

import org.apache.logging.log4j.*;
import org.testng.annotations.Test;
import com.hybridframework.pom.ProductsListPage;
import com.hybridframework.pom.VtigerHomePage;
import com.hybridframework.pom.VtigerLoginPage;

public class SampleTestScript extends BaseTestNG {
	public Logger logger = LogManager.getLogger(this.getClass());

	@Test
	public void testLogin() {
		
		logger.info("Initializing brower");
		new VtigerLoginPage(driver).login("admin", "1234");
		logger.error("Logging in to vtiger");
		logger.error("Clicking on Products Menu");
		new VtigerHomePage(driver).clickProductsMenu();
		logger.info("Clicking on Add Products Menu");
		new ProductsListPage(driver).clickAddProductsButton();
	}
}
