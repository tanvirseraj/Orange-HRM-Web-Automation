package com.it.bd.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.it.bd.drivers.PageDriver;
import com.it.bd.pages.AddEmployeePage;
import com.it.bd.pages.LoginPage;
import com.it.bd.utilities.CommonMethods;
import com.it.bd.utilities.ExtentFactory;

public class AddEmployeeTest extends CommonMethods{
	
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void openUrl() throws InterruptedException {
		PageDriver.getCurrentDriver().get(url2);
		timeout();
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Add Employee</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}
	
	
	@Test 
	public void testAddEmployeeMethod() throws IOException {
		//System.out.println(PageDriver.getCurrentDriver().getTitle());
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Add Employee Details</b></p>");
	    AddEmployeePage addEmployeePage = new AddEmployeePage(childTest);
	    addEmployeePage.addemployeepage();
	    
	}
	
	
	@AfterClass
	public void report() {
		report.flush();
	}
}
