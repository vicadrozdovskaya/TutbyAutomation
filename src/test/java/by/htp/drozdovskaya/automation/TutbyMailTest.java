package by.htp.drozdovskaya.automation;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import by.htp.drozdovskaya.automation.steps.Steps;

public class TutbyMailTest {
	
	private Steps steps;

	@Parameters({"Login", "Password"})
	@BeforeTest(description = "Init browser", groups = {"count letters"})
	public void setUp(String login, String password)
	{
		steps = new Steps();
		steps.initBrowser();
		steps.openTutbyMail();
		steps.loginTutby(login, password);
	}
	
	@Test(description = "Check quantity of not read letters inbox", groups = {"count letters"})
	public void checkQuantityOfNotReadInboxLetters() {
		int result = steps.getQuantityOfNotReadInboxLetters();
		System.out.println("Количесвто непрочитанных писем=" + result);
		Assert.assertTrue( result >= 0);	
		
	}
	@Test(description = "Check quantity of all leeters inbox", groups = {"count letters"})
	public void checkQuantityOfAllInboxLetters() {
		int result = steps.getQuantityOfAllInboxLetters();
		System.out.println("Количесвто входящих писем=" + result);
		Assert.assertTrue(result >= 0);
	}
	
	@AfterTest(description = "Stop Browser", groups = {"count letters"})
	public void stopBrowser()
	{
		steps.closeDriver();
	}

}
