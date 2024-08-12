package testrunner;
import Utils.Utils;
import config.Setup;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchEmployee;
import java.io.IOException;
import java.util.List;


public class SearchEmpTestRunner extends Setup {
    @FindBy(className = "oxd-input-field-error-message")
    WebElement errorMessage;

    @FindBy(xpath = "oxd-text")
    List<WebElement> recordMessage;

    @Test(priority = 1, description = "Admin Login")
    public void login(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("admin", "admin123");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        Boolean isExit=  driver.findElement(By.className("oxd-userdropdown-img")).isDisplayed();
        Assert.assertTrue(isExit);


    }

    @Test(priority = 2, description = "Search User By User Name")
    public void searchUser() throws IOException, ParseException, InterruptedException {
        SearchEmployee search = new SearchEmployee(driver);
        JSONObject empObj = Utils.readUser();
        String firstName = empObj.get("firstName").toString();
        search.searchByUserName(firstName);
        Thread.sleep(2000);
        WebElement waiter = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div[1]/div/span"));
        String getMessage = waiter.getText();
        String message = "(1) Record Found";
        Thread.sleep(1000);
        Assert.assertTrue(getMessage.contains(message));

    }

}
