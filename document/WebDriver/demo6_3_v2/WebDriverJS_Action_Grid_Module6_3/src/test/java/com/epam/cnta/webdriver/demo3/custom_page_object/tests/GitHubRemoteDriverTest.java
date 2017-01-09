package com.epam.cnta.webdriver.demo3.custom_page_object.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.cnta.webdriver.demo3.custom_page_object.pages.GitHubCreateRepoPage;
import com.epam.cnta.webdriver.demo3.custom_page_object.pages.GitHubHomePage;

public class GitHubRemoteDriverTest {

	private static final String PASSWORD = "Time4Death!";
	private static final String LOGIN = "testautomationuser";
	private static final String START_URL = "https://github.com/";

	private static WebDriver driver;

	public static WebDriver getDriver() {
		// required to get single WebDriver instance for the whole test flow
		// and make convenient WebDriver call from other classes
		if (driver == null) {
			setDriver();
		}
		return driver;
	}

	private static void setDriver() {
		// setting options and capabilities for webdriver launch via Grid
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("firefox");
		capabilities.setPlatform(Platform.WINDOWS);
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass(description = "Start browser")
	public void startBrowser() {
		// init Webdriver and open start url
		driver = getDriver();
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
