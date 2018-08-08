package by.htp.drozdovskaya.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

	private final String BASE_URL = "https://mail.tut.by/";
	private WebElement inputLogin;
	private WebElement inputPassword;
	private WebElement buttonSubmit;
	private WebDriverWait simpleWait;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
		simpleWait = new WebDriverWait(driver, 40);
	}

	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

	public void login(String username, String password) {
		inputLogin = driver.findElement(By.xpath("//input[@name='login']"));
		inputLogin.sendKeys(username);
		inputPassword = driver.findElement(By.xpath("//input[@name='password']"));
		inputPassword.sendKeys(password);
		buttonSubmit = driver.findElement(By.xpath("//input[@value='Войти']"));
		buttonSubmit.click();
	}

	public String getLoggedInUserName() {
		simpleWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='mail-User-Name']")));
		return driver.findElement(By.xpath("//div[@class='mail-User-Name']")).getText();
	}

}