package com.hybridframework.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WaitTool {
	
	// Instantiation of driver should be changed, declared it here for time
	// being to avoid compilation errors
	// public static WebDriver driver = new FirefoxDriver();
	public static void expliciteWait(WebDriver driver, WebElement element, int timeToWaitInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void impliciteWait(WebDriver driver, int timeToWaitInSec) {
		driver.manage().timeouts().implicitlyWait(timeToWaitInSec, TimeUnit.SECONDS);
	}
	
	public static void waitForPageToLoad(WebDriver driver, long timeOutInSeconds) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState")
				        .equals("complete");
			}
		};
		try {
			System.out.println("Waiting for page to load...");
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(expectation);
		}
		catch (Throwable error) {
			System.out.println("Timeout waiting for Page Load Request to complete after " + timeOutInSeconds
			        + " seconds");
			// Assert.assertFalse(true, "Timeout waiting for Page Load Request
			// to complete.");
		}
	}
	
	public void clickWhenReady(WebDriver driver, By locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public WebElement fluentWait(WebDriver driver, final WebElement webElement, int timeinsec) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		        .withTimeout(timeinsec, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
		        .ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			
			public WebElement apply(WebDriver driver) {
				return webElement;
			}
		});
		return element;
	}
	
	public WebElement getWhenVisible(WebDriver driver, By locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}
	
	public static <V> V waitFor(WebDriver driver, ExpectedCondition<V> expectedCondition,
	        int timeOutInSeconds) {
		System.out.println("Waiting for element to appear");
		return new WebDriverWait(driver, timeOutInSeconds).until(expectedCondition);
	}
}
