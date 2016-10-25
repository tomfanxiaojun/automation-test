package com.epam.automation.ivanfan.AutomationFramework.Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.epam.automation.ivanfan.AutomationFramework.Utils.ActionUtils;
import com.epam.automation.ivanfan.AutomationFramework.Utils.JavascriptExecutorUtils;

public class BasePage {
	private WebDriver driver;
	private ActionUtils actionUtils;
	private JavascriptExecutorUtils jsUtils;
	public BasePage() {
		driver=WebDriverSingleton.getWebDriverInstance();
		actionUtils=new ActionUtils(driver);
		jsUtils=new JavascriptExecutorUtils(driver);
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

	public ActionUtils getActionUtils() {
		return actionUtils;
	}

	public void setActionUtils(ActionUtils actionUtils) {
		this.actionUtils = actionUtils;
	}

	public JavascriptExecutorUtils getJsUtils() {
		return jsUtils;
	}

	public void setJsUtils(JavascriptExecutorUtils jsUtils) {
		this.jsUtils = jsUtils;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public void OpenPage(String start_url){
		this.driver.navigate().to(start_url);
	}
	public void AddImplicitly(){
		this.driver.manage().timeouts().implicitlyWait(100 * 6, TimeUnit.SECONDS);
		// Maximize browser window
		this.driver.manage().window().maximize();
	}
	public void StopBrowser() {
		this.driver.quit();
		this.driver = null;
	}
	
}
