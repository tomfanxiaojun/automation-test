package com.epam.automation.ivanfan.AutomationFramework.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavascriptExecutorUtils {
	protected WebDriver driver;
	JavascriptExecutor jsExec;
	public JavascriptExecutorUtils(WebDriver driver) {
		this.driver = driver;
		this.jsExec = (JavascriptExecutor) driver;
	}

	public void ClickById(String id) {
		
		jsExec.executeScript("document.getElementById('"+id+"').click()");

	}
	public void SetBackGroundColorByCssName(String cssName,String color){
		jsExec.executeScript("document.getElementsByClassName('"+cssName+"')[0].style='background:"+color+";'");
		
	}
}
