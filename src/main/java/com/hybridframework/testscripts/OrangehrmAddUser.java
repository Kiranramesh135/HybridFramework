package com.hybridframework.testscripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybridframework.orangehrm.pom.OrangehrmAddUserPage;
import com.hybridframework.orangehrm.pom.OrangehrmHomePage;
import com.hybridframework.orangehrm.pom.OrangehrmLoginPage;
import com.hybridframework.orangehrm.pom.OrangehrmSystemUsersPage;
import com.hybridframework.utils.ExcelReader;
import com.hybridframework.utils.Utilities;
import com.sun.tools.javah.Util.Exit;

public class OrangehrmAddUser extends BaseTestNG {

	@Test(groups = "Test1", dataProvider = "getUserDetails")
	public void addUser(String emplName, String uName, String pwd, String confirmPwd) {

		try {

			OrangehrmLoginPage orangecrmLoginPage = new OrangehrmLoginPage(driver);
			logger.info("---------Opening Login Page---------");
			Utilities.takeScreenshot(driver, "LoginPage");
			orangecrmLoginPage.login("Admin", "admin");
			OrangehrmHomePage orangehrmHomePage = new OrangehrmHomePage(driver);
			Utilities.takeScreenshot(driver, "HomePage");
			orangehrmHomePage.clickAdminTab();
			OrangehrmSystemUsersPage orangehrmSystemUsersPage = new OrangehrmSystemUsersPage(driver);
			Utilities.takeScreenshot(driver, "SystemUsersPage");
			orangehrmSystemUsersPage.clickAddButton();
			OrangehrmAddUserPage orangehrmAddUserPage = new OrangehrmAddUserPage(driver);
			orangehrmAddUserPage.enterUserDetails(emplName, uName, pwd, confirmPwd);
			Utilities.takeScreenshot(driver, "AddUserPage");
			orangehrmAddUserPage.clickSave();
			orangehrmSystemUsersPage.waitForsystemUsersHeader();
			logger.error("---------Testing Error Method---------");
			orangehrmSystemUsersPage.logout();

		}
		catch (InterruptedException e) {

			e.printStackTrace();
			logger.error(e.getMessage());

		}
		catch (Exception e) {
			
			Utilities.takeScreenshot(driver, "Exception");
			e.printStackTrace();
			logger.error(e.getMessage());
			
		}

	}

	@DataProvider
	public Object[][] getUserDetails() {

		Object[][] objArray = ExcelReader.readData("userDetails");
		return objArray;

	}

}
