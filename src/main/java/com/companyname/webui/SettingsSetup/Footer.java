package com.softserve.webui.SettingsSetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Footer {

    WebDriver driver;

    By footerCopyRights = By.xpath("//div[@class='footer_copy']");
    By footerImg = By.xpath("//img[@class='footer_robot']");

    void footerIsLoaded (){
        driver.findElement(footerCopyRights);
    }


}

