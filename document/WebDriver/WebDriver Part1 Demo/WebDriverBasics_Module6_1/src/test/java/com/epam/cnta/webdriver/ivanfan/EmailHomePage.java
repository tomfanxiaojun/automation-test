package com.epam.cnta.webdriver.ivanfan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailHomePage extends BasePage {

	@FindBy(xpath = "//div[@role='button'][@tabindex='0'][@gh='cm']")
	protected WebElement writeEmailButton;
	
	@FindBy(xpath = "//a[@href='https://mail.google.com/mail/u/0/#drafts']")
	protected WebElement draftLink;
	@FindBy(xpath = "//a[@href='https://mail.google.com/mail/u/0/#sent']")
	protected WebElement sendLink;
	@FindBy(xpath = "//span[@class='gb_1a gbii']")
	protected WebElement logoutLink;
	@FindBy(xpath = "//div[@class='gb_qb']//div[2]//a")
	protected WebElement logoutButton;
	public EmailHomePage(WebDriver driver) {
		super(driver);		 
	}
	public boolean isLogin(){
		System.out.println("Checking whether login successful.");
		return this.isElementPresent(writeEmailButton);
	}
	public void logout(){
		System.out.println("Logout is in progress...");
		logoutLink.click();
		logoutButton.click();
		System.out.println("Logout is successfull");
	}
	 

}
