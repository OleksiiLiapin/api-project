package com.softserve.webui.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductListPage {
    WebDriver driver;

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
    }

    By productListPageTitle = By.xpath("//span[@class='title']");



    public WebElement getTitle(){
        return driver.findElement(productListPageTitle);
    }
}
