package com.epam.cnta.webdriver.ivanfan;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GmailTest {	
	private static final String LOGIN_USER_PASSWORD = "fxj.1234567";
	private static final String LOGIN_USER_NAME = "ivanfan0212@gmail.com";
	private static final String START_URL = "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false&lp=1&hl=en#password";

	private WebDriver driver; 
	@BeforeClass(description = "Start browser")
	public void startBrowser() {		 
		driver = new FirefoxDriver();
		driver.get(START_URL);

	}

	@BeforeClass(dependsOnMethods = "startBrowser", description = "Add implicite wait and maximize window")
	public void addImplicitly() {
		driver.manage().timeouts().implicitlyWait(10 * 6, TimeUnit.SECONDS);

		// Maximize browser window
		driver.manage().window().maximize();
	}

	@Test(description = "Test Gemail ")
	public void testGMail() throws InterruptedException {
		// 1. Login via user-defined method
		EmailHomePage homePage=new LoginPage(driver).login(LOGIN_USER_NAME, LOGIN_USER_PASSWORD);
		// 2.login is successful
		Assert.assertTrue(homePage.isLogin(),
				"Looks you are not logged in correctly!");
		// 3.write email and save to draft box
		EmailBoxPage draftBox=new WriteEmailPage(driver).writeDraft();		 
		// 4.check draft box 
		Assert.assertTrue(draftBox.checkDraftBox(),
				"The Email not exist at draft box!");
		// 5.reset the email and send out.
		
		EmailBoxPage sendBox=new WriteEmailPage(driver).reWriteEmailAndSend(draftBox.targetEmail);
		// 6.re-check the draft box
		Assert.assertTrue(!draftBox.checkDraftBox(),
				"The draft box email not send successful!");
		// 7,check send box 
		Assert.assertTrue(sendBox.checkSendBox(),
				"The Email not exist at send box!"); 
		// 8.Logout		 
		homePage.logout();
		 
		

	}

	@AfterClass(description = "Stop Browser")
	public void stopBrowser() {
		driver.quit();
	} 

}
