package fpa.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import fpa.baseTest.TestComponents;

public class introduction extends TestComponents{
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		Actions a = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		String companycode = "Ideas2IT80";
		String companyname = "Ideas2IT80";
		String companycurrency = "EUR";
		String fiscalcalendar = "FC01";
		String locationcode = "Losangeles";
		String locationname = "Losangeles";
		String countryname = "United States";
		String BUcode = "RAVEN42";
		String BUname = "RAVEN42";
		String Deptcode = "admin12";
		String Deptname = "admin12";
		String template_name = "onetime7";
		String accountcode = " GL006";
		String accountname = " COGS6";
		String accountdescription = " COGS6";
		String tagname = "tag5";
		driver.get("http://uat.msciq.io/");
		driver.manage().window().maximize();
		login(driver);
		 addCompany(driver, a, companycode, companyname, companycurrency,
		 fiscalcalendar);
		addLocation(driver, locationcode, locationname, countryname, a, companyname);
		addBusinessunit(driver, a, BUcode, BUname);
		addDepartment(driver, wait, a, Deptcode, Deptname);
		homepage(driver);
		addtemplateaccountgroup(driver, wait, tagname);
		addglaccount(driver, wait, a, accountcode, accountname, accountdescription, tagname);
		homepage(driver);
		planningtemplates(driver, wait, template_name);
	}

	public static void login(WebDriver driver) {
		driver.findElement(By.id("email")).sendKeys("admin@msciq.io");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	public static void addCompany(WebDriver driver, Actions a, String companycode, String companyname,
			String companycurrency, String fiscalcalendar) throws InterruptedException {
		Thread.sleep(3000);
		WebElement Business_Structure = driver.findElement(By.xpath("//p[text()='Master Data']"));
		a.moveToElement(Business_Structure).click().perform();
		WebElement Business_Structure1 = driver.findElement(By.xpath("//p[text()='Meta Structure']"));
		a.moveToElement(Business_Structure1).click().perform();
		//// p[text()='Core Data Structure']
		WebElement Business_Structure2 = driver.findElement(By.xpath("//p[text()='Core Data Structure']"));
		a.moveToElement(Business_Structure2).click().perform();
		WebElement company = driver.findElement(By.xpath("//p[text()='Company']"));
		a.moveToElement(company).click().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-zo2mn6']")).click();

		// Add company
		driver.findElement(By.xpath("//button[text()='+ Add Company']")).click();
		Thread.sleep(2000);
		WebElement company_code = driver.findElement(By.xpath("//tbody/tr/td[3]"));
		a.doubleClick(company_code).sendKeys(companycode).perform();
		WebElement company_name = driver.findElement(By.xpath("//tbody/tr/td[4]"));
		a.doubleClick(company_name).sendKeys(companyname).perform();
		WebElement currency = driver.findElement(By.xpath("//tbody/tr/td[5]"));
		a.doubleClick(currency).sendKeys(companycurrency).perform();
		List<WebElement> currencyList = driver.findElements(By.cssSelector(".jdropdown-item div"));
		for (WebElement currencies : currencyList) {
			if (currencies.getText().equalsIgnoreCase(companycurrency)) {
				currencies.click();
				break;
			}
		}
		WebElement fiscal = driver.findElement(By.xpath("//tbody/tr/td[6]"));
		a.doubleClick(fiscal).sendKeys(fiscalcalendar).perform();
		List<WebElement> calendar = driver.findElements(By.cssSelector(".jdropdown-item div"));
		;
		for (WebElement calendarlist : calendar) {
			if (calendarlist.getText().equalsIgnoreCase(fiscalcalendar)) {
				calendarlist.click();
				break;
			}
		}
		Thread.sleep(3000);
		WebElement targetElement = driver.findElement(By.cssSelector("thead tr td:nth-child(10)"));
		a.scrollToElement(targetElement).perform();
		Thread.sleep(3000);
		WebElement activeDate = driver.findElement(By.xpath("//tbody/tr/td[8]"));
		a.doubleClick(activeDate).sendKeys("01/01/2023").perform();
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	public static void addLocation(WebDriver driver, String locationcode, String locationname, String countryname,
			Actions a, String companycode) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//div[@class='MuiGrid-root MuiGrid-item css-1wxaqej']/p[text()='ACME-ACME Corporation']"))
				.click();
		Thread.sleep(3000);
		List<WebElement> companylist = driver.findElements(
				By.xpath("//div[@class='MuiCollapse-wrapper MuiCollapse-vertical css-hboir5']/div/li/div/div/div[2]"));
		for (WebElement companydetails : companylist) {
			if (companydetails.getText().contains(companycode)) {
				companydetails.click();
				break;
			}
		}
		driver.findElement(By.xpath("//button[text()='+ Add Location']")).click();
		Thread.sleep(3000);
		WebElement location_code = driver.findElement(By.xpath("//tbody/tr/td[3]"));
		a.doubleClick(location_code).sendKeys(locationcode).perform();
		WebElement location_name = driver.findElement(By.xpath("//tbody/tr/td[4]"));
		a.doubleClick(location_name).sendKeys(locationname).perform();
		WebElement address = driver.findElement(By.xpath("//tbody/tr/td[5]"));
		a.doubleClick(address).sendKeys("132, My Street, Kingston").perform();
		WebElement country = driver.findElement(By.xpath("//tbody/tr/td[6]"));
		a.doubleClick(country).sendKeys(countryname).perform();
		Thread.sleep(3000);
		List<WebElement> countries = driver.findElements(By.cssSelector(".jdropdown-item div"));
		for (WebElement countrylist : countries) {
			if (countrylist.getText().equalsIgnoreCase(countryname)) {
				countrylist.click();
				break;

			}
		}
		Thread.sleep(3000);
		WebElement Active_from = driver.findElement(By.cssSelector("thead tr td:nth-child(11)"));
		a.scrollToElement(Active_from).perform();
		Thread.sleep(3000);
		WebElement activeDate = driver.findElement(By.xpath("//tbody/tr/td[9]"));
		a.doubleClick(activeDate).sendKeys("01/01/2023").perform();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	public static void addBusinessunit(WebDriver driver, Actions a, String BUcode, String BUname)
			throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Business Unit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Add Business Unit']")).click();
		WebElement goc = driver.findElement(By.cssSelector("tbody tr td:nth-child(2)"));
		a.doubleClick(goc).perform();
		driver.findElement(By.cssSelector(".jdropdown-description")).click();
		Thread.sleep(3000);
		WebElement businessunit_code = driver.findElement(By.xpath("//tbody//tr//td[3]"));
		a.doubleClick(businessunit_code).sendKeys(BUcode).perform();
		WebElement businessunit_name = driver.findElement(By.xpath("//tbody//tr//td[4]"));
		a.doubleClick(businessunit_name).sendKeys(BUname).perform();
		WebElement Active_from = driver.findElement(By.xpath("//tbody//tr//td[6]"));
		a.doubleClick(Active_from).sendKeys("01/01/2023").perform();
		driver.findElement(By.xpath("//button[text()='Save']")).click();

	}

	public static void addDepartment(WebDriver driver, WebDriverWait wait, Actions a, String Deptcode, String Deptname)
			throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Department']")).click();
		Thread.sleep(3000);
		WebElement addButton = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//tbody/tr[1]/td[13]/div/span[@aria-label='Add Row']")));
		addButton.click();
		WebElement Departmentcode = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[2]/td[2]")));
		a.doubleClick(Departmentcode).pause(1000).sendKeys(Deptcode).build().perform();
		WebElement Departmentname = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[2]/td[3]")));
		a.doubleClick(Departmentname).sendKeys(Deptname).perform();
		WebElement Active_from = driver.findElement(By.xpath("//tbody/tr[2]/td[6]"));
		a.doubleClick(Active_from).sendKeys("1/1/23").perform();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(3000);
//		WebElement assignDept = driver.findElement(By.cssSelector("thead tr td:nth-child(12)"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", assignDept);
//		
//	//thead tr td:nth-child(12)
//		a.scrollToElement(assignDept).perform();

//		WebElement mapDepartment = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[2]/td[10]/div/div/button")));
//		mapDepartment.click();

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

	public static void addtemplateaccountgroup(WebDriver driver, WebDriverWait wait, String tagname) {
		WebElement master_data_management = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@class='card-title MuiBox-root css-1itv5e3']/p[text()='Master Data Management']")));
		master_data_management.click();
		WebElement tag = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Template Account Group']")));
		tag.click();
		WebElement addTag = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[text()='+ Add Template Account Group']")));
		addTag.click();
		WebElement tagName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
		tagName.sendKeys(tagname);
		driver.findElement(By.xpath("//button[text()='Save']")).click();

		// driver.findElement(By.xpath(".react-select-container.css-b62m3t-container")).click();

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