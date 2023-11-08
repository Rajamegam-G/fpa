package fpa.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import fpa.baseTest.TestComponents;
import fpa.pages.Landingpage;
import fpa.pages.businessUnit;
import fpa.pages.company;
import fpa.pages.department;
import fpa.pages.location;
import fpa.pages.templateAccountGroup;

public class forecast extends TestComponents {
	@Test
	public void forecastflow() throws IOException, InterruptedException {
		// TODO Auto-generated method s9ub
		String companycode = "Ideas2IT97";
		String companyname = "Ideas2IT97";
		String companycurrency = "EUR";
		String fiscalcalendar = "FC01";
		String locationcode = "Losangeles";
		String locationname = "Losangeles";
		String countryname = "United States";
		String BUcode = "RAVEN51";
		String BUname = "RAVEN51";
		String Deptcode = "admin16";
		String Deptname = "admin16";
		String template_name = "onetime7";
		String accountcode = " GL006";
		String accountname = " COGS6";
		String accountdescription = " COGS6";
		String tagname = "tag6";

		Landingpage lp = new Landingpage(driver);
		lp.goTo();
		lp.landinpage();

		company cp = new company(driver);
		cp.addcompany(companycode, companyname, companycurrency, fiscalcalendar);
		location loc = new location(driver);
		loc.addLocation(locationcode, locationname, countryname, companycode);
		businessUnit bu = new businessUnit(driver);
		bu.addBusinessUnit(BUcode, BUname);
		department dep = new department(driver);
		dep.addDepartment(Deptcode, Deptname);
		templateAccountGroup tag = new templateAccountGroup(driver);
		tag.addtemplateaccountgroup(tagname);

//		homepage(driver);
//		addtemplateaccountgroup(driver, wait, tagname);
//		addglaccount(driver, wait, a, accountcode, accountname, accountdescription, tagname);
//		homepage(driver);
//		planningtemplates(driver, wait, template_name);
	}

	public static void homepage(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//div[@class='MuiGrid-root MuiGrid-container css-8p7p4d']//div[@class='MuiGrid-root MuiGrid-item css-v5xql3']"))
				.click();

	}

	public static void addglaccount(WebDriver driver, WebDriverWait wait, Actions a, String accountcode,
			String accountname, String accountdescription, String tagname) throws InterruptedException {
		Thread.sleep(3000);
		WebElement accounts = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Accounts']")));
		accounts.click();
		WebElement addrow = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//tbody/tr[1]/td[24]/div/span[@aria-label='Add Row']")));
		addrow.click();
		WebElement GLcode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[2]/td[2]")));
		a.doubleClick(GLcode).sendKeys(accountcode).perform();
		WebElement GLAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[2]/td[3]")));
		a.doubleClick(GLAccount).sendKeys(accountname).perform();
		WebElement Account_Description = driver.findElement(By.xpath("//tbody/tr[2]/td[4]"));
		a.doubleClick(Account_Description).sendKeys(accountdescription).perform();
		WebElement Account_Type = driver.findElement(By.xpath("//tbody/tr[2]/td[5]"));
		a.doubleClick(Account_Type).perform();
		WebElement accounttype_values = driver.findElement(By.xpath("//div[@id='P&L']"));
		accounttype_values.click();
		WebElement Active_from = driver.findElement(By.xpath("//tbody/tr[2]/td[8]"));
		a.doubleClick(Active_from).sendKeys("01/01/2023").perform();
		WebElement allocationgroup = driver.findElement(By.xpath("//tbody/tr[2]/td[12]"));
		a.scrollToElement(allocationgroup).perform();
		WebElement forecastrelevant = driver.findElement(By.xpath("//tbody/tr[2]/td[10]"));
		a.click(forecastrelevant).perform();
		WebElement templateaccountgroup = driver.findElement(By.xpath("//tbody/tr[2]/td[11]"));
		a.click(templateaccountgroup).perform();
		List<WebElement> tags = driver.findElements(By.xpath("//div[@class='jdropdown-content']/div"));
		for (WebElement tgroups : tags) {
			if (tgroups.getText().equalsIgnoreCase(tagname)) {
				tgroups.click();
			}
		}

		driver.findElement(By.xpath("//button[text()='Save']")).click();

	}

	public static void planningtemplates(WebDriver driver, WebDriverWait wait, String template_name) {
		WebElement forecast_setup = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@class='card-title MuiBox-root css-1itv5e3']/p[text()='Forecast Setup']")));
		forecast_setup.click();
		WebElement planning_templates = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Planning Templates']")));
		planning_templates.click();
		WebElement newtemplate = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='+ Add New Template']")));
		newtemplate.click();
		WebElement createnewtemplate = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Create New Template']")));
		createnewtemplate.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name"))).sendKeys(template_name);
		driver.findElement(By.xpath("//div[@id='mui-component-select-type']")).click();
		List<WebElement> type = driver.findElements(By.xpath("//div/ul/li"));
		for (WebElement templatetype : type) {
			if (templatetype.getText().equalsIgnoreCase("One-Time")) {
				templatetype.click();
				break;
			}
		}
		driver.findElement(By.xpath("//button[text()='Save']")).click();

	}

}
