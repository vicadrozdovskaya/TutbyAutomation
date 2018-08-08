package by.htp.drozdovskaya.automation.steps;

import org.openqa.selenium.WebDriver;

import by.htp.drozdovskaya.automation.driver.DriverSingleton;
import by.htp.drozdovskaya.automation.pages.LoginPage;
import by.htp.drozdovskaya.automation.pages.InboxPage;
import by.htp.drozdovskaya.automation.pages.TutbyMainPage;

public class Steps {

	private WebDriver driver;

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void openTutbyMail() {
		TutbyMainPage tutbyMainPage = new TutbyMainPage(driver);
		tutbyMainPage.openPage();
		tutbyMainPage.clickOnMail();
	}

	public void loginTutby(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}

	public boolean isLoggedIn(String username) {
		LoginPage loginPage = new LoginPage(driver);
		String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
		return actualUsername.equals(username);
	}

	public int getQuantityOfNotReadInboxLetters() {
		InboxPage inboxPage = new InboxPage(driver);
		return inboxPage.getQuantityOfNotReadInboxMail();
	}

	public int getQuantityOfAllInboxLetters() {
		InboxPage inboxPage = new InboxPage(driver);
		return inboxPage.getQuantityOfAllInboxMail();
	}

}