package com.hybridframework.stepdefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(
	features = {"Specifications/"},
	plugin = {"pretty","html:target/cucumber/","json:targer/cucumber_jason"},
	tags = {"@test1"}
//	glue = {"src/com/cucumber/stepdefinitions/"}
	)


public class CucumberRunner
{
	
}
