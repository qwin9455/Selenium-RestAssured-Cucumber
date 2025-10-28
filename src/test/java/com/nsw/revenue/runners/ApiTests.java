package com.nsw.revenue.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.nsw.revenue.stepDefinitions", "com.nsw.revenue.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"},
        tags = "@API"
)
public class ApiTests extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
