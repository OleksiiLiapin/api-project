package com.softserve.webui.pageobject;

import com.softserve.webui.SettingsSetup.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);
    private LoginPage loginPage = null;
    //protected WebDriver driver;

    public LoginPage() {
        super();
        driver.get(getURL());
    }


    By errorLogin = By.xpath("//div[@id='login_button_container']//form//h3");
    By userName = By.xpath("//input[@id='user-name']");
    By password = By.xpath("//input[@id='password']");
    By loginBtn = By.xpath("//input[@id='login-button']");


    public WebElement getUserName() {
        return driver.findElement(userName);
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }

    public WebElement getLoginBtn (){
        return driver.findElement(loginBtn);
    }

    public String getERROR_LOGIN_TEXT() {
        return driver.findElement(errorLogin).getText();
    }


    public void login(String userName, String passwords){
        loginPage.getUserName().sendKeys(userName);
        LOGGER.info("user name entered");
        loginPage.getPassword().sendKeys(passwords);
        LOGGER.info("password entered");
        loginPage.getLoginBtn().click();
        LOGGER.info("login button clicked");
    }

}
