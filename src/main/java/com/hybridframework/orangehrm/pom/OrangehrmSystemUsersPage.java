package com.hybridframework.orangehrm.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hybridframework.utils.WaitTool;
import com.hybridframework.utils.ConfigProperty.ConfigTimeout;

public class OrangehrmSystemUsersPage extends BasePageObject {

	@FindBy(xpath="//h1[contains(text(),'System Users')]")
	private WebElement systemUsersHeader;

	@FindBy(id="btnAdd")
	private WebElement addButton;

	@FindBy(id="searchSystemUser_userName")
	private WebElement userNameTextBox;

	@FindBy(id="searchBtn")
	private WebElement searchButton;

	@FindBy(id="btnDelete")
	private WebElement deleteButton;

	@FindBy(id="dialogDeleteBtn")
	private WebElement deleteOkButton;

	public OrangehrmSystemUsersPage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, ExpectedConditions.visibilityOf(systemUsersHeader),
				ConfigTimeout.TIMEOUT_VALUE.getPropertyAsInt());
		System.out.println("Landed in OrangehrmSystemUsersPage");

	}

	public void clickAddButton() {
		addButton.click();
	}

	public void waitForsystemUsersHeader() {
		WaitTool.waitFor(driver, ExpectedConditions.visibilityOf(systemUsersHeader), 30);

	}

	public void searchAndDeleteUser(String uName) {
		userNameTextBox.sendKeys(uName);
		searchButton.click();
		
		WebElement checkBox=driver
				.findElement(By.xpath("//a[contains(text(),'" + uName + "')]/../..//input[@type='checkbox']"));
		
		WaitTool.waitFor(driver, ExpectedConditions.visibilityOf(checkBox), 30);
		
		checkBox.click();
		deleteButton.click();
		deleteOkButton.click();
		waitForsystemUsersHeader();

	}

}
