package org.framework.demo.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static WebDriver  driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Sagar\\eclipse-workspace\\demo\\src\\main\\java\\org\\framework\\demo\\resources\\data.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		String URL = prop.getProperty("URL");
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sagar\\eclipse-workspace\\demo\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			//driver.get(URL);
		}
		else if (browser=="firefox")
		{
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void getScreenshot(String result) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File("C:\\Users\\Sagar\\eclipse-workspace\\demo\\screenshots\\"+result+"screenshot.png"));
		
	}
}
