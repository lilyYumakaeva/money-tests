package ru.autotests.common.pages;

import org.openqa.selenium.JavascriptExecutor;
import ru.autotests.common.config.WebDriverFactory;

/**
 * Created by lily on 13.06.17.
 */
public class BasePage {

    private boolean isPageLoaded() {
        return ((JavascriptExecutor) WebDriverFactory.getDriver())
                .executeScript("return document.readyState", new Object[0]).toString().startsWith("complete");

    }

    protected void waitForPageToLoad() {
        int secondsCount = 0;
        while (!isPageLoaded() && secondsCount < 5) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            secondsCount++;
        }
        if (!isPageLoaded()) {
            throw new AssertionError("Page was not opened");
        }
    }
}
