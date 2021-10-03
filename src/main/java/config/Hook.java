package config;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.cucumber.suiteslicing.SerenityTags;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Hook implements SpringContextAware {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Managed
    private WebDriver webDriver;
    private EnvironmentVariables environmentVariables;

    @Before
    public void beforeScenario(Scenario scenario) {
        getDriver().manage().window().maximize();
        Serenity.setSessionVariable(SessionVariable.SCENARIO_NAME).to(scenario.getName());
    }

    @After
    public void afterScenario() { }
}
