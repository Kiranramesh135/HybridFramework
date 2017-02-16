package com.hybridframework.testscripts;

import com.hybridframework.pom.VtigerLoginPage;
import com.hybridframework.utils.Browser;

public class Test {
	
	static Browser browser = Browser.getInstance();
	
	public static void main(String[] args) {
		VtigerLoginPage vtigerLoginPage = new VtigerLoginPage(browser);
		vtigerLoginPage.login("admin", "1234");
		new TestHomePage().testHomePage();
	}
}
