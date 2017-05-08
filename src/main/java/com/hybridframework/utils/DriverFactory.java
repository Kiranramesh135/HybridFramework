package com.hybridframework.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
	
	public WebDriver driver;
	
	public WebDriver setup(WebDriver driver) {
		if (driver == null) {
			
			// TODO Browser and OS specific driver instantiation to be added
			// here

			final URI uri;
			final URI exe;

//			System.getProperty(key)
			System.setProperty("webdriver.chrome.driver",
			        "src/main/resources/chrome-executables/chromedriver_win32/chromedriver");

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");

			if(getOSType().contains("Windows"))
			{
				System.out.println("Setting chrome driver path for Windows...")
						

			}

			System.setProperty("webdriver.chrome.driver",
			        "src/main/resources/chrome-executables/chromedriver_win32/chromedriver.exe");


			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
			driver.get(Utilities.getPropertyValue("url"));
			driver.manage().window().maximize();
			this.driver = driver;
			return this.driver;
		}
		else {
			return this.driver;
		}
	}

	public String getOSType(){
		System.out.println(System.getProperty("os.name") );
		return System.getProperty("os.name");
	}
	
	
	
	public void destroyDriver() {
		driver.quit();
		driver = null;
	}
}
