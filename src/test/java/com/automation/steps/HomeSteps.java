package com.automation.steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.automation.pages.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPathExpressionException;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import com.automation.pages.Homepage;
import com.automation.reader.XMLDataReader;
import com.automation.runner	.TestRunner;

public class HomeSteps extends TestRunner 
{

    public Homepage homePage;

    @Before
    public void openApp() throws XPathExpressionException 
    {
        driver.get(XMLDataReader.readData("//url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Given("^User on home page$")
    public void user_on_home_page() 
    {
    
    homePage = new Homepage(driver);
    String actualTitleOnHomePage= homePage.getTitleofThePage();
    System.out.println(actualTitleOnHomePage);
    Assert.assertEquals("Welcome to the Simple Travel Agency!", actualTitleOnHomePage);
    
    }

    @When("^User search with source \"(.*)\" and destination \"(.*)\"$")
    public void user_search_with_source_Paris_and_destination_London(String source, String destination) 
    {
    	
        homePage.searchFlight(source,destination);
        
    }
    
    @And("^Verify from departure \\\"(.*)\\\" and desitnation \\\"(.*)\\\" on results page$")
    public void verify_Flights_Search_Page(String source, String destination)
    {
    	boolean result = homePage.getHeadingOfThePage(source,destination);
    	System.out.println(result);
    	Assert.assertTrue(result);    	    	
    }
    
    @And("^Choose cheapest flight from search results$")
    public void choose_Cheapest_Flight_From_Search_Results()
    {
    	homePage.selectCheapFlight();
    }
   
    @When("^Enter Pax details name \"(.*)\" , address \"(.*)\" , city \"(.*)\" , state \"(.*)\" , zipcode \"(.*)\" , ccType \"(.*)\" , ccNumber \"(.*)\" , ccMonth \"(.*)\" , ccYear \"(.*)\" and purchase flight$")
    public void enter_Pax_Details_And_Purchase_Flight(String name, String address, String City, String State, long zipcode, String ccType, long ccNumber, int ccMonth, long ccYear )
    {
   
    	homePage.selectCheapFlight();
    	homePage.submitPaxForm(name,address,City,State,zipcode,ccType,ccNumber,ccMonth,ccYear);
    	String confirmationID= homePage.getConfirmationID();
    	System.out.println(confirmationID);
    }
	/*
	 * @And("^User verify product title \"(.*)\" of the search results page$")
	 * public void verify_title_of_the_product(String title) throws Exception {
	 * String actualPageValue = homePage.getProduct_Title_Search_Page();
	 * 
	 * System.out.println("Actual on page" + actualPageValue); title = title.trim();
	 * System.out.println("From feature" + title); // assertEquals(title,
	 * actualPageValue);
	 * 
	 * }
	 */
    
    /*@When("^User adds a product \\\"(.*)\\\" to cart$")
    public void add_Product_From_Home_page(String productName) 
    {
        homePage.add_Product_To_Cart(productName);
    }
    
    @And("^User validate a message on popup$")
    public void validate_Msg_Product_Added_Succesfully() throws Exception
    {
    	String actualProductMsg = homePage.getProduct_Success_Msg_On_Popup();
    	Assert.assertThat(actualProductMsg, CoreMatchers.containsString("successfully"));
    	//actualProductMsg = actualProductMsg.trim();
    	System.out.println(actualProductMsg);
     }
   
    @When("^User wants to see more details on a product \\\"(.*)\\\"$")
    public void view_Product_More(String productNameToSeeMore) 
    {
        homePage.view_More_Details(productNameToSeeMore);
    }
    
    @And("^User validate details on product description page$")
    public void validate_Product_Details()
    {
    	boolean msg = homePage.validate_PD_Name_ID_Description();
    	if(msg == true)
    		assertTrue(true);
    }
    
    @When("^User Changes size to \"(.*)\" , increment and decrement quantity$")
    public void changes_Size_Quanity(String size) throws InterruptedException
    {
     homePage.validate_By_ChangeSize_Increment_Decrement();
    }
    
    @Then("^User adds product to the cart$")
    public void add_Product_From_PDP() throws Exception
    {
    	homePage.add_Product_From_Product_Details_Page();
    	
    }
    
    @When("^Enter invalid \\\"(.*)\\\" and \\\"(.*)\\\" is entered$")
    public void invalid_Login_Detail(String uName, String password) throws InterruptedException
    {
    	homePage.enter_Login_Details(uName,password);
    }
    
    @And("^User gets this Authentication failed.")
    public void validate_Login_Message()
    {
    	boolean msg = homePage.validate_Authentication_Failed_Message();
    	if(msg == true)
    		assertTrue(true);
    }*/
}
