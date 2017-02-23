import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by ppacheco on 2/15/17.
 */
public class HomePageTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();
    HomePage homePage;


    @BeforeMethod
    public void goToHomePage(){
        homePage = new HomePage(driver);
        driver.get(homePage.PAGE_URL);
    }


    @Test
    public void verifiesHomePage(){
        String heroFirstTitle = "We help you\n" + "decide what features to build first!";
        softAssert.assertEquals(driver.getTitle(), homePage.getPAGE_TITLE());
        assertThat(homePage.getHeroFirstTitle(), is(heroFirstTitle));
    }

    @Test
    public void openTOS(){
        String tosTitle = "FeatUr Client Terms and Conditions";
        homePage.openTOS();
        assertThat(homePage.modalSpace.isDisplayed(), is(true));
        assertThat(homePage.getTOSTitle(), is(tosTitle));
    }

    @Test
    public void closeTOSWithButton(){
        homePage.openTOS();
        assertThat(homePage.modalSpace.isDisplayed(), is(true));
        homePage.closeTOSWithButton();

        //TODO find how to avoid stale element caused by element not attached to DOM anymore
//        assertThat(homePage.modalSpace.isDisplayed(), is(false));
    }

    @Test
    public void goToLoginPage(){
        LoginPage loginPage = homePage.goToLoginPage();
        String loginPageTitle = "Login";
        assertThat(loginPage.getLoginTitle(), is(loginPageTitle));
    }

    @Test
    public void goToSignUpPage () {
        SignUpPage signUpPage = homePage.goToSignUpPage();
        String signUpPageTitle = "Sign up";
        assertThat(signUpPage.getSignUpTitle(), is(signUpPageTitle));
    }

    @Test
    public void goToSignUpPageUsingButtonInHero(){
        SignUpPage signUpPage = homePage.goToSignUpUsingTopButton();
        String signUpPageTitle = "Sign up";
        assertThat(signUpPage.getSignUpTitle(), is(signUpPageTitle));
    }

    @Test
    public void goToSignUpPageUsingButtonInTryit (){
        SignUpPage signUpPage = homePage.goToSignUpUsingBottom();
        String signUpPageTitle = "Sign up";
        assertThat(signUpPage.getSignUpTitle(), is(signUpPageTitle));
    }

    @Test
    public void verifyMailToLink() {
        String mailToString = "mailto:hello@featur.me";
        assertThat(homePage.featurMailTo.getAttribute("href"), is(mailToString));
    }


}
