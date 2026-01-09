Feature: Login functionality

  In order to do internet banking
  As a valid Ask e-commerce customer
  I want to login successfully

  Scenario: Login Successful
    Given I am in the login page of the Ask e-commerce Application
    When I enter valid credentials
    Then I should be taken to the Account page
