package fpa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fpa.AbstractComponents.abstractComponents;

public class company extends abstractComponents {
	WebDriver driver;

	public company(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Company']")
	WebElement company;
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-zo2mn6']")
	WebElement gocname;
	@FindBy(xpath = "//button[text()='+ Add Company']")
	WebElement addCompany;
	@FindBy(xpath = "//tbody/tr/td[3]")
	WebElement company_code;
	@FindBy(xpath = "//tbody/tr/td[4]")
	WebElement company_name;
	@FindBy(xpath = "//tbody/tr/td[5]")
	WebElement currency;
	@FindBy(css = ".jdropdown-item div")
	List<WebElement> currencyList;
	@FindBy(xpath = "//tbody/tr/td[6]")
	WebElement fiscal;
	@FindBy(css = ".jdropdown-item div")
	List<WebElement> calendar;
	@FindBy(css = "thead tr td:nth-child(10)")
	WebElement targetElement;
	@FindBy(xpath = "//tbody/tr/td[8]")
	WebElement activeDate;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;
	@FindBy(xpath="//span[@role='progressbar']")
	WebElement progressbar;

	public void addcompany(String companycode, String companyname, String companycurrency, String fiscalcalendar)
			throws InterruptedException {
		Actions a = new Actions(driver);
		Thread.sleep(3000);
		waitForWebElementToBeinvisible(progressbar);
		goToCoreBusinessStructure();
		company.click();
		waitForWebElementToAppear(gocname);
		gocname.click();
		addCompany.click();
		a.doubleClick(company_code).sendKeys(companycode).build().perform();
		a.doubleClick(company_name).sendKeys(companyname).build().perform();
		a.doubleClick(currency).sendKeys(companycurrency).build().perform();
		for (WebElement currencies : currencyList) {
			if (currencies.getText().equalsIgnoreCase(companycurrency)) {
				currencies.click();
				break;
			}
		}
		a.doubleClick(fiscal).sendKeys(fiscalcalendar).build().perform();
		for (WebElement calendarlist : calendar) {
			if (calendarlist.getText().equalsIgnoreCase(fiscalcalendar)) {
				calendarlist.click();
				break;
			}
		}
		a.scrollToElement(targetElement).build().perform();
		a.doubleClick(activeDate).sendKeys("01/01/2023").build().perform();
		submit.click();
	}

}
