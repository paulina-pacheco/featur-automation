import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

/**
 * Created by ppacheco on 2/15/17.
 */
public class BasePage {

    public WebDriver driver;
    public String BASE_URL = "https://featur-test.herokuapp.com/";
    public String PAGE_URL;
    public String PAGE_TITLE;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loadPage(){
        driver.get(getPAGE_URL());

    }

    public String getPAGE_URL() {
        return PAGE_URL;
    }

    public void setElementText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void safeClick(WebElement element){
        if(element.isDisplayed()){
            element.click();
        } else {
            Reporter.log("Element not availble on page - " + getDriver().getCurrentUrl());

        }
    }

    public void setPAGE_URL(String PAGE_URL) {
        this.PAGE_URL = PAGE_URL;
    }

    public String getPAGE_TITLE() {
        return PAGE_TITLE;
    }

    public void setPAGE_TITLE(String PAGE_TITLE) {
        this.PAGE_TITLE = PAGE_TITLE;
    }
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void explicitWaitFor(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
