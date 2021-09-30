Feature: Sorting
  As a user
  I want to test search functionality
  So that I can be sure that search and sort categories are applied correctly


  Scenario Outline: Check All Search Results share the same category
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    Then All search results have category '<category>'

    Examples:
      | homePage              | keyword  | category                  |
      | https://www.ebay.com/ | iphone   | Cell Phones & Accessories |


  Scenario Outline: Check Change Shipping
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User changes shipping options
    Then All Search Results can be shipped to '<shippingCountry>'

    Examples:
      | homePage              | keyword  | shippingCountry  |
      | https://www.ebay.com/ | iphone   | Hong Kong        |


  Scenario Outline: Check Search Results Count does not match items per page count
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks Items per page
    Then There are more search results than expected according to <amountOfItems> per page

    Examples:
      | homePage              | keyword  | amountOfItems  |
      | https://www.ebay.com/ | iphone   | 25             |


  Scenario Outline: Check Every Search Page has the same number of sorting options
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    Then All pages have <amountOfSortingOptions> sorting options

    Examples:
      | homePage              | keyword                  | amountOfSortingOptions  |
      | https://www.ebay.com/ | leather notebook black   | 6                       |