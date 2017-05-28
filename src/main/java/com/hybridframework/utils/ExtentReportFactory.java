package com.hybridframework.utils;

import java.io.File;

import org.apache.logging.log4j.Logger;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportFactory {

	public ExtentReports extent;
	public Logger logger = new LogFactory().getLogger();

	public ExtentReports intialize(ExtentReports extent) {

		try {

			if (extent == null) {

				String reportPath = Utilities.OutputFile.getAbsolutePath() + "/ExtentReport.html";
				extent = new ExtentReports(reportPath, true);

				String configPath = System.getProperty("user.dir") + Utilities.getPropertyValue("xtentConfig");
				extent.loadConfig(new File(configPath));
				this.extent = extent;
				return this.extent;
			}
			else {
				return this.extent;
			}

		}
		catch (Exception e) {
			logger.error("Something went wrong",e);

		}
		return this.extent;

	}

}
