package com.nsw.revenue.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculationComponent extends BaseComponent {

    @FindBy(xpath = "//table[@class='TableApp']//td[contains(text(),'Is this registration for a passenger vehicle?')]/following-sibling::td")
    private WebElement isRegistered;

    @FindBy(xpath = "//table[@class='TableApp']//td[contains(text(),'Purchase price or value')]/following-sibling::td")
    private WebElement purchasePrice;

    @FindBy(xpath = "//table[@class='TableApp']//td[contains(text(),'Duty payable')]/following-sibling::td")
    private WebElement dutyPayable;

    public CalculationComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed() {
        WebElement modalDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));
        return modalDialog.isDisplayed();
    }

    public String getIsRegistered() {
        return isRegistered.getText();
    }

    public String getPurchasePrice() {
        return purchasePrice.getText();
    }

    public String getDutyPayable() {
        return dutyPayable.getText();
    }

}
