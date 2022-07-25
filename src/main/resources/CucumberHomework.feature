Feature: SauceLabs homepage functionality - login, added product to cart, checkout page, finish page


  @browser
  Scenario: SauceLabs FirstScenario
    Given user is navigated to 'https://www.saucedemo.com/'
    Then user sees page title 'Swag Labs'
    When user enters username 'standard_user' and password 'secret_sauce'
    And user clicks login button
    Then user is successfully logged in
    When user added product to cart
    And user clicks in the shopping cart
    Then user check if this product is in the Cart
    Then user clicks checkout button
    When user enters name 'Agnese' and password 'Antonova 'and postal code 'LV-1058'
    And user clicks continue button
    Then user check the data
    When user clicks finish button
    And user check is this on the finish page
    Then user clicks Back Home button

  @browser
  Scenario Outline: SauceLabs SecondScenario
    Given user is navigated to 'https://www.saucedemo.com/'
    Then user sees page title 'Swag Labs'
    When user enters username 'standard_user' and password 'secret_sauce'
    And user clicks login button
    And user clicks in the shopping cart
    Then user clicks checkout button
    When user enters '<name>' and '<password>' and '<postal code>'
    And user clicks continue button
    Then user sees error message '<error_text>'
    Examples:
      | name | password | postal code | error_text |
      |  | Antonova | LV-1058 | Error: First Name is required |
      | Agnese |  | LV-1058 | Error: Last Name is required |
      | Agnese | Antonova |  | Error: Postal Code is required |






