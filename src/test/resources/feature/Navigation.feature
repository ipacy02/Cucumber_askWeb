Feature: Navigation functionality

  In order to access different sections of the website
  As a valid Ask e-commerce customer
  I want to navigate using the menu links

  Scenario Outline: Successful navigation using menu links
    Given I am on the home page of the Ask e-commerce application
    When I click on the "<Navigation>" link
    Then I should be redirected to the "<NavigationTitle>" page

    Examples:
      | Navigation  | NavigationTitle  |
      |Home         |AskOmDch         |
      |Store        |Product          |
      | Men         |Men|
      | Women       |Women|
      | Accessories |Accessories|
      | Account     |Account|
      | About       |About|
      |Contact Us   |Contact Us |

