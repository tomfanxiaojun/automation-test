package com.epam.cnta.webdriver.demo2.additional.native_page_object_with_abstract_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GitHubCreateRepoPage extends GitHubAbstractPage {

	@FindBy(xpath = "//div[@id='your_repos']//h3[contains(.,'Your repositories')]")
	private WebElement yourRepositoriesLabel;

	public GitHubCreateRepoPage(WebDriver driver) {
		super(driver);
	}

	// Method to ensure that the core/mandatory control for the page is
	// displayed
	public boolean loginIsCorrect() {
		return yourRepositoriesLabel.isDisplayed();

	}

}
