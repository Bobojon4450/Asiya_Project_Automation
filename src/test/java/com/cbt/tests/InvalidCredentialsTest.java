package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class InvalidCredentialsTest {

    WebDriver driver = BrowserFactory.getDriver("chrome");


    @Test
    public void VYTrack_Invalid_Credintials_Login_Verify (){
        BrowserUtils.maximaze(driver);
        driver.get("http://qa2.vytrack.com/user/login");


    }

}
