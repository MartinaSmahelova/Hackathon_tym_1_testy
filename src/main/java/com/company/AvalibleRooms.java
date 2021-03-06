package com.company;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class AvalibleRooms {

        WebDriver driver;
        String homePageUrl = "http://www.czechitas-hackhaton.cz/en/";
        By layerCard = By.id("//*[@id=\"layer_cart\"]");
        By proocedToCheckOutButton = By.xpath("//a[@title='Proceed to checkout']");
        By budgetCabinRoom = By.xpath("//a[@data-id-product='1']");
        By deluxeAppartmentsRoom = By.xpath("//a[@data-id-product='2']");
        By fullNatureExperienceRoom = By.xpath("//a[@data-id-product='3']");
        By luxuryInTheWoodsRoom = By.xpath("//a[@data-id-product='4']");
        By rooms = By.xpath("//span[text()='Book Now']");
        By availibleRoomsPage = By.xpath("//span[text()='Search Rooms']");

        public AvalibleRooms(WebDriver webBrowser) {
            driver = webBrowser;
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
                        WebDriverWait wait = new WebDriverWait(driver,10);
                        wait.until(ExpectedConditions.elementToBeClickable(budgetCabinRoom));
                        driver.findElement(budgetCabinRoom).click();
                }

                if (roomeNumber == 2){
                        System.out.println("Choose room Deluxe appartments and click Book Now button");
                        WebDriverWait wait = new WebDriverWait(driver,10);
                        wait.until(ExpectedConditions.elementToBeClickable(deluxeAppartmentsRoom));
                        driver.findElement(deluxeAppartmentsRoom).click();
                }

                if (roomeNumber == 3){
                        System.out.println("Choose room Full Nature Experience and click Book Now button");
                        WebDriverWait wait = new WebDriverWait(driver,10);
                        wait.until(ExpectedConditions.elementToBeClickable(fullNatureExperienceRoom));
                        driver.findElement(fullNatureExperienceRoom).click();
                }

                if (roomeNumber == 4){
                        System.out.println("Choose room Luxury in the woods and click Book Now button");
                        WebDriverWait wait = new WebDriverWait(driver,10);
                        wait.until(ExpectedConditions.elementToBeClickable(luxuryInTheWoodsRoom));
                        driver.findElement(luxuryInTheWoodsRoom).click();
                }
        }

        public void chooseFrstAvailibleRoom(){
                List<WebElement> availableRooms = driver.findElements(rooms);
                if (availableRooms.size() > 0) {
                        for (int i = 0; i < availableRooms.size(); i++) {
                                availableRooms.get(i).click();
                                break; }
                }
                else {
                        System.out.println("No room available");
                }

        }


        public roomsAndPriceSummary clickOnProocedToCheckOutButton(){
        System.out.println("Find and click on prooced to checkcout button");
        driver.findElement(proocedToCheckOutButton).click();

        return new roomsAndPriceSummary(driver);
        }

        public boolean isAvailibleRoomsPageDisplayed(){
                System.out.println("Is available rooms page displayed");
                return driver.findElement(availibleRoomsPage).isDisplayed();
        }


}
