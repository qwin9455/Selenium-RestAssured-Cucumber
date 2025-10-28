package com.nsw.revenue.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager implements DriverManager {
    @Override
    public WebDriver createDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        if (System.getProperty("headless") != null && System.getProperty("headless").equals("true"))
            options.addArguments("headless");
        return new FirefoxDriver(options);
    }
}
