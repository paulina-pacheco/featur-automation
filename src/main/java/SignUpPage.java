import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ppacheco on 2/15/17.
 */
public class SignUpPage extends BasePage{

    @FindBy(css = ".form h2") WebElement signUpTitle;
    @FindBy(name = "name") WebElement nameInput;
    @FindBy (name = "email") WebElement emailInput;
    @FindBy (name = "password") WebElement passwordInput;
    @FindBy (name = "confirmpsw") WebElement confirmPasswordInput;
    @FindBy (css = "button[type = 'submit']") WebElement signUpButton;
    @FindBy (css = ".ftrModal ftr-tos a") WebElement tosLinkInForm;


    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public String getSignUpTitle() {
        return signUpTitle.getText();
    }





}
