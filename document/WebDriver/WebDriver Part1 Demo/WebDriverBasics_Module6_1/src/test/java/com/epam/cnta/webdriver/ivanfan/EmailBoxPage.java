package com.epam.cnta.webdriver.ivanfan;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailBoxPage extends EmailHomePage {
	
	@FindBy(xpath = "//div[@class='Cp']//div//table//tbody//tr//td[6]//div//div//div//span")
	protected List<WebElement> listEmails;	 
	private String subject;
	public WebElement targetEmail;
	public EmailBoxPage(WebDriver driver,String subject) {
		super(driver);	
		this.subject=subject;
	}
	
	public boolean checkDraftBox() throws InterruptedException{
		System.out.println("Checking draft box ....");
		return this.checkEmailBox(this.draftLink,this.subject);
	}
	public boolean checkSendBox() throws InterruptedException{
		System.out.println("Checking send box ...");
		return this.checkEmailBox(this.sendLink,this.subject);
	}
	private boolean checkEmailBox(WebElement boxType,String subject) throws InterruptedException {		 
		boxType.click();
		Thread.sleep(1000*3);	 
		for (int i = 0; i < listEmails.size(); i++) {		 
			if (listEmails.get(i).getText().equals(subject)) {
				targetEmail=listEmails.get(i);
				return true;
			}
		}
		return false;
	} 

}
