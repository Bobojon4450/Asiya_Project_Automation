package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Arrays;

public class Login_Verify {


    @Test
    public void VYTrack_ValidCredentials_Login_Verify (){
        String password = "UserUser123";
        String expectedUrl = "https://qa2.vytrack.com/";
        ArrayList<String> userNames = new ArrayList<>(Arrays.asList("user191", "user192", "storemanager228",
                "storemanager229", "storemanager230", "salesmanager291", "salesmanager292", "salesmanager293"));

        for (int i = 0; i < userNames.size(); i++) {
            WebDriver localDriver = BrowserFactory.getDriver("chrome");
            BrowserUtils.maximaze(localDriver);
            localDriver.get("http://qa2.vytrack.com/user/login");BrowserUtils.wait(2);
            WebElement userNameInputBox = localDriver.findElement(By.cssSelector("#prependedInput"));
            WebElement passwordInputBox = localDriver.findElement(By.cssSelector("#prependedInput2"));
            userNameInputBox.sendKeys(userNames.get(i));
            passwordInputBox.sendKeys(password + Keys.ENTER);
            BrowserUtils.wait(2);
            Assert.assertEquals(expectedUrl, localDriver.getCurrentUrl());
            localDriver.quit();
       }
    }

    @Test
    public void VYTrack_InvalidCredential_Login_Verify(){
        ArrayList<String> userNames = new ArrayList<>(Arrays.asList("user191", "QuQuss01", "SpaceMaNageR-11&",
                "sdfsdjfkljdk", "somermanasales11", "MaraudingManag1919", "Stealthmanager32323", "!!234Spave&^%"));
        ArrayList<String>passwords = new ArrayList<>(Arrays.asList("soeo123", "QuQu1212", "UserUser123",
                "userManager0101", "some_sales11!", "Marauding19", "Stealth_", "!!2&^%"));
        for (int i = 0; i < userNames.size(); i++) {
            WebDriver localDriver = BrowserFactory.getDriver("chrome");
            BrowserUtils.maximaze(localDriver);BrowserUtils.wait(1);
            localDriver.get("http://qa2.vytrack.com/user/login");BrowserUtils.wait(1);
            WebElement userNameInputBox = localDriver.findElement(By.cssSelector("#prependedInput"));
            WebElement passwordInputBox = localDriver.findElement(By.cssSelector("#prependedInput2"));
            userNameInputBox.sendKeys(userNames.get(i));
            passwordInputBox.sendKeys(passwords.get(i) + Keys.ENTER);
            WebElement tc2_errorMessage = localDriver.findElement(By.cssSelector(".alert.alert-error > div:first-child"));
            System.out.println(tc2_errorMessage.getText());
            Assert.assertTrue(tc2_errorMessage.isDisplayed());
            localDriver.quit();
        }

    }


}

       /*System.out.println(userNameText.getText());
         BrowserUtils.wait(1);
         Assert.assertTrue(userNameText.isDisplayed());
         WebElement userNameText = driver.findElement(By.cssSelector("ul.nav.pull-right.user-menu > li#user-menu > a:first-child"));
         //ul.nav.pull-right.user-menu > li#user-menu > a:first-child
         String expectedUser = "Marco Cartwright";
         /*String userName = "user191";*/
         /*String password = "UserUser123";*/

