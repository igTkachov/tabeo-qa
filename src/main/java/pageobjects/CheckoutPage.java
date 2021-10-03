package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;

@DefaultUrl("page:checkout.url")
public class CheckoutPage extends PageObject {

    public static By EMAIL = By.cssSelector(".ReadOnlyFormField-title");
    public static By CARD_NUMBER = By.cssSelector("#cardNumber");
    public static By CARD_EXPIRY_DATE = By.cssSelector("#cardExpiry");
    public static By CARD_CVV = By.cssSelector("#cardCvc");
    public static By CARD_BILLING_NAME = By.cssSelector("#billingName");

    public static By COMPLETE_AUTHENTICATION = By.cssSelector("#test-source-authorize-3ds");
    public static By FAIL_AUTHENTICATION = By.cssSelector("#test-source-fail-3ds");

    @WhenPageOpens
    public CheckoutPage waitForPageContentLoaded() {
        withTimeoutOf(getWaitForTimeout())
                .waitFor(EMAIL);
        return this;
    }
}
