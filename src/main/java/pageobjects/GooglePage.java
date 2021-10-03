package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;

@DefaultUrl("page:google.signin")
public class GooglePage extends PageObject {

    public static By EMAIL = By.cssSelector("#identifierId");
    public static By PASSWORD = By.cssSelector("input[name='password']");
    public static By NEXT_TO_PASSWORD = By.cssSelector("#identifierNext");
    public static By NEXT_TO_BOARD = By.cssSelector("#passwordNext");
    public static By ERROR_ACCOUNT_NOTIFICATION = By.cssSelector("#view_container div[aria-live='assertive'] span");

    @WhenPageOpens
    public GooglePage waitForPageContentLoaded() {
        withTimeoutOf(getWaitForTimeout())
                .waitFor(EMAIL);
        return this;
    }
}
