package fpa.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import fpa.pages.planningTemplates;
import fpa.pages.templateAccountGroup;

public class forecast extends TestComponents {
	@Test
	public void forecastflow() throws IOException, InterruptedException {
		// TODO Auto-generated method s9ub
		String companycode = "Ideas2IT111";
		String companyname = "Ideas2IT111";
		String companycurrency = "EUR";
		String fiscalcalendar = "FC01";
		String locationcode = "Losangeles";
		String locationname = "Losangeles";
		String countryname = "United States";
		String BUcode = "RAVEN63";
		String BUname = "RAVEN63";
		String Deptcode = "admin28";
		String Deptname = "admin28";
		String template_name = "onetime15";
		String accountcode = " GL0016";
		String accountname = " COGS16";
		String accountdescription = "COGS16";
		String tagname = "tag15";
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
		planningTemplates pt = new planningTemplates(driver);
		pt.planningtemplates(template_name);
	}

}
