package com.hybridframework.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {

	public static File OutputFile;

	public static void takeScreenshot(WebDriver driver, String filename) {
		// For Local execution
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Using remote webdriver
		// File srcFile = ((TakesScreenshot)new
		// Augmenter().augment(driver)).getScreenshotAs(OutputType.FILE)
		try {

			File scrShtFolder = new File(OutputFile.getAbsolutePath() + "/Screenshots");

			if (!scrShtFolder.exists()) {

				scrShtFolder.mkdir();
			}
			System.out.println(scrShtFolder.getAbsolutePath());
			FileUtils.copyFile(srcFile,
					new File(scrShtFolder.getAbsolutePath() + "/" + filename + System.currentTimeMillis() + ".png"));

		}
		catch (IOException e) {
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
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return value;
	}

	public static void executeCMD(String cmd) {
		String s = null;

		try {

			// run the Unix "ps -ef" command
			// using the Runtime exec method:
			Process p = Runtime.getRuntime().exec(cmd);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			// read the output from the command
			System.out.println("Here is the standard output of the command: \n");
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}

			// read any errors from the attempted command
			System.out.println("Here is the standard error of the command (if any): \n");
			while ((s = stdError.readLine()) != null) {
				System.out.println(s);

			}
		}
		catch (IOException e) {
			System.out.println("exception happened - here's what I know: ");
			e.printStackTrace();

		}

	}

	public static void createResultFolder() {

		try {
			System.out.println("inside createResultFolder() ");

			Date now = new Date();
			SimpleDateFormat timeStamp = new SimpleDateFormat("ddMMyyyyHHmmss");
			String time = timeStamp.format(now);
			String path = System.getProperty("user.dir") + "/src/main/resources/Results/" + time;

			OutputFile = new File(path);
			if (!OutputFile.exists()) {
				System.out.println("a");
				OutputFile.mkdir();
			}
			System.out.println("Creating result folder at location : " + path);

		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
