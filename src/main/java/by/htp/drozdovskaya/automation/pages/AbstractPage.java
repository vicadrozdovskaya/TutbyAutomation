package by.htp.drozdovskaya.automation.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}
}
