package com.company;

import org.openqa.selenium.*;

public class HomePage {
    WebDriver browser;
    String homePageUrl = "http://www.czechitas-hackhaton.cz/en/";
    By searchNowButton = By.id("search_room_submit");
    By buttonSelectHotel = By.id("id_hotel_button");
    By checkInDate = By.id("check_in_time");
    By checkOutDate = By.id("check_out_time");
    By hotelLocation = By.id("hotel_location");
    By hotelName = By.id("hotel_cat_name");
   

    public HomePage(WebDriver webBrowser) {
        browser = webBrowser;
        System.out.println("Navigate driver to Home page: " + homePageUrl );
        browser.navigate().to(homePageUrl);
    }


    public void selectHotel(){
        System.out.println("Find select hotel element and click on it");
        browser.findElement(buttonSelectHotel).click();
        System.out.println("Choose hotel name and click on it");
        browser.findElement(hotelName).click();
    }

    public void selectCheckInDate(String checkInDate){
        System.out.println("Find check in date element and click on it");
        browser.findElement(this.checkInDate).sendKeys(checkInDate);
    }
    

    public void selectCheckOutDate(String checkOutDate){
        System.out.println("Find check out date element and click on it");
        browser.findElement(this.checkOutDate).sendKeys(checkOutDate);
    }

    public AvalibleRooms SearchNow(){
        System.out.println("Find search now button and click on it");
        browser.findElement(searchNowButton).click();

        return new AvalibleRooms(browser);
    }

    public AvalibleRooms fillAllSearchNowInformation(String checkInDate, String checkOutDate){
        selectHotel();
        selectCheckInDate(checkInDate);
        selectCheckOutDate(checkOutDate);
        SearchNow();
        
        return new AvalibleRooms(browser);
    }
}
