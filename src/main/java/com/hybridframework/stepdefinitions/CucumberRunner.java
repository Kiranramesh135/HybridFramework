package com.hybridframework.stepdefinitions;

import org.junit.Test;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "resources/Specifications/" }, plugin = { "pretty", "html:target/cucumber/",
        "json:target/cucumber.json" }
//, tags = { "@test1" }
// ,glue = {"helpers","com.hybridframework.stepdefinitions"}
)
public class CucumberRunner {
	
	@Test
	public void dummyTest() {
		System.out.println("Testing maven cucumber runner");
	}
	
}
