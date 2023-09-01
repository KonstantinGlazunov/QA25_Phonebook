package org.ait.demowebshop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductsInCartTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.linkText("Log in"))) {
            click(By.linkText("Log out"));
        }
        login();
        clearCart();
        toHomePage();
    }

    @Test
    public void positiveAddProductBookInCart() {

        click(By.cssSelector(FIRST_PRODUCT_TITLE));
        String productNameOnProductPage = getProductNameOnProductPage();
        fillInputsCaseGiftCard();
        click(By.cssSelector("#add-to-cart-button-2"));
        toShopingCart();
        boolean isProductInCart = isElementPresent(By.xpath("//td[@class='product']/a[text()='" +
                productNameOnProductPage +
                "']"));  // наличие добавленного товара
        clearCart();
        Assert.assertTrue(isProductInCart);

    }

    private String getProductNameOnProductPage() {
        return driver.findElement(By.cssSelector("h1[itemprop]")).getText();
    }


}
