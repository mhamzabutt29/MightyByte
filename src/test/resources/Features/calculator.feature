Feature: Calculator
  Scenario Outline: Select type of calculator
    Given I am on class calc home page
    When I click "typeDropdown"
    And I click dropdown <option>
    And I am shown calculator changed to <option>
    Examples:
    | option     |
    | scientific |
    | graphing   |
    | matrix     |
    | basic      |