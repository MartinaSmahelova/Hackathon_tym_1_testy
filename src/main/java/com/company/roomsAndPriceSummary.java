package com.company;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class roomsAndPriceSummary {

    WebDriver driver;
    By proceedButton = By.xpath("//a[@title='Proceed to checkout']");

   
    public roomsAndPriceSummary(WebDriver webBrowser) {
        driver = webBrowser;
    }

    public GuestInformationPage clickOnBookNowButton(){
        System.out.println("Find and click on proceed button");
        driver.findElement(proceedButton).click();

        return new GuestInformationPage(driver);
    }
}
