package com.hybridframework.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.hybridframework.orangehrm.pom.OrangehrmAddUserPage;
import com.hybridframework.orangehrm.pom.OrangehrmHomePage;
import com.hybridframework.orangehrm.pom.OrangehrmLoginPage;
import com.hybridframework.orangehrm.pom.OrangehrmSystemUsersPage;
import com.hybridframework.utils.DriverFactory;
import com.hybridframework.utils.LogFactory;
import com.hybridframework.utils.Utilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangehrmAddUserStepDef {

	OrangehrmLoginPage orangehrmLoginPage;
	OrangehrmHomePage orangehrmHomePage;
	OrangehrmSystemUsersPage orangehrmSystemUsersPage;
	OrangehrmAddUserPage orangehrmAddUserPage;
	
	protected static WebDriver driver;
	public Logger logger = new LogFactory().getLogger();
	protected DriverFactory driverFactory;
	
	@Before
	public void preCondition() {
		
		Utilities.createResultFolder();
		logger = LogManager.getLogger(this.getClass());
		logger.info("----------Initializing Browser----------");
		driverFactory = new DriverFactory();
		driver = driverFactory.setup(driver);
		System.out.println("Webdriver = "+driver);
	}
	
	@After
	public void postCondition() {
		
		driverFactory.destroyDriver();
		logger.info("----------Closing Browser----------");
	}

	@Given("^I am on login page$")
	public void i_am_on_login_page() {
		// Write code here that turns the phrase above into concrete actions
		orangehrmLoginPage = new OrangehrmLoginPage(driver);
		logger.info("---------Opening Login Page---------");
		Utilities.takeScreenshot(driver, "LoginPage");

	}

	@And("^enter login credentials$")
	public void enter_login_credentials() {
		// Write code here that turns the phrase above into concrete actions
		orangehrmLoginPage.login("Admin", "admin");
		logger.info("---------Opening Login Page---------");

	}

	@When("^I am on homepage$")
	public void i_am_on_homepage() {
		// Write code here that turns the phrase above into concrete actions
		orangehrmHomePage = new OrangehrmHomePage(driver);
		Utilities.takeScreenshot(driver, "HomePage");

	}

	@And("^navigate to system users page$")
	public void navigate_to_system_users_page() {
		// Write code here that turns the phrase above into concrete actions
		orangehrmHomePage.clickAdminTab();
		orangehrmSystemUsersPage = new OrangehrmSystemUsersPage(driver);
		Utilities.takeScreenshot(driver, "SystemUsersPage");

	}

	@Then("^I enter \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\" details$")
	public void i_add_new_system_user(String emplName, String uName, String pwd, String confirmPwd){
		// Write code here that turns the phrase above into concrete actions
		orangehrmSystemUsersPage.clickAddButton();
		orangehrmAddUserPage = new OrangehrmAddUserPage(driver);
		try {
			orangehrmAddUserPage.enterUserDetails(emplName, uName, pwd, confirmPwd);
		}
		catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Utilities.takeScreenshot(driver, "AddUserPage");
		orangehrmAddUserPage.clickSave();
		try {
			if (orangehrmAddUserPage.getAlreadyExistError().isDisplayed()) {
				Utilities.takeScreenshot(driver, "DuplicateUser");
				orangehrmAddUserPage.logout();
			}
		}
		catch (NoSuchElementException e) {

			orangehrmSystemUsersPage.waitForsystemUsersHeader();
			orangehrmSystemUsersPage.logout();
		}

	}

}
