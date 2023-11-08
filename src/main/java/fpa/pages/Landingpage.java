package fpa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fpa.AbstractComponents.abstractComponents;

public class Landingpage extends abstractComponents {
	WebDriver driver;

	public Landingpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "email")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;

	public void landinpage() {
		username.sendKeys("admin@msciq.io");
		password.sendKeys("Msciq@123");
		submit.click();

	}

	public void goTo() {
		driver.get("http://qa.msciq.io/");
	}
}
