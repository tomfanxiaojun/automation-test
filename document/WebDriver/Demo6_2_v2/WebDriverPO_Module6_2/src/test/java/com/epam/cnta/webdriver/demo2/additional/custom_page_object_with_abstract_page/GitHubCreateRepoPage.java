package com.epam.cnta.webdriver.demo2.additional.custom_page_object_with_abstract_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GitHubCreateRepoPage extends GitHubAbstractPage {

	private static final String YOUR_REPO_LABEL_ID = "//div[@id='your_repos']//h3[contains(.,'Your repositories')]";
	private WebElement yourRepositoriesLabel;

	public GitHubCreateRepoPage(WebDriver driver) {
		super(driver);
	}

	// Method to ensure that the core/mandatory control for the page is
	// displayed
	public boolean loginIsCorrect() {
		yourRepositoriesLabel = driver.findElement(By.xpath(YOUR_REPO_LABEL_ID));
		return yourRepositoriesLabel.isDisplayed();

	}

}
