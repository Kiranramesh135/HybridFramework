package com.hybridframework.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hybridframework.utils.ConfigProperty.ConfigTimeout;
import com.hybridframework.utils.WaitTool;

public class ProductsListPage extends BasePageObject {
	
	@FindBy(id = "Products_listView_basicAction_LBL_ADD_RECORD")
	private WebElement addProductButton;
	@FindBy(xpath = "//strong[contains(text(),'Products List')]/..")
	private WebElement productsListLink;
	
	public ProductsListPage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, ExpectedConditions.visibilityOf(productsListLink),
		        ConfigTimeout.TIMEOUT_VALUE.getPropertyAsInt());
	}
	
	public void clickAddProductsButton() {
		addProductButton.click();
	}
}
