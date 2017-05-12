package com.hybridframework.testscripts;

import org.testng.annotations.Test;

import com.hybridframework.orangehrm.pom.OrangehrmAddUserPage;
import com.hybridframework.orangehrm.pom.OrangehrmHomePage;
import com.hybridframework.orangehrm.pom.OrangehrmLoginPage;
import com.hybridframework.orangehrm.pom.OrangehrmSystemUsersPage;

public class OrangehrmAddUser extends BaseTestNG {

	@Test(groups="Test1")
	public void addUser() {

		try {

			OrangehrmLoginPage orangecrmLoginPage=new OrangehrmLoginPage(driver);
			logger.info("---------Opening Login Page---------");
			orangecrmLoginPage.login("Admin", "admin");
			OrangehrmHomePage orangehrmHomePage=new OrangehrmHomePage(driver);
			orangehrmHomePage.clickAdminTab();
			OrangehrmSystemUsersPage orangehrmSystemUsersPage=new OrangehrmSystemUsersPage(driver);
			orangehrmSystemUsersPage.clickAddButton();
			OrangehrmAddUserPage orangehrmAddUserPage=new OrangehrmAddUserPage(driver);
			orangehrmAddUserPage.enterUserDetails("Andrew Daley", "AndrewDaley10", "abcd", "abcd");
			orangehrmSystemUsersPage.waitForsystemUsersHeader();
			logger.error("---------Testing Error Method---------");
			orangehrmSystemUsersPage.logout();
			
		}
		catch (InterruptedException e) {

			e.printStackTrace();
			logger.error(e.getMessage());
		}

	}

}
