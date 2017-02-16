package com.hybridframework.testscripts;

import com.hybridframework.pom.VtigerHomePage;
import com.hybridframework.utils.Browser;

public class TestHomePage
{
	Browser browser = Browser.getInstance();
	
	
	public void testHomePage()
	{
		try {
			Thread.sleep(5000);
			VtigerHomePage vtigerHomePage = new VtigerHomePage(browser);
			System.out.println(vtigerHomePage.getText());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
