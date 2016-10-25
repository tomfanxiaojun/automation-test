package com.epam.automation.ivanfan.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WriteEmailPage extends BasePage{
	@FindBy(xpath = "//div[@role='button'][@tabindex='0'][@gh='cm']")
	protected WebElement writeEmailButton;
	@FindBy(xpath = "//textarea[@role='combobox'][@name='to']")
	protected WebElement toEmailInput;
	@FindBy(name = "subjectbox")
	protected WebElement subjectInput;
	@FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
	protected WebElement contextInput;
	@FindBy(xpath = "//img[@class='Ha'][@src='images/cleardot.gif']")
	protected WebElement closeButton;
	@FindBy(xpath = "//div[@class='aDh']//table//tbody//tr[1]//td[1]//div")
	protected WebElement sendButton;
	public WriteEmailPage(){
		
	}
	public WebElement getToEmailInput() {
		return toEmailInput;
	}
	public void setToEmailInput(WebElement toEmailInput) {
		this.toEmailInput = toEmailInput;
	}
	public WebElement getSubjectInput() {
		return subjectInput;
	}
	public void setSubjectInput(WebElement subjectInput) {
		this.subjectInput = subjectInput;
	}
	public WebElement getContextInput() {
		return contextInput;
	}
	public void setContextInput(WebElement contextInput) {
		this.contextInput = contextInput;
	}
	public WebElement getCloseButton() {
		return closeButton;
	}
	public void setCloseButton(WebElement closeButton) {
		this.closeButton = closeButton;
	}
	public WebElement getSendButton() {
		return sendButton;
	}
	public void setSendButton(WebElement sendButton) {
		this.sendButton = sendButton;
	}
	public WebElement getWriteEmailButton() {
		return writeEmailButton;
	}
	public void setWriteEmailButton(WebElement writeEmailButton) {
		this.writeEmailButton = writeEmailButton;
	}
}
