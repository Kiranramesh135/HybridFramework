package com.hybridframework.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybridframework.utils.Browser;

public class BasePage {
	public Browser browser;

	@FindBy(xpath = "//img[@alt='Home']")
	public WebElement homeButton;

	@FindBy(xpath = "//a[@id='menubar_item_right_Administrator']/strong")
	public WebElement adminButton;

	@FindBy(id = "menubar_item_right_LBL_SIGN_OUT")
	public WebElement signOutButton;

	public BasePage(Browser browser) {
		this.browser = browser;
		PageFactory.initElements(this.browser.driver, this);
	}

	public void clickHomeButton() {
		browser.click(homeButton);
	}

	public void signOut() {
		try {
			browser.click(adminButton);
			Thread.sleep(5000);
			browser.click(signOutButton);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
