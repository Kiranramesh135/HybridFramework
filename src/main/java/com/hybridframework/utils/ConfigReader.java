package com.hybridframework.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader
{
	public static String getValue(String key)
	{
		File config = new File("src/main/resources/config/config.properties");
		
		String value=null;
		try
		{
			FileReader reader = new FileReader(config);
			Properties props = new Properties();
			props.load(reader);
			value = props.getProperty(key);	
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return value;
	}
}
