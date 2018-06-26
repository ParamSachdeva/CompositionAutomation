@facebook
Feature: Validate few feature of facebook.com

  @Login
  Scenario: Verify Facebook login functionality with Invalid data 
    Given Open browser and navigate to facebook site
    When Enter Invalid username
    And Enter Invalid password
    Then Click on facebook website
    And Verify login failed

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
