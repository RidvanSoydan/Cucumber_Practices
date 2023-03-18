Feature: Login functionality
  As a user, I should be able to login; so that I can land on homepage

  Scenario: Login with Valid Username and Valid Password (HelpDesk)
    When user is on ctissolutions search page
    And user types helpdesk1@cybertekschool.com
    And user types UserUser
    And user click login button
    Then  user should see title is Portal
    Then user close the driver

  Scenario: Login with Valid Username and Valid Password (HelpDesk)
    When user is on ctissolutions search page
    And user types "helpdesk2@cybertekschool.com"
    And user types UserUser
    And user click login button
    Then  user should see title is Portal
    Then user close the driver

  Scenario: Login with Valid Username and Valid Password (Human Resources)
    When user is on ctissolutions search page
    And user types hr1@cybertekschool.com
    And user types UserUser
    And user click login button
    Then  user should see title is Portal
    Then user close the driver

  Scenario: Login with Valid Username and Valid Password (Human Resources)
    When user is on ctissolutions search page
    And user types "marketing1@cybertekschool.com"
    And user types UserUser
    And user click login button
    Then  user should see title is Portal
    Then user close the driver

  Scenario: Login with Valid Username and Valid Password
    When user is on ctissolutions search page
    And user types username and password
      | hr5@cybertekschool.com |
      | UserUser               |
    And user click login button
    Then  user should see title is Portal
    Then user close the driver

  Scenario Outline: Login with Valid Username and Valid Password
    When user is on ctissolutions search page
    And user types "<userName>" as username
    And user types "<userPassword>" as password
    And user click login button
    Then  user should see title is Portal
    Then user close the driver
    Examples:
      | userName                      | userPassword |
      | helpdesk1@cybertekschool.com  | UserUser     |
      | helpdesk2@cybertekschool.com  | UserUser     |
      | helpdesk3@cybertekschool.com  | UserUser     |
      | helpdesk4@cybertekschool.com  | UserUser     |
      | helpdesk5@cybertekschool.com  | UserUser     |
      | helpdesk6@cybertekschool.com  | UserUser     |
      | hr5@cybertekschool.com        | UserUser     |
      | marketing1@cybertekschool.com | UserUser     |

  @wip
  Scenario Outline: Login with Valid Username and Valid Password
    When user is on ctissolutions search page
    And user types "<userName>" as username
    And user types "<password>" as password
    And user click login button
    Then  user should see title is Portal
    Then user close the driver
    Examples:
      | userName                     | password |
      | helpdesk6@cybertekschool.com | UserUser |
      | helpdesk7@cybertekschool.com | UserUser |
      | helpdesk8@cybertekschool.com | UserUser |
      | helpdesk9@cybertekschool.com | UserUser |

  @excel
    Scenario: login with excel data
      When user is on ctissolutions search page
      And user get data from excel and verify login
      Then user close the driver
