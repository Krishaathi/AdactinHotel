package com.stepdefinition;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.base.BaseClass;
import com.pageobject.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * 
 * @author Aadhi
 * @Description Book hotel with all credential
 * @Creation Date 28/6/22
 *  
 */
public class BookingHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param address
	 * @param dataTable
	 * @Description Select the booking hotel details after selecting hotels
	 * @creation Date 28/6/22
	 */
	@Then("User should Book the Hotel after successfully select hotel  using {string},{string},{string} and save the generated orderId")
	public void userShouldBookTheHotelAfterSuccessfullySelectHotelUsingAndSaveTheGeneratedOrderId(String firstname,
			String lastname, String address, io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> m = dataTable.asMaps();

		pom.getBookingPage().bookHotel(firstname, lastname, address, m.get(2).get("creditcardnumber"),
				m.get(2).get("creditcardtype"), m.get(2).get("expirymonth"), m.get(2).get("expiryyear"),
				m.get(2).get("cvv"));

	}
	/**
	 * 
	 * @param VerifyMessage
	 * @Description Get the message after successfully book the hotel
	 * Creation Date 28/6/22
	 */
	@Then("User should verify after Sucessfully Book hotel get message {string}")
	public void userShouldVerifyAfterSucessfullyBookHotelGetMessage(String VerifyMessage) {

//		System.out.println(getText(pom.getBookingPage().getVerrifyMessage()));
		String verifymsg = getText(pom.getBookingPage().getVerrifyMessage());
//		Assert.assertEquals("verify", VerifyMessage, verifymsg);

	}
	/**
	 * @Description Click the search button without select all details
	 */
	@Then("User Should Book the Hotel after successfully without filling details")
	public void userShouldBookTheHotelAfterSuccessfullyWithoutFillingDetails() {
		pom.getBookingPage().bookHotel();

	}
	/**
	 * 
	 * @param FirstnameError
	 * @param LastnameError
	 * @param AddressError
	 * @param CcNumError
	 * @param CcTypeError
	 * @param CcExpiryError
	 * @param CvvError
	 * @Descriprion Verifying the error message at booking hotel page 
	 */
	@Then("User should after verify Book hotel get error message {string},{string},{string},{string},{string},{string}and{string}")
	public void userShouldAfterVerifyBookHotelGetErrorMessageAnd(String FirstnameError, String LastnameError,
			String AddressError, String CcNumError, String CcTypeError, String CcExpiryError, String CvvError) {

		String firstname = getText(pom.getBookingPage().getFirstnameError());
		Assert.assertEquals("verified", FirstnameError, firstname);

		String lastname = getText(pom.getBookingPage().getLastnameError());
		Assert.assertEquals("verified", LastnameError, lastname);
		String address = getText(pom.getBookingPage().getAddressError());
		Assert.assertEquals("verified", AddressError, address);
		String cardnumber = getText(pom.getBookingPage().getCcNumError());
		Assert.assertEquals("verified", CcNumError, cardnumber);
		String cardtype = getText(pom.getBookingPage().getCcTypeError());
		Assert.assertEquals("verified", CcTypeError, cardtype);
		String expiry = getText(pom.getBookingPage().getCcExpiryError());
		Assert.assertEquals("verified", CcExpiryError, expiry);
		String cvv = getText(pom.getBookingPage().getCvvError());
		Assert.assertEquals("verified", CvvError, cvv);

	}

}
