@API
Feature: Open library author list

  Scenario: Get an author
    Given I send a get request to "/authors/OL1A.json"
    Then the status code should be 200
    And the "personal_name" should be equal to "Sachi Rautroy"
    And the "alternate_names" should contain "Yugashrashta Sachi Routray"