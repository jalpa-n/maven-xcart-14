package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import javax.xml.soap.Name;
import java.util.List;

public class SalePage extends Utility {

    By saleText = By.xpath("//h1[@id='page-title']");
    By sortBy = By.xpath("//span[contains(text(),'Sort by:')]");
    By sortByMenu = By.xpath("//ul[@class='display-sort sort-crit grid-list']//li//a");
    By productList = By.xpath("//div[@class='items-list items-list-products sale-products']//h5");
    By productPriceList = By.xpath("//div[@class='items-list items-list-products sale-products']//span[@class='price product-price']");
    By productRateList = By.xpath("//div[@class='products']//div[@class='stars-row full']");
    By addFirstProductToCart = By.xpath("(//span[text()='Add to cart'])[1]");
    By productAddToCartMessage = By.xpath("//li[contains(text(),'Product has been added to your cart')]");
    By closeAddToCartMessage = By.xpath("//a[@class='close']");
    By yourCart = By.xpath("//div[@title='Your cart']");
    By viewCart = By.xpath("//span[contains(text(),'View cart')]");

    //method to verify "sale" text
    public String actualSaleText(){

        Reporter.log("Getting Sale text from element "+saleText.toString()+"<br>");
        return waitUntilVisibilityOfElementLocated(saleText,50).getText();
    }

    //method to select filter from sort-by drop-down on sale page
    public void selectSortByFilter(String filter) throws InterruptedException {

        mouseHoverToElement(sortBy);
        List<WebElement> filterList=driver.findElements(sortByMenu);
        for(WebElement element:filterList){
            Thread.sleep(1000);
            Reporter.log("Getting text "+ element.getText()+"From element"+element.toString()+"compare with"+filter+"<br>");
            if(element.getText().trim().equalsIgnoreCase(filter)){
                Reporter.log("Mouse hover and click on filter"+element.toString()+"<br>");
                mouseHoverAndClickToElement(element);
                break;
            }
        }
    }
    //method to verify product name in ascending order
    public List<String> getProductNames() throws InterruptedException {

        Reporter.log("Getting product name"+productList.toString()+"<br");
        return setProductNameList(productList);
    }

    //method to verify product price in ascending order
    public List<Double> getProductPrices() throws InterruptedException {

        Reporter.log("Getting product price "+productPriceList.toString()+"<br>");
        return setProductPriceList (productPriceList);
    }

    //method to verify product rating in descending order
    public List <Double> getProductRates() throws InterruptedException {

        Reporter.log("Getting product ratting "+productRateList.toString()+"<br>");
        return setProductRateList (productRateList);
    }

    //method to add product to cart
    public void addProductToCart(){

        Reporter.log("Add product to cart "+addFirstProductToCart.toString()+"<br>");
        mouseHoverAndCLickToElement(addFirstProductToCart);
    }

    public String actualAddToCartDisplayedMessage(){

        Reporter.log("Getting Green bar message "+productAddToCartMessage.toString()+"<br>");
        return waitUntilVisibilityOfElementLocated(productAddToCartMessage,20).getText();
    }

    public void closeAddToCartMessage (){

        Reporter.log("Closing green bar message "+closeAddToCartMessage.toString()+"<br>");
        clickOnElement(closeAddToCartMessage);
    }

    public void clickOnYourCartAndViewCart(){

        Reporter.log("Click on your cart tab "+yourCart.toString()+"<br>");
        clickOnElement(yourCart);
        Reporter.log("Click on view car button "+viewCart.toString()+"<br>");
        clickOnElement(viewCart);
    }
}
