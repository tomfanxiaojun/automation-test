package com.epam.automation.ivanfan.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EmailHomePage extends BasePage {

	@FindBy(xpath = "//div[@role='button'][@tabindex='0'][@gh='cm']")
	protected WebElement writeEmailButton;
	
	@FindBy(xpath = "//a[@href='https://mail.google.com/mail/u/0/#drafts']")
	protected WebElement draftLink;
	@FindBy(xpath = "//a[@href='https://mail.google.com/mail/u/0/#sent']")
	protected WebElement sendLink;
	@FindBy(xpath = "//span[@class='gb_1a gbii']")
	protected WebElement logoutLink;
	@FindBy(xpath = "//a[contains(@href, 'Logout')]")
	protected WebElement logoutButton;
	@FindBy(xpath = "//a[contains(@aria-label, 'Settings')]")
	protected WebElement settingButton;
	public EmailHomePage() {			
		//actionUtils.MouseOverAction(settingButton);
	}
	public WebElement getWriteEmailButton() {
		return writeEmailButton;
	}
	public void setWriteEmailButton(WebElement writeEmailButton) {
		this.writeEmailButton = writeEmailButton;
	}
	public WebElement getDraftLink() {
		return draftLink;
	}
	public void setDraftLink(WebElement draftLink) {
		this.draftLink = draftLink;
	}
	public WebElement getSendLink() {
		return sendLink;
	}
	public void setSendLink(WebElement sendLink) {
		this.sendLink = sendLink;
	}
	public WebElement getLogoutLink() {
		return logoutLink;
	}
	public void setLogoutLink(WebElement logoutLink) {
		this.logoutLink = logoutLink;
	}
	public WebElement getLogoutButton() {
		return logoutButton;
	}
	public void setLogoutButton(WebElement logoutButton) {
		this.logoutButton = logoutButton;
	}
	public WebElement getSettingButton() {
		return settingButton;
	}
	public void setSettingButton(WebElement settingButton) {
		this.settingButton = settingButton;
	}

	 

}