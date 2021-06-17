package com.xcart.mobile.utility;


import com.xcart.mobile.basepage.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Utility extends BasePage {

    /**
     * This method will click on element
     * @param by
     */
    public void clickOnElement(By by){

        driver.findElement(by).click();
    }

    public void clickOnElement(WebElement element){

        element.click();
    }




    /**
     * This method will get text from element
     * @param by
     * @return
     */

    public String getTextFromElement(By by){

        return driver.findElement(by).getText();

    }

    public String getTextFromElement(WebElement element){

        return element.getText();
    }




    /**
     * This method will send text on element
     * @param by
     * @param text
     */


    public void sendTextToElement(By by,String text){

        driver.findElement(by).sendKeys(text);
    }

    public void sendTextToElement(WebElement element,String text){

        element.sendKeys(text);
    }

    /**
     * this method will clear the existing text of an element
     */
    public void clearTextOnElement(By by) {

        WebElement clearText = driver.findElement(by);
        clearText.clear();
    }

    public void clearTextOnElement(WebElement element){

        WebElement clearText = element;
        clearText.clear();
    }



    /**
     * This method will select by value from dropdown
     * @param by
     * @param value
     */

    public void selectByValueFromDropDown (By by, String value){

        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }
    public void selectByValueFromDropDown (WebElement element, String value){

        Select select = new Select(element);
        select.selectByValue(value);
    }
    public void selectByVisibleText(By by,String visibleText){
        Select select=new Select(driver.findElement(by));
        select.selectByVisibleText(visibleText);
    }
    public void selectByVisibleText(WebElement element,String visibleText){
        Select select=new Select(element);
        select.selectByVisibleText(visibleText);
    }
    public void selectByIndex(By by,int index){
        Select select=new Select(driver.findElement(by));
        select.selectByIndex(index);
    }

    public void selectByIndex(WebElement element,int index){
        Select select=new Select(element);
        select.selectByIndex(index);
    }



    /**
     * this method change the quantity of selected element
     * @param quantity
     */
    public void changeQuantityOnElement(By by,String quantity){

        WebElement quantityElement=driver.findElement(by);
        quantityElement.clear();
        quantityElement.sendKeys(quantity);
    }

    public void changeQuantityOnElement(WebElement element ,String quantity){

        WebElement quantityElement= element;
        quantityElement.clear();
        quantityElement.sendKeys(quantity);
    }





    /**
     * This method used to scroll down the page
     * @param by
     * @param yAxis
     */
    public void scrollDown(By by,int yAxis){

        Actions actions=new Actions(driver);
        WebElement slider=driver.findElement(by);

        actions.dragAndDropBy(slider,0,yAxis).build().perform();
    }

    public void scrollDown(WebElement element,int yAxis){

        Actions actions=new Actions(driver);
        WebElement slider = element;

        actions.dragAndDropBy(slider,0,yAxis).build().perform();

    }




    /**
     * This method will used to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void mouseHoverToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    /**
     * This method will used to hover mouse on element
     */
    public void mouseHoverAndCLickToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

    public void mouseHoverAndClickToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }




    /**
     * this method will used to wait until element located
     * @param by
     * @param timeout
     * @return
     */

    public WebElement waitUntilVisibilityOfElementLocated(By by, int timeout){

        WebDriverWait wait = new WebDriverWait(driver,timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }


    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    /*
     *Screenshot methods
     */
    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }


    public List<String> setProductNameList(By by) throws InterruptedException {
        List<WebElement> productList = driver.findElements(by);
        List<String> productNameList = new ArrayList<>();


        for (WebElement list : productList) {
            Thread.sleep(2000);
            productNameList.add(list.getText());
        }
        return productNameList;
    }


    public List<Double> setProductPriceList(By by) throws InterruptedException {

        List<WebElement> productList= driver.findElements(by);
        List<Double>  productPriceList=new ArrayList<>();
        for(WebElement name:productList){
            Thread.sleep(1000);
            productPriceList.add(Double.parseDouble(name.getText().replace("$","")));
        }
        return productPriceList;
    }

    //This method get the List of ProductRate
    public List<Double> setProductRateList(By by) throws InterruptedException {

        List<WebElement> productList = driver.findElements(by);
        List<Double> productRateList = new ArrayList<>();
        for (WebElement name : productList) {

            Thread.sleep(1000);
            String rate = name.getAttribute("style").replace("width:", "");
            productRateList.add(Double.parseDouble(rate.replace("%;","")));
        }
        return productRateList;
    }

    public int randomNumber(){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(900);
    }

    public void alertAccept() {

        Alert alert = driver.switchTo().alert();
        alert.getText();
        alert.accept();
    }
}