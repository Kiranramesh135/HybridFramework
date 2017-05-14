package com.hybridframework.orangehrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hybridframework.utils.WaitTool;
import com.hybridframework.utils.ConfigProperty.ConfigTimeout;

public abstract class BasePageObject {

	protected WebDriver driver;

	@FindBy(id = "btnLogin")
	private WebElement loginButton;

	@FindBy(id = "welcome")
	private WebElement welcome;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	private WebElement logoutLink;

	protected BasePageObject(WebDriver driver) {
		System.out.println("Inside basepageobject constructor");
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void logout() {
		welcome.click();
		WaitTool.waitFor(driver, ExpectedConditions.visibilityOf(logoutLink), 30);
		logoutLink.click();
		WaitTool.waitFor(driver, ExpectedConditions.visibilityOf(loginButton), 30);

	}

}
