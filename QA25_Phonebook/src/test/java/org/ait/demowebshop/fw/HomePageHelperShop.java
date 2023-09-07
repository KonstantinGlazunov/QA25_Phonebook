package org.ait.demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelperShop extends HelperBaseShop{
    public HomePageHelperShop(WebDriver driver) {
        super(driver);
    }

    public void toHomePage() {
        click(By.cssSelector("img[title]:first-of-type"));
    }
}
