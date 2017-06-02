package com.hybridframework.testscripts;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybridframework.orangehrm.pom.OrangehrmHomePage;
import com.hybridframework.orangehrm.pom.OrangehrmLoginPage;
import com.hybridframework.orangehrm.pom.OrangehrmSystemUsersPage;
import com.hybridframework.utils.DbReader;
import com.hybridframework.utils.ExcelReader;
import com.hybridframework.utils.Utilities;
import com.relevantcodes.extentreports.LogStatus;

public class OrangehrmDeleteUser extends BaseTestNG {

	OrangehrmSystemUsersPage orangehrmSystemUsersPage;

	@Test(groups = "Test1", dataProvider = "getUserDetailsFromDB", priority = -1)
	public void deleteUser(String uName) {
		try {

			test.assignCategory("Sample Test2");
			OrangehrmLoginPage orangecrmLoginPage = new OrangehrmLoginPage(driver);
			logger.info("Landed in LoginPage");
			test.log(LogStatus.PASS, "Opening Login Page");
			Utilities.takeScreenshot(driver, "LoginPage");
			orangecrmLoginPage.login("Admin", "admin");
			logger.info("Entered login credentials");
			test.log(LogStatus.PASS, "Entered Login Credentials");
			OrangehrmHomePage orangehrmHomePage = new OrangehrmHomePage(driver);
			test.log(LogStatus.PASS, "Landed in Home Page");
			Utilities.takeScreenshot(driver, "HomePage");
			orangehrmHomePage.clickAdminTab();
			test.log(LogStatus.PASS, "Clicked on AdminTab");
			logger.info("Clicked on AdminTab");
			orangehrmSystemUsersPage = new OrangehrmSystemUsersPage(driver);
			test.log(LogStatus.PASS, "Landed in SystemUserPage");
			logger.info("Landed in SystemUserPage");
			orangehrmSystemUsersPage.searchAndDeleteUser(uName);
			test.log(LogStatus.PASS, "Searched and deleted user : " + uName);
			orangehrmSystemUsersPage.logout();
			test.log(LogStatus.PASS, "Clicked logout and landed in LoginPage");
			logger.info("Clicked logout and landed in LoginPage");

		}
		catch (NoSuchElementException e) {

			Utilities.takeScreenshot(driver, "UserDoesntExist");
			test.log(LogStatus.FAIL, "User " + uName + " Doesnt Exist");
			logger.error("User " + uName + " Doesnt Exist");
			orangehrmSystemUsersPage.logout();
			logger.info("Clicked logout and landed in LoginPage");

		}
		catch (Exception e) {
			e.printStackTrace();
			logger.error(e);

		}
	}

	@DataProvider
	public Object[][] getUserDetails() {

		Object[][] objArray = ExcelReader.readData("deleteUser");
		return objArray;

	}

	@DataProvider
	public Object[][] getUserDetailsFromDB() {

		Object[][] objArray = DbReader.readDB("userdetail", "username");
		return objArray;
	}

}
