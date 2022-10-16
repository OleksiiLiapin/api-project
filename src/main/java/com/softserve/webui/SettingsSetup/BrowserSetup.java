package com.softserve.webui.SettingsSetup;

import com.softserve.settings.MavenProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.util.Properties;

public class BrowserSetup {
    private static final Logger LOGGER = LogManager.getLogger(BrowserSetup.class);
    private WebDriver driver;
    private final String browser = MavenProperties.singleMavenPropertiesInstance().getBrowserConfig();

    public BrowserSetup() {
    }

//    public WebDriver getDriver() {
//        return webDriverManager();
//    }

//    private String fetchBrowserProperty() {
//        Properties prop = new Properties();
//        FileInputStream data = null;
//
//        try {
//            data = new FileInputStream("src/main/resources/maven.properties");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            prop.load(data);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        browser = prop.getProperty("browser");
//        LOGGER.info("Browser config name: " + browser);
//        return browser;
//    }

//    public WebDriver webDriverManager(){
//        switch (browser) {
//            case "chrome" -> {
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//            }
//            case "firefox" -> {
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//            }
//            case "edge" -> {
//                WebDriverManager.edgedriver().setup();
//                driver = new EdgeDriver();
//            }
//            default -> LOGGER.error("Browser " + browser + " is not correct");
//        }
//
//        if (driver!=null){
//            driver.manage().window().maximize();
//            return driver;
//        }
//        return null;
//    }


}
