package com.nsw.revenue.hooks;

import com.nsw.revenue.drivers.DriverManagerFactory;
import com.nsw.revenue.utils.ConfigUtil;
import com.nsw.revenue.utils.ScenarioUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;

public class Hooks {

    private final ScenarioUtil scenarioUtil;

    public Hooks(ScenarioUtil scenarioUtil) {
        this.scenarioUtil = scenarioUtil;
    }

    @Before("@Web")
    public void setup() {
        try {
            scenarioUtil.setDriver(DriverManagerFactory.getDriver(System.getProperty("browser")));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Before("@API")
    public void setupApi() {
        scenarioUtil.setUrl(ConfigUtil.getProperty("base.url"));
    }

    @After("@Web")
    public void tearDown() {
        DriverManagerFactory.quitDriver();
    }
}
