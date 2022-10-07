package com.sbiBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rDriver){
		
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
		
	}
	
	@FindBy(name="uid")
	WebElement txtUsername;
	
	@FindBy(name="password")
	WebElement txtUserPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	public void setUsername(String username) {
		txtUsername.sendKeys(username);
	}
	
	public void setPassword(String password) {
		txtUserPassword.sendKeys(password);
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
}
