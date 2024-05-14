package locators;

import org.openqa.selenium.By;

public class CareerPageLocators {
    public static final By nameInput = By.xpath("//input[@id='companyName']");
    public static final By lastnameInput = By.xpath("//input[@id='contactPerson']");
    public static final By phoneInput = By.xpath("//input[@id='phoneNumber']");
    public static final By emailInput = By.xpath("//input[@id='email']");
    public static final By messageInput = By.xpath("//input[@id='message']");
    public static final By applyButton = By.xpath("//button[contains(text(),'Դիմել')]");
}
