package com.hybridframework.testscripts;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybridframework.orangehrm.pom.OrangehrmAddUserPage;
import com.hybridframework.orangehrm.pom.OrangehrmHomePage;
import com.hybridframework.orangehrm.pom.OrangehrmLoginPage;
import com.hybridframework.orangehrm.pom.OrangehrmSystemUsersPage;
import com.hybridframework.utils.DbReader;
import com.hybridframework.utils.ExcelReader;
import com.hybridframework.utils.Utilities;
import com.relevantcodes.extentreports.LogStatus;

public class OrangehrmAddUser extends BaseTestNG {

	@Test(groups = "Test1", dataProvider = "getUserDetailsFromDB")
	public void addUser(String emplName, String uName, String pwd, String confirmPwd) {

		try {

			OrangehrmLoginPage orangecrmLoginPage = new OrangehrmLoginPage(driver);
			logger.info("---------Opening Login Page---------");
			test.assignCategory("Sample Test1");
			test.log(LogStatus.PASS, "Landed in Login Page");
			Utilities.takeScreenshot(driver, "LoginPage");
			//
			orangecrmLoginPage.login("Admin", "admin");
			test.log(LogStatus.PASS, "Entered Login Credential");
			OrangehrmHomePage orangehrmHomePage = new OrangehrmHomePage(driver);
			test.log(LogStatus.PASS, "Landed in Home Page");
			Utilities.takeScreenshot(driver, "HomePage");

			// test.log(LogStatus.INFO,test.addScreenCapture(Utilities.scrShtFileName));
			orangehrmHomePage.clickAdminTab();
			test.log(LogStatus.PASS, "Clicked on AdminTab");
			OrangehrmSystemUsersPage orangehrmSystemUsersPage = new OrangehrmSystemUsersPage(driver);
			Utilities.takeScreenshot(driver, "SystemUsersPage");
			test.log(LogStatus.PASS, "Landed in SysemUserPage");
			orangehrmSystemUsersPage.clickAddButton();
			test.log(LogStatus.PASS, "Clicked AddButton in SystemUserPage");
			OrangehrmAddUserPage orangehrmAddUserPage = new OrangehrmAddUserPage(driver);
			test.log(LogStatus.PASS, "Landed in AddUserPage");
			orangehrmAddUserPage.enterUserDetails(emplName, uName, pwd, confirmPwd);
			test.log(LogStatus.PASS, "Entered details of employee : " + emplName);
			Utilities.takeScreenshot(driver, "AddUserPage");
			orangehrmAddUserPage.clickSave();
			try {
				if (orangehrmAddUserPage.getAlreadyExistError().isDisplayed()) {
					Utilities.takeScreenshot(driver, "DuplicateUser");
					test.log(LogStatus.FAIL, "Duplicate User");
					orangehrmAddUserPage.logout();
				}
			}
			catch (NoSuchElementException e) {

				orangehrmSystemUsersPage.waitForsystemUsersHeader();
				test.log(LogStatus.PASS, "Landed in SysemUserPage");
				orangehrmSystemUsersPage.logout();
				test.log(LogStatus.PASS, "Clicked logout and landed in LoginPage");

			}

		}
		catch (InterruptedException e) {

			e.printStackTrace();
			logger.error("Something went wrong", e);
			test.log(LogStatus.ERROR, e);

		}
		catch (Exception e) {

			Utilities.takeScreenshot(driver, "Exception");
			e.printStackTrace();
			logger.error("Something went wrong", e);
			test.log(LogStatus.ERROR, e);

		}

	}

	@DataProvider
	public Object[][] getUserDetails() {

		Object[][] objArray = ExcelReader.readData("userDetails");
		return objArray;

	}

	@DataProvider
	public Object[][] getUserDetailsFromDB() {
		Object[][] objArray = DbReader.readDB();
		return objArray;
	}

}
