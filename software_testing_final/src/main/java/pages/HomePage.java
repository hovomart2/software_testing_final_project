package pages;

import locators.HomePageLocators;
import locators.SearchResultsPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.script.ExceptionDetails;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage {
    private final WebDriver driver;
    private WebDriverWait wait;
    private By careersButton = HomePageLocators.careersButton;
    private By contactUsButton = HomePageLocators.contactUsButton;
    private By sortDropdown = SearchResultsPageLocators.sortDropdown;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public CareersPage goToCareersPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(careersButton)).click();
        return new CareersPage(driver);
    }

    public ContactUsPage goToContactUsPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsButton)).click();
        return new ContactUsPage(driver);
    }

    public SearchResultsPage search(String search){
        driver.get("https://www.yerevan-city.am/search/0?search=" + search);
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortDropdown));
        return new SearchResultsPage(driver, search);
    }


//    public Object search(String search){
//        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.searchFieldXPath));
////        searchField.click();
//        searchField.clear();
//        searchField.sendKeys(search);
//        WebElement loading = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.searchLoading));
//        wait.until(ExpectedConditions.invisibilityOf(loading));
//        WebElement searchPageLink = driver.findElement(HomePageLocators.searchPageLink);
//        WebElement emptySearchResult = driver.findElement(HomePageLocators.emptySearchResult);
//        if(searchPageLink.isDisplayed()){
//            searchPageLink.click();
//            System.out.println("barev");
//            return new SearchResultsPage(driver);
//        }
//        else if(emptySearchResult.isDisplayed()){
//            System.out.println("hajox");
//            return "Empty";
//        }else{
//            System.out.println("hajoxxxxx");
//            return "esinchaa";
//        }
//    }

}
