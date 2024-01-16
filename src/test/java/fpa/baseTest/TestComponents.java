package fpa.baseTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import fpa.pages.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestComponents {
	public WebDriver driver;
	public Landingpage lp;

	public WebDriver initializeDriver() throws IOException {
		// Properties prop = new Properties();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	@BeforeTest
	public Landingpage launchapplication() throws IOException {
		driver = initializeDriver();
		lp = new Landingpage(driver);
		lp.goTo();
		lp.landinpage();
		return lp;

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}