package com.nsw.revenue.drivers;

import com.nsw.revenue.utils.Base64Util;
import com.nsw.revenue.utils.ConfigUtil;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriverManager extends DriverManager {
    @Override
    public RemoteWebDriver createDriver() throws MalformedURLException {
        var browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");

        browserOptions.setCapability("LT:Options", getLtOptions());
        return new RemoteWebDriver(
                new URL("http://" + Base64Util.decryptString(ConfigUtil.getProperty("username")) + ":" + Base64Util.decryptString(ConfigUtil.getProperty("access.key")) + ConfigUtil.getProperty("grid.url")),
                browserOptions
        );
    }
}
