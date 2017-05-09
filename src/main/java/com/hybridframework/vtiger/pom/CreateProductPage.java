package com.hybridframework.vtiger.pom;

import org.openqa.selenium.WebDriver;

public class CreateProductPage extends BasePageObject {
	
	public CreateProductPage(WebDriver driver) {
		super(driver);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
