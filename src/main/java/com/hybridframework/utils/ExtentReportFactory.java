package com.hybridframework.utils;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportFactory {

	public ExtentReports extent;

	public ExtentReports intialize(ExtentReports extent) {

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

}
