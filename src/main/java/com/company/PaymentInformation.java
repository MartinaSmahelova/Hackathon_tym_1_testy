package com.company;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

public class PaymentInformation {

    private WebDriver driver;
    By checkboxIagree = By.className("checker");
    By payByBankWire = By.xpath("//a[@title = 'Pay by bank wire']");
    By payByCard = By.xpath("//a[@title = 'Pay with PayPal']");

    public PaymentInformation(WebDriver driver) {
        this.driver = driver;
    }

    public void checkAgreeWithTermsAndConditions() {
        System.out.println("Looking for the checkbox 'I agree with terms'.");
        WebElement newCustomerRegisterButton = driver.findElement(checkboxIagree);
        Actions myCursor = new Actions(driver);
        System.out.println("Hovering over the checkbox 'I agree'.");
        myCursor.moveToElement(newCustomerRegisterButton).build().perform();
        System.out.println("Checking the checkbox 'I agree with terms'.");
        myCursor.click().build().perform();
        //return new CustomRegisterPage(driver);
    }

    public OrderSummary payByBankWIre(){
        System.out.println("Looking for the button 'Pay by bank wire', click on it.");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(payByBankWire));
        driver.findElement(payByBankWire).click();

        return new OrderSummary(driver);
    }

    public OrderSummary payByCardOrPaypal(){
        System.out.println("Looking for the button 'Pay by bank wire', click on it.");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(payByCard));
        driver.findElement(payByCard).click();

        return new OrderSummary(driver);
    }

}
