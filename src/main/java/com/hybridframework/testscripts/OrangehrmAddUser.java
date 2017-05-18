package com.hybridframework.testscripts;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybridframework.orangehrm.pom.OrangehrmAddUserPage;
import com.hybridframework.orangehrm.pom.OrangehrmHomePage;
import com.hybridframework.orangehrm.pom.OrangehrmLoginPage;
import com.hybridframework.orangehrm.pom.OrangehrmSystemUsersPage;
import com.hybridframework.utils.ExcelReader;
import com.hybridframework.utils.Utilities;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.tools.javah.Util.Exit;

public class OrangehrmAddUser extends BaseTestNG {

	

	

	@Test(groups = "Test1", dataProvider = "getUserDetails")
	public void addUser(String emplName, String uName, String pwd, String confirmPwd) {

		try {

			OrangehrmLoginPage orangecrmLoginPage = new OrangehrmLoginPage(driver);
			logger.info("---------Opening Login Page---------");
			test.assignCategory("Sample Test1");
			test.log(LogStatus.PASS, "Opening Login Page");
			Utilities.takeScreenshot(driver, "LoginPage");
			test.addScreenCapture(Utilities.scrShtFileName);
			orangecrmLoginPage.login("Admin", "admin");
			OrangehrmHomePage orangehrmHomePage = new OrangehrmHomePage(driver);
			test.log(LogStatus.PASS, "Opening Home Page");
			Utilities.takeScreenshot(driver, "HomePage");
			test.addScreenCapture(Utilities.scrShtFileName);
//			test.log(LogStatus.INFO,test.addScreenCapture(Utilities.scrShtFileName));
			test.log(LogStatus.INFO, "test scrsht", Utilities.scrShtFileName);
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
//			test.log(LogStatus.FAIL, "Testing error status");
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
