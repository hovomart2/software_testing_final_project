package locators;

import org.openqa.selenium.By;

public class SearchResultsPageLocators {
    public static final By sortDropdown = By.xpath("//body/app-root[1]/app-main[1]/app-product-page[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/app-dropdown[1]/div[1]/div[1]/div[1]");
    public static final By priceLowestToHighest = By.xpath("//body/app-root[1]/app-main[1]/app-product-page[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/app-dropdown[1]/div[1]/div[2]/div[3]/p[1]");
    public static final By priceHighestToLowest = By.xpath("//body/app-root[1]/app-main[1]/app-product-page[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/app-dropdown[1]/div[1]/div[2]/div[4]/p[1]");
    public static final By itemsDiv = By.xpath("//body/app-root[1]/app-main[1]/app-product-page[1]/div[1]/div[1]/div[3]/div[1]/div[3]");

    public static final By categories = By.xpath("//body/app-root[1]/app-main[1]/app-product-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
    public static final By appProductItems = By.tagName("app-product-item");
    public static final By span = By.tagName("span");
    public static final By p = By.tagName("p");
    public static final By priceFromInput = By.xpath("//body/app-root[1]/app-main[1]/app-product-page[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/input[1]");
    public static final By priceUpToInput = By.xpath("//body/app-root[1]/app-main[1]/app-product-page[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/input[1]");
    public static final By saleCheckbox = By.xpath("//body/app-root[1]/app-main[1]/app-product-page[1]/div[1]/div[1]/div[1]/div[2]/div[2]/app-checkbox[1]/label[1]/span[1]");

}
