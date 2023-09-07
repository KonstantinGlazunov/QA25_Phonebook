package org.ait.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePAgeHelper extends HelperBase {
    public HomePAgeHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent() {
        return driver.findElements(By.xpath("//h1[(text()='Home Component')]")).size() > 0;
    }
}
