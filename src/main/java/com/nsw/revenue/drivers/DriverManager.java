package com.nsw.revenue.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.util.HashMap;

public abstract class DriverManager {
    abstract RemoteWebDriver createDriver() throws MalformedURLException;

    public HashMap<String, Object> getLtOptions() {
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("project", "LambdaTest Revenue NSW Automation");
        ltOptions.put("build", "LambdaTest V1.0.0");
        ltOptions.put("name", "Stamp Duty Calculator");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        return ltOptions;
    }
}
