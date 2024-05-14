import com.sun.source.tree.AssertTree;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchResultsPage;

import java.util.List;

public class SearchResultsPageTest extends BaseTest {


    @Test
    public void checkSearchWord(){
        SearchResultsPage searchResultsPage = homePage.search("Ռոբոտ");
        searchResultsPage.setProductItems();
        searchResultsPage.getItemNames();
        Assert.assertTrue(searchResultsPage.isKeywordInAllItemNames());
    }

    @Test
    public void checkPriceRange(){
        SearchResultsPage searchResultsPage = homePage.search("չիպս");
        String from = "300";
        String upTo = "1000";
        searchResultsPage.writePriceFromInput(from);
        searchResultsPage.writePriceUpToInput(upTo);
        searchResultsPage.scrollUp()
        searchResultsPage.clickOnSaleCheckbox();// for applying changes, as there was no submit button
        searchResultsPage.clickOnSaleCheckbox();
        searchResultsPage.setProductItems();
        Assert.assertTrue(searchResultsPage.isInRange(from, upTo));
    }

    @Test
    public void checkLowestToHighest(){
        SearchResultsPage searchResultsPage = (SearchResultsPage) homePage.search("gini");
        searchResultsPage.clickOnDropdown();
        searchResultsPage.clickOnPriceLowestToHighest();
        List<Integer> prices = searchResultsPage.getItemsPrices();
        Assert.assertTrue(searchResultsPage.checkLowestToHighest(prices));
    }

    @Test
    public void checkHighestToLowest(){
        SearchResultsPage searchResultsPage = (SearchResultsPage) homePage.search("gini");
        searchResultsPage.clickOnDropdown();
        searchResultsPage.clickOnPriceHighestToLowest();
        List<Integer> prices = searchResultsPage.getItemsPrices();
        Assert.assertTrue(searchResultsPage.checkHighestToLowest(prices));
    }
}
