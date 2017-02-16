package com.hybridframework.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hybridframework.utils.Browser;

public class VtigerLoginPage extends BasePage
{
	
	@FindBy(id="username")
	public WebElement userName;

	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(xpath="//div[@id='forgotPassword']/button")
	public WebElement signIn;
	
	
	public VtigerLoginPage(Browser browser)
	{
		super(browser);
	}
	
	public void login(String username, String pwd)
	{
		//Entered user name
		userName.sendKeys(username);
		
		//Entered password
		password.sendKeys(pwd);
		
		//Click on sign in button
		signIn.click();
	}
	
	public String getPageTitle()
	{
		return browser.getTitle();
	}
}

