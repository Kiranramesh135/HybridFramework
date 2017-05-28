package com.hybridframework.orangehrm.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hybridframework.utils.WaitTool;
import com.hybridframework.utils.ConfigProperty.ConfigTimeout;

public class OrangehrmAddUserPage extends BasePageObject {

	@FindBy(xpath = "//h1[contains(text(),'Add User')]")
	private WebElement addUserHeader;

	@FindBy(id = "systemUser_employeeName_empName")
	private WebElement employeeName;

	@FindBy(id = "systemUser_userName")
	private WebElement userName;

	@FindBy(id = "systemUser_password")
	private WebElement password;

	@FindBy(id = "systemUser_confirmPassword")
	private WebElement confirmPassword;

	@FindBy(id = "btnSave")
	private WebElement saveButton;
	
	@FindBy(xpath = "//span[contains(text(),'Already exists')]")
	private WebElement alreadyExistError;
	
	

	public OrangehrmAddUserPage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, ExpectedConditions.visibilityOf(addUserHeader),
				ConfigTimeout.TIMEOUT_VALUE.getPropertyAsInt());
		System.out.println("Landed in OrangehrmAddUserPage");
	}

	public void enterUserDetails(String emplName, String uName, String pwd, String confirmPwd)
			throws InterruptedException {
		employeeName.sendKeys(emplName);
		employeeName.sendKeys(Keys.TAB);
		employeeName.sendKeys(Keys.TAB);
		Thread.sleep(5000);
		userName.sendKeys(uName);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(confirmPwd);

	}

	public void clickSave() {
		saveButton.click();
	}
	
	public WebElement getAlreadyExistError() {
		return alreadyExistError;
	}

}
