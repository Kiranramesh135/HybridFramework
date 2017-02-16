package com.hybridframework.testscripts;

import org.openqa.selenium.WebDriver;

import com.hybridframework.utils.ConfigReader;
import com.hybridframework.utils.DriverFactory;

public class Test {
	
	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		try
		{
			 DriverFactory factory = new DriverFactory();
			 driver = factory.setup(driver);
			 driver.get(ConfigReader.getValue("url"));
		}
		catch(Exception e )
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
