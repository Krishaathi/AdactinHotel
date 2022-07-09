package com.stepdefinition;
import java.util.concurrent.TimeUnit;

import org.codehaus.groovy.runtime.callsite.PerInstancePojoMetaClassSite;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BaseClass;
import com.pageobject.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * 
 * @author Aadhi
 * @Description Verifying the order id cancellation
 * @Creation Date 29/6/22
 *
 */
public class CancelBookingStep extends BaseClass {
	private static final String SearchResultError = null;
	PageObjectManager pom = new PageObjectManager();
/**
 * 
 * @throws InterruptedException
 * @Description Generate the order id after booking confirmation
 * 
 */

	@Then("User should cancel generated order id after booking confirmation")
	public void userShouldCancelGeneratedOrderIdAfterBookingConfirmation() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		String orderId= pom.getBookingConformationPage().getOrderId();
		pom.getCancelbookingpage().cancelBooking(orderId);

	}
	/**
	 * 
	 * @param string
	 * @Description Cancel the generate the order id and getting cancellation message
	 * @Date 29/6/22 
	 */
	@Then("User should verify cancel message after cancelling {string}")
	public void userShouldVerifyCancelMessageAfterCancelling(String string) {
		String searcherror = getText(pom.getCancelbookingpage().getSearchResultError());

		System.out.println(searcherror);

//		Assert.assertEquals("verify", SearchResultError, searcherror);
	}
	/**
	 * 
	 * @param orderID
	 * @Description Cancel the existing  order id and getting cancellation message
	 */
	@Then("User should cancel existing order {string} after sucessfully login")
	public void userShouldCancelExistingOrderAfterSucessfullyLogin(String orderID) {
		pom.getCancelbookingpage().cancelBooking(orderID);

    
	
}
	
}
