package fpa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import fpa.AbstractComponents.abstractComponents;

public class planningTemplates extends abstractComponents {
	WebDriver driver;

	public planningTemplates(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='menu-card-container MuiBox-root css-n6niph']/div/p[text()='Templates']")
	WebElement templates;
	@FindBy(xpath = "//button[text()='+ Add New Template']")
	WebElement newtemplate;
	@FindBy(xpath = "//button[text()='Create New Template']")
	WebElement createnewtemplate;
	@FindBy(id = "name")
	WebElement templatename;
	@FindBy(xpath = "//div[@id='mui-component-select-type']")
	WebElement selectTemplateType;
	@FindBy(xpath = "//div/ul/li")
	List<WebElement> listOfTemplates;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement submit;
	@FindBy(xpath = "//span[@role='progressbar']")
	WebElement progressbar;

	public void planningtemplates(String template_name) {
		goToHomePage();
		waitForWebElementToBeinvisible(progressbar);
		goToForecastAdministration();
		templates.click();
		waitForpresenceofElementLocated(By.xpath("//button[text()='+ Add New Template']"));
		newtemplate.click();
		waitForpresenceofElementLocated(By.xpath("//button[text()='Create New Template']"));
		createnewtemplate.click();
		waitForWebElementToBeinvisible(progressbar);
		waitForpresenceofElementLocated(By.id("name"));
		templatename.sendKeys(template_name);
		selectTemplateType.click();
		for (WebElement templatetype : listOfTemplates) {
			if (templatetype.getText().equalsIgnoreCase("One-Time")) {
				templatetype.click();
				break;
			}
		}
		submit.click();

	}

}
