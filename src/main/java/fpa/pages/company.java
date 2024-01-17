package fpa.pages;

import java.util.List;

import org.openqa.selenium.By;
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
	@FindBy(xpath = "//span[@role='progressbar']")
	WebElement progressbar;
	@FindBy(xpath = "//div[@class='MuiFormControl-root MuiTextField-root css-fee8p6']/div/input")
	WebElement searchbox;
	@FindBy(xpath = "//tbody/tr[2]")
	WebElement actionbutton;
	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorPrimary MuiIconButton-sizeMedium css-17ql1g7']//*[name()='svg']")
	WebElement editbutton;
	@FindBy(id = "name")
	WebElement newcompanyname;
	@FindBy(xpath = "//button[normalize-space()='Update']")
	WebElement updatecompany;
	
	String Date="23/1/1";

	public void addcompany(String companycode, String companyname, String companycurrency, String fiscalcalendar)
			throws InterruptedException {
		Actions a = new Actions(driver);
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
		a.doubleClick(activeDate).sendKeys(Date).build().perform();
		submit.click();
	}

	public void searchcompany(String companycode) throws InterruptedException {
		waitForWebElementToBeinvisible(progressbar);
		gocname.click();
		searchbox.click();
		searchbox.sendKeys(companycode);
	}

	public void editcompany(String companyname) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(actionbutton).build().perform();
		action.moveToElement(editbutton).click().build().perform();
		newcompanyname.click();
		newcompanyname.sendKeys("new");
		//waitForWebElementToBeClickable(updatecompany);
		Thread.sleep(4000);
		action.moveToElement(updatecompany).click().build().perform();
		// updatecompany.click();

	}

}
