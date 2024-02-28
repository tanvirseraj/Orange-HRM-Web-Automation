package com.it.bd.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {
protected static String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

protected static String url2 = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";

protected static String url3 = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	
	WebDriver driver;

	@BeforeSuite
	public void startBrowser() {
		String browserName = System.getProperty("browser", "chrome");

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		
		PageDriver.getInstance().setDriver(driver);
	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
}
