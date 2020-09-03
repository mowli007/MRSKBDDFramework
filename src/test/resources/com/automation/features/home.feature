@web
Feature: Search a flight inbetween destination, select the cheapest and  purchase it. 

Scenario Outline: Verify home and search results page with source and destination
   Given User on home page
   When User search with source "<source>" and destination "<destination>"
   And Verify from departure "<source>" and desitnation "<destination>" on results page
   
   Examples: 
          | source | destination |
          | Boston | London |


Scenario Outline: Select Cheapest Flight
   Given User on home page
   When User search with source "<source>" and destination "<destination>"
   And Choose cheapest flight from search results  
   
   Examples: 
          | source | destination |
          | Boston | London | 
          

Scenario Outline: Purchase Cheapest Flight by entering pax details
   Given User on home page
   When User search with source "<source>" and destination "<destination>"
   When Enter Pax details name "<name>" , address "<address>" , city "<city>" , state "<state>" , zipcode "<zipcode>" , ccType "<ccType>" , ccNumber "<ccNumber>" , ccMonth "<ccMonth>" , ccYear "<ccYear>" and purchase flight
   
   Examples: 
          | source | destination | name | address | city| state | zipcode | ccType | ccNumber | ccMonth | ccYear |
          | Boston | London | Chandra Mowli Katta | Koramangala 1st Block | Bangalore | Karnataka | 560034 |  amex | 340765673757859 | 12 | 2022 |
   
    
             