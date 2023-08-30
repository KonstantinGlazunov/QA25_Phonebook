package org.ait.demowebshop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WelcomeOnHomePageTest extends TestBase{

@Test
    public void isWelcomeComponentPresent(){
    Assert.assertTrue(isElementPresent(By.xpath("//h2[contains(text(),'Welcome to our store')]")));
}
}
