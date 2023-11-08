package fpa.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class abstractComponents {
	WebDriver driver;
	@FindBy(xpath = "//div[@class='menu-card-container MuiBox-root css-n6niph']/div/p[text()='Master Data']")
	WebElement masterDataTile;
	@FindBy(xpath = "//div[@class='menu-card-container MuiBox-root css-n6niph']/div/p[text()='Meta Structure']")
	WebElement metaStructureTile;
	@FindBy(xpath = "//div[@class='menu-card-container MuiBox-root css-n6niph']/div/p[text()='Core Data Structure']")
	WebElement coreDataStructureTile;

	public abstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void visibilityofelements(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}

	public void waitForElementsToDisappear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));

	}

	public void waitForWebElementToAppear(WebElement wele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(wele));
	}

	public void waitForWebElementToBeClickable(WebElement wele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(wele));
	}

	public void waitForpresenceofElementLocated(By FindBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(FindBy));
	}

	public void goToCoreBusinessStructure() {
		masterDataTile.click();
		metaStructureTile.click();
		coreDataStructureTile.click();

	}
}