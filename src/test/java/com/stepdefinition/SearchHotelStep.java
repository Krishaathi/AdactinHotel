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
 * @Description Search the hotel with all credential
 * @Creation Date 27/6/22
 */
public class SearchHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();
/**
 * 
 * @param Location
 * @param Hotel
 * @param Roomtype
 * @param Numberofrooms
 * @param Checkindate
 * @param Checkoutdate
 * @param Adult
 * @param Children
 * @Description User Select the all details
 * @Creation Date 27/6/22
 *  
 */
	@Then("User should  Search the Hotel after Sucessfully Login with {string},{string},{string},{string},{string},{string},{string}and{string}")
	public void userShouldSearchTheHotelAfterSucessfullyLoginWithAnd(String Location, String Hotel, String Roomtype,
			String Numberofrooms, String Checkindate, String Checkoutdate, String Adult, String Children) {

		pom.getSearchHotelPage().searchHotels(Location, Hotel, Roomtype, Numberofrooms, Checkindate, Checkoutdate,
				Adult, Children);

	}
/**
 * 
 * @param verifyMessage
 * @Description User get the verifing message
 */
	@Then("User should after verify successfully search message with {string}")

	public void userShouldAfterVerifySuccessfullySearchMessageWith(String verifyMessage) {

                     String text = getText(pom.getSearchHotelPage().getVerifyMessage());
                     Assert.assertEquals("hy", verifyMessage, text);
                     
	}
/**
 * 
 * @param Location
 * @param Numberofrooms
 * @param Checkindate
 * @param Checkoutdate
 * @param Adult
 * @Description Mandatory Details only performed
 */
	@Then("User should Search the Hotel after Sucessfully Login with Mandatory details {string},{string},{string},{string}and{string}")
	public void userShouldSearchTheHotelAfterSucessfullyLoginWithMandatoryDetailsAnd(String Location,
			String Numberofrooms, String Checkindate, String Checkoutdate, String Adult) {
		pom.getSearchHotelPage().searchHotels(Location, Numberofrooms, Checkindate, Checkoutdate, Adult);

	}
	/**
	 * 
	 * @param getCheckInError
	 * @param getCheckOutError
	 * @Descreption Verifying the Check in Check out Dates Error message
	 * 
	 */
	@Then("User should after verify  search get Error message  {string} ,{string}")
	public void userShouldAfterVerifySearchGetErrorMessage(String getCheckInError, String getCheckOutError) {
		
//		implicitWait(30);
		String checkin = getText(pom.getSearchHotelPage().getCheckINError());
		 Assert.assertEquals("hy", getCheckInError, checkin);
		 
		 String checkout = getText(pom.getSearchHotelPage().getCheckOutError());
		 Assert.assertEquals("hy", getCheckOutError, checkout);

	}
	/**
	 * @Description Click the search button without select all details
	 *  
	 */
	@Then("User should Search the Hotel without select details after Sucessfully Login")
	public void userShouldSearchTheHotelWithoutSelectDetailsAfterSucessfullyLogin() {
		pom.getSearchHotelPage().searchHotels();
	}
	/**
	 * @Description Verifying the error message at search hotel page
	 * Creation Date 27/6/22
	 */
	@Then("User should after verify  search get Error message {string}")
	public void userShouldAfterVerifySearchGetErrorMessage(String locationError) {
		
		String location = getText(pom.getSearchHotelPage().getLocationError());
		 Assert.assertEquals("hy", locationError, location);

		
	}}
