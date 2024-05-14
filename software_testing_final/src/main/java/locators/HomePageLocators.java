package locators;

import org.openqa.selenium.By;

public class HomePageLocators {
    public static final By darkLightModeButton = By.cssSelector("body > app-root > app-main > app-main > app-theme-modal > app-modal > div > div.P-modal-container > div > div.G-flex.G-align-center.P-buttons-block.G-justify-end > button");

    public static final By pushNotificationButton = By.cssSelector("body > app-root > app-main > app-header > app-modal > div > div.P-modal-container > div > div > div.P-notification-texts > button");
    public static final By searchFieldXPath = By.xpath("//header/div[1]/div[3]/app-search[1]/section[1]/div[1]/div[1]");
    public static final By emptySearchResult = By.xpath("//header/div[1]/div[4]/app-search[1]/section[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]");
    public static final By searchLoading = By.xpath("//header/div[1]/div[4]/app-search[1]/section[1]/div[2]/div[1]/div[2]/div[1]/div[2]/app-loader[1]/span[1]");

    public static final By searchPageLink = By.xpath("//header/div[1]/div[4]/app-search[1]/section[1]/div[2]/div[1]/div[1]/a[1]");
    public static final By careersButton = By.xpath("//a[contains(text(),'Աշխատանք')]");
    public static final By contactUsButton = By.xpath("//a[contains(text(),'Կապվեք մեզ հետ')]");


}