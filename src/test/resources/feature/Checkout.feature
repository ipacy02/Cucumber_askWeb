Feature: Checkout form

  As a customer
  I want to fill the checkout form
  So that I can place an order successfully

  Scenario: Submit checkout form with valid details
    Given I have added a product to my cart
    When I fill in the checkout form with the following details
      | firstName | lastName | company | country | street        | apartment | town   | state | zip   | phone      | email         |
      | John      | William      | ABC Ltd | US      | 123 Main St   | Apt 10    | Dallas | Texas | 75001 | 0789123456 | john@test.com |
    And I place the order
    Then the order should be placed successfully
