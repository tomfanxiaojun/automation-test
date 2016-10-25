package com.epam.automation.ivanfan.AutomationFramework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSingleton {
	private static WebDriver driver;

	private WebDriverSingleton() {
	}

	public static WebDriver getWebDriverInstance() {
		if (null == driver) {
			driver = new FirefoxDriver();
			//driver = new ChromeDriver();
			
		}
		return driver;
	}

	public static void closeWebBrowser() {
		driver.quit();
		driver = null;
	}
}