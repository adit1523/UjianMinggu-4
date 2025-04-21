Feature: Inventory

  Scenario: Add product and checkout
    Given I am login swag labs
    When I click login
    And I click product and checkout
    And I fill form checkout
    Then I see message thank you for your order
    Given I go to logout

  Scenario: Invalid fill form checkout
    When I go to checkout
    And I am not input form checkout
    Then I see message first name is required
    Given I am logout after see message invalid
