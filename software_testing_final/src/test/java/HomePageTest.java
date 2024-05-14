import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    @Test
    public  void validOneWordSearch(){
        homePage.search("gini");

//        SearchResultsPage results = homePage.goSearchResultsPage("wine");
//        SoftAssert sa = new SoftAssert();
//        sa.assertAll();

    }
}
