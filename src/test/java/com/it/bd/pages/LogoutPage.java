package com.it.bd.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.it.bd.drivers.PageDriver;
import com.it.bd.utilities.GetScreenShot;

public class LogoutPage {
	ExtentTest test;
	public LogoutPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	@FindBys({ @FindBy(xpath = "//header/div[1]/div[2]/ul[1]/li[1]/span[1]") })
	WebElement orangetestbutton;
	
	@FindBys({ @FindBy(xpath = "//a[contains(text(),'Logout')]") })
	WebElement logoutbutton;
	
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
		
		public void logoutpage() throws IOException {
		try {
			test.info("Please click on the Orange Test button");
			if(orangetestbutton.isDisplayed()) {
				orangetestbutton.click();
				passCase("You have clicked Orange Test button");
				Thread.sleep(1000);
				try {
					test.info("Please click on the Logout button");
					if(logoutbutton.isDisplayed()) {
						logoutbutton.click();
						passCaseWithSC("Logout is Successful", "successfully_logout");
						Thread.sleep(1000);
					}
				} catch (Exception e) {
					failCase("Logout button was not locateable. Please check the error message.", "logoutbutton_fail");	
				}
			}
		} catch (Exception e) {
			failCase("Orange Test button was not locateable. Please check the error message.", "orangetestbutton_fail");
		}
		
		
		}
	
	
	
	
}
