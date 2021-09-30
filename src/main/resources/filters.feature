Feature: Filters
  As a user
  I want to test filters functionality
  So that I can be sure that filters are applied correctly


  Scenario Outline: Check amount of applied Filters
    Given User opens '<homePage>' page
    When User clicks Shop by Category button
    And User clicks Pet Supplies button
    And User clicks Dog Supplies button
    And User clicks Collars button
    And User chooses Material Filter
    And User chooses Dog Size Filter
    Then User checks that amount of applied filters is <amountOfFiltersApplied>

    Examples:
      | homePage              | amountOfFiltersApplied |
      | https://www.ebay.com/ | 2                      |


  Scenario Outline: Check all Search Results contain applied Filter
    Given User opens '<homePage>' page
    When User clicks Shop by Category button
    And User clicks Pet Supplies button
    And User clicks Dog Supplies button
    And User clicks Collars button
    And User clicks All Filters
    And User applies Free Shipping Filter
    Then User checks that all Search Results contain '<appliedFilter>'

    Examples:
      | homePage              |appliedFilter |
      | https://www.ebay.com/ |Free shipping |

