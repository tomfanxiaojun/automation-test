package com.epam.cnta.webdriver.demo2.additional.custom_page_object_with_abstract_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GitHubHomePage extends GitHubAbstractPage {

	private static final String SIGNIN_BTN_ID = "Sign in";
	private WebElement signInBtn;

	public GitHubHomePage(WebDriver driver) {
		super(driver);
	}

	public GitHubSignInPage openSignInPage() {
		// click the "button" input element created by link text
		signInBtn = driver.findElement(By.linkText(SIGNIN_BTN_ID));
		signInBtn.click();
		System.out.println("Navigating to signin page...");

		return new GitHubSignInPage(driver);
	}
}
