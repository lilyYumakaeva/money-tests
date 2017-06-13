package ru.autotests.common.config;


/**
 * Created by lily on 12.06.17.
 */
public class Config {

    private static Config config;

    public static Config getConfig() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }

    public static GetProperties PROPERTIES_FILE = new GetProperties();

    public Browser getBrowser() {
        Browser browserForTests = Browser.getByName(PROPERTIES_FILE.browser);
        if (browserForTests != null) {
            return browserForTests;
        } else {
            throw new IllegalStateException("Browser name '" + PROPERTIES_FILE.browser + "' is not valid");
        }
    }

    public String getBaseURL() {
        return PROPERTIES_FILE.baseURL;
    }

}
