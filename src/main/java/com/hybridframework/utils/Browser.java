package com.hybridframework.utils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Browser
{
	public WebDriver driver;
	
	static String  url = ConfigReader.getValue("url");
	
	private static Browser instance = null;
	
	private Browser(String url)
	{	
		System.setProperty("webdriver.chrome.driver", "E:\\My_WorkSpace\\HybridFramework\\Drivers\\chromedriver_win32\\chromedriver.exe");
//		driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static Browser getInstance()
	{
		if(instance==null)
		{
			instance = new Browser(url);
		}
		return instance;
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}
	
	//To open Url
	public void openUrl(String url)
	{
		System.out.println("Opening url : "+url);
		driver.get(url);
	}
	
	//To Change to new active tab
	public void changeToNewActiveWindow()
	{
		try
		{
//			driver.wait(20);
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			System.out.println(tabs);
			driver.switchTo().window(tabs.get(0));
			System.out.println("Switched to new active window");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//To get page title
	public String getTitle()
	{
		String Title = driver.getTitle();
		return Title;
	}
	
	public String getText(WebElement element)
	{
		return element.getText();
		
	}
	
	public void click(WebElement element)
	{
		element.click();
	}
	
	public void clear(WebElement element)
	{
		element.clear();
	}
	
	public void enterData(WebElement element, String data)
	{
		element.sendKeys(data);
	}
	
	//To verify whether element is present or not
/*	public WebElement getElement(String locator, String element)
	{
		By byElement;
		WebElement webElement;
		switch (locator)
		{
			case "xpath":					byElement = By.xpath(element);
			break;
			
			case "id":						byElement = By.id(element);
			break;
			
			case "name":					byElement = By.name(element);
			break;

			case "className":				byElement = By.className(element);
			break;
			
			case "linkText":				byElement = By.linkText(element);
			break;
			
			case "partialLinkText":			byElement = By.partialLinkText(element);
			break;
			
			case "tagName":					byElement = By.tagName(element);
			break;
			
			case "cssSelector":				byElement = By.cssSelector(element);
			break;
			
			default:						throw new RuntimeException("Invalid locator");
			
		}
		
		try
		{
			webElement = driver.findElement(byElement);
			return webElement;
		}
		catch(ElementNotFoundException e)
		{
			return webElement = null;
//			System.out.println("Element not found "+e);
		} 
		catch(NoSuchElementException e)
		{
			return webElement = null;	
		}
	}*/
	
	public void selectDropDownValue(WebElement element, String visibleText)
	{
		Select select = new Select(element);
		select.deselectByVisibleText(visibleText);
	}
	
	//To close all browser instances
	public void quit()
	{
		driver.quit();
	}

	
	
}
