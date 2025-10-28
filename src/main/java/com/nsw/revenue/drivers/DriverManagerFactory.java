package com.nsw.revenue.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public class DriverManagerFactory {

    private static final ThreadLocal<RemoteWebDriver> driverThreadLocal = new ThreadLocal<>();

    public static RemoteWebDriver getDriver(String browserType) throws MalformedURLException {
        RemoteWebDriver driver = driverThreadLocal.get();
        if (driver == null) {
            DriverManager driverManager = createDriverManager(browserType);
            driver = driverManager.createDriver();
            driverThreadLocal.set(driver);
        }
        return driver;
    }

    private static DriverManager createDriverManager(String browserType) {
        return switch (browserType.toLowerCase()) {
            case "chrome" -> new ChromeDriverManager();
            default -> throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        };
    }

    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
}
