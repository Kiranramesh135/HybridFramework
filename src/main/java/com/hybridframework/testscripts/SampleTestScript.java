package com.hybridframework.testscripts;

import org.testng.annotations.Test;
import com.hybridframework.pom.ProductsListPage;
import com.hybridframework.pom.VtigerHomePage;
import com.hybridframework.pom.VtigerLoginPage;

public class SampleTestScript extends BaseTestNG{
	
	@Test@org.junit.Test
	public void testLogin()
	{
		new VtigerLoginPage(driver).login("admin", "1234");
		new VtigerHomePage(driver).clickProductsMenu();
		new ProductsListPage(driver).clickAddProductsButton();
		
	}
}
