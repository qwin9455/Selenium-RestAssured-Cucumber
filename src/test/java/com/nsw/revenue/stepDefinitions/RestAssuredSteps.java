package com.nsw.revenue.stepDefinitions;

import com.nsw.revenue.utils.ScenarioUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.RestAssured;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class RestAssuredSteps {

    private Response response;

    public RestAssuredSteps(ScenarioUtil scenarioUtil) {
        RestAssured.baseURI = scenarioUtil.getUrl();
    }

    @Given("I send a get request to {string}")
    public void iSendAGetRequestTo(String endpoint) {
        response = RestAssured.given().get(endpoint);
    }

    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("the response should contain {string} : {string}")
    public void theResponseShouldContain(String key, String value) {

    }

    @And("the {string} should be equal to {string}")
    public void theShouldBeEqualTo(String key, String value) {
        response.then().body(key, equalTo(value));
    }

    @And("the {string} should contain {string}")
    public void theShouldContain(String key, String value) {
        response.then().body(key, hasItem(value));
    }
}
