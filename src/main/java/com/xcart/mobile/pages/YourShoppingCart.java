package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class YourShoppingCart extends Utility {

    By yourShoppingCart = By.xpath("//h1[@id='page-title']");
    By quantityChange = By.xpath("//input[@id='amount16']");
    By subTotal = By.xpath("(//span[@class='cart-subtotal']//span[@class='surcharge-cell'])[1]");
    By total = By.xpath("//li[@class='total']//span[@class='surcharge-cell']");
    By checkOutButton = By.xpath("//span[contains(text(),'Go to checkout')]");
    By emptyCartLink = By.xpath("//a[contains(text(),'Empty your cart')]");
    By emptyCartMessage = By.xpath("//h1[@id='page-title']");



    public String actualYourShoppingCartText (){
        Reporter.log("Getting your shopping cart text "+yourShoppingCart.toString()+"<br>");
        return waitUntilVisibilityOfElementLocated(yourShoppingCart,20).getText();
    }
    public void clearExistingProductQuantity(){
        Reporter.log("Clear quantity of products "+quantityChange.toString()+"<br>");
        clearTextOnElement(quantityChange);
    }
    public void updateProductQuantity (String quantity) throws InterruptedException {
        Reporter.log("Send new quantity to the element "+quantityChange.toString()+"<br>");
        sendTextToElement(quantityChange,quantity);
    }
    public String actualSubTotal(){
        Reporter.log("Getting sub total "+subTotal.toString()+"<br>");
        return waitUntilVisibilityOfElementLocated(subTotal, 20).getText();
    }
    public String actualTotal(){
        Reporter.log("Getting total price "+total.toString()+"<br>");
        return waitUntilVisibilityOfElementLocated(total,20).getText();
    }
    public void clickOnCheckOutButton(){
        Reporter.log("Click on check out button "+checkOutButton.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(checkOutButton,30));
    }

    public void clickOnEmptyYourCart(){
        Reporter.log("Click on empty your cart "+emptyCartLink.toString()+"<br>");
        mouseHoverAndCLickToElement(emptyCartLink);
    }
    public String alertMessage(){
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
    public void clickOnAlertMessage(){
        Alert alert =driver.switchTo().alert();
        alert.accept();
    }

}

