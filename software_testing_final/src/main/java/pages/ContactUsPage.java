package pages;

import locators.CareerPageLocators;
import locators.ContactUsPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ContactUsPage {
    private final WebDriver driver;
    WebDriverWait wait;
    private By fullNameInput = ContactUsPageLocators.fullNameInput;
    private By emailInput = ContactUsPageLocators.emailInput;
    private By phoneInput = ContactUsPageLocators.phoneInput;
    private By messageInput = ContactUsPageLocators.messageInput;
    private By submitButton = ContactUsPageLocators.submitButton;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void writeFullName(String text){
        WebElement fullNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(this.fullNameInput));
        fullNameInput.clear();
        fullNameInput.sendKeys(text);
    }

    public void writeEmail(String text){
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(this.emailInput));
        emailInput.clear();
        emailInput.sendKeys(text);
    }

    public void writePhone(String text){
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(this.phoneInput));
        phoneInput.clear();
        phoneInput.sendKeys(text);
    }

    public void writeMessage(String text){
        WebElement messageInput = wait.until(ExpectedConditions.visibilityOfElementLocated(this.messageInput));
        messageInput.clear();
        messageInput.sendKeys(text);
    }

    public void submit(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.submitButton)).click();
    }

    public boolean isHappyPath(){
        WebElement emailInput = driver.findElement(this.emailInput);
        WebElement fullNameInput = driver.findElement(this.fullNameInput);
        WebElement phoneInput = driver.findElement(this.phoneInput);
        WebElement messageInput = driver.findElement(this.messageInput);
        List<WebElement> webElements = List.of(emailInput, fullNameInput, phoneInput, messageInput);
        for (WebElement webElement : webElements) {
            if(webElement.getCssValue("border-color").equals("rgb(223, 0, 38)")){
                return false;
            }
        }
        return true;
    }
}
