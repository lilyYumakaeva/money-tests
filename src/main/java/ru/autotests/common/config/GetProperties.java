package ru.autotests.common.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by lily on 12.06.17.
 */
public class GetProperties {

    String browser = "firefox";
    String baseURL = "https://money.yandex.ru/";
    String pathToOperaDriver = "";
    String pathToChromeDriver = "";
    String pathToGeckoDriver = "";

    InputStream inputStream;

    GetProperties() {

        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException(
                        String.format("Property file '%s' not found in the classpath", propFileName));
            }

            this.baseURL = prop.getProperty("baseURL");
            this.browser = prop.getProperty("browser");
            this.pathToChromeDriver = prop.getProperty("pathToChromeDriver");
            this.pathToGeckoDriver = prop.getProperty("pathToGeckoDriver");
            this.pathToOperaDriver = prop.getProperty("pathToOperaDriver");

        } catch (Exception e) {
            System.out.println(String.format("Exception: %s", e));
        } finally {
            try {
                inputStream.close();
            } catch (IOException e2) {
                System.out.println(
                        String.format("Can't close inputStream, while reading property file, exception: %s", e2));
            }
        }
    }
}



