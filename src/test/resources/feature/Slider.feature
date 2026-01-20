Feature: Sliding the price range
  As an e-commerce customer
  I want to slide the price range from min to max
  So that I can filter products within a desired price range

  Scenario Outline: Slide the price range and check that it updates
    Given I am on the Store page of the askomdch website on Slider
    When I slide the minimum price by "<Slide_min>" pixels
    And I slide the maximum price by "<Slide_max>" pixels
    Then the price label should be updated

    Examples:
      | Slide_min | Slide_max |
      | 20        | 50        |
      | 0         | 100       |

