package com.epam.automation.ivanfan.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	@FindBy(id = "Email")
	private WebElement loginEmailInput; 
	@FindBy(id = "Passwd")
	private WebElement loginPasswdInput; 
	public WebElement getLoginEmailInput() {
		return loginEmailInput;
	}
	public void setLoginEmailInput(WebElement loginEmailInput) {
		this.loginEmailInput = loginEmailInput;
	}
	public WebElement getLoginPasswdInput() {
		return loginPasswdInput;
	}
	public void setLoginPasswdInput(WebElement loginPasswdInput) {
		this.loginPasswdInput = loginPasswdInput;
	}


}