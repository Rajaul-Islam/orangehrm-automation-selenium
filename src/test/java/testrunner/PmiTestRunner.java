package testrunner;

import Utils.Utils;
import com.github.javafaker.Faker;
import config.EmployeeModel;
import config.Setup;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PIMPage;

import java.io.IOException;
import java.time.Duration;

public class PmiTestRunner extends Setup {

    @BeforeTest
    public void doLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("admin", "admin123");
    }
    @Test
    public void createUser() throws InterruptedException, IOException, ParseException {
        PIMPage pmipage = new PIMPage(driver);

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userName = faker.name().username();
        String password = "Ppassw@rd123";



        pmipage.createUser(firstName, lastName, userName, password, password);
        WebElement headerElement = driver.findElement(By.xpath("//h6[text()=\"Personal Details\"]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf((WebElement) headerElement));
        String gotTest = headerElement.getText();
        Assert.assertTrue(gotTest.contains("Personal Details"));

        EmployeeModel model = new EmployeeModel();
        model.setFirstName(firstName);
        model.setLastName(lastName);
        model.setUserName(userName);
        model.setPassword(password);

        Utils.saveUser(model);

    }
}
