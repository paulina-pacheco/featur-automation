import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by ppacheco on 2/15/17.
 */
public class HomePage extends BasePage{

    //TODO this needs refactor because we are extending this class, name class should be something like "headerAndFooterPage" or something similar

    @FindBy(className = "logo") WebElement logo;
    @FindBy(css = ".homepage__hero-boxes--blue h1") WebElement heroFirstTitle;
    @FindBy(id = "home") WebElement homeLink;
    @FindBy(id = "how-it-works") WebElement howItWorksLink;
    @FindBy(id = "login") WebElement loginLink;
    @FindBy(id = "signup") WebElement signUpLink;
    @FindBy(css = ".homepage__hero-boxes .button") WebElement tryFeaturFreeButtonTop;
    @FindBy(css = ".tryit .button") WebElement tryFeaturFreeButtonBottom;
    @FindBy(partialLinkText = "hello@featur.me") WebElement featurMailTo;
    @FindBy(css = "ftr-tos a") WebElement featurTOSLink;
    @FindBy(css = ".modal .close") WebElement closeModalButton;

    @FindBy(className = "modal")
    @CacheLookup
    WebElement modalSpace;

    @FindBy(css = ".tos_container h1") WebElement tosTitle;


    public HomePage(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "FeatUR | Analysis setup : Beta";
        this.PAGE_URL =  "https://featur-test.herokuapp.com/#/homepage";
    }

    public HomePage goToHomepageWithLink (){
        safeClick(homeLink);
        return new HomePage(driver);
    }

    public HomePage goToHomepageWithLogo (){
        safeClick(logo);
        return new HomePage(driver);
    }

    public LoginPage goToLoginPage(){
        safeClick(loginLink);
        return new LoginPage(driver);
    }

    public SignUpPage goToSignUpPage(){
        safeClick(signUpLink);
        return new SignUpPage(driver);
    }

    public SignUpPage goToSignUpUsingTopButton(){
        safeClick(tryFeaturFreeButtonTop);
        return new SignUpPage(driver);
    }

    public SignUpPage goToSignUpUsingBottom(){
        safeClick(tryFeaturFreeButtonBottom);
        return new SignUpPage(driver);
    }

    public void openTOS(){
        safeClick(featurTOSLink);
    }

    public String  getTOSTitle() {
        return tosTitle.getText();
    }

    public void closeTOSWithButton(){
        safeClick(closeModalButton);
    }

    public void closeTOSClickingOutside(){
        safeClick(modalSpace);
    }

    public String getHeroFirstTitle(){
        return heroFirstTitle.getText();
    }


}
