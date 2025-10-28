package com.nsw.revenue.pages;

import com.nsw.revenue.pages.components.CalculationComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StampDutyCalculatorPage extends BasePage {

    @FindBy(id = "purchasePrice")
    private WebElement purchasePrice;

    public StampDutyCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterPurchasePrice(String price) {
        purchasePrice.sendKeys(price);
    }

    public CalculationComponent getCalculationComponent() {
        return new CalculationComponent(driver);
    }
}
