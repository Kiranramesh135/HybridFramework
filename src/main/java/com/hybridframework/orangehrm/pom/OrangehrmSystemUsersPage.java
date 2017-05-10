package com.hybridframework.orangehrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hybridframework.utils.WaitTool;
import com.hybridframework.utils.ConfigProperty.ConfigTimeout;

public class OrangehrmSystemUsersPage extends BasePageObject {

	@FindBy(xpath = "//h1[contains(text(),'System Users')]")
	private WebElement systemUsersHeader;

	@FindBy(id = "btnAdd")
	private WebElement addButton;

	public OrangehrmSystemUsersPage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, ExpectedConditions.visibilityOf(systemUsersHeader),
				ConfigTimeout.TIMEOUT_VALUE.getPropertyAsInt());
		System.out.println("Landed in OrangehrmSystemUsersPage");

	}

	public void clickAddButton() {
		addButton.click();
	}

}
