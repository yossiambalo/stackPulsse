package com.stackpulse;

import com.stackpulse.selenium.DriverManager;
import com.stackpulse.selenium.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestBase {

    public WebDriver driver;

    @Parameters({"browser", "url"})

    @BeforeTest
    public void init(String browser, String url) {
        switch (browser) {
            case "chrome":
                driver = DriverManager.getWebDriver(DriverType.CHROME);
                break;
            case "edge":
                driver = DriverManager.getWebDriver(DriverType.EDGE);
                break;
            case "firefox":
                driver = DriverManager.getWebDriver(DriverType.FIREFOX);
                break;
            case "ie":
                driver = DriverManager.getWebDriver(DriverType.IE);
                break;
            default:
        }
        driver.get(url);
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
