package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        //if login link is not present
        if (!isElementPresent(By.cssSelector("[href='/login']"))) {
            //click on Sign Out button
            click(By.xpath("//button[.='Sign Out']"));
        }
    }
    //click link login
    @Test
    public void loginPositiveTest(){
        click(By.cssSelector("[href='/login']"));
        //enter email
        type(By.name("email"), "ddd@gmail.com");
        //enter password
        type(By.name("password"), "Aa1234567$");

        click(By.name("login"));
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }
    //enter email
    //enter password
    //click on the
}
