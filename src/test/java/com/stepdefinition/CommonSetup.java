package com.stepdefinition;
import com.pageobject.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class CommonSetup {
	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should verify successfully login message {string}")
	public void userShouldVerifySuccessfullyLoginMessage(String string) {
	
	}
}
