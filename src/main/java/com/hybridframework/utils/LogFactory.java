package com.hybridframework.utils;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

public class LogFactory {
	
	private Logger logger;
	
	public LogFactory() {
		LoggerContext context = (LoggerContext) LogManager.getContext(false);
		File file = new File("src/main/resources/config/log4j2.xml");
		context.setConfigLocation(file.toURI());
		logger = LogManager.getLogger(this.getClass());
	}
	
	public Logger getLogger() {
		return logger;
	}
}
