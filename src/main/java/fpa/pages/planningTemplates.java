package fpa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	public void planningtemplates(WebDriver driver, WebDriverWait wait, String template_name) {
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
