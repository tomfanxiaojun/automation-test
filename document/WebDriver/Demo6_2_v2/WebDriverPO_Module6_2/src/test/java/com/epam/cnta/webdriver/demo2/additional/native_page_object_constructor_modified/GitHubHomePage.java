package com.epam.cnta.webdriver.demo2.additional.native_page_object_constructor_modified;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GitHubHomePage {

	@FindBy(linkText = "Sign in")
	private WebElement signInBtn;
	private WebDriver driver;

	public GitHubHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public GitHubSignInPage openSignInPage() {
		// click the "button" input element created by link text
		signInBtn.click();
		System.out.println("Navigating to signin page...");
		return new GitHubSignInPage(driver);
	}
}
