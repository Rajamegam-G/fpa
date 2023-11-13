package fpa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fpa.AbstractComponents.abstractComponents;

public class inputTemplates extends abstractComponents {

	WebDriver driver;

	public inputTemplates(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@role='progressbar']")
	WebElement progressbar;

	public void inputtemplates() {

		goToHomePage();
		waitForWebElementToBeinvisible(progressbar);
		goToInputTemplates();

	}

}
