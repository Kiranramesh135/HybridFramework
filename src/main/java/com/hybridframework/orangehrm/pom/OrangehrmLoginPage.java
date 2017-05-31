package com.hybridframework.orangehrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hybridframework.utils.WaitTool;

public class OrangehrmLoginPage extends BasePageObject {

	@FindBy(id = "txtUsername")
	private WebElement userName;

	@FindBy(id = "txtPassword")
	private WebElement password;

	@FindBy(id = "btnLogin")
	private WebElement loginButton;

	public OrangehrmLoginPage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, ExpectedConditions.visibilityOf(loginButton),
				60);
		System.out.println("Landed in OrangehrmLoginPage");
	}
	
	public void login(String uName, String pwd) {
		userName.sendKeys(uName);
		password.sendKeys(pwd);
		loginButton.click();
	}

}
