package com.hybridframework.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hybridframework.utils.Browser;

public class ProductsListPage extends BasePage
{
	@FindBy(id="Products_listView_basicAction_LBL_ADD_RECORD")
	public WebElement addProductButton;
	
	public ProductsListPage(Browser browser)
	{
		super(browser);
	}
	
	public void clickAddProduct()
	{
		browser.click(addProductButton);
	}
	
	public String getPageTitle()
	{
		return browser.getTitle();
	}
}
