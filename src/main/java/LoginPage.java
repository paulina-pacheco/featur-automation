import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ppacheco on 2/15/17.
 */
public class LoginPage extends HomePage {

    @FindBy(css = ".form h2")
    WebElement loginTitle;
    @FindBy(name = "email")
    WebElement emailInput;
    @FindBy(name = "password")
    WebElement passwordInput;
    @FindBy(id = "remember")
    WebElement rememberCheckbox;
    @FindBy(css = "button[type = 'submit']")
    WebElement loginButton;
    @FindBy(partialLinkText = "Forgot your password?")
    WebElement forgotPasswordLink;
    @FindBy(className = "input_error")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "https://featur-test.herokuapp.com/#/login";
        this.PAGE_TITLE = "FeatUR | Analysis setup : Beta";
    }

    public String getLoginTitle() {
        return loginTitle.getText();
    }

    public void fillEmail(String text) {
        setElementText(emailInput, text);
    }

    public void fillPassword(String text) {
        setElementText(passwordInput, text);
    }

    public void checkRemember() {
        if (!rememberCheckbox.isSelected()) {
            rememberCheckbox.click();
        }
    }

    public void uncheckRemember() {
        if (rememberCheckbox.isEnabled()) {
            rememberCheckbox.click();
        }
    }

    public Dashboard clickLoginButton(){
        safeClick(loginButton);
        return new Dashboard(driver);
    }

    public String getErrorMessage(){
        explicitWaitFor(errorMessage);
        return errorMessage.getText();
    }

    public void fillLoginForm(String email, String password){
        fillEmail(email);
        fillPassword(password);
    }

    public void fillLoginFormAndRemember(String email, String password) {
        fillLoginForm(email, password);
        checkRemember();
    }

    public ForgotPasswordPage goToForgotPasswordPage() {
        safeClick(forgotPasswordLink);
        return new ForgotPasswordPage(driver);
    }

    @Override
    public LoginPage goToLoginPage(){
        safeClick(signUpLink);
        return this;
    }
}

