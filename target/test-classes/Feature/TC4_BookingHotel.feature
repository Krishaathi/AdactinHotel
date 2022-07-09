
Feature: Verifying Adactinhotel BookHotel Details

  Scenario Outline: Verifying Adactinhotel BookHotel details with Valid  Credential
    Given User is on the Adactinhotel Page
    When User should Login  with "<username>", "<password>"
    Then User should verify successfully login message "Hello krishaathi3577!"
    And User should  Search the Hotel after Sucessfully Login with "<Location>","<Hotel>","<Roomtype>","<Numberofrooms>","<Checkindate>","<Checkoutdate>","<Adult>"and"<Children>"
    Then User should after verify successfully search message with "Select Hotel"
    And User should Select the Hotel and continue After successfully search
    Then User should after verify successfully select hotel get message "Book A Hotel"
    And User should Book the Hotel after successfully select hotel  using "<firstname>","<lastname>","<address>" and save the generated orderId
      | creditcardtype   | creditcardnumber | expirymonth | expiryyear | cvv  |
      | VISA             | 1111111111111111 | June        |       2022 | 1111 |
      | American Express | 1234123412341234 | June        |       2022 | 1421 |
      | Master Card      | 1234123412341234 | June        |       2022 | 1221 |
    Then User should verify after Sucessfully Book hotel get message "Booking Confirmation"

    Examples: 
      | username       | password   | Location  | Hotel         | Roomtype | Numberofrooms | Checkindate | Checkoutdate | Adult   | Children  | firstname | lastname | address    |
      | krishaathi3577 | 9894873577 | Melbourne | Hotel Cornice | Double   | 10 - Ten      | 05/07/2022  | 07/07/2022   | 2 - Two | 3 - Three | Kandasamy | Bala     | 1/16sattur |

  Scenario Outline: Verifying Adactinhotel BookHotel details with Valid  Credential
    Given User is on the Adactinhotel Page
    When User should Login  with "<username>", "<password>"
    Then User should verify successfully login message "Hello krishaathi3577!"
    And User should  Search the Hotel after Sucessfully Login with "<Location>","<Hotel>","<Roomtype>","<Numberofrooms>","<Checkindate>","<Checkoutdate>","<Adult>"and"<Children>"
    Then User should after verify successfully search message with "Select Hotel"
    And User should Select the Hotel and continue After successfully search
    Then User should after verify successfully select hotel get message "Book A Hotel"
    And User Should Book the Hotel after successfully without filling details
    Then User should after verify Book hotel get error message "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month"and"Please Enter your Credit Card CVV Number"

    Examples: 
      | username       | password   | Location  | Hotel         | Roomtype | Numberofrooms | Checkindate | Checkoutdate | Adult   | Children  |
      | krishaathi3577 | 9894873577 | Melbourne | Hotel Cornice | Double   | 10 - Ten      | 05/07/2022  | 07/07/2022   | 2 - Two | 3 - Three |
