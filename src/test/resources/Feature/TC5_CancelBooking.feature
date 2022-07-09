
Feature: Verifying Adactinhotel Cancel Details

  Scenario Outline: Verifying Adactinhotel cancelpage details with Valid  Credential
    Given User is on the Adactinhotel Page
    When User should Login  with "<username>", "<password>"
    Then User should verify successfully login message "Hello krishaathi3577!"
    And User should  Search the Hotel after Sucessfully Login with "<Location>","<Hotel>","<Roomtype>","<Numberofrooms>","<Checkindate>","<Checkoutdate>","<Adult>"and"<Children>"
    Then User should after verify successfully search message with "Select Hotel"
    And User should Select the Hotel and continue After successfully search
    Then User should after verify successfully select hotel get message "Book A Hotel"
    And User should Book the Hotel after successfully select hotel  using "<firstname>","<lastname>","<address>" and save the generated orderId
      | creditcardtype   | creditcardnumber | expirymonth | expiryyear | cvv |
      | VISA             | 1234123412341234 | June        |       2022 | 122 |
      | American Express | 1234123412341234 | June        |       2022 | 142 |
      | Master Card      | 1234123412341234 | June        |       2022 | 122 |
    Then User should verify after Sucessfully Book hotel get message "Booking Confirmation"
    And User should cancel generated order id after booking confirmation
    Then User should verify cancel message after cancelling "The booking has been cancelled."

    Examples: 
      | username       | password   | Location  | Hotel         | Roomtype | Numberofrooms | Checkindate | Checkoutdate | Adult   | Children  | firstname | lastname | address |
      | krishaathi3577 | 9894873577 | Melbourne | Hotel Cornice | Double   | 2 - Two       | 21/06/2022  | 22/06/2022   | 2 - Two | 3 - Three | krish     | aathi    | chennai |

  Scenario Outline: Verifying Adactinhotel Cancelpage details with Valid Credential
    Given User is on the Adactinhotel Page
    When User should Login  with "<username>", "<password>"
    Then User should verify successfully login message "Hello krishaathi3577!"
    And User should cancel existing order "<orderID>" after sucessfully login
    Then User should verify cancel message after cancelling "The booking has been cancelled."

    Examples: 
      | username       | password   | orderID    |
      | krishaathi3577 | 9894873577 | O1347USDD7 |
