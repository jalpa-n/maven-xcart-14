package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class TargetCheckoutPage extends Utility {

    By secureCheckoutText = By.xpath("//h1[@class='title']");
    By firstNameField = By.xpath("//input[@id='shippingaddress-firstname']");
    By lastNameField = By.xpath("//input[@id='shippingaddress-lastname']");
    By addressField = By.xpath("//input[@id='shippingaddress-street']");
    By cityField = By.xpath("//input[@id='shippingaddress-city']");
    By countryDropDown = By.xpath("//select[@id='shippingaddress-country-code']");
    By stateField = By.xpath("//input[@id='shippingaddress-custom-state']");
    By zipCodeField = By.xpath("//input[@id='shippingaddress-zipcode']");
    By checkOut = By.xpath("//input[@id='create_profile']");
    By passwordField = By.xpath("//input[@id='password']");
    By localShippingRadio = By.xpath("//label[@title='Local shipping']//input[@id='method128']");
    By cODRadio = By.xpath("//input[@value='6']");
    By totalPrice = By.xpath("(//span[@class='surcharge-cell'])[6]");
    By placeOrderButton = By.xpath("//span[contains(text(),'Place order:')]");
    By thankYouText = By.xpath("//h1[@id='page-title']");
    By greenBarMessage = By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]");
    By greenBarClose = By.xpath("//a[@class='close']");
    By cartEmptyMessage = By.xpath("//h1[@id='page-title']");

    public String actualSecureCheckoutText (){
        Reporter.log("Getting Secure checkout text from element "+secureCheckoutText.toString()+"<br>");
        return waitUntilVisibilityOfElementLocated(secureCheckoutText,20).getText();
    }
    public void enterFirstName(String firstName){
        Reporter.log("Enter first name "+firstNameField.toString()+"<br>");
        sendTextToElement(firstNameField,firstName);
    }
    public void enterLastName(String lastName){
        Reporter.log("Enter Last name "+lastNameField.toString()+"<br");
        sendTextToElement(lastNameField,lastName);
    }
    public void enterAddress(String address){
        Reporter.log("Enter address "+addressField.toString()+"<br>");
        sendTextToElement(addressField,address);
    }
    public void enterCity (String city){

        Reporter.log("clear text on city "+cityField.toString()+"<br>");
        clearTextOnElement(cityField);
        Reporter.log("Enter city name "+cityField.toString()+"<br>");
        sendTextToElement(cityField,city);
    }
    public void selectCountryFromDropDownMenu(String countryText){

        Reporter.log("Select country "+countryDropDown.toString()+"<br>");
        countryText.equalsIgnoreCase(countryText);
        selectByVisibleText(countryDropDown,countryText);
    }
    public void enterState(String state){

        Reporter.log("Clear text from state field "+stateField.toString()+"<br>");
        clearTextOnElement(stateField);
        Reporter.log("Enter text to state field "+stateField.toString()+"<br>");
        sendTextToElement(stateField,state);
    }
    public void enterZipCode(String zipCode) throws InterruptedException {

        Thread.sleep(3000);
        Reporter.log("Clear text from zipcode field "+zipCodeField.toString()+"<br>");
        clearTextOnElement(zipCodeField);
        Thread.sleep(2000);
        Reporter.log("Enter text to state field "+zipCodeField.toString()+"<br>");
        sendTextToElement(zipCodeField,zipCode);
    }
    public void clickOnCreateAnAccountCheckBox() throws InterruptedException {

        Thread.sleep(3000);
        Reporter.log("Click on create an account for later use "+checkOut.toString()+"<br>");
        mouseHoverAndCLickToElement(checkOut);
    }
    public void enterPassword (String password){
        Reporter.log("Enter password "+passwordField.toString()+"<br>");
        sendTextToElement(passwordField,password);
    }
    public void clickLocalShippingRadioButton(){
        Reporter.log("Click on local shipping "+localShippingRadio.toString()+"<br>");
        mouseHoverAndCLickToElement(localShippingRadio);
    }
    public void clickCODRadioButton(){
        Reporter.log("Click on radio button "+cODRadio.toString()+"<br>");
        mouseHoverAndCLickToElement(cODRadio);
    }
    public String actualTotalPrice(){

        Reporter.log("Getting total price from element "+totalPrice.toString()+"<br>");
        return waitUntilVisibilityOfElementLocated(totalPrice,20).getText();
    }
    public void clickOnPlaceOrderButton(){
        Reporter.log("Click on place order button "+placeOrderButton.toString()+"<br>");
        clickOnElement(placeOrderButton);
    }
    public String actualThankYouForYourOrderText(){
        Reporter.log("Getting thank you for your order "+thankYouText.toString()+"<br>");
        return waitUntilVisibilityOfElementLocated(thankYouText,20).getText();
    }
    public String actualGreenBarMessage(){
        Reporter.log("Getting green bar message "+ greenBarMessage.toString()+"<br>");
        return waitUntilVisibilityOfElementLocated(greenBarMessage,20).getText();

    }
    public void clickCloseOnGreenBarMessage(){
        Reporter.log("Close green bar message "+greenBarClose.toString()+"<br>");
        clickOnElement(greenBarClose);
    }
    public String actualYourCartIsEmptyMessage (){
        Reporter.log("Getting your cart empty text from element "+cartEmptyMessage.toString()+"<br>");
        return waitUntilVisibilityOfElementLocated(cartEmptyMessage,20).getText();
    }

}
