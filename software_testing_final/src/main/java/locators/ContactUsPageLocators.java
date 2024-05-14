package locators;

import org.openqa.selenium.By;

public class ContactUsPageLocators {
    public static final By fullNameInput = By.xpath("//input[@id='name']");
    public static final By emailInput = By.xpath("//input[@id='email']");
    public static final By phoneInput = By.xpath("//input[@id='phoneNumber']");
    public static final By messageInput = By.xpath("//textarea[@id='message']");
    public static final By submitButton = By.xpath("//button[contains(text(),'Ուղարկել')]");

}
