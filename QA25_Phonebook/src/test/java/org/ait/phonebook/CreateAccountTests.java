package org.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
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
    public void existedUserRegistrationNegativeTest() {

        fillingLoginRegistrationForm("qq@qq.qq", "Pass@1234");
        clickOnRegistrationButton();
        Assert.assertTrue(isAllertPresent());
    }

}
