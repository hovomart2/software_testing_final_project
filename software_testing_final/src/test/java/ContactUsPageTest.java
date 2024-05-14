import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class ContactUsPageTest extends BaseTest{

    @Test
    public void invalidForm1(){
        //without message
        ContactUsPage contactUsPage = homePage.goToContactUsPage();
        contactUsPage.writeFullName("Lilit Lilityan");
        contactUsPage.writePhone("+37499999988");
        contactUsPage.writeEmail("lilit_lilityan@gmail.com");
        contactUsPage.submit();
        Assert.assertFalse(contactUsPage.isHappyPath());
    }

    @Test
    public void invalidForm2(){
        //full name less than 2 characters
        ContactUsPage contactUsPage = homePage.goToContactUsPage();
        contactUsPage.writeFullName("L");
        contactUsPage.writePhone("+37499999988");
        contactUsPage.writeEmail("lilit_lilityan@gmail.com");
        contactUsPage.writeMessage("Good job!!!!");
        contactUsPage.submit();
        Assert.assertFalse(contactUsPage.isHappyPath());
    }

    @Test
    public void invalidForm3(){
        //email with not valid input
        ContactUsPage contactUsPage = homePage.goToContactUsPage();
        contactUsPage.writeFullName("Lilit Lilityan");
        contactUsPage.writePhone("+37499999988");
        contactUsPage.writeEmail("lilit_lilityan");
        contactUsPage.writeMessage("Good job!!!!");
        contactUsPage.submit();
        Assert.assertFalse(contactUsPage.isHappyPath());
    }

    @Test
    public void invalidForm4(){
        //phone containing not 12 characters
        ContactUsPage contactUsPage = homePage.goToContactUsPage();
        contactUsPage.writeFullName("Lilit Lilityan");
        contactUsPage.writePhone("+379988");
        contactUsPage.writeEmail("lilit_lilityan@gmail.com");
        contactUsPage.writeMessage("Good job!!!!");
        contactUsPage.submit();
        Assert.assertFalse(contactUsPage.isHappyPath());
    }

    @Test
    public void invalidForm5(){
        //message less than 2 characters
        ContactUsPage contactUsPage = homePage.goToContactUsPage();
        contactUsPage.writeFullName("Lilit Lilityan");
        contactUsPage.writePhone("+3799999988");
        contactUsPage.writeEmail("lilit_lilityan@gmail.com");
        contactUsPage.writeMessage("!");
        contactUsPage.submit();
        Assert.assertFalse(contactUsPage.isHappyPath());
    }

    @Test
    public void validForm(){
        //message less than 2 characters
        ContactUsPage contactUsPage = homePage.goToContactUsPage();
        contactUsPage.writeFullName("Lilit Lilityan");
        contactUsPage.writePhone("+37499999988");
        contactUsPage.writeEmail("lilit_lilityan@gmail.com");
        contactUsPage.writeMessage("Good Job!!!");
        Assert.assertTrue(contactUsPage.isHappyPath());
    }

}
