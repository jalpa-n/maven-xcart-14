package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class LoginAccountPage extends Utility {

    By loginInText = By.xpath("//h3[contains(text(),'Log in to your account')]");
    By emailField = By.xpath("//input[@id='email']");
    By continueButton = By.xpath("//tbody/tr[2]/td[1]/button[1]");


    public String actualLogInToYourAccountText (){

        Reporter.log("Getting page verification text"+ loginInText.toString()+"<br>");
        return waitUntilVisibilityOfElementLocated(loginInText,30).getText();
    }
    public void enterEmailId(String userName,String domainName){

        Reporter.log("Enter email "+ userName+randomNumber()+domainName+"in email field"+ emailField.toString()+"<br>");
        sendTextToElement(emailField,userName+randomNumber()+domainName);
    }
    public void clickOnContinueButton(){

        Reporter.log("Click on continue button "+continueButton.toString()+"<br>");
        clickOnElement(continueButton);
    }

}