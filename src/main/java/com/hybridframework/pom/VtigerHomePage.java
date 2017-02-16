package com.hybridframework.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hybridframework.utils.Browser;

public class VtigerHomePage extends BasePage
{
	
	
	@FindBy(xpath="//a[@id='menubar_item_Products']/strong")
	public WebElement products;
	
	@FindBy(xpath="//a[@id='menubar_item_right_Administrator']/strong")
	public WebElement admin;
	
	@FindBy(xpath="//a[@id='menubar_item_right_LBL_SIGN_OUT']")
	public WebElement signout;
	
	@FindBy(xpath="//div[@id='basicSearchModulesList_chzn']/a/span")
	private WebElement allRecords;
	
	
	public VtigerHomePage(Browser browser)
	{
		super(browser);
	}
	
	public String getPageTitle()
	{
		return browser.getTitle();
	}
	
	public void clickProducts()
	{
		browser.click(products);
	}
	
	public String getText()
	{
		return browser.getText(allRecords);
	}
	
	public void signout()
	{
		browser.click(admin);
		browser.click(signout);
		
	}
}
