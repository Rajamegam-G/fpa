package fpa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fpa.AbstractComponents.abstractComponents;

public class businessUnit extends abstractComponents {
	WebDriver driver;

	public businessUnit(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h6[text()='Acme Corporation']")
	WebElement homepage;
	@FindBy(xpath = "//div[@class='menu-card-container MuiBox-root css-n6niph']/div/p[text()='Business Unit']")
	WebElement businessUnitTab;
	@FindBy(xpath = "//button[text()='Add Business Unit']")
	WebElement addNewBusinessUnit;
	@FindBy(css = "tbody tr td:nth-child(2)")
	WebElement goc;
	@FindBy(css = ".jdropdown-description")
	WebElement gocList;
	@FindBy(xpath = "//tbody//tr//td[3]")
	WebElement businessunit_code;
	@FindBy(xpath = "//tbody//tr//td[4]")
	WebElement businessunit_name;
	@FindBy(xpath = "//tbody//tr//td[6]")
	WebElement Active_from;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement submit;

	public void addBusinessUnit(String BUcode, String BUname) throws InterruptedException {
		Actions a = new Actions(driver);
		Thread.sleep(3000);
		homepage.click();
		Thread.sleep(3000);
		goToCoreBusinessStructure();
		Thread.sleep(3000);
		businessUnitTab.click();
		Thread.sleep(3000);
		addNewBusinessUnit.click();
		a.doubleClick(goc).perform();
		gocList.click();
		Thread.sleep(3000);
		a.doubleClick(businessunit_code).sendKeys(BUcode).perform();
		a.doubleClick(businessunit_name).sendKeys(BUname).perform();
		a.doubleClick(Active_from).sendKeys("01/01/2023").perform();
		submit.click();
	}
}