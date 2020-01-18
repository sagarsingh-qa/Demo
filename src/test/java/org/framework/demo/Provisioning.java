package org.framework.demo;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.framework.demo.resources.Base;
import org.framework.demo.resources.Xls_Reader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ProvisionLogin;

public class Provisioning extends Base {
	
	//public  static org.apache.log4j.Logger log = org.apache.log4j.LogManager.getLogger(Base.class.getName());
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void InitiateDriver() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("ProvisionURL"));
		log.info("Navigated to Provision Login Page");
	}

	@Test
	
	public void partnerLogin() throws IOException
	{
		//creating object to that class and invoke methods
		ProvisionLogin LP = new ProvisionLogin(driver);
		
		Xls_Reader Login_reader = datasheet(1);
		Xls_Reader form_reader = datasheet(1);
		
		LP.getUserName().sendKeys(Login_reader.getCellData("logindetails", "partner name", 2));
		LP.getPassword().sendKeys(Login_reader.getCellData("logindetails", "password", 2));
		LP.getLogin().submit();
		
		String getText = LP.getValidate().getText();
		if(getText.contentEquals("Provisioning Form"))
		{
			System.out.println("Logged in Successfully");
		}
		else
		{
			System.out.println("Error in Login");
		}
		
		//Fill the Form
		
		LP.getaccountname().sendKeys(form_reader.getCellData("provisioningdata", "AccountName", 2));
		LP.getextension(form_reader.getCellData("provisioningdata", "Extension", 2));
		LP.getphonenumber().sendKeys(form_reader.getCellData("provisioningdata", "PhoneNumber", 2));
		LP.getcompanyname().sendKeys(form_reader.getCellData("provisioningdata", "Company Name", 2));
	
		//LP.gettimezone(form_reader.getCellData("provisioningdata", "timezone", 2));
		LP.gettimezone("Eniwetok, Kwajalein(-12:00)");
	
		LP.getindustry(form_reader.getCellData("provisioningdata", "industry", 2));
		LP.getfirstname().sendKeys(form_reader.getCellData("provisioningdata", "firstname", 2));
		LP.getlastname().sendKeys(form_reader.getCellData("provisioningdata", "lastname", 2));
		LP.getemail().sendKeys(form_reader.getCellData("provisioningdata", "email", 2));
		LP.getre_email().sendKeys(form_reader.getCellData("provisioningdata", "reemail", 2));
		
		//get the paymentmode
		String mode = form_reader.getCellData("provisioningdata", "paymentmode", 2);
		
		switch(mode)
		{
		case "Credit Card": 
			LP.getpaymentmode_creditcard().click();
			break;
		case "Check":
			LP.getpaymentmode_check().click();
			break;
		case "Electronic Funds Transfer":
			LP.getpaymentmode_eft().click();
			break;
		}
		
		LP.getcardtype(form_reader.getCellData("provisioningdata", "cardtype", 2));
		LP.getexpire_month(form_reader.getCellData("provisioningdata", "month", 2));
		LP.getexpire_year(form_reader.getCellData("provisioningdata", "year", 2));
		LP.getcreditcardnumber().sendKeys(form_reader.getCellData("provisioningdata", "creditcardnumber", 2));
		LP.getccname().sendKeys(form_reader.getCellData("provisioningdata", "ccname", 2));
		LP.getccid().sendKeys(form_reader.getCellData("provisioningdata", "ccid", 2));
		LP.getbillingemail().sendKeys(form_reader.getCellData("provisioningdata", "billingemail", 2));
		LP.getadd1().sendKeys(form_reader.getCellData("provisioningdata", "add1", 2));
		LP.getadd2().sendKeys(form_reader.getCellData("provisioningdata", "add2", 2));
		LP.getcity().sendKeys(form_reader.getCellData("provisioningdata", "city", 2));
		LP.getstate(form_reader.getCellData("provisioningdata", "state", 2));
		LP.getzip().sendKeys(form_reader.getCellData("provisioningdata", "zip", 2));
		LP.getcountry(form_reader.getCellData("provisioningdata", "country", 2));
		LP.getlocationname().sendKeys(form_reader.getCellData("provisioningdata", "LocationName", 2));
		LP.getLadd1().sendKeys(form_reader.getCellData("provisioningdata", "Ladd1", 2));
		LP.getLadd2().sendKeys(form_reader.getCellData("provisioningdata", "Ladd2", 2));
		LP.getLcity().sendKeys(form_reader.getCellData("provisioningdata", "LCity", 2));
		LP.getLstate(form_reader.getCellData("provisioningdata", "Lstate", 2));
		LP.getLzip().sendKeys(form_reader.getCellData("provisioningdata", "Lzip", 2));
		LP.getLcountry(form_reader.getCellData("provisioningdata", "Lcountry", 2));
		LP.getPsubmit().click();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many different data types test should run
		//column stands for how many values or test data required for each test
		
		Object[][] data = new Object[1][2];
		
		//0th row
		data[0][0] = "qa";
		data[0][1] = "abc@1234";
		
		return data;
	}
	
	/*
	 * @AfterTest public void teardown() { driver.close(); driver=null; }
	 */
}
