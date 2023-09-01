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
            click(By.linkText("Log out"));
        }
        click(By.linkText("Register"));
    }

    @AfterMethod()
    public void tierDown() {
        super.tierDown();
    }

    @Test
    public void PositiveRegistrationdUserTest() {
        int i = (int) (System.currentTimeMillis() / 1000 % 3000);
        type("#FirstName", "Ivan");
        type("#LastName", "Ivanov");
        type("#Email", "qq" + i + "@qq.qq");
        type("#Password", "Pass@1234");
        type("#ConfirmPassword", "Pass@1234");
        click(By.cssSelector("#register-button"));

        Assert.assertTrue(isElementPresent(By.xpath("//div[contains(text(),'Your registration completed')]")));
    }

    @Test
    public void registrationExistedUserTest() {
        type("#FirstName", "Ivan");
        type("#LastName", "Ivanov");
        type("#Email", "qq123@qq.qq");
        type("#Password", "Pass@1234");
        type("#ConfirmPassword", "Pass@1234");
        click(By.cssSelector("#register-button"));

        Assert.assertTrue(isElementPresent(By.xpath("//li[contains(text(),'The specified email already exists')]")));

    }


}
