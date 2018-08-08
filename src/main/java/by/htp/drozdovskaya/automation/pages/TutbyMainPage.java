package by.htp.drozdovskaya.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TutbyMainPage extends AbstractPage {

	private final String BASE_URL = "https://www.tut.by/";

	public TutbyMainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnMail() {
		driver.findElement(By.xpath("//a[@title='Почта']")).click();
	}

	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

}
