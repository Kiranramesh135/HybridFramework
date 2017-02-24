package com.hybridframework.utils;

import java.io.File;
import java.net.URI;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;


/**
 * Created by sadupa on 7/26/14.
 */
public class LogDemo {
	
	

	public static void main(String[] args){
    	
    	try
    	{
    		
    		/*File file = new File("src/main/resources/config/log4j2.xml");
    		context.setConfigLocation(file.toURI());
    		Logger logger = LogManager.getLogger(LogDemo.class);*/
    		
//    		2nd implementation
    		
    		 
    		/*LoggerContext context = (LoggerContext) LogManager.getContext(false);
    		ConfigurationSource source = new ConfigurationSource(new FileInputStream("src/main/resources/config/log4j2.xml"));
    		XmlConfiguration xmlConfig = new XmlConfiguration(context, source);
    		LoggerContext.getContext().start(xmlConfig); 
    		Logger logger = (Logger) LogManager.getLogger(LogDemo.class);*/
    		
    		
    		/*File f = new File("src/main/resources/config/log4j2.xml");
    		java.net.URI fc = f.toURI();         
    		System.out.println("Loading logging config file: " + fc);
    		Logger logger = (Logger) LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    		LoggerContext.getContext().setConfigLocation(fc);
    		
    		
    		
    		logger.info("info");
    		logger.error("error"); */
    		
    		readconfig();
        
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    		e.printStackTrace();
    		
    	}
    }
	
	public static void readconfig()
	{
		//Type 1 
		System.out.println("1");
		File f = new File("src/main/resources/config/log4j2.xml");
		System.out.println("2");
		URI fc = f.toURI();         
		System.out.println("3");
		Logger logger = (Logger) LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
		System.out.println("4");
		LoggerContext.getContext().setConfigLocation(fc);
		
		logger.debug("this is a debug log message");
	    logger.info("this is a information log message");
	    logger.warn("this is a warning log message");
	    logger.error("this is a error log message");
	    
		

	 
	      
		
		
	}
}
