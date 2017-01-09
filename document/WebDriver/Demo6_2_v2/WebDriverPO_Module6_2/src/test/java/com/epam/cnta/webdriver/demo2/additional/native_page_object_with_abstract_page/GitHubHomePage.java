package com.epam.cnta.webdriver.demo2.additional.native_page_object_with_abstract_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GitHubHomePage extends GitHubAbstractPage {

	@FindBy(linkText = "Sign in")
	private WebElement signInBtn;

	public GitHubHomePage(WebDriver driver) {
		super(driver);
	}

	public GitHubSignInPage openSignInPage() {
		// click the "button" input element created by link text
		signInBtn.click();
		System.out.println("Navigating to signin page...");
		return new GitHubSignInPage(driver);
	}
}
