package driver;

import config.ContextConfigProperties;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SelenoidRemoteChromeDriverSource implements DriverSource {

    private static String SELENIUM_HUB_URL_FORMAT = "http://%s:%d/wd/hub";

    private ContextConfigProperties contextConfigProperties = new ContextConfigProperties();

    @Override
    public WebDriver newDriver() {
        contextConfigProperties.loadProperties();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
//        options.addArguments("--disable-web-security");
//        options.addArguments("--user-data-dir");
//        options.addArguments("--allow-running-insecure-content");
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        options.setCapability("browserName", "chrome");
        options.setCapability("enableVNC", true);
        options.setCapability("enableLog", true);
        try {
            return new RemoteWebDriver(
                    new URL(
                            String.format(
                                    SELENIUM_HUB_URL_FORMAT,
                                    contextConfigProperties.selenoidHost(),
                                    contextConfigProperties.selenoidPort()
                            )
                    ),
                    options
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }

    @Override
    public Class<? extends WebDriver> driverType() {
        return RemoteWebDriver.class;
    }
}
