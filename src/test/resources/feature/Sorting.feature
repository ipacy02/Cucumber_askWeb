Feature: Sorting functionality

  As an e-commerce customer
  I want to sort products successfully

  Scenario Outline: Sort products using different options
    Given I am on the Store page of the askomdch website
    When I sort products by "<SortOption>"
    Then the products should be sorted accordingly

    Examples:
      | SortOption                 |
      | price                      |
      | Sort by average rating     |
      | Sort by latest             |
      | Sort by price: low to high |
      | Sort by price: high to low |
