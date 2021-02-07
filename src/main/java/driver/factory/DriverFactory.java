package driver.factory;

import enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory {

    private static WebDriver driver;
    private static Logger log = LoggerFactory.getLogger(DriverFactory.class.getName());
    private static DesiredCapabilities generalCaps = new DesiredCapabilities();

    public static WebDriver initDriver(Browsers browser) {
        try {
            switch (browser) {
                case Chrome:
                    driver = new ChromeDriverManager().getDriver();
                    break;
                case Firefox:
                    driver = new FirefoxDriverManager().getDriver();
                    break;
                //TO BE DONE
//                case Safari:
//                    driver = new SafariDriverManager().getDriver();
//                    break;
//                case IE:
//                    driver = new IeDriverManager().getDriver();
//                    break;
//                case Edge:
//                    driver = new EdgeDriverManager().getDriver();
//                    break;
                default:
                    driver = new ChromeDriverManager().getDriver();
            }
        } catch (Exception ex) {
            log.warn(String
                    .format("Driver was not initiated due to exception. Log message '%s'.", ex.getMessage()));
            try {
                driver = new ChromeDriverManager().getDriver();
            } catch (Exception e) {
                log.error(String
                        .format("Starting of desired '%1$s' and default browser failed. Log message '%2$s'.",
                                browser.toString(), e.getMessage()));
            }
        }
        return driver;
    }
}
