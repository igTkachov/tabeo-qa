import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty",
                "junit:target/cucumber-reports/Cucumber.xml",
                "junit:target/cucumber-junit.xml"},
        glue = {"stepdefinitions", "config"},
        features="classpath:features/payment.feature"
)
public class PaymentFeature {
}
