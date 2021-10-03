package stepdefinitions;

import config.SpringContextAware;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Shared;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import steps.PaymentStep;
import utils.TestUtils;

public class PaymentStepDefinition implements SpringContextAware {

    @Value("${user.default.email}")
    private String userDefaultEmail;

    @Value("${user.default.name}")
    private String userDefaultName;

    @Value("${card.number.valid.payment}")
    private String validPaymentCard;

    @Value("${card.number.fail.payment}")
    private String failPaymentCard;

    @Autowired
    private TestUtils utils;

    @Shared
    PaymentStep paymentStep;

    @When("^I want to buy subscription$")
    public void i_want_to_buy_subscription() { paymentStep.clickButtonPay20mo(); }

    @When("^I want to buy application$")
    public void i_want_to_buy_application() { paymentStep.clickButtonPay220(); }

    @When("^I provide the valid card number$")
    public void i_provide_the_valid_card_number() { paymentStep.provideCardNumber(validPaymentCard); }

    @When("^I provide the unsuccessful card number$")
    public void i_provide_the_unsuccessful_card_number() { paymentStep.provideCardNumber(failPaymentCard); }

    @When("^I provide valid card date$")
    public void i_provide_valid_card_date() { paymentStep.provideCardExpiryDate(utils.generateExpirationDate()); }

    @When("^I provide valid card cvv$")
    public void i_provide_valid_card_cvv() { paymentStep.provideCardCvv(utils.generateCvv()); }

    @When("^I provide valid card holder$")
    public void i_provide_the_valid_card_holder() { paymentStep.provideCardBillingName(userDefaultName); }

    @When("^I try to make subscription$")
    public void i_try_to_make_subscription() { paymentStep.clickSubmitButton(); }

    @When("^I try to make payment$")
    public void i_try_to_make_payment() { paymentStep.clickSubmitButton(); }

    @Then("^I should see the email$")
    public void i_should_see_the_email() { paymentStep.isEmail(userDefaultEmail); }

    @Then("^I try to complete Authentication with 3D secure$")
    public void i_try_to_complete_authentication_with_3D_secure() { paymentStep.completeAuthentication(); }

    @Then("^I try to fail Authentication with 3D secure$")
    public void i_try_to_fail_authentication_with_3D_secure() { paymentStep.failAuthentication(); }

    @Then("^I should see Success payment$")
    public void i_should_see_success_payment() {
        paymentStep.isThankYouMessageDisplayed();
        paymentStep.isThankYouMessageText("THANK YOU!");
        paymentStep.isDownloadMessageDisplayed();
        paymentStep.isDownloadMessageText("Your purchase is ready to be downloaded.");
        paymentStep.isOrderMessageDisplayed();
    }

    @Then("^I should see message about declined card$")
    public void i_should_see_message_about_declined_card() {
        paymentStep.isErrorCardMessageDisplayed();
        paymentStep.isErrorIconDisplayed();
    }
}
