import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by ppacheco on 2/17/17.
 */
public class ForgotPasswordPageTest extends BaseTest {
    ForgotPasswordPage forgotPasswordPage;

    @BeforeMethod
    public void goToForgotPasswordPage(){
        forgotPasswordPage = new ForgotPasswordPage(driver);
        driver.get(forgotPasswordPage.getPAGE_URL());
    }

    @Test
    public void doNotFillEmailInputAndContinue(){
        forgotPasswordPage.clickContinueButton();
        assertThat(forgotPasswordPage.getInvalidEmailErrorMessage(), is("Email is required"));
    }

    @Test
    public void enterInvalidUserEmailAndContinue(){
        String invalidUserEmail = "1234@test.com";
        forgotPasswordPage.fillEmail(invalidUserEmail);
        forgotPasswordPage.clickContinueButton();
        assertThat(forgotPasswordPage.getInvalidUserErrorMessage(), is(invalidUserEmail+" is not a valid user."));

    }

    @Test
    public void enterValidUserAndContinue(){
        String validUser = "ppacheco@nearsoft.com";
        forgotPasswordPage.fillFormAndContinue(validUser);
        assertThat(forgotPasswordPage.getDisclaimerPasswordResetMessage(), is("Your password reset request is being processed, please check your registered email inbox."));
    }

}
