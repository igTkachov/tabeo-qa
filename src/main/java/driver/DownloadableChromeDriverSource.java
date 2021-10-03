package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class DownloadableChromeDriverSource implements DriverSource {

    @Override
    public WebDriver newDriver() {
        WebDriverManager.chromedriver().setup();
        System.out.println("# Chrome driver version is: " + WebDriverManager.chromedriver().getDownloadedDriverVersion());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-web-security");
//        options.addArguments("--user-data-dir");
//        options.addArguments("--allow-running-insecure-content");

        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        return new ChromeDriver(options);
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }

    @Override
    public Class<? extends WebDriver> driverType() {
        return ChromeDriver.class;
    }
}