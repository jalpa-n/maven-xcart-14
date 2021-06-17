package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class NewArrivals extends Utility {


    By newArrivalsText = By.xpath("//h1[@id='page-title']");

    public String actualNewArrivalText() {

        Reporter.log("Getting text from element" + newArrivalsText.toString() + "<br>");
        return waitUntilVisibilityOfElementLocated(newArrivalsText, 50).getText();
    }

}