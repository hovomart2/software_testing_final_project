package pages;

import locators.CareerPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CareerPage {
    private final WebDriver driver;
    WebDriverWait wait;
    private By nameInput = CareerPageLocators.nameInput;
    private By lastnameInput = CareerPageLocators.lastnameInput;
    private By phoneInput = CareerPageLocators.phoneInput;
    private By emailInput = CareerPageLocators.emailInput;
    private By messageInput = CareerPageLocators.emailInput;

    public CareerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void writeName(String text){
        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(this.nameInput));
        nameInput.clear();
        nameInput.sendKeys(text);

    }

    public void writeLastname(String text){
        WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(this.lastnameInput));
        lastNameInput.clear();
        lastNameInput.sendKeys(text);

    }

    public void writePhone(String text){
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(this.phoneInput));
        phoneInput.clear();
        phoneInput.sendKeys(text);

    }

    public void writeEmail(String text){
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(this.emailInput));
        emailInput.clear();
        emailInput.sendKeys(text);

    }

    public void writeMessage(String text){
        WebElement messageInput = wait.until(ExpectedConditions.visibilityOfElementLocated(this.messageInput));
        messageInput.clear();
        messageInput.sendKeys(text);
    }

    public void clickApply(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(CareerPageLocators.applyButton)).click();
    }

    public boolean isHappyPath(){
        WebElement emailInput = driver.findElement(this.emailInput);
        WebElement nameInput = driver.findElement(this.nameInput);
        WebElement lastNameInput = driver.findElement(this.lastnameInput);
        WebElement phoneInput = driver.findElement(this.phoneInput);
        WebElement messageInput = driver.findElement(this.messageInput);
        List<WebElement> webElements = List.of(emailInput, nameInput, lastNameInput, phoneInput, messageInput);
        for (WebElement webElement : webElements) {
            if(webElement.getCssValue("border-color").equals("rgb(223, 0, 38)")){
                return false;
            }
        }
        return true;
    }
}
