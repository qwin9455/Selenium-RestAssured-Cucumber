package com.nsw.revenue.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManagerFactory {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver(String browserType) {
        WebDriver driver = driverThreadLocal.get();
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
            case "firefox" -> new FirefoxDriverManager();
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
