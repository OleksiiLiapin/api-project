package com.softserve.service.webui.testcases;

import com.softserve.webui.SettingsSetup.BasePage;
import com.softserve.webui.SettingsSetup.BrowserSetup;
import com.softserve.webui.pageobject.LoginPage;
import com.softserve.webui.testdata.LoginPageData;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {


    @Test (description = "TC-01. Verify that user can successfully log in")
    public static void TestSuccessLoginPage(){
        Logger LOGGER = LogManager.getLogger(LoginTest.class);
        LoginPage.login_End_to_End(LoginPageData.standardUser_UserName, LoginPageData.password);




//        Assertions.assertThat().endsWith("inventory.html");
       LOGGER.info("User logged in");
    }

//    @Test (description = "TC-02. Verify that user cannot login with wrong password")
//    public static void TestErrorLogin (){
//        Logger LOGGER = LogManager.getLogger(BrowserSetup.class);
//
//        LoginPage loginPage = new LoginPage();
//
//        Login.login_End_to_End(loginPage,
//                LoginPageData.standardUser_UserName,
//                LoginPageData.wrongPassword);
//        LOGGER.info(loginPage.getERROR_LOGIN_TEXT() + " - error text appeared");
//        Assertions.assertThat(loginPage.getERROR_LOGIN_TEXT())
//                .isEqualTo("Epic sadface: Username and password do not match any user in this service");
//    }



}
