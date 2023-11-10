package fpa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fpa.AbstractComponents.abstractComponents;

public class glAccount extends abstractComponents {
	WebDriver driver;

	public glAccount(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='menu-card-container MuiBox-root css-n6niph']/div/p[text()='GL Account']")
	WebElement glAccountTile;
	@FindBy(xpath = "//tbody/tr[1]/td[24]/div/span[@aria-label='Add Row']")
	WebElement addRow;
	@FindBy(xpath = "//tbody/tr[2]/td[2]")
	WebElement glCode;
	@FindBy(xpath = "//tbody/tr[2]/td[3]")
	WebElement glAccount;
	@FindBy(xpath = "//tbody/tr[2]/td[4]")
	WebElement glAccountDescription;
	@FindBy(xpath = "//tbody/tr[2]/td[5]")
	WebElement accountType;
	@FindBy(xpath = "//div[@id='P&L']")
	WebElement accountTypeValues;
	@FindBy(xpath = "//tbody/tr[2]/td[8]")
	WebElement activeFrom;
	@FindBy(xpath = "//tbody/tr[2]/td[12]")
	WebElement allocationGroup;
	@FindBy(xpath = "//tbody/tr[2]/td[10]")
	WebElement forecastRelevant;
	@FindBy(xpath = "//tbody/tr[2]/td[11]")
	WebElement templateAccountgroup;
	@FindBy(xpath = "//div[@class='jdropdown-content']/div")
	List<WebElement> tags;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement submit;

	public void addglaccount(String accountcode, String accountname, String accountdescription, String tagname)
			throws InterruptedException {
		Actions a = new Actions(driver);
		Thread.sleep(3000);
		goToHomePage();
		goToCoreBusinessStructure();
		// waitForWebElementToBeClickable(accounts);
		glAccountTile.click();
		waitForpresenceofElementLocated(By.xpath("//tbody/tr[1]/td[24]/div/span[@aria-label='Add Row']"));
		addRow.click();
		waitForWebElementToBeClickable(glCode);
		a.doubleClick(glCode).pause(1000).sendKeys(accountcode).build().perform();
		waitForWebElementToBeClickable(glAccount);
		a.doubleClick(glAccount).sendKeys(accountname).build().perform();
		a.doubleClick(glAccountDescription).sendKeys(accountdescription).build().perform();
		a.doubleClick(accountType).perform();
		accountTypeValues.click();
		a.doubleClick(activeFrom).sendKeys("01/01/2023").build().perform();
		a.scrollToElement(allocationGroup).perform();
		a.click(forecastRelevant).build().perform();
		a.doubleClick(templateAccountgroup).build().perform();
		for (WebElement tgroups : tags) {
			if (tgroups.getText().equalsIgnoreCase(tagname)) {
				tgroups.click();
			}
		}

		submit.click();

	}

}
