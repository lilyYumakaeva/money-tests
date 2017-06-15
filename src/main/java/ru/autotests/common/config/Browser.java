package ru.autotests.common.config;

/**
 * Created by lily on 12.06.17.
 */
public enum Browser {

    FIREFOX("firefox"),
    CHROME("chrome"),
    OPERA("opera");

    private String browserName;

    Browser(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserName() {
        return browserName;
    }

    public static Browser getByName(String name){
        for(Browser browser : values()) {
            if(browser.getBrowserName().equalsIgnoreCase(name)) {
                return browser;
            }
        }
        return null;
    }
}
