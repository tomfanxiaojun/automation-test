package com.epam.cnta.webdriver.ivanfan;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public boolean isElementPresent(By locator) {
		return driver.findElements(locator).size() > 0;
	}
	public boolean isElementPresent(WebElement e) {
		return e.isDisplayed();
	}
	public WebElement findElement(By locator){
		return driver.findElement(locator)==null?null:driver.findElement(locator);
	}
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator)==null?null:driver.findElements(locator);
	}
	
}
