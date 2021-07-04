Feature: Create Account
  A new user should be able to create a account

  Scenario: create account for a new user
    Given a new user to uPet
    When user creates an account providing the details
    Then user should be able create new account successfully and upload his profile photo