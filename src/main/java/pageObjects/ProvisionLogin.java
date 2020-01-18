package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProvisionLogin {
public WebDriver driver;
	
	public ProvisionLogin(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void dropdownvalue(By Element, String text)
	{
		System.out.println("Inside the select method"+text);
		Select dd = new Select(driver.findElement(Element));
		dd.selectByVisibleText(text);
	}
	
	//Login 
	By username = By.xpath("//input[@name='dealerinfo.dealername']");
	
	By password = By.xpath("//input[@id='CSDLoginAction_dealerinfo_dpassword']");
	
	By LoginSubmit = By.xpath("//input[@type='submit']");
	
	By ValidatePage = By.xpath("//h1[contains(text(),'Provisioning Form')]");
	
	//Form
	By accountname = By.xpath("//input[@id='ProvisioningAction_provisioningobj_accountname']");
	By extension = By.xpath("//select[@id='ProvisioningAction_provisioningobj_extnlength']");
	By phonenumber = By.xpath("//input[@id='ProvisioningAction_provisioningobj_curphonenum']");
	By companyname = By.xpath("//input[@id='ProvisioningAction_provisioningobj_companyname']");
	By timezone = By.xpath("//select[@id='ProvisioningAction_provisioningobj_timezone']");
	By industry = By.xpath("//select[@id='ProvisioningAction_provisioningobj_industrytype']");
	
	By firstname = By.xpath("//input[@id='ProvisioningAction_provisioningobj_firstname']");
	By lastname = By.xpath("//input[@id='ProvisioningAction_provisioningobj_lastname']");
	By email = By.xpath("//input[@id='ProvisioningAction_provisioningobj_email']");
	By re_email = By.xpath("//input[@id='ProvisioningAction_provisioningobj_retypeemail']");
	
	By paymentmode_creditcard = By.xpath("//table[@class='mainTable']//input[2]");
	By paymentmode_check = By.xpath("//table[@class='mainTable']//input[3]");
	By paymentmode_eft = By.xpath("//table[@class='mainTable']//input[4]");
	
	By cardtype = By.xpath("//select[@id='ProvisioningAction_provisioningobj_paymenttype']");
	By expire_month = By.xpath("//select[@id='ProvisioningAction_provisioningobj_expires_month']");
	By expire_year = By.xpath("//select[@name='provisioningobj.expires_year']");
	By creditcardnumber = By.xpath("//input[@id='ProvisioningAction_provisioningobj_creditcardnumber']");
	By ccname = By.xpath("//input[@id='ProvisioningAction_provisioningobj_nameoncard']");
	By ccid = By.xpath("//input[@id='ProvisioningAction_provisioningobj_cardid']");
	By billingemail = By.xpath("//input[@id='ProvisioningAction_provisioningobj_billingEmailAddr']");
	By add1 = By.xpath("//input[@id='ProvisioningAction_provisioningobj_pay_StreetAddNo']");
	By add2 = By.xpath("//input[@id='ProvisioningAction_provisioningobj_pay_StrtName']");
	By city = By.xpath("//input[@id='ProvisioningAction_provisioningobj_city_payment']");
	By state = By.xpath("//select[@id='ProvisioningAction_provisioningobj_state_payment']");
	By zip = By.xpath("//input[@id='ProvisioningAction_provisioningobj_postalcode_payment']");
	By country = By.xpath("//select[@id='ProvisioningAction_provisioningobj_country_payment']");
	
	By locationname = By.xpath("//input[@id='ProvisioningAction_provisioningobj_locationname']");
	By Ladd1 = By.xpath("//input[@id='ProvisioningAction_provisioningobj_loca_StreetAddressNumber']");
	By Ladd2 = By.xpath("//input[@id='ProvisioningAction_provisioningobj_loca_StreetName']");
	By Lcity = By.xpath("//input[@id='ProvisioningAction_provisioningobj_city_location']");
	By Lstate = By.xpath("//select[@id='ProvisioningAction_provisioningobj_state_location']");
	By Lzip = By.xpath("//input[@id='ProvisioningAction_provisioningobj_postalcode_location']");
	By Lcountry = By.xpath("//select[@id='ProvisioningAction_provisioningobj_country_location']");
	
	By Psubmit = By.xpath("//input[@id='ProvisioningAction_submit']"); 
	
	
	
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
	
	public WebElement getValidate()
	{
		return driver.findElement(ValidatePage);
	}

	//Form Methods
	
	public WebElement getaccountname()
	{
		return driver.findElement(accountname);
	}
	public void getextension(String ext)
	{
		dropdownvalue(extension,ext);
	}
	
	public String selectedextension()
	{
		String selectExt =  driver.findElement(extension).getText();
		return selectExt;
	}

	public WebElement getphonenumber()
	{
		return driver.findElement(phonenumber);
	}
	public WebElement getcompanyname()
	{
		return driver.findElement(companyname);
	}

	public void gettimezone(String text)
	{
		dropdownvalue(timezone,text);
	}

	public void getindustry(String text)
	{
		dropdownvalue(industry,text);
	}

	public WebElement getfirstname()
	{
		return driver.findElement(firstname);
	}

	public WebElement getlastname()
	{
		return driver.findElement(lastname);
	}

	public WebElement getemail()
	{
		return driver.findElement(email);
	}

	public WebElement getre_email()
	{
		return driver.findElement(re_email);
	}

	public WebElement getpaymentmode_creditcard()
	{
		return driver.findElement(paymentmode_creditcard);
	}
	public WebElement getpaymentmode_check()
	{
		return driver.findElement(paymentmode_check);
	}
	public WebElement getpaymentmode_eft()
	{
		return driver.findElement(paymentmode_eft);
	}
	public void getcardtype(String type)
	{
		dropdownvalue(cardtype,type);
	}

	public void getexpire_month(String month)
	{
		dropdownvalue(expire_month,month);
	}

	public void getexpire_year(String year)
	{
		dropdownvalue(expire_year,year);
	}

	public WebElement getcreditcardnumber()
	{
		return driver.findElement(creditcardnumber);
	}

	public WebElement getccname()
	{
		return driver.findElement(ccname);
	}

	public WebElement getccid()
	{
		return driver.findElement(ccid);
	}

	public WebElement getbillingemail()
	{
		return driver.findElement(billingemail);
	}

	public WebElement getadd1()
	{
		return driver.findElement(add1);
	}

	public WebElement getadd2()
	{
		return driver.findElement(add2);
	}

	public WebElement getcity()
	{
		return driver.findElement(city);
	}

	public void getstate(String txt)
	{
		dropdownvalue(state, txt);
	}

	public WebElement getzip()
	{
		return driver.findElement(zip);
	}

	public void getcountry(String text)
	{
		dropdownvalue(country, text);
	}

	public WebElement getlocationname()
	{
		return driver.findElement(locationname);
	}

	public WebElement getLadd1()
	{
		return driver.findElement(Ladd1);
	}

	public WebElement getLadd2()
	{
		return driver.findElement(Ladd2);
	}

	public WebElement getLcity()
	{
		return driver.findElement(Lcity);
	}

	public void getLstate(String text)
	{
		dropdownvalue(Lstate, text);
	}

	public WebElement getLzip()
	{
		return driver.findElement(Lzip);
	}

	public void getLcountry(String text)
	{
		dropdownvalue(Lcountry, text);
	}

	public WebElement getPsubmit()
	{
		return driver.findElement(Psubmit);
	}
}
