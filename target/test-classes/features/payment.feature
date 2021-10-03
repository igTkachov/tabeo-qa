@payment
  Feature: Check payment flow

    As a user
    I want to have ability to pay
    In order to be able to use payment feature

    # Validation with different values of payment fields, related to validation of third-party services (it's Stripe in our case) and we shouldn't check it.
    # But we need to check how our system will be responding on.
    # So it tests below we check main business flow.

    @automated
      Scenario: User should be able to have success payment with Subscription (pay £20/mo)
      Given I've signed in
      When I want to buy subscription
      Then I should see the email

      When I provide the valid card number
      And I provide valid card date
      And I provide valid card cvv
      And I provide valid card holder
      And I try to make subscription
      And I try to complete Authentication with 3D secure

      Then I should see Success payment

    @automated
    Scenario: User should be able to have success payment with Application payment (pay £220)
      Given I've signed in
      When I want to buy application
      Then I should see the email

      When I provide the valid card number
      And I provide valid card date
      And I provide valid card cvv
      And I provide valid card holder
      And I try to make subscription
      And I try to complete Authentication with 3D secure

      Then I should see Success payment

    @automated
    Scenario: User should not be able to perform payment with unsuccessful card number for Subscription (pay £20/mo)
      Given I've signed in
      When I want to buy subscription
      Then I should see the email

      When I provide the unsuccessful card number
      And I provide valid card date
      And I provide valid card cvv
      And I provide valid card holder
      And I try to make subscription
      And I try to complete Authentication with 3D secure

      Then I should see message about declined card

    @automated
    Scenario: User should not be able to perform payment with unsuccessful card number for Application payment (pay £220)
      Given I've signed in
      When I want to buy application
      Then I should see the email

      When I provide the unsuccessful card number
      And I provide valid card date
      And I provide valid card cvv
      And I provide valid card holder
      And I try to make subscription
      And I try to complete Authentication with 3D secure

      Then I should see message about declined card