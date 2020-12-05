package com.company;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class GuestInformationPage {

    private WebDriver driver;
    By guestCheckoutButton = By.id("opc_guestCheckout");
    By socialTitle = By.id("id_gender");
    By costumerFirstName = By.id("customer_firstname");
    By costumerLastName = By.id("customer_lastname");
    By costumerEmail = By.id("email");
    By costumerMobilePhone = By.id("phone_mobile");
    By proceedButton = By.xpath("//a[@title='Proceed to Payment']");
    By saveButton = By.id("submitGuestAccount");


    public GuestInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnGuestCheckout(){
        System.out.println("Looking for 'Guest Checkout' button, click on it");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(guestCheckoutButton));
        driver.findElement(guestCheckoutButton).click();
    }

    public void selectSocialTitle(String gender) {
        System.out.println("Looking for 'Social title' select, selecting 'Mr.'");
        new Select(driver.findElement(socialTitle)).selectByVisibleText(gender);
    }

    public void fillInFirstName(String firstName) {
        System.out.println("Looking for 'First name' input box, filling in it with: " + firstName);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(costumerFirstName));
        System.out.println("filling in it with: " + firstName);
        driver.findElement(costumerFirstName).sendKeys(firstName);
    }

    public void fillInLastName(String lastName) {
        System.out.println("Looking for 'Last name' input box,  filling in it with: " + lastName);
        driver.findElement(costumerLastName).sendKeys(lastName);
    }

    public void fillInEmail(String email) {
        System.out.println("Looking for 'Email' input box,  filling in it with: " + email);
        driver.findElement(costumerEmail).sendKeys(email);
    }

    public void fillInMobilePhone(Integer mobilePhone) {
        System.out.println("Looking for 'Email' input box,  filling in it with: " + mobilePhone);
        driver.findElement(costumerMobilePhone).sendKeys(mobilePhone.toString());
    }

    /*public void clickOnSave() throws InterruptedException {
        System.out.println("Looking for 'Save' button, clicking on it.");
        driver.findElement(By.id("submitGuestAccount")).click();
    }

    public boolean isGuestInformationDisplayed() {
        System.out.println("Checking if 'Guest information' is displayed.");
        WebElement guestInformation = driver.findElement(By.xpath("//a[@title='Proceed to Payment']"));
        return guestInformation.isDisplayed();
    }*/

    public void clickOnSave() {
        System.out.println("Looking for 'Save' button, clicking on it.");
        driver.findElement(saveButton).click();
    }

    public boolean isProceedButtonDisplayed() throws InterruptedException {
        System.out.println("Checking if 'Guest information' is displayed.");
        return driver.findElement(proceedButton).isDisplayed();
    }

    public PaymentInformation clickOnProceedButton(){
        System.out.println("Looking for 'procees' button, clicking on it.");
        driver.findElement(proceedButton).click();

        return new PaymentInformation(driver);
    }

    public PaymentInformation fillAllGuestInformationPageAndProceed(String gender, String name, String lastName, String email, int mobile){
       clickOnGuestCheckout();
       selectSocialTitle(gender);
       fillInFirstName(name);
       fillInLastName(lastName);
       fillInEmail(email);
       fillInMobilePhone(mobile);
       clickOnSave();

       return new PaymentInformation(driver);
    }
}
