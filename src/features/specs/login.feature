Feature: Login
  I want to login the system

  @login
  Scenario Outline: Making autentication
    Given I am on HomePage
    When I fill in "<name>" in the field username
    And I fill in "<password>" in the field password
    And I click on Log in
    Then I should be redirect to AngendaPage

    Examples: 
      | name | password |
      | CPR  |   112628 |
      | ccc  |   112628 |
