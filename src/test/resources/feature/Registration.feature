Feature: Registration functionality

  In order to do internet banking
  As a valid Ask e-commerce customer
  I want to register successfully


  Scenario Outline: Registration Successful
    Given I am in the registration page of the Ask e-commerce Application
    When I enter username "<username>", email "<email>" and password "<password>"
    Then I should be redirected to the registration page

    Examples:
      | username | email             | password   |
      | mukamana   | mukamana@gmail.com  | mukamana@20    |


  Scenario Outline: Registration fails when fields are empty
    When I enter username "<username>", email "<email>" and password "<password>"
    And I click register button
    Then I should see a registration error message

    Examples:
      | username | email           | password |
      |           |                 |         |


  Scenario Outline: Registration fails when only email is provided
    Given I am in the registration page of the Ask e-commerce Application
    When I enter username "<username>", email "<email>" and password "<password>"
    Then I should see a registration error message

    Examples:
      | username | email            | password |
      |          | poti@gmail.com   |          |


