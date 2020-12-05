package com.company;

import java.util.concurrent.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class Tests {

    WebDriver firefox;

    @Before
    public void SetUp(){

        System.setProperty("webdriver.gecko.driver","C:\\FirefoxDriver\\geckodriver.exe");

        firefox = new FirefoxDriver();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("-private");
        firefox.manage().window().maximize();
        firefox.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void PlaceOrder() {
        HomePage homePage = new HomePage(firefox);
        homePage.selectHotel();
        homePage.selectCheckInDate("06-12-2020");
        homePage.selectCheckOutDate("08-12-2020");
        AvalibleRooms avalibleRooms = homePage.SearchNow();
        avalibleRooms.clickOnBookNowButton();
        roomsAndPriceSummary roomsAndPriceSummary = avalibleRooms.clickOnProocedToCheckOutButton();
        GuestInformationPage guestInformationPage = roomsAndPriceSummary.clickOnBookNowButton();
        guestInformationPage.clickOnGuestCheckout();
        guestInformationPage.selectSocialTitle("Mrs.");
        guestInformationPage.fillInFirstName("Anna");
        guestInformationPage.fillInLastName("Best");
        guestInformationPage.fillInEmail("tester.testczechitas1@gmail.com");
        guestInformationPage.fillInMobilePhone(123456789);
        guestInformationPage.clickOnSave();
        PaymentInformation paymentInformation = guestInformationPage.clickOnProceedButton();
        paymentInformation.checkAgreeWithTermsAndConditions();
        OrderSummary orderSummary = paymentInformation.payByBankWIre();
        orderSummary.clickOnConfirmOrder();

    }


    @After
    public void CleanUp(){
        firefox.quit();
    }


}
