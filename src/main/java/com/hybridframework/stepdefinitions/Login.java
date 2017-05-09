package com.hybridframework.stepdefinitions;

import com.hybridframework.vtiger.pom.VtigerHomePage;
import com.hybridframework.vtiger.pom.VtigerLoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Login {
	
	// public static Browser browser = DriverFactory.getBrowser();
	public VtigerLoginPage vtigerLoginPage;
	public VtigerHomePage vtigerHomePage;
	
	@Given("^I am on login page$")
	public void i_am_on_login_page() throws Throwable {
		// vtigerLoginPage = new VtigerLoginPage(browser);
	}
	
	@Given("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_username_and_password(String userName, String password) throws Throwable {
		// List<List<String>> data = table.raw();
		// vtigerLoginPage.login(data.get(1).get(0), data.get(1).get(1));
		vtigerLoginPage.login(userName, password);
	}
	
	@Then("^I am on home page$")
	public void i_am_on_home_page() throws Throwable {
		// vtigerHomePage = new VtigerHomePage(browser);
		// System.out.println(vtigerHomePage.getPageTitle());
		// Assert.assertTrue("page title did not match",
		// vtigerHomePage.getPageTitle().equalsIgnoreCase("Home"));
		// SoftAssert sa = new SoftAssert();
		// sa.assertTrue(vtigerHomePage.getPageTitle().equals("abscd"), "page
		// title did not match");
		// sa.assertAll();
		// DriverFactory.destroyDriver();
		// vtigerHomePage.signout();
	}
	
	@Given("^I asdd$")
	public void i_asdd() throws Throwable {
		System.out.println("a");
	}
	
	@Given("^I enter fds$")
	public void i_enter_fds() throws Throwable {
		System.out.println("b");
	}
	
	@Then("^I asfsfds$")
	public void i_asfsfds() throws Throwable {
		System.out.println("c");
	}
}
