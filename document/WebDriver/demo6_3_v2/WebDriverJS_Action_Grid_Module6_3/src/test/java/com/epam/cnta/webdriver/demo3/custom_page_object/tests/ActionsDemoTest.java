package com.epam.cnta.webdriver.demo3.custom_page_object.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionsDemoTest {

	private static final String DROPPABLE_TEST_URL = "http://jqueryui.com/droppable/";
	private static final String SELECTABLE_TEST_URL = "http://jqueryui.com/selectable/";
	private static final String DRAGGABLE_TEST_URL = "http://jqueryui.com/draggable/";
	private static final String CONTEXT_MENU_URL = "http://medialize.github.io/jQuery-contextMenu/demo.html";
	private static WebDriver driver;

	@BeforeClass
	public void setUp() {
		// setting up initial WebDriver/browser options
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(description = "Drag element by XY-ofset coordinates")
	public void draggable() throws InterruptedException {
		// navigating to test url
		driver.get(DRAGGABLE_TEST_URL);

		// switching to frame containing web element
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

		WebElement draggable = driver.findElement(By.id("draggable"));

		// perform drag-and-drop action
		new Actions(driver).dragAndDropBy(draggable, 120, 120).build().perform();

		// freeze for a while to demonstrate action result
		Thread.sleep(3000);
	}

	@Test(description = "Drag and drop (element-to-element", dependsOnMethods = "draggable")
	public void droppable() throws InterruptedException {
		// navigating to test url
		driver.get(DROPPABLE_TEST_URL);

		// switching to frame containing web elements
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));

		// perform drag-and-drop action
		new Actions(driver).dragAndDrop(draggable, droppable).build().perform();

		// freeze for a while to demonstrate action result
		Thread.sleep(3000);
	}

	@Test(description = "Multiple selection", dependsOnMethods = "droppable")
	public void selectMultiple() throws InterruptedException {
		// navigating to test url
		driver.get(SELECTABLE_TEST_URL);

		// switching to frame containing web elements
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

		// getting selectable element list and printing it out for test purpose
		List<WebElement> listItems = driver.findElements(By.cssSelector("ol#selectable *"));
		System.out.println("Item list size: " + listItems.size());

		// perform action chain to select multiple items
		new Actions(driver).clickAndHold(listItems.get(0)).moveToElement(listItems.get(4)).moveByOffset(90, 0).release()
				.perform();

		// freeze for a while to demonstrate action result
		Thread.sleep(3000);
	}

	@Test(description = "Context Menu", dependsOnMethods = "selectMultiple")
	public void contextClick() throws InterruptedException {
		// navigating to test url
		driver.navigate().to(CONTEXT_MENU_URL);

		// performing wait for a test element which is expected to be a target
		// for contextClick action
		By locator = By.xpath("//span[contains(@class,'context-menu-one') and contains(.,'right click me')]");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		// perform contextClick action to open context menu
		new Actions(driver).contextClick(driver.findElement(locator)).build().perform();

		// clicking the item available after context menu was open by previous
		// action
		driver.findElement(By.cssSelector("li.context-menu-icon-edit>span")).click();
		System.out.println("Sucessfully right-clicked on the element");

		// switching to alert popup
		Alert alert = driver.switchTo().alert();
		String textEdit = alert.getText();

		// verification of alert text
		Assert.assertEquals(textEdit, "clicked: edit", "Failed to click on Edit link");

		// freeze for a while to demonstrate action result
		Thread.sleep(3000);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
