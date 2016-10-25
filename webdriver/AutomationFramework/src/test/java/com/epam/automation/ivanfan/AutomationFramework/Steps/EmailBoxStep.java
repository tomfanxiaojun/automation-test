package com.epam.automation.ivanfan.AutomationFramework.Steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.epam.automation.ivanfan.AutomationFramework.Pages.*;
 

public class EmailBoxStep {
	private final static Logger logger = Logger.getLogger(EmailBoxStep.class);
	private static EmailBoxPage emailBoxPage;

	private EmailBoxStep() {
	}

	private static EmailBoxPage getWriteEmailPageInstance() {
		if (null == emailBoxPage) {
			emailBoxPage = new EmailBoxPage();
		}
		return emailBoxPage;
	}
		
	
	public static  WebElement checkDraftBox(String subject) throws InterruptedException{
		getWriteEmailPageInstance();
		logger.info("Checking draft box ....");
		return checkEmailBox(emailBoxPage.getDraftLink(),subject);
	}
	public static WebElement checkSendBox(String subject) throws InterruptedException{
		getWriteEmailPageInstance();
		logger.info("Checking send box ...");
		return checkEmailBox(emailBoxPage.getSendLink(),subject);
	}
	private static WebElement  checkEmailBox(WebElement boxType,String subject) throws InterruptedException {		 
		WebElement targetEmail=null;
		emailBoxPage.getActionUtils().ClickAction(boxType);
		Thread.sleep(1000*3);	 
		for (int i = 0; i < emailBoxPage.getListEmails().size(); i++) {		 
			if (emailBoxPage.getListEmails().get(i).getText().equals(subject)) {
				targetEmail=emailBoxPage.getListEmails().get(i);
				return targetEmail;
			}
		}
		return targetEmail;
	} 
}
