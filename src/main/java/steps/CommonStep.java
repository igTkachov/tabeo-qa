package steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public abstract class CommonStep extends UIInteractionSteps {

    public WebElementFacade scrollTo(WebElementFacade elementToScrollTo) {
        evaluateJavascript("arguments[0].scrollIntoView()", elementToScrollTo);
        return elementToScrollTo;
    }

    public int localTimeout() { return 5000; }
}
