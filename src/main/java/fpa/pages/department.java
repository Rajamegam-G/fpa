package fpa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fpa.AbstractComponents.abstractComponents;

public class department extends abstractComponents {
	WebDriver driver;

	public department(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//div[@class='menu-card-container MuiBox-root css-n6niph']/div/p[text()='Department']")
	WebElement Departmenttile;
	@FindBy(xpath = "//tbody/tr[1]/td[13]/div/span[@aria-label='Add Row']")
	WebElement addbutton;
	@FindBy(xpath = "//tbody/tr[2]/td[2]")
	WebElement Departmentcode;
	@FindBy(xpath = "//tbody/tr[2]/td[3]")
	WebElement Departmentname;
	@FindBy(xpath = "//tbody/tr[2]/td[6]")
	WebElement activeDate;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement submit;
	@FindBy(css = "thead tr td:nth-child(12)")
	WebElement targetElement;
	@FindBy(xpath = "//tbody/tr[2]/td[10]/div/div/button")
	WebElement assignDepartment;
	@FindBy(xpath="//span[@role='progressbar']")
	WebElement progressbar;

	public void addDepartment(String Deptcode, String Deptname) throws InterruptedException {
		Actions a = new Actions(driver);
		Thread.sleep(3000);
		goToHomePage();
		Thread.sleep(3000);
		waitForWebElementToBeinvisible(progressbar);
		goToCoreBusinessStructure();
		Departmenttile.click();
		Thread.sleep(3000);
		waitForpresenceofElementLocated(By.xpath("//tbody/tr[1]/td[13]/div/span[@aria-label='Add Row']"));
		addbutton.click();
		waitForWebElementToBeClickable(Departmentcode);
		a.doubleClick(Departmentcode).pause(1000).sendKeys(Deptcode).build().perform();
		waitForWebElementToBeClickable(Departmentname);
		a.doubleClick(Departmentname).sendKeys(Deptname).perform();
		a.doubleClick(activeDate).sendKeys("1/1/23").perform();
		submit.click();
		Thread.sleep(3000);
//		a.scrollToElement(targetElement).build().perform();
//		waitForWebElementToBeClickable(assignDepartment);
//		assignDepartment.click();

	}
}
