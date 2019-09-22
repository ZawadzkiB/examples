Feature: Check account withdrawal mechanism

  Scenario Outline: Withdraw amounts
    Given account with 200 balance
    When withdraw <amount>
    Then we get that <amount>
    And money left on our account is 200 minus <amount>

    Examples:
      | amount  |
      | 0       |
      | 50      |
      | 100     |
      | 150     |
      | 200     |

    Scenario: Try to withdraw more money than is on account
      Given account with 200 balance
      When withdraw 500
      Then error should be returned
      And account balance should be same as before
      And last operation should be not created