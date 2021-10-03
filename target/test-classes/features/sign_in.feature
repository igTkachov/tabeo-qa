@sign_in
  Feature: Check sign in

    As a user
    I want to sign in
    In order to be able to use the main feature

    @automated
      Scenario: User should be able to sign in with valid credentials
      Given I open main page
      And I try to sign in
      And I try to sign in with google

      When I provide the default email for log in
      And I try to go to enter password
      And I provide the default password for log in
      And I try to finish sign in with google

      Then I should see user name

    # Validation with wrong account or wrong password related to validation of third-party services (it's Google in our case) and we shouldn't check it.
    # But we need to check how our system will be responding on.
    # According of Equivalence class analysis technique it's enough to make one validation
    @automated
    Scenario: User should not be able to sign in with not valid credentials
      Given I open main page
      And I try to sign in
      And I try to sign in with google

      When I provide unrelated email for log in
      And I try to go to enter password
      Then I should see error message

      When I again open main page
      Then I should not see user name
      But I should be able to try sign in