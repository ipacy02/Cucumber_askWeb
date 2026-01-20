Feature: Registration functionality

  In order to do internet banking
  As a valid Ask e-commerce customer
  I want to register successfully


  Scenario Outline: Registration Successful
    Given I am in the registration page of the Ask e-commerce Application
    When I enter username "<username>", email "<email>" and password "<password>"
    Then I should be redirected to the registration page

    Examples:
      | username   | email                | password      |
      | mukamana23 | mukamana23@gmail.com | mukamana23@20 |


  Scenario Outline: Registration fails when fields are empty
    Given I am in the registration page of the Ask e-commerce Application
    When I enter username "<username>", email "<email>" and password "<password>"
    Then I should see a registration error message

    Examples:
      | username | email | password |
      |          |       |          |


  Scenario Outline: Registration fails when only email is provided
    Given I am in the registration page of the Ask e-commerce Application
    When I enter username "<username>", email "<email>" and password "<password>"
    Then I should see a registration error message

    Examples:
      | username | email                | password |
      |          | mukamana23@gmail.com |          |


