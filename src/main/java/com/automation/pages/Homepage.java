package com.automation.pages;



import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Random;

import org.hamcrest.CoreMatchers;




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
	
	
	/*
	 * public String getProduct_Title_Search_Page() {
	 * 
	 * String actualValue = productTitleOnSearchResultsPage.getAttribute("text");
	 * actualValue= actualValue.trim(); return actualValue; }
	 * 
	 * public void add_Product_To_Cart(String product) { Actions actions = new
	 * Actions(driver); WebElement productOptions = productOnHomePage;
	 * actions.moveToElement(productOptions).perform();
	 * System.out.println("Done mouse move hover on product");
	 * addProductButton.click();
	 * 
	 * }
	 * 
	 * public String getProduct_Success_Msg_On_Popup() throws InterruptedException {
	 * Thread.sleep(2000); String actualPopupMsg = successMsgOnPopUp.getText();
	 * Thread.sleep(2000); System.out.println("Cart succesfull msg === "
	 * +actualPopupMsg); Thread.sleep(2000); Assert.assertThat(actualPopupMsg,
	 * CoreMatchers.containsString("successfully")); return actualPopupMsg; }
	 * 
	 * public void view_More_Details(String moreDetailsProduct) { Actions
	 * moreActions = new Actions(driver); WebElement moreProductOptions =
	 * productOnHomePage; moreActions.moveToElement(moreProductOptions).perform();
	 * System.out.println("Done mouse move hover on product more");
	 * moreProductButton.click(); }
	 * 
	 * public boolean validate_PD_Name_ID_Description() {
	 * 
	 * String productN= productName.getText(); String prodtID = productID.getText();
	 * String prodtCondtn = productCondition.getText(); String prodDesc =
	 * productDescription.getText();
	 * 
	 * if(productN != "null" && prodtID != "null" && prodtCondtn != "null" &&
	 * prodDesc !="null" ) { return true; } else { return false; } }
	 * 
	 * public void validate_By_ChangeSize_Increment_Decrement() throws
	 * InterruptedException { Select dropSize = new Select(sizeDropdown);
	 * dropSize.selectByValue("2");
	 * 
	 * 
	 * Thread.sleep(2000);
	 * 
	 * String BeforeIncrementQuanityValue = quanity.getAttribute("value"); Integer
	 * BeforeIncrementQuanityValueInd =
	 * Integer.parseInt(BeforeIncrementQuanityValue);
	 * System.out.println("Before incrementing the value = "
	 * +BeforeIncrementQuanityValue);
	 * 
	 * increMent.click(); Thread.sleep(2000);
	 * 
	 * String AfterIncrementQuanityValue = quanity.getAttribute("value"); Integer
	 * AfterIncrementQuanityValueint =Integer.parseInt(AfterIncrementQuanityValue);
	 * System.out.println("After increment the quanity value ---"
	 * +AfterIncrementQuanityValue); Integer incrementedValue = 2;
	 * System.out.println("String value ---- "+incrementedValue);
	 * 
	 * if(AfterIncrementQuanityValueint == incrementedValue) {
	 * assertEquals(AfterIncrementQuanityValueint,incrementedValue);
	 * System.out.println("Increment is working"); }else {
	 * System.out.println("Increment did not happen"); }
	 * 
	 * Thread.sleep(2000); decreMent.click(); Thread.sleep(2000);
	 * 
	 * Integer decrementedValue = 1;
	 * 
	 * if(BeforeIncrementQuanityValueInd == decrementedValue) {
	 * assertEquals(BeforeIncrementQuanityValueInd,decrementedValue);
	 * System.out.println("Decrement is working"); }else {
	 * System.out.println("Decrement did not happen"); } }
	 * 
	 * public void add_Product_From_Product_Details_Page() throws Exception {
	 * addProductButtonOnPDP.click(); getProduct_Success_Msg_On_Popup(); }
	 * 
	 * public void enter_Login_Details(String name, String pwd) {
	 * 
	 * signinLink.click(); uNameTextBox.sendKeys(name); pwdTextBox.sendKeys(pwd);
	 * signInButton.click();
	 * 
	 * }
	 * 
	 * public boolean validate_Authentication_Failed_Message()
	 
		{
			
			String msg = authenticalFailedLabel.getText();
			if(msg == "Authentication failed.")
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}*/
		
}

