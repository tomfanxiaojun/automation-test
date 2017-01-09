package com.epam.cnta.webdriver.demo2.additional.native_page_object_with_abstract_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class GitHubAbstractPage {

	protected WebDriver driver;

	public GitHubAbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public boolean isElementPresent(By locator) {
		return driver.findElements(locator).size() > 0;
	}

}
