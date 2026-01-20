Feature: Category functionality

  As a user I want to browser on the category successfully

  Scenario Outline: Browse products by category
    Given I am on the Store page of the askomdch website on category
    When I browse product by "<Category_name>"
    Then I should get products in the category

    Examples:
      | Category_name       |
      | accessories         |
      | men                 |
      | mens-jeans          |
      | mens-shirts         |
      | mens-shoes          |
      | purses-and-handbags |
      | women               |
      | womens-jeans        |
      | womens-shirts       |
      | womens-shoes        |



