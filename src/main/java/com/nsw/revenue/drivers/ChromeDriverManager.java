package com.nsw.revenue.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager implements DriverManager {
    @Override
    public WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        if (System.getProperty("headless") != null && System.getProperty("headless").equals("true"))
            options.addArguments("headless");
        return new ChromeDriver(options);
    }
}
