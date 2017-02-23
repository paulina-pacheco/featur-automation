import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by ppacheco on 2/22/17.
 */
public class firstautomation extends BaseTest{

    GooglePage page;

    @BeforeMethod
    public void goToGoogle () {
        page = new GooglePage(driver);
        driver.get("http://www.google.com");
    }

    @Test
    public void firstTest(){
//        driver.get("https://www.google.com.mx/");
//        driver.findElement(By.id("lst-ib")).sendKeys("mitchiri mitchiri");
//        driver.findElement(By.name("btnG")).click();

        page.setInputAndSearch("mitchiri mitchiri");

    }

}
