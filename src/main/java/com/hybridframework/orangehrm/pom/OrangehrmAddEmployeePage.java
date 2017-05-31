package com.hybridframework.orangehrm.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.hybridframework.utils.WaitTool;
import com.hybridframework.utils.ConfigProperty.ConfigTimeout;

public class OrangehrmAddEmployeePage extends BasePageObject {

	@FindBy(xpath = "//h1[contains(text(),'Add Employee')]")
	private WebElement addEmployeeHeader;
	
	@FindBy(id = "firstName")
	private WebElement firstName;
	
	@FindBy(id = "lastName")
	private WebElement lastName;
	
	@FindBy(id = "location")
	private WebElement locationDropDown;
	
	@FindBy(id = "btnSave")
	private WebElement saveButton;
	
	public OrangehrmAddEmployeePage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, ExpectedConditions.visibilityOf(addEmployeeHeader),
				ConfigTimeout.TIMEOUT_VALUE.getPropertyAsInt());
	}
	
	public void addEmployee(String fName, String lName, String location) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		Select select = new Select(locationDropDown);
		select.selectByVisibleText(location);
		saveButton.click();
		System.out.println("");
	}
	

}
