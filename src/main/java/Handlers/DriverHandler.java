package Handlers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHandler {
    static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://centr.com/join-us");
    }

    public static void setDriver(WebDriver driver) {
        DriverHandler.driver = driver;
    }
    public static void quitDriver(){
        driver.quit();
    }
}

