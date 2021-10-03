package steps;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.CheckoutPage;
import pageobjects.MainPage;

public class PaymentStep extends CommonStep {

    @Step
    public void clickButtonPay20mo(){ $(MainPage.SUBSCRIPTION).waitUntilClickable().click(); }

    @Step
    public void clickButtonPay220(){ $(MainPage.PAYMENT).waitUntilClickable().click(); }

    @Step
    public void clickSubmitButton(){ $(MainPage.SUBMIT_BUTTON).waitUntilClickable().click(); }

    @Step
    public void isEmail(String email){ $(CheckoutPage.EMAIL).waitUntilVisible().shouldContainText(email); }

    @Step
    public void provideCardNumber(String card){ $(CheckoutPage.CARD_NUMBER).waitUntilClickable().type(card); }

    @Step
    public void provideCardExpiryDate(String date){ $(CheckoutPage.CARD_EXPIRY_DATE).waitUntilClickable().type(date); }

    @Step
    public void provideCardCvv(String cvv){ $(CheckoutPage.CARD_CVV).waitUntilClickable().type(cvv); }

    @Step
    public void provideCardBillingName(String name){ $(CheckoutPage.CARD_BILLING_NAME).waitUntilClickable().type(name); }

    @Step
    public void completeAuthentication(){
        WebDriverWait wait = new WebDriverWait(getDriver(), localTimeout());
        WebElement topIframe = getDriver().findElement(By.cssSelector("iframe[name^='__privateStripeFrame']:first-child"));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(topIframe));
        waitABit(localTimeout());
        WebElement __stripeJSChallengeFrameIframe = getDriver().findElement(By.id("challengeFrame"));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(__stripeJSChallengeFrameIframe));
        WebElement acsFrameIframe = getDriver().findElement(By.name("acsFrame"));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(acsFrameIframe));
        $(CheckoutPage.COMPLETE_AUTHENTICATION).waitUntilClickable().click();
        getDriver().switchTo().defaultContent();
    }

    @Step
    public void failAuthentication(){ $(CheckoutPage.FAIL_AUTHENTICATION).waitUntilClickable().click(); }

    @Step
    public void isThankYouMessageDisplayed(){ $(MainPage.THANK_YOU_MESSAGE).waitUntilVisible().shouldBeVisible(); }

    @Step
    public void isThankYouMessageText(String text){ $(MainPage.THANK_YOU_MESSAGE).waitUntilVisible().shouldContainText(text); }

    @Step
    public void isDownloadMessageDisplayed(){ $(MainPage.DOWNLOADED_MESSAGE).waitUntilVisible().shouldBeVisible(); }

    @Step
    public void isDownloadMessageText(String text){ $(MainPage.DOWNLOADED_MESSAGE).waitUntilVisible().shouldContainText(text); }

    @Step
    public void isOrderMessageDisplayed(){ $(MainPage.ORDER_MESSAGE).waitUntilVisible().shouldBeVisible(); }

    @Step
    public void isErrorCardMessageDisplayed(){ $(MainPage.ERROR_CARD_MESSAGE).waitUntilVisible().shouldBeVisible(); }

    @Step
    public void isErrorIconDisplayed(){ $(MainPage.ERROR_ICON).waitUntilVisible().shouldBeVisible(); }
}
