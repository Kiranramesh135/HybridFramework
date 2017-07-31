package com.hybridframework.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hybridframework.utils.ConfigProperty.ConfigTimeout;
import com.hybridframework.utils.WaitTool;

public class VtigerHomePage extends BasePageObject {
	
	@FindBy(xpath = "//h2[contains(text(),'Home')]")
	private WebElement homeText;
	@FindBy(xpath = "//a[@id='menubar_item_Products']/strong")
	private WebElement productsMenu;
	@FindBy(xpath = "//a[@id='menubar_item_right_Administrator']/strong")
	private WebElement admin;
	@FindBy(xpath = "//a[@id='menubar_item_right_LBL_SIGN_OUT']")
	private WebElement signout;
	@FindBy(xpath = "//div[@id='basicSearchModulesList_chzn']/a/span")
	private WebElement allRecords;
	
	public VtigerHomePage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, ExpectedConditions.visibilityOf(homeText),
		        ConfigTimeout.TIMEOUT_VALUE.getPropertyAsInt());
	}
	
	public void clickProductsMenu() {
		productsMenu.click();
	}
}
