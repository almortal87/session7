Feature: Amazon test

  Scenario: User searches for Amazon item
    Given The user in on Amazon search page
    When the user searches for "Video Games"
    And click on the first result shown
    Then check the price for the first result shown is more than 0