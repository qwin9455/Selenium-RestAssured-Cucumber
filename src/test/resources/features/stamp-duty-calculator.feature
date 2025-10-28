@Web
Feature: Motor vehicle stamp duty calculator

  Background:
    Given I am on the Service NSW duty check motor vehicle stamp duty page
    When I click the "Check online" button
    Then I am redirected to Revenue NSW page

  Scenario: Calculate stamp duty
    When I choose "Yes" as registration type
    And I enter the vehicle price as "40000"
    And I click the "Calculate" button
    Then I should see the calculation displayed
    And the details should be as follows
      | Is Passenger Vehicle | Purchase Price | Duty Payable |
      | Yes                  | $40,000.00     | $1,200.00    |
