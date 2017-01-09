package com.epam.cnta.webdriver.demo2.lection_demo_native_page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GitHubHomePage {

	@FindBy(linkText = "Sign in")
	private WebElement signInBtn;

	public void openSignInPage() {
		// click the "button" input element created by link text
		signInBtn.click();
	}
}
