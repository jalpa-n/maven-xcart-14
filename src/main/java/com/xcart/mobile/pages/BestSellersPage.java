package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

public class BestSellersPage extends Utility {
    By sortBy = By.xpath("//span[contains(text(),'Sort by:')]");
    By sortByMenu = By.xpath("//ul[@class='display-sort sort-crit grid-list']//li//a");
    By productsZToA = By.xpath("//ul[@class='products-grid grid-list']/descendant::h5");
    By bestSellerText = By.xpath("//h1[@id='page-title']");
    By productPrice = By.xpath("//ul[@class='products-grid grid-list']/descendant::span[@class='price product-price']");
    By productRates = By.xpath("//div[@class='products']//div[@class='stars-row full']");
    By addVinylTOCart = By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-13']");
    By productAddToCartMessage = By.xpath("//li[contains(text(),'Product has been added to your cart')]");
    By closeAddToCartMessage = By.xpath("//a[@class='close']");
    By yourCart = By.xpath("//div[@title='Your cart']");
    By viewCart = By.xpath("//span[contains(text(),'View cart')]");


    //method to select filter from sort-by drop down menu
    public void selectSortByFilter(String filter) throws InterruptedException {

        Reporter.log("Mouse hover to sort-by drop-down "+ sortBy.toString()+"<br>");
        mouseHoverToElement(sortBy);
        List<WebElement> filterList = driver.findElements(sortByMenu);

        for (WebElement element : filterList) {
            Thread.sleep(1000);
            Reporter.log("Getting text "+ element.getText()+"From element"+element.toString()+"compare with"+filter+"<br>");

            if (element.getText().trim().equalsIgnoreCase(filter)) {
                Reporter.log("Mouse hover and click to a filter "+ element.toString()+"<br>");
                mouseHoverAndClickToElement(element);
                break;
            }
        }
    }

    //method to verify "Bestseller" text
    public String actualBestSellerText() {

        Reporter.log("Getting Seller Text" + bestSellerText.toString()+ "<br>");
        return waitUntilVisibilityOfElementLocated(bestSellerText, 20).getText();
    }

    //Method to get product name
    public List<String> getProductName() throws InterruptedException {

        Reporter.log("Getting product name "+ productsZToA.toString()+"<br>");
        return setProductNameList(productsZToA);
    }

    //method to get price list from bestseller page
    public List<Double> getProductPrice() throws InterruptedException {

        Reporter.log("Getting product price list "+ productPrice.toString()+"<br>");
        return setProductPriceList(productPrice);
    }

    //method to get product rating
    public List<Double> getProductRating() throws InterruptedException {

        Reporter.log("Getting product ratting "+productRates.toString()+"<br>");
        return setProductRateList(productRates);
    }

    public void addVinylIdolsToCart (){

        Reporter.log("Mouse hover and click to add product to cart"+addVinylTOCart.toString()+"<br>");
        mouseHoverAndCLickToElement(addVinylTOCart);
    }
    public String actualAddToCartDisplayedMessage(){

        Reporter.log("Getting green bar text "+productAddToCartMessage.toString()+"<br>");
        return waitUntilVisibilityOfElementLocated(productAddToCartMessage,20).getText();
    }

    public void closeAddToCartMessage (){

        Reporter.log("Close green bar message "+closeAddToCartMessage.toString()+"<br>");
        clickOnElement(closeAddToCartMessage);
    }

    public void clickOnYourCartAndViewCart(){

        Reporter.log("Click on your cart drop-down"+yourCart.toString()+"<br>");
        clickOnElement(yourCart);
        Reporter.log("Click on view cart"+viewCart.toString()+"<br>");
        clickOnElement(viewCart);
    }



}