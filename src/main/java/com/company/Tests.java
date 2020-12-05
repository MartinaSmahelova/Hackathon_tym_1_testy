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
    public void sucesfullyPlacedOrder_NewCustomer_ValidInformation_PayByWire() {
        HomePage homePage = new HomePage(firefox);
        homePage.selectHotel();
        homePage.selectCheckInDate("06-12-2020");
        homePage.selectCheckOutDate("08-12-2020");
        AvalibleRooms avalibleRooms = homePage.SearchNow();
        avalibleRooms.chooseFrstAvailibleRoom();
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
        Assert.assertTrue("When clicing on confirm order button, confirmation message is displayed",
               orderSummary.isOrderConfirmationDisplayed());
    }

    @Test
    public void sucesfullyPlaceOrder_CostumerWithALreadyRegisteredEmail() {
        HomePage homePage = new HomePage(firefox);
        homePage.fillAllSearchNowInformation("15-12-2020","17-12-2020");
        AvalibleRooms avalibleRooms = homePage.SearchNow();
        avalibleRooms.chooseFrstAvailibleRoom();
        roomsAndPriceSummary roomsAndPriceSummary = avalibleRooms.clickOnProocedToCheckOutButton();
        GuestInformationPage guestInformationPage = roomsAndPriceSummary.clickOnBookNowButton();
        guestInformationPage.clickOnGuestCheckout();
        guestInformationPage.selectSocialTitle("Mrs.");
        guestInformationPage.fillInFirstName("Anna");
        guestInformationPage.fillInLastName("Best");
        guestInformationPage.fillInEmail("tester.testczechitas@gmail.com");
        guestInformationPage.fillInMobilePhone(123456789);
        guestInformationPage.clickOnSave();
        Assert.assertTrue("When submiting already registered email, error message is displayed",
                guestInformationPage.isErrorMessageDisplayed());
    }


    @Test
    public void dateConfirmationNextYear() {
        HomePage homePage = new HomePage(firefox);
        homePage.selectHotel();
        homePage.selectCheckInDate("06-01-2021");
        homePage.selectCheckOutDate("08-01-2021");
        AvalibleRooms avalibleRooms = homePage.SearchNow();
        Assert.assertTrue("When clicing on confirm order button, confirmation message is displayed",
                avalibleRooms.isAvailibleRoomsPageDisplayed());
    }

    @Test
    public void dateConfirmationThisYear() {
        HomePage homePage = new HomePage(firefox);
        homePage.selectHotel();
        homePage.selectCheckInDate("06-12-2020");
        homePage.selectCheckOutDate("08-12-2020");
        AvalibleRooms avalibleRooms = homePage.SearchNow();
        Assert.assertTrue("When clicing on confirm order button, confirmation message is displayed",
                avalibleRooms.isAvailibleRoomsPageDisplayed());
    }

    /**
     * Test failed connected to bug with ID 282
     */
    @Test
    public void unsucesfullyPlaceOrder_NewCustomer_ValidInformation_PayByPayPal() {
        HomePage homePage = new HomePage(firefox);
        homePage.selectHotel();
        homePage.selectCheckInDate("06-12-2020");
        homePage.selectCheckOutDate("08-12-2020");
        AvalibleRooms avalibleRooms = homePage.SearchNow();
        avalibleRooms.chooseFrstAvailibleRoom();
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
        OrderSummary orderSummary = paymentInformation.payByCardOrPaypal();
        orderSummary.clickOnConfirmOrder();
        Assert.assertTrue("When clicing on confirm order button, confirmation message is displayed",
                orderSummary.isOrderConfirmationDisplayed());
    }


    @After
    public void CleanUp(){
        firefox.quit();
    }


}
