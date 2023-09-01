package org.ait.phonebook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

   @AfterMethod()
    public void tierDown() {
        driver.quit();
    }

    public boolean isHomeComponentPresent() {
        return driver.findElements(By.xpath("//h1[(text()='Home Component')]")).size() > 0;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public boolean isElementPresent2(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public boolean isAllertPresent(){
        Alert alert  = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.alertIsPresent());
        if (alert==null){
            return false;
        }else {
            driver.switchTo().alert();
            alert.accept();
            return true;
        }
}

    public void clickOnLoginLink() {
        click(By.cssSelector("a:nth-child(4)"));
    }

    public void clickOnSignoutButton() {
        click(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[(text()='LOGIN')]"));
    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//button[(text()='Registration')]"));
    }

    public void fillingLoginRegistrationForm(String email, String pass) {
        type(By.cssSelector("[placeholder='Email']"), email);

        type(By.cssSelector("[placeholder='Password']"), pass);
    }
}
