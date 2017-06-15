package ru.autotests.common.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import ru.autotests.common.config.WebDriverFactory;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.util.ImageTool;

import java.io.IOException;

import static org.junit.Assert.fail;

/**
 * Created by lily on 13.06.17.
 */
public class BasePage {

    private int timeToWait = 10;

    protected void waitForPageToLoad() {
        int seconds = 0;
        while (!isPageLoaded() && seconds < timeToWait) {
            waitOneSecond();
            seconds++;
        }
        if (!isPageLoaded()) {
            attachScreenshot();
            fail(String.format("Страница не загрузилась за %s секунд", timeToWait));
        }
    }

    private boolean isPageLoaded() {
        return ((JavascriptExecutor) WebDriverFactory.getDriver())
                .executeScript("return document.readyState", new Object[0]).toString().equalsIgnoreCase("complete");
    }

    private void waitOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void waitForElementDisplayed(WebElement element, String elemDescription) {
        int seconds = 0;
        while (!isElementDisplayed(element) && seconds < timeToWait) {
            waitOneSecond();
            seconds++;
        }
        if (!isElementDisplayed(element)) {
            attachScreenshot();
            fail(String.format("Элемент %s не появился за %s секунд", elemDescription, timeToWait));
        }
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Attachment(value = "screenshot", type = "image/png")
    protected byte[] attachScreenshot() {
        try {
            return ImageTool.toByteArray(new AShot().takeScreenshot(WebDriverFactory.getDriver()));
        } catch (IOException e) {
            return new byte[0];
        }
    }
}
