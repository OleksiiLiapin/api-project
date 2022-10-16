package com.softserve.webui.SettingsSetup;

import com.softserve.settings.MavenProperties;
import com.softserve.util.ProvideServiceConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
    private static final Logger LOGGER = LogManager.getLogger(BrowserSetup.class);
    protected static WebDriver driver;
    private final String browser = MavenProperties.singleMavenPropertiesInstance().getBrowserConfig();
    private final String url = ProvideServiceConfig.getService("webui");
    private Header header;
    private Footer footer;


    public BasePage() {
        driver = getDriver();
        driver.get(url);
        System.out.println("Constructor from Base Page");
    }

    public WebDriver getDriver() {
        return webDriverManager();
    }


    public WebDriver webDriverManager(){
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            default -> LOGGER.error("Browser " + browser + " is not correct");
        }

        if (driver!=null){
            driver.manage().window().maximize();
            return driver;
        }
        return null;
    }
}



