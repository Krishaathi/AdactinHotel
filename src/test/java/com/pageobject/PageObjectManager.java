package com.pageobject;

import com.pages.BookingConformationPage;
import com.pages.BookingPage;
import com.pages.CancelBookingPage;
import com.pages.LoginPage;
import com.pages.SearchHotelPage;
import com.pages.SelectAHotelPage;
import com.stepdefinition.CancelBookingStep;

public class PageObjectManager {
private LoginPage loginPage;
private SearchHotelPage searchHotelPage;
private SelectAHotelPage selectAHotelPage;
private BookingPage bookingPage;
private BookingConformationPage bookingConformationPage;
private CancelBookingPage cancelbookingpage;

public CancelBookingPage getCancelbookingpage() {
	return (cancelbookingpage==null)?cancelbookingpage=new CancelBookingPage():cancelbookingpage;
}
public LoginPage getLoginPage() {
	return (loginPage==null)?loginPage=new LoginPage():loginPage;
}
public SearchHotelPage getSearchHotelPage() {
	return (searchHotelPage==null)?searchHotelPage=new SearchHotelPage():searchHotelPage;
}
public SelectAHotelPage getSelectAHotelPage() {
	return (selectAHotelPage==null)?selectAHotelPage=new SelectAHotelPage():selectAHotelPage;
}
public BookingPage getBookingPage() {
	return (bookingPage==null)?bookingPage=new BookingPage():bookingPage;
}
public BookingConformationPage getBookingConformationPage() {
	return (bookingConformationPage==null)?bookingConformationPage =new BookingConformationPage():bookingConformationPage;
}




}
