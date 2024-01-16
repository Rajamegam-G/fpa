package fpa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import fpa.baseTest.TestComponents;
import fpa.pages.company;

public class companyTestCase extends TestComponents {

	String companycode = "Ideas2IT0193";
	String companyname = "Ideas2IT0193";
	String companycurrency = "EUR";
	String fiscalcalendar = "FC01";

	@Test(priority=0)
	// Add company
	public void addCompanyTest() throws InterruptedException {
		company cp = new company(driver);
		cp.addcompany(companycode, companyname, companycurrency, fiscalcalendar);

	}

	// search & read company
	@Test(priority=1)
	public void readCompanyTest() throws InterruptedException {
		company cp = new company(driver);
		Thread.sleep(2000);
		cp.searchcompany(companycode);
		Thread.sleep(3000);
		List<WebElement> companyList = driver.findElements(By.xpath("//tbody/tr[2]/td[2]"));
		for (WebElement company : companyList) {
			String ccode = company.getText().trim();
			System.out.println(ccode);
			Assert.assertEquals(ccode, companycode, "Company doesnot matches");

		}
	}
	//edit the company
	@Test(priority=2, dependsOnMethods = "readCompanyTest")
	public void editCompanyTest() throws InterruptedException {
		company cp = new company(driver);
		cp.editcompany(companycode);
	}

}