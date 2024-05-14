package pages;

import locators.CareersPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CareersPage {
    private final WebDriver driver;
    WebDriverWait wait;
    private By firstCareerButton = CareersPageLocators.firstCareerButton;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public CareerPage clickOnFirstCategory(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstCareerButton)).click();
        return new CareerPage(driver);
    }
}
