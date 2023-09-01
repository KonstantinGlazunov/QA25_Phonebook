package org.ait.demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;
    String FIRST_PRODUCT_SELECTOR = ".product-item:first-of-type img[src]:first-of-type";
    public static final String ADD_TO_CART_BUTTON_SELECTOR = "#add-to-cart-button-2";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(/*enabled = false*/)
    public void tierDown() {
        driver.quit();
    }


    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();



    }
    public void type(String hashtag, String text) {
        driver.findElement(By.cssSelector(hashtag)).click();
        driver.findElement(By.cssSelector(hashtag)).clear();
        driver.findElement(By.cssSelector(hashtag)).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }


    public void toShopingCart() {
        click(By.xpath("//span[contains(text(),'Shopping cart')]"));
    }

    public void fillInputsCaseGiftCard() {
        WebElement recipientNameField = driver.findElement(By.cssSelector("#giftcard_2_RecipientName")); //проверяем поля giftcard
        if (recipientNameField != null) {
            type("#giftcard_2_RecipientName", "Recipient Name");
            type("#giftcard_2_RecipientEmail", "recepient@email.qq");
        }
    }

    public void toHomePage() {
        click(By.cssSelector("img[title]:first-of-type"));
    }

    public void clearCart() {
        toShopingCart(); //кликаем на корзину
        while (isElementPresent(By.xpath("//tbody/tr[1]/td[1]/input[1]"))) { //пока на странице нет надписи
            //.remove-from-cart

            click(By.xpath("//tbody/tr[1]/td[1]/input[1]"));
            //input[type='checkbox'][name='removefromcart']:first-of-type
            click(By.cssSelector("input[value='Update shopping cart']"));
        }
    }

    public void login() {
        click(By.linkText("Log in"));
        type("#Email", "qq123@qq.qq");
        type("#Password", "Pass@1234");
        click(By.cssSelector("input[value = 'Log in']"));
    }
}



