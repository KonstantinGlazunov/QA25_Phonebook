package org.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.xpath("//a[(text()='LOGIN')]"))){
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        }
driver.findElement(By.cssSelector("a:nth-child(4)")).click();
    }

      /* if (!isElemenetPresent(By.xpath("//a[(text()='LOGIN')]"))){
        driver.findElement(By.xpath("//button[contains(.,'Sign Out')]"));
    }*/

    // precondition: user should be logged out
    //click on login link  //  //xpath //a[(text()='LOGIN')]
   // enter email   //css [placeholder='Email']
     //       enter password   //css [placeholder='Password']
       // click registration button  //xpath //button[(text()='Registration')]
    // assert sing out button displayed  //xpath //button[(text()='Login')]
//  //button[contains(.,'Sign Out')]


    @AfterMethod(enabled=false)
    public void tierDown(){
        super.tierDown();
    }

    /*
    @Test
            public void newUserRegistrationPositiveTest(){

    driver.findElement(By.cssSelector("[placeholder='Email']")).click();
    driver.findElement(By.cssSelector("[placeholder='Email']")).clear();
    driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("qq@qq.qq");

        driver.findElement(By.cssSelector("[placeholder='Password']")).click();
        driver.findElement(By.cssSelector("[placeholder='Password']")).clear();
    driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Pass@1234");
driver.findElement(By.xpath("//button[(text()='Registration')]")).click();
        Assert.assertTrue(isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]")));

    }

     */

}
