package org.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignoutButton();
        }
        clickOnLoginLink();
    }
    @AfterMethod()
    public void tierDown() {
        super.tierDown();
    }

    @Test
    public void loginPositiveTest(){
        fillingLoginRegistrationForm("qq@qq.qq", "Pass@1234");
        click(By.xpath("//button[.='Login']"));
        Assert.assertTrue(isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]")));

    }




}
