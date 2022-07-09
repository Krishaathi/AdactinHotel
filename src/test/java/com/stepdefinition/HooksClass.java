package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class HooksClass extends BaseClass{
@Before
public void beforeScenario() throws FileNotFoundException, IOException {
	getDriver(getPropertyFileValue("browser"));
	loadUrl(getPropertyFileValue("url"));
}
@After
public void afterScenario(Scenario scenario) {
	TakesScreenshot screenshot= (TakesScreenshot)driver;
	byte[] bs = screenshot.getScreenshotAs(OutputType.BYTES);
	scenario.embed(bs, "EveryScenario");
	closeAllWindow();
	

}
}
