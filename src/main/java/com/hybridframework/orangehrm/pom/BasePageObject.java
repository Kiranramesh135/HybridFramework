package com.hybridframework.orangehrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePageObject {

	protected WebDriver driver;

	protected BasePageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

}
