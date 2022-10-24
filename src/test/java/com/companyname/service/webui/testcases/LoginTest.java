package com.softserve.service.webui.testcases;

import com.softserve.webui.SettingsSetup.BasePage;
import com.softserve.webui.pageobject.LoginPage;
import com.softserve.webui.testdata.LoginPageData;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class LoginTest {


    @Test (description = "TC-01. Verify that user can successfully log in")
    public static void TestSuccessLoginPage(){
        Logger LOGGER = LogManager.getLogger(LoginTest.class);
        LoginPage loginPage = new LoginPage();
        loginPage.login("pass", "pass");



//        Assertions.assertThat().endsWith("inventory.html");

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
