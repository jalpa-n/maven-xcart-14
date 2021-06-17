package com.xcart.mobile.testsuite.shopping;

import com.xcart.mobile.pages.*;
import com.xcart.mobile.retryAnalyzer.RetryAnalyzer;
import com.xcart.mobile.testbase.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ShoppingTest extends TestBase {
    SoftAssert softAssert = new SoftAssert();
    HomePage homepage = new HomePage();
    SalePage sale = new SalePage();
    YourShoppingCart yourShoppingCart = new YourShoppingCart();
    LoginAccountPage logInAccount = new LoginAccountPage();
    TargetCheckoutPage targetCheckout = new TargetCheckoutPage();
    BestSellersPage bestSellers = new BestSellersPage();


    @Test(groups = {"smoke", "sanity", "regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyThatUserShouldPlaceOrderSuccessfullyForAvengersFabricationsPlush() throws InterruptedException {

        homepage.mouseHoverOnHotDeals();
        homepage.clickOnSalesOrBestSellers("Sale");
        Thread.sleep(2000);
        String expectedSaleText = "Sale";
        softAssert.assertEquals(expectedSaleText, sale.actualSaleText());

        Thread.sleep(2000);
        sale.selectSortByFilter("Name A - Z");
        Thread.sleep(2000);

        sale.addProductToCart();
        Thread.sleep(2000);
        String expectedAddToCartMessage = "Product has been added to your cart";
        softAssert.assertEquals(expectedAddToCartMessage, sale.actualAddToCartDisplayedMessage());
        sale.closeAddToCartMessage();
        Thread.sleep(2000);
        sale.clickOnYourCartAndViewCart();

        Thread.sleep(2000);
        String expectedYourShoppingCartText1 = "Your shopping cart - 1 item";
        softAssert.assertEquals(expectedYourShoppingCartText1, yourShoppingCart.actualYourShoppingCartText());

        Thread.sleep(2000);
        yourShoppingCart.clearExistingProductQuantity();
        //Thread.sleep(3000);
        yourShoppingCart.updateProductQuantity("2");

        Thread.sleep(5000);
        String expectedYourShoppingCartText2 = "Your shopping cart - 2 items";
        softAssert.assertEquals(expectedYourShoppingCartText2, yourShoppingCart.actualYourShoppingCartText());

        Thread.sleep(2000);
        String expectedSubTotal = "$29.98";
        softAssert.assertEquals(expectedSaleText, yourShoppingCart.actualSubTotal());

        Thread.sleep(2000);
        String expectedTotal = "$36.00";
        softAssert.assertEquals(expectedTotal, yourShoppingCart.actualTotal());
        yourShoppingCart.clickOnCheckOutButton();

        Thread.sleep(2000);
        String expectedLogInToYourAccountText = "Log in to your account";
        softAssert.assertEquals(expectedLogInToYourAccountText, logInAccount.actualLogInToYourAccountText());

        Thread.sleep(2000);
        logInAccount.enterEmailId("jalpa.2306", "@gmail.com");
        logInAccount.clickOnContinueButton();

        Thread.sleep(2000);
        String expectedSecureCheckoutText = "Secure Checkout";
        softAssert.assertEquals(expectedSecureCheckoutText, targetCheckout.actualSecureCheckoutText());

        Thread.sleep(2000);
        targetCheckout.enterFirstName("Jalpa");
        targetCheckout.enterLastName("Ganatra");
        targetCheckout.enterAddress("42 conyger close");
        Thread.sleep(2000);
        targetCheckout.enterCity("corby");
        Thread.sleep(2000);
        targetCheckout.selectCountryFromDropDownMenu("United Kingdom");
        targetCheckout.enterState("NorthHamption");
        Thread.sleep(2000);
        targetCheckout.enterZipCode("NN18 8FW");
        Thread.sleep(3000);
        targetCheckout.clickOnCreateAnAccountCheckBox();
        targetCheckout.enterPassword("J1234567");
        Thread.sleep(2000);
        targetCheckout.clickLocalShippingRadioButton();
        Thread.sleep(2000);
        targetCheckout.clickCODRadioButton();

        Thread.sleep(2000);
        String expectedTotalPrice = "$37.03";
        softAssert.assertEquals(expectedTotalPrice, targetCheckout.actualTotalPrice());

        Thread.sleep(2000);
        targetCheckout.clickOnPlaceOrderButton();

        String expectedThankYouForYourOrderText = "Thank you";
        softAssert.assertEquals(expectedThankYouForYourOrderText, targetCheckout.actualThankYouForYourOrderText());

    }

    @Test(groups = {"sanity", "regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {

        homepage.mouseHoverOnHotDeals();
        homepage.clickOnSalesOrBestSellers("Bestsellers");
        Thread.sleep(2000);
        String expectedBestSellerText = "Bestsellers";
        softAssert.assertEquals(expectedBestSellerText, bestSellers.actualBestSellerText());

        bestSellers.selectSortByFilter("Name A - Z");
        Thread.sleep(2000);

        bestSellers.addVinylIdolsToCart();
        Thread.sleep(2000);
        String expectedAddToCartMessage = "Product has been added to your cart";
        softAssert.assertEquals(expectedAddToCartMessage, bestSellers.actualAddToCartDisplayedMessage());
        bestSellers.closeAddToCartMessage();
        Thread.sleep(2000);
        bestSellers.clickOnYourCartAndViewCart();

        Thread.sleep(2000);
        String expectedYourShoppingCartText1 = "Your shopping cart - 1 item";
        softAssert.assertEquals(expectedYourShoppingCartText1, yourShoppingCart.actualYourShoppingCartText());

        Thread.sleep(2000);
        yourShoppingCart.clickOnEmptyYourCart();
        String expectedAlertMessage = "Are you sure you want to clear your cart?";
        String actualAlertMessage = yourShoppingCart.alertMessage();
        softAssert.assertEquals(expectedAlertMessage, actualAlertMessage);

        Thread.sleep(2000);
        yourShoppingCart.clickOnAlertMessage();

        String expectedGreenBarMessage = "Item(s) deleted from your cart";
        softAssert.assertEquals(expectedGreenBarMessage, targetCheckout.actualGreenBarMessage());
        targetCheckout.clickCloseOnGreenBarMessage();

        Thread.sleep(2000);
        String expectedYourCartIsEmptyMessage = "Your cart is empty";
        softAssert.assertEquals(expectedYourCartIsEmptyMessage, targetCheckout.actualYourCartIsEmptyMessage());

    }
}