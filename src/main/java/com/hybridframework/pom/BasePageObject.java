package com.hybridframework.pom;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePageObject {
	
	protected WebDriver driver;
	
	protected BasePageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
}
