package by.htp.drozdovskaya.automation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import by.htp.drozdovskaya.automation.steps.Steps;

public class TutbyLoginTest {
	
	private Steps steps;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
		steps.openTutbyMail();
	}

	@Parameters({ "Login", "Password" })
	@Test(description = "Login to Tut.by", groups = { "login tut.by" })
	public void oneCanloginTutby(String login, String password) {
		steps.loginTutby(login, password);
		Assert.assertTrue(steps.isLoggedIn("victestingtask@tut.by"));

	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
