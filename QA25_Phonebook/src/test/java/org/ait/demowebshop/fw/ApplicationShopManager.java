package org.ait.demowebshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationShopManager  {
    WebDriver driver;

    UserHelperShop user;
    CartHelper cart;

    HomePageHelperShop homePage;


    public void init() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user = new UserHelperShop(driver);
        cart = new CartHelper(driver);
        homePage = new HomePageHelperShop(driver);
    }

    public void stop() {
        driver.quit();
    }

    public UserHelperShop getUser() {
        return user;
    }

    public CartHelper getCart() {
        return cart;
    }

    public HomePageHelperShop getHomePage() {
        return homePage;
    }
}
