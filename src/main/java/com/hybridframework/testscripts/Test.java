package com.hybridframework.testscripts;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.hybridframework.orangehrm.pom.OrangehrmAddUserPage;
import com.hybridframework.orangehrm.pom.OrangehrmHomePage;
import com.hybridframework.orangehrm.pom.OrangehrmLoginPage;
import com.hybridframework.orangehrm.pom.OrangehrmSystemUsersPage;
import com.hybridframework.utils.DriverFactory;
import com.hybridframework.utils.Utilities;

public class Test {
	
	public static WebDriver driver;
	
	public static void main(String[] args) {
		try {
//			DriverFactory factory = new DriverFactory();
//			driver = factory.setup(driver);
//			driver.get(Utilities.getPropertyValue("url"));
//			OrangehrmLoginPage orangecrmLoginPage = new OrangehrmLoginPage(driver);
//			orangecrmLoginPage.login("Admin", "admin");
//			OrangehrmHomePage orangehrmHomePage = new OrangehrmHomePage(driver);
//			orangehrmHomePage.clickAdminTab();
//			OrangehrmSystemUsersPage orangehrmSystemUsersPage = new OrangehrmSystemUsersPage(driver);
//			orangehrmSystemUsersPage.clickAddButton();
//			OrangehrmAddUserPage orangehrmAddUserPage = new OrangehrmAddUserPage(driver);
//			orangehrmAddUserPage.enterUserDetails("Andrew Daley", "AndrewDaley1", "abcd", "abcd");
//			orangehrmSystemUsersPage.waitForsystemUsersHeader();
//			orangehrmSystemUsersPage.logout();
			
			File file = new File(System.getProperty("user.dir")+"/src/main/resources/a");
//			File file = new File(System.getProperty("user.dir")+"/a");
			file.mkdir();
			System.out.println(file.getAbsolutePath());
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
//			driver.quit();
		}
	}
}
