import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by ppacheco on 2/15/17.
 */
public class LogInTest extends BaseTest {

    LoginPage loginPage;


    @BeforeMethod
    public void goToLoginPage(){
        loginPage = new LoginPage(driver);
        driver.get(loginPage.PAGE_URL);
    }

    @Test
    public void tryToLoginWithoutFillingForm(){
        loginPage.clickLoginButton();
        String emptyEmailPlaceholder = "Email is required";
        String emptyPasswordPlaceholder = "A password is required";

        assertThat(loginPage.emailInput.getAttribute("placeholder"), is(emptyEmailPlaceholder));
        assertThat(loginPage.passwordInput.getAttribute("placeholder"), is(emptyPasswordPlaceholder));
    }

    @Test
    public void loginWithInvalidCredentials(){
        loginPage.fillEmail("ppacheco@nearsoft.com");
        loginPage.fillPassword("12345");
        loginPage.clickLoginButton();

        String errorMessage = "Wrong user/password combination.";

        assertThat(loginPage.getErrorMessage(), is(errorMessage));
    }

    @Test
    public void loginWithNonExistingUser () {
        loginPage.fillEmail("mail@domain.com");
        loginPage.fillPassword("12345");
        loginPage.clickLoginButton();

        String errorMessage = "User Not Found";

        assertThat(loginPage.getErrorMessage(), is(errorMessage));
    }

    @Test
    public void loginWithValidCredentials () {
        loginPage.fillLoginForm("ppacheco@nearsoft.com", "holahola");
        Dashboard dashboard = loginPage.clickLoginButton();
        String userName = "paulina";

        assertThat(dashboard.getUserName(), is(userName));
    }

    //TODO this test sometimes fails, sometimes passes... if you debug it, always passes
    @Test
    public void logout() {
        loginPage.fillLoginForm("ppacheco@nearsoft.com", "holahola");
        Dashboard dashboard = loginPage.clickLoginButton();
        assertThat(dashboard.getUserName(), is("paulina"));
        HomePage homePage = dashboard.logOut();

        assertThat(homePage.getHeroFirstTitle(), is("We help you\n" +
                "decide what features to build first!"));

    }

    //TODO needs refactor, when you initialize the driver it uses a new user session
    //also, remember checkbox does not have any functionality attached to it
    @Test(enabled = false)
    public void loginAndRemember(){
        loginPage.fillLoginFormAndRemember("ppacheco@nearsoft.com", "holahola");
        Dashboard dashboard = loginPage.clickLoginButton();
        assertThat(dashboard.getUserName(), is("paulina"));
        driver.close();
        driver = new ChromeDriver();
        goToLoginPage();
        assertThat(dashboard.getUserName(), is("paulina"));

    }

    //TODO related to previous test
    @Test(enabled = false)
    public void loginAndRememberWithoutRemember(){

    }

    @Test()
    public void goToForgotPasswordPageFromLogin(){
        ForgotPasswordPage forgotPasswordPage = loginPage.goToForgotPasswordPage();
        assertThat(forgotPasswordPage.getEnterEmailDisclaimerMessage(), is("Enter your email to recover your account."));
    }


}
