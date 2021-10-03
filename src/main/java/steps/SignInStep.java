package steps;

import net.thucydides.core.annotations.Step;
import pageobjects.GooglePage;
import pageobjects.MainPage;

public class SignInStep extends CommonStep {

    MainPage mainPage;

    @Step
    public void openMainPage(){ mainPage.open(); }

    @Step
    public void clickSignIn() { $(MainPage.SIGN_IN).waitUntilClickable().click(); }

    @Step
    public void clickSignInWithGoogle() { $(MainPage.SIGN_IN_WITH_GOOGLE).waitUntilClickable().click(); }

    @Step
    public void provideUserNameForLogIn(String email) { $(GooglePage.EMAIL).type(email); }

    @Step
    public void clickNextToPassword() { $(GooglePage.NEXT_TO_PASSWORD).waitUntilEnabled().click(); }

    @Step
    public void clickNextToMainBoard() { $(GooglePage.NEXT_TO_BOARD).waitUntilEnabled().click(); }

    @Step
    public void providePasswordForLogIn(String password) { $(GooglePage.PASSWORD).type(password); }

    @Step
    public void isUserNameDisplayed(boolean shouldBe) {
        if (shouldBe) $(MainPage.USER_NAME).shouldBeVisible();
        else $(MainPage.USER_NAME).shouldNotBeVisible();
    }

    @Step
    public void isGoogleErrorDisplayed() { $(GooglePage.ERROR_ACCOUNT_NOTIFICATION).shouldBeVisible(); }

    @Step
    public void isSignInButtonDisplayed() { $(MainPage.SIGN_IN).shouldBeVisible(); }
}
