import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ppacheco on 2/17/17.
 */
public class ForgotPasswordPage extends HomePage{

    @FindBy(css = ".form h2")
    WebElement forgotPasswordTitle;
    @FindBy(name = "email")
    WebElement emailInput;
    @FindBy(name = "button")
    WebElement continueButton;
    @FindBy(className = "input_error")
    WebElement invalidEmailErrorMessage;
    @FindBy(css = "span[ng-show = 'errorMsg']")
    WebElement invalidUserErrorMessage;
    @FindBy(css = "span[ng-hide = 'recoverPassForm.$submitted && userExist']")
    WebElement disclaimerEnterEmailMessage;
    @FindBy(css = "span[ng-show = 'recoverPassForm.$submitted && userExist']")
    WebElement disclaimerPasswordResetMessage;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "https://featur-test.herokuapp.com/#/forgot-password";
    }

    public void fillEmail(String text) {
        setElementText(emailInput, text);
    }

    public String getForgotPasswordTitle() {
        explicitWaitFor(forgotPasswordTitle);
        return forgotPasswordTitle.getText();
    }

    public String getEnterEmailDisclaimerMessage(){
        explicitWaitFor(disclaimerEnterEmailMessage);
        return disclaimerEnterEmailMessage.getText();
    }

    public String getDisclaimerPasswordResetMessage(){
        explicitWaitFor(disclaimerPasswordResetMessage);
        return disclaimerPasswordResetMessage.getText();
    }

    public String getInvalidEmailErrorMessage() {
        explicitWaitFor(invalidEmailErrorMessage);
        return invalidEmailErrorMessage.getText();
    }

    public String getInvalidUserErrorMessage(){
        explicitWaitFor(invalidUserErrorMessage);
        return invalidUserErrorMessage.getText();
    }

    public void clickContinueButton() {
        safeClick(continueButton);
    }

    public void fillFormAndContinue(String text){
        setElementText(emailInput, text);
        clickContinueButton();
    }

}
