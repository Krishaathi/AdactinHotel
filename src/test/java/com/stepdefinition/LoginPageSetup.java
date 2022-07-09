package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

//import org.testng.Assert;

import com.base.BaseClass;
import com.pageobject.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * 
 * @author Aadhi
 * @Description  Login with all credential
 * @Creation Date :25/6/22
 */
public class LoginPageSetup extends BaseClass {
	PageObjectManager pom = new PageObjectManager();
/**
 * 	
 * @throws FileNotFoundException
 * @throws IOException
 */
	@Given("User is on the Adactinhotel Page")
	public void userIsOnTheAdactinhotelPage() throws FileNotFoundException, IOException {
		
	}
/**
 * 
 * @param username
 * @param password
 * @throws FileNotFoundException
 * @throws IOException
 * @throws AWTException
 * @Creation Date : 25/6/22
 * @Description User Sholud Login with
 * 
 */
	@When("User should Login  with {string}, {string}")
	public void userShouldLoginWith(String username, String password) throws FileNotFoundException, IOException, AWTException {
		pom.getLoginPage().LoginPage(username,password);
	}
	/**
	 * 
	 * @param username
	 * @param password
	 * @throws AWTException
	 * @Creation Date:26/6/22
	 * @Description Login with Enter Keys
	 * 
	 */
	@When("User should login with Enter Key {string},{string}")
	public void userShouldLoginWithEnterKey(String username, String password) throws AWTException {
		pom.getLoginPage().loginWithEnterKey(username, password);
	}
	/**
	 * 
	 * @param message
	 * @Description Verifying the error message at login page
	 * @Creation Date:26/6/22
	 */

	@Then("User should verify after login get error message contains {string}")
	public void userShouldVerifyAfterLoginGetErrorMessageContains(String message) {
		String text = getText(pom.getLoginPage().getVerifymessage());
		Assert.assertTrue("hy",text.contains(message));
		System.out.println(text);
	}

}
