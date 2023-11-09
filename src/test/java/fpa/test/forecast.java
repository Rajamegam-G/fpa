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
import fpa.pages.glAccount;
import fpa.pages.location;
import fpa.pages.templateAccountGroup;

public class forecast extends TestComponents {
	@Test
	public void forecastflow() throws IOException, InterruptedException {
		// TODO Auto-generated method s9ub
		String companycode = "Ideas2IT100";
		String companyname = "Ideas2IT100";
		String companycurrency = "EUR";
		String fiscalcalendar = "FC01";
		String locationcode = "Losangeles";
		String locationname = "Losangeles";
		String countryname = "United States";
		String BUcode = "RAVEN54";
		String BUname = "RAVEN54";
		String Deptcode = "admin19";
		String Deptname = "admin19";
		String template_name = "onetime7";
		String accountcode = " GL007";
		String accountname = " COGS7";
		String accountdescription = " COGS7";
		String tagname = "tag7";

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
		glAccount gl = new glAccount(driver);
		gl.addglaccount(accountcode, accountname, accountdescription, tagname);

//		planningtemplates(driver, wait, template_name);
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
