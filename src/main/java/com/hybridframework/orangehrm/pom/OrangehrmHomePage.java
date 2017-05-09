package com.hybridframework.orangehrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hybridframework.utils.ConfigProperty.ConfigTimeout;
import com.hybridframework.utils.WaitTool;

public class OrangehrmHomePage extends BasePageObject {

	@FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
	private WebElement dashboard;

	public OrangehrmHomePage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, ExpectedConditions.visibilityOf(dashboard),
				ConfigTimeout.TIMEOUT_VALUE.getPropertyAsInt());
	}

}
