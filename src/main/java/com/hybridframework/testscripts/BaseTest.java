package com.hybridframework.testscripts;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.hybridframework.utils.Browser;


public class BaseTest {
	public Browser browser;


	@BeforeSuite
	public void preCondition() {
//		browser = Browser.getInstance();
		
	}

	@AfterSuite
	public void postCondition()
	{
		
		browser.quit();
	}

}
