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

public class AddEmployeePage {
ExtentTest test;

public AddEmployeePage(ExtentTest test) {
	PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	this.test = test;
}

@FindBys({ @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]") })
WebElement pimbutton;


@FindBys({ @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]") })
WebElement addbutton;

@FindBys({ @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]") })
WebElement firstname;

@FindBys({ @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/input[1]") })
WebElement middlename;

@FindBys({ @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]") })
WebElement lastname;

@FindBys({ @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/input[1]") })
WebElement employeeid;

@FindBys({ @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/label[1]/span[1]") })
WebElement createlogindetails;

@FindBys({ @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/input[1]") })
WebElement username;

@FindBys({ @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/input[1]") })
WebElement password;

@FindBys({ @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[4]/div[1]/div[2]/div[1]/div[2]/input[1]") })
WebElement confirmpassword;

@FindBys({ @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/button[2]") })
WebElement savebutton;



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
	
	public void addemployeepage() throws IOException {
		try {
			test.info("Please click on the PIM button");
			if(pimbutton.isDisplayed()) {
				pimbutton.click();
				passCase("You have clicked PIM button");
				Thread.sleep(1000);
				try {
					test.info("Please click on the Add Button");
					if(addbutton.isDisplayed()) {
						addbutton.click();
						passCase("You have clicked on the Add Button");
						Thread.sleep(1000);
						try {
							test.info("Please enter the First Name");
							if(firstname.isDisplayed()) {
								firstname.sendKeys("Mr");
								passCase("You have entered First Name");
								Thread.sleep(1000);
								try {
									test.info("Please enter the Middle Name");
									if(middlename.isDisplayed()) {
										middlename.sendKeys("John");
										passCase("You have entered Middle Name");
										Thread.sleep(1000);
										try {
											test.info("Please enter the Last Name");
											if(lastname.isDisplayed()) {
												lastname.sendKeys("Dow");
												passCase("You have entered Last Name");
												Thread.sleep(1000);
												try {
													test.info("Please enter the Employee Id");
													if(employeeid.isDisplayed()) {
														employeeid.sendKeys("0340");
														passCase("You have entered Employee Id");
														Thread.sleep(1000);
														try {
															test.info("Please click on the Create Login Details");
															if(createlogindetails.isDisplayed()) {
																createlogindetails.click();
																passCase("You have clicked on the Create Login Details");
																Thread.sleep(1000);
																try {
																	test.info("Please enter the Username");
																	if(username.isDisplayed()) {
																		username.sendKeys("@john");
																		passCase("You have entered the Username");
																		Thread.sleep(1000);
																		try {
																			test.info("Please enter the Password");
																			if(password.isDisplayed()) {
																				password.sendKeys("o1234567");
																				passCase("You have entered the Password");
																				Thread.sleep(1000);
																				try {
																					test.info("Please enter the Confirm Password");
																					if(confirmpassword.isDisplayed()) {
																						confirmpassword.sendKeys("o12345678");
																						passCase("You have entered the Confirm Password");
																	                    Thread.sleep(1000);
																
																	                    try {
																	                    	test.info("Please Click on the Save Button");
																	                    	if(savebutton.isDisplayed()) {
																								savebutton.click();
																								Thread.sleep(1000);
																								passCaseWithSC("Save is Successful", "savesuccessfully_pass");
																	                    	}
																						} catch (Exception e) {
																							failCase("Save Button was not locateable. Please check the error message.", "savebutton_fail");
																						}
																					}
																				} catch (Exception e) {
																			
																					failCase("Confirm Password was not locateable. Please check the error message.", "confirmpassword_fail");
																				}
																			}
																		} catch (Exception e) {
																			failCase("Password was not locateable. Please check the error message.", "password_fail");
																		}
																	}
																} catch (Exception e) {
																	failCase("Username was not locateable. Please check the error message.", "username_fail");
																}
															}
														} catch (Exception e) {
															failCase("Create Login Details not locateable. Please check the error message.", "createlogindetails_fail");
														}
													}
												} catch (Exception e) {
													failCase("Employee Id was not locateable. Please check the error message.", "employeeid_fail");
												}
											}
										} catch (Exception e) {
											failCase("Last Name was not locateable. Please check the error message.", "lastname_fail");
										}
									}
								} catch (Exception e) {
									failCase("Middle Name was not locateable. Please check the error message.", "middlename_fail");
								}
							}
							
						} catch (Exception e) {
							failCase("First Name was not locateable. Please check the error message.", "firstname_fail");
						}
					}
				} catch (Exception e) {
					failCase("Add Button was not locateable. Please check the error message.", "addbutton_fail");	
				}
			}		
			
		} catch (Exception e) {
			failCase("PIM button was not locateable. Please check the error message.", "pimbutton_fail");
		}
	}







}

