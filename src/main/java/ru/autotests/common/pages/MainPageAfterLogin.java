package ru.autotests.common.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.autotests.common.config.WebDriverFactory;

/**
 * Created by lily on 13.06.17.
 */
public class MainPageAfterLogin extends BasePage {
    @FindBy(css = ".user__name")
    public WebElement userName;

    @FindBy(css = ".popup_visibility_visible a.user__logout")
    public WebElement logoutLink;

    public MainPageAfterLogin() {
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
        waitForPageToLoad();
    }

    public MainPageBeforeLogin logout() {
        userName.click();
        logoutLink.click();
        return new MainPageBeforeLogin(true);
    }

}
