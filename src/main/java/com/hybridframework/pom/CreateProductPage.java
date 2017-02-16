package com.hybridframework.pom;

import com.hybridframework.utils.Browser;

public class CreateProductPage extends BasePage
{
	public CreateProductPage(Browser browser)
	{
		super(browser);
	}
	
	public String getPageTitle()
	{
		return browser.getTitle();
	}
}
