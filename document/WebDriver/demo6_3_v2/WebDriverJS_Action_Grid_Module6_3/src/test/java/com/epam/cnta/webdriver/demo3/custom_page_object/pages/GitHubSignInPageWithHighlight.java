package com.epam.cnta.webdriver.demo3.custom_page_object.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.epam.cnta.webdriver.demo3.custom_page_object.DemoTools;

public class GitHubSignInPageWithHighlight {

	private static final String LOGIN_INPUT = "login_field";
	private static final String PWD_INPUT = "//input[@id='password']";
	private static final String SIGNIN_BTN = "//input[@value='Sign in']";
	private WebElement loginInput;
	private WebElement pwdInput;
	private WebElement signInBtn;
	private WebDriver driver;

	public GitHubSignInPageWithHighlight(WebDriver driver) {
		this.driver = driver;
	}

	public GitHubCreateRepoPage loginToGitHub(String login, String password) {
		// Clear text input element created by "id" attribute with a certain
		// value and type the user name there
		System.out.println("Typing user login: " + login);
		loginInput = driver.findElement(By.id(LOGIN_INPUT));
		DemoTools.highlightWithJS(loginInput);
		loginInput.clear();
		loginInput.sendKeys(login);

		// Clear text input element created by xpath expression and type the
		// password there
		System.out.println("Typing user password: " + password);
		pwdInput = driver.findElement(By.xpath(PWD_INPUT));
		DemoTools.highlightWithJS(pwdInput);
		pwdInput.clear();
		pwdInput.sendKeys(password);

		// Click element created by xpath expression and type the password there
		signInBtn = driver.findElement(By.xpath(SIGNIN_BTN));
		DemoTools.highlightWithJS(pwdInput);
		signInBtn.click();
		System.out.println("Login is in progress...");

		return new GitHubCreateRepoPage(driver);

	}

}
