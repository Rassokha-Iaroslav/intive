package driver.factory;

import driver.DriverProvider;
import enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirefoxDriverManager implements IDriverManager {

    private WebDriver driver;
    private Logger log = LoggerFactory.getLogger(FirefoxDriverManager.class);

    @Override
    public WebDriver getDriver() {
        System.setProperty("webdriver.gecko.driver", DriverProvider.getDriverPath(Browsers.Firefox));
        FirefoxOptions options = new FirefoxOptions();
        //some specific option here
        driver = new FirefoxDriver(options);
        return driver;
    }
}
