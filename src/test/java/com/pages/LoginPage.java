package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.pageobject.PageObjectManager;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
@FindBy(id="username")
private WebElement txtUserName;
@FindBy(id="password")
private WebElement txtpassword;
@FindBy(id="login")
private WebElement BtnLogin;
@FindBy(xpath="//div[@class='auth_error']")
private WebElement verifymessage;



public WebElement getVerifymessage() {
	return verifymessage;
}

public WebElement gettxtUserName() {
	return txtUserName;
	
}

public WebElement gettxtpassword() {
	return txtpassword;
	
}

public WebElement getBtnLogin() {
	return BtnLogin;

}


public void LoginPage(String username, String password) {
	type(gettxtUserName(), username);
	type(gettxtpassword(), password);
	click(getBtnLogin());
}

public void loginWithEnterKey(String username, String password) throws AWTException {
	type(gettxtUserName(), username);
	
	type(gettxtpassword(), password);
	Robot robot = new Robot();
	
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_TAB);
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_TAB);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
}
public void LoginPage() {
	click(getBtnLogin());
}


}
