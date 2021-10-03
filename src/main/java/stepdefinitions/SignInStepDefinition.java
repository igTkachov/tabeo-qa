package stepdefinitions;

import config.SpringContextAware;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Shared;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import steps.SignInStep;
import utils.TestUtils;

public class SignInStepDefinition implements SpringContextAware {

    @Value("${user.default.email}")
    private String userDefaultEmail;

    @Value("${user.default.password}")
    private String userDefaultPassword;

    @Autowired
    private TestUtils utils;

    @Shared
    SignInStep signInStep;

    @When("^I open main page$")
    public void i_open_main_page() { signInStep.openMainPage(); }

    @When("^I again open main page$")
    public void i_again_open_main_page() { i_open_main_page(); }

    @Given("^I've signed in$")
    public void i_ve_signed_in() {
        i_open_main_page();
        i_try_to_sign_in();
        i_try_to_sign_in_with_google();
        i_provide_the_default_email_for_log_in();
        i_try_to_go_to_enter_password();
        i_provide_the_default_password_for_log_in();
        i_try_to_finish_sign_in_with_google();
        i_should_see_user_name(null);
    }

    @When("^I try to sign in$")
    public void i_try_to_sign_in() { signInStep.clickSignIn(); }

    @When("^I try to go to enter password$")
    public void i_try_to_go_to_enter_password() { signInStep.clickNextToPassword(); }

    @When("^I try to finish sign in with google$")
    public void i_try_to_finish_sign_in_with_google() { signInStep.clickNextToMainBoard(); }

    @When("^I try to sign in with google$")
    public void i_try_to_sign_in_with_google() { signInStep.clickSignInWithGoogle(); }

    @When("^I provide the default email for log in$")
    public void i_provide_the_default_email_for_log_in() { signInStep.provideUserNameForLogIn(userDefaultEmail); }

    @When("^I provide unrelated email for log in$")
    public void i_provide_unrelated_email_for_log_in() {
        var email = utils.generateEmail();
        signInStep.provideUserNameForLogIn(email);
    }

    @When("^I provide the default password for log in$")
    public void i_provide_the_default_password_for_log_in() { signInStep.providePasswordForLogIn(userDefaultPassword); }

    @When("^I provide random password for log in$")
    public void i_provide_random_password_for_log_in() {
        var password = utils.generatePassword();
        signInStep.providePasswordForLogIn(password); }

    @Then("^I should( not)? see user name$")
    public void i_should_see_user_name(String not) { signInStep.isUserNameDisplayed(not == null); }

    @Then("^I should see error message$")
    public void i_should_see_error_message() { signInStep.isGoogleErrorDisplayed(); }

    @Then("^I should be able to try sign in$")
    public void i_should_be_able_to_try_sign_in() { signInStep.isSignInButtonDisplayed(); }
}
