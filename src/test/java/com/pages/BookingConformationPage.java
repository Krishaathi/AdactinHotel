package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookingConformationPage extends BaseClass {
	public BookingConformationPage() {
		PageFactory.initElements(driver, this);
	}
@FindBy(id="order_no")
private WebElement txtorderno;

@FindBy(xpath="//td[text()='Booking Confirmation ']")
private WebElement verifymessage;


public WebElement gettxtorderno() {
	return txtorderno;
}
public WebElement getVerifymessage() {
	return verifymessage;
}
//public String bookingCoformation() {
//	String orderId = getAttribute(gettxtorderno());
//	return orderId;
 
//}
public String getOrderId() {
	String orderId = getAttribute(gettxtorderno());
	return orderId;
}
	
}
