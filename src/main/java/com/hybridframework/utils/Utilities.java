package com.hybridframework.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

public class Utilities {

	public static void takeScreenshot(WebDriver driver, String filename) {
//		For Local execution
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		Using remote webdriver
//		File srcFile = ((TakesScreenshot)new Augmenter().augment(driver)).getScreenshotAs(OutputType.FILE)
		try {
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\Screenshots\\"
			        + filename + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getPropertyValue(String key) {

		File config = new File("src/main/resources/config/config.properties");
		String value = null;
		try {
			FileReader reader = new FileReader(config);
			Properties props = new Properties();
			props.load(reader);
			value = props.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return value;
	}
}
