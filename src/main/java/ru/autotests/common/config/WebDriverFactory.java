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
                    //https://github.com/mozilla/geckodriver/releases
                    System.setProperty("webdriver.gecko.driver", "/Users/lily/Downloads/geckodriver");
                    driver = new FirefoxDriver(DesiredCapabilities.firefox());
                    break;
                case CHROME:
                    //https://chromedriver.storage.googleapis.com/index.html?path=2.30/
                    System.setProperty("webdriver.chrome.driver", "/Users/lily/Downloads/chromedriver");
                    driver = new ChromeDriver(DesiredCapabilities.chrome());
                    break;
                case OPERA:
                    //https://github.com/operasoftware/operachromiumdriver/releases
                    System.setProperty("webdriver.opera.driver", "/Users/lily/Downloads/operadriver_mac64/operadriver");
                    driver = new OperaDriver(DesiredCapabilities.operaBlink());
                    break;
                default:
                    throw new IllegalStateException("Unsupported browser type");

            }
        } else {
            throw new IllegalStateException("Driver has already been initialized. Quit it before using this method");
        }
    }

    /**
     * Finishes browser
     */
    public static void finishBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
