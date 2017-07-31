package com.hybridframework.orangehrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hybridframework.utils.ConfigProperty.ConfigTimeout;
import com.hybridframework.utils.WaitTool;

public class OrangehrmEmployeeListPage extends BasePageObject {

	@FindBy(xpath = "//h1[contains(text(),'Employee Information')]")
	private WebElement employeeInformationHeader;
	
	@FindBy(id = "btnAdd")
	private WebElement addButton;

	public OrangehrmEmployeeListPage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, ExpectedConditions.visibilityOf(employeeInformationHeader),
				ConfigTimeout.TIMEOUT_VALUE.getPropertyAsInt());

	}
	
	public void clickAddButton() {
		addButton.click();
	}

}
