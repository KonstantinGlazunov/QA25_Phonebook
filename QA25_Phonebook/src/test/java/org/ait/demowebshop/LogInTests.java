package org.ait.demowebshop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.linkText("Log in"))) {
            click(By.linkText("Log out"));
        }
        click(By.linkText("Log in"));
    }

@Test
    public void positiveLoginTest(){
    type("#Email", "qq123@qq.qq");
    type("#Password", "Pass@1234");
    click(By.cssSelector("input[value = 'Log in']"));
    Assert.assertTrue(isElementPresent(By.linkText("Log out")));
}
////span[text()='Login was unsuccessful. Please correct the errors and try again.']
@Test
public void negativeLoginTest(){
    type("#Email", "qq123@qq.qqqqqqqqqqqqqqqqqqqq");
    type("#Password", "Pass@1234");
    click(By.cssSelector("input[value = 'Log in']"));
    Assert.assertTrue(isElementPresent(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']")));
}


}
