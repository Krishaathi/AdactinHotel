package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SelectAHotelPage extends BaseClass {
	public SelectAHotelPage() {
		PageFactory.initElements(driver, this);
	}
@FindBy(id="radiobutton_0")
private WebElement btnradio;
@FindBy(id="continue")
private WebElement btncontinue;
@FindBy(xpath="//td[text()='Book A Hotel ']")
private WebElement verifymessage;
@FindBy(xpath="//label[text()='Please Select a Hotel']")
private WebElement verifyerrormessage;


public WebElement getVerifyerrormessage() {
	return verifyerrormessage;
}
public WebElement getVerifymessage() {
	return verifymessage;
}
public WebElement getBtnradio() {
	return btnradio;
}
public WebElement getBtncontinue() {
	return btncontinue;
}

public void selectAHotel() {
	click(getBtnradio());
	click(getBtncontinue());
}
public void selectcontinue() {
	click(getBtncontinue());

}
}
