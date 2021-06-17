package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {


    By menuList = By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li");
    By hotDeals = By.xpath("(//span[@class='primary-title'])[2]");
    By hotDealsDropMenu = By.xpath("//ul[@class='nav navbar-nav top-main-menu']//li//ul//li//span");

    //method to select elements from top tabs on homepage
    public void topTabs(String topTab) {

        List<WebElement> topTabsList = driver.findElements(menuList);

        for (WebElement element : topTabsList) {
            Reporter.log("Getting text "+ element.getText()+"From element"+element.toString()+"compare with"+topTab+"<br>");
            if (element.getText().equalsIgnoreCase(topTab)) {
                element.click();
                break;
            }
        }
    }

    //mouse hover on hot deals tab on homepage
    public void mouseHoverOnHotDeals() {

        Reporter.log("Mouse hover on hot deals tab"+hotDeals.toString()+"<br>");
        mouseHoverToElement(hotDeals);
    }

    //method to select sales or bestseller option from hot deals drop-down on homepage
    public void clickOnSalesOrBestSellers(String menu) throws InterruptedException {

        List<WebElement> hotDeal = driver.findElements(hotDealsDropMenu);
        for (WebElement list : hotDeal) {
            Reporter.log("Getting text "+ list.getText()+"From element"+list.toString()+"compare with"+menu+"<br>");
            if (list.getText().equalsIgnoreCase(menu)) {
                mouseHoverAndClickToElement(list);
                break;
            }
        }
    }
}