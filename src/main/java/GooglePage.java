import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ppacheco on 2/22/17.
 */
public class GooglePage extends BasePage{


    WebElement searchInput = driver.findElement(By.id("lst-ib"));
    WebElement searchButton = driver.findElement(By.name("btnG"));

    public GooglePage(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "Google";
        this.PAGE_URL = "https://www.google.com.mx/";
    }

    public void setInputText (String text) {
        searchInput.sendKeys(text);
    }

    public void clickSearchButton () {
        searchButton.click();
    }

    public void setInputAndSearch (String text){
        setInputText(text);
        searchButton.click();
    }

}
