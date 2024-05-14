//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import pages.HomePage;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//public class BaseTest {
//
//    private WebDriver driver;
//    protected HomePage homePage;
//
//
//    @BeforeClass
//    public void setUp() {
//
//
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
////
////        ChromeOptions options = new ChromeOptions();
////        options.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        homePage = new HomePage(driver);
//
//    }

import locators.HomePageLocators;
import org.checkerframework.checker.guieffect.qual.AlwaysSafe;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    private WebDriverWait wait;

    @BeforeClass
    public void SetUp() {
        // Initialize the WebDriver
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.yerevan-city.am");
        homePage = new HomePage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.darkLightModeButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.pushNotificationButton)).click();
    }

    @AfterClass
    public void finish(){
        driver.close();
    }

    public static String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        return now.format(formatter);
    }

    @AfterMethod
    public void reload(){
        driver.navigate().refresh();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            String fileName = result.getName() + "_" + getCurrentDateTime() + ".png";
            Path destination = Paths.get("screenshots", fileName);
            try {
                Files.createDirectories(destination.getParent());
                Files.move(screenshot.toPath(), destination);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Failed to move screenshot file: " + e.getMessage());
            }
        }
    }

}

