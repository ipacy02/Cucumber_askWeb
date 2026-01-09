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
      | muni   | muni@gmail.com  | muni@    |
