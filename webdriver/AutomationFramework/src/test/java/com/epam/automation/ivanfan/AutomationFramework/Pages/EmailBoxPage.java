package com.epam.automation.ivanfan.AutomationFramework.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
 
public class EmailBoxPage extends EmailHomePage {
	
	@FindBy(xpath = "//div[@class='Cp']//div//table//tbody//tr//td[6]//div//div//div//span")
	private List<WebElement> listEmails;

	public List<WebElement> getListEmails() {
		return listEmails;
	}

	public void setListEmails(List<WebElement> listEmails) {
		this.listEmails = listEmails;
	}	 


}