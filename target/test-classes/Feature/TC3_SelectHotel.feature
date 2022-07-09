
Feature: Verifying Adactinhotel SelectHotel Details

  Scenario Outline: Verifying Adactinhotel SelectHotel details with Valid  Credential
    Given User is on the Adactinhotel Page
    When User should Login  with "<username>", "<password>"
    Then User should verify successfully login message "Hello krishaathi3577!"
    And User should  Search the Hotel after Sucessfully Login with "<Location>","<Hotel>","<Roomtype>","<Numberofrooms>","<Checkindate>","<Checkoutdate>","<Adult>"and"<Children>"
    Then User should after verify successfully search message with "Select Hotel"
    And User should Select the Hotel and continue After successfully search
    Then User should after verify successfully select hotel get message "Book A Hotel"

    Examples: 
      | username       | password   | Location  | Hotel         | Roomtype | Numberofrooms | Checkindate | Checkoutdate | Adult   | Children  |
      | krishaathi3577 | 9894873577 | Melbourne | Hotel Cornice | Double   | 2 - Two       | 21-06-2022  | 22-06-2022   | 2 - Two | 3 - Three |

  Scenario Outline: Verifying Adactinhotel SelectHotel details with InValid  Credential
    Given User is on the Adactinhotel Page
    When User should Login  with "<username>", "<password>"
    Then User should verify successfully login message "Hello krishaathi3577!"
    And User should  Search the Hotel after Sucessfully Login with "<Location>","<Hotel>","<Roomtype>","<Numberofrooms>","<Checkindate>","<Checkoutdate>","<Adult>"and"<Children>"
    Then User should after verify successfully search message with "Select Hotel"
    And User should without Select the Hotel and continue After successfully search
    Then User should  verify after  continue get Error message "Please Select a Hotel"

    Examples: 
      | username       | password   | Location  | Hotel         | Roomtype | Numberofrooms | Checkindate | Checkoutdate | Adult   | Children  |
      | krishaathi3577 | 9894873577 | Melbourne | Hotel Cornice | Double   | 2 - Two       | 21-06-2022  | 22-06-2022   | 2 - Two | 3 - Three |
