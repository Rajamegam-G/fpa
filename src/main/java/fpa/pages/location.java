package fpa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fpa.AbstractComponents.abstractComponents;

public class location extends abstractComponents {
	WebDriver driver;

	public location(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='ACME-ACME corporation']")
	WebElement goc;
	@FindBy(xpath = "//div[@class='MuiCollapse-wrapper MuiCollapse-vertical css-hboir5']/div/li/div/div/div[2]")
	List<WebElement> companylist;
	@FindBy(xpath = "//button[text()='+ Add Location']")
	WebElement addLocation;
	@FindBy(xpath = "//tbody/tr/td[3]")
	WebElement locationCode;
	@FindBy(xpath = "//tbody/tr/td[4]")
	WebElement locationName;
	@FindBy(xpath = "//tbody/tr/td[5]")
	WebElement address;
	@FindBy(xpath = "//tbody/tr/td[6]")
	WebElement country;
	@FindBy(css = ".jdropdown-item div")
	List<WebElement> countries;
	@FindBy(css = "thead tr td:nth-child(11)")
	WebElement Active_from;
	@FindBy(xpath = "//tbody/tr/td[9]")
	WebElement activeDate;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;

	public void addLocation(String locationcode, String locationname, String countryname,
			String companycode) throws InterruptedException {
		Actions a = new Actions(driver);
		Thread.sleep(3000);
		goc.click();
		Thread.sleep(3000);
		for (WebElement companydetails : companylist) {
			if (companydetails.getText().contains(companycode)) {
				companydetails.click();
				break;
			}
		}
		addLocation.click();
		Thread.sleep(3000);
		a.doubleClick(locationCode).sendKeys(locationcode).perform();
		a.doubleClick(locationName).sendKeys(locationname).perform();
		a.doubleClick(address).sendKeys("132, My Street, Kingston").perform();
		a.doubleClick(country).sendKeys(countryname).perform();
		Thread.sleep(3000);
		for (WebElement countrylist : countries) {
			if (countrylist.getText().equalsIgnoreCase(countryname)) {
				countrylist.click();
				break;

			}
		}
		Thread.sleep(3000);
		a.scrollToElement(Active_from).perform();
		Thread.sleep(3000);
		a.doubleClick(activeDate).sendKeys("01/01/2023").perform();
		submit.click();
	}
}
