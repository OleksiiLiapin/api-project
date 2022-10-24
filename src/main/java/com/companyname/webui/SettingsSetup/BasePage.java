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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage {
    private static final Logger LOGGER = LogManager.getLogger(BrowserSetup.class);
    protected WebDriver driver;
    protected WebDriverWait wait;
    private final String browser = MavenProperties.singleMavenPropertiesInstance().getBrowserConfig();
    private final String URL = ProvideServiceConfig.getService("webui");
    private static final Duration DEFAULT_TIMEOUT_SECONDS = Duration.ofSeconds(10);


    public BasePage() {
        driver = getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        driver.get(URL);
        System.out.println("Constructor from Base Page");
    }

    public String getURL() {
        return URL;
    }

    public WebDriver getDriver() {
        return webDriverManager();
    }


    private WebDriver webDriverManager(){
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



