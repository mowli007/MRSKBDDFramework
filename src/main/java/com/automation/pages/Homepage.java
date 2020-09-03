package com.automation.pages;



import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/*import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
*/
import java.util.Random;

//import org.hamcrest.CoreMatchers;




public class Homepage 
{
	
	public WebDriver driver;
	
	public Homepage(WebDriver driver)
	{
        PageFactory.initElements(driver, this);
        this.driver = driver;
        
    }
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/h1[1]")
	private WebElement homePageTitle;
	
	@FindBy(name="fromPort")
	private WebElement dropDownSource;
	
	@FindBy(name = "toPort")
	private WebElement dropDownDestination;
	
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement findFlightButton;
	
	@FindBy(xpath= "//h3[contains(text(),'Flights)]")
	private WebElement searchPageTitle;
	
	
	@FindBy(xpath="//tr[3]//td[1]//input[1]")
	private WebElement chooseThisFlightButton;
	
	
	@FindBy(id = "inputName")
	private WebElement txtFieldName;
	
	@FindBy(id = "address")
	private WebElement txtFieldAddress;
	
	@FindBy(id ="city")
	private WebElement txtFieldCity;
	
	@FindBy(id ="state")
	private WebElement txtFieldState;
	
	@FindBy(id ="zipCode")
	private WebElement txtFieldZipCode;
	
	@FindBy(id="cardType")
	private WebElement dropDownCardType;
	
	@FindBy(id ="creditCardNumber")
	private WebElement txtFieldCreditCardNumber;
	
	@FindBy(id ="creditCardMonth")
	private WebElement txtFieldCreditCardMonth;
	
	@FindBy(id ="creditCardYear")
	private WebElement txtFieldCreditCardYear;
	
	@FindBy(id ="nameOnCard")
	private WebElement txtFieldCreditCardNameOnCard;
	
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement buttonPurchaseFlight;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]")
	private WebElement labelConfirmationID;
	
	public String getTitleofThePage()
	{
		return homePageTitle.getText();
	}
	
	public void searchFlight(String source, String destination)
	{
		dropDownSource.sendKeys(source);
		dropDownDestination.sendKeys(destination);
		findFlightButton.click();
	}
	
	public boolean getHeadingOfThePage(String source, String destination)
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Flights from "+source+" to "+destination+"')]")).isDisplayed();
				
	}
	
	public void selectCheapFlight()
	{
		chooseThisFlightButton.click();
	}
	
	public void submitPaxForm(String name,String address, String city,String state,long zipCode,String creditCardType,long creditCardNumber,int creditCardMonth,long creditCardYear)
	{
		txtFieldName.sendKeys(name);
		txtFieldAddress.sendKeys(address);
		txtFieldCity.sendKeys(city);
		txtFieldState.sendKeys(state);
		long zipcodel =zipCode;
		String zipCodeS=String.valueOf(zipcodel);  
		
		txtFieldZipCode.sendKeys(zipCodeS);
		WebElement  testDropDown  =  driver.findElement(By.id("cardType"));
		Select ddlOperation = new Select(testDropDown);  
		ddlOperation.selectByValue(creditCardType);
		
		long creditCardNumberl =creditCardNumber;
		String creditCardNumberS=String.valueOf(creditCardNumberl); 
		  txtFieldCreditCardNumber.sendKeys(creditCardNumberS);
				
		txtFieldCreditCardMonth.clear();
		int creditCardMonthl =creditCardMonth;
		String creditCardMonthS=String.valueOf(creditCardMonthl); 
		txtFieldCreditCardMonth.sendKeys(creditCardMonthS);
		txtFieldCreditCardYear.clear();
		
		long creditCardYearl =creditCardYear;
		String creditCardYearS=String.valueOf(creditCardYearl); 
		txtFieldCreditCardYear.sendKeys(creditCardYearS);
		
		txtFieldCreditCardNameOnCard.sendKeys(name);
		buttonPurchaseFlight.click();
		
	}
	
	public String getConfirmationID()
	{
		return labelConfirmationID.getText();
	}
	
	
			
}

