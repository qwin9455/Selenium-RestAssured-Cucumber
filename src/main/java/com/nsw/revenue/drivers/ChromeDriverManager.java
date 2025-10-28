package com.nsw.revenue.drivers;

import com.nsw.revenue.utils.Base64Util;
import com.nsw.revenue.utils.ConfigUtil;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class ChromeDriverManager implements DriverManager {
    @Override
    public RemoteWebDriver createDriver() throws MalformedURLException {
        var browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");

        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("project", "LambdaTest Revenue NSW Automation");
        ltOptions.put("build", "LambdaTest V1.0.0");
        ltOptions.put("name", "Stamp Duty Calculator");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");

        browserOptions.setCapability("LT:Options", ltOptions);

        String gridUrl = "@hub.lambdatest.com/wd/hub";
        return new RemoteWebDriver(
                new URL("http://" + Base64Util.decryptString(ConfigUtil.getProperty("username")) + ":" + Base64Util.decryptString(ConfigUtil.getProperty("access.key")) + gridUrl),
                browserOptions
        );
    }
}
