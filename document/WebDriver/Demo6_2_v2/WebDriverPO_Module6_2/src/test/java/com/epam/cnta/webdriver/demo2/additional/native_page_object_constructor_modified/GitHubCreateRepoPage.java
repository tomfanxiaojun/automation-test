package com.epam.cnta.webdriver.demo2.additional.native_page_object_constructor_modified;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GitHubCreateRepoPage {
	
	@FindBy (xpath = "//div[@id='your_repos']//h3[contains(.,'Your repositories')]")
	private WebElement yourRepositoriesLabel;
	private WebDriver driver;
	
	public GitHubCreateRepoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	//Method to ensure that the core/mandatory control for the page is displayed
	public boolean loginIsCorrect() {
		return yourRepositoriesLabel.isDisplayed();
		
	}
	
}
