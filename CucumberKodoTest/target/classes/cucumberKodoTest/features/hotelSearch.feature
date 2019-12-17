Feature: Hotel Search for Travel Booking site

@Test
  Scenario: Verify Error message if login user enter checkin & checkout date without entering destination city name
    Given I have online booking url as "https://www.phptravels.net"
    When I enter the check-in date as "19-12-2019"
    And I enter the check out date as "20-12-2019"
    And I add adult count while hotel search
    And I click on search button
    Then I should error message "Please fill in this field"

@Test
  Scenario: Verify login user enter the same checkin & checkout date
    Given I have online booking url as "https://www.phptravels.net"
    When I select city as "Mumbai"
    And I enter the check-in date as "18-12-2019"
    And I enter the check out date as "18-12-2019"
    And I add adult count while hotel search
    And I click on search button
    Then Result should display based on search criteria
    
@Test
  Scenario: Verify login user enter the different checkin & checkout date
    Given I have online booking url as "https://www.phptravels.net"
    When I select city as "Mumbai"    
    And I enter the check-in date as "18-12-2019"
    And I enter the check out date as "20-12-2019"
    And I add adult count while hotel search
    And I click on search button
    Then Result should display based on search criteria
     
@Test
  Scenario: Verify login user enter the different checkin & checkout date
    Given I have online booking url as "https://www.phptravels.net"
    When I select city as "Mumbai"
    And I enter the check-in date as "18-12-2019"
    And I enter the check out date as "20-12-2019"
    And I add adult count while hotel search
    And I add child count while hotel search
    And I click on search button
    Then Result should display based on search criteria   