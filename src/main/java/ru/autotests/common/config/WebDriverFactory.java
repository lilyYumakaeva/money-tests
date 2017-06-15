package ru.autotests.common.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by lily on 12.06.17.
 */
public class WebDriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Driver has not been initialized. " +
                    "Please call WebDriverFactory.startBrowser() before use this method");
        }
    }

    public static void startBrowser() {
        if (driver == null) {
            Browser browser = Config.getConfig().getBrowser();

            switch (browser) {
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", Config.PROPERTIES_FILE.pathToGeckoDriver);
                    driver = new FirefoxDriver(DesiredCapabilities.firefox());
                    break;
                case CHROME:
                    System.setProperty("webdriver.chrome.driver",  Config.PROPERTIES_FILE.pathToChromeDriver);
                    driver = new ChromeDriver(DesiredCapabilities.chrome());
                    break;
                case OPERA:
                    System.setProperty("webdriver.opera.driver", Config.PROPERTIES_FILE.pathToOperaDriver);
                    driver = new OperaDriver(DesiredCapabilities.operaBlink());
                    break;
                default:
                    throw new IllegalStateException("Unsupported browser type");

            }
        } else {
            throw new IllegalStateException("Driver has already been initialized. Quit it before using this method");
        }
    }

    public static void finishBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
