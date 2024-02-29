package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){
        if (!isLoginLinkPresent()) {

            clickOnSignOutButton();
        }
    }

    @Test
    public void creatExistedAccountNegativeTest(){
        clickOnLoginLink();
        fillLoginRegisterForm(new User().
                setEmail("ddd@gmail.com").
                setPassword( "Aa1234567$"));
        clickOnRegistrationButton();
        Assert.assertTrue(isAlertAppears());

    }

}
