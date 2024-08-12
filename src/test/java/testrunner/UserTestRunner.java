package testrunner;

import Utils.Utils;
import config.Setup;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserInfoUpdate;

import java.io.IOException;

public class UserTestRunner extends Setup {
    @Test(priority = 1, description = "employee can not login with wrong cred")
    public void loginWithWrongCreds() throws IOException, ParseException {
       JSONObject user =  Utils.readUser();
       String userName = (String) user.get("userName");
       String password = (String) user.get("password");


        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(userName, password);
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        Boolean isExit=  driver.findElement(By.className("oxd-userdropdown-img")).isDisplayed();
        Assert.assertTrue(isExit);


    }

    @Test(priority = 2)
    public void userContactOtherInfoUpdate () throws InterruptedException {
        UserInfoUpdate adminPage = new UserInfoUpdate(driver);
        Thread.sleep(3000);
        adminPage.userContactOtherInfoUpdate(driver);


    }

    @Test(priority = 3, description = "Update User info")
    public void updateUsername () throws InterruptedException, IOException, ParseException {
        UserInfoUpdate adminPage = new UserInfoUpdate(driver);
        adminPage.updateUsername();
        Thread.sleep(5000);
        String titleActual = driver.findElement(By.className("oxd-table-filter-title")).getText();

        String titleExpected = "System Users";

        Assert.assertEquals(titleActual, titleExpected);
        Thread.sleep(3000);


    }
}
