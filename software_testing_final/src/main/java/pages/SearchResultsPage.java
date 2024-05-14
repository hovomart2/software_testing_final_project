package pages;

import locators.SearchResultsPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage {
    private final WebDriver driver;
    WebDriverWait wait;
    private By sortDropdown = SearchResultsPageLocators.sortDropdown;
    private By priceLowestToHighest = SearchResultsPageLocators.priceLowestToHighest;
    private By priceHighestToLowest = SearchResultsPageLocators.priceHighestToLowest;
    private List<WebElement> productItems;
    private By itemsDiv = SearchResultsPageLocators.itemsDiv;
    private By appProductItems = SearchResultsPageLocators.appProductItems;
    private By span = SearchResultsPageLocators.span;
    private String keyword;
    private By p = SearchResultsPageLocators.p;
    private By priceFromInput = SearchResultsPageLocators.priceFromInput;
    private By priceUpToInput = SearchResultsPageLocators.priceUpToInput;
    private By saleCheckBox = SearchResultsPageLocators.saleCheckbox;
    public SearchResultsPage(WebDriver driver, String keyword) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.keyword = keyword;
    }

    public void clickOnDropdown(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.sortDropdown)).click();
    }

    public void clickOnPriceLowestToHighest(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.priceLowestToHighest)).click();
    }

    public void clickOnPriceHighestToLowest(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.priceHighestToLowest)).click();
    }

    public void setProductItems(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement itemsDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(this.itemsDiv));
        this.productItems = itemsDiv.findElements(this.appProductItems);
    }

    public List<String> getItemNames(){
        List<String> names = new ArrayList<>();
        for (WebElement webElement : productItems){
            WebElement span = webElement.findElement(this.p);
            names.add(span.getText());
        }
        return names;
    }

    public List<Integer> getItemsPrices(){
        List<Integer> prices = new ArrayList<>();
        for(WebElement webElement : productItems){
            List<WebElement> spans = webElement.findElements(this.span);
            String price = spans.get(2).getText();
            price = price.substring(0, price.length() - 2);
            price = price.replaceAll(",", "");
            prices.add(Integer.parseInt(price));
        }
        return prices;
    }

    public boolean checkLowestToHighest(List<Integer> prices){
        for (int i = 0; i < prices.size() - 1; i++) {
            if(prices.get(i) > prices.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public boolean checkHighestToLowest(List<Integer> prices){
        for (int i = 0; i < prices.size() - 1; i++) {
            if(prices.get(i) < prices.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public boolean isKeywordInAllItemNames(){
        for (String itemName : getItemNames()){
            if(!itemName.contains(keyword)){
                return false;
            }
        }
        return true;
    }

    public void writePriceFromInput(String from){
        WebElement priceFromInput = wait.until(ExpectedConditions.visibilityOfElementLocated(this.priceFromInput));
        priceFromInput.clear();
        priceFromInput.sendKeys(from);
    }

    public void writePriceUpToInput(String upTo){
        WebElement priceUpToInput = wait.until(ExpectedConditions.visibilityOfElementLocated(this.priceUpToInput));
        priceUpToInput.clear();
        priceUpToInput.sendKeys(upTo);
    }


    public void clickOnSaleCheckbox(){
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(this.saleCheckBox));
        checkbox.click();
    }

    public boolean isInRange(String fromStr, String upToStr){
        int from = Integer.parseInt(fromStr);
        int upTo = Integer.parseInt(upToStr);
        List<Integer> prices = getItemsPrices();
        for (int i = 0; i < prices.size(); i++) {
            if(prices.get(i)<from || prices.get(i)>upTo){
                return false;
            }
        }
        return true;
    }
}
