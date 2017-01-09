package com.epam.cnta.webdriver.demo2.additional.native_page_object_with_abstract_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GitHubSignInPage extends GitHubAbstractPage {

	@FindBy(id = "login_field")
	private WebElement loginInput;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement pwdInput;

	@FindBy(xpath = "//input[@value='Sign in']")
	private WebElement signInBtn;

	public GitHubSignInPage(WebDriver driver) {
		super (driver);
	}

	public GitHubCreateRepoPage loginToGitHub(String login, String password) {
		// Clear text input element created by "id" attribute with a certain
		// value and type the user name there
		System.out.println("Typing user login: " + login);
		loginInput.clear();
		loginInput.sendKeys(login);

		// Clear text input element created by xpath expression and type the
		// password there
		System.out.println("Typing user password: " + password);
		pwdInput.clear();
		pwdInput.sendKeys(password);

		// Click element created by xpath expression and type the password there
		signInBtn.click();
		System.out.println("Login is in progress...");
		
		return new GitHubCreateRepoPage(driver);

	}

}
