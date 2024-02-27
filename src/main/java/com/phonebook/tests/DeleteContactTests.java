package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests  extends TestBase{
    @BeforeMethod
    public void precondition(){

        if (!isElementPresent(By.cssSelector("[href='/login']"))) {
            //click on Sign Out button
            click(By.xpath("//button[.='Sign Out']"));
        }

        click(By.cssSelector("[href='/login']"));
        //enter email
        type(By.name("email"), "ddd@gmail.com");
        //enter password
        type(By.name("password"), "Aa1234567$");

        click(By.name("login"));
        click(By.cssSelector("[href='/add']"));
        type(By.cssSelector("input:nth-child(1)"),"Adam");
        type(By.cssSelector("input:nth-child(2)"),"Karl");
        type(By.cssSelector("input:nth-child(3)"),"1234567890");
        type(By.cssSelector("input:nth-child(4)"),"adam@gm.com");
        type(By.cssSelector("input:nth-child(5)"),"Berlin");
        type(By.cssSelector("input:nth-child(6)"),"goalkeeper");
        click(By.cssSelector(".add_form__2rsm2 button"));
    }
    @Test
    public void removeContactTest(){
        int sizeBefore=sizeOfContacts();
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
        pause(1000);
        int sizeAfter=sizeOfContacts();

        Assert.assertEquals(sizeAfter,sizeBefore-1);

    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public int sizeOfContacts() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }
}
