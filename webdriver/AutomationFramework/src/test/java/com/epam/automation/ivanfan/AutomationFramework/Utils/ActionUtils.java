package com.epam.automation.ivanfan.AutomationFramework.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtils {
	protected WebDriver driver;

	public ActionUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void ClickAction(WebElement e) {
		new Actions(driver).click(e).build().perform();
	}
	public void MouseOverAction(WebElement e){
		new Actions(driver).moveToElement(e);
	}
	 
}