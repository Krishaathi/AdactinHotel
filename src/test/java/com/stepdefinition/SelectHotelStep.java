package com.stepdefinition;
import org.junit.Assert;


import com.base.BaseClass;
import com.pageobject.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * 
 * @author Aadhi
 * @Description User verifying the select hotel page with all credentials
 * @Creation Date 28/6/22
 * 
 */
public class SelectHotelStep extends BaseClass{
	PageObjectManager pom = new PageObjectManager();
	/**
	 * @Description Select the all details after search hotel
	 */
	@Then("User should Select the Hotel and continue After successfully search")
	public void userShouldSelectTheHotelAndContinueAfterSuccessfullySearch() {
		pom.getSelectAHotelPage().selectAHotel();

	}
	/**
	 * 
	 * @param verifyMessage
	 * 
	 */
	@Then("User should after verify successfully select hotel get message {string}")
	public void userShouldAfterVerifySuccessfullySelectHotelGetMessage(String verifyMessage) {
		String text = getText(pom.getSelectAHotelPage().getVerifymessage());
		Assert.assertTrue("hy", text.contains(verifyMessage));
		System.out.println(text);
	}
	/**
	 * @Description Select the button without select any details 
	 */
	@Then("User should without Select the Hotel and continue After successfully search")
	public void userShouldWithoutSelectTheHotelAndContinueAfterSuccessfullySearch() {
		pom.getSelectAHotelPage().selectcontinue();
	}
	/**
	 * 
	 * @param verifyerrormessage
	 * @Description Verifying the error message at select hotel page
	 * @Creation Date 28/6/22
	 * 
	 */

	@Then("User should  verify after  continue get Error message {string}")
	public void userShouldVerifyAfterContinueGetErrorMessage(String verifyerrormessage) {
		String text = getText(pom.getSelectAHotelPage().getVerifyerrormessage());
		Assert.assertTrue("hy", text.contains(verifyerrormessage));
		System.out.println(text);
		

	}


}
