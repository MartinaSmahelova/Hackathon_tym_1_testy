package com.company;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class OrderSummary {
    private WebDriver driver;
    By iConfirmMyOrderButton = By.xpath("//button[@type='submit']");
    By confirmationMessage = By.xpath("//p[contains(@class,'alert-success')]");

    public OrderSummary(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnConfirmOrder(){
        System.out.println("Looking for the button 'I confirm my order', click on it.");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(iConfirmMyOrderButton));
        driver.findElement(iConfirmMyOrderButton).click();
    }

    public boolean isOrderConfirmationDisplayed(){
        System.out.println("'Confirmation message' is displayed");
        return driver.findElement(confirmationMessage).isDisplayed();
    }


}
