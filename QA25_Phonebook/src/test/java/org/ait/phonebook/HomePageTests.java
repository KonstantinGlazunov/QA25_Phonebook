package org.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    public void isHomeComponentPresentTest() {
       // driver.findElement(By.xpath("//h1[(text()='Home Component')]"));
       // System.out.println("Home component is  " + isHElementPresent(By.xpath("//h1[(text()='Home Component')]")));
        //System.out.println("Home component is  " + isElementPresent2(By.xpath("//h1[(text()='Home Component')]")));

        Assert.assertTrue(isElementPresent2(By.xpath("//h1[(text()='Home Component')]")));
    }

}
