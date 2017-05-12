package com.hybridframework.testscripts;

import org.testng.annotations.Test;

import com.hybridframework.orangehrm.pom.OrangehrmHomePage;
import com.hybridframework.orangehrm.pom.OrangehrmLoginPage;
import com.hybridframework.orangehrm.pom.OrangehrmSystemUsersPage;

public class OrangehrmDeleteUser extends BaseTestNG {

	@Test(groups="Test1")
	public void deleteUser() {
		try {

			OrangehrmLoginPage orangecrmLoginPage=new OrangehrmLoginPage(driver);
			logger.info("---------Opening Login Page---------");
			orangecrmLoginPage.login("Admin", "admin");
			OrangehrmHomePage orangehrmHomePage=new OrangehrmHomePage(driver);
			orangehrmHomePage.clickAdminTab();
			logger.info("---------Clicked on admin tab---------");
			OrangehrmSystemUsersPage orangehrmSystemUsersPage=new OrangehrmSystemUsersPage(driver);
			orangehrmSystemUsersPage.searchAndDeleteUser("AndrewDaley10");
			orangehrmSystemUsersPage.logout();

		}
		catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());

		}
	}

}
