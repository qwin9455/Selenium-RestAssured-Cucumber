package com.nsw.revenue.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public interface DriverManager {
    RemoteWebDriver createDriver() throws MalformedURLException;
}
