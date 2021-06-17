package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class ContactUs extends Utility {

    By contactUsText = By.xpath("(//span[text()='Contact us'])[2]");

    //method to verify "Contact Us" text
    public String actualContactUsText (){

        Reporter.log("Page navigation on contact us " +contactUsText.toString()+"<br>");
        return waitUntilVisibilityOfElementLocated(contactUsText,50).getText();
    }
}
