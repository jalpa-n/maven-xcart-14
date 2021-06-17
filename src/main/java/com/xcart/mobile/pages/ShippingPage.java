package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class ShippingPage extends Utility {


        By shippingText = By.xpath("//h1[@id='page-title']");

        //method to verify "Shipping" text with page navigation
        public String actualShippingText() {

            Reporter.log("Getting Shipping text from element " + shippingText.toString() + "<br>");
            return waitUntilVisibilityOfElementLocated(shippingText, 50).getText();
        }

    }
