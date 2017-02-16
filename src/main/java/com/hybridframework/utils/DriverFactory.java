package com.hybridframework.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory
{
	
	public WebDriver driver;
//	public static Browser browser;
	
//	public static WebDriver getDriver()
//	{
//		System.setProperty("webdriver.chrome.driver", "E:\\My_WorkSpace\\MyHybridFramework\\Drivers\\chromedriver_win32\\chromedriver.exe");
//		driver = new ChromeDriver();
//		return driver;
//	}
	
	public WebDriver setup(WebDriver driver)
	{
		// TODO	Browser and OS specific driver instantiation to be added here
    	
    	driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
//		driver.get(url);
		driver.manage().window().maximize();
    	this.driver=driver;
		return driver;
	}
	 

	    public void destroyDriver() {
	    	driver.quit();
	        driver = null;
	    }
	
}
