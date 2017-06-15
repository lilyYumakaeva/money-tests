package ru.autotests.common.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.autotests.common.config.WebDriverFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by lily on 13.06.17.
 */
public class NotLoggedPage extends BasePage{

    @FindBy(css = ".user__enter")
    private WebElement loginButton;

    @FindBy(css = "input[name=login]")
    private WebElement loginInput;

    @FindBy(css = "input[name=passwd]")
    private WebElement passwordInput;

    @FindBy(css = "button[type=submit]")
    private WebElement submitButton;

    public NotLoggedPage() {
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
        waitForPageToLoad();
    }

    @Step("Пользователь залогинился")
    public LoggedPage login() {
        clickLoginButton();
        typeLoginAndPassword();
        return clickSubmitButton();
    }

    @Step("Клик на кнопку Войти")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Вводим логин и пароль")
    public void typeLoginAndPassword() {
        loginInput.sendKeys("iliya.ogurcov");
        passwordInput.sendKeys("iliya.ogurcov2017");
        attachScreenshot();
    }

    @Step("Клик на кнопку Войти в домике")
    public LoggedPage clickSubmitButton() {
        submitButton.click();
        return new LoggedPage();
    }

    @Step("Проверяем наличие кнопки 'Войти' в правом верхнем углу")
    public void checkloginButtonPresent() {
        waitForElementDisplayed(loginButton, "кнопка 'Войти' в правом верхнем углу");
        attachScreenshot();
    }


}
