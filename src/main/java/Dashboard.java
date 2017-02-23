import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ppacheco on 2/15/17.
 */
public class Dashboard extends BasePage{

    @FindBy(className = "username")
    WebElement userName;

    @FindBy(css = ".welcome-message a")
    WebElement userEmail;

    @FindBy(css = ".welcome-message")
    WebElement welcomeMessage;

    @FindBy(css = ".header__user-logout a")
    WebElement logOutLink;


    public Dashboard(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "FeatUR | Analysis setup : Beta";
        this.PAGE_URL = "https://featur-test.herokuapp.com/#/dashboard";
    }

    public String getUserName () {
        return userName.getText();
    }

    public String getUserEmail (){
        String email = userEmail.getText();
        return email.substring(0, email.length()-1);
    }

    public HomePage logOut() {
        safeClick(logOutLink);
        return new HomePage(driver);
    }


}
