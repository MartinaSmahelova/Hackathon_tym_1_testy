package com.company;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class roomsAndPriceSummary {

    WebDriver driver;
    By proceedButton = By.xpath("//*[@id=\"collapse-shopping-cart\"]/div/div[2]/div[2]/div/a");

   
    public roomsAndPriceSummary(WebDriver webBrowser) {
        driver = webBrowser;
    }

    public GuestInformationPage clickOnBookNowButton(){
        System.out.println("Find and click on proceed button");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(proceedButton));
        driver.findElement(proceedButton).click();

        return new GuestInformationPage(driver);
    }
}
