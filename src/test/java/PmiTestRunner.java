import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;
import java.time.Duration;
import java.util.List;

public class PmiTestRunner extends Setup {

    @BeforeTest
    public void doLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("admin", "admin123");
    }
    @Test
    public void createUser() throws InterruptedException {
        PIMPage pmipage = new PIMPage(driver);


        pmipage.createUser("rajaufla", "isldamsaa", "rajaul-isfdslamaa", "rajaul123", "rajaul123");
        WebElement headerElement = driver.findElement(By.xpath("//h6[text()=\"Personal Details\"]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf((WebElement) headerElement));
        String gotTest = headerElement.getText();
        Assert.assertTrue(gotTest.contains("Personal Details"));

    }
}
