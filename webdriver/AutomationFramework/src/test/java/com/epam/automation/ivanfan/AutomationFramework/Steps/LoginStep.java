package com.epam.automation.ivanfan.AutomationFramework.Steps;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.epam.automation.ivanfan.AutomationFramework.Objects.UserModel;
import com.epam.automation.ivanfan.AutomationFramework.Pages.EmailHomePage;
import com.epam.automation.ivanfan.AutomationFramework.Pages.LoginPage;

public class LoginStep {
	private static LoginPage loginPage;
	private final static Logger logger = Logger.getLogger(LoginStep.class);
	private LoginStep() {
	}

	public static EmailHomePage login(UserModel userModel) {
		if (null == loginPage) {
			loginPage = new LoginPage();
		}
		logger.info("Typing user login email: " + userModel.getEmail());
		loginPage.getLoginEmailInput().clear();
		loginPage.getLoginEmailInput().sendKeys(userModel.getEmail());
		loginPage.getJsUtils().ClickById("next");
		loginPage.getLoginPasswdInput().clear();
//		logger.setLevel(Level.DEBUG);
//		System.out.println(logger.getLevel());
		logger.debug("Typing user password: " + userModel.getPassWord());
		loginPage.getLoginPasswdInput().sendKeys(userModel.getPassWord());
		loginPage.getJsUtils().ClickById("signIn");
		logger.debug("Login is in progress...");
		return new EmailHomePage();
	}
}
