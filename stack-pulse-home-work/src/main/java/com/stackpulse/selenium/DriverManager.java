package com.stackpulse.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static WebDriver getWebDriver(DriverType driverType){
        String driverDir = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "driver" + File.separator;
        WebDriver driver = null;
        switch (driverType){
            case CHROME:
                System.setProperty("webdriver.chrome.driver", driverDir+"chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case EDGE:
                System.setProperty("webdriver.edge.driver",driverDir+"MicrosoftWebDriver.exe");
                driver =  new EdgeDriver();
                break;
            case IE:
                System.setProperty("webdriver.ie.driver",driverDir+"IEDriverServer.exe");
                driver =  new InternetExplorerDriver();
                driver.manage().deleteAllCookies();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver",driverDir+"geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                return null;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
