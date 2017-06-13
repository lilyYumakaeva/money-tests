package ru.autotests.common;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import ru.autotests.common.config.WebDriverFactory;
import ru.autotests.common.pages.MainPageAfterLogin;
import ru.autotests.common.pages.MainPageBeforeLogin;

import java.net.MalformedURLException;


/**
 * Created by lily on 11.06.17.
 */
public class LoginLogoutTest {

    private WebDriver driver;

    @Before
    public void beforeTest() throws MalformedURLException {
        WebDriverFactory.startBrowser();
        driver = WebDriverFactory.getDriver();
    }

    @Test
    public void checkAuthorization(){
        MainPageBeforeLogin pageBeforeLogin = new MainPageBeforeLogin();
        MainPageAfterLogin pageAfterLogin = pageBeforeLogin.login();
        pageAfterLogin.logout();
    }

    @After
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }

}
