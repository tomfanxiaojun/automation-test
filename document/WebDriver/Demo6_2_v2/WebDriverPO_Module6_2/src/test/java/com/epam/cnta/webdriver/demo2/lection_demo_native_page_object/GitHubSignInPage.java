package com.epam.cnta.webdriver.demo2.lection_demo_native_page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GitHubSignInPage {

	@FindBy(id = "login_field")
	private WebElement loginInput;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement pwdInput;

	@FindBy(xpath = "//input[@value='Sign in']")
	private WebElement signInBtn;

	public void loginToGitHub(String login, String password) {
		// Clear text input element created by "id" attribute with a certain value and type the user name there
		loginInput.clear();
		loginInput.sendKeys(login);
		
		// Clear text input element created by xpath expression and type the password there
		pwdInput.clear();
		pwdInput.sendKeys(password);
		
		//Click element created by xpath expression and type the password there
		signInBtn.click();
	}

}
