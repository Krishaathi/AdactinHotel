
Feature: Verifying Adactinhotel Login Details

  Scenario Outline: Verifying Adactinhotel Login details with Valid Credential
    Given User is on the Adactinhotel Page
    When User should Login  with "<username>", "<password>"
    Then User should verify successfully login message "Hello krishaathi3577!"

    Examples: 
      | username       | password   |
      | krishaathi3577 | 9894873577 |

  Scenario Outline: Verifying Adactinhotel Login details with Valid Credential
    Given User is on the Adactinhotel Page
    When User should login with Enter Key "<username>","<password>"
    Then User should verify successfully login message "Hello krishaathi3577!"

    Examples: 
      | username       | password   |
      | krishaathi3577 | 9894873577 |

  Scenario Outline: Verifying Adactinhotel Login details with InValid Credential
    Given User is on the Adactinhotel Page
    When User should Login  with "<username>", "<password>"
    Then User should verify after login get error message contains "Invalid Login details or Your Password might have expired."

    Examples: 
      | username         | password   |
      | krishaathi3577aa | 9894873577 |
