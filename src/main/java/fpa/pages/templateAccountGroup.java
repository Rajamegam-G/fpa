package fpa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import fpa.AbstractComponents.abstractComponents;

public class templateAccountGroup extends abstractComponents {
	WebDriver driver;

	public templateAccountGroup(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addtemplateaccountgroup(WebDriverWait wait, String tagname) {
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
}
