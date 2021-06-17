package com.xcart.mobile.testsuite.homepage;

import com.xcart.mobile.pages.*;
import com.xcart.mobile.retryAnalyzer.RetryAnalyzer;
import com.xcart.mobile.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TopMenuTest extends TestBase {

    SoftAssert softAssert = new SoftAssert();
    HomePage homepage = new HomePage();
    ShippingPage shipping = new ShippingPage();
    NewArrivals newArrivals = new NewArrivals();
    ComingsoonPage comingSoon = new ComingsoonPage();
    ContactUs contactUs = new ContactUs();


    @Test(groups = {"smoke", "regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyUserShouldNavigateToShippingPageSuccessfully() throws InterruptedException {

        homepage.topTabs("Shipping");
        Thread.sleep(1000);
        String expectedShippingText = "Shipping";
        softAssert.assertEquals(expectedShippingText, shipping.actualShippingText());
    }

    @Test(groups = {"smoke", "sanity", "regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyUserShouldNavigateToNewPageSuccessfully() throws InterruptedException {

        homepage.topTabs("New!");
        Thread.sleep(1000);
        String expectedNewArrivalText = "New arrivals";
        softAssert.assertEquals(expectedNewArrivalText, newArrivals.actualNewArrivalText());
    }

    @Test(groups = {"sanity", "regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyUserShouldNavigateToComingSoonPageSuccessfully() throws InterruptedException {

        homepage.topTabs("Coming soon");
        Thread.sleep(1000);
        String expectedComingSoonText = "Coming soon";
        softAssert.assertEquals(expectedComingSoonText, comingSoon.actualComingSoonText());
    }

    @Test(groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyUserShouldNavigateToContactUsPageSuccessfully() throws InterruptedException {

        homepage.topTabs("Contact us");
        Thread.sleep(1000);
        String expectedContactUsText = "Contact ";
        Assert.assertEquals(expectedContactUsText, contactUs.actualContactUsText());
    }

}
