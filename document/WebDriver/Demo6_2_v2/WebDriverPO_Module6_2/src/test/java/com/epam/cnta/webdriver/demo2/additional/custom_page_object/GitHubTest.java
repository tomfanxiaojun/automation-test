package com.epam.cnta.webdriver.demo2.additional.custom_page_object;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GitHubTest {

	private static final String PASSWORD = "Time4Death!";
	private static final String LOGIN = "testautomationuser";
	private static final String START_URL = "https://github.com/";

	private WebDriver driver;

	@BeforeClass(description = "Start browser")
	public void startBrowser() {
		// init Webdriver and open start url
		driver = new FirefoxDriver();
		driver.get(START_URL);
	}

	@BeforeClass(dependsOnMethods = "startBrowser", description = "Add implicit wait and maximize window")
	public void addImplicitly() {
		// set a certain implicit wait timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Maximize browser window
		driver.manage().window().maximize();
	}

	@Test(description = "Login to Github account")
	public void loginToGithub() {
		// Login via user-defined method
		new GitHubHomePage(driver).openSignInPage().loginToGitHub(LOGIN, PASSWORD);

		// Verify the login procedure was correct
		Assert.assertTrue(new GitHubCreateRepoPage(driver).loginIsCorrect(), "Looks you are NOT logged in correctly!");
		System.out.println("Login was completed correctly.");
	}

	@AfterClass(description = "Stop Browser")
	public void stopBrowser() {
		driver.quit();
	}

}
