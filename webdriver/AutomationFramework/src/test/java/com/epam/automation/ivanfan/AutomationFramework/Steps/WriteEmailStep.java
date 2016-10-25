package com.epam.automation.ivanfan.AutomationFramework.Steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.epam.automation.ivanfan.AutomationFramework.Objects.EmailModel;
import com.epam.automation.ivanfan.AutomationFramework.Pages.WriteEmailPage;

public class WriteEmailStep {
	private static WriteEmailPage writeEmailPage;
	private final static Logger logger = Logger.getLogger(WriteEmailStep.class);
	private WriteEmailStep() {
	}

	private static WriteEmailPage getWriteEmailPageInstance() {
		if (null == writeEmailPage) {
			writeEmailPage = new WriteEmailPage();
		}
		return writeEmailPage;
	}

	private static void writeEmail(EmailModel emailModel) {
		getWriteEmailPageInstance();

		// writeEmailButton.click();
		if (!emailModel.getIsDraft()) {
			writeEmailPage.getToEmailInput().clear();
			writeEmailPage.getToEmailInput().sendKeys(
					emailModel.getToEmailAddress());
			logger.info("To:" + emailModel.getToEmailAddress());
		}

		writeEmailPage.getSubjectInput().clear();
		writeEmailPage.getSubjectInput().sendKeys(emailModel.getSubject());
		logger.info("Subject:" + emailModel.getSubject());

		if (!emailModel.getIsDraft()) {
			writeEmailPage.getActionUtils().ClickAction(
					writeEmailPage.getContextInput());
			writeEmailPage.getJsUtils().SetBackGroundColorByCssName(
					"Am Al editable LW-avf", "red");
			// contextInput.click();
			writeEmailPage.getContextInput().clear();
			writeEmailPage.getContextInput().sendKeys(emailModel.getContent());
			logger.info("Context:" + emailModel.getContent());
		}

	}

	public static void writeDraftEmail(EmailModel emailModel) {
		getWriteEmailPageInstance();
		logger.info("Writing a email ...");
		writeEmailPage.getActionUtils().ClickAction(
				writeEmailPage.getWriteEmailButton());
		writeEmail(emailModel);
		saveDraftEmail();
	}

	public static void reWritetEmail(WebElement targetEmail,
			EmailModel emailModel) {
		getWriteEmailPageInstance();
		clickTargetEmail(targetEmail);
		logger.info("Writing a email ...");
		writeEmail(emailModel);
		sendEmail();
	}

	private static void clickTargetEmail(WebElement targetEmail) {
		logger.info("Rewriting the email ....");
		writeEmailPage.getActionUtils().ClickAction(targetEmail);
	}

	private static void saveDraftEmail() {
		writeEmailPage.getActionUtils().ClickAction(
				writeEmailPage.getCloseButton());
		logger.info("Saving email to draft box ....");
	}

	private static void sendEmail() {
		writeEmailPage.getActionUtils().ClickAction(
				writeEmailPage.getSendButton());
		logger.info("Sending the email...");
	}

}
