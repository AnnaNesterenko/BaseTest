package com.selenium.test.webtestsbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Anna_Nesterenko on 10.01.2016.
 */
public class WebDriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            return driver = new FirefoxDriver();
        }
    }

    public static void finishBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
