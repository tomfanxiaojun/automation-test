package com.epam.cnta.webdriver.demo1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GitHubTest {

	private static final String SIGN_IN_INPUT = "//input[@value='Sign in']";
	private static final String INPUT_PASSWORD = "//input[@id='password']";
	private static final String LOGIN_FIELD = "login_field";
	private static final String GO_TO_SIGN_IN_TEXT = "Sign in";
	private static final String YOUR_REPOSITORIES = "//div[@id='your_repos']//h3[contains(.,'Your repositories')]";
	private static final String PASSWORD = "Time4Death!";
	private static final String LOGIN = "testautomationuser";
	private static final String START_URL = "https://github.com/";

	private WebDriver driver;

	@BeforeClass(description = "Start browser")
	public void startBrowser() {
		driver = new FirefoxDriver();
		driver.get(START_URL);
	}

	@BeforeClass(dependsOnMethods = "startBrowser", description = "Add implicite wait and maximize window")
	public void addImplicitly() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Maximize browser window
		driver.manage().window().maximize();
	}

	@Test(description = "Login to Github account")
	public void loginToGithub() {
		// Login via user-defined method
		doLogin(LOGIN, PASSWORD);

		// Verify the login procedure was correct
		Assert.assertTrue(isElementPresent(By.xpath(YOUR_REPOSITORIES)), "Looks you are NOT logged in correctly!");
	}

	@AfterClass(description = "Stop Browser")
	public void stopBrowser() {
		driver.quit();
	}

	private boolean isElementPresent(By by) {
		// Custom implementation for is ElementPresent
		return !driver.findElements(by).isEmpty();
	}

	private void doLogin(String login, String password) {

		// Find the "button" input element by link text
		driver.findElement(By.linkText(GO_TO_SIGN_IN_TEXT)).click();

		// Find the text input element by "id" attribute with a certain value
		// and type the user name there
		WebElement loginInput = driver.findElement(By.id(LOGIN_FIELD));
		loginInput.clear();
		loginInput.sendKeys(login);

		// Find the text input element by xpath expression and type the password
		// there
		WebElement passwordInput = driver.findElement(By.xpath(INPUT_PASSWORD));
		passwordInput.clear();
		passwordInput.sendKeys(password);

		// Now submit the form. WebDriver will find the form for us from the
		// element
		driver.findElement(By.xpath(SIGN_IN_INPUT)).click();
	}

}
