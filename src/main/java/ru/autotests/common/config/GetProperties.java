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

    InputStream inputStream;

    GetProperties() {

        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            baseURL = prop.getProperty("baseURL");
            browser = prop.getProperty("browser");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e2) {
                System.out.println("Can't close inputStream, exception: " + e2);
            }
        }
    }
}



