package com.hybridframework.testscripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybridframework.orangehrm.pom.OrangehrmHomePage;
import com.hybridframework.orangehrm.pom.OrangehrmLoginPage;
import com.hybridframework.orangehrm.pom.OrangehrmSystemUsersPage;
import com.hybridframework.utils.ExcelReader;
import com.relevantcodes.extentreports.LogStatus;

public class OrangehrmDeleteUser extends BaseTestNG {

	@Test(groups = "Test1", dataProvider = "getUserDetails")
	public void deleteUser(String uName) {
		try {

			OrangehrmLoginPage orangecrmLoginPage = new OrangehrmLoginPage(driver);
			logger.info("---------Opening Login Page---------");
			test.assignCategory("Sample Test2");
			test.log(LogStatus.PASS, "Opening Login Page");
			orangecrmLoginPage.login("Admin", "admin");
			OrangehrmHomePage orangehrmHomePage = new OrangehrmHomePage(driver);
			orangehrmHomePage.clickAdminTab();
			logger.info("---------Clicked on admin tab---------");
			OrangehrmSystemUsersPage orangehrmSystemUsersPage = new OrangehrmSystemUsersPage(driver);
			test.log(LogStatus.PASS, "Opening system users page");
			orangehrmSystemUsersPage.searchAndDeleteUser(uName);
			orangehrmSystemUsersPage.logout();

		}
		catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());

		}
	}

	@DataProvider
	public Object[][] getUserDetails() {

		Object[][] objArray = ExcelReader.readData("deleteUser");
		return objArray;

	}

}
