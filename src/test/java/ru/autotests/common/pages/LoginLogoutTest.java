package ru.autotests.common.pages;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import ru.autotests.common.config.WebDriverFactory;
import ru.yandex.qatools.allure.annotations.Title;

import static ru.autotests.common.config.Config.getConfig;


/**
 * Created by lily on 11.06.17.
 */
public class LoginLogoutTest {

    private static WebDriver driver;

    @Before
    public void before() {
        WebDriverFactory.startBrowser();
        driver = WebDriverFactory.getDriver();
        driver.get(getConfig().getBaseURL());
    }

    @Title("Проверка успешного логина")
    @Test
    public void checkLogin() {
        NotLoggedPage pageBeforeLogin = new NotLoggedPage();
        pageBeforeLogin.clickLoginButton();
        pageBeforeLogin.typeLoginAndPassword();
        LoggedPage pageAfterLogin = pageBeforeLogin.clickSubmitButton();
        pageAfterLogin.checkUserNamePresent();
    }

    @Title("Проверка успешного разлогина")
    @Test
    public void checkLogout() {
        NotLoggedPage pageBeforeLogin = new NotLoggedPage();
        LoggedPage pageAfterLogin = pageBeforeLogin.login();
        NotLoggedPage afterLogout = pageAfterLogin.logout();
        afterLogout.checkloginButtonPresent();
    }

    @After
    public void after() {
        WebDriverFactory.finishBrowser();
    }

}
