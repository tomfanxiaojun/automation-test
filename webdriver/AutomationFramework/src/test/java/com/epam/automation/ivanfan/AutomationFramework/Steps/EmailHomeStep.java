package com.epam.automation.ivanfan.AutomationFramework.Steps;

import org.apache.log4j.Logger;

import com.epam.automation.ivanfan.AutomationFramework.Pages.EmailHomePage;

public class EmailHomeStep {
	private static EmailHomePage emailHomePage;
	private final static Logger logger = Logger.getLogger(EmailBoxStep.class);
	private EmailHomeStep() {
	}

	private static EmailHomePage getEmailHomePageInstance() {
		if (null == emailHomePage) {
			emailHomePage = new EmailHomePage();
		}
		return emailHomePage;
	}

	public static boolean isLogin() {
		getEmailHomePageInstance();
		logger.info("Checking whether login successful.");
		return emailHomePage.isElementPresent(emailHomePage
				.getWriteEmailButton());
	}

	public static void logout() {
		getEmailHomePageInstance();
		logger.info("Logout is in progress...");
		emailHomePage.getActionUtils().ClickAction(
				emailHomePage.getLogoutLink());
		emailHomePage.getActionUtils().ClickAction(
				emailHomePage.getLogoutButton());
		System.out.println("Logout is scucessfull");
		logger.info("Logout is successfull");
	}
}
