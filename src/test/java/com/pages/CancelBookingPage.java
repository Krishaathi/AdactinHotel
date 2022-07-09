package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class CancelBookingPage extends BaseClass {
	public CancelBookingPage(){
		PageFactory.initElements(driver, this);
	}
	
	public static String orderNum;
	@FindBy(id = "order_no")
	private WebElement orderNo;

	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement btnMyItinerary;

	@FindBy(id = "order_id_text")
	private WebElement txtorderId;
	
//	@FindBy(name="ids[]")
//	private WebElement btnIdClick;

	@FindBy(xpath = "//input[contains(@value,'Cancel ')]")
	private WebElement btnclickcancelorderid;
	
	@FindBy(id = "search_hotel_id")
	private WebElement btnGo;
	
	@FindBy(id = "search_result_error")
	private WebElement searchResultError;
//
//	@FindBy(id = "check_all")
//	private WebElement btnCheckAll;
//
//	@FindBy(id = "//input[@value=\"Cancel Selected\"]")
//	private WebElement btnCancelOrder;

	
//	public WebElement getBtnIdClick() {
//		return btnIdClick;
//	}

	public WebElement getBtnclickcancelorderid() {
		return btnclickcancelorderid;
	}



	public static String getOrderNum() {
		return orderNum;
	}

	public WebElement getOrderNo() {
		return orderNo;
	}

	public WebElement getBtnMyItinerary() {
		return btnMyItinerary;
	}

	public WebElement getTxtorderId() {
		return txtorderId;
	}

	

	public WebElement getBtnGo() {
		return btnGo;
	}



	public WebElement getSearchResultError() {
		return searchResultError;
	}
	
	
	
//	public WebElement getBtnGo() {
//		return btnGo;
//	}
//
//	public WebElement getBtnCheckAll() {
//		return btnCheckAll; 
//	}
//
//	public WebElement getBtnCancelOrder() {
//		return btnCancelOrder;
//	}
	
//  public void cancelBooking() {
//	  click(getTxtorderId());
//	  click(getBtnMyItinerary());
//	  click(getBtnIdClick());
//	  clickOk();
//}

	public void cancelBooking(String orderNo) {
		click(getBtnMyItinerary());
		type(getTxtorderId(), orderNo);
		click(getTxtorderId());
//		click(getBtnIdClick());
		click(getBtnclickcancelorderid());
		clickOk();
		
		
}




	
}
