Feature: Login to classcalc.com

  Background:
    Given I am on class calc login popup


  Scenario Outline: Login with invalid credentials
    When I enter <username> and <password>
    And I click "Login"
    Then I am shown validation <message>
    Examples:
    | username          | password | message                      |
    |                   |          | You cannot leave blank       |
    | valid@gmail.com   |          | Password is a required field |
    |                   | abcdef   | Email is a required field    |
    #    invalid email with invalid password
    | invalid@gmail.com | invalid  | Invalid email/password       |
    #    valid email with invalid password
    | valid@gmail.com   | invalid  | Invalid email/password       |
    #    invalid email with valid password
    | invalid@gmail.com | valid    | Invalid email/password       |

#  Scenario Outline: Login with valid credentials
#    When I enter <username> and <password>
#    And I click "Login"
#    Then I am shown validation <message>
#    Examples:
#      | username          | password | message                      |
#      |                   |          | You cannot leave blank       |

