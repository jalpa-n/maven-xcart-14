package com.xcart.mobile.testbase;


import com.xcart.mobile.propertyreader.PropertyReader;
import com.xcart.mobile.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends Utility {
    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(groups = {"smoke","sanity","regression"})
    public void setUp(){

        selectBrowser(browser);
    }

    @AfterMethod(groups = {"smoke","sanity","regression"})
    public void tearDown(){
        closeBrowser();
    }

}
