Feature: AddToCart functionality

  In order to do internet banking
  As a valid Ask e-commerce customer
  I want to add the product in the cart successfully

  Scenario Outline: Add to cart Successful
    Given I am in the home page of the Ask e-commerce Application
    When I add the product <index> in the cart
    Then I should be redirected to the cart page

    Examples:
    |index|
    |4  |
    |2  |



