package com.hybridframework.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

	public WebDriver driver;
	public Logger logger = new LogFactory().getLogger();

	public WebDriver setup(WebDriver driver) {

		logger = LogManager.getLogger(this.getClass());

		try {

			if (driver == null) {

				DesiredCapabilities capabilities = null;

				if (getOSType().contains("Windows")) {
					logger.info("----------Setting chrome driver path for Windows...----------");

					System.setProperty("webdriver.chrome.driver",
							"src/main/resources/chrome-executables/chromedriver_win32/chromedriver.exe");
					logger.info("Found chrome driver exe in the below mentioned path");
					logger.info(System.getProperty("webdriver.chrome.driver"));

				}
				else if (getOSType().contains("Mac")) {

					if (Utilities.getPropertyValue("browserType").equalsIgnoreCase("chrome")) {

						capabilities = DesiredCapabilities.chrome();
						ChromeOptions options = new ChromeOptions();
						options.addArguments("start-maximized");

						// to disable save password popup
						options.addArguments("chrome.switches",
								"--disable-extensions --disable-extensions-file-access-check "
										+ "--disable-extensions-http-throttling --disable-infobars --enable-automation --start-maximized");
						Map<String, Object> prefs = new HashMap<String, Object>();
						prefs.put("credentials_enable_service", false);
						prefs.put("profile.password_manager_enabled", false);
						options.setExperimentalOption("prefs", prefs);

						// to disable 'chrome is being controlled by automated
						// test software'
						options.addArguments("disable-infobars");

						logger.info("etting Chrome driver path for MAC...");
						System.setProperty("webdriver.chrome.driver",
								"src/main/resources/executables/chrome/chromedriver_mac64/chromedriver");
						Utilities.executeCMD(
								"chmod +x " + "src/main/resources/executables/chrome/chromedriver_mac64/chromedriver");
						logger.info(System.getProperty("webdriver.chrome.driver"));

						capabilities.setCapability(ChromeOptions.CAPABILITY, options);
						driver = new ChromeDriver(capabilities);

					}
					else if (Utilities.getPropertyValue("browserType").equalsIgnoreCase("firefox")) {

						// There are issues related to firefox driver for mac
						// os, this code is not complete
						// capabilities = DesiredCapabilities.firefox();
						// FirefoxOptions options = new FirefoxOptions();
						// options.addArguments("start-maximized");
						
						
						logger.info("Setting Firefox driver path for MAC...");
						System.setProperty("webdriver.gecko.driver",
								"src/main/resources/executables/firefox/firefoxdriver_mac/geckodriver");
						Utilities.executeCMD(
								"chmod +x " + "src/main/resources/executables/firefox/firefoxdriver_mac/geckodriver");
						// capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS,
						// options);
						driver = new FirefoxDriver(capabilities);

					}
				}

				driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
				driver.get(Utilities.getPropertyValue("url"));
				Dimension d = new Dimension(1440, 900);
				Point p = new Point(0, 0);
				logger.info("Maximising browser");
				driver.manage().window().setPosition(p);
				driver.manage().window().setSize(d);

				this.driver = driver;
				return this.driver;
			}
			else {
				return this.driver;
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			logger.error("Something went wrong", e);
			
		}

		return this.driver;
	}

	public String getOSType() {
		logger.info ("Operating System = "+System.getProperty("os.name"));
		return System.getProperty("os.name");
	}

	public void destroyDriver() {
		driver.quit();
		driver = null;
	}
}
