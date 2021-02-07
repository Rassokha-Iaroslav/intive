package commons;

import driver.factory.DriverFactory;
import enums.Browsers;
import enums.TestRunTypes;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestsInitializer {

    public static iTestsConfig testEnvConfig = EnvironmentHelper.getEnv();
    private static String log4jConfigPath = "src/main/resources/log4j.properties";
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    private static Logger log = LoggerFactory.getLogger(TestsInitializer.class);

    public static WebDriver getDriver() {
        if (threadLocalDriver.get() == null) {
            threadLocalDriver
                    .set(DriverFactory.initDriver(Browsers.valueOf(testEnvConfig.getBrowser())));
            log.debug(String.format("Thread with name '%1$s' and id:'%2$s' created driver",
                    Thread.currentThread().getName(), Thread.currentThread().getId()));

        }
        return threadLocalDriver.get();
    }

    @Before
    public static void setupMain() {
        setUpLoggingLevel();
    }

    @Before("@apiTest")
    public void setupApiTest() {
        RestAssured.baseURI = testEnvConfig.host();
    }

    @Before("@webTest")
    public static void setupWebTest() {
        getDriver().manage().window().maximize();
    }

    @After("@webTest")
    public static void cleanupWebTest() {
        WebDriver driver = getDriver();
        threadLocalDriver.remove();
        if (driver != null) {
            driver.quit();
        }
    }


    private static void setUpLoggingLevel() {
        PropertyConfigurator.configure(log4jConfigPath);
        if (TestRunTypes.valueOf(testEnvConfig.getTestRunType().toUpperCase())
                == TestRunTypes.DEBUG) {
            LogManager.getRootLogger().setLevel(org.apache.log4j.Level.DEBUG);
        }
    }
}
