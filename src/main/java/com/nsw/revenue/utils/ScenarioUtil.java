package com.nsw.revenue.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ScenarioUtil {
    private RemoteWebDriver driver;
    private String url;

    public RemoteWebDriver getDriver() {
        return driver;
    }

    public void setDriver(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
