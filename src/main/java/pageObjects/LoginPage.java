package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By username = By.xpath("//input[@type='text']");
	
	By password = By.xpath("//input[@type='password']");
	
	By LoginSubmit = By.xpath("//input[@type='submit']");
	
	By Title = By.xpath("//h2[contains(text(),'Login')]");
	
	public WebElement getUserName()
	{
		return driver.findElement(username);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(LoginSubmit);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(Title);
	}
}
