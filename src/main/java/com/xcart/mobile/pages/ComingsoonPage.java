package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class ComingsoonPage extends Utility {


    By comingSoonText = By.xpath("(//span[text()='Coming soon'])[2]");

    //method to verify "Coming Soon" text
    public String actualComingSoonText (){

        Reporter.log("Page navigation on coming soon " +comingSoonText.toString()+"<br>");
        return waitUntilVisibilityOfElementLocated(comingSoonText,50).getText();
    }
}
