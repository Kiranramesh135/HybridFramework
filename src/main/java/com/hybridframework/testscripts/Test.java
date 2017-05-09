package com.hybridframework.testscripts;

import org.openqa.selenium.WebDriver;

import com.hybridframework.orangehrm.pom.OrangehrmHomePage;
import com.hybridframework.orangehrm.pom.OrangehrmLoginPage;
import com.hybridframework.utils.DriverFactory;
import com.hybridframework.utils.Utilities;

public class Test {
	
	public static WebDriver driver;
	
	public static void main(String[] args) {
		try {
			DriverFactory factory = new DriverFactory();
			driver = factory.setup(driver);
			driver.get(Utilities.getPropertyValue("url"));
			OrangehrmLoginPage orangecrmLoginPage = new OrangehrmLoginPage(driver);
			orangecrmLoginPage.login("Admin", "admin");
			OrangehrmHomePage orangehrmHomePage = new OrangehrmHomePage(driver);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
