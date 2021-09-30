Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check Remove Product From Cart
    Given User opens '<homePage>' page
    When User clicks Shop by Category button
    And User clicks Pet Supplies button
    And User clicks Dog Supplies button
    And User clicks Collars button
    And User clicks on first product
    And User clicks Add to Cart button on product
    And User clicks Remove button
    Then User checks that text in cart is '<notification>'

    Examples:
      | homePage              | notification           |
      | https://www.ebay.com/ | Shopping cart          |


  Scenario Outline: Check Registration without password
    Given User opens '<homePage>' page
    When User clicks Register button
    And User inputs firstname '<firstName>'
    And User inputs lastname '<lastName>'
    And User inputs email '<email>'
    Then User can not click Create Account

    Examples:
      | homePage              | firstName   |lastName |email               |
      | https://www.ebay.com/ | Tester      |Test     |mapfiin@gmail.com   |

  Scenario Outline: Check Registration with invalid password
    Given User opens '<homePage>' page
    When User clicks Register button
    And User inputs firstname '<firstName>'
    And User inputs lastname '<lastName>'
    And User inputs password '<password>'
    And User inputs email '<email>'
    And User inputs password '<password>'
    Then User sees Error Message

    Examples:
      | homePage              | firstName   |lastName |email               |password|
      | https://www.ebay.com/ | Tester      |Test     |mapfiin@gmail.com   |test    |


  Scenario Outline: Check Product Page main functions
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks on Iphone
    And User checks title visibility
    And User checks Breadcrumbs visibility
    And User checks Back to search visibility
    And User checks Price visibility
    And User checks Buy It Now button visibility
    And User checks Add To WatchList button visibility
    And User checks Sign In button visibility
    And User checks Seller Information visibility
    And User checks Rating visibility
    Then User checks Add To Cart button visibility
    Examples:
      | homePage              | keyword  |
      | https://www.ebay.com/ | iphone   |