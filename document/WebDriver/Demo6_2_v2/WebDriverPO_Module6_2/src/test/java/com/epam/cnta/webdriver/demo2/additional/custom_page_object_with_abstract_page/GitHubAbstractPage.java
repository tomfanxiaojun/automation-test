package com.epam.cnta.webdriver.demo2.additional.custom_page_object_with_abstract_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class GitHubAbstractPage {

	protected WebDriver driver;

	public GitHubAbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public boolean isElementPresent(By locator) {
		return driver.findElements(locator).size() > 0;
	}

}
