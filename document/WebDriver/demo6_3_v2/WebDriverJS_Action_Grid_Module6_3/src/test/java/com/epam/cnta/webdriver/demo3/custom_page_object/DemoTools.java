package com.epam.cnta.webdriver.demo3.custom_page_object;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.epam.cnta.webdriver.demo3.custom_page_object.tests.GitHubRemoteDriverTest;

public class DemoTools {
	private static WebDriver driver = GitHubRemoteDriverTest.getDriver();

	public static void highlightWithJS(WebElement element) {
		String bg = element.getCssValue("backgroundColor");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + "red" + "'", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
