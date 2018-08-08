package by.htp.drozdovskaya.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InboxPage extends AbstractPage {
	public InboxPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);

	}

	public int getQuantityOfNotReadInboxMail() {
		int quantity = 0;
		try {
			String textFromTag = driver.findElement(By.xpath("//span[@class='mail-LabelList-Item_count']")).getText();
			quantity = Integer.parseInt(textFromTag);
		} catch (NoSuchElementException e) {
			System.out.println("непрочитанных писем нет");
		}
		return quantity;
	}

	public int getQuantityOfAllInboxMail() {
		String textFromTag = driver.findElement(By.xpath("//span[@class='mail-NestedList-Item-Info-Extras']"))
				.getText();
		int quantity;
		if (textFromTag.contains(" ") || textFromTag.contains("/")) {
			String[] strMas = textFromTag.split(" ");
			quantity = Integer.parseInt(strMas[2]);
		} else {
			quantity = Integer.parseInt(textFromTag);
		}
		return quantity;
	}

}
