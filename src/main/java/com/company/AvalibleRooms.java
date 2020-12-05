package com.company;
import org.openqa.selenium.*;

public class AvalibleRooms {

        WebDriver driver;
        String homePageUrl = "http://www.czechitas-hackhaton.cz/en/";
        By bookNowButton = By.xpath("//*[@id=\"category_data_cont\"]/div[1]/div/div[2]/a/span");
        By layerCard = By.id("//*[@id=\"layer_cart\"]");
        By proocedToCheckOutButton = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");
        By BudgetCabinRoom = By.xpath("");
        By DeluxeAppartmentsRoom = By.xpath("");
        By FullNatureExperienceRoom = By.xpath("");
        By LuxuryInTheWoodsRoom = By.xpath("");

        public AvalibleRooms(WebDriver webBrowser) {
            driver = webBrowser;
        }

        public void clickOnBookNowButton(){
            System.out.println("Find and click on book now button");
            driver.findElement(bookNowButton).click();
        }

        /**
         * use room namber:
         * 1 = Budget Cabin
         * 2 = Deluxe appartments
         * 3 = Full Nature Experience
         * 4 = Luxury in the woods
         * @param roomeNumber
         */
        public void chooseRoomAndClikBookNowButton(int roomeNumber){
                if (roomeNumber == 1){
                        System.out.println("Choose room Budget Cabin and click Book Now button");
                        driver.findElement(bookNowButton).click();
                }

                if (roomeNumber == 2){
                        System.out.println("Choose room Deluxe appartments and click Book Now button");
                        driver.findElement(bookNowButton).click();
                }

                if (roomeNumber == 3){
                        System.out.println("Choose room Full Nature Experience and click Book Now button");
                        driver.findElement(bookNowButton).click();
                }

                if (roomeNumber == 4){
                        System.out.println("Choose room Luxury in the woods and click Book Now button");
                        driver.findElement(bookNowButton).click();
                }
        }

        public roomsAndPriceSummary clickOnProocedToCheckOutButton(){
        System.out.println("Find and click on prooced to checkcout button");
        driver.findElement(proocedToCheckOutButton).click();

        return new roomsAndPriceSummary(driver);
        }

//        public void getTextOfLayerCard(){
//            driver.findElement(layerCard).getText();
//            System.out.println("Text of layer card: " + driver.findElement(layerCard).getText());
//        }
}
