package com.nsw.revenue.stepDefinitions;

import com.nsw.revenue.pages.StampDutyCalculatorPage;
import com.nsw.revenue.utils.ConfigUtil;
import com.nsw.revenue.utils.ScenarioUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class StampDutySteps {

    private final StampDutyCalculatorPage stampDutyCalculatorPage;

    public StampDutySteps(ScenarioUtil scenarioUtil) {
        stampDutyCalculatorPage = new StampDutyCalculatorPage(scenarioUtil.getDriver());
    }

    @Given("I am on the Service NSW duty check motor vehicle stamp duty page")
    public void iAmOnTheServiceNSWDutyCheckMotorVehicleStampDutyPage() {
        stampDutyCalculatorPage.navigateToUrl(ConfigUtil.getProperty("stamp.duty.url"));
    }

    @When("I click the {string} button")
    public void iClickTheButton(String buttonText) {
        stampDutyCalculatorPage.clickByText(buttonText);
    }

    @When("I choose {string} as registration type")
    public void iChooseAsRegistrationType(String registrationType) {
        stampDutyCalculatorPage.clickByText(registrationType);
        
    }

    @When("I enter the vehicle price as {string}")
    public void iEnterTheVehiclePriceAs(String vehiclePrice) {
        stampDutyCalculatorPage.enterPurchasePrice(vehiclePrice);
    }


    @Then("I am redirected to Revenue NSW page")
    public void iAmRedirectedToRevenueNSWPage() {
        assertEquals(stampDutyCalculatorPage.getCurrentUrl(), ConfigUtil.getProperty("revenue.nsw.url"));
    }

    @Then("I should see the calculation displayed")
    public void iShouldSeeTheCalculationDisplayed() {
        assert stampDutyCalculatorPage.getCalculationComponent().isDisplayed();
    }

    @Then("the details should be as follows")
    public void theDetailsShouldBeAsFollows(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        assertEquals(stampDutyCalculatorPage.getCalculationComponent().getIsRegistered(), rows.get(0).get("Is Passenger Vehicle"));
        assertEquals(stampDutyCalculatorPage.getCalculationComponent().getPurchasePrice(), rows.get(0).get("Purchase Price"));
        assertEquals(stampDutyCalculatorPage.getCalculationComponent().getDutyPayable(), rows.get(0).get("Duty Payable"));
    }
}
