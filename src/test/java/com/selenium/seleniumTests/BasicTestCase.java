package com.selenium.seleniumTests;

import com.csg.utils.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;

public class BasicTestCase {
    protected static WebDriver driver;

    protected static WebDriver getWebDriver() {
        if (driver == null){
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigProperties.getProperty("imp.wait")), TimeUnit.SECONDS);
        }
        return driver;
    }

    @BeforeSuite
    public static void setUp() {
        getWebDriver().manage().window().maximize();
    }

    @AfterSuite
    public static void tearDown() throws Exception {
        driver.quit();
        driver = null;
    }
}
