package ru.autotests.common.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.autotests.common.config.WebDriverFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by lily on 13.06.17.
 */
public class LoggedPage extends BasePage {
    @FindBy(css = ".user__name")
    private WebElement userName;

    @FindBy(css = ".popup_visibility_visible a.user__logout")
    private WebElement logoutLink;

    public LoggedPage() {
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
        waitForPageToLoad();
    }

    @Step("Пользователь разлогинился")
    public NotLoggedPage logout() {
        waitForElementDisplayed(userName, "юзернейм в правом верхнем углу");
        userName.click();
        logoutLink.click();
        return new NotLoggedPage();
    }

    @Step("Проверяем наличие юзернейма в правом верхнем углу")
    public void checkUserNamePresent() {
        waitForElementDisplayed(userName, "юзернейм в правом верхнем углу");
        attachScreenshot();
    }

}
