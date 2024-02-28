package com.it.bd.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.it.bd.drivers.PageDriver;
import com.it.bd.utilities.ExcelUtils;
import com.it.bd.utilities.GetScreenShot;
import com.it.bd.utilities.TestRandomData;

public class LoginPage {
ExtentTest test;

ExcelUtils excelUtils = new ExcelUtils();
//TestRandomData testRandomData = new TestRandomData();
	
	public LoginPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}

	/*
	 * 1. Locators 2. Methods
	 */

	@FindBys({ @FindBy(xpath = "//input[@name='username']") })
	WebElement userName;

	@FindBys({ @FindBy(xpath = "//input[@name='password']") })
	WebElement password;

	@FindBys({ @FindBy(xpath = "//button[@type='submit']") })
	WebElement submit;
	
	
	//Pass Case
	public void passCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
	}
	
	public void passCaseWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}
	
	//Fail Case
	public void failCase(String message, String scName) throws IOException {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}

	public void login() throws IOException {
		excelUtils.writeExcelData("Tanvir", "Seraj", "tanvirseraj@yopmail.com", "01714932886", "1207");
		excelUtils.ReadExcel();
	    //testRandomData.randomData();
		try {
			test.info("Please enter your username.");
			if (userName.isDisplayed()) {
				userName.sendKeys(excelUtils.username);
				passCase("You have entered your username");
				Thread.sleep(2000);
				try {
					test.info("Please enter your password.");
					if (password.isDisplayed()) {
						password.sendKeys(excelUtils.password);
						passCase("You have entered your password");
						Thread.sleep(2000);
						try {
							test.info("Please click on the Login Button.");
							if (submit.isDisplayed()) {
								submit.click();
								Thread.sleep(5000);
								passCaseWithSC("Submit is Successful", "login_pass");
							}
						} catch (Exception e) {
							failCase("Submit button was not locateable.", "submit_fail");
						}
					}
				} catch (Exception e) {
					failCase("Password was not locateable. Please check the error message.", "pass_fail");
					
				}
			}
		} catch (Exception e) {
			failCase("User name was not locateable. Please check the error message.", "username_fail");
		}
	}
}
