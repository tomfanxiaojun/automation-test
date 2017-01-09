package com.epam.cnta.webdriver.ivanfan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage extends BasePage {
	@FindBy(id = "Email")
	private WebElement loginEmailInput;
	@FindBy(id = "next")
	private WebElement loginNextButton;
	@FindBy(id = "Passwd")
	private WebElement loginPasswdInput;
	@FindBy(id = "signIn")
	private WebElement loginButton;
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
   public EmailHomePage login(String email, String password){
	    System.out.println("Typing user login email: " + email);
	    loginEmailInput.clear();
	    loginEmailInput.sendKeys(email);
	    loginNextButton.click();
	    loginPasswdInput.clear();	  
	    System.out.println("Typing user password: " + password);
	    loginPasswdInput.sendKeys(password);
	    loginButton.click();
	    System.out.println("Login is in progress...");	
		return new EmailHomePage(driver);
   }

}
