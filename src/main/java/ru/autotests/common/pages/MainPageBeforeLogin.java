package ru.autotests.common.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.autotests.common.config.WebDriverFactory;

import static ru.autotests.common.config.Config.getConfig;

/**
 * Created by lily on 13.06.17.
 */
public class MainPageBeforeLogin extends BasePage{

    @FindBy(css = ".user__enter")
    public WebElement loginButton;

    @FindBy(css = "input[name=login]")
    public WebElement loginInput;

    @FindBy(css = "input[name=passwd]")
    public WebElement passwordInput;

    @FindBy(css = "button[type=submit]")
    public WebElement submitButton;

    public MainPageBeforeLogin() {
        WebDriverFactory.getDriver().get(getConfig().getBaseURL());
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
        waitForPageToLoad();
    }

    public MainPageBeforeLogin(boolean logged) {
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
        waitForPageToLoad();
    }

    public MainPageAfterLogin login() {
        loginButton.click();
        loginInput.sendKeys("iliya.ogurcov");
        passwordInput.sendKeys("iliya.ogurcov2017");
        submitButton.click();
        return new MainPageAfterLogin();
    }

}
