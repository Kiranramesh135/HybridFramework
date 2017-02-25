package com.hybridframework.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.hybridframework.utils.ConfigProperty.ConfigTimeout;
import com.hybridframework.utils.WaitTool;

public class VtigerLoginPage extends BasePageObject {

	@FindBy(id = "username")
	public WebElement userName;
	@FindBy(id = "password")
	public WebElement password;
	@FindBy(xpath = "//div[@id='forgotPassword']/button")
	public WebElement signIn;

	public VtigerLoginPage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, ExpectedConditions.visibilityOf(signIn),
		        ConfigTimeout.TIMEOUT_VALUE.getPropertyAsInt());
	}

	public void login(String username, String pwd) {
		// Entered user name
		userName.sendKeys(username);
		// Entered password
		password.sendKeys(pwd);
		// Click on sign in button
		signIn.click();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
}
