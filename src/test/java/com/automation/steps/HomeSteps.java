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
	
}
