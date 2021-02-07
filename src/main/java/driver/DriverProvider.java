package driver;

import enums.Browsers;
import org.openqa.selenium.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class DriverProvider {
    private static Logger log = LoggerFactory.getLogger(DriverProvider.class.getName());

    private static String getChromeDriverPath() {
        Platform platform = Platform.getCurrent();
        log.debug(String.format("Current Platform: '%s'", Platform.getCurrent()));
        String driverPath = "";
        switch (platform) {
            case MAC:
                driverPath = "mac/chromedriver";
                break;
            case XP:
            case VISTA:
            case WIN10:
                driverPath = "win/chromedriver.exe";
                break;
            case LINUX:
                log.debug("getting Linux driver");
                driverPath = "nux/chromedriver";
                break;
            default:
                log.warn("getChromeDriverPath unknown or unsupported Platform " + Platform.getCurrent());
                return null;
        }

        return new File("src/test/resources/drivers/" + driverPath).getAbsolutePath();
    }

    private static String getFirefoxDriverPath() {

        Platform platform = Platform.getCurrent();
        String driverPath = "";
        switch (platform) {
            case MAC:
                driverPath = "mac/geckodriver";
                break;
            case XP:
            case VISTA:
            case WIN10:
                driverPath = "win/geckodriver.exe";
                break;
            case LINUX:
                driverPath = "nix/geckodriver";
                break;
            default:
                log.warn("getFirefoxDriverPath unknown or unsupported Platform " + Platform.getCurrent());
                return null;
        }

        return new File("src/test/resources/drivers/" + driverPath).getAbsolutePath();
    }

    private static String getInternetExplorerDriverPath() {
        Platform platform = Platform.getCurrent();
        String driverPath = "";
        switch (platform) {
            case XP:
            case VISTA:
            case WIN10:
                driverPath = "win/IEDriverServer.exe";
                break;
            default:
                log.warn("getInternetExplorerDriverPath unknown or unsupported Platform " + Platform
                        .getCurrent());
                return null;
        }

        return new File("src/test/resources/drivers/" + driverPath).getAbsolutePath();
    }

    private static String getMicrosoftEdgeDriverPath() {
        Platform platform = Platform.getCurrent();
        String driverPath = "";
        switch (platform) {
            case XP:
            case VISTA:
            case WIN10:
                driverPath = "win/msedgedriver.exe";
                break;
            case MAC:
                driverPath = "mac/msedgedriver";
                break;
            default:
                log.warn(
                        "getMicrosoftEdgeDriverPath unknown or unsupported Platform " + Platform.getCurrent());
                return null;
        }

        return new File("src/test/resources/drivers/" + driverPath).getAbsolutePath();
    }

    public static String getDriverPath(Browsers browser) {
        String browserPath = "";
        switch (browser) {
            case Safari:
                break;
            case Firefox:
                browserPath = getFirefoxDriverPath();
                break;
            case ChromeOnMobile:
            case Chrome:
                browserPath = getChromeDriverPath();
                break;
            case IE:
                browserPath = getInternetExplorerDriverPath();
                break;
            case Edge:
                browserPath = getMicrosoftEdgeDriverPath();
                break;
            default:
                browserPath = getChromeDriverPath();
                break;
        }
        return browserPath;
    }
}
