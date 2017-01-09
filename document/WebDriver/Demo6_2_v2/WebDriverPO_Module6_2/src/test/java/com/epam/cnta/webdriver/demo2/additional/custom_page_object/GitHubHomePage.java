package com.epam.cnta.webdriver.demo2.additional.custom_page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GitHubHomePage {

	private static final String SIGNIN_BTN_ID = "Sign in";
	private WebElement signInBtn;
	private WebDriver driver;

	public GitHubHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public GitHubSignInPage openSignInPage() {
		// click the "button" input element created by link text
		signInBtn = driver.findElement(By.linkText(SIGNIN_BTN_ID));
		signInBtn.click();
		System.out.println("Navigating to signin page...");
		
		return new GitHubSignInPage(driver);
	}
}
