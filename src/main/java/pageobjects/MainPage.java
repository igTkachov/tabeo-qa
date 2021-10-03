package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;

@DefaultUrl("page:base.url")
public class MainPage extends PageObject {

    public static By SIGN_IN = By.cssSelector("button[href^='#']");
    public static By SIGN_IN_WITH_GOOGLE = By.cssSelector(".inline-block button[type='button']");
    public static By USER_NAME = By.cssSelector("#headlessui-menu-button-7");

    public static By SUBSCRIPTION = By.cssSelector("form[action*='subscription']");
    public static By PAYMENT = By.cssSelector("form[action*='payment']");
    public static By SUBMIT_BUTTON = By.cssSelector(".SubmitButton");

    public static By THANK_YOU_MESSAGE = By.cssSelector("h1.uppercase");
    public static By DOWNLOADED_MESSAGE = By.cssSelector("p.font-extrabold");
    public static By ORDER_MESSAGE = By.cssSelector("p.text-gray-500");

    public static By ERROR_CARD_MESSAGE = By.cssSelector(".FieldError span[aria-hidden='false']");
    public static By ERROR_ICON = By.cssSelector(".FormFieldInput-Icon .Icon--red");

    @WhenPageOpens
    public MainPage waitForPageContentLoaded() {
        withTimeoutOf(getWaitForTimeout())
                .waitFor(SIGN_IN);
        return this;
    }
}
