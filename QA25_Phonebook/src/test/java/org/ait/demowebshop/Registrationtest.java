package org.ait.demowebshop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registrationtest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.linkText("Log in"))) {
            driver.findElement(By.linkText("Log out")).click();
        }
        driver.findElement(By.linkText("Register")).click();
    }

    @AfterMethod(enabled = false)
    public void tierDown() {
        super.tierDown();
    }

    @Test
    public void registrationExistUserTest() {
        driver.findElement(By.cssSelector("#FirstName")).click();
        driver.findElement(By.cssSelector("#FirstName")).clear();
        driver.findElement(By.cssSelector("#FirstName")).sendKeys("Ivan");

        driver.findElement(By.cssSelector("#LastName")).click();
        driver.findElement(By.cssSelector("#LastName")).clear();
        driver.findElement(By.cssSelector("#LastName")).sendKeys("Ivanov");

        driver.findElement(By.cssSelector("#Email")).click();
        driver.findElement(By.cssSelector("#Email")).clear();
        driver.findElement(By.cssSelector("#Email")).sendKeys("qq123@qq.qq");

        driver.findElement(By.cssSelector("#Password")).click();
        driver.findElement(By.cssSelector("#Password")).clear();
        driver.findElement(By.cssSelector("#Password")).sendKeys("Pass@1234");

        driver.findElement(By.cssSelector("#ConfirmPassword")).click();
        driver.findElement(By.cssSelector("#ConfirmPassword")).clear();
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("Pass@1234");

        driver.findElement(By.cssSelector("#register-button")).click();

        Assert.assertTrue(isElementPresent(By.xpath("//li[contains(text(),'The specified email already exists')]")));

    }
}
