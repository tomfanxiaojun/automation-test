package com.epam.cnta.webdriver.ivanfan;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WriteEmailPage extends EmailHomePage {
	@FindBy(xpath = "//textarea[@role='combobox'][@name='to']")
	protected WebElement toEmailInput;
	@FindBy(name = "subjectbox")
	protected WebElement subjectInput;
	@FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
	protected WebElement contextInput;
	@FindBy(xpath = "//img[@class='Ha'][@src='images/cleardot.gif']")
	protected WebElement closeButton;
	@FindBy(xpath = "//div[@class='aDh']//table//tbody//tr[1]//td[1]//div")
	protected WebElement sendButton;
 
	
	
	
	private static final String TO_EMAIL_ADDRESS = "Ivan_Fan@epam.com";
	private long randomNum = 0;
	private String subject;
	private String newSubject;
	private static final String SUBJECTBOX_CONTEXT = "Test Eamil subject";
	private static final String CONTEXT_EMAIL = "This is a test email ,this is the content.";
	public WriteEmailPage(WebDriver driver) {
		super(driver);	
		randomNum = new Date().getTime();
		subject = SUBJECTBOX_CONTEXT + "_" + randomNum;
		newSubject = subject + ",email send from draft box.";
	}
	public EmailBoxPage writeDraft(){
		System.out.println("Writing a email ...");
		writeEmailButton.click();
		toEmailInput.clear();
		toEmailInput.sendKeys(TO_EMAIL_ADDRESS);
		System.out.println("To:"+TO_EMAIL_ADDRESS);
		subjectInput.clear();
		subjectInput.sendKeys(subject);
		System.out.println("Subject:"+subject);
		contextInput.click();
		contextInput.clear();
		contextInput.sendKeys(CONTEXT_EMAIL);	
		System.out.println("Context:"+CONTEXT_EMAIL);
		closeButton.click();
		System.out.println("Saving email to draft box ....");
		return new EmailBoxPage(driver,this.subject);
	}
	public EmailBoxPage reWriteEmailAndSend(WebElement targetEmail){
		System.out.println("Rewriting the email ....");
		targetEmail.click();
		subjectInput.clear();
		System.out.println("New Subject:"+newSubject);
		subjectInput.sendKeys(newSubject);
		sendButton.click(); 
		System.out.println("Sending the email...");
		return new EmailBoxPage(driver,this.newSubject);
	} 
}
