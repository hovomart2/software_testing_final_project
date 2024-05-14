import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CareerPage;
import pages.CareersPage;

public class CareerPageTest extends BaseTest{

    @Test
    public void invalidForm1(){
        CareersPage careersPage = homePage.goToCareersPage();
        CareerPage careerPage = careersPage.clickOnFirstCategory();
        careerPage.writeName("Anush");
        careerPage.writeLastname("Arakelyan");
        careerPage.writePhone("099999999");
        careerPage.writeEmail("anush_arakelyan");
        careerPage.writeMessage("es uzum em ashxatel");
        careerPage.clickApply();
        Assert.assertFalse(careerPage.isHappyPath());
    }

    @Test
    public void invalidForm2(){
        CareersPage careersPage = homePage.goToCareersPage();
        CareerPage careerPage = careersPage.clickOnFirstCategory();
        careerPage.writeName("Anush");
        careerPage.writeLastname("Arakelyan");
        careerPage.writeEmail("anush_arakelyan@gmail.com");
        careerPage.writeMessage("es uzum em ashxatel");
        careerPage.clickApply();
        Assert.assertFalse(careerPage.isHappyPath());
    }

    @Test
    public void validForm(){
        CareersPage careersPage = homePage.goToCareersPage();
        CareerPage careerPage = careersPage.clickOnFirstCategory();
        careerPage.writeName("Anush");
        careerPage.writeLastname("Arakelyan");
        careerPage.writePhone("099999999");
        careerPage.writeEmail("anush_arakelyan@gmail.com");
        careerPage.writeMessage("es uzum em ashxatel");
        Assert.assertTrue(careerPage.isHappyPath());
    }

}
