package fpa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fpa.AbstractComponents.abstractComponents;

public class templateAccountGroup extends abstractComponents {
	WebDriver driver;

	public templateAccountGroup(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='menu-card-container MuiBox-root css-1fohtr1']/div/p[text()='Template Account Group']")
	WebElement tag;
	@FindBy(xpath = "//button[text()='+ Add Template Account Group']")
	WebElement addTag;
	@FindBy(id = "name")
	WebElement tagName;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement submit;
	@FindBy(xpath = "//h6[text()='Acme Corporation']")
	WebElement homepage;
	@FindBy(xpath="//span[@role='progressbar']")
	WebElement progressbar;

	public void addtemplateaccountgroup(String tagname) throws InterruptedException {
		homepage.click();
		waitForWebElementToBeinvisible(progressbar);
		goToForecastAttributes();
		tag.click();
		waitForpresenceofElementLocated(By.xpath("//button[text()='+ Add Template Account Group']"));
		addTag.click();
		waitForpresenceofElementLocated(By.id("name"));
		tagName.sendKeys(tagname);
		Thread.sleep(3000);
		submit.click();
		Thread.sleep(3000);

		// driver.findElement(By.xpath(".react-select-container.css-b62m3t-container")).click();

	}
}
