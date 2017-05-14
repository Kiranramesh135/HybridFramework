package com.hybridframework.orangehrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hybridframework.utils.WaitTool;
import com.hybridframework.utils.ConfigProperty.ConfigTimeout;

public class OrangehrmPersonalDetailsPage extends BasePageObject {

	@FindBy(xpath = "//h1[contains(text(),'Personal Details')]")
	private WebElement personalDetailsHeader;

	public OrangehrmPersonalDetailsPage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, ExpectedConditions.visibilityOf(personalDetailsHeader),
				ConfigTimeout.TIMEOUT_VALUE.getPropertyAsInt());
	}

}
