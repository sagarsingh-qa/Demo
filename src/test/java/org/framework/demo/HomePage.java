package org.framework.demo;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.framework.demo.resources.Base;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class HomePage extends Base {
	
	//public  static org.apache.log4j.Logger log = org.apache.log4j.LogManager.getLogger(Base.class.getName());
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void InitiateDriver() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("URL"));
		log.info("Navigated to Home Page");
	}

	@Test(dataProvider="getData")
	
	public void HomePage(String username,String password) throws IOException
	{
		//creating object to that class and invoke methods
		LoginPage LP = new LoginPage(driver);
		
		//compare the text from browser with actual value..
		Assert.assertEquals(LP.getTitle().getText(), "Login");
		log.error("Title not matched");
		log.info("Successfull validated the text message");
		Assert.assertTrue(LP.getLogin().isEnabled());
		LP.getUserName().sendKeys(username);
		LP.getPassword().sendKeys(password);
		LP.getLogin().submit();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many different data types test should run
		//column stands for how many values or test data required for each test
		
		Object[][] data = new Object[1][2];
		
		//0th row
		data[0][0] = "security";
		data[0][1] = "abc@12345";
		
		/*
		 * //1st Row data[1][0] = "gr.calls"; data[1][1] = "abc@1234";
		 */
		
		return data;
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
}
