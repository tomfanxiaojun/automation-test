package com.epam.cnta.webdriver.demo2.lection_demo_native_page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GitHubCreateRepoPage {
	
	@FindBy (xpath = "//div[@id='your_repos']//h3[contains(.,'Your repositories')]")
	private WebElement yourRepositoriesLabel;
	
	//Method to ensure that the core/mandatory control for the page is displayed
	public boolean loginIsCorrect() {
		return yourRepositoriesLabel.isDisplayed();
		
	}
	
}
