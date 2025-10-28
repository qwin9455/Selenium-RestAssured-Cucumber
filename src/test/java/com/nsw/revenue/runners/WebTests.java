package com.nsw.revenue.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.*;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.nsw.revenue.stepDefinitions", "com.nsw.revenue.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"},
        tags = "@Web"
)
public class WebTests extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
