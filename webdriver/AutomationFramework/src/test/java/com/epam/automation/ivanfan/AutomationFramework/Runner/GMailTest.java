package com.epam.automation.ivanfan.AutomationFramework.Runner;

import java.util.Date;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.automation.ivanfan.AutomationFramework.Objects.EmailModel;
import com.epam.automation.ivanfan.AutomationFramework.Objects.UserModel;
import com.epam.automation.ivanfan.AutomationFramework.Pages.BasePage;
import com.epam.automation.ivanfan.AutomationFramework.Steps.EmailBoxStep;
import com.epam.automation.ivanfan.AutomationFramework.Steps.EmailHomeStep;
import com.epam.automation.ivanfan.AutomationFramework.Steps.LoginStep;
import com.epam.automation.ivanfan.AutomationFramework.Steps.WriteEmailStep;

public class GMailTest {
	private static final String LOGIN_USER_PASSWORD = "fxj.1234567";
	private static final String LOGIN_USER_NAME = "ivanfan0212@gmail.com";
	private static final String START_URL = "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false&lp=1&hl=en#password";
	private static final String TO_EMAIL_ADDRESS = "Ivan_Fan@epam.com";
	private static final String SUBJECTBOX_CONTEXT = "Test Eamil subject";
	private static final String CONTEXT_EMAIL = "This is a test email ,this is the content.";
	private BasePage basePage;

	@BeforeClass(description = "Start browser")
	public void startBrowser() {
		basePage = new BasePage();
		basePage.OpenPage(START_URL);

	}

	@BeforeClass(dependsOnMethods = "startBrowser", description = "Add implicite wait and maximize window")
	public void addImplicitly() {
		basePage.AddImplicitly();
	}

	@Test(description = "Test Gemail ")
	public void testGMail() throws InterruptedException {
		// // 1. Login via user-defined method
		UserModel userModel = new UserModel();
		userModel.setEmail(LOGIN_USER_NAME);
		userModel.setPassWord(LOGIN_USER_PASSWORD);
		LoginStep.login(userModel);
		// // 2.login is successful
		Assert.assertTrue(EmailHomeStep.isLogin(),
				"Looks you are not logged in correctly!");
		// // 3.write email and save to draft box
		EmailModel emailModel = new EmailModel();
		emailModel.setFromEmailAddress(LOGIN_USER_NAME);
		emailModel.setToEmailAddress(TO_EMAIL_ADDRESS);
		long randomNum = new Date().getTime();
		emailModel.setSubject(SUBJECTBOX_CONTEXT + "_" + randomNum);
		emailModel.setContent(CONTEXT_EMAIL);
		emailModel.setIsDraft(false);
		WriteEmailStep.writeDraftEmail(emailModel);
		// // 4.check draft box
		WebElement targetEmail = EmailBoxStep.checkDraftBox(emailModel.subject);
		Assert.assertNotNull(targetEmail, "The Email not exist at draft box!");
		// // 5.reset the email and send out.

		emailModel.setIsDraft(true);
		emailModel.setSubject(emailModel.getSubject()
				+ ",email send from draft box.");
		WriteEmailStep.reWritetEmail(targetEmail, emailModel);

		// // 6.re-check the draft box
		targetEmail = EmailBoxStep.checkDraftBox(emailModel.subject);
		Assert.assertNull(targetEmail,
				"The draft box email not send successful!");
		// // 7,check send box
		targetEmail = EmailBoxStep.checkSendBox(emailModel.subject);
		Assert.assertNotNull(targetEmail,
				"The draft box email not send successful!");
		// // 8.Logout
		System.out.println("logout .............");
		EmailHomeStep.logout();

	}

	@AfterClass(description = "Stop Browser")
	public void stopBrowser() {
		 //basePage.StopBrowser();
	}

}
